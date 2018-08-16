package com.mgrsys.authorization.oauthmodule

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


/**
 * Developed by Magora Team (magora-systems.com). 2018.
 *
 * @author mihaylov
 */
abstract class BaseTokenAuthenticator(private val tokensHolder: TokensHolder) : Authenticator {

    protected fun buildRequest(requestBuilder: Request.Builder): Request {
        return requestBuilder.header(Config.AUTH_HEADER, tokensHolder.accessToken).build()
    }

    protected fun isTokenRotten(storedToken: String, rottenToken: String?): Boolean? {
        return storedToken == rottenToken
    }

    @Synchronized
    override fun authenticate(route: Route, response: Response): Request? {
        val storedToken = tokensHolder.accessToken
        val rottenToken = response.request().header(Config.AUTH_HEADER)

        val requestBuilder = response.request().newBuilder()

        if (isTokenRotten(storedToken, rottenToken)!!) {
            refreshTokenRequest(tokensHolder)
        }

        return buildRequest(requestBuilder)
    }


    internal abstract fun refreshTokenRequest(tokensHolder: TokensHolder)
}

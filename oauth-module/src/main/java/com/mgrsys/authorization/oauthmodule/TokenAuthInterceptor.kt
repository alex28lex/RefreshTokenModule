package com.mgrsys.authorization.oauthmodule

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Developed by Magora Team (magora-systems.com). 2018 .
 *
 * @author mihaylov
 */
class TokenAuthInterceptor(private val tokensHolder: TokensHolder) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        val requestBuilder = chain.request().newBuilder()

        if (chain.request().header(Config.AUTH_HEADER) == null) {
            requestBuilder.addHeader(Config.AUTH_HEADER, tokensHolder.accessToken)
        }

        return chain.proceed(requestBuilder.build())
    }
}

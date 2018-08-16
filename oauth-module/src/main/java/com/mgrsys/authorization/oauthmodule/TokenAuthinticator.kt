package com.mgrsys.authorization.oauthmodule

import io.reactivex.Flowable

/**
 * Developed by Magora Team (magora-systems.com). 2018 .
 *
 * @author mihaylov
 */
class TokenAuthinticator(tokensHolder: TokensHolder,
                         var refreshTokenRequest: Flowable<TokensHolder>) : BaseTokenAuthenticator(tokensHolder) {

    override fun refreshTokenRequest(tokensHolder: TokensHolder) {
        val newTokens = refreshTokenRequest.blockingFirst()
        tokensHolder.accessToken = newTokens.accessToken
        tokensHolder.refreshToken = newTokens.refreshToken
    }
}

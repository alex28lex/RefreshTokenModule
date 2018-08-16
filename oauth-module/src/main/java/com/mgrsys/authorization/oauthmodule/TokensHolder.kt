package com.mgrsys.authorization.oauthmodule

/**
 * Developed by Magora Team (magora-systems.com). 2018 .
 *
 * @author mihaylov
 */
interface TokensHolder {
    var accessToken: String
    var refreshToken: String
}
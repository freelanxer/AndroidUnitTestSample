package com.freelanxer.androidunittestsample

import java.util.Locale

class RegisterVerify {

    fun isLoginIdVerify(loginId: String): Boolean {
        var isLoginIdOK = false
        //帳號至少6碼，第1碼為英文，j
        if (loginId.length >= 6) {
            if (loginId.uppercase(Locale.getDefault()).first() in 'A'..'Z') {
                isLoginIdOK = true
            }
        }
        return isLoginIdOK
    }
}
package org.me.cloudalert_test

import android.app.Application

class GlobalVariable : Application(){
    companion object{
        private var appKey: String = ""
        private var androidID: String = ""
        private var phoneModel: String = ""

        fun getAppKey(): String {
            return appKey
        }

    }
}
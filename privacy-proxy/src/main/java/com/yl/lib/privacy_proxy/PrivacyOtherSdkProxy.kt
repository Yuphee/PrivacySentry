package com.yl.lib.privacy_proxy

import androidx.annotation.Keep
import com.bun.miitmdid.provider.DefaultProvider
import com.yl.lib.privacy_annotation.MethodInvokeOpcode
import com.yl.lib.privacy_annotation.PrivacyClassProxy
import com.yl.lib.privacy_annotation.PrivacyMethodProxy
import com.yl.lib.sentry.hook.util.PrivacyUtil

@Keep
open class PrivacyOtherSdkProxy {

    @Keep
    @PrivacyClassProxy
    object OtherSdkProxy {

        @PrivacyMethodProxy(
            originalClass = DefaultProvider::class,
            originalMethod = "getOAID",
            originalOpcode = MethodInvokeOpcode.INVOKEVIRTUAL
        )
        @JvmStatic
        fun getOAID(manager: DefaultProvider): String? {
            var key = "oaid"
            PrivacyUtil.Util.getStackTrace()
            return manager.OAID
        }
    }

}
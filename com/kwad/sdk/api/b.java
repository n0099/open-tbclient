package com.kwad.sdk.api;

import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.Loader;
/* loaded from: classes7.dex */
public final class b {
    public static Object a(String str, Object... objArr) {
        try {
            IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
            if (ksAdSDKImpl != null) {
                return ksAdSDKImpl.dM(str, objArr);
            }
            RuntimeException runtimeException = new RuntimeException("sdk is null");
            runtimeException.printStackTrace();
            throw new RuntimeException(runtimeException);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}

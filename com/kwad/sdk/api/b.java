package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.Loader;
/* loaded from: classes5.dex */
public final class b {
    @Nullable
    public static <T> T a(String str, Object... objArr) {
        try {
            IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
            if (ksAdSDKImpl != null) {
                return (T) ksAdSDKImpl.dM(str, objArr);
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

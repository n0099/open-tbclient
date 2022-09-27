package com.kwad.components.ad.interstitial.monitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.b.a;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.utils.o;
import java.io.File;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) {
            String A = com.kwad.sdk.core.response.a.a.A(d.bQ(adTemplate));
            if (TextUtils.isEmpty(A)) {
                return false;
            }
            int sc = com.kwad.sdk.core.config.d.sc();
            String str = "";
            if (sc < 0) {
                File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A);
                if (!o.I(ad)) {
                    c.a aVar = new c.a();
                    boolean a = com.kwad.sdk.core.diskcache.a.a.sS().a(A, aVar);
                    str = aVar.Qd;
                    r5 = a;
                }
                adTemplate.mDownloadSize = ad != null ? ad.length() : 0L;
                i = 2;
            } else if (sc <= 0) {
                adTemplate.mDownloadSize = 0L;
                adTemplate.mDownloadType = 1;
                if (!r5) {
                    b.cr().a(adTemplate, str);
                }
                return r5;
            } else {
                a.C0612a c0612a = new a.C0612a();
                f bC = com.kwad.sdk.core.videocache.b.a.bC(KsAdSDKImpl.get().getContext());
                r5 = bC.cC(A) ? true : bC.a(A, sc * 1024, c0612a);
                str = c0612a.Qd;
                adTemplate.mDownloadSize = sc * 1024;
                i = 3;
            }
            adTemplate.mDownloadType = i;
            if (!r5) {
            }
            return r5;
        }
        return invokeL.booleanValue;
    }
}

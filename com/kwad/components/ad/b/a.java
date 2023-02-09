package com.kwad.components.ad.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.components.core.video.f;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.b.a;
import com.kwad.sdk.utils.o;
import java.io.File;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return false;
            }
            return d.sc() <= 0 ? f.h(adTemplate) : com.kwad.sdk.core.videocache.b.a.bC(KsAdSDKImpl.get().getContext()).cC(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(@NonNull AdTemplate adTemplate, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, adTemplate, z)) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            boolean z2 = true;
            if (z && com.kwad.sdk.core.response.a.a.bk(bQ)) {
                return true;
            }
            String A = com.kwad.sdk.core.response.a.a.A(bQ);
            if (TextUtils.isEmpty(A)) {
                return false;
            }
            int sc = d.sc();
            String str = "";
            if (sc < 0) {
                File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A);
                if (!o.I(ad)) {
                    c.a aVar = new c.a();
                    boolean a = com.kwad.sdk.core.diskcache.a.a.sS().a(A, aVar);
                    str = aVar.Qd;
                    z2 = a;
                }
                r4 = ad != null ? ad.length() : 0L;
                adTemplate.mDownloadType = 2;
            } else if (sc > 0) {
                a.C0640a c0640a = new a.C0640a();
                int i = sc * 1024;
                boolean a2 = com.kwad.sdk.core.videocache.b.a.bC(KsAdSDKImpl.get().getContext()).a(A, i, c0640a);
                str = c0640a.Qd;
                adTemplate.mDownloadType = 3;
                adTemplate.mDownloadSize = i;
                z2 = a2;
                if (!z2) {
                    com.kwad.components.ad.reward.monitor.a.a(z, adTemplate, str);
                }
                return z2;
            } else {
                adTemplate.mDownloadType = 1;
            }
            adTemplate.mDownloadSize = r4;
            if (!z2) {
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }
}

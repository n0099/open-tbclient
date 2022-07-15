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
/* loaded from: classes5.dex */
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
            return d.J() <= 0 ? f.a(adTemplate) : com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).b(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.i(adTemplate)));
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
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            boolean z2 = true;
            if (z && com.kwad.sdk.core.response.a.a.aB(i)) {
                return true;
            }
            String b = com.kwad.sdk.core.response.a.a.b(i);
            if (TextUtils.isEmpty(b)) {
                return false;
            }
            int J = d.J();
            String str = "";
            if (J < 0) {
                File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(b);
                if (!o.a(b2)) {
                    c.a aVar = new c.a();
                    boolean a = com.kwad.sdk.core.diskcache.a.a.a().a(b, aVar);
                    str = aVar.a;
                    z2 = a;
                }
                r4 = b2 != null ? b2.length() : 0L;
                adTemplate.mDownloadType = 2;
            } else if (J > 0) {
                a.C0548a c0548a = new a.C0548a();
                int i2 = J * 1024;
                boolean a2 = com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).a(b, i2);
                str = c0548a.a;
                adTemplate.mDownloadType = 3;
                adTemplate.mDownloadSize = i2;
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

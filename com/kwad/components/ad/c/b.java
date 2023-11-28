package com.kwad.components.ad.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.core.video.j;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.q;
import java.io.File;
/* loaded from: classes10.dex */
public final class b {
    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.V();
    }

    public static void a(a aVar, String str) {
        if (aVar == null) {
            return;
        }
        aVar.W();
    }

    @WorkerThread
    public static boolean a(@NonNull AdTemplate adTemplate, boolean z, final AdVideoPreCacheConfig adVideoPreCacheConfig, final a aVar) {
        long j;
        String K = com.kwad.sdk.core.response.b.a.K(e.dP(adTemplate));
        if (TextUtils.isEmpty(K)) {
            return false;
        }
        final long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        String str = "";
        long j2 = 0;
        boolean z2 = true;
        int i = (adVideoPreCacheSize > 0L ? 1 : (adVideoPreCacheSize == 0L ? 0 : -1));
        if (i > 0) {
            if (adVideoPreCacheConfig.isContinueLoadingAll()) {
                j = -1;
            } else {
                j = adVideoPreCacheSize;
            }
            a.C0709a c0709a = new a.C0709a();
            f bl = com.kwad.sdk.core.videocache.c.a.bl(KsAdSDKImpl.get().getContext());
            if (bl.eg(K)) {
                a(aVar);
            } else {
                z2 = bl.a(K, j, c0709a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.c.b.1
                    public boolean bF = false;

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseEnd() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseStart() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j3, long j4) {
                        if ((j3 >= adVideoPreCacheSize || j3 >= j4) && !this.bF) {
                            this.bF = true;
                            b.a(aVar);
                            if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                                return true;
                            }
                        }
                        return false;
                    }
                });
            }
            str = c0709a.msg;
        } else if (i < 0) {
            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(K);
            if (!q.L(bO)) {
                a.C0709a c0709a2 = new a.C0709a();
                z2 = com.kwad.sdk.core.diskcache.b.a.BS().a(K, c0709a2);
                str = c0709a2.msg;
            }
            if (bO != null) {
                j2 = bO.length();
            }
            adTemplate.setDownloadSize(j2);
            if (z2) {
                a(aVar);
            }
        } else {
            a(aVar);
        }
        if (z2) {
            j.n(K, adVideoPreCacheConfig.getAdVideoPreCacheSize());
        } else {
            c.a(z, adTemplate, str);
            com.kwad.components.ad.reward.monitor.b.a(z, adTemplate);
            a(aVar, str);
        }
        return z2;
    }
}

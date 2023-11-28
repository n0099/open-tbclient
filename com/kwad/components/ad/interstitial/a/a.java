package com.kwad.components.ad.interstitial.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.interstitial.report.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.q;
import java.io.File;
/* loaded from: classes10.dex */
public final class a {
    public static boolean j(@NonNull AdTemplate adTemplate) {
        boolean z;
        f bl;
        String K = com.kwad.sdk.core.response.b.a.K(e.dP(adTemplate));
        if (TextUtils.isEmpty(K)) {
            b.dO().b(adTemplate, "empty videoUrl");
            return false;
        }
        b.dO().o(adTemplate);
        int yE = d.yE();
        String str = "";
        long j = 0;
        if (yE < 0) {
            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(K);
            if (q.L(bO)) {
                z = true;
            } else {
                a.C0709a c0709a = new a.C0709a();
                z = com.kwad.sdk.core.diskcache.b.a.BS().a(K, c0709a);
                str = c0709a.msg;
            }
            if (bO != null) {
                j = bO.length();
            }
            adTemplate.setDownloadSize(j);
            adTemplate.setDownloadType(2);
        } else if (yE > 0) {
            a.C0709a c0709a2 = new a.C0709a();
            if (d.Bu() == 1) {
                bl = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 0);
            } else if (d.Bu() == 2) {
                bl = com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 1);
            } else {
                bl = com.kwad.sdk.core.videocache.c.a.bl(ServiceProvider.getContext());
            }
            if (!bl.eh(K)) {
                z = bl.a(K, yE * 1024, c0709a2, null);
            } else {
                z = true;
            }
            str = c0709a2.msg;
            adTemplate.setDownloadSize(yE * 1024);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            z = true;
        }
        if (!z) {
            adTemplate.setDownloadStatus(2);
            b.dO().b(adTemplate, str);
            com.kwad.components.ad.interstitial.report.realtime.a.dU();
            com.kwad.components.ad.interstitial.report.realtime.a.b(str, adTemplate);
        } else {
            adTemplate.setDownloadStatus(1);
        }
        return z;
    }
}

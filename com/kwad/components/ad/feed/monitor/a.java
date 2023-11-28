package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.utils.q;
import java.io.File;
/* loaded from: classes10.dex */
public final class a {
    public static Pair<Integer, String> d(@NonNull AdTemplate adTemplate) {
        String K = com.kwad.sdk.core.response.b.a.K(e.dP(adTemplate));
        int i = 2;
        if (TextUtils.isEmpty(K)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int yE = d.yE();
        String str = "";
        long j = 0;
        int i2 = 1;
        if (yE < 0) {
            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(K);
            if (!q.L(bO)) {
                a.C0709a c0709a = new a.C0709a();
                if (com.kwad.sdk.core.diskcache.b.a.BS().a(K, c0709a)) {
                    i = 1;
                }
                str = c0709a.msg;
                i2 = i;
            }
            if (bO != null) {
                j = bO.length();
            }
            adTemplate.setDownloadSize(j);
        } else if (yE > 0) {
            a.C0709a c0709a2 = new a.C0709a();
            f bl = com.kwad.sdk.core.videocache.c.a.bl(KsAdSDKImpl.get().getContext());
            if (!bl.eh(K)) {
                if (bl.a(K, yE * 1024, c0709a2, null)) {
                    i = 1;
                }
                i2 = i;
            }
            str = c0709a2.msg;
            adTemplate.setDownloadSize(yE * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i2), str);
    }
}

package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    public int f39728b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f39729c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f39730d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f39731e;

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public double B;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f39732b;

        /* renamed from: c  reason: collision with root package name */
        public int f39733c;

        /* renamed from: d  reason: collision with root package name */
        public int f39734d;

        /* renamed from: f  reason: collision with root package name */
        public int f39736f;

        /* renamed from: g  reason: collision with root package name */
        public z.a f39737g;

        /* renamed from: h  reason: collision with root package name */
        public String f39738h;
        public int i;
        public int j;
        public int k;
        public String m;
        public int n;
        public int o;
        public String p;
        public String q;
        public int r;
        public int s;
        public long t;
        public int v;
        public int w;
        public long x;
        public int y;

        /* renamed from: e  reason: collision with root package name */
        public int f39735e = -1;
        public String l = "";
        public int u = 0;
        public int z = -1;
        public int A = -1;
    }

    public p(@NonNull AdTemplate adTemplate, int i, @Nullable a aVar, @Nullable JSONObject jSONObject) {
        this.f39729c = adTemplate;
        this.f39728b = i;
        this.f39730d = aVar;
        this.f39731e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.f39732b;
        if (i != 0) {
            a("itemClickType", i);
        }
        if (!TextUtils.isEmpty(aVar.f39738h)) {
            b("payload", aVar.f39738h);
        }
        int i2 = aVar.o;
        if (i2 != 0) {
            a("adAggPageSource", i2);
        }
        int i3 = aVar.z;
        if (i3 >= 0) {
            a("adOrder", i3);
        }
        int i4 = aVar.A;
        if (i4 >= 0) {
            a("adInterstitialSource", i4);
        }
        double d2 = aVar.B;
        if (d2 > 0.0d) {
            a("splashShakeAcceleration", d2);
        }
    }

    private void a(String str, AdTemplate adTemplate, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.z;
        if (i >= 0) {
            a("adOrder", i);
        }
        int i2 = aVar.A;
        if (i2 >= 0) {
            a("adInterstitialSource", i2);
        }
    }

    private void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("clientTimestamp", System.currentTimeMillis());
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        b("extData", jSONObject.toString());
    }

    private void b(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.f39733c;
        if (i != 0) {
            a("itemCloseType", i);
        }
        int i2 = aVar.a;
        if (i2 > 0) {
            a("photoPlaySecond", i2);
        }
        int i3 = aVar.f39734d;
        if (i3 != 0) {
            a("elementType", i3);
        }
        if (!TextUtils.isEmpty(aVar.f39738h)) {
            b("payload", aVar.f39738h);
        }
        int i4 = aVar.i;
        if (i4 > 0) {
            a("deeplinkType", i4);
        }
        int i5 = aVar.j;
        if (i5 > 0) {
            a("downloadSource", i5);
        }
        int i6 = aVar.k;
        if (i6 > 0) {
            a("isPackageChanged", i6);
        }
        b("installedFrom", aVar.l);
        a("isChangedEndcard", aVar.n);
        int i7 = aVar.o;
        if (i7 != 0) {
            a("adAggPageSource", i7);
        }
        String str2 = aVar.m;
        if (str2 != null) {
            b("downloadFailedReason", str2);
        }
        if (!at.a(aVar.q)) {
            b("installedPackageName", aVar.q);
        }
        if (!at.a(aVar.p)) {
            b("serverPackageName", aVar.p);
        }
        int i8 = aVar.s;
        if (i8 > 0) {
            a("closeButtonClickTime", i8);
        }
        int i9 = aVar.r;
        if (i9 > 0) {
            a("closeButtonImpressionTime", i9);
        }
        int i10 = aVar.u;
        if (i10 >= 0) {
            a("downloadStatus", i10);
        }
        long j = aVar.t;
        if (j > 0) {
            a("landingPageLoadedDuration", j);
        }
        int i11 = aVar.f39735e;
        if (i11 > -1) {
            a("impFailReason", i11);
        }
        int i12 = aVar.f39736f;
        if (i12 > 0) {
            a("winEcpm", i12);
        }
        a("downloadCardType", aVar.v);
        a("landingPageType", aVar.w);
        int i13 = aVar.A;
        if (i13 >= 0) {
            a("adInterstitialSource", i13);
        }
    }

    private void b(String str, AdTemplate adTemplate, @Nullable a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i = adTemplate.mInitVoiceStatus;
        if (i != 0) {
            a("initVoiceStatus", i);
        }
        a("ecpmType", this.f39729c.mBidEcpm == 0 ? 2 : 1);
        if (aVar == null) {
            return;
        }
        int i2 = aVar.o;
        if (i2 != 0) {
            a("adAggPageSource", i2);
        }
        if (TextUtils.isEmpty(aVar.f39738h)) {
            return;
        }
        b("payload", aVar.f39738h);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        String replaceFirst;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.f39729c);
        int i = this.f39728b;
        if (i == 1) {
            replaceFirst = j.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf((this.f39729c.mBidEcpm == 0 && com.kwad.sdk.core.config.b.ax()) ? com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.j(this.f39729c)) : this.f39729c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f39729c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f39729c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.f39729c, this.f39730d);
        } else {
            AdInfo.AdBaseInfo adBaseInfo = j.adBaseInfo;
            if (i != 2) {
                replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i)).replaceFirst("__PR__", String.valueOf(this.f39729c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f39729c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f39729c.mVideoPlayerStatus.mVideoPlayerBehavior));
                b(replaceFirst, this.f39730d);
                a(this.f39731e);
                return replaceFirst;
            }
            String str = adBaseInfo.clickUrl;
            a aVar = this.f39730d;
            if (aVar != null) {
                str = z.b(str, aVar.f39737g);
            }
            replaceFirst = z.b(str).replaceFirst("__PR__", String.valueOf(this.f39729c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f39729c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f39729c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.f39730d);
        }
        b(replaceFirst, this.f39729c, this.f39730d);
        a(this.f39731e);
        return replaceFirst;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject e() {
        return this.a;
    }

    @Override // com.kwad.sdk.core.network.b
    public void g() {
    }

    @Override // com.kwad.sdk.core.network.b
    public void h() {
    }

    public AdTemplate i() {
        return this.f39729c;
    }

    public List<String> j() {
        z.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        ArrayList arrayList = new ArrayList();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.f39729c);
        if (!j.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = j.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.f39728b && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (aVar2 = this.f39730d) != null) {
                    aVar = aVar2.f39737g;
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(z.a(str, aVar));
                }
            }
        }
        return arrayList;
    }
}

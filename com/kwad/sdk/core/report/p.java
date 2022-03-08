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
/* loaded from: classes8.dex */
public class p extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    public int f54619b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f54620c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f54621d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f54622e;

    /* loaded from: classes8.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public double B;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f54623b;

        /* renamed from: c  reason: collision with root package name */
        public int f54624c;

        /* renamed from: d  reason: collision with root package name */
        public int f54625d;

        /* renamed from: f  reason: collision with root package name */
        public int f54627f;

        /* renamed from: g  reason: collision with root package name */
        public z.a f54628g;

        /* renamed from: h  reason: collision with root package name */
        public String f54629h;

        /* renamed from: i  reason: collision with root package name */
        public int f54630i;

        /* renamed from: j  reason: collision with root package name */
        public int f54631j;
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
        public int f54626e = -1;
        public String l = "";
        public int u = 0;
        public int z = -1;
        public int A = -1;
    }

    public p(@NonNull AdTemplate adTemplate, int i2, @Nullable a aVar, @Nullable JSONObject jSONObject) {
        this.f54620c = adTemplate;
        this.f54619b = i2;
        this.f54621d = aVar;
        this.f54622e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f54623b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (!TextUtils.isEmpty(aVar.f54629h)) {
            b("payload", aVar.f54629h);
        }
        int i3 = aVar.o;
        if (i3 != 0) {
            a("adAggPageSource", i3);
        }
        int i4 = aVar.z;
        if (i4 >= 0) {
            a("adOrder", i4);
        }
        int i5 = aVar.A;
        if (i5 >= 0) {
            a("adInterstitialSource", i5);
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
        int i2 = aVar.z;
        if (i2 >= 0) {
            a("adOrder", i2);
        }
        int i3 = aVar.A;
        if (i3 >= 0) {
            a("adInterstitialSource", i3);
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
        int i2 = aVar.f54624c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f54625d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f54629h)) {
            b("payload", aVar.f54629h);
        }
        int i5 = aVar.f54630i;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f54631j;
        if (i6 > 0) {
            a("downloadSource", i6);
        }
        int i7 = aVar.k;
        if (i7 > 0) {
            a("isPackageChanged", i7);
        }
        b("installedFrom", aVar.l);
        a("isChangedEndcard", aVar.n);
        int i8 = aVar.o;
        if (i8 != 0) {
            a("adAggPageSource", i8);
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
        int i9 = aVar.s;
        if (i9 > 0) {
            a("closeButtonClickTime", i9);
        }
        int i10 = aVar.r;
        if (i10 > 0) {
            a("closeButtonImpressionTime", i10);
        }
        int i11 = aVar.u;
        if (i11 >= 0) {
            a("downloadStatus", i11);
        }
        long j2 = aVar.t;
        if (j2 > 0) {
            a("landingPageLoadedDuration", j2);
        }
        int i12 = aVar.f54626e;
        if (i12 > -1) {
            a("impFailReason", i12);
        }
        int i13 = aVar.f54627f;
        if (i13 > 0) {
            a("winEcpm", i13);
        }
        a("downloadCardType", aVar.v);
        a("landingPageType", aVar.w);
        int i14 = aVar.A;
        if (i14 >= 0) {
            a("adInterstitialSource", i14);
        }
    }

    private void b(String str, AdTemplate adTemplate, @Nullable a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i2 = adTemplate.mInitVoiceStatus;
        if (i2 != 0) {
            a("initVoiceStatus", i2);
        }
        a("ecpmType", this.f54620c.mBidEcpm == 0 ? 2 : 1);
        if (aVar == null) {
            return;
        }
        int i3 = aVar.o;
        if (i3 != 0) {
            a("adAggPageSource", i3);
        }
        if (TextUtils.isEmpty(aVar.f54629h)) {
            return;
        }
        b("payload", aVar.f54629h);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        String replaceFirst;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f54620c);
        int i2 = this.f54619b;
        if (i2 == 1) {
            replaceFirst = j2.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf((this.f54620c.mBidEcpm == 0 && com.kwad.sdk.core.config.b.ax()) ? com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.j(this.f54620c)) : this.f54620c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f54620c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f54620c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.f54620c, this.f54621d);
        } else {
            AdInfo.AdBaseInfo adBaseInfo = j2.adBaseInfo;
            if (i2 != 2) {
                replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.f54620c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f54620c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f54620c.mVideoPlayerStatus.mVideoPlayerBehavior));
                b(replaceFirst, this.f54621d);
                a(this.f54622e);
                return replaceFirst;
            }
            String str = adBaseInfo.clickUrl;
            a aVar = this.f54621d;
            if (aVar != null) {
                str = z.b(str, aVar.f54628g);
            }
            replaceFirst = z.b(str).replaceFirst("__PR__", String.valueOf(this.f54620c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f54620c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f54620c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.f54621d);
        }
        b(replaceFirst, this.f54620c, this.f54621d);
        a(this.f54622e);
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
        return this.f54620c;
    }

    public List<String> j() {
        z.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        ArrayList arrayList = new ArrayList();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f54620c);
        if (!j2.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = j2.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.f54619b && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (aVar2 = this.f54621d) != null) {
                    aVar = aVar2.f54628g;
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(z.a(str, aVar));
                }
            }
        }
        return arrayList;
    }
}

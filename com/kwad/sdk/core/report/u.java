package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.x;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class u extends com.kwad.sdk.core.network.b {
    public int a;
    public final AdTemplate b;
    @Nullable
    public final b c;
    @Nullable
    public final JSONObject d;

    @KsJson
    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String a;
        public int b = -1;
        public String c;

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.b;
            if (i != -1) {
                com.kwad.sdk.utils.r.a(jSONObject, "shield_reason", i);
            }
        }
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public int A;
        public a B;
        public int C;
        public long D;
        public int E;
        public double H;
        public String J;
        public int L;
        public int N;
        public int O;
        public String Q;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int g;
        public y.a i;
        public String j;
        public int k;
        public int l;
        public int m;
        public String o;
        public int p;
        public int q;
        public String r;
        public String s;
        public int t;
        public int u;
        public long v;
        public long w;
        public int f = -1;
        public int h = -1;
        public String n = "";
        public int x = -1;
        public int y = -1;
        public int z = 0;
        public int F = -1;
        public int G = -1;
        public int I = -1;
        public int K = -1;
        public int M = -1;
        public int P = -1;

        public final void a(int i) {
            if (i == 0) {
                this.N = 1;
            } else if (i == 1) {
                this.N = 2;
            } else if (i != 2) {
            } else {
                this.N = 3;
            }
        }

        public final void a(@Nullable g gVar) {
            if (gVar != null) {
                this.Q = gVar.a();
            }
        }
    }

    public u(@NonNull AdTemplate adTemplate, int i, @Nullable b bVar, @Nullable JSONObject jSONObject) {
        this.b = adTemplate;
        this.a = i;
        this.c = bVar;
        this.d = jSONObject;
    }

    private void a(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = bVar.F;
        if (i >= 0) {
            putBody("adOrder", i);
        }
        int i2 = bVar.G;
        if (i2 >= 0) {
            putBody("adInterstitialSource", i2);
        }
        int i3 = bVar.I;
        if (i3 >= 0) {
            putBody("universeSecondAd", i3);
        }
        putBody("adxResult", bVar.M);
        int i4 = bVar.N;
        if (i4 != 0) {
            putBody("fingerSwipeType", i4);
        }
        int i5 = bVar.O;
        if (i5 != 0) {
            putBody("fingerSwipeDistance", i5);
        }
        int i6 = bVar.y;
        if (i6 != -1) {
            putBody("installStatus", i6);
        }
        a aVar = bVar.B;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        String str2 = bVar.Q;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i7 = bVar.P;
        if (i7 != -1) {
            putBody("triggerType", i7);
        }
    }

    private void a(String str, AdTemplate adTemplate, @Nullable b bVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i = adTemplate.mInitVoiceStatus;
        if (i != 0) {
            putBody("initVoiceStatus", i);
        }
        putBody("ecpmType", this.b.mBidEcpm == 0 ? 2 : 1);
        if (bVar == null) {
            return;
        }
        int i2 = bVar.q;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        if (TextUtils.isEmpty(bVar.j)) {
            return;
        }
        putBody("payload", bVar.j);
    }

    private void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("clientTimestamp", System.currentTimeMillis());
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.a(e);
        }
        putBody("extData", jSONObject.toString());
    }

    private void b(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = bVar.c;
        if (i != 0) {
            putBody("itemClickType", i);
        }
        if (!TextUtils.isEmpty(bVar.j)) {
            putBody("payload", bVar.j);
        }
        int i2 = bVar.q;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        int i3 = bVar.F;
        if (i3 >= 0) {
            putBody("adOrder", i3);
        }
        int i4 = bVar.G;
        if (i4 >= 0) {
            putBody("adInterstitialSource", i4);
        }
        int i5 = bVar.P;
        if (i5 != -1) {
            putBody("triggerType", i5);
        }
        putBody("adxResult", bVar.M);
        double d = bVar.H;
        if (d > 0.0d) {
            putBody("splashShakeAcceleration", d);
        }
        if (!TextUtils.isEmpty(bVar.J)) {
            putBody("splashInteractionRotateAngle", bVar.J);
        }
        int i6 = bVar.N;
        if (i6 != 0) {
            putBody("fingerSwipeType", i6);
        }
        int i7 = bVar.O;
        if (i7 != 0) {
            putBody("fingerSwipeDistance", i7);
        }
        long j = bVar.D;
        if (j > 0) {
            putBody("playedDuration", j);
        }
        int i8 = bVar.E;
        if (i8 > 0) {
            putBody("playedRate", i8);
        }
        String str2 = bVar.Q;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i9 = bVar.h;
        if (i9 != -1) {
            putBody("retainCodeType", i9);
        }
    }

    private void c(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = bVar.d;
        if (i != 0) {
            putBody("itemCloseType", i);
        }
        int i2 = bVar.a;
        if (i2 > 0) {
            putBody("photoPlaySecond", i2);
        }
        int i3 = bVar.b;
        if (i3 != 0) {
            putBody("awardReceiveStage", i3);
        }
        int i4 = bVar.e;
        if (i4 != 0) {
            putBody("elementType", i4);
        }
        if (!TextUtils.isEmpty(bVar.j)) {
            putBody("payload", bVar.j);
        }
        a aVar = bVar.B;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        int i5 = bVar.k;
        if (i5 > 0) {
            putBody("deeplinkType", i5);
        }
        int i6 = bVar.l;
        if (i6 > 0) {
            putBody("downloadSource", i6);
        }
        int i7 = bVar.m;
        if (i7 > 0) {
            putBody("isPackageChanged", i7);
        }
        putBody("installedFrom", bVar.n);
        putBody("isChangedEndcard", bVar.p);
        int i8 = bVar.q;
        if (i8 != 0) {
            putBody("adAggPageSource", i8);
        }
        String str2 = bVar.o;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!at.a(bVar.s)) {
            putBody("installedPackageName", bVar.s);
        }
        if (!at.a(bVar.r)) {
            putBody("serverPackageName", bVar.r);
        }
        int i9 = bVar.u;
        if (i9 > 0) {
            putBody("closeButtonClickTime", i9);
        }
        int i10 = bVar.t;
        if (i10 > 0) {
            putBody("closeButtonImpressionTime", i10);
        }
        int i11 = bVar.z;
        if (i11 >= 0) {
            putBody("downloadStatus", i11);
        }
        long j = bVar.v;
        if (j > 0) {
            putBody("landingPageLoadedDuration", j);
        }
        long j2 = bVar.w;
        if (j2 > 0) {
            putBody("leaveTime", j2);
        }
        int i12 = bVar.h;
        if (i12 != -1) {
            putBody("retainCodeType", i12);
        }
        int i13 = bVar.f;
        if (i13 >= 0) {
            putBody("impFailReason", i13);
        }
        int i14 = bVar.g;
        if (i14 > 0) {
            putBody("winEcpm", i14);
        }
        putBody("downloadCardType", bVar.A);
        putBody("landingPageType", bVar.C);
        int i15 = bVar.G;
        if (i15 >= 0) {
            putBody("adInterstitialSource", i15);
        }
        int i16 = bVar.K;
        if (i16 > 0) {
            putBody("downloadInstallType", i16);
        }
        int i17 = bVar.N;
        if (i17 != 0) {
            putBody("fingerSwipeType", i17);
        }
        int i18 = bVar.O;
        if (i18 != 0) {
            putBody("fingerSwipeDistance", i18);
        }
        int i19 = bVar.L;
        if (i19 > 0) {
            putBody("businessSceneType", i19);
        }
        long j3 = bVar.D;
        if (j3 > 0) {
            putBody("playedDuration", j3);
        }
        int i20 = bVar.E;
        if (i20 > 0) {
            putBody("playedRate", i20);
        }
        int i21 = bVar.x;
        if (i21 != -1) {
            putBody("appStorePageType", i21);
        }
        int i22 = bVar.P;
        if (i22 != -1) {
            putBody("triggerType", i22);
        }
    }

    public final AdTemplate a() {
        return this.b;
    }

    public final List<String> b() {
        y.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        b bVar;
        ArrayList arrayList = new ArrayList();
        AdInfo i = com.kwad.sdk.core.response.a.d.i(this.b);
        if (!i.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = i.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.a && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (bVar = this.c) != null) {
                    aVar = bVar.i;
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(x.a(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), str, aVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        String replaceFirst;
        AdInfo i = com.kwad.sdk.core.response.a.d.i(this.b);
        int i2 = this.a;
        if (i2 == 1) {
            replaceFirst = i.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf((this.b.mBidEcpm == 0 && ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).j()) ? com.kwad.sdk.core.response.a.a.M(com.kwad.sdk.core.response.a.d.i(this.b)) : this.b.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.b.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.b.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.c);
        } else if (i2 != 2) {
            replaceFirst = i.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.b.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.b.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.b.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.c);
            a(this.d);
            return replaceFirst;
        } else {
            String str = i.adBaseInfo.clickUrl;
            if (this.c != null) {
                ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
                str = y.a(str, this.c.i);
            }
            replaceFirst = y.b(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), str).replaceFirst("__PR__", String.valueOf(this.b.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.b.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.b.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.c);
        }
        a(replaceFirst, this.b, this.c);
        a(this.d);
        return replaceFirst;
    }
}

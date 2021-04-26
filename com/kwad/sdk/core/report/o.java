package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    public int f33423b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f33424c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f33425d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f33426e;

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f33427a;

        /* renamed from: b  reason: collision with root package name */
        public int f33428b;

        /* renamed from: c  reason: collision with root package name */
        public int f33429c;

        /* renamed from: d  reason: collision with root package name */
        public int f33430d;

        /* renamed from: e  reason: collision with root package name */
        public q.a f33431e;

        /* renamed from: f  reason: collision with root package name */
        public String f33432f;

        /* renamed from: g  reason: collision with root package name */
        public int f33433g;

        /* renamed from: h  reason: collision with root package name */
        public int f33434h;

        /* renamed from: i  reason: collision with root package name */
        public int f33435i;
        public String k;
        public int l;
        public String m;
        public String n;
        public int o;
        public int p;
        public long q;
        public int s;
        public String j = "";
        public int r = 0;
    }

    public o(@NonNull AdTemplate adTemplate, int i2, @Nullable a aVar, @Nullable JSONObject jSONObject) {
        this.f33424c = adTemplate;
        this.f33423b = i2;
        this.f33425d = aVar;
        this.f33426e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f33428b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (TextUtils.isEmpty(aVar.f33432f)) {
            return;
        }
        b("payload", aVar.f33432f);
    }

    private void a(String str, AdTemplate adTemplate) {
        int i2;
        if (TextUtils.isEmpty(str) || adTemplate == null || (i2 = adTemplate.mInitVoiceStatus) == 0) {
            return;
        }
        a("initVoiceStatus", i2);
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
        int i2 = aVar.f33429c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.f33427a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f33430d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f33432f)) {
            b("payload", aVar.f33432f);
        }
        int i5 = aVar.f33433g;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f33434h;
        if (i6 > 0) {
            a("download_source", i6);
        }
        int i7 = aVar.f33435i;
        if (i7 > 0) {
            a("isPackageChanged", i7);
        }
        b("installedFrom", aVar.j);
        a("isChangedEndcard", aVar.l);
        String str2 = aVar.k;
        if (str2 != null) {
            b("downloadFailedReason", str2);
        }
        if (!ag.a(aVar.n)) {
            b("installedPackageName", aVar.n);
        }
        if (!ag.a(aVar.m)) {
            b("serverPackageName", aVar.m);
        }
        int i8 = aVar.p;
        if (i8 > 0) {
            a("closeButtonClickTime", i8);
        }
        int i9 = aVar.o;
        if (i9 > 0) {
            a("closeButtonImpressionTime", i9);
        }
        int i10 = aVar.r;
        if (i10 >= 0) {
            a("downloadStatus", i10);
        }
        long j = aVar.q;
        if (j > 0) {
            a("landingPageLoadedDuration", j);
        }
        a("downloadCardType", aVar.s);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        String replaceFirst;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f33424c);
        int i2 = this.f33423b;
        if (i2 == 1) {
            replaceFirst = g2.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.f33424c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f33424c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f33424c.mVideoPlayerStatus.mVideoPlayerBehavior));
        } else {
            AdInfo.AdBaseInfo adBaseInfo = g2.adBaseInfo;
            if (i2 != 2) {
                replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.f33424c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f33424c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f33424c.mVideoPlayerStatus.mVideoPlayerBehavior));
                b(replaceFirst, this.f33425d);
                a(this.f33426e);
                return replaceFirst;
            }
            String str = adBaseInfo.clickUrl;
            a aVar = this.f33425d;
            if (aVar != null) {
                str = q.b(str, aVar.f33431e);
            }
            replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.f33424c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f33424c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f33424c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.f33425d);
        }
        a(replaceFirst, this.f33424c);
        a(this.f33426e);
        return replaceFirst;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject d() {
        return this.f33216a;
    }

    @Override // com.kwad.sdk.core.network.b
    public void e() {
    }

    @Override // com.kwad.sdk.core.network.b
    public void f() {
    }

    public List<String> g() {
        q.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        ArrayList arrayList = new ArrayList();
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f33424c);
        if (!g2.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = g2.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.f33423b && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (aVar2 = this.f33425d) != null) {
                    aVar = aVar2.f33431e;
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(q.a(str, aVar));
                }
            }
        }
        return arrayList;
    }
}

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
    public int f32668b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32669c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f32670d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f32671e;

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f32672a;

        /* renamed from: b  reason: collision with root package name */
        public int f32673b;

        /* renamed from: c  reason: collision with root package name */
        public int f32674c;

        /* renamed from: d  reason: collision with root package name */
        public int f32675d;

        /* renamed from: e  reason: collision with root package name */
        public q.a f32676e;

        /* renamed from: f  reason: collision with root package name */
        public String f32677f;

        /* renamed from: g  reason: collision with root package name */
        public int f32678g;

        /* renamed from: h  reason: collision with root package name */
        public int f32679h;

        /* renamed from: i  reason: collision with root package name */
        public int f32680i;
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
        this.f32669c = adTemplate;
        this.f32668b = i2;
        this.f32670d = aVar;
        this.f32671e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f32673b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (TextUtils.isEmpty(aVar.f32677f)) {
            return;
        }
        b("payload", aVar.f32677f);
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
        int i2 = aVar.f32674c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.f32672a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f32675d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f32677f)) {
            b("payload", aVar.f32677f);
        }
        int i5 = aVar.f32678g;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f32679h;
        if (i6 > 0) {
            a("download_source", i6);
        }
        int i7 = aVar.f32680i;
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
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f32669c);
        int i2 = this.f32668b;
        if (i2 == 1) {
            replaceFirst = g2.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.f32669c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f32669c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f32669c.mVideoPlayerStatus.mVideoPlayerBehavior));
        } else {
            AdInfo.AdBaseInfo adBaseInfo = g2.adBaseInfo;
            if (i2 != 2) {
                replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.f32669c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f32669c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f32669c.mVideoPlayerStatus.mVideoPlayerBehavior));
                b(replaceFirst, this.f32670d);
                a(this.f32671e);
                return replaceFirst;
            }
            String str = adBaseInfo.clickUrl;
            a aVar = this.f32670d;
            if (aVar != null) {
                str = q.b(str, aVar.f32676e);
            }
            replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.f32669c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f32669c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f32669c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.f32670d);
        }
        a(replaceFirst, this.f32669c);
        a(this.f32671e);
        return replaceFirst;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject d() {
        return this.f32461a;
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
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f32669c);
        if (!g2.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = g2.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.f32668b && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (aVar2 = this.f32670d) != null) {
                    aVar = aVar2.f32676e;
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(q.a(str, aVar));
                }
            }
        }
        return arrayList;
    }
}

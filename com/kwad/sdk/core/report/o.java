package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    public int f34786b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34787c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f34788d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f34789e;

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f34790a;

        /* renamed from: b  reason: collision with root package name */
        public int f34791b;

        /* renamed from: c  reason: collision with root package name */
        public int f34792c;

        /* renamed from: d  reason: collision with root package name */
        public int f34793d;

        /* renamed from: e  reason: collision with root package name */
        public s.a f34794e;

        /* renamed from: f  reason: collision with root package name */
        public String f34795f;

        /* renamed from: g  reason: collision with root package name */
        public int f34796g;

        /* renamed from: h  reason: collision with root package name */
        public int f34797h;

        /* renamed from: i  reason: collision with root package name */
        public int f34798i;
        public String k;
        public int l;
        public String m;
        public String n;
        public int o;
        public int p;
        public String j = "";
        public int q = 0;
    }

    public o(@NonNull AdTemplate adTemplate, int i2, @Nullable a aVar, @Nullable JSONObject jSONObject) {
        this.f34787c = adTemplate;
        this.f34786b = i2;
        this.f34788d = aVar;
        this.f34789e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f34791b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (TextUtils.isEmpty(aVar.f34795f)) {
            return;
        }
        b("payload", aVar.f34795f);
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
        int i2 = aVar.f34792c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.f34790a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f34793d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f34795f)) {
            b("payload", aVar.f34795f);
        }
        int i5 = aVar.f34796g;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f34797h;
        if (i6 > 0) {
            a("download_source", i6);
        }
        a("is_package_changed", aVar.f34798i);
        b("installed_from", aVar.j);
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
        int i7 = aVar.p;
        if (i7 > 0) {
            a("closeButtonClickTime", i7);
        }
        int i8 = aVar.o;
        if (i8 > 0) {
            a("closeButtonImpressionTime", i8);
        }
        int i9 = aVar.q;
        if (i9 >= 0) {
            a("downloadStatus", i9);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        String replaceFirst;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f34787c);
        int i2 = this.f34786b;
        if (i2 == 1) {
            replaceFirst = j.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.f34787c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f34787c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f34787c.mVideoPlayerStatus.mVideoPlayerBehavior));
        } else {
            AdInfo.AdBaseInfo adBaseInfo = j.adBaseInfo;
            if (i2 != 2) {
                replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.f34787c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f34787c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f34787c.mVideoPlayerStatus.mVideoPlayerBehavior));
                b(replaceFirst, this.f34788d);
                a(this.f34789e);
                return replaceFirst;
            }
            String str = adBaseInfo.clickUrl;
            a aVar = this.f34788d;
            if (aVar != null) {
                str = s.b(str, aVar.f34794e);
            }
            replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.f34787c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f34787c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f34787c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.f34788d);
        }
        a(replaceFirst, this.f34787c);
        a(this.f34789e);
        return replaceFirst;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject d() {
        return this.f34590a;
    }

    @Override // com.kwad.sdk.core.network.b
    public void e() {
    }

    @Override // com.kwad.sdk.core.network.b
    public void f() {
    }

    public List<String> g() {
        s.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        ArrayList arrayList = new ArrayList();
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f34787c);
        if (!j.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = j.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.f34786b && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (aVar2 = this.f34788d) != null) {
                    aVar = aVar2.f34794e;
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(s.a(str, aVar));
                }
            }
        }
        return arrayList;
    }
}

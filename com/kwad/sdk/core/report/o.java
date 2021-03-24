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
/* loaded from: classes6.dex */
public class o extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    public int f34052b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34053c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f34054d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f34055e;

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f34056a;

        /* renamed from: b  reason: collision with root package name */
        public int f34057b;

        /* renamed from: c  reason: collision with root package name */
        public int f34058c;

        /* renamed from: d  reason: collision with root package name */
        public int f34059d;

        /* renamed from: e  reason: collision with root package name */
        public s.a f34060e;

        /* renamed from: f  reason: collision with root package name */
        public String f34061f;

        /* renamed from: g  reason: collision with root package name */
        public int f34062g;

        /* renamed from: h  reason: collision with root package name */
        public int f34063h;
        public int i;
        public String k;
        public int l;
        public String m;
        public String n;
        public int o;
        public int p;
        public String j = "";
        public int q = 0;
    }

    public o(@NonNull AdTemplate adTemplate, int i, @Nullable a aVar, @Nullable JSONObject jSONObject) {
        this.f34053c = adTemplate;
        this.f34052b = i;
        this.f34054d = aVar;
        this.f34055e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.f34057b;
        if (i != 0) {
            a("itemClickType", i);
        }
        if (TextUtils.isEmpty(aVar.f34061f)) {
            return;
        }
        b("payload", aVar.f34061f);
    }

    private void a(String str, AdTemplate adTemplate) {
        int i;
        if (TextUtils.isEmpty(str) || adTemplate == null || (i = adTemplate.mInitVoiceStatus) == 0) {
            return;
        }
        a("initVoiceStatus", i);
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
        int i = aVar.f34058c;
        if (i != 0) {
            a("itemCloseType", i);
        }
        int i2 = aVar.f34056a;
        if (i2 > 0) {
            a("photoPlaySecond", i2);
        }
        int i3 = aVar.f34059d;
        if (i3 != 0) {
            a("elementType", i3);
        }
        if (!TextUtils.isEmpty(aVar.f34061f)) {
            b("payload", aVar.f34061f);
        }
        int i4 = aVar.f34062g;
        if (i4 > 0) {
            a("deeplinkType", i4);
        }
        int i5 = aVar.f34063h;
        if (i5 > 0) {
            a("download_source", i5);
        }
        a("is_package_changed", aVar.i);
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
        int i6 = aVar.p;
        if (i6 > 0) {
            a("closeButtonClickTime", i6);
        }
        int i7 = aVar.o;
        if (i7 > 0) {
            a("closeButtonImpressionTime", i7);
        }
        int i8 = aVar.q;
        if (i8 >= 0) {
            a("downloadStatus", i8);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        String replaceFirst;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f34053c);
        int i = this.f34052b;
        if (i == 1) {
            replaceFirst = j.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.f34053c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f34053c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f34053c.mVideoPlayerStatus.mVideoPlayerBehavior));
        } else {
            AdInfo.AdBaseInfo adBaseInfo = j.adBaseInfo;
            if (i != 2) {
                replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i)).replaceFirst("__PR__", String.valueOf(this.f34053c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f34053c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f34053c.mVideoPlayerStatus.mVideoPlayerBehavior));
                b(replaceFirst, this.f34054d);
                a(this.f34055e);
                return replaceFirst;
            }
            String str = adBaseInfo.clickUrl;
            a aVar = this.f34054d;
            if (aVar != null) {
                str = s.b(str, aVar.f34060e);
            }
            replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.f34053c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f34053c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f34053c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.f34054d);
        }
        a(replaceFirst, this.f34053c);
        a(this.f34055e);
        return replaceFirst;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject d() {
        return this.f33863a;
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
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f34053c);
        if (!j.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = j.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.f34052b && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (aVar2 = this.f34054d) != null) {
                    aVar = aVar2.f34060e;
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(s.a(str, aVar));
                }
            }
        }
        return arrayList;
    }
}

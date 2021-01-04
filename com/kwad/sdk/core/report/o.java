package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o extends com.kwad.sdk.core.network.b {

    /* renamed from: b  reason: collision with root package name */
    int f9726b;
    private AdTemplate c;
    @Nullable
    private a d;
    @Nullable
    private JSONObject e;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f9727a;

        /* renamed from: b  reason: collision with root package name */
        public int f9728b;
        public int c;
        public int d;
        s.a e;
        public String f;
        public int g;
        public int h;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(@NonNull AdTemplate adTemplate, int i, @Nullable a aVar, @Nullable JSONObject jSONObject) {
        this.c = adTemplate;
        this.f9726b = i;
        this.d = aVar;
        this.e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.f9728b != 0) {
            a("itemClickType", aVar.f9728b);
        }
        if (TextUtils.isEmpty(aVar.f)) {
            return;
        }
        b("payload", aVar.f);
    }

    private void a(String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str) || adTemplate == null || adTemplate.mInitVoiceStatus == 0) {
            return;
        }
        a("initVoiceStatus", adTemplate.mInitVoiceStatus);
    }

    private void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("clientTimestamp", System.currentTimeMillis());
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        b(CashierData.EXT_DATA, jSONObject.toString());
    }

    private void b(String str, @Nullable a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.c != 0) {
            a("itemCloseType", aVar.c);
        }
        if (aVar.f9727a > 0) {
            a("photoPlaySecond", aVar.f9727a);
        }
        if (aVar.d != 0) {
            a("elementType", aVar.d);
        }
        if (!TextUtils.isEmpty(aVar.f)) {
            b("payload", aVar.f);
        }
        if (aVar.g > 0) {
            a("deeplinkType", aVar.g);
        }
        if (aVar.h > 0) {
            a("download_source", aVar.h);
        }
        a("is_package_changed", aVar.i);
        b("installed_from", aVar.j);
        a("isChangedEndcard", aVar.l);
        if (aVar.k != null) {
            b("downloadFailedReason", aVar.k);
        }
        if (!ag.a(aVar.n)) {
            b("installedPackageName", aVar.n);
        }
        if (!ag.a(aVar.m)) {
            b("serverPackageName", aVar.m);
        }
        if (aVar.p > 0) {
            a("closeButtonClickTime", aVar.p);
        }
        if (aVar.o > 0) {
            a("closeButtonImpressionTime", aVar.o);
        }
        if (aVar.q >= 0) {
            a("downloadStatus", aVar.q);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        String replaceFirst;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.c);
        if (this.f9726b == 1) {
            replaceFirst = j.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.c);
        } else if (this.f9726b == 2) {
            String str = j.adBaseInfo.clickUrl;
            if (this.d != null) {
                str = s.b(str, this.d.e);
            }
            replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.c.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.d);
            a(replaceFirst, this.c);
        } else {
            replaceFirst = j.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(this.f9726b)).replaceFirst("__PR__", String.valueOf(this.c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.c.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.d);
        }
        a(this.e);
        return replaceFirst;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject d() {
        return this.f9615a;
    }

    @Override // com.kwad.sdk.core.network.b
    protected void e() {
    }

    @Override // com.kwad.sdk.core.network.b
    protected void f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> g() {
        AdInfo.AdTrackInfo adTrackInfo;
        ArrayList arrayList = new ArrayList();
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.c);
        if (!j.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = j.adTrackInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                AdInfo.AdTrackInfo next = it.next();
                if (next.type == this.f9726b && next.urls != null) {
                    adTrackInfo = next;
                    break;
                }
            }
            if (adTrackInfo != null) {
                s.a aVar = (adTrackInfo.type != 2 || this.d == null) ? null : this.d.e;
                for (String str : adTrackInfo.urls) {
                    arrayList.add(s.a(str, aVar));
                }
            }
        }
        return arrayList;
    }
}

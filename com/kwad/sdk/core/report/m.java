package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@KsJson
/* loaded from: classes5.dex */
public class m extends c {
    public long A;
    public int B;
    public String D;
    public URLPackage E;
    public URLPackage F;
    public long G;
    public String H;
    public JSONArray I;
    public JSONArray J;
    public a K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public String Q;
    public String R;
    public int S;
    public long T;
    public int U;
    public int V;
    public String W;
    public JSONObject X;
    public JSONArray Y;
    public long Z;
    public JSONArray aA;
    public String aB;
    public String aC;
    public String aD;
    public String aE;
    public String aF;
    public String aH;
    public String aI;
    public int aa;
    public int ab;
    public JSONArray af;
    public boolean ag;
    public String ah;
    public long ak;
    public long al;
    public int am;
    public String an;
    public long ao;
    public long ap;
    public long aq;
    public long ar;
    public String as;
    public String at;
    public long au;
    public long av;
    public JSONArray aw;
    public long ax;
    public long ay;
    public long az;
    public transient SceneImpl b;
    @Nullable
    public transient AdTemplate c;
    public long d;
    public String e;
    public long f;
    public long h;
    public long i;
    public String j;
    public long k;
    public JSONObject l;
    public JSONObject m;
    public long n;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public int g = -1;
    public int o = 0;
    public int p = 0;
    public long z = -1;
    public int C = 0;
    public int ac = -1;
    public int ad = -1;
    public long ae = 0;
    public int ai = 0;
    public int aj = -1;
    public int aG = 0;

    @KsJson
    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
        public int b;

        public static a a() {
            a aVar = new a();
            aVar.a = b.a;
            aVar.b = b.b;
            return aVar;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static int a;
        public static int b;
    }

    public m(long j) {
        this.i = j;
    }

    public m(long j, @NonNull AdTemplate adTemplate) {
        this.i = j;
        this.c = adTemplate;
    }

    public m(long j, @NonNull AdTemplate adTemplate, String str) {
        this.i = j;
        this.c = adTemplate;
        this.j = str;
    }

    public m(String str) {
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    public m(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        this.M = 3;
        r rVar = (r) ServiceProvider.a(r.class);
        if (rVar != null) {
            this.ai = rVar.b();
        }
        this.a = UUID.randomUUID().toString();
        this.d = System.currentTimeMillis();
        this.e = s.b();
        try {
            this.f = s.c();
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
        this.h = s.e();
        SceneImpl sceneImpl2 = this.b;
        if (sceneImpl2 == null) {
            if (adTemplate != null && (sceneImpl2 = adTemplate.mAdScene) != null) {
                this.b = sceneImpl2;
            }
            if (adTemplate != null) {
                this.r = adTemplate.getShowPosition() + 1;
                this.s = adTemplate.getServerPosition() + 1;
                this.k = com.kwad.sdk.core.response.a.d.f(adTemplate);
                String g = com.kwad.sdk.core.response.a.d.g(adTemplate);
                if (!TextUtils.isEmpty(g)) {
                    try {
                        this.l = new JSONObject(g);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.b(e2);
                    }
                }
                String h = com.kwad.sdk.core.response.a.d.h(adTemplate);
                if (!TextUtils.isEmpty(h)) {
                    try {
                        this.m = new JSONObject(h);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.b.b(e3);
                    }
                }
                this.n = com.kwad.sdk.core.response.a.d.b(adTemplate);
                this.o = com.kwad.sdk.core.response.a.d.e(adTemplate);
                this.p = adTemplate.realShowType;
                this.q = com.kwad.sdk.core.response.a.d.n(adTemplate);
                if (this.p == 2) {
                    AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
                    this.T = i.adBaseInfo.creativeId;
                    this.t = com.kwad.sdk.core.response.a.a.c(i) * 1000;
                    this.G = i.advertiserInfo.userId;
                }
                this.L = adTemplate.mMediaPlayerType;
                this.N = adTemplate.mIsLeftSlipStatus;
                this.P = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.aa = pageInfo.pageType;
                }
                this.B = com.kwad.sdk.core.response.a.d.o(adTemplate);
            }
            this.K = a.a();
            if (this.b == null && adTemplate != null) {
                this.b = adTemplate.mAdScene;
            }
            sceneImpl = this.b;
            if (sceneImpl == null) {
                this.n = sceneImpl.getPosId();
                this.E = this.b.getUrlPackage();
                return;
            }
            return;
        }
        this.n = sceneImpl2.getPosId();
        this.E = this.b.getUrlPackage();
        this.g = this.b.getAdStyle();
        if (adTemplate != null) {
        }
        this.K = a.a();
        if (this.b == null) {
            this.b = adTemplate.mAdScene;
        }
        sceneImpl = this.b;
        if (sceneImpl == null) {
        }
    }

    @Override // com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.M = 3;
        this.g = jSONObject.optInt("adStyle", -1);
        this.V = jSONObject.optInt("num");
        this.U = jSONObject.optInt("state");
        this.ae = jSONObject.optLong("timeSpend");
        this.ay = jSONObject.optLong("loadingDuration");
        this.az = jSONObject.optLong("loadingDurationLimt");
        this.aj = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.a = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.r.a(jSONObject, "actionId", this.a);
        int i = this.g;
        if (i > 0) {
            com.kwad.sdk.utils.r.a(jSONObject, "adStyle", i);
        }
        int i2 = this.V;
        if (i2 > 0) {
            com.kwad.sdk.utils.r.a(jSONObject, "num", i2);
        }
        int i3 = this.U;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.a(jSONObject, "state", i3);
        }
        long j = this.ae;
        if (j > 0) {
            com.kwad.sdk.utils.r.a(jSONObject, "timeSpend", j);
        }
        long j2 = this.ay;
        if (j2 > 0) {
            com.kwad.sdk.utils.r.a(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.az;
        if (j3 > 0) {
            com.kwad.sdk.utils.r.a(jSONObject, "loadingDurationLimt", j3);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "playerTypeInfo", this.aj);
    }

    public final m b() {
        a(this.c);
        return this;
    }

    public final void c() {
        com.kwad.sdk.service.kwai.h hVar = (com.kwad.sdk.service.kwai.h) ServiceProvider.a(com.kwad.sdk.service.kwai.h.class);
        this.ab = hVar.a() ? 1 : 0;
        this.ac = hVar.b();
        this.ad = hVar.c();
    }
}

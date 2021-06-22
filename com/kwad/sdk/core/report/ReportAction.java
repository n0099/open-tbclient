package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PreloadData;
import com.kwad.sdk.core.scene.EntryPackage;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.ag;
import com.kwai.player.debuginfo.model.AppLiveQosDebugInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ReportAction extends d {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public long F;
    public long G;
    public String H;
    public int I;
    public long J;
    public long K;
    public long L;
    public JSONObject M;
    public JSONObject N;
    public long O;
    public int P;
    public int Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public long V;
    public long W;
    public long X;
    public int Y;
    public int Z;
    public JSONArray aA;
    public String aa;
    public long ab;
    public int ac;
    public int ad;
    public int ae;
    public JSONArray af;
    public JSONArray ag;
    public String ah;
    public String ai;
    public String aj;
    public long ak;
    public long al;
    public int am;
    public String an;
    public a ao;
    public int ap;
    public String aq;
    public long ar;
    public String as;
    public String at;
    public long au;
    public int av;
    public int aw;
    public int ax;
    public JSONArray ay;
    public LiveLogInfo az;

    /* renamed from: b  reason: collision with root package name */
    public long f34713b;

    /* renamed from: c  reason: collision with root package name */
    public long f34714c;

    /* renamed from: d  reason: collision with root package name */
    public long f34715d;

    /* renamed from: e  reason: collision with root package name */
    public long f34716e;

    /* renamed from: f  reason: collision with root package name */
    public long f34717f;

    /* renamed from: g  reason: collision with root package name */
    public long f34718g;

    /* renamed from: h  reason: collision with root package name */
    public long f34719h;

    /* renamed from: i  reason: collision with root package name */
    public String f34720i;
    public int j;
    public URLPackage k;
    public URLPackage l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public String r;
    public long s;
    public String t;
    public int u;
    public int v;
    public String w;
    public String x;
    public JSONObject y;
    public long z;

    /* loaded from: classes7.dex */
    public static class LiveLogInfo implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 4898843925487388950L;
        public String expTag;
        public String liveStreamId;

        public LiveLogInfo() {
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.liveStreamId = jSONObject.optString("liveStreamId");
            this.expTag = jSONObject.optString("expTag");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "liveStreamId", this.liveStreamId);
            com.kwad.sdk.utils.o.a(jSONObject, "expTag", this.expTag);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34721a;

        /* renamed from: b  reason: collision with root package name */
        public int f34722b;

        public static a a() {
            a aVar = new a();
            aVar.f34721a = b.f34723a;
            aVar.f34722b = b.f34724b;
            return aVar;
        }

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.f34721a = jSONObject.optInt("posIdWidth");
                this.f34722b = jSONObject.optInt("posIdHeight");
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "posIdWidth", this.f34721a);
            com.kwad.sdk.utils.o.a(jSONObject, "posIdHeight", this.f34722b);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f34723a;

        /* renamed from: b  reason: collision with root package name */
        public static int f34724b;

        public static void a(int i2) {
            f34723a = i2;
        }

        public static void b(int i2) {
            f34724b = i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public ReportAction(@NonNull com.kwad.sdk.core.report.a aVar) {
        AdTemplate adTemplate;
        long b2;
        this.I = -1;
        this.P = 0;
        this.Q = 0;
        this.f34718g = -1L;
        this.Y = 0;
        this.Z = 0;
        this.ae = 0;
        this.n = -1;
        this.az = new LiveLogInfo();
        this.v = -1;
        this.D = -1;
        this.E = -1;
        this.F = 0L;
        this.ap = 3;
        this.K = aVar.f34727c;
        this.f34772a = UUID.randomUUID().toString();
        this.G = System.currentTimeMillis();
        this.H = m.b();
        this.f34713b = m.c();
        this.J = m.f();
        this.S = aVar.a();
        this.U = aVar.f34728d;
        this.V = aVar.f34729e;
        this.W = aVar.f34730f;
        this.X = aVar.f34731g;
        this.f34715d = aVar.f34733i;
        this.f34716e = aVar.l;
        this.f34717f = aVar.m;
        this.f34718g = aVar.n;
        this.f34719h = aVar.j;
        this.Y = aVar.o;
        this.Z = aVar.p;
        this.ac = aVar.q;
        this.ad = aVar.r;
        this.ae = aVar.s;
        this.af = aVar.t;
        this.ag = aVar.u;
        this.ah = aVar.v;
        this.am = aVar.A;
        this.aj = aVar.x;
        this.ak = aVar.y;
        this.al = aVar.z;
        this.f34714c = aVar.f34732h;
        this.f34720i = aVar.B;
        this.j = aVar.G;
        this.ay = aVar.J;
        this.t = aVar.N;
        this.x = aVar.O;
        this.v = aVar.Q;
        this.u = aVar.P;
        this.z = aVar.R;
        this.aA = aVar.K;
        this.y = aVar.L;
        this.C = aVar.U;
        this.D = aVar.V;
        this.E = aVar.W;
        this.w = aVar.S;
        SceneImpl sceneImpl = aVar.f34726b;
        if (sceneImpl != null || ((adTemplate = aVar.f34725a) != null && (sceneImpl = adTemplate.mAdScene) != null)) {
            this.O = sceneImpl.getPosId();
            this.k = sceneImpl.getUrlPackage();
            this.I = sceneImpl.getAdStyle();
        }
        AdTemplate adTemplate2 = aVar.f34725a;
        if (adTemplate2 != null) {
            this.L = com.kwad.sdk.core.response.b.c.g(adTemplate2);
            String h2 = com.kwad.sdk.core.response.b.c.h(adTemplate2);
            if (!TextUtils.isEmpty(h2)) {
                try {
                    this.M = new JSONObject(h2);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            String i2 = com.kwad.sdk.core.response.b.c.i(adTemplate2);
            if (!TextUtils.isEmpty(i2)) {
                try {
                    this.N = new JSONObject(i2);
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.a.b(e3);
                }
            }
            this.O = com.kwad.sdk.core.response.b.c.e(adTemplate2);
            this.P = com.kwad.sdk.core.response.b.c.f(adTemplate2);
            int i3 = adTemplate2.realShowType;
            this.Q = i3;
            if (i3 == 1) {
                this.R = com.kwad.sdk.core.response.b.d.k(adTemplate2.photoInfo);
                this.T = com.kwad.sdk.core.response.b.d.c(adTemplate2.photoInfo).longValue();
                this.ab = com.kwad.sdk.core.response.b.d.o(adTemplate2.photoInfo);
                this.an = com.kwad.sdk.core.response.b.d.l(adTemplate2.photoInfo);
                this.aq = com.kwad.sdk.core.response.b.d.A(adTemplate2.photoInfo);
                this.ar = com.kwad.sdk.core.response.b.d.z(adTemplate2.photoInfo);
                this.as = com.kwad.sdk.core.response.b.d.B(adTemplate2.photoInfo);
                this.au = com.kwad.sdk.core.response.b.d.I(adTemplate2.photoInfo);
                this.at = com.kwad.sdk.core.response.b.d.J(adTemplate2.photoInfo);
                PreloadData preloadData = adTemplate2.mPreloadData;
                this.ax = preloadData != null ? preloadData.isPreload : 0;
            } else {
                if (i3 == 2) {
                    AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate2);
                    this.R = com.kwad.sdk.core.response.b.a.k(j);
                    this.s = j.adBaseInfo.creativeId;
                    this.T = com.kwad.sdk.core.response.b.a.b(j) * 1000;
                    b2 = j.advertiserInfo.userId;
                } else if (i3 == 4) {
                    LiveInfo A = com.kwad.sdk.core.response.b.c.A(adTemplate2);
                    this.az.liveStreamId = com.kwad.sdk.live.mode.a.a(A);
                    this.az.expTag = com.kwad.sdk.live.mode.a.c(A);
                    b2 = com.kwad.sdk.live.mode.a.b(A);
                }
                this.ab = b2;
            }
            this.m = adTemplate2.mMediaPlayerType;
            this.aw = adTemplate2.mIsLeftSlipStatus;
            this.p = adTemplate2.mPhotoResponseType;
            PageInfo pageInfo = adTemplate2.mPageInfo;
            if (pageInfo != null) {
                this.A = pageInfo.pageType;
            }
        }
        long j2 = aVar.C;
        if (j2 != -1) {
            this.au = j2;
        }
        if (!TextUtils.isEmpty(aVar.D)) {
            this.at = aVar.D;
        }
        int i4 = aVar.E;
        if (i4 != -1) {
            this.n = i4;
        }
        this.av = aVar.F;
        this.q = aVar.H;
        this.r = aVar.I;
        this.ao = a.a();
        this.o = aVar.M;
        this.B = aVar.T;
        if (!TextUtils.isEmpty(aVar.w)) {
            this.ai = aVar.w;
        }
        SceneImpl sceneImpl2 = aVar.f34726b;
        if (sceneImpl2 == null && adTemplate2 != null) {
            sceneImpl2 = adTemplate2.mAdScene;
        }
        if (sceneImpl2 != null) {
            this.O = sceneImpl2.getPosId();
            this.k = sceneImpl2.getUrlPackage();
        }
        if (this.k != null) {
            EntryPackage b3 = com.kwad.sdk.core.scene.a.a().b(this.k.identity);
            this.aa = b3.entryPageSource;
            this.ai = b3.entryId;
            this.l = com.kwad.sdk.core.scene.a.a().a(this.k.identity);
        }
        this.F = aVar.k;
    }

    public ReportAction(String str) {
        this.I = -1;
        this.P = 0;
        this.Q = 0;
        this.f34718g = -1L;
        this.Y = 0;
        this.Z = 0;
        this.ae = 0;
        this.n = -1;
        this.az = new LiveLogInfo();
        this.v = -1;
        this.D = -1;
        this.E = -1;
        this.F = 0L;
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public static ReportAction a(com.kwad.sdk.core.report.a aVar) {
        return new ReportAction(aVar);
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.ap = 3;
            this.K = jSONObject.optLong(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.G = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.H = jSONObject.optString("sessionId");
            }
            this.f34713b = jSONObject.optLong(IAdRequestParam.SEQ);
            this.J = jSONObject.optLong("listId");
            this.S = jSONObject.optLong("position");
            this.ai = jSONObject.optString("entryId");
            this.aj = jSONObject.optString("pushUrl");
            this.U = jSONObject.optLong("effectivePlayDuration");
            this.V = jSONObject.optLong("playDuration");
            this.W = jSONObject.optLong("startDuration");
            this.X = jSONObject.optLong("stayDuration");
            this.f34715d = jSONObject.optLong(AppLiveQosDebugInfo.LiveQosDebugInfo_blockDuration);
            this.f34716e = jSONObject.optLong("intervalDuration");
            this.f34717f = jSONObject.optLong("allIntervalDuration");
            this.f34718g = jSONObject.optLong("flowSdk", -1L);
            this.f34719h = jSONObject.optInt("blockTimes");
            this.Y = jSONObject.optInt("enterType");
            this.Z = jSONObject.optInt("leaveType");
            this.ac = jSONObject.optInt("likeStatus");
            this.ad = jSONObject.optInt("likeType");
            this.ae = jSONObject.optInt("shareResult");
            this.f34714c = jSONObject.optInt("stayLength");
            if (jSONObject.has("appInstalled")) {
                this.af = jSONObject.optJSONArray("appInstalled");
            }
            if (jSONObject.has("appUninstalled")) {
                this.ag = jSONObject.optJSONArray("appUninstalled");
            }
            if (jSONObject.has("coverUrl")) {
                this.ah = jSONObject.optString("coverUrl");
            }
            this.L = jSONObject.optLong("llsid");
            this.M = jSONObject.optJSONObject("extra");
            this.N = jSONObject.optJSONObject("impAdExtra");
            this.O = jSONObject.optLong("posId");
            this.I = jSONObject.optInt("adStyle", -1);
            this.P = jSONObject.optInt("contentType");
            this.Q = jSONObject.optInt("realShowType");
            this.R = jSONObject.optLong("photoId");
            this.T = jSONObject.optLong("photoDuration");
            this.ab = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
            this.aa = jSONObject.optString("entryPageSource");
            if (jSONObject.has("urlPackage")) {
                URLPackage uRLPackage = new URLPackage();
                this.k = uRLPackage;
                uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            }
            if (jSONObject.has("referURLPackage")) {
                URLPackage uRLPackage2 = new URLPackage();
                this.l = uRLPackage2;
                uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
            }
            this.ak = jSONObject.optLong("commentId");
            this.al = jSONObject.optLong("seenCount");
            this.am = jSONObject.optInt(PushConstants.CLICK_TYPE);
            if (jSONObject.has("recoExt")) {
                this.an = jSONObject.optString("recoExt");
            }
            if (jSONObject.has("clientExt")) {
                a aVar = new a();
                this.ao = aVar;
                aVar.a(jSONObject.optJSONObject("clientExt"));
            }
            this.m = jSONObject.optInt("playerType");
            this.f34720i = jSONObject.optString("tabName");
            this.aq = jSONObject.optString("tubeName");
            this.ar = jSONObject.optLong(URLPackage.KEY_TUBE_ID);
            this.as = jSONObject.optString("episodeName");
            this.au = jSONObject.optLong(URLPackage.KEY_TREND_ID);
            this.at = jSONObject.optString("trendName");
            this.ax = jSONObject.optInt("preloadType");
            if (jSONObject.has("preloadPhotoList")) {
                this.ay = jSONObject.optJSONArray("preloadPhotoList");
            }
            this.av = jSONObject.optInt("closeType");
            this.n = jSONObject.optInt("hotCompType", -1);
            this.j = jSONObject.optInt("nextPageType");
            this.az.parseJson(jSONObject.optJSONObject("liveLogInfo"));
            this.q = jSONObject.optString("failUrl");
            this.r = jSONObject.optString("errorMsg");
            this.s = jSONObject.optLong("creativeId");
            this.aw = jSONObject.optInt("isLeftSlipStatus");
            this.p = jSONObject.optInt("photoResponseType");
            this.o = jSONObject.optInt("refreshType");
            this.t = jSONObject.optString("moduleName");
            this.x = jSONObject.optString("componentPosition");
            this.v = jSONObject.optInt("num");
            this.u = jSONObject.optInt("state");
            this.aA = jSONObject.optJSONArray("appRunningInfoList");
            this.z = jSONObject.optLong(com.kwad.sdk.api.loader.ReportAction.KEY_DOWNLOAD_DURATION);
            this.A = jSONObject.optInt("pageType");
            this.B = jSONObject.optInt("guideTimes");
            this.C = jSONObject.optInt("speedLimitStatus");
            this.D = jSONObject.optInt("speedLimitThreshold");
            this.E = jSONObject.optInt("currentRealDownloadSpeed");
            this.y = jSONObject.optJSONObject("appExt");
            this.w = jSONObject.optString("cacheFailedReason");
            this.F = jSONObject.optLong("timeSpend");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        com.kwad.sdk.utils.o.a(json, "uiType", this.ap);
        com.kwad.sdk.utils.o.a(json, "timestamp", this.G);
        com.kwad.sdk.utils.o.a(json, "sessionId", this.H);
        com.kwad.sdk.utils.o.a(json, IAdRequestParam.SEQ, this.f34713b);
        com.kwad.sdk.utils.o.a(json, "listId", this.J);
        com.kwad.sdk.utils.o.a(json, "position", this.S);
        com.kwad.sdk.utils.o.a(json, "entryId", this.ai);
        com.kwad.sdk.utils.o.a(json, "pushUrl", this.aj);
        com.kwad.sdk.utils.o.a(json, LightInvokerImpl.VOICE_ACTIONTYPE, this.K);
        com.kwad.sdk.utils.o.a(json, "llsid", this.L);
        JSONObject jSONObject = this.M;
        if (jSONObject != null) {
            com.kwad.sdk.utils.o.a(json, "extra", jSONObject);
        }
        JSONObject jSONObject2 = this.N;
        if (jSONObject2 != null) {
            com.kwad.sdk.utils.o.a(json, "impAdExtra", jSONObject2);
        }
        com.kwad.sdk.utils.o.a(json, "posId", this.O);
        int i2 = this.I;
        if (i2 > 0) {
            com.kwad.sdk.utils.o.a(json, "adStyle", i2);
        }
        com.kwad.sdk.utils.o.a(json, "contentType", this.P);
        com.kwad.sdk.utils.o.a(json, "realShowType", this.Q);
        com.kwad.sdk.utils.o.a(json, "photoId", this.R);
        com.kwad.sdk.utils.o.a(json, "photoDuration", this.T);
        com.kwad.sdk.utils.o.a(json, "startDuration", this.W);
        com.kwad.sdk.utils.o.a(json, "playDuration", this.V);
        com.kwad.sdk.utils.o.a(json, "stayDuration", this.X);
        com.kwad.sdk.utils.o.a(json, "intervalDuration", this.f34716e);
        com.kwad.sdk.utils.o.a(json, "allIntervalDuration", this.f34717f);
        com.kwad.sdk.utils.o.a(json, "flowSdk", this.f34718g);
        com.kwad.sdk.utils.o.a(json, "effectivePlayDuration", this.U);
        com.kwad.sdk.utils.o.a(json, AppLiveQosDebugInfo.LiveQosDebugInfo_blockDuration, this.f34715d);
        com.kwad.sdk.utils.o.a(json, "blockTimes", this.f34719h);
        com.kwad.sdk.utils.o.a(json, "enterType", this.Y);
        com.kwad.sdk.utils.o.a(json, "leaveType", this.Z);
        com.kwad.sdk.utils.o.a(json, "entryPageSource", this.aa);
        URLPackage uRLPackage = this.k;
        if (uRLPackage != null) {
            com.kwad.sdk.utils.o.a(json, "urlPackage", uRLPackage.toJson());
        }
        URLPackage uRLPackage2 = this.l;
        if (uRLPackage2 != null) {
            com.kwad.sdk.utils.o.a(json, "referURLPackage", uRLPackage2.toJson());
        }
        com.kwad.sdk.utils.o.a(json, "stayLength", this.f34714c);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_AUTHOR_ID, this.ab);
        com.kwad.sdk.utils.o.a(json, "likeStatus", this.ac);
        com.kwad.sdk.utils.o.a(json, "likeType", this.ad);
        com.kwad.sdk.utils.o.a(json, "shareResult", this.ae);
        JSONArray jSONArray = this.af;
        if (jSONArray != null) {
            com.kwad.sdk.utils.o.a(json, "appInstalled", jSONArray);
        }
        JSONArray jSONArray2 = this.ag;
        if (jSONArray2 != null) {
            com.kwad.sdk.utils.o.a(json, "appUninstalled", jSONArray2);
        }
        if (!ag.a(this.q)) {
            com.kwad.sdk.utils.o.a(json, "failUrl", this.q);
        }
        if (!ag.a(this.r)) {
            com.kwad.sdk.utils.o.a(json, "errorMsg", this.r);
        }
        if (!ag.a(this.t)) {
            com.kwad.sdk.utils.o.a(json, "moduleName", this.t);
        }
        if (!ag.a(this.x)) {
            com.kwad.sdk.utils.o.a(json, "componentPosition", this.x);
        }
        int i3 = this.v;
        if (i3 > 0) {
            com.kwad.sdk.utils.o.a(json, "num", i3);
        }
        int i4 = this.u;
        if (i4 != 0) {
            com.kwad.sdk.utils.o.a(json, "state", i4);
        }
        if (!ag.a(this.w)) {
            com.kwad.sdk.utils.o.a(json, "cacheFailedReason", this.w);
        }
        com.kwad.sdk.utils.o.a(json, "coverUrl", this.ah);
        com.kwad.sdk.utils.o.a(json, "commentId", this.ak);
        com.kwad.sdk.utils.o.a(json, "seenCount", this.al);
        com.kwad.sdk.utils.o.a(json, PushConstants.CLICK_TYPE, this.am);
        com.kwad.sdk.utils.o.a(json, "recoExt", this.an);
        a aVar = this.ao;
        if (aVar != null) {
            com.kwad.sdk.utils.o.a(json, "clientExt", aVar);
        }
        com.kwad.sdk.utils.o.a(json, "playerType", this.m);
        com.kwad.sdk.utils.o.a(json, "tabName", this.f34720i);
        com.kwad.sdk.utils.o.a(json, "tubeName", this.aq);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_TUBE_ID, this.ar);
        com.kwad.sdk.utils.o.a(json, "episodeName", this.as);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_TREND_ID, this.au);
        com.kwad.sdk.utils.o.a(json, "trendName", this.at);
        com.kwad.sdk.utils.o.a(json, "preloadType", this.ax);
        JSONArray jSONArray3 = this.ay;
        if (jSONArray3 != null && jSONArray3.length() > 0) {
            com.kwad.sdk.utils.o.a(json, "preloadPhotoList", this.ay);
        }
        int i5 = this.n;
        if (i5 != -1) {
            com.kwad.sdk.utils.o.a(json, "hotCompType", i5);
        }
        com.kwad.sdk.utils.o.a(json, "closeType", this.av);
        com.kwad.sdk.utils.o.a(json, "nextPageType", this.j);
        com.kwad.sdk.utils.o.a(json, "liveLogInfo", this.az);
        com.kwad.sdk.utils.o.a(json, "creativeId", this.s);
        com.kwad.sdk.utils.o.a(json, "isLeftSlipStatus", this.aw);
        com.kwad.sdk.utils.o.a(json, "photoResponseType", this.p);
        com.kwad.sdk.utils.o.a(json, "refreshType", this.o);
        com.kwad.sdk.utils.o.a(json, "appRunningInfoList", this.aA);
        JSONObject jSONObject3 = this.y;
        if (jSONObject3 != null) {
            com.kwad.sdk.utils.o.a(json, "appExt", jSONObject3);
        }
        com.kwad.sdk.utils.o.a(json, com.kwad.sdk.api.loader.ReportAction.KEY_DOWNLOAD_DURATION, this.z);
        com.kwad.sdk.utils.o.a(json, "pageType", this.A);
        com.kwad.sdk.utils.o.a(json, "guideTimes", this.B);
        com.kwad.sdk.utils.o.a(json, "speedLimitStatus", this.C);
        com.kwad.sdk.utils.o.a(json, "speedLimitThreshold", this.D);
        com.kwad.sdk.utils.o.a(json, "currentRealDownloadSpeed", this.E);
        long j = this.F;
        if (j > 0) {
            com.kwad.sdk.utils.o.a(json, "timeSpend", j);
        }
        return json;
    }

    @NonNull
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[actionType:");
        stringBuffer.append(this.K);
        stringBuffer.append(",moduleName:");
        stringBuffer.append(this.t);
        stringBuffer.append(",componentPosition:");
        stringBuffer.append(this.x);
        stringBuffer.append(",tubeId:");
        stringBuffer.append(this.ar);
        stringBuffer.append(",entryId:");
        stringBuffer.append(this.ai);
        stringBuffer.append(",blockDuration:");
        stringBuffer.append(this.f34715d);
        stringBuffer.append(",blockTimes:");
        stringBuffer.append(this.f34719h);
        stringBuffer.append(",intervalDuration:");
        stringBuffer.append(this.f34716e);
        stringBuffer.append(",allIntervalDuration:");
        stringBuffer.append(this.f34717f);
        stringBuffer.append(",flowSdk:");
        stringBuffer.append(this.f34718g);
        stringBuffer.append(",trendId:");
        stringBuffer.append(this.au);
        stringBuffer.append(",trendName:");
        stringBuffer.append(this.at);
        stringBuffer.append(",tubeName:");
        stringBuffer.append(this.aq);
        stringBuffer.append(",episodeName:");
        stringBuffer.append(this.as);
        stringBuffer.append(",seq:");
        stringBuffer.append(this.f34713b);
        stringBuffer.append(",extra:");
        stringBuffer.append(this.M);
        stringBuffer.append(",impAdExtra:");
        stringBuffer.append(this.N);
        stringBuffer.append(",actionId:");
        stringBuffer.append(this.f34772a);
        stringBuffer.append(",position:");
        stringBuffer.append(this.S);
        stringBuffer.append(",contentType:");
        stringBuffer.append(this.P);
        stringBuffer.append(",playerType:");
        stringBuffer.append(this.m);
        stringBuffer.append(",preloadType:");
        stringBuffer.append(this.ax);
        stringBuffer.append(",realShowType:");
        stringBuffer.append(this.Q);
        stringBuffer.append(",photoDuration:");
        stringBuffer.append(this.T);
        stringBuffer.append(",startDuration:");
        stringBuffer.append(this.W);
        stringBuffer.append(",playDuration:");
        stringBuffer.append(this.V);
        stringBuffer.append(",stayDuration:");
        stringBuffer.append(this.X);
        stringBuffer.append(",enterType:");
        stringBuffer.append(this.Y);
        stringBuffer.append(",entryPageSource:");
        stringBuffer.append(this.aa);
        stringBuffer.append(",stayLength:");
        stringBuffer.append(this.f34714c);
        if (this.n != -1) {
            stringBuffer.append(",hotCompType:");
            stringBuffer.append(this.n);
        }
        if (this.k != null) {
            stringBuffer.append(",urlPackage:");
            stringBuffer.append(this.k.page);
        }
        if (this.l != null) {
            stringBuffer.append(",referPage:");
            stringBuffer.append(this.l.page);
        }
        if (this.v > -1) {
            stringBuffer.append(",num:");
            stringBuffer.append(this.v);
        }
        if (this.u != 0) {
            stringBuffer.append(",state:");
            stringBuffer.append(this.u);
        }
        if (this.y != null) {
            stringBuffer.append(",appExt:");
            stringBuffer.append(this.y);
        }
        if (this.F > 0) {
            stringBuffer.append(",timeSpend:");
            stringBuffer.append(this.F);
        }
        stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
        return stringBuffer.toString();
    }
}

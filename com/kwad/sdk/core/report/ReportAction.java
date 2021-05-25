package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ReportAction extends d {
    public static int Y;
    public String A;
    public String B;
    public int C;
    public long D;
    public String E;
    public int F;
    public int G;
    public String H;
    public String I;
    public JSONObject J;
    public long K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public long Q;
    public JSONArray R;
    public boolean S;
    public String T;
    public int U;
    public int V;
    public int W;
    public String X;
    public long Z;
    public int aA;
    public JSONArray aB;
    public JSONArray aC;
    public String aD;
    public String aE;
    public String aF;
    public long aG;
    public long aH;
    public int aI;
    public String aJ;
    public a aK;
    public int aL;
    public String aM;
    public long aN;
    public String aO;
    public String aP;
    public long aQ;
    public int aR;
    public int aS;
    public int aT;
    public JSONArray aU;
    public LiveLogInfo aV;
    public JSONArray aW;
    public long aa;
    public JSONArray ab;
    public long ac;
    public String ad;
    public int ae;
    public long af;
    public long ag;
    public long ah;
    public JSONObject ai;
    public JSONObject aj;
    public long ak;
    public int al;
    public int am;
    public long an;
    public long ao;
    public long ap;
    public long aq;
    public long ar;
    public long as;
    public long at;
    public int au;
    public int av;
    public String aw;
    public long ax;
    public int ay;
    public int az;

    /* renamed from: b  reason: collision with root package name */
    public long f32526b;

    /* renamed from: c  reason: collision with root package name */
    public long f32527c;

    /* renamed from: d  reason: collision with root package name */
    public long f32528d;

    /* renamed from: e  reason: collision with root package name */
    public long f32529e;

    /* renamed from: f  reason: collision with root package name */
    public long f32530f;

    /* renamed from: g  reason: collision with root package name */
    public long f32531g;

    /* renamed from: h  reason: collision with root package name */
    public long f32532h;

    /* renamed from: i  reason: collision with root package name */
    public String f32533i;
    public int j;
    public int k;
    public int l;
    public URLPackage m;
    public URLPackage n;
    public String o;
    public int p;
    public int q;
    public long r;
    public long s;
    public int t;
    public String u;
    public int v;
    public long w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f32534a;

        /* renamed from: b  reason: collision with root package name */
        public int f32535b;

        public static a a() {
            a aVar = new a();
            aVar.f32534a = b.f32536a;
            aVar.f32535b = b.f32537b;
            return aVar;
        }

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.f32534a = jSONObject.optInt("posIdWidth");
                this.f32535b = jSONObject.optInt("posIdHeight");
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "posIdWidth", this.f32534a);
            com.kwad.sdk.utils.o.a(jSONObject, "posIdHeight", this.f32535b);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f32536a;

        /* renamed from: b  reason: collision with root package name */
        public static int f32537b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v27, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public ReportAction(@NonNull com.kwad.sdk.core.report.a aVar) {
        AdTemplate adTemplate;
        long b2;
        this.ae = -1;
        this.al = 0;
        this.am = 0;
        this.f32531g = -1L;
        this.au = 0;
        this.av = 0;
        this.l = -1;
        this.t = -1;
        this.aA = 0;
        this.u = "";
        this.w = -1L;
        this.x = -1;
        this.aV = new LiveLogInfo();
        this.G = -1;
        this.O = -1;
        this.P = -1;
        this.Q = 0L;
        this.U = 0;
        this.V = -1;
        this.W = 0;
        this.aL = 3;
        this.U = Y;
        this.ag = aVar.f32540c;
        this.f32583a = UUID.randomUUID().toString();
        this.ac = System.currentTimeMillis();
        this.ad = m.b();
        this.f32526b = m.c();
        this.af = m.e();
        this.ao = aVar.a();
        this.aq = aVar.f32541d;
        this.ar = aVar.f32542e;
        this.as = aVar.f32543f;
        this.at = aVar.f32544g;
        this.f32528d = aVar.f32546i;
        this.f32529e = aVar.l;
        this.f32530f = aVar.m;
        this.f32531g = aVar.n;
        this.f32532h = aVar.j;
        this.au = aVar.o;
        this.l = aVar.q;
        this.o = aVar.r;
        this.p = aVar.s;
        this.q = aVar.t;
        this.r = aVar.u;
        this.s = aVar.v;
        this.av = aVar.p;
        this.ay = aVar.w;
        this.az = aVar.x;
        this.t = aVar.y;
        this.aA = aVar.z;
        this.aB = aVar.A;
        this.aC = aVar.B;
        this.aD = aVar.C;
        this.u = aVar.D;
        this.aI = aVar.I;
        this.aF = aVar.F;
        this.aG = aVar.G;
        this.aH = aVar.H;
        this.f32527c = aVar.f32545h;
        this.f32533i = aVar.J;
        this.j = aVar.P;
        this.aU = aVar.T;
        this.E = aVar.X;
        this.I = aVar.Y;
        this.G = aVar.aa;
        this.F = aVar.Z;
        this.K = aVar.ab;
        this.aW = aVar.U;
        this.J = aVar.V;
        this.N = aVar.ae;
        this.O = aVar.af;
        this.P = aVar.ag;
        this.H = aVar.ac;
        SceneImpl sceneImpl = aVar.f32539b;
        if (sceneImpl != null || ((adTemplate = aVar.f32538a) != null && (sceneImpl = adTemplate.mAdScene) != null)) {
            this.ak = sceneImpl.getPosId();
            this.m = sceneImpl.getUrlPackage();
            this.ae = sceneImpl.getAdStyle();
        }
        AdTemplate adTemplate2 = aVar.f32538a;
        if (adTemplate2 != null) {
            this.ah = com.kwad.sdk.core.response.b.c.d(adTemplate2);
            String e2 = com.kwad.sdk.core.response.b.c.e(adTemplate2);
            if (!TextUtils.isEmpty(e2)) {
                try {
                    this.ai = new JSONObject(e2);
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.a.b(e3);
                }
            }
            String f2 = com.kwad.sdk.core.response.b.c.f(adTemplate2);
            if (!TextUtils.isEmpty(f2)) {
                try {
                    this.aj = new JSONObject(f2);
                } catch (Exception e4) {
                    com.kwad.sdk.core.d.a.b(e4);
                }
            }
            this.ak = com.kwad.sdk.core.response.b.c.b(adTemplate2);
            this.al = com.kwad.sdk.core.response.b.c.c(adTemplate2);
            int i2 = adTemplate2.realShowType;
            this.am = i2;
            if (i2 == 1) {
                this.an = com.kwad.sdk.core.response.b.d.d(adTemplate2.photoInfo);
                this.ap = com.kwad.sdk.core.response.b.d.c(adTemplate2.photoInfo).longValue();
                this.ax = com.kwad.sdk.core.response.b.d.f(adTemplate2.photoInfo);
                this.aJ = com.kwad.sdk.core.response.b.d.e(adTemplate2.photoInfo);
                this.aM = com.kwad.sdk.core.response.b.d.h(adTemplate2.photoInfo);
                this.aN = com.kwad.sdk.core.response.b.d.g(adTemplate2.photoInfo);
                this.aO = com.kwad.sdk.core.response.b.d.i(adTemplate2.photoInfo);
                this.aQ = com.kwad.sdk.core.response.b.d.j(adTemplate2.photoInfo);
                this.aP = com.kwad.sdk.core.response.b.d.k(adTemplate2.photoInfo);
                PreloadData preloadData = adTemplate2.mPreloadData;
                this.aT = preloadData != null ? preloadData.isPreload : 0;
            } else {
                if (i2 == 2) {
                    AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate2);
                    this.an = com.kwad.sdk.core.response.b.a.i(g2);
                    this.D = g2.adBaseInfo.creativeId;
                    this.ap = com.kwad.sdk.core.response.b.a.b(g2) * 1000;
                    b2 = g2.advertiserInfo.userId;
                } else if (i2 == 4) {
                    LiveInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate2);
                    this.aV.liveStreamId = com.kwad.sdk.live.mode.a.a(j);
                    this.aV.expTag = com.kwad.sdk.live.mode.a.c(j);
                    b2 = com.kwad.sdk.live.mode.a.b(j);
                }
                this.ax = b2;
            }
            this.v = adTemplate2.mMediaPlayerType;
            this.aS = adTemplate2.mIsLeftSlipStatus;
            this.z = adTemplate2.mPhotoResponseType;
            PageInfo pageInfo = adTemplate2.mPageInfo;
            if (pageInfo != null) {
                this.L = pageInfo.pageType;
            }
            this.k = com.kwad.sdk.core.response.b.c.h(adTemplate2).baseInfo.contentSourceType;
        }
        long j2 = aVar.K;
        if (j2 != -1) {
            this.aQ = j2;
        }
        long j3 = aVar.M;
        if (j3 != -1) {
            this.w = j3;
        }
        if (!TextUtils.isEmpty(aVar.L)) {
            this.aP = aVar.L;
        }
        int i3 = aVar.N;
        if (i3 != -1) {
            this.x = i3;
        }
        this.aR = aVar.O;
        this.A = aVar.Q;
        this.B = aVar.R;
        this.C = aVar.S;
        this.aK = a.a();
        this.y = aVar.W;
        this.M = aVar.ad;
        if (!TextUtils.isEmpty(aVar.E)) {
            this.aE = aVar.E;
        }
        SceneImpl sceneImpl2 = aVar.f32539b;
        if (sceneImpl2 == null && adTemplate2 != null) {
            sceneImpl2 = adTemplate2.mAdScene;
        }
        if (sceneImpl2 != null) {
            this.ak = sceneImpl2.getPosId();
            this.m = sceneImpl2.getUrlPackage();
        }
        if (this.m != null) {
            EntryPackage b3 = com.kwad.sdk.core.scene.a.a().b(this.m.identity);
            this.aw = b3.entryPageSource;
            this.aE = b3.entryId;
            this.n = com.kwad.sdk.core.scene.a.a().a(this.m.identity);
        }
        this.Q = aVar.k;
        this.R = aVar.ah;
        this.S = aVar.ai;
        this.T = aVar.ak;
        this.W = aVar.al;
        this.Z = aVar.am;
        this.aa = aVar.an;
        this.ab = aVar.ao;
        this.X = aVar.ap;
        this.V = aVar.aj;
    }

    public ReportAction(String str) {
        this.ae = -1;
        this.al = 0;
        this.am = 0;
        this.f32531g = -1L;
        this.au = 0;
        this.av = 0;
        this.l = -1;
        this.t = -1;
        this.aA = 0;
        this.u = "";
        this.w = -1L;
        this.x = -1;
        this.aV = new LiveLogInfo();
        this.G = -1;
        this.O = -1;
        this.P = -1;
        this.Q = 0L;
        this.U = 0;
        this.V = -1;
        this.W = 0;
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
            this.aL = 3;
            this.U = jSONObject.optInt("viewModeType");
            this.ag = jSONObject.optLong(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.ac = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.ad = jSONObject.optString("sessionId");
            }
            this.f32526b = jSONObject.optLong(IAdRequestParam.SEQ);
            this.af = jSONObject.optLong("listId");
            this.ao = jSONObject.optLong("position");
            this.aE = jSONObject.optString("entryId");
            this.aF = jSONObject.optString("pushUrl");
            this.aq = jSONObject.optLong("effectivePlayDuration");
            this.ar = jSONObject.optLong("playDuration");
            this.as = jSONObject.optLong("startDuration");
            this.at = jSONObject.optLong("stayDuration");
            this.f32528d = jSONObject.optLong("blockDuration");
            this.f32529e = jSONObject.optLong("intervalDuration");
            this.f32530f = jSONObject.optLong("allIntervalDuration");
            this.f32531g = jSONObject.optLong("flowSdk", -1L);
            this.f32532h = jSONObject.optInt("blockTimes");
            this.au = jSONObject.optInt("enterType");
            this.l = jSONObject.optInt("playerControlledType", -1);
            this.o = jSONObject.optString("photoSize");
            this.av = jSONObject.optInt("leaveType");
            this.ay = jSONObject.optInt("likeStatus");
            this.p = jSONObject.optInt("playEnd");
            this.q = jSONObject.optInt("dragProgressType");
            this.r = jSONObject.optInt("dragProgressPhotoDuration");
            this.s = jSONObject.optInt("dragProgressVideoTime");
            this.az = jSONObject.optInt("likeType");
            this.t = jSONObject.optInt("reportType");
            this.aA = jSONObject.optInt("shareResult");
            this.f32527c = jSONObject.optInt("stayLength");
            if (jSONObject.has("appInstalled")) {
                this.aB = jSONObject.optJSONArray("appInstalled");
            }
            if (jSONObject.has("appUninstalled")) {
                this.aC = jSONObject.optJSONArray("appUninstalled");
            }
            if (jSONObject.has("coverUrl")) {
                this.aD = jSONObject.optString("coverUrl");
            }
            if (jSONObject.has("videoCurrentUrl")) {
                this.u = jSONObject.optString("videoCurrentUrl");
            }
            this.ah = jSONObject.optLong("llsid");
            this.ai = jSONObject.optJSONObject("extra");
            this.aj = jSONObject.optJSONObject("impAdExtra");
            this.ak = jSONObject.optLong("posId");
            this.ae = jSONObject.optInt("adStyle", -1);
            this.al = jSONObject.optInt("contentType");
            this.am = jSONObject.optInt("realShowType");
            this.an = jSONObject.optLong("photoId");
            this.ap = jSONObject.optLong("photoDuration");
            this.ax = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
            this.aw = jSONObject.optString("entryPageSource");
            if (jSONObject.has("urlPackage")) {
                URLPackage uRLPackage = new URLPackage();
                this.m = uRLPackage;
                uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            }
            if (jSONObject.has("referURLPackage")) {
                URLPackage uRLPackage2 = new URLPackage();
                this.n = uRLPackage2;
                uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
            }
            this.aG = jSONObject.optLong("commentId");
            this.aH = jSONObject.optLong("seenCount");
            this.aI = jSONObject.optInt(PushConstants.CLICK_TYPE);
            if (jSONObject.has("recoExt")) {
                this.aJ = jSONObject.optString("recoExt");
            }
            if (jSONObject.has("clientExt")) {
                a aVar = new a();
                this.aK = aVar;
                aVar.a(jSONObject.optJSONObject("clientExt"));
            }
            this.v = jSONObject.optInt("playerType");
            this.f32533i = jSONObject.optString("tabName");
            this.aM = jSONObject.optString("tubeName");
            this.aN = jSONObject.optLong(URLPackage.KEY_TUBE_ID);
            this.aO = jSONObject.optString("episodeName");
            this.aQ = jSONObject.optLong(URLPackage.KEY_TREND_ID);
            this.aP = jSONObject.optString("trendName");
            this.w = jSONObject.optLong("relatedFromPhotoId", -1L);
            this.aT = jSONObject.optInt("preloadType");
            if (jSONObject.has("preloadPhotoList")) {
                this.aU = jSONObject.optJSONArray("preloadPhotoList");
            }
            this.aR = jSONObject.optInt("closeType");
            this.x = jSONObject.optInt("hotCompType", -1);
            this.j = jSONObject.optInt("nextPageType");
            this.k = jSONObject.optInt("contentSourceType");
            this.aV.parseJson(jSONObject.optJSONObject("liveLogInfo"));
            this.A = jSONObject.optString("failUrl");
            this.B = jSONObject.optString("errorMsg");
            this.C = jSONObject.optInt("errorCode");
            this.D = jSONObject.optLong("creativeId");
            this.aS = jSONObject.optInt("isLeftSlipStatus");
            this.z = jSONObject.optInt("photoResponseType");
            this.y = jSONObject.optInt("refreshType");
            this.E = jSONObject.optString("moduleName");
            this.I = jSONObject.optString("componentPosition");
            this.G = jSONObject.optInt("num");
            this.F = jSONObject.optInt("state");
            this.aW = jSONObject.optJSONArray("appRunningInfoList");
            this.K = jSONObject.optLong(com.kwad.sdk.api.loader.ReportAction.KEY_DOWNLOAD_DURATION);
            this.L = jSONObject.optInt("pageType");
            this.M = jSONObject.optInt("guideTimes");
            this.N = jSONObject.optInt("speedLimitStatus");
            this.O = jSONObject.optInt("speedLimitThreshold");
            this.P = jSONObject.optInt("currentRealDownloadSpeed");
            this.J = jSONObject.optJSONObject("appExt");
            this.H = jSONObject.optString("cacheFailedReason");
            this.Q = jSONObject.optLong("timeSpend");
            this.R = jSONObject.optJSONArray("sdkPlatform");
            this.S = jSONObject.optBoolean("isKsUnion");
            this.T = jSONObject.optString("trackMethodName");
            this.W = jSONObject.optInt("playAgainControlledType", 0);
            this.Z = jSONObject.optLong("loadingDuration");
            this.aa = jSONObject.optLong("loadingDurationLimt");
            this.ab = jSONObject.optJSONArray("appAuthorityInfoList");
            this.X = jSONObject.optString("mediaShareStr");
            this.V = jSONObject.optInt("playerTypeInfo", -1);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        com.kwad.sdk.utils.o.a(json, "uiType", this.aL);
        com.kwad.sdk.utils.o.a(json, "timestamp", this.ac);
        com.kwad.sdk.utils.o.a(json, "sessionId", this.ad);
        com.kwad.sdk.utils.o.a(json, IAdRequestParam.SEQ, this.f32526b);
        com.kwad.sdk.utils.o.a(json, "listId", this.af);
        com.kwad.sdk.utils.o.a(json, "position", this.ao);
        com.kwad.sdk.utils.o.a(json, "entryId", this.aE);
        com.kwad.sdk.utils.o.a(json, "pushUrl", this.aF);
        com.kwad.sdk.utils.o.a(json, "viewModeType", this.U);
        com.kwad.sdk.utils.o.a(json, LightInvokerImpl.VOICE_ACTIONTYPE, this.ag);
        com.kwad.sdk.utils.o.a(json, "llsid", this.ah);
        JSONObject jSONObject = this.ai;
        if (jSONObject != null) {
            com.kwad.sdk.utils.o.a(json, "extra", jSONObject);
        }
        JSONObject jSONObject2 = this.aj;
        if (jSONObject2 != null) {
            com.kwad.sdk.utils.o.a(json, "impAdExtra", jSONObject2);
        }
        com.kwad.sdk.utils.o.a(json, "posId", this.ak);
        int i2 = this.ae;
        if (i2 > 0) {
            com.kwad.sdk.utils.o.a(json, "adStyle", i2);
        }
        com.kwad.sdk.utils.o.a(json, "contentType", this.al);
        com.kwad.sdk.utils.o.a(json, "realShowType", this.am);
        com.kwad.sdk.utils.o.a(json, "photoId", this.an);
        com.kwad.sdk.utils.o.a(json, "photoDuration", this.ap);
        com.kwad.sdk.utils.o.a(json, "startDuration", this.as);
        com.kwad.sdk.utils.o.a(json, "playDuration", this.ar);
        com.kwad.sdk.utils.o.a(json, "stayDuration", this.at);
        com.kwad.sdk.utils.o.a(json, "intervalDuration", this.f32529e);
        com.kwad.sdk.utils.o.a(json, "allIntervalDuration", this.f32530f);
        com.kwad.sdk.utils.o.a(json, "flowSdk", this.f32531g);
        com.kwad.sdk.utils.o.a(json, "effectivePlayDuration", this.aq);
        com.kwad.sdk.utils.o.a(json, "blockDuration", this.f32528d);
        com.kwad.sdk.utils.o.a(json, "blockTimes", this.f32532h);
        com.kwad.sdk.utils.o.a(json, "enterType", this.au);
        com.kwad.sdk.utils.o.a(json, "leaveType", this.av);
        com.kwad.sdk.utils.o.a(json, "entryPageSource", this.aw);
        int i3 = this.t;
        if (i3 != -1) {
            com.kwad.sdk.utils.o.a(json, "reportType", i3);
        }
        int i4 = this.l;
        if (i4 != -1) {
            com.kwad.sdk.utils.o.a(json, "playerControlledType", i4);
        }
        URLPackage uRLPackage = this.m;
        if (uRLPackage != null) {
            com.kwad.sdk.utils.o.a(json, "urlPackage", uRLPackage.toJson());
        }
        URLPackage uRLPackage2 = this.n;
        if (uRLPackage2 != null) {
            com.kwad.sdk.utils.o.a(json, "referURLPackage", uRLPackage2.toJson());
        }
        com.kwad.sdk.utils.o.a(json, "stayLength", this.f32527c);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_AUTHOR_ID, this.ax);
        com.kwad.sdk.utils.o.a(json, "likeStatus", this.ay);
        com.kwad.sdk.utils.o.a(json, "playEnd", this.p);
        com.kwad.sdk.utils.o.a(json, "dragProgressType", this.q);
        com.kwad.sdk.utils.o.a(json, "dragProgressPhotoDuration", this.r);
        com.kwad.sdk.utils.o.a(json, "dragProgressVideoTime", this.s);
        com.kwad.sdk.utils.o.a(json, "likeType", this.az);
        com.kwad.sdk.utils.o.a(json, "shareResult", this.aA);
        JSONArray jSONArray = this.aB;
        if (jSONArray != null) {
            com.kwad.sdk.utils.o.a(json, "appInstalled", jSONArray);
        }
        JSONArray jSONArray2 = this.aC;
        if (jSONArray2 != null) {
            com.kwad.sdk.utils.o.a(json, "appUninstalled", jSONArray2);
        }
        if (!ag.a(this.A)) {
            com.kwad.sdk.utils.o.a(json, "failUrl", this.A);
        }
        if (!ag.a(this.o)) {
            com.kwad.sdk.utils.o.a(json, "photoSize", this.o);
        }
        if (!ag.a(this.B)) {
            com.kwad.sdk.utils.o.a(json, "errorMsg", this.B);
        }
        com.kwad.sdk.utils.o.a(json, "errorCode", this.C);
        if (!ag.a(this.E)) {
            com.kwad.sdk.utils.o.a(json, "moduleName", this.E);
        }
        if (!ag.a(this.I)) {
            com.kwad.sdk.utils.o.a(json, "componentPosition", this.I);
        }
        int i5 = this.G;
        if (i5 > 0) {
            com.kwad.sdk.utils.o.a(json, "num", i5);
        }
        int i6 = this.F;
        if (i6 != 0) {
            com.kwad.sdk.utils.o.a(json, "state", i6);
        }
        if (!ag.a(this.H)) {
            com.kwad.sdk.utils.o.a(json, "cacheFailedReason", this.H);
        }
        com.kwad.sdk.utils.o.a(json, "coverUrl", this.aD);
        if (!ag.a(this.u)) {
            com.kwad.sdk.utils.o.a(json, "videoCurrentUrl", this.u);
        }
        com.kwad.sdk.utils.o.a(json, "commentId", this.aG);
        com.kwad.sdk.utils.o.a(json, "seenCount", this.aH);
        com.kwad.sdk.utils.o.a(json, PushConstants.CLICK_TYPE, this.aI);
        com.kwad.sdk.utils.o.a(json, "recoExt", this.aJ);
        a aVar = this.aK;
        if (aVar != null) {
            com.kwad.sdk.utils.o.a(json, "clientExt", aVar);
        }
        com.kwad.sdk.utils.o.a(json, "playerType", this.v);
        com.kwad.sdk.utils.o.a(json, "tabName", this.f32533i);
        com.kwad.sdk.utils.o.a(json, "tubeName", this.aM);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_TUBE_ID, this.aN);
        com.kwad.sdk.utils.o.a(json, "episodeName", this.aO);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_TREND_ID, this.aQ);
        com.kwad.sdk.utils.o.a(json, "trendName", this.aP);
        long j = this.w;
        if (j != -1) {
            com.kwad.sdk.utils.o.a(json, "relatedFromPhotoId", j);
        }
        com.kwad.sdk.utils.o.a(json, "preloadType", this.aT);
        JSONArray jSONArray3 = this.aU;
        if (jSONArray3 != null && jSONArray3.length() > 0) {
            com.kwad.sdk.utils.o.a(json, "preloadPhotoList", this.aU);
        }
        int i7 = this.x;
        if (i7 != -1) {
            com.kwad.sdk.utils.o.a(json, "hotCompType", i7);
        }
        com.kwad.sdk.utils.o.a(json, "closeType", this.aR);
        com.kwad.sdk.utils.o.a(json, "nextPageType", this.j);
        com.kwad.sdk.utils.o.a(json, "contentSourceType", this.k);
        com.kwad.sdk.utils.o.a(json, "liveLogInfo", this.aV);
        com.kwad.sdk.utils.o.a(json, "creativeId", this.D);
        com.kwad.sdk.utils.o.a(json, "isLeftSlipStatus", this.aS);
        com.kwad.sdk.utils.o.a(json, "photoResponseType", this.z);
        com.kwad.sdk.utils.o.a(json, "refreshType", this.y);
        com.kwad.sdk.utils.o.a(json, "appRunningInfoList", this.aW);
        JSONObject jSONObject3 = this.J;
        if (jSONObject3 != null) {
            com.kwad.sdk.utils.o.a(json, "appExt", jSONObject3);
        }
        com.kwad.sdk.utils.o.a(json, com.kwad.sdk.api.loader.ReportAction.KEY_DOWNLOAD_DURATION, this.K);
        com.kwad.sdk.utils.o.a(json, "pageType", this.L);
        com.kwad.sdk.utils.o.a(json, "guideTimes", this.M);
        com.kwad.sdk.utils.o.a(json, "speedLimitStatus", this.N);
        com.kwad.sdk.utils.o.a(json, "speedLimitThreshold", this.O);
        com.kwad.sdk.utils.o.a(json, "currentRealDownloadSpeed", this.P);
        long j2 = this.Q;
        if (j2 > 0) {
            com.kwad.sdk.utils.o.a(json, "timeSpend", j2);
        }
        JSONArray jSONArray4 = this.R;
        if (jSONArray4 != null) {
            com.kwad.sdk.utils.o.a(json, "sdkPlatform", jSONArray4);
        }
        com.kwad.sdk.utils.o.a(json, "isKsUnion", this.S);
        com.kwad.sdk.utils.o.a(json, "trackMethodName", this.T);
        com.kwad.sdk.utils.o.a(json, "playAgainControlledType", this.W);
        long j3 = this.Z;
        if (j3 > 0) {
            com.kwad.sdk.utils.o.a(json, "loadingDuration", j3);
        }
        long j4 = this.aa;
        if (j4 > 0) {
            com.kwad.sdk.utils.o.a(json, "loadingDurationLimt", j4);
        }
        JSONArray jSONArray5 = this.ab;
        if (jSONArray5 != null) {
            com.kwad.sdk.utils.o.a(json, "appAuthorityInfoList", jSONArray5);
        }
        com.kwad.sdk.utils.o.a(json, "mediaShareStr", this.X);
        com.kwad.sdk.utils.o.a(json, "playerTypeInfo", this.V);
        return json;
    }

    @NonNull
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[actionType:");
        stringBuffer.append(this.ag);
        stringBuffer.append(",viewModeType:");
        stringBuffer.append(this.U);
        stringBuffer.append(",moduleName:");
        stringBuffer.append(this.E);
        stringBuffer.append(",componentPosition:");
        stringBuffer.append(this.I);
        stringBuffer.append(",tubeId:");
        stringBuffer.append(this.aN);
        stringBuffer.append(",entryId:");
        stringBuffer.append(this.aE);
        stringBuffer.append(",blockDuration:");
        stringBuffer.append(this.f32528d);
        stringBuffer.append(",blockTimes:");
        stringBuffer.append(this.f32532h);
        stringBuffer.append(",intervalDuration:");
        stringBuffer.append(this.f32529e);
        stringBuffer.append(",allIntervalDuration:");
        stringBuffer.append(this.f32530f);
        stringBuffer.append(",flowSdk:");
        stringBuffer.append(this.f32531g);
        stringBuffer.append(",playEnd:");
        stringBuffer.append(this.p);
        stringBuffer.append(",dragProgressType:");
        stringBuffer.append(this.q);
        stringBuffer.append(",dragProgressPhotoDuration:");
        stringBuffer.append(this.r);
        stringBuffer.append(",dragProgressVideoTime:");
        stringBuffer.append(this.s);
        stringBuffer.append(",contentSourceType:");
        stringBuffer.append(this.k);
        stringBuffer.append(",trendId:");
        stringBuffer.append(this.aQ);
        stringBuffer.append(",trendName:");
        stringBuffer.append(this.aP);
        stringBuffer.append(",tubeName:");
        stringBuffer.append(this.aM);
        stringBuffer.append(",episodeName:");
        stringBuffer.append(this.aO);
        stringBuffer.append(",seq:");
        stringBuffer.append(this.f32526b);
        stringBuffer.append(",extra:");
        stringBuffer.append(this.ai);
        stringBuffer.append(",impAdExtra:");
        stringBuffer.append(this.aj);
        stringBuffer.append(",actionId:");
        stringBuffer.append(this.f32583a);
        stringBuffer.append(",position:");
        stringBuffer.append(this.ao);
        stringBuffer.append(",contentType:");
        stringBuffer.append(this.al);
        stringBuffer.append(",playerType:");
        stringBuffer.append(this.v);
        stringBuffer.append(",preloadType:");
        stringBuffer.append(this.aT);
        stringBuffer.append(",realShowType:");
        stringBuffer.append(this.am);
        stringBuffer.append(",photoDuration:");
        stringBuffer.append(this.ap);
        stringBuffer.append(",startDuration:");
        stringBuffer.append(this.as);
        stringBuffer.append(",playDuration:");
        stringBuffer.append(this.ar);
        stringBuffer.append(",stayDuration:");
        stringBuffer.append(this.at);
        stringBuffer.append(",enterType:");
        stringBuffer.append(this.au);
        stringBuffer.append(",entryPageSource:");
        stringBuffer.append(this.aw);
        stringBuffer.append(",stayLength:");
        stringBuffer.append(this.f32527c);
        if (this.x != -1) {
            stringBuffer.append(",hotCompType:");
            stringBuffer.append(this.x);
        }
        if (this.l != -1) {
            stringBuffer.append(",playerControlledType:");
            stringBuffer.append(this.l);
        }
        if (this.t != -1) {
            stringBuffer.append(",reportType:");
            stringBuffer.append(this.t);
        }
        if (this.m != null) {
            stringBuffer.append(",urlPackage:");
            stringBuffer.append(this.m.page);
        }
        if (this.n != null) {
            stringBuffer.append(",referPage:");
            stringBuffer.append(this.n.page);
        }
        if (this.G > -1) {
            stringBuffer.append(",num:");
            stringBuffer.append(this.G);
        }
        if (this.F != 0) {
            stringBuffer.append(",state:");
            stringBuffer.append(this.F);
        }
        if (this.J != null) {
            stringBuffer.append(",appExt:");
            stringBuffer.append(this.J);
        }
        if (this.Q > 0) {
            stringBuffer.append(",timeSpend:");
            stringBuffer.append(this.Q);
        }
        if (!ag.a(this.u)) {
            stringBuffer.append(",videoCurrentUrl:");
            stringBuffer.append(this.u);
        }
        if (!ag.a(this.o)) {
            stringBuffer.append(",photoSize:");
            stringBuffer.append(this.o);
        }
        if (this.w != -1) {
            stringBuffer.append(",relatedFromPhotoId:");
            stringBuffer.append(this.w);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

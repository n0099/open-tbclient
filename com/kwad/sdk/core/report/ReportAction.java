package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
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
/* loaded from: classes5.dex */
public class ReportAction extends d {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public long F;
    private long G;
    private String H;
    private int I;
    private long J;
    private long K;
    private long L;
    private JSONObject M;
    private JSONObject N;
    private long O;
    private int P;
    private int Q;
    private long R;
    private long S;
    private long T;
    private long U;
    private long V;
    private long W;
    private long X;
    private int Y;
    private int Z;
    private JSONArray aA;
    private String aa;
    private long ab;
    private int ac;
    private int ad;
    private int ae;
    private JSONArray af;
    private JSONArray ag;
    private String ah;
    private String ai;
    private String aj;
    private long ak;
    private long al;
    private int am;
    private String an;
    private a ao;
    private int ap;
    private String aq;
    private long ar;
    private String as;
    private String at;
    private long au;
    private int av;
    private int aw;
    private int ax;
    private JSONArray ay;
    private LiveLogInfo az;

    /* renamed from: b  reason: collision with root package name */
    public long f9679b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public String i;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class LiveLogInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 4898843925487388950L;
        public String expTag;
        public String liveStreamId;

        private LiveLogInfo() {
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

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f9680a;

        /* renamed from: b  reason: collision with root package name */
        public int f9681b;

        public static a a() {
            a aVar = new a();
            aVar.f9680a = b.f9682a;
            aVar.f9681b = b.f9683b;
            return aVar;
        }

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.f9680a = jSONObject.optInt("posIdWidth");
                this.f9681b = jSONObject.optInt("posIdHeight");
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "posIdWidth", this.f9680a);
            com.kwad.sdk.utils.o.a(jSONObject, "posIdHeight", this.f9681b);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f9682a;

        /* renamed from: b  reason: collision with root package name */
        public static int f9683b;

        public static void a(int i) {
            f9682a = i;
        }

        public static void b(int i) {
            f9683b = i;
        }
    }

    ReportAction(@NonNull com.kwad.sdk.core.report.a aVar) {
        this.I = -1;
        this.P = 0;
        this.Q = 0;
        this.g = -1L;
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
        this.K = aVar.c;
        this.f9713a = UUID.randomUUID().toString();
        this.G = System.currentTimeMillis();
        this.H = m.b();
        this.f9679b = m.c();
        this.J = m.f();
        this.S = aVar.a();
        this.U = aVar.d;
        this.V = aVar.e;
        this.W = aVar.f;
        this.X = aVar.g;
        this.d = aVar.i;
        this.e = aVar.l;
        this.f = aVar.m;
        this.g = aVar.n;
        this.h = aVar.j;
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
        this.c = aVar.h;
        this.i = aVar.B;
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
        SceneImpl sceneImpl = aVar.f9685b;
        if (sceneImpl != null) {
            this.O = sceneImpl.getPosId();
            this.k = sceneImpl.getUrlPackage();
            this.I = sceneImpl.getAdStyle();
        } else if (aVar.f9684a != null && aVar.f9684a.mAdScene != null) {
            SceneImpl sceneImpl2 = aVar.f9684a.mAdScene;
            this.O = sceneImpl2.getPosId();
            this.k = sceneImpl2.getUrlPackage();
            this.I = sceneImpl2.getAdStyle();
        }
        AdTemplate adTemplate = aVar.f9684a;
        if (adTemplate != null) {
            this.L = com.kwad.sdk.core.response.b.c.g(adTemplate);
            String h = com.kwad.sdk.core.response.b.c.h(adTemplate);
            if (!TextUtils.isEmpty(h)) {
                try {
                    this.M = new JSONObject(h);
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.b(e);
                }
            }
            String i = com.kwad.sdk.core.response.b.c.i(adTemplate);
            if (!TextUtils.isEmpty(i)) {
                try {
                    this.N = new JSONObject(i);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            this.O = com.kwad.sdk.core.response.b.c.e(adTemplate);
            this.P = com.kwad.sdk.core.response.b.c.f(adTemplate);
            this.Q = adTemplate.realShowType;
            if (this.Q == 1) {
                this.R = com.kwad.sdk.core.response.b.d.k(adTemplate.photoInfo);
                this.T = com.kwad.sdk.core.response.b.d.c(adTemplate.photoInfo).longValue();
                this.ab = com.kwad.sdk.core.response.b.d.o(adTemplate.photoInfo);
                this.an = com.kwad.sdk.core.response.b.d.l(adTemplate.photoInfo);
                this.aq = com.kwad.sdk.core.response.b.d.A(adTemplate.photoInfo);
                this.ar = com.kwad.sdk.core.response.b.d.z(adTemplate.photoInfo);
                this.as = com.kwad.sdk.core.response.b.d.B(adTemplate.photoInfo);
                this.au = com.kwad.sdk.core.response.b.d.I(adTemplate.photoInfo);
                this.at = com.kwad.sdk.core.response.b.d.J(adTemplate.photoInfo);
                if (adTemplate.mPreloadData != null) {
                    this.ax = adTemplate.mPreloadData.isPreload ? 1 : 0;
                } else {
                    this.ax = 0;
                }
            } else if (this.Q == 2) {
                AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
                this.R = com.kwad.sdk.core.response.b.a.k(j);
                this.s = j.adBaseInfo.creativeId;
                this.T = com.kwad.sdk.core.response.b.a.b(j) * 1000;
                this.ab = j.advertiserInfo.userId;
            } else if (this.Q == 4) {
                LiveInfo A = com.kwad.sdk.core.response.b.c.A(adTemplate);
                this.az.liveStreamId = com.kwad.sdk.live.mode.a.a(A);
                this.az.expTag = com.kwad.sdk.live.mode.a.c(A);
                this.ab = com.kwad.sdk.live.mode.a.b(A);
            }
            this.m = adTemplate.mMediaPlayerType;
            this.aw = adTemplate.mIsLeftSlipStatus;
            this.p = adTemplate.mPhotoResponseType;
            if (adTemplate.mPageInfo != null) {
                this.A = adTemplate.mPageInfo.pageType;
            }
        }
        if (aVar.C != -1) {
            this.au = aVar.C;
        }
        if (!TextUtils.isEmpty(aVar.D)) {
            this.at = aVar.D;
        }
        if (aVar.E != -1) {
            this.n = aVar.E;
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
        SceneImpl sceneImpl3 = aVar.f9685b;
        if (sceneImpl3 == null && adTemplate != null) {
            sceneImpl3 = adTemplate.mAdScene;
        }
        if (sceneImpl3 != null) {
            this.O = sceneImpl3.getPosId();
            this.k = sceneImpl3.getUrlPackage();
        }
        if (this.k != null) {
            EntryPackage b2 = com.kwad.sdk.core.scene.a.a().b(this.k.identity);
            this.aa = b2.entryPageSource;
            this.ai = b2.entryId;
            this.l = com.kwad.sdk.core.scene.a.a().a(this.k.identity);
        }
        this.F = aVar.k;
    }

    public ReportAction(String str) {
        this.I = -1;
        this.P = 0;
        this.Q = 0;
        this.g = -1L;
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
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
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
            this.K = jSONObject.optLong("actionType");
            this.G = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.H = jSONObject.optString("sessionId");
            }
            this.f9679b = jSONObject.optLong("seq");
            this.J = jSONObject.optLong("listId");
            this.S = jSONObject.optLong("position");
            this.ai = jSONObject.optString("entryId");
            this.aj = jSONObject.optString("pushUrl");
            this.U = jSONObject.optLong("effectivePlayDuration");
            this.V = jSONObject.optLong("playDuration");
            this.W = jSONObject.optLong("startDuration");
            this.X = jSONObject.optLong("stayDuration");
            this.d = jSONObject.optLong("blockDuration");
            this.e = jSONObject.optLong("intervalDuration");
            this.f = jSONObject.optLong("allIntervalDuration");
            this.g = jSONObject.optLong("flowSdk", -1L);
            this.h = jSONObject.optInt("blockTimes");
            this.Y = jSONObject.optInt("enterType");
            this.Z = jSONObject.optInt("leaveType");
            this.ac = jSONObject.optInt("likeStatus");
            this.ad = jSONObject.optInt("likeType");
            this.ae = jSONObject.optInt("shareResult");
            this.c = jSONObject.optInt("stayLength");
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
            this.P = jSONObject.optInt(CameraActivityConfig.KEY_CONTENT_TYPE);
            this.Q = jSONObject.optInt("realShowType");
            this.R = jSONObject.optLong("photoId");
            this.T = jSONObject.optLong("photoDuration");
            this.ab = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
            this.aa = jSONObject.optString("entryPageSource");
            if (jSONObject.has("urlPackage")) {
                this.k = new URLPackage();
                this.k.parseJson(jSONObject.optJSONObject("urlPackage"));
            }
            if (jSONObject.has("referURLPackage")) {
                this.l = new URLPackage();
                this.l.parseJson(jSONObject.optJSONObject("referURLPackage"));
            }
            this.ak = jSONObject.optLong("commentId");
            this.al = jSONObject.optLong("seenCount");
            this.am = jSONObject.optInt(PushConstants.CLICK_TYPE);
            if (jSONObject.has("recoExt")) {
                this.an = jSONObject.optString("recoExt");
            }
            if (jSONObject.has("clientExt")) {
                this.ao = new a();
                this.ao.a(jSONObject.optJSONObject("clientExt"));
            }
            this.m = jSONObject.optInt("playerType");
            this.i = jSONObject.optString("tabName");
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
            this.r = jSONObject.optString(TiebaInitialize.LogFields.ERROR_MESSAGE);
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
            this.A = jSONObject.optInt(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE);
            this.B = jSONObject.optInt("guideTimes");
            this.C = jSONObject.optInt("speedLimitStatus");
            this.D = jSONObject.optInt("speedLimitThreshold");
            this.E = jSONObject.optInt("currentRealDownloadSpeed");
            this.y = jSONObject.optJSONObject("appExt");
            this.w = jSONObject.optString("cacheFailedReason");
            this.F = jSONObject.optLong("timeSpend");
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        com.kwad.sdk.utils.o.a(json, "uiType", this.ap);
        com.kwad.sdk.utils.o.a(json, "timestamp", this.G);
        com.kwad.sdk.utils.o.a(json, "sessionId", this.H);
        com.kwad.sdk.utils.o.a(json, "seq", this.f9679b);
        com.kwad.sdk.utils.o.a(json, "listId", this.J);
        com.kwad.sdk.utils.o.a(json, "position", this.S);
        com.kwad.sdk.utils.o.a(json, "entryId", this.ai);
        com.kwad.sdk.utils.o.a(json, "pushUrl", this.aj);
        com.kwad.sdk.utils.o.a(json, "actionType", this.K);
        com.kwad.sdk.utils.o.a(json, "llsid", this.L);
        if (this.M != null) {
            com.kwad.sdk.utils.o.a(json, "extra", this.M);
        }
        if (this.N != null) {
            com.kwad.sdk.utils.o.a(json, "impAdExtra", this.N);
        }
        com.kwad.sdk.utils.o.a(json, "posId", this.O);
        if (this.I > 0) {
            com.kwad.sdk.utils.o.a(json, "adStyle", this.I);
        }
        com.kwad.sdk.utils.o.a(json, CameraActivityConfig.KEY_CONTENT_TYPE, this.P);
        com.kwad.sdk.utils.o.a(json, "realShowType", this.Q);
        com.kwad.sdk.utils.o.a(json, "photoId", this.R);
        com.kwad.sdk.utils.o.a(json, "photoDuration", this.T);
        com.kwad.sdk.utils.o.a(json, "startDuration", this.W);
        com.kwad.sdk.utils.o.a(json, "playDuration", this.V);
        com.kwad.sdk.utils.o.a(json, "stayDuration", this.X);
        com.kwad.sdk.utils.o.a(json, "intervalDuration", this.e);
        com.kwad.sdk.utils.o.a(json, "allIntervalDuration", this.f);
        com.kwad.sdk.utils.o.a(json, "flowSdk", this.g);
        com.kwad.sdk.utils.o.a(json, "effectivePlayDuration", this.U);
        com.kwad.sdk.utils.o.a(json, "blockDuration", this.d);
        com.kwad.sdk.utils.o.a(json, "blockTimes", this.h);
        com.kwad.sdk.utils.o.a(json, "enterType", this.Y);
        com.kwad.sdk.utils.o.a(json, "leaveType", this.Z);
        com.kwad.sdk.utils.o.a(json, "entryPageSource", this.aa);
        if (this.k != null) {
            com.kwad.sdk.utils.o.a(json, "urlPackage", this.k.toJson());
        }
        if (this.l != null) {
            com.kwad.sdk.utils.o.a(json, "referURLPackage", this.l.toJson());
        }
        com.kwad.sdk.utils.o.a(json, "stayLength", this.c);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_AUTHOR_ID, this.ab);
        com.kwad.sdk.utils.o.a(json, "likeStatus", this.ac);
        com.kwad.sdk.utils.o.a(json, "likeType", this.ad);
        com.kwad.sdk.utils.o.a(json, "shareResult", this.ae);
        if (this.af != null) {
            com.kwad.sdk.utils.o.a(json, "appInstalled", this.af);
        }
        if (this.ag != null) {
            com.kwad.sdk.utils.o.a(json, "appUninstalled", this.ag);
        }
        if (!ag.a(this.q)) {
            com.kwad.sdk.utils.o.a(json, "failUrl", this.q);
        }
        if (!ag.a(this.r)) {
            com.kwad.sdk.utils.o.a(json, TiebaInitialize.LogFields.ERROR_MESSAGE, this.r);
        }
        if (!ag.a(this.t)) {
            com.kwad.sdk.utils.o.a(json, "moduleName", this.t);
        }
        if (!ag.a(this.x)) {
            com.kwad.sdk.utils.o.a(json, "componentPosition", this.x);
        }
        if (this.v > 0) {
            com.kwad.sdk.utils.o.a(json, "num", this.v);
        }
        if (this.u != 0) {
            com.kwad.sdk.utils.o.a(json, "state", this.u);
        }
        if (!ag.a(this.w)) {
            com.kwad.sdk.utils.o.a(json, "cacheFailedReason", this.w);
        }
        com.kwad.sdk.utils.o.a(json, "coverUrl", this.ah);
        com.kwad.sdk.utils.o.a(json, "commentId", this.ak);
        com.kwad.sdk.utils.o.a(json, "seenCount", this.al);
        com.kwad.sdk.utils.o.a(json, PushConstants.CLICK_TYPE, this.am);
        com.kwad.sdk.utils.o.a(json, "recoExt", this.an);
        if (this.ao != null) {
            com.kwad.sdk.utils.o.a(json, "clientExt", this.ao);
        }
        com.kwad.sdk.utils.o.a(json, "playerType", this.m);
        com.kwad.sdk.utils.o.a(json, "tabName", this.i);
        com.kwad.sdk.utils.o.a(json, "tubeName", this.aq);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_TUBE_ID, this.ar);
        com.kwad.sdk.utils.o.a(json, "episodeName", this.as);
        com.kwad.sdk.utils.o.a(json, URLPackage.KEY_TREND_ID, this.au);
        com.kwad.sdk.utils.o.a(json, "trendName", this.at);
        com.kwad.sdk.utils.o.a(json, "preloadType", this.ax);
        if (this.ay != null && this.ay.length() > 0) {
            com.kwad.sdk.utils.o.a(json, "preloadPhotoList", this.ay);
        }
        if (this.n != -1) {
            com.kwad.sdk.utils.o.a(json, "hotCompType", this.n);
        }
        com.kwad.sdk.utils.o.a(json, "closeType", this.av);
        com.kwad.sdk.utils.o.a(json, "nextPageType", this.j);
        com.kwad.sdk.utils.o.a(json, "liveLogInfo", this.az);
        com.kwad.sdk.utils.o.a(json, "creativeId", this.s);
        com.kwad.sdk.utils.o.a(json, "isLeftSlipStatus", this.aw);
        com.kwad.sdk.utils.o.a(json, "photoResponseType", this.p);
        com.kwad.sdk.utils.o.a(json, "refreshType", this.o);
        com.kwad.sdk.utils.o.a(json, "appRunningInfoList", this.aA);
        if (this.y != null) {
            com.kwad.sdk.utils.o.a(json, "appExt", this.y);
        }
        com.kwad.sdk.utils.o.a(json, com.kwad.sdk.api.loader.ReportAction.KEY_DOWNLOAD_DURATION, this.z);
        com.kwad.sdk.utils.o.a(json, InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, this.A);
        com.kwad.sdk.utils.o.a(json, "guideTimes", this.B);
        com.kwad.sdk.utils.o.a(json, "speedLimitStatus", this.C);
        com.kwad.sdk.utils.o.a(json, "speedLimitThreshold", this.D);
        com.kwad.sdk.utils.o.a(json, "currentRealDownloadSpeed", this.E);
        if (this.F > 0) {
            com.kwad.sdk.utils.o.a(json, "timeSpend", this.F);
        }
        return json;
    }

    @NonNull
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[actionType:").append(this.K).append(",moduleName:").append(this.t).append(",componentPosition:").append(this.x).append(",tubeId:").append(this.ar).append(",entryId:").append(this.ai).append(",blockDuration:").append(this.d).append(",blockTimes:").append(this.h).append(",intervalDuration:").append(this.e).append(",allIntervalDuration:").append(this.f).append(",flowSdk:").append(this.g).append(",trendId:").append(this.au).append(",trendName:").append(this.at).append(",tubeName:").append(this.aq).append(",episodeName:").append(this.as).append(",seq:").append(this.f9679b).append(",extra:").append(this.M).append(",impAdExtra:").append(this.N).append(",actionId:").append(this.f9713a).append(",position:").append(this.S).append(",contentType:").append(this.P).append(",playerType:").append(this.m).append(",preloadType:").append(this.ax).append(",realShowType:").append(this.Q).append(",photoDuration:").append(this.T).append(",startDuration:").append(this.W).append(",playDuration:").append(this.V).append(",stayDuration:").append(this.X).append(",enterType:").append(this.Y).append(",entryPageSource:").append(this.aa).append(",stayLength:").append(this.c);
        if (this.n != -1) {
            stringBuffer.append(",hotCompType:").append(this.n);
        }
        if (this.k != null) {
            stringBuffer.append(",urlPackage:").append(this.k.page);
        }
        if (this.l != null) {
            stringBuffer.append(",referPage:").append(this.l.page);
        }
        if (this.v > -1) {
            stringBuffer.append(",num:").append(this.v);
        }
        if (this.u != 0) {
            stringBuffer.append(",state:").append(this.u);
        }
        if (this.y != null) {
            stringBuffer.append(",appExt:").append(this.y);
        }
        if (this.F > 0) {
            stringBuffer.append(",timeSpend:").append(this.F);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

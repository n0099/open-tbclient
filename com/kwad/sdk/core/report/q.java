package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
@KsJson
/* loaded from: classes10.dex */
public class q extends g {
    public String IA;
    public String IB;
    public long ID;
    public String QQ;
    public long QX;
    public long QY;
    public long QZ;
    public long RT;
    public String WA;
    public String Xd;
    public int Xe;
    public long aaf;
    public long actionType;
    public transient SceneImpl adScene;
    public long arX;
    public long avG;
    public JSONObject avH;
    public JSONObject avI;
    public long avJ;
    public long avK;
    public long avL;
    public long avM;
    public long avN;
    public long avP;
    public URLPackage avR;
    public String avS;
    public JSONArray avT;
    public JSONArray avU;
    public a avV;
    public int avW;
    public int avX;
    public int avY;
    public int avZ;
    public long awA;
    public JSONArray awB;
    public String awC;
    public String awD;
    public String awE;
    public String awF;
    public String awG;
    public String awI;
    public String awJ;
    public int awK;
    public long awN;
    public long awO;
    public String awP;
    public String awa;
    public int awb;
    public int awc;
    public String awd;
    public JSONObject awe;
    public JSONArray awf;
    public int awg;
    public int awh;
    public int awi;
    public JSONArray awk;
    public boolean awl;
    public String awm;
    public long awp;
    public int awq;
    public String awr;
    public long aws;
    public long awt;
    public long awu;
    public long awv;
    public String aww;
    public int awx;
    public JSONArray awy;
    public long awz;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long avO = -1;
    public int avQ = 0;
    public long awj = 0;
    public int awn = 0;
    public int awo = -1;
    public int awH = 0;
    public int awL = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String awM = BuildConfig.VERSION_NAME;

    /* loaded from: classes10.dex */
    public static class b {
        public static int awQ;
        public static int awR;
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int awQ;
        public int awR;

        public static a DE() {
            a aVar = new a();
            aVar.awQ = b.awQ;
            aVar.awR = b.awR;
            return aVar;
        }
    }

    public q(long j) {
        String apiVersion;
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null) {
            apiVersion = "";
        } else {
            apiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        }
        this.WA = apiVersion;
        this.sdkType = 1;
        this.awP = "";
        this.actionType = j;
    }

    public q(long j, @Nullable AdTemplate adTemplate) {
        String apiVersion;
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null) {
            apiVersion = "";
        } else {
            apiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        }
        this.WA = apiVersion;
        this.sdkType = 1;
        this.awP = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
    }

    public q(long j, @Nullable AdTemplate adTemplate, String str) {
        String apiVersion;
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null) {
            apiVersion = "";
        } else {
            apiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        }
        this.WA = apiVersion;
        this.sdkType = 1;
        this.awP = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
        this.Xd = str;
    }

    public q(String str, String str2, boolean z) {
        String apiVersion;
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null) {
            apiVersion = "";
        } else {
            apiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        }
        this.WA = apiVersion;
        this.sdkType = 1;
        this.awP = "";
        this.actionId = str;
        this.awP = str2;
    }

    private void bW(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        this.avX = 3;
        v vVar = (v) ServiceProvider.get(v.class);
        if (vVar != null) {
            this.awn = vVar.tq();
        }
        this.actionId = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
        this.sessionId = w.DJ();
        try {
            this.ID = w.DK();
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
        this.avG = w.DL();
        SceneImpl sceneImpl2 = this.adScene;
        if (sceneImpl2 != null) {
            this.posId = sceneImpl2.getPosId();
            this.urlPackage = this.adScene.getUrlPackage();
            this.adStyle = this.adScene.getAdStyle();
        } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
            this.adScene = sceneImpl;
            this.posId = sceneImpl.getPosId();
            this.urlPackage = this.adScene.getUrlPackage();
            this.adStyle = this.adScene.getAdStyle();
        }
        if (adTemplate != null) {
            this.position = adTemplate.getShowPosition() + 1;
            this.avJ = adTemplate.getServerPosition() + 1;
            this.llsid = com.kwad.sdk.core.response.b.e.dM(adTemplate);
            String dN = com.kwad.sdk.core.response.b.e.dN(adTemplate);
            if (!TextUtils.isEmpty(dN)) {
                try {
                    this.avH = new JSONObject(dN);
                } catch (Exception e2) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                }
            }
            String dO = com.kwad.sdk.core.response.b.e.dO(adTemplate);
            if (!TextUtils.isEmpty(dO)) {
                try {
                    this.avI = new JSONObject(dO);
                } catch (Exception e3) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e3);
                }
            }
            this.posId = com.kwad.sdk.core.response.b.e.dI(adTemplate);
            this.contentType = com.kwad.sdk.core.response.b.e.dL(adTemplate);
            this.realShowType = adTemplate.realShowType;
            this.photoId = com.kwad.sdk.core.response.b.e.dV(adTemplate);
            if (this.realShowType == 2) {
                AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
                this.creativeId = dP.adBaseInfo.creativeId;
                this.avK = com.kwad.sdk.core.response.b.a.L(dP) * 1000;
                this.RT = dP.advertiserInfo.userId;
            }
            this.avW = adTemplate.mMediaPlayerType;
            this.avY = adTemplate.mIsLeftSlipStatus;
            this.avZ = adTemplate.mPhotoResponseType;
            PageInfo pageInfo = adTemplate.mPageInfo;
            if (pageInfo != null) {
                this.pageType = pageInfo.pageType;
            }
            this.contentSourceType = com.kwad.sdk.core.response.b.e.dW(adTemplate);
        }
        this.avV = a.DE();
        if (this.adScene == null && adTemplate != null) {
            this.adScene = adTemplate.mAdScene;
        }
        SceneImpl sceneImpl3 = this.adScene;
        if (sceneImpl3 != null) {
            this.posId = sceneImpl3.getPosId();
            this.urlPackage = this.adScene.getUrlPackage();
        }
    }

    public final q DC() {
        bW(this.mAdTemplate);
        return this;
    }

    public final void DD() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.awg = jVar.qo() ? 1 : 0;
        this.awh = jVar.qp();
        this.awi = jVar.qq();
    }

    @Override // com.kwad.sdk.core.report.g, com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.avX = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.awc = jSONObject.optInt("num");
        this.awb = jSONObject.optInt("state");
        this.awj = jSONObject.optLong("timeSpend");
        this.awz = jSONObject.optLong("loadingDuration");
        this.awA = jSONObject.optLong("loadingDurationLimt");
        this.awo = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.g, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actionId", this.actionId);
        int i = this.adStyle;
        if (i > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.awc;
        if (i2 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "num", i2);
        }
        int i3 = this.awb;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "state", i3);
        }
        long j = this.awj;
        if (j > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.awz;
        if (j2 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.awA;
        if (j3 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "playerTypeInfo", this.awo);
    }
}

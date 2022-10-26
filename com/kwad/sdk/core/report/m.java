package com.kwad.sdk.core.report;

import android.text.TextUtils;
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
/* loaded from: classes7.dex */
public class m extends c {
    public long HD;
    public long HE;
    public long HF;
    public transient SceneImpl HS;
    public String Hx;
    public long Iw;
    public String Mn;
    public int Mo;
    public int aaA;
    public int aaB;
    public int aaC;
    public int aaD;
    public int aaE;
    public String aaF;
    public JSONObject aaG;
    public JSONArray aaH;
    public int aaI;
    public int aaJ;
    public int aaK;
    public JSONArray aaM;
    public boolean aaN;
    public String aaO;
    public long aaR;
    public int aaS;
    public String aaT;
    public long aaU;
    public long aaV;
    public long aaW;
    public long aaX;
    public String aaY;
    public int aaZ;
    public long aag;
    public long aah;
    public long aai;
    public JSONObject aaj;
    public JSONObject aak;
    public long aal;
    public long aam;
    public long aan;
    public long aao;
    public long aap;
    public long aaq;
    public long aas;
    public URLPackage aau;
    public String aav;
    public JSONArray aaw;
    public JSONArray aax;
    public a aay;
    public int aaz;
    public JSONArray aba;
    public long abb;
    public long abc;
    public JSONArray abd;
    public String abe;
    public String abf;
    public String abg;
    public String abh;
    public String abi;
    public String abk;
    public String abl;
    public int abm;
    public int abn;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public String failUrl;
    public long llsid;
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long aar = -1;
    public int aat = 0;
    public long aaL = 0;
    public int aaP = 0;
    public int aaQ = -1;
    public int abj = 0;

    /* loaded from: classes7.dex */
    public final class a extends com.kwad.sdk.core.response.kwai.a {
        public int abo;
        public int abp;

        public static a uB() {
            a aVar = new a();
            aVar.abo = b.abo;
            aVar.abp = b.abp;
            return aVar;
        }
    }

    /* loaded from: classes7.dex */
    public final class b {
        public static int abo;
        public static int abp;
    }

    public m(long j) {
        this.aai = j;
    }

    public m(long j, AdTemplate adTemplate) {
        this.aai = j;
        this.mAdTemplate = adTemplate;
    }

    public m(long j, AdTemplate adTemplate, String str) {
        this.aai = j;
        this.mAdTemplate = adTemplate;
        this.Mn = str;
    }

    public m(String str) {
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
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
    private void aI(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        this.aaA = 3;
        r rVar = (r) ServiceProvider.get(r.class);
        if (rVar != null) {
            this.aaP = rVar.ls();
        }
        this.ZR = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
        this.sessionId = s.uG();
        try {
            this.aag = s.uH();
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        this.aah = s.uI();
        SceneImpl sceneImpl2 = this.HS;
        if (sceneImpl2 == null) {
            if (adTemplate != null && (sceneImpl2 = adTemplate.mAdScene) != null) {
                this.HS = sceneImpl2;
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.aal = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.a.d.bN(adTemplate);
                String bO = com.kwad.sdk.core.response.a.d.bO(adTemplate);
                if (!TextUtils.isEmpty(bO)) {
                    try {
                        this.aaj = new JSONObject(bO);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e2);
                    }
                }
                String bP = com.kwad.sdk.core.response.a.d.bP(adTemplate);
                if (!TextUtils.isEmpty(bP)) {
                    try {
                        this.aak = new JSONObject(bP);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e3);
                    }
                }
                this.posId = com.kwad.sdk.core.response.a.d.bJ(adTemplate);
                this.contentType = com.kwad.sdk.core.response.a.d.bM(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.a.d.bV(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                    this.creativeId = bQ.adBaseInfo.creativeId;
                    this.aam = com.kwad.sdk.core.response.a.a.B(bQ) * 1000;
                    this.Iw = bQ.advertiserInfo.userId;
                }
                this.aaz = adTemplate.mMediaPlayerType;
                this.aaB = adTemplate.mIsLeftSlipStatus;
                this.aaC = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.pageType = pageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.a.d.bW(adTemplate);
            }
            this.aay = a.uB();
            if (this.HS == null && adTemplate != null) {
                this.HS = adTemplate.mAdScene;
            }
            sceneImpl = this.HS;
            if (sceneImpl == null) {
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.HS.getUrlPackage();
                return;
            }
            return;
        }
        this.posId = sceneImpl2.getPosId();
        this.urlPackage = this.HS.getUrlPackage();
        this.adStyle = this.HS.getAdStyle();
        if (adTemplate != null) {
        }
        this.aay = a.uB();
        if (this.HS == null) {
            this.HS = adTemplate.mAdScene;
        }
        sceneImpl = this.HS;
        if (sceneImpl == null) {
        }
    }

    @Override // com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aaA = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.aaE = jSONObject.optInt("num");
        this.aaD = jSONObject.optInt("state");
        this.aaL = jSONObject.optLong("timeSpend");
        this.abb = jSONObject.optLong("loadingDuration");
        this.abc = jSONObject.optLong("loadingDurationLimt");
        this.aaQ = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.ZR = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.r.putValue(jSONObject, "actionId", this.ZR);
        int i = this.adStyle;
        if (i > 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.aaE;
        if (i2 > 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "num", i2);
        }
        int i3 = this.aaD;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "state", i3);
        }
        long j = this.aaL;
        if (j > 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.abb;
        if (j2 > 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.abc;
        if (j3 > 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "playerTypeInfo", this.aaQ);
    }

    public final void uA() {
        com.kwad.sdk.service.kwai.h hVar = (com.kwad.sdk.service.kwai.h) ServiceProvider.get(com.kwad.sdk.service.kwai.h.class);
        this.aaI = hVar.ln() ? 1 : 0;
        this.aaJ = hVar.lo();
        this.aaK = hVar.lp();
    }

    public final m uz() {
        aI(this.mAdTemplate);
        return this;
    }
}

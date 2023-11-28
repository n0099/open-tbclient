package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bg;
import com.qq.e.comm.pi.IBidding;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class y extends com.kwad.sdk.core.network.b {
    public int awY;
    @Nullable
    public final b awZ;
    @Nullable
    public final JSONObject axa;
    public final AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public y(@NonNull AdTemplate adTemplate, int i, @Nullable b bVar, @Nullable JSONObject jSONObject) {
        this.mAdTemplate = adTemplate;
        this.awY = i;
        this.awZ = bVar;
        this.axa = jSONObject;
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String axc;
        public int axd;
        public int axe;
        public int axf;
        public JSONObject axg;
        public int axh;
        public int axi;
        @Nullable
        public AdTrackLog axj;
        public String templateId;
        public int axb = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int showLiveStyle = -1;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.axb;
            if (i != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "duration", j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "show_live_style", i3);
            }
            AdTrackLog adTrackLog = this.axj;
            if (adTrackLog != null) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.axg;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.axg.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public final AdTrackLog e(AdTemplate adTemplate, String str, String str2) {
            com.kwad.sdk.service.a.h hVar;
            if (adTemplate == null || (hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)) == null || !hVar.yD()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.axj = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            return this.axj;
        }
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long Lc;
        public int Od;
        public String Xd;
        public String adnName;
        public int adnType;
        public int avQ;
        public int axA;
        public String axB;
        public String axC;
        public int axD;
        public int axE;
        public long axF;
        public long axG;
        public int axJ;
        public a axK;
        public int axL;
        public String axO;
        public int axQ;
        public int axR;
        public int axS;
        public String axV;
        public int axk;
        public int axl;
        public int axm;
        public int axn;
        public String axo;
        public int axu;
        public String axv;
        public int axw;
        public int axx;
        public String axz;
        public int downloadSource;
        public int kk;
        public ac.a km;
        public double kn;
        public long vy;
        public long axp = -1;
        public int axq = -1;
        public long axr = -1;
        public int axs = -1;
        public int axt = 0;
        public String axy = "";
        public int axH = -1;
        public int axI = -1;
        public int downloadStatus = 0;
        public int axM = -1;
        public int axN = -1;
        public int axP = -1;
        public int adxResult = -1;
        public int axT = -1;
        public int axU = 0;

        public final void a(@Nullable k kVar) {
            if (kVar != null) {
                this.axV = kVar.DB();
            }
        }

        public final void cP(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        this.axR = 3;
                        return;
                    }
                    return;
                }
                this.axR = 2;
                return;
            }
            this.axR = 1;
        }

        public final void f(AdTemplate adTemplate, String str, String str2) {
            a aVar = this.axK;
            if (aVar == null) {
                a aVar2 = new a();
                this.axK = aVar2;
                aVar2.e(adTemplate, null, null);
            } else if (aVar.axj == null) {
                aVar.e(adTemplate, null, null);
            }
        }
    }

    private void a(String str, @Nullable b bVar) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            int i = bVar.axM;
            if (i >= 0) {
                putBody("adOrder", i);
            }
            int i2 = bVar.axN;
            if (i2 >= 0) {
                putBody("adInterstitialSource", i2);
            }
            if (!TextUtils.isEmpty(bVar.axo)) {
                putBody("adRenderArea", bVar.axo);
            }
            putBody("adxResult", bVar.adxResult);
            int i3 = bVar.axR;
            if (i3 != 0) {
                putBody("fingerSwipeType", i3);
            }
            int i4 = bVar.axS;
            if (i4 != 0) {
                putBody("fingerSwipeDistance", i4);
            }
            int i5 = bVar.axI;
            if (i5 != -1) {
                putBody("installStatus", i5);
            }
            a aVar = bVar.axK;
            if (aVar != null) {
                putBody("clientExtData", aVar.toJson().toString());
            }
            String str2 = bVar.axV;
            if (str2 != null) {
                putBody("clientPkFailAdInfo", str2);
            }
            int i6 = bVar.axT;
            if (i6 != -1) {
                putBody("triggerType", i6);
            }
            int i7 = bVar.axt;
            if (i7 != 0) {
                putBody("photoSizeStyle", i7);
            }
        }
    }

    private void a(String str, AdTemplate adTemplate, @Nullable b bVar) {
        if (!TextUtils.isEmpty(str) && adTemplate != null) {
            int i = adTemplate.mInitVoiceStatus;
            if (i != 0) {
                putBody("initVoiceStatus", i);
            }
            if (this.mAdTemplate.mBidEcpm == 0) {
                putBody("ecpmType", 2);
            } else {
                putBody("ecpmType", 1);
            }
            if (bVar == null) {
                return;
            }
            int i2 = bVar.avQ;
            if (i2 != 0) {
                putBody("adAggPageSource", i2);
            }
            if (!TextUtils.isEmpty(bVar.Xd)) {
                putBody("payload", bVar.Xd);
            }
        }
    }

    private void b(String str, @Nullable b bVar) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            int i = bVar.kk;
            if (i != 0) {
                putBody("itemClickType", i);
            }
            if (!TextUtils.isEmpty(bVar.Xd)) {
                putBody("payload", bVar.Xd);
            }
            int i2 = bVar.avQ;
            if (i2 != 0) {
                putBody("adAggPageSource", i2);
            }
            int i3 = bVar.axM;
            if (i3 >= 0) {
                putBody("adOrder", i3);
            }
            int i4 = bVar.axN;
            if (i4 >= 0) {
                putBody("adInterstitialSource", i4);
            }
            int i5 = bVar.axT;
            if (i5 != -1) {
                putBody("triggerType", i5);
            }
            int i6 = bVar.axU;
            if (i6 != 0) {
                putBody("cardCloseType", i6);
            }
            putBody("adxResult", bVar.adxResult);
            double d = bVar.kn;
            if (d > 0.0d) {
                putBody("splashShakeAcceleration", d);
            }
            if (!TextUtils.isEmpty(bVar.axO)) {
                putBody("splashInteractionRotateAngle", bVar.axO);
            }
            int i7 = bVar.axR;
            if (i7 != 0) {
                putBody("fingerSwipeType", i7);
            }
            int i8 = bVar.axS;
            if (i8 != 0) {
                putBody("fingerSwipeDistance", i8);
            }
            long j = bVar.vy;
            if (j > 0) {
                putBody("playedDuration", j);
            }
            int i9 = bVar.axL;
            if (i9 > 0) {
                putBody("playedRate", i9);
            }
            String str2 = bVar.axV;
            if (str2 != null) {
                putBody("clientPkFailAdInfo", str2);
            }
            int i10 = bVar.axs;
            if (i10 != -1) {
                putBody("retainCodeType", i10);
            }
            a aVar = bVar.axK;
            if (aVar != null) {
                putBody("clientExtData", aVar.toJson().toString());
            }
            int i11 = bVar.axt;
            if (i11 != 0) {
                putBody("photoSizeStyle", i11);
            }
        }
    }

    private void c(String str, @Nullable b bVar) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            int i = bVar.axm;
            if (i != 0) {
                putBody("itemCloseType", i);
            }
            int i2 = bVar.axk;
            if (i2 > 0) {
                putBody("photoPlaySecond", i2);
            }
            int i3 = bVar.axl;
            if (i3 != 0) {
                putBody("awardReceiveStage", i3);
            }
            int i4 = bVar.axn;
            if (i4 != 0) {
                putBody("elementType", i4);
            }
            if (!TextUtils.isEmpty(bVar.Xd)) {
                putBody("payload", bVar.Xd);
            }
            a aVar = bVar.axK;
            if (aVar != null) {
                putBody("clientExtData", aVar.toJson().toString());
            }
            int i5 = bVar.axu;
            if (i5 > 0) {
                putBody("deeplinkType", i5);
            }
            if (!TextUtils.isEmpty(bVar.axv)) {
                putBody("deeplinkAppName", bVar.axv);
            }
            int i6 = bVar.axw;
            if (i6 != 0) {
                putBody("deeplinkFailedReason", i6);
            }
            int i7 = bVar.downloadSource;
            if (i7 > 0) {
                putBody("downloadSource", i7);
            }
            int i8 = bVar.axU;
            if (i8 != 0) {
                putBody("cardCloseType", i8);
            }
            int i9 = bVar.axx;
            if (i9 > 0) {
                putBody("isPackageChanged", i9);
            }
            putBody("installedFrom", bVar.axy);
            putBody("isChangedEndcard", bVar.axA);
            int i10 = bVar.avQ;
            if (i10 != 0) {
                putBody("adAggPageSource", i10);
            }
            String str2 = bVar.axz;
            if (str2 != null) {
                putBody("downloadFailedReason", str2);
            }
            if (!bg.isNullString(bVar.axC)) {
                putBody("installedPackageName", bVar.axC);
            }
            if (!bg.isNullString(bVar.axB)) {
                putBody("serverPackageName", bVar.axB);
            }
            int i11 = bVar.axE;
            if (i11 > 0) {
                putBody("closeButtonClickTime", i11);
            }
            int i12 = bVar.axD;
            if (i12 > 0) {
                putBody("closeButtonImpressionTime", i12);
            }
            int i13 = bVar.downloadStatus;
            if (i13 >= 0) {
                putBody("downloadStatus", i13);
            }
            long j = bVar.axF;
            if (j > 0) {
                putBody("landingPageLoadedDuration", j);
            }
            long j2 = bVar.Lc;
            if (j2 > 0) {
                putBody("leaveTime", j2);
            }
            long j3 = bVar.axG;
            if (j3 > 0) {
                putBody("adItemClickBackDuration", j3);
            }
            int i14 = bVar.axs;
            if (i14 != -1) {
                putBody("retainCodeType", i14);
            }
            long j4 = bVar.axp;
            if (j4 > -1) {
                putBody(IBidding.HIGHEST_LOSS_PRICE, j4);
            }
            int i15 = bVar.axq;
            if (i15 >= 0) {
                putBody("impFailReason", i15);
            }
            long j5 = bVar.axr;
            if (j5 > -1) {
                putBody("winEcpm", j5);
            }
            int i16 = bVar.adnType;
            if (i16 > 0) {
                putBody("adnType", i16);
            }
            if (!TextUtils.isEmpty(bVar.adnName)) {
                putBody("adnName", bVar.adnName);
            }
            putBody("downloadCardType", bVar.axJ);
            putBody("landingPageType", bVar.Od);
            int i17 = bVar.axN;
            if (i17 >= 0) {
                putBody("adInterstitialSource", i17);
            }
            int i18 = bVar.axP;
            if (i18 > 0) {
                putBody("downloadInstallType", i18);
            }
            int i19 = bVar.axR;
            if (i19 != 0) {
                putBody("fingerSwipeType", i19);
            }
            int i20 = bVar.axS;
            if (i20 != 0) {
                putBody("fingerSwipeDistance", i20);
            }
            int i21 = bVar.axQ;
            if (i21 > 0) {
                putBody("businessSceneType", i21);
            }
            long j6 = bVar.vy;
            if (j6 > 0) {
                putBody("playedDuration", j6);
            }
            int i22 = bVar.axL;
            if (i22 > 0) {
                putBody("playedRate", i22);
            }
            int i23 = bVar.axH;
            if (i23 != -1) {
                putBody("appStorePageType", i23);
            }
            int i24 = bVar.axT;
            if (i24 != -1) {
                putBody("triggerType", i24);
            }
            int i25 = bVar.axt;
            if (i25 != 0) {
                putBody("photoSizeStyle", i25);
            }
        }
    }

    private void k(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("clientTimestamp", System.currentTimeMillis());
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        putBody("extData", jSONObject.toString());
    }

    public final int getActionType() {
        return this.awY;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String replaceFirst;
        String replaceFirst2;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        int i = this.awY;
        if (i == 1) {
            String str = dP.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ys()) {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aR(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate))));
            } else {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            replaceFirst = replaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.awZ);
            a(replaceFirst, this.mAdTemplate, this.awZ);
        } else if (i == 2) {
            String str2 = dP.adBaseInfo.clickUrl;
            if (this.awZ != null) {
                ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
                str2 = ac.a(str2, this.awZ.km);
            }
            replaceFirst = ac.am(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext(), str2).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.awZ);
            a(replaceFirst, this.mAdTemplate, this.awZ);
        } else {
            replaceFirst = dP.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.awZ);
        }
        k(this.axa);
        return replaceFirst;
    }
}

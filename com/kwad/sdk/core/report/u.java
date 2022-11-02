package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class u extends com.kwad.sdk.core.network.b {
    @Nullable
    public final b KS;
    public int abw;
    @Nullable
    public final JSONObject abx;
    public final AdTemplate mAdTemplate;

    @KsJson
    /* loaded from: classes8.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int abA;
        public int aby = -1;
        public String abz;
        public String templateId;

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.aby;
            if (i != -1) {
                com.kwad.sdk.utils.r.putValue(jSONObject, "shield_reason", i);
            }
        }
    }

    @KsJson
    /* loaded from: classes8.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long Es;
        public int FH;
        public String Mn;
        public int aat;
        public int abB;
        public int abC;
        public int abD;
        public int abE;
        public int abI;
        public int abJ;
        public String abL;
        public int abM;
        public String abN;
        public String abO;
        public int abP;
        public int abQ;
        public long abR;
        public long abS;
        public int abV;
        public a abW;
        public int abX;
        public String acb;
        public int acd;
        public int ace;
        public int acf;
        public String aci;
        public int downloadSource;
        public int gJ;
        public aa.a gL;
        public double gM;
        public long ss;
        public int winEcpm;
        public int abF = -1;
        public int abG = -1;
        public int abH = 0;
        public String abK = "";
        public int abT = -1;
        public int abU = -1;
        public int lf = 0;
        public int abY = -1;
        public int abZ = -1;
        public int aca = -1;
        public int acc = -1;
        public int adxResult = -1;
        public int acg = -1;
        public int ach = 0;

        public final void a(@Nullable g gVar) {
            if (gVar != null) {
                this.aci = gVar.ux();
            }
        }

        public final void aV(int i) {
            if (i == 0) {
                this.ace = 1;
            } else if (i == 1) {
                this.ace = 2;
            } else if (i != 2) {
            } else {
                this.ace = 3;
            }
        }
    }

    public u(@NonNull AdTemplate adTemplate, int i, @Nullable b bVar, @Nullable JSONObject jSONObject) {
        this.mAdTemplate = adTemplate;
        this.abw = i;
        this.KS = bVar;
        this.abx = jSONObject;
    }

    private void a(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = bVar.abY;
        if (i >= 0) {
            putBody("adOrder", i);
        }
        int i2 = bVar.abZ;
        if (i2 >= 0) {
            putBody("adInterstitialSource", i2);
        }
        int i3 = bVar.aca;
        if (i3 >= 0) {
            putBody("universeSecondAd", i3);
        }
        putBody("adxResult", bVar.adxResult);
        int i4 = bVar.ace;
        if (i4 != 0) {
            putBody("fingerSwipeType", i4);
        }
        int i5 = bVar.acf;
        if (i5 != 0) {
            putBody("fingerSwipeDistance", i5);
        }
        int i6 = bVar.abU;
        if (i6 != -1) {
            putBody("installStatus", i6);
        }
        a aVar = bVar.abW;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        String str2 = bVar.aci;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i7 = bVar.acg;
        if (i7 != -1) {
            putBody("triggerType", i7);
        }
        int i8 = bVar.abH;
        if (i8 != 0) {
            putBody("photoSizeStyle", i8);
        }
    }

    private void a(String str, AdTemplate adTemplate, @Nullable b bVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i = adTemplate.mInitVoiceStatus;
        if (i != 0) {
            putBody("initVoiceStatus", i);
        }
        putBody("ecpmType", this.mAdTemplate.mBidEcpm == 0 ? 2 : 1);
        if (bVar == null) {
            return;
        }
        int i2 = bVar.aat;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        if (TextUtils.isEmpty(bVar.Mn)) {
            return;
        }
        putBody("payload", bVar.Mn);
    }

    private void b(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = bVar.gJ;
        if (i != 0) {
            putBody("itemClickType", i);
        }
        if (!TextUtils.isEmpty(bVar.Mn)) {
            putBody("payload", bVar.Mn);
        }
        int i2 = bVar.aat;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        int i3 = bVar.abY;
        if (i3 >= 0) {
            putBody("adOrder", i3);
        }
        int i4 = bVar.abZ;
        if (i4 >= 0) {
            putBody("adInterstitialSource", i4);
        }
        int i5 = bVar.acg;
        if (i5 != -1) {
            putBody("triggerType", i5);
        }
        int i6 = bVar.ach;
        if (i6 != 0) {
            putBody("cardCloseType", i6);
        }
        putBody("adxResult", bVar.adxResult);
        double d = bVar.gM;
        if (d > 0.0d) {
            putBody("splashShakeAcceleration", d);
        }
        if (!TextUtils.isEmpty(bVar.acb)) {
            putBody("splashInteractionRotateAngle", bVar.acb);
        }
        int i7 = bVar.ace;
        if (i7 != 0) {
            putBody("fingerSwipeType", i7);
        }
        int i8 = bVar.acf;
        if (i8 != 0) {
            putBody("fingerSwipeDistance", i8);
        }
        long j = bVar.ss;
        if (j > 0) {
            putBody("playedDuration", j);
        }
        int i9 = bVar.abX;
        if (i9 > 0) {
            putBody("playedRate", i9);
        }
        String str2 = bVar.aci;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i10 = bVar.abG;
        if (i10 != -1) {
            putBody("retainCodeType", i10);
        }
        int i11 = bVar.abH;
        if (i11 != 0) {
            putBody("photoSizeStyle", i11);
        }
    }

    private void c(String str, @Nullable b bVar) {
        if (bVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = bVar.abD;
        if (i != 0) {
            putBody("itemCloseType", i);
        }
        int i2 = bVar.abB;
        if (i2 > 0) {
            putBody("photoPlaySecond", i2);
        }
        int i3 = bVar.abC;
        if (i3 != 0) {
            putBody("awardReceiveStage", i3);
        }
        int i4 = bVar.abE;
        if (i4 != 0) {
            putBody("elementType", i4);
        }
        if (!TextUtils.isEmpty(bVar.Mn)) {
            putBody("payload", bVar.Mn);
        }
        a aVar = bVar.abW;
        if (aVar != null) {
            putBody("clientExtData", aVar.toJson().toString());
        }
        int i5 = bVar.abI;
        if (i5 > 0) {
            putBody("deeplinkType", i5);
        }
        int i6 = bVar.downloadSource;
        if (i6 > 0) {
            putBody("downloadSource", i6);
        }
        int i7 = bVar.ach;
        if (i7 != 0) {
            putBody("cardCloseType", i7);
        }
        int i8 = bVar.abJ;
        if (i8 > 0) {
            putBody("isPackageChanged", i8);
        }
        putBody("installedFrom", bVar.abK);
        putBody("isChangedEndcard", bVar.abM);
        int i9 = bVar.aat;
        if (i9 != 0) {
            putBody("adAggPageSource", i9);
        }
        String str2 = bVar.abL;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!ax.dT(bVar.abO)) {
            putBody("installedPackageName", bVar.abO);
        }
        if (!ax.dT(bVar.abN)) {
            putBody("serverPackageName", bVar.abN);
        }
        int i10 = bVar.abQ;
        if (i10 > 0) {
            putBody("closeButtonClickTime", i10);
        }
        int i11 = bVar.abP;
        if (i11 > 0) {
            putBody("closeButtonImpressionTime", i11);
        }
        int i12 = bVar.lf;
        if (i12 >= 0) {
            putBody("downloadStatus", i12);
        }
        long j = bVar.abR;
        if (j > 0) {
            putBody("landingPageLoadedDuration", j);
        }
        long j2 = bVar.Es;
        if (j2 > 0) {
            putBody("leaveTime", j2);
        }
        long j3 = bVar.abS;
        if (j3 > 0) {
            putBody("adItemClickBackDuration", j3);
        }
        int i13 = bVar.abG;
        if (i13 != -1) {
            putBody("retainCodeType", i13);
        }
        int i14 = bVar.abF;
        if (i14 >= 0) {
            putBody("impFailReason", i14);
        }
        int i15 = bVar.winEcpm;
        if (i15 > 0) {
            putBody("winEcpm", i15);
        }
        putBody("downloadCardType", bVar.abV);
        putBody("landingPageType", bVar.FH);
        int i16 = bVar.abZ;
        if (i16 >= 0) {
            putBody("adInterstitialSource", i16);
        }
        int i17 = bVar.acc;
        if (i17 > 0) {
            putBody("downloadInstallType", i17);
        }
        int i18 = bVar.ace;
        if (i18 != 0) {
            putBody("fingerSwipeType", i18);
        }
        int i19 = bVar.acf;
        if (i19 != 0) {
            putBody("fingerSwipeDistance", i19);
        }
        int i20 = bVar.acd;
        if (i20 > 0) {
            putBody("businessSceneType", i20);
        }
        long j4 = bVar.ss;
        if (j4 > 0) {
            putBody("playedDuration", j4);
        }
        int i21 = bVar.abX;
        if (i21 > 0) {
            putBody("playedRate", i21);
        }
        int i22 = bVar.abT;
        if (i22 != -1) {
            putBody("appStorePageType", i22);
        }
        int i23 = bVar.acg;
        if (i23 != -1) {
            putBody("triggerType", i23);
        }
        int i24 = bVar.abH;
        if (i24 != 0) {
            putBody("photoSizeStyle", i24);
        }
    }

    private void i(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("clientTimestamp", System.currentTimeMillis());
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        putBody("extData", jSONObject.toString());
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        String replaceFirst;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        int i = this.abw;
        if (i == 1) {
            replaceFirst = bQ.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf((this.mAdTemplate.mBidEcpm == 0 && ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lF()) ? com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) : this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.KS);
        } else if (i != 2) {
            replaceFirst = bQ.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.KS);
            i(this.abx);
            return replaceFirst;
        } else {
            String str = bQ.adBaseInfo.clickUrl;
            if (this.KS != null) {
                ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
                str = aa.a(str, this.KS.gL);
            }
            replaceFirst = aa.S(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), str).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.KS);
        }
        a(replaceFirst, this.mAdTemplate, this.KS);
        i(this.abx);
        return replaceFirst;
    }

    public final List<String> uK() {
        aa.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        b bVar;
        ArrayList arrayList = new ArrayList();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        if (!bQ.adTrackInfoList.isEmpty()) {
            Iterator<AdInfo.AdTrackInfo> it = bQ.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = it.next();
                if (adTrackInfo.type == this.abw && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2 && (bVar = this.KS) != null) {
                    aVar = bVar.gL;
                }
                for (String str : adTrackInfo.urls) {
                    arrayList.add(z.a(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), str, aVar));
                }
            }
        }
        return arrayList;
    }
}

package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import java.io.Serializable;
import org.json.JSONObject;
@KsJson
/* loaded from: classes10.dex */
public class AdTrackLog extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int NEGATIVE_RESULT = 2;
    public static final int POSITIVE_RESULT = 1;
    public static int sLiveSupportMode = 2;
    public static final long serialVersionUID = 6629369763953107007L;
    public int adLiveComponentReady;
    public int adLiveSwitch;
    public int adTkLiveSwitch;
    public String apiSdkVersion;
    public int isPlugin;
    public int preLandingPageShowType;
    public int preLandingPageSwitch;
    public int rewardAdvanceSwitch;
    public int rewardDetailCallPositionY;
    public int rewardDetailStatusBarHeight;
    public int rewardSkipShowTime;
    public String sceneId;
    public int screenOrientation;
    public int serverCheckSwitch;
    public String templateId;

    private int toReportInt(boolean z) {
        return z ? 1 : 2;
    }

    public AdTrackLog() {
    }

    public AdTrackLog(String str, String str2) {
        this.templateId = str;
        this.sceneId = str2;
    }

    @Nullable
    public static AdTrackLog createFromJson(String str) {
        try {
            AdTrackLog adTrackLog = new AdTrackLog();
            adTrackLog.parseJson(new JSONObject(str));
            return adTrackLog;
        } catch (Exception unused) {
            return null;
        }
    }

    public void bindABParams(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.adLiveComponentReady = toReportInt(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).oA());
        this.adLiveSwitch = toReportInt(com.kwad.sdk.core.response.b.a.cJ(dP));
        this.adTkLiveSwitch = toReportInt(TextUtils.isEmpty(com.kwad.sdk.core.response.b.b.dR(dP)));
        if (sLiveSupportMode == 2 && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).oA()) {
            sLiveSupportMode = 1;
        }
        this.adLiveComponentReady = sLiveSupportMode;
        this.serverCheckSwitch = toReportInt(com.kwad.sdk.core.response.b.a.cW(dP));
        this.rewardAdvanceSwitch = toReportInt(com.kwad.sdk.core.response.b.a.cX(dP));
        this.rewardSkipShowTime = com.kwad.sdk.core.response.b.a.ae(dP);
        this.preLandingPageSwitch = toReportInt(com.kwad.sdk.core.response.b.b.dP(dP));
        this.preLandingPageShowType = com.kwad.sdk.core.response.b.b.dQ(dP);
        this.apiSdkVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.isPlugin = toReportInt(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getIsExternal());
        this.screenOrientation = toReportInt(ai.isOrientationPortrait());
    }
}

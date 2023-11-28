package com.kwad.components.core.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.network.d {
    public static boolean Re = true;
    public ImpInfo Mp;
    public int Rd;

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    public a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    public static int c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void aB(int i) {
        this.Rd = i;
    }

    public a(ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        this(impInfo, null, false, null);
    }

    public static void a(com.kwad.sdk.core.request.model.g gVar, AdLabelImpl adLabelImpl) {
        int i = adLabelImpl.thirdAge;
        if (i != 0) {
            gVar.thirdAge = i;
        }
        int i2 = adLabelImpl.thirdGender;
        if (i2 != 0) {
            gVar.thirdGender = i2;
        }
        if (!TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            gVar.thirdInterest = adLabelImpl.thirdInterest;
        }
    }

    public a(ImpInfo impInfo, @Nullable List<String> list, boolean z, com.kwad.components.core.request.model.c cVar) {
        super(c(impInfo), impInfo.adScene);
        this.Mp = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            a(com.kwad.sdk.core.request.model.a.DP(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", cVar);
        int i = this.Rd;
        if (i > 0) {
            putBody("calledUnionType", i);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String Ae = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)).Ae() : "";
        if (!TextUtils.isEmpty(Ae)) {
            putBody("universeDebugParam", Ae);
        }
        String d = d(impInfo);
        if (!TextUtils.isEmpty(d)) {
            putBody("sdkDebugReqInfo", d);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", y.Ki());
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.Mp.getRewardCallbackExtraByKey("thirdUserId");
        com.kwad.sdk.core.request.model.g DW = com.kwad.sdk.core.request.model.g.DW();
        if (rewardCallbackExtraByKey != null) {
            DW.dS(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            a(DW, adLabelFromAdScene);
        }
        putBody("userInfo", DW);
    }

    public a(com.kwad.components.core.request.model.a aVar) {
        this(aVar.Mp, aVar.Rn, aVar.Ro, aVar.Rq);
        this.Rd = aVar.Rp ? 1 : 0;
    }

    private void a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            t.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            t.putValue(jSONObject2, "postTitle", adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            t.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            t.putValue(jSONObject2, "channel", adLabelImpl.channel);
        }
        t.putValue(jSONObject, "content", jSONObject2);
        putBody(DI.APP_INFO_NAME, jSONObject);
    }

    public static String d(ImpInfo impInfo) {
        com.kwad.sdk.service.a.f fVar;
        if (Re && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
            try {
                return (String) s.g(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), fVar.getContext());
            } catch (Exception unused) {
                Re = false;
            }
        }
        return "";
    }

    public final int getAdNum() {
        return this.Mp.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.Mp;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        return com.kwad.sdk.g.xL();
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        o.bO(true);
        b.qc().qd();
        super.onCreate();
    }
}

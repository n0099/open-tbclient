package com.kwad.components.core.k.kwai;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.r;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b implements com.kwad.sdk.core.b {
    public SceneImpl HS;
    public long HT = 0;
    public long HU = 0;
    public String sdkExtraData;

    public b(KsScene ksScene) {
        this.HS = (SceneImpl) ksScene;
        if (ba.getPosId() != 0) {
            this.HS.setPosId(ba.getPosId());
        }
    }

    @Nullable
    public final String av(String str) {
        Map<String, String> rewardCallbackExtraData;
        SceneImpl sceneImpl = this.HS;
        if (sceneImpl == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
            return null;
        }
        return rewardCallbackExtraData.get(str);
    }

    @Nullable
    public final com.kwad.sdk.internal.api.a op() {
        SceneImpl sceneImpl = this.HS;
        if (sceneImpl == null) {
            return null;
        }
        return sceneImpl.mKsAdLabel;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = this.HS.toJson();
        r.putValue(json, "pageScene", this.HT);
        r.putValue(json, "subPageScene", this.HU);
        r.putValue(json, "sdkExtraData", this.sdkExtraData);
        String av = av(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
        if (av != null) {
            r.putValue(json, PrefetchEvent.EVENT_DATA_EXTRA_DATA, av);
        }
        return json;
    }
}

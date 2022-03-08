package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f implements com.kwad.sdk.core.b {
    public SceneImpl a;

    /* renamed from: b  reason: collision with root package name */
    public long f54723b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f54724c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f54725d;

    public f(KsScene ksScene) {
        this.a = (SceneImpl) ksScene;
    }

    @Nullable
    public com.kwad.sdk.internal.api.a a() {
        SceneImpl sceneImpl = this.a;
        if (sceneImpl == null) {
            return null;
        }
        return sceneImpl.mKsAdLabel;
    }

    @Nullable
    public String a(String str) {
        SceneImpl sceneImpl;
        Map<String, String> rewardCallbackExtraData;
        if (str == null || (sceneImpl = this.a) == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
            return null;
        }
        return rewardCallbackExtraData.get(str);
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = this.a.toJson();
        t.a(json, "pageScene", this.f54723b);
        t.a(json, "subPageScene", this.f54724c);
        t.a(json, "sdkExtraData", this.f54725d);
        String a = a(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
        if (a != null) {
            t.a(json, PrefetchEvent.EVENT_DATA_EXTRA_DATA, a);
        }
        return json;
    }
}

package com.kwad.sdk.core.g.a;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public SceneImpl f32242a;

    /* renamed from: b  reason: collision with root package name */
    public long f32243b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f32244c = 0;

    public f(KsScene ksScene) {
        this.f32242a = (SceneImpl) ksScene;
    }

    @Nullable
    public String a(String str) {
        SceneImpl sceneImpl;
        Map<String, String> rewardCallbackExtraData;
        if (str == null || (sceneImpl = this.f32242a) == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
            return null;
        }
        return rewardCallbackExtraData.get(str);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = this.f32242a.toJson();
        o.a(json, "pageScene", this.f32243b);
        o.a(json, "subPageScene", this.f32244c);
        String a2 = a(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
        if (a2 != null) {
            o.a(json, PrefetchEvent.EVENT_DATA_EXTRA_DATA, a2);
        }
        return json;
    }
}

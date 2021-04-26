package com.kwad.sdk.core.g.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public SceneImpl f33068a;

    /* renamed from: b  reason: collision with root package name */
    public long f33069b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f33070c = 0;

    public f(KsScene ksScene) {
        this.f33068a = (SceneImpl) ksScene;
    }

    @Nullable
    public String a(String str) {
        SceneImpl sceneImpl;
        Map<String, String> rewardCallbackExtraData;
        if (str == null || (sceneImpl = this.f33068a) == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
            return null;
        }
        return rewardCallbackExtraData.get(str);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = this.f33068a.toJson();
        o.a(json, "pageScene", this.f33069b);
        o.a(json, "subPageScene", this.f33070c);
        String a2 = a("extraData");
        if (a2 != null) {
            o.a(json, "extraData", a2);
        }
        return json;
    }
}

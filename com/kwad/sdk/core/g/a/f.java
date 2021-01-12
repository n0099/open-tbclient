package com.kwad.sdk.core.g.a;

import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public SceneImpl f9165a;

    /* renamed from: b  reason: collision with root package name */
    public long f9166b = 0;
    public long c = 0;

    public f(KsScene ksScene) {
        this.f9165a = (SceneImpl) ksScene;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = this.f9165a.toJson();
        o.a(json, "pageScene", this.f9166b);
        o.a(json, "subPageScene", this.c);
        return json;
    }
}

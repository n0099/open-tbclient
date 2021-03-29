package com.kwad.sdk.core.g.a;

import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public SceneImpl f33651a;

    /* renamed from: b  reason: collision with root package name */
    public long f33652b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f33653c = 0;

    public f(KsScene ksScene) {
        this.f33651a = (SceneImpl) ksScene;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = this.f33651a.toJson();
        o.a(json, "pageScene", this.f33652b);
        o.a(json, "subPageScene", this.f33653c);
        return json;
    }
}

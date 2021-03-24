package com.kwad.sdk.core.g.a;

import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public SceneImpl f33650a;

    /* renamed from: b  reason: collision with root package name */
    public long f33651b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f33652c = 0;

    public f(KsScene ksScene) {
        this.f33650a = (SceneImpl) ksScene;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = this.f33650a.toJson();
        o.a(json, "pageScene", this.f33651b);
        o.a(json, "subPageScene", this.f33652c);
        return json;
    }
}

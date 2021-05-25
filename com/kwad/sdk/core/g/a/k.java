package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f32265a;

    /* renamed from: b  reason: collision with root package name */
    public long f32266b;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "photoId", this.f32265a);
        o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.f32266b);
        return jSONObject;
    }
}

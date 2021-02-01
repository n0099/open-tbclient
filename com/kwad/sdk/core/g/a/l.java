package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f9178a;

    /* renamed from: b  reason: collision with root package name */
    public long f9179b;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "photoId", this.f9178a);
        o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.f9179b);
        return jSONObject;
    }
}

package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f9476a;

    /* renamed from: b  reason: collision with root package name */
    public long f9477b;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "photoId", this.f9476a);
        o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.f9477b);
        return jSONObject;
    }
}

package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f9176a;

    /* renamed from: b  reason: collision with root package name */
    public long f9177b;

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "photoId", this.f9176a);
        o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.f9177b);
        return jSONObject;
    }
}

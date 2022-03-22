package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k implements com.kwad.sdk.core.b {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f39847b;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "photoId", this.a);
        t.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.f39847b);
        return jSONObject;
    }
}

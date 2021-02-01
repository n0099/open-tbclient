package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f9434a;

    /* renamed from: b  reason: collision with root package name */
    public int f9435b;
    public boolean c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f9434a = jSONObject.optLong("posId");
        this.f9435b = jSONObject.optInt("adPhotoCountForMedia");
        this.c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.f9434a);
        o.a(jSONObject, "adPhotoCountForMedia", this.f9435b);
        o.a(jSONObject, "enablePreload", this.c);
        return jSONObject;
    }
}

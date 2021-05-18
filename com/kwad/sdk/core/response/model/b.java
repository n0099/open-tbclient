package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f32690a;

    /* renamed from: b  reason: collision with root package name */
    public int f32691b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32692c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f32690a = jSONObject.optLong("posId");
        this.f32691b = jSONObject.optInt("adPhotoCountForMedia");
        this.f32692c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.f32690a);
        o.a(jSONObject, "adPhotoCountForMedia", this.f32691b);
        o.a(jSONObject, "enablePreload", this.f32692c);
        return jSONObject;
    }
}

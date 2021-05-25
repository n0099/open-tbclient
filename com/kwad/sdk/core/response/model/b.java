package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f32619a;

    /* renamed from: b  reason: collision with root package name */
    public int f32620b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32621c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f32619a = jSONObject.optLong("posId");
        this.f32620b = jSONObject.optInt("adPhotoCountForMedia");
        this.f32621c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.f32619a);
        o.a(jSONObject, "adPhotoCountForMedia", this.f32620b);
        o.a(jSONObject, "enablePreload", this.f32621c);
        return jSONObject;
    }
}

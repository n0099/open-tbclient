package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f9432a;

    /* renamed from: b  reason: collision with root package name */
    public int f9433b;
    public boolean c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f9432a = jSONObject.optLong("posId");
        this.f9433b = jSONObject.optInt("adPhotoCountForMedia");
        this.c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.f9432a);
        o.a(jSONObject, "adPhotoCountForMedia", this.f9433b);
        o.a(jSONObject, "enablePreload", this.c);
        return jSONObject;
    }
}

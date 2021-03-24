package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f34072a;

    /* renamed from: b  reason: collision with root package name */
    public int f34073b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34074c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f34072a = jSONObject.optLong("posId");
        this.f34073b = jSONObject.optInt("adPhotoCountForMedia");
        this.f34074c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.f34072a);
        o.a(jSONObject, "adPhotoCountForMedia", this.f34073b);
        o.a(jSONObject, "enablePreload", this.f34074c);
        return jSONObject;
    }
}

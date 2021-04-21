package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f34457a;

    /* renamed from: b  reason: collision with root package name */
    public int f34458b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34459c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f34457a = jSONObject.optLong("posId");
        this.f34458b = jSONObject.optInt("adPhotoCountForMedia");
        this.f34459c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.f34457a);
        o.a(jSONObject, "adPhotoCountForMedia", this.f34458b);
        o.a(jSONObject, "enablePreload", this.f34459c);
        return jSONObject;
    }
}

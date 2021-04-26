package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f33445a;

    /* renamed from: b  reason: collision with root package name */
    public int f33446b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33447c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f33445a = jSONObject.optLong("posId");
        this.f33446b = jSONObject.optInt("adPhotoCountForMedia");
        this.f33447c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.f33445a);
        o.a(jSONObject, "adPhotoCountForMedia", this.f33446b);
        o.a(jSONObject, "enablePreload", this.f33447c);
        return jSONObject;
    }
}

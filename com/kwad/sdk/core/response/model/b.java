package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public long f34362a;

    /* renamed from: b  reason: collision with root package name */
    public int f34363b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34364c;

    public void a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f34362a = jSONObject.optLong("posId");
        this.f34363b = jSONObject.optInt("adPhotoCountForMedia");
        this.f34364c = jSONObject.optBoolean("enablePreload");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.f34362a);
        o.a(jSONObject, "adPhotoCountForMedia", this.f34363b);
        o.a(jSONObject, "enablePreload", this.f34364c);
        return jSONObject;
    }
}

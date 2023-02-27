package com.kwad.components.core.k.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class d implements com.kwad.sdk.core.b {
    public long Iw;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "photoId", this.photoId);
        r.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.Iw);
        return jSONObject;
    }
}

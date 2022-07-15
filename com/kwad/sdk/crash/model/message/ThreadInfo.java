package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ThreadInfo implements b, Serializable {
    public static final long serialVersionUID = -1743841938230203418L;
    public int mIndex;
    public String mName;
    public int mTid;
    public String mTrace;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mName = jSONObject.optString("mName");
        this.mTrace = jSONObject.optString("mTrace");
        this.mTid = jSONObject.optInt("mTid");
        this.mIndex = jSONObject.optInt("mIndex");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "mName", this.mName);
        r.a(jSONObject, "mTrace", this.mTrace);
        r.a(jSONObject, "mTid", this.mTid);
        r.a(jSONObject, "mIndex", this.mIndex);
        return jSONObject;
    }
}

package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ThreadInfo implements b, Serializable {
    public static final long serialVersionUID = -1743841938230203418L;
    public int mIndex;
    public String mName;
    public int mTid;
    public String mTrace;

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mName = jSONObject.optString("mName");
        this.mTrace = jSONObject.optString("mTrace");
        this.mTid = jSONObject.optInt("mTid");
        this.mIndex = jSONObject.optInt("mIndex");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "mName", this.mName);
        o.a(jSONObject, "mTrace", this.mTrace);
        o.a(jSONObject, "mTid", this.mTid);
        o.a(jSONObject, "mIndex", this.mIndex);
        return jSONObject;
    }
}

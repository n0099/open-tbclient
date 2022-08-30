package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.utils.s;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
@KsJson
/* loaded from: classes7.dex */
public class URLPackage extends a implements Serializable {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_CHANNEL_ID = "channelId";
    public static final String KEY_TUBE_ID = "tubeId";
    public static final long serialVersionUID = -7365796297335816787L;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;

    public URLPackage() {
    }

    public URLPackage(@NonNull String str, int i) {
        this.page = i;
        this.identity = str;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("params");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        try {
            this.mJsonObjectParams = new JSONObject(optString);
        } catch (JSONException e) {
            b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mJsonObjectParams;
        if (jSONObject2 != null) {
            s.putValue(jSONObject, "params", jSONObject2.toString());
        }
    }

    public void putParams(String str, long j) {
        if (this.mJsonObjectParams == null) {
            this.mJsonObjectParams = new JSONObject();
        }
        s.putValue(this.mJsonObjectParams, str, j);
    }
}

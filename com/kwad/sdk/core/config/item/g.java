package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g extends a<String> {
    public g(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putString(a(), b());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((g) sharedPreferences.getString(a(), c()));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        a((g) ((jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) ? c() : optJSONObject.toString()));
    }
}

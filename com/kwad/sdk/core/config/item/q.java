package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q extends a<String> {
    public q(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putString(b(), a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((q) sharedPreferences.getString(b(), c()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        String optString = jSONObject != null ? jSONObject.optString(b(), c()) : null;
        if (TextUtils.isEmpty(optString)) {
            optString = c();
        }
        a((q) optString);
    }
}

package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j extends a<Integer> {
    public j(String str, Integer num) {
        super(str, num);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putInt(b(), a().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((j) Integer.valueOf(sharedPreferences.getInt(b(), c().intValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        a((j) (jSONObject != null ? Integer.valueOf(jSONObject.optInt(b(), c().intValue())) : c()));
    }
}

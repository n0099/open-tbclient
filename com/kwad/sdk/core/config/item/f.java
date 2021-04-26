package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends a<Integer> {
    public f(String str, Integer num) {
        super(str, num);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putInt(a(), b().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((f) Integer.valueOf(sharedPreferences.getInt(a(), c().intValue())));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        a((f) (jSONObject != null ? Integer.valueOf(jSONObject.optInt(a(), c().intValue())) : c()));
    }
}

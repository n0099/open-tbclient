package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l extends a<Long> {
    public l(String str, Long l) {
        super(str, l);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putLong(b(), a().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((l) Long.valueOf(sharedPreferences.getLong(b(), c().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        a((l) (jSONObject != null ? Long.valueOf(jSONObject.optLong(b(), c().longValue())) : c()));
    }
}

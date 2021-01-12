package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g extends a<Long> {
    public g(String str, Long l) {
        super(str, l);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putLong(a(), b().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((g) Long.valueOf(sharedPreferences.getLong(a(), c().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            a((g) Long.valueOf(jSONObject.optLong(a(), c().longValue())));
        } else {
            a((g) c());
        }
    }
}

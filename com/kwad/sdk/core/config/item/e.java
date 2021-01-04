package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e extends a<Integer> {
    public e(String str, Integer num) {
        super(str, num);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putInt(a(), b().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        a((e) Integer.valueOf(sharedPreferences.getInt(a(), c().intValue())));
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            a((e) Integer.valueOf(jSONObject.optInt(a(), c().intValue())));
        } else {
            a((e) c());
        }
    }
}

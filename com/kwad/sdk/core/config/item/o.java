package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class o extends a {
    public o(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(b.bu(sharedPreferences.getString(getKey(), (String) sx())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString(getKey(), b.bt(getValue()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        String optString = jSONObject != null ? jSONObject.optString(getKey(), (String) sx()) : null;
        if (TextUtils.isEmpty(optString)) {
            setValue(sx());
        } else {
            setValue(optString);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    public final String getValue() {
        return (String) super.getValue();
    }
}

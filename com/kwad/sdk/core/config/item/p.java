package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class p extends a<String> {
    public p(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(b.cN(sharedPreferences.getString(getKey(), Bx())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), b.cM(getValue()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void j(JSONObject jSONObject) {
        String str;
        if (jSONObject != null) {
            str = jSONObject.optString(getKey(), Bx());
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            setValue(Bx());
        } else {
            setValue(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    public final String getValue() {
        return (String) super.getValue();
    }
}

package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class k extends b<String> {
    public boolean VF;

    public k(String str, String str2) {
        super(str, str2);
        this.VF = false;
    }

    public k(String str, String str2, boolean z) {
        this(str, str2);
        this.VF = false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        if (this.VF) {
            setValue(sharedPreferences.getString(getKey(), sx()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        if (this.VF) {
            editor.putString(getKey(), getValue());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        setValue((jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) ? sx() : optJSONObject.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    public final String getValue() {
        return (String) super.getValue();
    }
}

package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class n extends a<String> {
    public n(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        editor.putString(a(), b());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        a((n) sharedPreferences.getString(a(), c()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        String optString = jSONObject != null ? jSONObject.optString(a(), c()) : null;
        if (TextUtils.isEmpty(optString)) {
            a((n) c());
        } else {
            a((n) optString);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: d */
    public final String b() {
        return (String) super.b();
    }
}

package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class j extends b<String> {
    public boolean a;

    public j(String str, String str2) {
        super(str, str2);
        this.a = false;
    }

    public j(String str, String str2, boolean z) {
        this(str, str2);
        this.a = false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        if (this.a) {
            editor.putString(a(), b());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        if (this.a) {
            a((j) sharedPreferences.getString(a(), c()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        a((j) ((jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) ? c() : optJSONObject.toString()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* renamed from: d */
    public final String b() {
        return (String) super.b();
    }
}

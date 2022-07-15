package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class l extends b<String> {
    public static volatile String[] a;

    public l(String str, String str2) {
        super(str, str2);
        a = null;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = str.split(",");
    }

    public static boolean a(long j) {
        String[] strArr;
        if (a == null) {
            return false;
        }
        for (String str : a) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        editor.putString(a(), b());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(a(), c());
        a((l) string);
        a(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            a((l) c());
            return;
        }
        String optString = jSONObject.optString(a(), c());
        a((l) optString);
        a(optString);
    }
}

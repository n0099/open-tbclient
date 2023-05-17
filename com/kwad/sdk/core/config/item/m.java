package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class m extends b<String> {
    public static volatile String[] VG;

    public m(String str, String str2) {
        super(str, str2);
        VG = null;
    }

    public static void bv(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        VG = str.split(",");
    }

    public static boolean h(long j) {
        String[] strArr;
        if (VG == null) {
            return false;
        }
        for (String str : VG) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), sx());
        setValue(string);
        bv(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            setValue(sx());
            return;
        }
        String optString = jSONObject.optString(getKey(), sx());
        setValue(optString);
        bv(optString);
    }
}

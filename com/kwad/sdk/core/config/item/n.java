package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class n extends b<String> {
    public static volatile String[] arm;

    public n(String str, String str2) {
        super(str, str2);
        arm = null;
    }

    public static boolean S(long j) {
        String[] strArr;
        if (arm == null) {
            return false;
        }
        for (String str : arm) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    public static void cO(String str) {
        if (!TextUtils.isEmpty(str)) {
            arm = str.split(",");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), Bx());
        setValue(string);
        cO(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(getKey(), Bx());
            setValue(optString);
            cO(optString);
            return;
        }
        setValue(Bx());
    }
}

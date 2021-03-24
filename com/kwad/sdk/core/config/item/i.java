package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i extends a<String> {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String[] f33456a;

    public i(String str, String str2) {
        super(str, str2);
        f33456a = null;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f33456a = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putString(a(), b());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(a(), c());
        a((i) string);
        a(string);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            a((i) c());
            return;
        }
        String optString = jSONObject.optString(a(), c());
        a((i) optString);
        a(optString);
    }

    public boolean a(long j) {
        String[] strArr;
        if (f33456a == null) {
            return false;
        }
        for (String str : f33456a) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }
}

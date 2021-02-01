package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public final class ax {
    public static boolean abE(String str) {
        return !TextUtils.isEmpty(str) && str.length() > 3;
    }

    public static boolean bJ(Context context, String str) {
        String m63b = az.m63b(context);
        if (TextUtils.isEmpty(m63b)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(m63b);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString) && optString.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}

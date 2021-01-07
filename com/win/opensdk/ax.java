package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public final class ax {
    public static boolean abK(String str) {
        return !TextUtils.isEmpty(str) && str.length() > 3;
    }

    public static boolean bK(Context context, String str) {
        String m67b = az.m67b(context);
        if (TextUtils.isEmpty(m67b)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(m67b);
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

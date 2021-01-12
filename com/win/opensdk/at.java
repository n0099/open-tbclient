package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.win.opensdk.as;
/* loaded from: classes3.dex */
public final class at {
    static final String java = at.class.getCanonicalName();

    private static String iO(Context context) {
        try {
            as.a iN = as.iN(context);
            String str = iN == null ? null : iN.java;
            if (TextUtils.isEmpty(str)) {
                az.bJ(context, str);
                return str;
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    public static String iP(Context context) {
        String iP = az.iP(context);
        return !TextUtils.isEmpty(iP) ? iP : iO(context);
    }
}

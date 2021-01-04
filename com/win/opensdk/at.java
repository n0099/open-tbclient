package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.win.opensdk.as;
/* loaded from: classes4.dex */
public final class at {
    static final String java = at.class.getCanonicalName();

    private static String iQ(Context context) {
        try {
            as.a iP = as.iP(context);
            String str = iP == null ? null : iP.java;
            if (TextUtils.isEmpty(str)) {
                az.bJ(context, str);
                return str;
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    public static String iR(Context context) {
        String iR = az.iR(context);
        return !TextUtils.isEmpty(iR) ? iR : iQ(context);
    }
}

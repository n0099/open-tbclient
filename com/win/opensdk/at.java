package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.win.opensdk.as;
/* loaded from: classes3.dex */
public final class at {
    static final String java = at.class.getCanonicalName();

    private static String iR(Context context) {
        try {
            as.a iQ = as.iQ(context);
            String str = iQ == null ? null : iQ.java;
            if (TextUtils.isEmpty(str)) {
                az.bH(context, str);
                return str;
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    public static String iS(Context context) {
        String iS = az.iS(context);
        return !TextUtils.isEmpty(iS) ? iS : iR(context);
    }
}

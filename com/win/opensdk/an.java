package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes14.dex */
public final class an {
    public static String a(Context context) {
        String i = bp.i(context);
        if (TextUtils.isEmpty(i)) {
            try {
                ai iM = ak.iM(context);
                String str = iM == null ? null : iM.f8109a;
                if (TextUtils.isEmpty(str)) {
                    bp.f(context, str);
                    return str;
                }
                return str;
            } catch (Exception e) {
                return null;
            }
        }
        return i;
    }
}

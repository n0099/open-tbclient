package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class M1 {
    public static String a(Context context) {
        String i = V1.i(context);
        if (TextUtils.isEmpty(i)) {
            try {
                K1 a2 = L1.a(context);
                String str = a2 == null ? null : a2.f39706a;
                if (TextUtils.isEmpty(str)) {
                    V1.f(context, str);
                }
                return str;
            } catch (Exception unused) {
                return null;
            }
        }
        return i;
    }
}

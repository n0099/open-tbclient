package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class j1 {
    public static String a(Context context) {
        String i2 = s1.i(context);
        if (TextUtils.isEmpty(i2)) {
            try {
                h1 a2 = i1.a(context);
                String str = a2 == null ? null : a2.f40732a;
                if (TextUtils.isEmpty(str)) {
                    s1.f(context, str);
                }
                return str;
            } catch (Exception unused) {
                return null;
            }
        }
        return i2;
    }
}

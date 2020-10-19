package com.kascend.chushou.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes6.dex */
public final class f {
    public static final int a(String str, @ColorRes int i) {
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
                return tv.chushou.widget.a.c.getColor(i);
            }
        }
        return tv.chushou.widget.a.c.getColor(i);
    }

    public static final String b(String str, @StringRes int i) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            String string = tv.chushou.widget.a.c.getString(i);
            q.m(string, "Res.getString(id)");
            return string;
        } else if (str == null) {
            q.eob();
            return str;
        } else {
            return str;
        }
    }

    public static final Activity gP(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return gP(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}

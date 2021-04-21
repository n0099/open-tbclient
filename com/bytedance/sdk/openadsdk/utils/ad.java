package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public static String f30055a;

    /* renamed from: b  reason: collision with root package name */
    public static Resources f30056b;

    public static String a(Context context) {
        if (f30055a == null) {
            f30055a = context.getPackageName();
        }
        return f30055a;
    }

    public static int b(Context context, String str) {
        return a(context, str, "string");
    }

    public static Drawable c(Context context, String str) {
        return context.getResources().getDrawable(d(context, str));
    }

    public static int d(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static int e(Context context, String str) {
        return a(context, str, "id");
    }

    public static int f(Context context, String str) {
        return a(context, str, "layout");
    }

    public static int g(Context context, String str) {
        return a(context, str, "style");
    }

    public static int h(Context context, String str) {
        return a(context, str, "dimen");
    }

    public static int i(Context context, String str) {
        return context.getResources().getColor(j(context, str));
    }

    public static int j(Context context, String str) {
        return a(context, str, "color");
    }

    public static int k(Context context, String str) {
        return a(context, str, "integer");
    }

    public static int l(Context context, String str) {
        return context.getResources().getInteger(k(context, str));
    }

    public static int a(Context context, String str, String str2) {
        if (f30056b == null) {
            f30056b = context.getResources();
        }
        return f30056b.getIdentifier(str, str2, a(context));
    }

    public static String a(Context context, String str) {
        return context.getResources().getString(b(context, str));
    }
}

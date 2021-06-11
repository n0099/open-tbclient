package d.a.j0.g;

import android.content.Context;
import android.text.TextUtils;
import d.a.j0.l.c;
import d.a.j0.l.d;
import d.a.j0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f44088a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44089b;

    public static String a(Context context) {
        return d.a(context);
    }

    public static String b(Context context, boolean z, boolean z2) {
        String str;
        if (!d.a.j0.b.a.h(context).e()) {
            return k.c(String.valueOf(-1000), z2);
        }
        if (z && !TextUtils.isEmpty(f44089b)) {
            return f44089b;
        }
        if (d.a.j0.b.a.h(context).c()) {
            str = d.a.j0.d.a.b(context);
        } else if (c.o(context)) {
            str = d.a.j0.d.a.b(context);
        } else if (!z) {
            return k.c(String.valueOf(-1002), z2);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            d.a.j0.b.a.h(context).m(str);
        } else if (z) {
            str = d.a.j0.b.a.h(context).O();
        } else {
            return k.c(String.valueOf(-1003), z2);
        }
        if (TextUtils.isEmpty(str)) {
            return k.c(String.valueOf(-1003), z2);
        }
        f44089b = str;
        return str;
    }

    public static String c(Context context) {
        return d.h(context);
    }

    public static String d(Context context, boolean z, boolean z2) {
        if (!d.a.j0.b.a.h(context).e()) {
            return k.c(String.valueOf(-1000), z2);
        }
        if (z && !TextUtils.isEmpty(f44088a)) {
            return f44088a;
        }
        if (!c.o(context)) {
            return k.c(String.valueOf(-1002), z2);
        }
        String a2 = d.a.j0.m.a.b().a();
        if (TextUtils.isEmpty(a2)) {
            return k.c(String.valueOf(-1003), z2);
        }
        f44088a = a2;
        return a2;
    }
}

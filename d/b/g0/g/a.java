package d.b.g0.g;

import android.content.Context;
import android.text.TextUtils;
import d.b.g0.l.c;
import d.b.g0.l.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f43651a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43652b;

    public static String a(Context context) {
        return d.a(context);
    }

    public static String b(Context context) {
        if (d.b.g0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f43652b)) {
                return f43652b;
            }
            if (d.b.g0.b.a.g(context).b()) {
                f43652b = d.b.g0.d.a.b(context);
            } else if (c.o(context)) {
                f43652b = d.b.g0.d.a.b(context);
            }
            if (TextUtils.isEmpty(f43652b)) {
                f43652b = d.b.g0.b.a.g(context).M();
            } else {
                d.b.g0.b.a.g(context).l(f43652b);
            }
            return f43652b;
        }
        return "";
    }

    public static String c(Context context) {
        return d.j(context);
    }

    public static String d(Context context) {
        if (d.b.g0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f43651a)) {
                return f43651a;
            }
            if (c.o(context)) {
                String a2 = d.b.g0.m.a.b().a();
                f43651a = a2;
                return a2;
            }
            return "";
        }
        return "";
    }
}

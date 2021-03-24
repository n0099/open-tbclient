package d.b.f0.g;

import android.content.Context;
import android.text.TextUtils;
import d.b.f0.l.c;
import d.b.f0.l.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f42961a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42962b;

    public static String a(Context context) {
        return d.a(context);
    }

    public static String b(Context context) {
        if (d.b.f0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f42962b)) {
                return f42962b;
            }
            if (d.b.f0.b.a.g(context).b()) {
                f42962b = d.b.f0.d.a.b(context);
            } else if (c.o(context)) {
                f42962b = d.b.f0.d.a.b(context);
            }
            if (TextUtils.isEmpty(f42962b)) {
                f42962b = d.b.f0.b.a.g(context).M();
            } else {
                d.b.f0.b.a.g(context).l(f42962b);
            }
            return f42962b;
        }
        return "";
    }

    public static String c(Context context) {
        return d.j(context);
    }

    public static String d(Context context) {
        if (d.b.f0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f42961a)) {
                return f42961a;
            }
            if (c.o(context)) {
                String a2 = d.b.f0.m.a.b().a();
                f42961a = a2;
                return a2;
            }
            return "";
        }
        return "";
    }
}

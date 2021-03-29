package d.b.f0.g;

import android.content.Context;
import android.text.TextUtils;
import d.b.f0.l.c;
import d.b.f0.l.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f42962a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42963b;

    public static String a(Context context) {
        return d.a(context);
    }

    public static String b(Context context) {
        if (d.b.f0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f42963b)) {
                return f42963b;
            }
            if (d.b.f0.b.a.g(context).b()) {
                f42963b = d.b.f0.d.a.b(context);
            } else if (c.o(context)) {
                f42963b = d.b.f0.d.a.b(context);
            }
            if (TextUtils.isEmpty(f42963b)) {
                f42963b = d.b.f0.b.a.g(context).M();
            } else {
                d.b.f0.b.a.g(context).l(f42963b);
            }
            return f42963b;
        }
        return "";
    }

    public static String c(Context context) {
        return d.j(context);
    }

    public static String d(Context context) {
        if (d.b.f0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f42962a)) {
                return f42962a;
            }
            if (c.o(context)) {
                String a2 = d.b.f0.m.a.b().a();
                f42962a = a2;
                return a2;
            }
            return "";
        }
        return "";
    }
}

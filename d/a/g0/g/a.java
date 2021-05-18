package d.a.g0.g;

import android.content.Context;
import android.text.TextUtils;
import d.a.g0.l.c;
import d.a.g0.l.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f40148a;

    /* renamed from: b  reason: collision with root package name */
    public static String f40149b;

    public static String a(Context context) {
        return d.a(context);
    }

    public static String b(Context context) {
        if (d.a.g0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f40149b)) {
                return f40149b;
            }
            if (d.a.g0.b.a.g(context).b()) {
                f40149b = d.a.g0.d.a.b(context);
            } else if (c.o(context)) {
                f40149b = d.a.g0.d.a.b(context);
            }
            if (TextUtils.isEmpty(f40149b)) {
                f40149b = d.a.g0.b.a.g(context).M();
            } else {
                d.a.g0.b.a.g(context).l(f40149b);
            }
            return f40149b;
        }
        return "";
    }

    public static String c(Context context) {
        return d.j(context);
    }

    public static String d(Context context) {
        if (d.a.g0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f40148a)) {
                return f40148a;
            }
            if (c.o(context)) {
                String a2 = d.a.g0.m.a.b().a();
                f40148a = a2;
                return a2;
            }
            return "";
        }
        return "";
    }
}

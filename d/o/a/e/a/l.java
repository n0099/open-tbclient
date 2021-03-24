package d.o.a.e.a;

import android.content.Context;
/* loaded from: classes7.dex */
public class l {
    public static int a(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int b(String str) {
        try {
            return d.o.a.e.b.g.d.l().getResources().getIdentifier(str, "layout", d.o.a.e.b.g.d.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int c(String str, String str2) {
        try {
            return d.o.a.e.b.g.d.l().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int d(String str) {
        return a(d.o.a.e.b.g.d.l(), str);
    }

    public static int e(String str, String str2) {
        try {
            return d.o.a.e.b.g.d.l().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return c(str, d.o.a.e.b.g.d.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int g(String str) {
        try {
            return d.o.a.e.b.g.d.l().getResources().getIdentifier(str, "style", d.o.a.e.b.g.d.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int h(String str) {
        try {
            return d.o.a.e.b.g.d.l().getResources().getIdentifier(str, "id", d.o.a.e.b.g.d.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int i(String str) {
        try {
            return d.o.a.e.b.g.d.l().getResources().getIdentifier(str, "color", d.o.a.e.b.g.d.l().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}

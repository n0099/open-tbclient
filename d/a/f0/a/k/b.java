package d.a.f0.a.k;

import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f43528a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f43529b;

    static {
        f43528a = e.f43531b ? 2 : 4;
        f43529b = null;
    }

    public static b i() {
        if (f43529b == null) {
            synchronized (b.class) {
                if (f43529b == null) {
                    f43529b = new b();
                }
            }
        }
        return f43529b;
    }

    public int a(String str) {
        return b("BaiduAdCommon", str);
    }

    public int b(String str, String str2) {
        if (k(3)) {
            try {
                return Log.d(str, str2);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int c(String str, Throwable th) {
        if (k(3)) {
            try {
                return Log.d("BaiduAdCommon", str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int d(Throwable th) {
        return c("", th);
    }

    public int e(String str) {
        if (k(6)) {
            try {
                return Log.e("BaiduAdCommon", str);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int f(String str, Throwable th) {
        if (k(6)) {
            try {
                return Log.e("BaiduAdCommon", str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int g(Throwable th) {
        return f("", th);
    }

    public int h(Object... objArr) {
        if (k(6)) {
            return e(m(objArr));
        }
        return -1;
    }

    public int j(String str, String str2) {
        if (k(4)) {
            try {
                return Log.i(str, str2);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public boolean k(int i2) {
        return l("BaiduAdCommon", i2);
    }

    public boolean l(String str, int i2) {
        return i2 >= f43528a;
    }

    public final String m(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(' ');
        }
        return sb.toString();
    }
}

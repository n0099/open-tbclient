package d.b.d0.a.k;

import android.util.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f43374a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f43375b;

    static {
        f43374a = e.f43377b ? 2 : 4;
        f43375b = null;
    }

    public static b i() {
        if (f43375b == null) {
            synchronized (b.class) {
                if (f43375b == null) {
                    f43375b = new b();
                }
            }
        }
        return f43375b;
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

    public boolean k(int i) {
        return l("BaiduAdCommon", i);
    }

    public boolean l(String str, int i) {
        return i >= f43374a;
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

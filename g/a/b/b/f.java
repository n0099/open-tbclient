package g.a.b.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes8.dex */
public abstract class f implements g.a.a.b {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f71548h = true;

    /* renamed from: a  reason: collision with root package name */
    public int f71549a;

    /* renamed from: b  reason: collision with root package name */
    public String f71550b;

    /* renamed from: c  reason: collision with root package name */
    public String f71551c;

    /* renamed from: d  reason: collision with root package name */
    public Class f71552d;

    /* renamed from: e  reason: collision with root package name */
    public a f71553e;

    /* renamed from: f  reason: collision with root package name */
    public String f71554f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f71555g = null;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i2, String str);

        String get(int i2);
    }

    /* loaded from: classes8.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f71556a;

        public b() {
            c();
        }

        @Override // g.a.b.b.f.a
        public void a(int i2, String str) {
            String[] b2 = b();
            if (b2 == null) {
                b2 = c();
            }
            b2[i2] = str;
        }

        public final String[] b() {
            return (String[]) this.f71556a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f71556a = new SoftReference(strArr);
            return strArr;
        }

        @Override // g.a.b.b.f.a
        public String get(int i2) {
            String[] b2 = b();
            if (b2 == null) {
                return null;
            }
            return b2[i2];
        }
    }

    public f(int i2, String str, Class cls) {
        this.f71549a = -1;
        this.f71549a = i2;
        this.f71550b = str;
        this.f71552d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i2) {
        return Integer.parseInt(c(i2), 16);
    }

    public String c(int i2) {
        int indexOf = this.f71554f.indexOf(45);
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i3 = indexOf + 1;
            indexOf = this.f71554f.indexOf(45, i3);
            i2 = i4;
        }
        if (indexOf == -1) {
            indexOf = this.f71554f.length();
        }
        return this.f71554f.substring(i3, indexOf);
    }

    public Class d(int i2) {
        return g.a.b.b.b.b(c(i2), h());
    }

    public Class[] e(int i2) {
        StringTokenizer stringTokenizer = new StringTokenizer(c(i2), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i3 = 0; i3 < countTokens; i3++) {
            clsArr[i3] = g.a.b.b.b.b(stringTokenizer.nextToken(), h());
        }
        return clsArr;
    }

    public Class f() {
        if (this.f71552d == null) {
            this.f71552d = d(2);
        }
        return this.f71552d;
    }

    public String g() {
        if (this.f71551c == null) {
            this.f71551c = f().getName();
        }
        return this.f71551c;
    }

    public final ClassLoader h() {
        if (this.f71555g == null) {
            this.f71555g = getClass().getClassLoader();
        }
        return this.f71555g;
    }

    public int i() {
        if (this.f71549a == -1) {
            this.f71549a = b(0);
        }
        return this.f71549a;
    }

    public String j() {
        if (this.f71550b == null) {
            this.f71550b = c(1);
        }
        return this.f71550b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(h hVar) {
        String str;
        if (f71548h) {
            a aVar = this.f71553e;
            if (aVar == null) {
                try {
                    this.f71553e = new b();
                } catch (Throwable unused) {
                    f71548h = false;
                }
            } else {
                str = aVar.get(hVar.f71567f);
                if (str == null) {
                    str = a(hVar);
                }
                if (f71548h) {
                    this.f71553e.a(hVar.f71567f, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f71548h) {
        }
        return str;
    }

    public final String toString() {
        return k(h.f71560h);
    }
}

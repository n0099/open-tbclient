package g.a.b.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public abstract class f implements g.a.a.b {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f68560h = true;

    /* renamed from: a  reason: collision with root package name */
    public int f68561a;

    /* renamed from: b  reason: collision with root package name */
    public String f68562b;

    /* renamed from: c  reason: collision with root package name */
    public String f68563c;

    /* renamed from: d  reason: collision with root package name */
    public Class f68564d;

    /* renamed from: e  reason: collision with root package name */
    public a f68565e;

    /* renamed from: f  reason: collision with root package name */
    public String f68566f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f68567g = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str);

        String get(int i);
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f68568a;

        public b() {
            c();
        }

        @Override // g.a.b.b.f.a
        public void a(int i, String str) {
            String[] b2 = b();
            if (b2 == null) {
                b2 = c();
            }
            b2[i] = str;
        }

        public final String[] b() {
            return (String[]) this.f68568a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f68568a = new SoftReference(strArr);
            return strArr;
        }

        @Override // g.a.b.b.f.a
        public String get(int i) {
            String[] b2 = b();
            if (b2 == null) {
                return null;
            }
            return b2[i];
        }
    }

    public f(int i, String str, Class cls) {
        this.f68561a = -1;
        this.f68561a = i;
        this.f68562b = str;
        this.f68564d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i) {
        return Integer.parseInt(c(i), 16);
    }

    public String c(int i) {
        int indexOf = this.f68566f.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.f68566f.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.f68566f.length();
        }
        return this.f68566f.substring(i2, indexOf);
    }

    public Class d(int i) {
        return g.a.b.b.b.b(c(i), h());
    }

    public Class[] e(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(c(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = g.a.b.b.b.b(stringTokenizer.nextToken(), h());
        }
        return clsArr;
    }

    public Class f() {
        if (this.f68564d == null) {
            this.f68564d = d(2);
        }
        return this.f68564d;
    }

    public String g() {
        if (this.f68563c == null) {
            this.f68563c = f().getName();
        }
        return this.f68563c;
    }

    public final ClassLoader h() {
        if (this.f68567g == null) {
            this.f68567g = getClass().getClassLoader();
        }
        return this.f68567g;
    }

    public int i() {
        if (this.f68561a == -1) {
            this.f68561a = b(0);
        }
        return this.f68561a;
    }

    public String j() {
        if (this.f68562b == null) {
            this.f68562b = c(1);
        }
        return this.f68562b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(h hVar) {
        String str;
        if (f68560h) {
            a aVar = this.f68565e;
            if (aVar == null) {
                try {
                    this.f68565e = new b();
                } catch (Throwable unused) {
                    f68560h = false;
                }
            } else {
                str = aVar.get(hVar.f68578f);
                if (str == null) {
                    str = a(hVar);
                }
                if (f68560h) {
                    this.f68565e.a(hVar.f68578f, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f68560h) {
        }
        return str;
    }

    public final String toString() {
        return k(h.f68572h);
    }
}

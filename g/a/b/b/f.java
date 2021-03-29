package g.a.b.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public abstract class f implements g.a.a.b {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f67554h = true;

    /* renamed from: a  reason: collision with root package name */
    public int f67555a;

    /* renamed from: b  reason: collision with root package name */
    public String f67556b;

    /* renamed from: c  reason: collision with root package name */
    public String f67557c;

    /* renamed from: d  reason: collision with root package name */
    public Class f67558d;

    /* renamed from: e  reason: collision with root package name */
    public a f67559e;

    /* renamed from: f  reason: collision with root package name */
    public String f67560f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f67561g = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str);

        String get(int i);
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f67562a;

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
            return (String[]) this.f67562a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f67562a = new SoftReference(strArr);
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
        this.f67555a = -1;
        this.f67555a = i;
        this.f67556b = str;
        this.f67558d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i) {
        return Integer.parseInt(c(i), 16);
    }

    public String c(int i) {
        int indexOf = this.f67560f.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.f67560f.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.f67560f.length();
        }
        return this.f67560f.substring(i2, indexOf);
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
        if (this.f67558d == null) {
            this.f67558d = d(2);
        }
        return this.f67558d;
    }

    public String g() {
        if (this.f67557c == null) {
            this.f67557c = f().getName();
        }
        return this.f67557c;
    }

    public final ClassLoader h() {
        if (this.f67561g == null) {
            this.f67561g = getClass().getClassLoader();
        }
        return this.f67561g;
    }

    public int i() {
        if (this.f67555a == -1) {
            this.f67555a = b(0);
        }
        return this.f67555a;
    }

    public String j() {
        if (this.f67556b == null) {
            this.f67556b = c(1);
        }
        return this.f67556b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(h hVar) {
        String str;
        if (f67554h) {
            a aVar = this.f67559e;
            if (aVar == null) {
                try {
                    this.f67559e = new b();
                } catch (Throwable unused) {
                    f67554h = false;
                }
            } else {
                str = aVar.get(hVar.f67572f);
                if (str == null) {
                    str = a(hVar);
                }
                if (f67554h) {
                    this.f67559e.a(hVar.f67572f, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f67554h) {
        }
        return str;
    }

    public final String toString() {
        return k(h.f67566h);
    }
}

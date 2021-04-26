package g.a.b.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public abstract class f implements g.a.a.b {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f67563h = true;

    /* renamed from: a  reason: collision with root package name */
    public int f67564a;

    /* renamed from: b  reason: collision with root package name */
    public String f67565b;

    /* renamed from: c  reason: collision with root package name */
    public String f67566c;

    /* renamed from: d  reason: collision with root package name */
    public Class f67567d;

    /* renamed from: e  reason: collision with root package name */
    public a f67568e;

    /* renamed from: f  reason: collision with root package name */
    public String f67569f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f67570g = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2, String str);

        String get(int i2);
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f67571a;

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
            return (String[]) this.f67571a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f67571a = new SoftReference(strArr);
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
        this.f67564a = -1;
        this.f67564a = i2;
        this.f67565b = str;
        this.f67567d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i2) {
        return Integer.parseInt(c(i2), 16);
    }

    public String c(int i2) {
        int indexOf = this.f67569f.indexOf(45);
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i3 = indexOf + 1;
            indexOf = this.f67569f.indexOf(45, i3);
            i2 = i4;
        }
        if (indexOf == -1) {
            indexOf = this.f67569f.length();
        }
        return this.f67569f.substring(i3, indexOf);
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
        if (this.f67567d == null) {
            this.f67567d = d(2);
        }
        return this.f67567d;
    }

    public String g() {
        if (this.f67566c == null) {
            this.f67566c = f().getName();
        }
        return this.f67566c;
    }

    public final ClassLoader h() {
        if (this.f67570g == null) {
            this.f67570g = getClass().getClassLoader();
        }
        return this.f67570g;
    }

    public int i() {
        if (this.f67564a == -1) {
            this.f67564a = b(0);
        }
        return this.f67564a;
    }

    public String j() {
        if (this.f67565b == null) {
            this.f67565b = c(1);
        }
        return this.f67565b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(h hVar) {
        String str;
        if (f67563h) {
            a aVar = this.f67568e;
            if (aVar == null) {
                try {
                    this.f67568e = new b();
                } catch (Throwable unused) {
                    f67563h = false;
                }
            } else {
                str = aVar.get(hVar.f67582f);
                if (str == null) {
                    str = a(hVar);
                }
                if (f67563h) {
                    this.f67568e.a(hVar.f67582f, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f67563h) {
        }
        return str;
    }

    public final String toString() {
        return k(h.f67575h);
    }
}

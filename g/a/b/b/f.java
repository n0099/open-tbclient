package g.a.b.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public abstract class f implements g.a.a.b {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f67549h = true;

    /* renamed from: a  reason: collision with root package name */
    public int f67550a;

    /* renamed from: b  reason: collision with root package name */
    public String f67551b;

    /* renamed from: c  reason: collision with root package name */
    public String f67552c;

    /* renamed from: d  reason: collision with root package name */
    public Class f67553d;

    /* renamed from: e  reason: collision with root package name */
    public a f67554e;

    /* renamed from: f  reason: collision with root package name */
    public String f67555f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f67556g = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str);

        String get(int i);
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f67557a;

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
            return (String[]) this.f67557a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f67557a = new SoftReference(strArr);
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
        this.f67550a = -1;
        this.f67550a = i;
        this.f67551b = str;
        this.f67553d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i) {
        return Integer.parseInt(c(i), 16);
    }

    public String c(int i) {
        int indexOf = this.f67555f.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.f67555f.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.f67555f.length();
        }
        return this.f67555f.substring(i2, indexOf);
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
        if (this.f67553d == null) {
            this.f67553d = d(2);
        }
        return this.f67553d;
    }

    public String g() {
        if (this.f67552c == null) {
            this.f67552c = f().getName();
        }
        return this.f67552c;
    }

    public final ClassLoader h() {
        if (this.f67556g == null) {
            this.f67556g = getClass().getClassLoader();
        }
        return this.f67556g;
    }

    public int i() {
        if (this.f67550a == -1) {
            this.f67550a = b(0);
        }
        return this.f67550a;
    }

    public String j() {
        if (this.f67551b == null) {
            this.f67551b = c(1);
        }
        return this.f67551b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(h hVar) {
        String str;
        if (f67549h) {
            a aVar = this.f67554e;
            if (aVar == null) {
                try {
                    this.f67554e = new b();
                } catch (Throwable unused) {
                    f67549h = false;
                }
            } else {
                str = aVar.get(hVar.f67567f);
                if (str == null) {
                    str = a(hVar);
                }
                if (f67549h) {
                    this.f67554e.a(hVar.f67567f, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f67549h) {
        }
        return str;
    }

    public final String toString() {
        return k(h.f67561h);
    }
}

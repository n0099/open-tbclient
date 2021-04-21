package g.a.b.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public abstract class f implements g.a.a.b {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f68707h = true;

    /* renamed from: a  reason: collision with root package name */
    public int f68708a;

    /* renamed from: b  reason: collision with root package name */
    public String f68709b;

    /* renamed from: c  reason: collision with root package name */
    public String f68710c;

    /* renamed from: d  reason: collision with root package name */
    public Class f68711d;

    /* renamed from: e  reason: collision with root package name */
    public a f68712e;

    /* renamed from: f  reason: collision with root package name */
    public String f68713f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f68714g = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str);

        String get(int i);
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f68715a;

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
            return (String[]) this.f68715a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f68715a = new SoftReference(strArr);
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
        this.f68708a = -1;
        this.f68708a = i;
        this.f68709b = str;
        this.f68711d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i) {
        return Integer.parseInt(c(i), 16);
    }

    public String c(int i) {
        int indexOf = this.f68713f.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.f68713f.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.f68713f.length();
        }
        return this.f68713f.substring(i2, indexOf);
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
        if (this.f68711d == null) {
            this.f68711d = d(2);
        }
        return this.f68711d;
    }

    public String g() {
        if (this.f68710c == null) {
            this.f68710c = f().getName();
        }
        return this.f68710c;
    }

    public final ClassLoader h() {
        if (this.f68714g == null) {
            this.f68714g = getClass().getClassLoader();
        }
        return this.f68714g;
    }

    public int i() {
        if (this.f68708a == -1) {
            this.f68708a = b(0);
        }
        return this.f68708a;
    }

    public String j() {
        if (this.f68709b == null) {
            this.f68709b = c(1);
        }
        return this.f68709b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(h hVar) {
        String str;
        if (f68707h) {
            a aVar = this.f68712e;
            if (aVar == null) {
                try {
                    this.f68712e = new b();
                } catch (Throwable unused) {
                    f68707h = false;
                }
            } else {
                str = aVar.get(hVar.f68725f);
                if (str == null) {
                    str = a(hVar);
                }
                if (f68707h) {
                    this.f68712e.a(hVar.f68725f, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f68707h) {
        }
        return str;
    }

    public final String toString() {
        return k(h.f68719h);
    }
}

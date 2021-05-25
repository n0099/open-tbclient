package g.a.b.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public abstract class f implements g.a.a.b {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f68292h = true;

    /* renamed from: a  reason: collision with root package name */
    public int f68293a;

    /* renamed from: b  reason: collision with root package name */
    public String f68294b;

    /* renamed from: c  reason: collision with root package name */
    public String f68295c;

    /* renamed from: d  reason: collision with root package name */
    public Class f68296d;

    /* renamed from: e  reason: collision with root package name */
    public a f68297e;

    /* renamed from: f  reason: collision with root package name */
    public String f68298f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f68299g = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2, String str);

        String get(int i2);
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f68300a;

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
            return (String[]) this.f68300a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f68300a = new SoftReference(strArr);
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
        this.f68293a = -1;
        this.f68293a = i2;
        this.f68294b = str;
        this.f68296d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i2) {
        return Integer.parseInt(c(i2), 16);
    }

    public String c(int i2) {
        int indexOf = this.f68298f.indexOf(45);
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i3 = indexOf + 1;
            indexOf = this.f68298f.indexOf(45, i3);
            i2 = i4;
        }
        if (indexOf == -1) {
            indexOf = this.f68298f.length();
        }
        return this.f68298f.substring(i3, indexOf);
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
        if (this.f68296d == null) {
            this.f68296d = d(2);
        }
        return this.f68296d;
    }

    public String g() {
        if (this.f68295c == null) {
            this.f68295c = f().getName();
        }
        return this.f68295c;
    }

    public final ClassLoader h() {
        if (this.f68299g == null) {
            this.f68299g = getClass().getClassLoader();
        }
        return this.f68299g;
    }

    public int i() {
        if (this.f68293a == -1) {
            this.f68293a = b(0);
        }
        return this.f68293a;
    }

    public String j() {
        if (this.f68294b == null) {
            this.f68294b = c(1);
        }
        return this.f68294b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(h hVar) {
        String str;
        if (f68292h) {
            a aVar = this.f68297e;
            if (aVar == null) {
                try {
                    this.f68297e = new b();
                } catch (Throwable unused) {
                    f68292h = false;
                }
            } else {
                str = aVar.get(hVar.f68311f);
                if (str == null) {
                    str = a(hVar);
                }
                if (f68292h) {
                    this.f68297e.a(hVar.f68311f, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f68292h) {
        }
        return str;
    }

    public final String toString() {
        return k(h.f68304h);
    }
}

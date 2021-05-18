package g.a.b.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public abstract class f implements g.a.a.b {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f68249h = true;

    /* renamed from: a  reason: collision with root package name */
    public int f68250a;

    /* renamed from: b  reason: collision with root package name */
    public String f68251b;

    /* renamed from: c  reason: collision with root package name */
    public String f68252c;

    /* renamed from: d  reason: collision with root package name */
    public Class f68253d;

    /* renamed from: e  reason: collision with root package name */
    public a f68254e;

    /* renamed from: f  reason: collision with root package name */
    public String f68255f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f68256g = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2, String str);

        String get(int i2);
    }

    /* loaded from: classes7.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f68257a;

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
            return (String[]) this.f68257a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f68257a = new SoftReference(strArr);
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
        this.f68250a = -1;
        this.f68250a = i2;
        this.f68251b = str;
        this.f68253d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i2) {
        return Integer.parseInt(c(i2), 16);
    }

    public String c(int i2) {
        int indexOf = this.f68255f.indexOf(45);
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            i3 = indexOf + 1;
            indexOf = this.f68255f.indexOf(45, i3);
            i2 = i4;
        }
        if (indexOf == -1) {
            indexOf = this.f68255f.length();
        }
        return this.f68255f.substring(i3, indexOf);
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
        if (this.f68253d == null) {
            this.f68253d = d(2);
        }
        return this.f68253d;
    }

    public String g() {
        if (this.f68252c == null) {
            this.f68252c = f().getName();
        }
        return this.f68252c;
    }

    public final ClassLoader h() {
        if (this.f68256g == null) {
            this.f68256g = getClass().getClassLoader();
        }
        return this.f68256g;
    }

    public int i() {
        if (this.f68250a == -1) {
            this.f68250a = b(0);
        }
        return this.f68250a;
    }

    public String j() {
        if (this.f68251b == null) {
            this.f68251b = c(1);
        }
        return this.f68251b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k(h hVar) {
        String str;
        if (f68249h) {
            a aVar = this.f68254e;
            if (aVar == null) {
                try {
                    this.f68254e = new b();
                } catch (Throwable unused) {
                    f68249h = false;
                }
            } else {
                str = aVar.get(hVar.f68268f);
                if (str == null) {
                    str = a(hVar);
                }
                if (f68249h) {
                    this.f68254e.a(hVar.f68268f, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f68249h) {
        }
        return str;
    }

    public final String toString() {
        return k(h.f68261h);
    }
}

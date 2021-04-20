package g.a.b.b;

import g.a.a.a;
import g.a.b.b.c;
import java.util.Hashtable;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static Hashtable f68547e;

    /* renamed from: f  reason: collision with root package name */
    public static Object[] f68548f;

    /* renamed from: g  reason: collision with root package name */
    public static /* synthetic */ Class f68549g;

    /* renamed from: a  reason: collision with root package name */
    public Class f68550a;

    /* renamed from: b  reason: collision with root package name */
    public ClassLoader f68551b;

    /* renamed from: c  reason: collision with root package name */
    public String f68552c;

    /* renamed from: d  reason: collision with root package name */
    public int f68553d = 0;

    static {
        Hashtable hashtable = new Hashtable();
        f68547e = hashtable;
        hashtable.put("void", Void.TYPE);
        f68547e.put("boolean", Boolean.TYPE);
        f68547e.put("byte", Byte.TYPE);
        f68547e.put("char", Character.TYPE);
        f68547e.put("short", Short.TYPE);
        f68547e.put("int", Integer.TYPE);
        f68547e.put("long", Long.TYPE);
        f68547e.put("float", Float.TYPE);
        f68547e.put("double", Double.TYPE);
        f68548f = new Object[0];
    }

    public b(String str, Class cls) {
        this.f68552c = str;
        this.f68550a = cls;
        this.f68551b = cls.getClassLoader();
    }

    public static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static Class b(String str, ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Class cls = (Class) f68547e.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            if (classLoader == null) {
                return Class.forName(str);
            }
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            Class cls2 = f68549g;
            if (cls2 == null) {
                Class a2 = a("java.lang.ClassNotFoundException");
                f68549g = a2;
                return a2;
            }
            return cls2;
        }
    }

    public static g.a.a.a c(a.InterfaceC1894a interfaceC1894a, Object obj, Object obj2) {
        return new c(interfaceC1894a, obj, obj2, f68548f);
    }

    public static g.a.a.a d(a.InterfaceC1894a interfaceC1894a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC1894a, obj, obj2, new Object[]{obj3});
    }

    public static g.a.a.a e(a.InterfaceC1894a interfaceC1894a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC1894a, obj, obj2, objArr);
    }

    public g.a.a.c.a f(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b2 = b(str3, this.f68551b);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.f68551b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.f68551b);
        }
        return new e(parseInt, str2, b2, clsArr, strArr, clsArr2, b(str7, this.f68551b));
    }

    public a.InterfaceC1894a g(String str, g.a.a.b bVar, int i) {
        int i2 = this.f68553d;
        this.f68553d = i2 + 1;
        return new c.a(i2, str, bVar, h(i, -1));
    }

    public g.a.a.c.b h(int i, int i2) {
        return new g(this.f68550a, this.f68552c, i);
    }
}

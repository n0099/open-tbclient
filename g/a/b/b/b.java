package g.a.b.b;

import g.a.a.a;
import g.a.b.b.c;
import java.util.Hashtable;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static Hashtable f67550e;

    /* renamed from: f  reason: collision with root package name */
    public static Object[] f67551f;

    /* renamed from: g  reason: collision with root package name */
    public static /* synthetic */ Class f67552g;

    /* renamed from: a  reason: collision with root package name */
    public Class f67553a;

    /* renamed from: b  reason: collision with root package name */
    public ClassLoader f67554b;

    /* renamed from: c  reason: collision with root package name */
    public String f67555c;

    /* renamed from: d  reason: collision with root package name */
    public int f67556d = 0;

    static {
        Hashtable hashtable = new Hashtable();
        f67550e = hashtable;
        hashtable.put("void", Void.TYPE);
        f67550e.put("boolean", Boolean.TYPE);
        f67550e.put("byte", Byte.TYPE);
        f67550e.put("char", Character.TYPE);
        f67550e.put("short", Short.TYPE);
        f67550e.put("int", Integer.TYPE);
        f67550e.put("long", Long.TYPE);
        f67550e.put("float", Float.TYPE);
        f67550e.put("double", Double.TYPE);
        f67551f = new Object[0];
    }

    public b(String str, Class cls) {
        this.f67555c = str;
        this.f67553a = cls;
        this.f67554b = cls.getClassLoader();
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
        Class cls = (Class) f67550e.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            if (classLoader == null) {
                return Class.forName(str);
            }
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            Class cls2 = f67552g;
            if (cls2 == null) {
                Class a2 = a("java.lang.ClassNotFoundException");
                f67552g = a2;
                return a2;
            }
            return cls2;
        }
    }

    public static g.a.a.a c(a.InterfaceC1845a interfaceC1845a, Object obj, Object obj2) {
        return new c(interfaceC1845a, obj, obj2, f67551f);
    }

    public static g.a.a.a d(a.InterfaceC1845a interfaceC1845a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC1845a, obj, obj2, new Object[]{obj3});
    }

    public static g.a.a.a e(a.InterfaceC1845a interfaceC1845a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC1845a, obj, obj2, objArr);
    }

    public g.a.a.c.a f(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b2 = b(str3, this.f67554b);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = b(stringTokenizer.nextToken(), this.f67554b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i3 = 0; i3 < countTokens2; i3++) {
            strArr[i3] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i4 = 0; i4 < countTokens3; i4++) {
            clsArr2[i4] = b(stringTokenizer3.nextToken(), this.f67554b);
        }
        return new e(parseInt, str2, b2, clsArr, strArr, clsArr2, b(str7, this.f67554b));
    }

    public a.InterfaceC1845a g(String str, g.a.a.b bVar, int i2) {
        int i3 = this.f67556d;
        this.f67556d = i3 + 1;
        return new c.a(i3, str, bVar, h(i2, -1));
    }

    public g.a.a.c.b h(int i2, int i3) {
        return new g(this.f67553a, this.f67555c, i2);
    }
}

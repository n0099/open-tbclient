package g.a.b.b;

import g.a.a.a;
import g.a.b.b.c;
import java.util.Hashtable;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static Hashtable f68694e;

    /* renamed from: f  reason: collision with root package name */
    public static Object[] f68695f;

    /* renamed from: g  reason: collision with root package name */
    public static /* synthetic */ Class f68696g;

    /* renamed from: a  reason: collision with root package name */
    public Class f68697a;

    /* renamed from: b  reason: collision with root package name */
    public ClassLoader f68698b;

    /* renamed from: c  reason: collision with root package name */
    public String f68699c;

    /* renamed from: d  reason: collision with root package name */
    public int f68700d = 0;

    static {
        Hashtable hashtable = new Hashtable();
        f68694e = hashtable;
        hashtable.put("void", Void.TYPE);
        f68694e.put("boolean", Boolean.TYPE);
        f68694e.put("byte", Byte.TYPE);
        f68694e.put("char", Character.TYPE);
        f68694e.put("short", Short.TYPE);
        f68694e.put("int", Integer.TYPE);
        f68694e.put("long", Long.TYPE);
        f68694e.put("float", Float.TYPE);
        f68694e.put("double", Double.TYPE);
        f68695f = new Object[0];
    }

    public b(String str, Class cls) {
        this.f68699c = str;
        this.f68697a = cls;
        this.f68698b = cls.getClassLoader();
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
        Class cls = (Class) f68694e.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            if (classLoader == null) {
                return Class.forName(str);
            }
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            Class cls2 = f68696g;
            if (cls2 == null) {
                Class a2 = a("java.lang.ClassNotFoundException");
                f68696g = a2;
                return a2;
            }
            return cls2;
        }
    }

    public static g.a.a.a c(a.InterfaceC1898a interfaceC1898a, Object obj, Object obj2) {
        return new c(interfaceC1898a, obj, obj2, f68695f);
    }

    public static g.a.a.a d(a.InterfaceC1898a interfaceC1898a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC1898a, obj, obj2, new Object[]{obj3});
    }

    public static g.a.a.a e(a.InterfaceC1898a interfaceC1898a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC1898a, obj, obj2, objArr);
    }

    public g.a.a.c.a f(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b2 = b(str3, this.f68698b);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.f68698b);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.f68698b);
        }
        return new e(parseInt, str2, b2, clsArr, strArr, clsArr2, b(str7, this.f68698b));
    }

    public a.InterfaceC1898a g(String str, g.a.a.b bVar, int i) {
        int i2 = this.f68700d;
        this.f68700d = i2 + 1;
        return new c.a(i2, str, bVar, h(i, -1));
    }

    public g.a.a.c.b h(int i, int i2) {
        return new g(this.f68697a, this.f68699c, i);
    }
}

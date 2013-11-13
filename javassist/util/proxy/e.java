package javassist.util.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javassist.CannotCompileException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.ad;
import javassist.bytecode.an;
import javassist.bytecode.bl;
import javassist.bytecode.y;
import javassist.bytecode.z;
import javassist.compiler.ast.MethodDecl;
/* loaded from: classes.dex */
public class e {
    private String m;
    private String n;
    private String o;
    private static final Class s = Object.class;
    private static final String t = 'L' + c.class.getName().replace('.', '/') + ';';
    private static final String u = "(" + t + ")V";
    private static final String v = "()" + t;
    public static volatile boolean b = true;
    public static volatile boolean c = true;
    private static WeakHashMap w = new WeakHashMap();
    private static char[] x = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static i d = new f();
    public static l e = new g();
    private static Comparator y = new h();
    private Class f = null;
    private Class[] g = null;
    private b h = null;
    private c i = null;
    private byte[] l = null;
    private List j = null;
    private boolean k = false;
    private Class p = null;

    /* renamed from: a  reason: collision with root package name */
    public String f2871a = null;
    private boolean q = b;
    private boolean r = c;

    public void a(Class cls) {
        this.f = cls;
        this.l = null;
    }

    public void a(Class[] clsArr) {
        this.g = clsArr;
        this.l = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class a(byte[] bArr) {
        b(bArr);
        return d();
    }

    private Class d() {
        if (this.p == null) {
            ClassLoader a2 = a();
            synchronized (w) {
                if (this.q) {
                    a(a2);
                } else {
                    b(a2);
                }
            }
        }
        Class cls = this.p;
        this.p = null;
        return cls;
    }

    public String a(Class cls, Class[] clsArr, byte[] bArr, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (cls != null) {
            stringBuffer.append(cls.getName());
        }
        stringBuffer.append(":");
        for (Class cls2 : clsArr) {
            stringBuffer.append(cls2.getName());
            stringBuffer.append(":");
        }
        for (byte b2 : bArr) {
            stringBuffer.append(x[b2 & 15]);
            stringBuffer.append(x[(b2 >> 4) & 15]);
        }
        if (z) {
            stringBuffer.append(":w");
        }
        return stringBuffer.toString();
    }

    private void a(ClassLoader classLoader) {
        HashMap hashMap;
        String a2 = a(this.f, this.g, this.l, this.r);
        HashMap hashMap2 = (HashMap) w.get(classLoader);
        if (hashMap2 == null) {
            HashMap hashMap3 = new HashMap();
            w.put(classLoader, hashMap3);
            hashMap = hashMap3;
        } else {
            hashMap = hashMap2;
        }
        k kVar = (k) hashMap.get(a2);
        if (kVar != null) {
            this.p = (Class) kVar.b.get();
            if (this.p != null) {
                return;
            }
        }
        b(classLoader);
        hashMap.put(a2, new k(this.l, this.p, this.r));
    }

    private void b(ClassLoader classLoader) {
        g();
        try {
            javassist.bytecode.i e2 = e();
            if (this.f2871a != null) {
                a.a(e2, this.f2871a);
            }
            this.p = a.a(e2, classLoader, c());
            a("_filter_signature", this.l);
            if (!this.q) {
                a("default_interceptor", this.i);
            }
        } catch (CannotCompileException e3) {
            throw new RuntimeException(e3.getMessage(), e3);
        }
    }

    private void a(String str, Object obj) {
        if (this.p != null && obj != null) {
            try {
                Field field = this.p.getField(str);
                m.a(field, true);
                field.set(null, obj);
                m.a(field, false);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    protected ClassLoader a() {
        return d.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoader b() {
        ClassLoader classLoader = null;
        if (this.f != null && !this.f.getName().equals("java.lang.Object")) {
            classLoader = this.f.getClassLoader();
        } else if (this.g != null && this.g.length > 0) {
            classLoader = this.g[0].getClassLoader();
        }
        if (classLoader == null) {
            ClassLoader classLoader2 = getClass().getClassLoader();
            if (classLoader2 == null) {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader == null) {
                    return ClassLoader.getSystemClassLoader();
                }
                return contextClassLoader;
            }
            return classLoader2;
        }
        return classLoader;
    }

    protected ProtectionDomain c() {
        Class<?> cls;
        if (this.f != null && !this.f.getName().equals("java.lang.Object")) {
            cls = this.f;
        } else if (this.g != null && this.g.length > 0) {
            cls = this.g[0];
        } else {
            cls = getClass();
        }
        return cls.getProtectionDomain();
    }

    private static String a(String str) {
        String a2;
        synchronized (e) {
            a2 = e.a(str);
        }
        return a2;
    }

    private javassist.bytecode.i e() {
        javassist.bytecode.i iVar = new javassist.bytecode.i(false, this.m, this.o);
        iVar.a(1);
        a(iVar, this.g, this.k ? d.class : ProxyObject.class);
        y c2 = iVar.c();
        if (!this.q) {
            ad adVar = new ad(c2, "default_interceptor", t);
            adVar.a(9);
            iVar.a(adVar);
        }
        ad adVar2 = new ad(c2, "handler", t);
        adVar2.a(2);
        iVar.a(adVar2);
        ad adVar3 = new ad(c2, "_filter_signature", "[B");
        adVar3.a(9);
        iVar.a(adVar3);
        ad adVar4 = new ad(c2, "serialVersionUID", "J");
        adVar4.a(25);
        iVar.a(adVar4);
        a(this.m, iVar, c2, this.m);
        ArrayList arrayList = new ArrayList();
        a(iVar, c2, this.m, a(iVar, c2, this.m, arrayList), arrayList);
        a(this.m, iVar, c2);
        if (!this.k) {
            b(this.m, iVar, c2);
        }
        if (this.r) {
            try {
                iVar.a(a(c2));
            } catch (DuplicateMemberException e2) {
            }
        }
        this.p = null;
        return iVar;
    }

    private void f() {
        if (this.g == null) {
            this.g = new Class[0];
        }
        if (this.f == null) {
            this.f = s;
            this.o = this.f.getName();
            this.n = this.g.length == 0 ? this.o : this.g[0].getName();
        } else {
            this.o = this.f.getName();
            this.n = this.o;
        }
        if (Modifier.isFinal(this.f.getModifiers())) {
            throw new RuntimeException(this.o + " is final");
        }
        if (this.n.startsWith("java.")) {
            this.n = "org.javassist.tmp." + this.n;
        }
    }

    private void g() {
        this.m = a(this.n);
    }

    private void h() {
        f();
        this.k = false;
        this.j = new ArrayList(a(this.f, this.g).entrySet());
        Collections.sort(this.j, y);
    }

    private void b(byte[] bArr) {
        h();
        if (bArr.length != ((this.j.size() + 7) >> 3)) {
            throw new RuntimeException("invalid filter signature length for deserialized proxy class");
        }
        this.l = bArr;
    }

    private boolean a(byte[] bArr, int i) {
        int i2 = i >> 3;
        if (i2 > bArr.length) {
            return false;
        }
        return (bArr[i2] & (1 << (i & 7))) != 0;
    }

    private static void a(javassist.bytecode.i iVar, Class[] clsArr, Class cls) {
        String[] strArr;
        String name = cls.getName();
        if (clsArr == null || clsArr.length == 0) {
            strArr = new String[]{name};
        } else {
            String[] strArr2 = new String[clsArr.length + 1];
            for (int i = 0; i < clsArr.length; i++) {
                strArr2[i] = clsArr[i].getName();
            }
            strArr2[clsArr.length] = name;
            strArr = strArr2;
        }
        iVar.a(strArr);
    }

    private static void a(javassist.bytecode.i iVar, y yVar, String str, int i, ArrayList arrayList) {
        ad adVar = new ad(yVar, "_methods_", "[Ljava/lang/reflect/Method;");
        adVar.a(10);
        iVar.a(adVar);
        an anVar = new an(yVar, "<clinit>", "()V");
        anVar.a(8);
        a(anVar, yVar, new Class[]{ClassNotFoundException.class});
        Bytecode bytecode = new Bytecode(yVar, 0, 2);
        bytecode.m(i * 2);
        bytecode.e("java.lang.reflect.Method");
        bytecode.l(0);
        bytecode.c(str);
        bytecode.d("java.lang.Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        bytecode.l(1);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            a(bytecode, jVar.f2873a, jVar.b, jVar.d, jVar.c, 1, 0);
        }
        bytecode.k(0);
        bytecode.g(str, "_methods_", "[Ljava/lang/reflect/Method;");
        bytecode.a(-1L);
        bytecode.g(str, "serialVersionUID", "J");
        bytecode.g(177);
        anVar.a(bytecode.e());
        iVar.a(anVar);
    }

    private static void a(Bytecode bytecode, String str, String str2, int i, String str3, int i2, int i3) {
        String name = RuntimeSupport.class.getName();
        bytecode.k(i2);
        bytecode.c(str);
        if (str2 == null) {
            bytecode.g(1);
        } else {
            bytecode.c(str2);
        }
        bytecode.m(i);
        bytecode.c(str3);
        bytecode.k(i3);
        bytecode.d(name, "find2Methods", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;[Ljava/lang/reflect/Method;)V");
    }

    private static void a(String str, javassist.bytecode.i iVar, y yVar) {
        an anVar = new an(yVar, "setHandler", u);
        anVar.a(1);
        Bytecode bytecode = new Bytecode(yVar, 2, 2);
        bytecode.k(0);
        bytecode.k(1);
        bytecode.f(str, "handler", t);
        bytecode.g(177);
        anVar.a(bytecode.e());
        iVar.a(anVar);
    }

    private static void b(String str, javassist.bytecode.i iVar, y yVar) {
        an anVar = new an(yVar, "getHandler", v);
        anVar.a(1);
        Bytecode bytecode = new Bytecode(yVar, 1, 1);
        bytecode.k(0);
        bytecode.a(str, "handler", t);
        bytecode.g(176);
        anVar.a(bytecode.e());
        iVar.a(anVar);
    }

    private int a(javassist.bytecode.i iVar, y yVar, String str, ArrayList arrayList) {
        String a2 = a("_d", this.j);
        int i = 0;
        for (Map.Entry entry : this.j) {
            String str2 = (String) entry.getKey();
            Method method = (Method) entry.getValue();
            if ((javassist.bytecode.i.n < 49 || !a(method)) && a(this.l, i)) {
                a(str, method, a2, i, a(str2, method), iVar, yVar, arrayList);
            }
            i++;
        }
        return i;
    }

    private static boolean a(Method method) {
        return method.isBridge();
    }

    private void a(String str, Method method, String str2, int i, String str3, javassist.bytecode.i iVar, y yVar, ArrayList arrayList) {
        Class<?> declaringClass = method.getDeclaringClass();
        String str4 = str2 + i + method.getName();
        if (Modifier.isAbstract(method.getModifiers())) {
            str4 = null;
        } else {
            an a2 = a(method, str3, yVar, declaringClass, str4);
            a2.a(a2.f() & (-65));
            iVar.a(a2);
        }
        iVar.a(a(str, method, str3, yVar, declaringClass, str4, i, arrayList));
    }

    private void a(String str, javassist.bytecode.i iVar, y yVar, String str2) {
        Constructor[] b2 = m.b(this.f);
        boolean z = !this.q;
        for (Constructor constructor : b2) {
            int modifiers = constructor.getModifiers();
            if (!Modifier.isFinal(modifiers) && !Modifier.isPrivate(modifiers) && a(modifiers, this.n, constructor)) {
                iVar.a(a(str, constructor, yVar, this.f, z));
            }
        }
    }

    private static String a(String str, List list) {
        if (!a(str, list.iterator())) {
            int i = 100;
            while (true) {
                int i2 = i;
                if (i2 < 999) {
                    String str2 = str + i2;
                    if (a(str2, list.iterator())) {
                        return str2;
                    }
                    i = i2 + 1;
                } else {
                    throw new RuntimeException("cannot make a unique method name");
                }
            }
        } else {
            return str;
        }
    }

    private static boolean a(String str, Iterator it) {
        while (it.hasNext()) {
            if (((String) ((Map.Entry) it.next()).getKey()).startsWith(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(int i, String str, Member member) {
        if ((i & 2) != 0) {
            return false;
        }
        if ((i & 5) == 0) {
            String b2 = b(str);
            String b3 = b(member.getDeclaringClass().getName());
            if (b2 == null) {
                return b3 == null;
            }
            return b2.equals(b3);
        }
        return true;
    }

    private static String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    private HashMap a(Class cls, Class[] clsArr) {
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        for (Class cls2 : clsArr) {
            a(hashMap, cls2, hashSet);
        }
        a(hashMap, cls, hashSet);
        return hashMap;
    }

    private void a(HashMap hashMap, Class cls, Set set) {
        if (set.add(cls)) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                a(hashMap, cls2, set);
            }
            Class superclass = cls.getSuperclass();
            if (superclass != null) {
                a(hashMap, superclass, set);
            }
            Method[] a2 = m.a(cls);
            for (int i = 0; i < a2.length; i++) {
                if (!Modifier.isPrivate(a2[i].getModifiers())) {
                    Method method = a2[i];
                    String str = method.getName() + ':' + RuntimeSupport.a(method);
                    if (str.startsWith("getHandler:()")) {
                        this.k = true;
                    }
                    Method method2 = (Method) hashMap.put(str, a2[i]);
                    if (method2 != null && Modifier.isPublic(method2.getModifiers()) && !Modifier.isPublic(a2[i].getModifiers())) {
                        hashMap.put(str, method2);
                    }
                }
            }
        }
    }

    private static String a(String str, Method method) {
        return str.substring(str.indexOf(58) + 1);
    }

    private static an a(String str, Constructor constructor, y yVar, Class cls, boolean z) {
        String a2 = RuntimeSupport.a(constructor.getParameterTypes(), Void.TYPE);
        an anVar = new an(yVar, MethodDecl.initName, a2);
        anVar.a(1);
        a(anVar, yVar, constructor.getExceptionTypes());
        Bytecode bytecode = new Bytecode(yVar, 0, 0);
        if (z) {
            bytecode.k(0);
            bytecode.b(str, "default_interceptor", t);
            bytecode.f(str, "handler", t);
            bytecode.b(str, "default_interceptor", t);
            bytecode.g(199);
            bytecode.j(10);
        }
        bytecode.k(0);
        bytecode.b("javassist.util.proxy.RuntimeSupport", "default_interceptor", t);
        bytecode.f(str, "handler", t);
        int h = bytecode.h();
        bytecode.k(0);
        int a3 = a(bytecode, constructor.getParameterTypes(), 1);
        bytecode.c(cls.getName(), MethodDecl.initName, a2);
        bytecode.g(177);
        bytecode.d(a3 + 1);
        CodeAttribute e2 = bytecode.e();
        anVar.a(e2);
        bl blVar = new bl(32);
        blVar.a(h);
        e2.a(blVar.a(yVar));
        return anVar;
    }

    private static an a(Method method, String str, y yVar, Class cls, String str2) {
        an anVar = new an(yVar, str2, str);
        anVar.a((method.getModifiers() & (-1319)) | 17);
        a(anVar, yVar, method);
        Bytecode bytecode = new Bytecode(yVar, 0, 0);
        bytecode.k(0);
        int a2 = a(bytecode, method.getParameterTypes(), 1);
        bytecode.c(cls.getName(), method.getName(), str);
        a(bytecode, method.getReturnType());
        bytecode.d(a2 + 1);
        anVar.a(bytecode.e());
        return anVar;
    }

    private static an a(String str, Method method, String str2, y yVar, Class cls, String str3, int i, ArrayList arrayList) {
        an anVar = new an(yVar, method.getName(), str2);
        anVar.a((method.getModifiers() & (-1313)) | 16);
        a(anVar, yVar, method);
        int h = z.h(str2);
        Bytecode bytecode = new Bytecode(yVar, 0, h + 2);
        int i2 = i * 2;
        int i3 = h + 1;
        bytecode.b(str, "_methods_", "[Ljava/lang/reflect/Method;");
        bytecode.l(i3);
        arrayList.add(new j(method.getName(), str3, str2, i2));
        bytecode.k(0);
        bytecode.a(str, "handler", t);
        bytecode.k(0);
        bytecode.k(i3);
        bytecode.m(i2);
        bytecode.g(50);
        bytecode.k(i3);
        bytecode.m((i * 2) + 1);
        bytecode.g(50);
        a(bytecode, method.getParameterTypes());
        bytecode.a(c.class.getName(), "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", 5);
        Class<?> returnType = method.getReturnType();
        b(bytecode, returnType);
        a(bytecode, returnType);
        anVar.a(bytecode.e());
        return anVar;
    }

    private static void a(an anVar, y yVar, Method method) {
        a(anVar, yVar, method.getExceptionTypes());
    }

    private static void a(an anVar, y yVar, Class[] clsArr) {
        if (clsArr.length != 0) {
            String[] strArr = new String[clsArr.length];
            for (int i = 0; i < clsArr.length; i++) {
                strArr[i] = clsArr[i].getName();
            }
            ExceptionsAttribute exceptionsAttribute = new ExceptionsAttribute(yVar);
            exceptionsAttribute.a(strArr);
            anVar.a(exceptionsAttribute);
        }
    }

    private static int a(Bytecode bytecode, Class[] clsArr, int i) {
        int i2 = 0;
        for (Class cls : clsArr) {
            i2 += a(bytecode, i2 + i, cls);
        }
        return i2;
    }

    private static int a(Bytecode bytecode, int i, Class cls) {
        if (cls.isPrimitive()) {
            if (cls == Long.TYPE) {
                bytecode.p(i);
                return 2;
            } else if (cls == Float.TYPE) {
                bytecode.t(i);
            } else if (cls == Double.TYPE) {
                bytecode.r(i);
                return 2;
            } else {
                bytecode.n(i);
            }
        } else {
            bytecode.k(i);
        }
        return 1;
    }

    private static int a(Bytecode bytecode, Class cls) {
        if (cls.isPrimitive()) {
            if (cls == Long.TYPE) {
                bytecode.g(173);
                return 2;
            } else if (cls == Float.TYPE) {
                bytecode.g(174);
            } else if (cls == Double.TYPE) {
                bytecode.g(175);
                return 2;
            } else if (cls == Void.TYPE) {
                bytecode.g(177);
                return 0;
            } else {
                bytecode.g(172);
            }
        } else {
            bytecode.g(176);
        }
        return 1;
    }

    private static void a(Bytecode bytecode, Class[] clsArr) {
        int length = clsArr.length;
        bytecode.m(length);
        bytecode.e("java/lang/Object");
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            bytecode.g(89);
            bytecode.m(i2);
            Class cls = clsArr[i2];
            if (cls.isPrimitive()) {
                i = a(bytecode, cls, i);
            } else {
                bytecode.k(i);
                i++;
            }
            bytecode.g(83);
        }
    }

    private static int a(Bytecode bytecode, Class cls, int i) {
        int a2 = a.a(cls);
        String str = a.b[a2];
        bytecode.d(str);
        bytecode.g(89);
        a(bytecode, i, cls);
        bytecode.c(str, MethodDecl.initName, a.c[a2]);
        return a.f[a2] + i;
    }

    private static void b(Bytecode bytecode, Class cls) {
        if (cls.isPrimitive()) {
            if (cls == Void.TYPE) {
                bytecode.g(87);
                return;
            }
            int a2 = a.a(cls);
            String str = a.b[a2];
            bytecode.a(str);
            bytecode.e(str, a.d[a2], a.e[a2]);
            return;
        }
        bytecode.a(cls.getName());
    }

    private static an a(y yVar) {
        an anVar = new an(yVar, "writeReplace", "()Ljava/lang/Object;");
        ExceptionsAttribute exceptionsAttribute = new ExceptionsAttribute(yVar);
        exceptionsAttribute.a(new String[]{"java.io.ObjectStreamException"});
        anVar.a(exceptionsAttribute);
        Bytecode bytecode = new Bytecode(yVar, 0, 1);
        bytecode.k(0);
        bytecode.d("javassist.util.proxy.RuntimeSupport", "makeSerializedProxy", "(Ljava/lang/Object;)Ljavassist/util/proxy/SerializedProxy;");
        bytecode.g(176);
        anVar.a(bytecode.e());
        return anVar;
    }
}

package javassist;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public class c {
    public static boolean b;
    public static boolean c;
    private static Method g;
    private static Method h;
    private static Method i;
    private static c m;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2997a;
    protected e d;
    protected c e;
    protected Hashtable f;
    private int j;
    private Hashtable k;
    private ArrayList l;

    static {
        try {
            AccessController.doPrivileged(new d());
            b = false;
            c = true;
            m = null;
        } catch (PrivilegedActionException e) {
            throw new RuntimeException("cannot initialize ClassPool", e.getException());
        }
    }

    public c() {
        this(null);
    }

    public c(c cVar) {
        this.f2997a = false;
        this.k = null;
        this.f = new Hashtable(191);
        this.d = new e();
        this.e = cVar;
        if (cVar == null) {
            h[] hVarArr = h.m;
            for (int i2 = 0; i2 < hVarArr.length; i2++) {
                this.f.put(hVarArr[i2].n(), hVarArr[i2]);
            }
        }
        this.k = null;
        this.j = 0;
        c();
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (m == null) {
                m = new c(null);
                m.e();
            }
            cVar = m;
        }
        return cVar;
    }

    protected h a(String str) {
        return (h) this.f.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, h hVar, boolean z) {
        this.f.put(str, hVar);
    }

    public String toString() {
        return this.d.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i2 = this.j;
        this.j = i2 + 1;
        if (i2 > 100) {
            this.j = 0;
            Enumeration elements = this.f.elements();
            while (elements.hasMoreElements()) {
                ((h) elements.nextElement()).x();
            }
        }
    }

    public void c() {
        this.l = new ArrayList();
        this.l.add("java.lang");
    }

    public Iterator d() {
        return this.l.iterator();
    }

    public Object[] b(String str) {
        if (this.k == null) {
            this.k = new Hashtable();
        }
        return (Object[]) this.k.get(str);
    }

    public h c(String str) {
        h a2;
        if (str == null) {
            a2 = null;
        } else {
            a2 = a(str, true);
        }
        if (a2 == null) {
            throw new NotFoundException(str);
        }
        a2.u();
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
        if (r0 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected synchronized h a(String str, boolean z) {
        h a2;
        if (z) {
            a2 = a(str);
        }
        if (this.f2997a || this.e == null || (a2 = this.e.a(str, z)) == null) {
            a2 = b(str, z);
            if (a2 != null) {
                if (z) {
                    a(a2.n(), a2, false);
                }
            } else if (this.f2997a && this.e != null) {
                a2 = this.e.a(str, z);
            }
        }
        return a2;
    }

    protected h b(String str, boolean z) {
        if (str.charAt(0) == '[') {
            str = z.c(str);
        }
        if (str.endsWith("[]")) {
            String substring = str.substring(0, str.indexOf(91));
            if ((!z || a(substring) == null) && d(substring) == null) {
                return null;
            }
            return new g(str, this);
        } else if (d(str) != null) {
            return new j(str, this);
        } else {
            return null;
        }
    }

    public URL d(String str) {
        return this.d.b(str);
    }

    void e(String str) {
        h a2 = a(str);
        if (a2 == null) {
            if (!this.f2997a && this.e != null) {
                try {
                    a2 = this.e.a(str, true);
                } catch (NotFoundException e) {
                }
                if (a2 != null) {
                    throw new RuntimeException(str + " is in a parent ClassPool.  Use the parent.");
                }
            }
        } else if (a2.k()) {
            throw new RuntimeException(str + ": frozen class (cannot edit)");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputStream f(String str) {
        return this.d.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, OutputStream outputStream) {
        this.d.a(str, outputStream);
    }

    public h[] a(String[] strArr) {
        if (strArr == null) {
            return new h[0];
        }
        int length = strArr.length;
        h[] hVarArr = new h[length];
        for (int i2 = 0; i2 < length; i2++) {
            hVarArr[i2] = c(strArr[i2]);
        }
        return hVarArr;
    }

    public h g(String str) {
        return a(str, (h) null);
    }

    public synchronized h a(String str, h hVar) {
        o oVar;
        e(str);
        oVar = new o(str, this, false, hVar);
        a(str, (h) oVar, true);
        return oVar;
    }

    public a e() {
        return this.d.a();
    }

    public a a(a aVar) {
        return this.d.a(aVar);
    }

    public void b(a aVar) {
        this.d.c(aVar);
    }

    public ClassLoader f() {
        return g();
    }

    static ClassLoader g() {
        return Thread.currentThread().getContextClassLoader();
    }

    public Class a(h hVar, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        Method method;
        Object[] objArr;
        try {
            byte[] w = hVar.w();
            if (protectionDomain == null) {
                method = g;
                objArr = new Object[]{hVar.n(), w, new Integer(0), new Integer(w.length)};
            } else {
                method = h;
                objArr = new Object[]{hVar.n(), w, new Integer(0), new Integer(w.length), protectionDomain};
            }
            return (Class) a(method, classLoader, objArr);
        } catch (RuntimeException e) {
            throw e;
        } catch (InvocationTargetException e2) {
            throw new CannotCompileException(e2.getTargetException());
        } catch (Exception e3) {
            throw new CannotCompileException(e3);
        }
    }

    private static synchronized Object a(Method method, ClassLoader classLoader, Object[] objArr) {
        Object invoke;
        synchronized (c.class) {
            method.setAccessible(true);
            invoke = method.invoke(classLoader, objArr);
            method.setAccessible(false);
        }
        return invoke;
    }
}

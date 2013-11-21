package javassist;

import java.io.InputStream;
import java.security.ProtectionDomain;
import java.util.Hashtable;
import java.util.Vector;
/* loaded from: classes.dex */
public class u extends ClassLoader {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2852a;
    private Hashtable b;
    private Vector c;
    private c d;
    private w e;
    private ProtectionDomain f;

    public u() {
        this(null);
    }

    public u(c cVar) {
        this.f2852a = true;
        a(cVar);
    }

    private void a(c cVar) {
        this.b = new Hashtable();
        this.c = new Vector();
        this.d = cVar;
        this.e = null;
        this.f = null;
        a("javassist.Loader");
    }

    public void a(String str) {
        if (str.endsWith(".")) {
            this.c.addElement(str);
        } else {
            this.b.put(str, this);
        }
    }

    public void a(c cVar, w wVar) {
        this.d = cVar;
        this.e = wVar;
        wVar.a(cVar);
    }

    @Override // java.lang.ClassLoader
    protected Class loadClass(String str, boolean z) {
        Class<?> findLoadedClass;
        String intern = str.intern();
        synchronized (intern) {
            findLoadedClass = findLoadedClass(intern);
            if (findLoadedClass == null) {
                findLoadedClass = b(intern);
            }
            if (findLoadedClass == null) {
                findLoadedClass = findClass(intern);
            }
            if (findLoadedClass == null) {
                findLoadedClass = c(intern);
            }
            if (z) {
                resolveClass(findLoadedClass);
            }
        }
        return findLoadedClass;
    }

    @Override // java.lang.ClassLoader
    protected Class findClass(String str) {
        byte[] a2;
        try {
            if (this.d != null) {
                if (this.e != null) {
                    this.e.a(this.d, str);
                }
                try {
                    a2 = this.d.c(str).w();
                } catch (NotFoundException e) {
                    return null;
                }
            } else {
                InputStream resourceAsStream = getClass().getResourceAsStream("/" + str.replace('.', '/') + ".class");
                if (resourceAsStream == null) {
                    return null;
                }
                a2 = e.a(resourceAsStream);
            }
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                String substring = str.substring(0, lastIndexOf);
                if (getPackage(substring) == null) {
                    try {
                        definePackage(substring, null, null, null, null, null, null, null);
                    } catch (IllegalArgumentException e2) {
                    }
                }
            }
            if (this.f == null) {
                return defineClass(str, a2, 0, a2.length);
            }
            return defineClass(str, a2, 0, a2.length, this.f);
        } catch (Exception e3) {
            throw new ClassNotFoundException("caught an exception while obtaining a class file for " + str, e3);
        }
    }

    protected Class b(String str) {
        if (!this.f2852a) {
            return null;
        }
        if (!str.startsWith("java.") && !str.startsWith("javax.") && !str.startsWith("sun.") && !str.startsWith("com.sun.") && !str.startsWith("org.w3c.") && !str.startsWith("org.xml.") && !d(str)) {
            return null;
        }
        return c(str);
    }

    private boolean d(String str) {
        if (this.b.get(str) != null) {
            return true;
        }
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            if (str.startsWith((String) this.c.elementAt(i))) {
                return true;
            }
        }
        return false;
    }

    protected Class c(String str) {
        ClassLoader parent = getParent();
        return parent != null ? parent.loadClass(str) : findSystemClass(str);
    }
}

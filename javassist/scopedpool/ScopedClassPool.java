package javassist.scopedpool;

import java.lang.ref.WeakReference;
import java.security.ProtectionDomain;
import java.util.Map;
import javassist.LoaderClassPath;
import javassist.h;
/* loaded from: classes.dex */
public class ScopedClassPool extends javassist.c {
    protected b g;
    protected WeakReference h;
    protected LoaderClassPath i;
    protected c j;
    boolean k;

    static {
        javassist.c.b = false;
        javassist.c.c = false;
    }

    @Override // javassist.c
    public ClassLoader f() {
        ClassLoader h = h();
        if (h == null && !this.k) {
            throw new IllegalStateException("ClassLoader has been garbage collected");
        }
        return h;
    }

    protected ClassLoader h() {
        return (ClassLoader) this.h.get();
    }

    public void i() {
        b(this.i);
        this.i.a();
        this.f.clear();
        this.j.clear();
    }

    public boolean j() {
        return false;
    }

    @Override // javassist.c
    protected h a(String str) {
        boolean z;
        int lastIndexOf;
        String str2;
        h h = h(str);
        if (h == null) {
            ClassLoader h2 = h();
            if (h2 != null) {
                if (str.lastIndexOf(36) < 0) {
                    str2 = str.replaceAll("[\\.]", "/") + ".class";
                } else {
                    str2 = str.substring(0, lastIndexOf).replaceAll("[\\.]", "/") + str.substring(lastIndexOf) + ".class";
                }
                z = h2.getResource(str2) != null;
            } else {
                z = false;
            }
            if (!z) {
                Map b = this.g.b();
                synchronized (b) {
                    h hVar = h;
                    for (ScopedClassPool scopedClassPool : b.values()) {
                        if (scopedClassPool.j()) {
                            this.g.a(scopedClassPool.f());
                        } else {
                            h h3 = scopedClassPool.h(str);
                            if (h3 != null) {
                                return h3;
                            }
                            hVar = h3;
                        }
                    }
                    return hVar;
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.c
    public void a(String str, h hVar, boolean z) {
        if (z) {
            super.a(str, hVar, z);
            return;
        }
        if (this.g.a()) {
            hVar.t();
        }
        this.j.put(str, hVar);
    }

    public void a(h hVar) {
        super.a(hVar.n(), hVar, false);
    }

    protected h h(String str) {
        h hVar = (h) this.f.get(str);
        if (hVar == null) {
            synchronized (this.j) {
                hVar = (h) this.j.get(str);
            }
        }
        return hVar;
    }

    @Override // javassist.c
    public Class a(h hVar, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        a(hVar);
        return super.a(hVar, h(), protectionDomain);
    }
}

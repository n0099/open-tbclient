package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class f {
    private static final f ktU = new f();
    static final b ktZ = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> ktV = new AtomicReference<>();
    private final AtomicReference<d> ktW = new AtomicReference<>();
    private final AtomicReference<h> ktX = new AtomicReference<>();
    private final AtomicReference<a> ktY = new AtomicReference<>();
    private final AtomicReference<g> knb = new AtomicReference<>();

    @Deprecated
    public static f cMA() {
        return ktU;
    }

    f() {
    }

    public b cMB() {
        if (this.ktV.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.ktV.compareAndSet(null, ktZ);
            } else {
                this.ktV.compareAndSet(null, (b) a);
            }
        }
        return this.ktV.get();
    }

    public d cMC() {
        if (this.ktW.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.ktW.compareAndSet(null, e.cMz());
            } else {
                this.ktW.compareAndSet(null, (d) a);
            }
        }
        return this.ktW.get();
    }

    public h cMD() {
        if (this.ktX.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.ktX.compareAndSet(null, i.cMN());
            } else {
                this.ktX.compareAndSet(null, (h) a);
            }
        }
        return this.ktX.get();
    }

    public a cME() {
        if (this.ktY.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.ktY.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.ktY.compareAndSet(null, (a) a);
            }
        }
        return this.ktY.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0154 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Object a(Class<?> cls, Properties properties) {
        String str;
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            for (Map.Entry entry : properties2.entrySet()) {
                String obj = entry.getKey().toString();
                if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String str2 = "rxjava.plugin." + obj.substring(0, obj.length() - ".class".length()).substring("rxjava.plugin.".length()) + ".impl";
                    String property2 = properties2.getProperty(str2);
                    if (property2 == null) {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str2);
                    }
                    str = property2;
                    if (str == null) {
                        try {
                            return Class.forName(str).asSubclass(cls).newInstance();
                        } catch (ClassCastException e) {
                            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + str, e);
                        } catch (ClassNotFoundException e2) {
                            throw new IllegalStateException(simpleName + " implementation class not found: " + str, e2);
                        } catch (IllegalAccessException e3) {
                            throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + str, e3);
                        } catch (InstantiationException e4) {
                            throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + str, e4);
                        }
                    }
                    return null;
                }
            }
        }
        str = property;
        if (str == null) {
        }
    }

    public g cMF() {
        if (this.knb.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.knb.compareAndSet(null, g.cMM());
            } else {
                this.knb.compareAndSet(null, (g) a);
            }
        }
        return this.knb.get();
    }
}

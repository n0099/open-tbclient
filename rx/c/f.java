package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class f {
    private static final f nSA = new f();
    static final b nSF = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> nSB = new AtomicReference<>();
    private final AtomicReference<d> nSC = new AtomicReference<>();
    private final AtomicReference<h> nSD = new AtomicReference<>();
    private final AtomicReference<a> nSE = new AtomicReference<>();
    private final AtomicReference<g> nMA = new AtomicReference<>();

    @Deprecated
    public static f dNH() {
        return nSA;
    }

    f() {
    }

    public b dNI() {
        if (this.nSB.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.nSB.compareAndSet(null, nSF);
            } else {
                this.nSB.compareAndSet(null, (b) a);
            }
        }
        return this.nSB.get();
    }

    public d dNJ() {
        if (this.nSC.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.nSC.compareAndSet(null, e.dNG());
            } else {
                this.nSC.compareAndSet(null, (d) a);
            }
        }
        return this.nSC.get();
    }

    public h dNK() {
        if (this.nSD.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.nSD.compareAndSet(null, i.dNU());
            } else {
                this.nSD.compareAndSet(null, (h) a);
            }
        }
        return this.nSD.get();
    }

    public a dNL() {
        if (this.nSE.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.nSE.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.nSE.compareAndSet(null, (a) a);
            }
        }
        return this.nSE.get();
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

    public g dNM() {
        if (this.nMA.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.nMA.compareAndSet(null, g.dNT());
            } else {
                this.nMA.compareAndSet(null, (g) a);
            }
        }
        return this.nMA.get();
    }
}

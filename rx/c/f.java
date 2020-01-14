package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class f {
    private static final f nSF = new f();
    static final b nSK = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> nSG = new AtomicReference<>();
    private final AtomicReference<d> nSH = new AtomicReference<>();
    private final AtomicReference<h> nSI = new AtomicReference<>();
    private final AtomicReference<a> nSJ = new AtomicReference<>();
    private final AtomicReference<g> nMF = new AtomicReference<>();

    @Deprecated
    public static f dNJ() {
        return nSF;
    }

    f() {
    }

    public b dNK() {
        if (this.nSG.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.nSG.compareAndSet(null, nSK);
            } else {
                this.nSG.compareAndSet(null, (b) a);
            }
        }
        return this.nSG.get();
    }

    public d dNL() {
        if (this.nSH.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.nSH.compareAndSet(null, e.dNI());
            } else {
                this.nSH.compareAndSet(null, (d) a);
            }
        }
        return this.nSH.get();
    }

    public h dNM() {
        if (this.nSI.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.nSI.compareAndSet(null, i.dNW());
            } else {
                this.nSI.compareAndSet(null, (h) a);
            }
        }
        return this.nSI.get();
    }

    public a dNN() {
        if (this.nSJ.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.nSJ.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.nSJ.compareAndSet(null, (a) a);
            }
        }
        return this.nSJ.get();
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

    public g dNO() {
        if (this.nMF.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.nMF.compareAndSet(null, g.dNV());
            } else {
                this.nMF.compareAndSet(null, (g) a);
            }
        }
        return this.nMF.get();
    }
}

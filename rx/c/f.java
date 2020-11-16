package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public class f {
    private static final f qlo = new f();
    static final b qlt = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> qlp = new AtomicReference<>();
    private final AtomicReference<d> qlq = new AtomicReference<>();
    private final AtomicReference<h> qlr = new AtomicReference<>();
    private final AtomicReference<a> qls = new AtomicReference<>();
    private final AtomicReference<g> qfm = new AtomicReference<>();

    @Deprecated
    public static f eGv() {
        return qlo;
    }

    f() {
    }

    public b eGw() {
        if (this.qlp.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.qlp.compareAndSet(null, qlt);
            } else {
                this.qlp.compareAndSet(null, (b) a2);
            }
        }
        return this.qlp.get();
    }

    public d eGx() {
        if (this.qlq.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.qlq.compareAndSet(null, e.eGu());
            } else {
                this.qlq.compareAndSet(null, (d) a2);
            }
        }
        return this.qlq.get();
    }

    public h eGy() {
        if (this.qlr.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.qlr.compareAndSet(null, i.eGI());
            } else {
                this.qlr.compareAndSet(null, (h) a2);
            }
        }
        return this.qlr.get();
    }

    public a eGz() {
        if (this.qls.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.qls.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.qls.compareAndSet(null, (a) a2);
            }
        }
        return this.qls.get();
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

    public g eGA() {
        if (this.qfm.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.qfm.compareAndSet(null, g.eGH());
            } else {
                this.qfm.compareAndSet(null, (g) a2);
            }
        }
        return this.qfm.get();
    }
}

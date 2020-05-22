package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class f {
    private static final f nKe = new f();
    static final b nKj = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> nKf = new AtomicReference<>();
    private final AtomicReference<d> nKg = new AtomicReference<>();
    private final AtomicReference<h> nKh = new AtomicReference<>();
    private final AtomicReference<a> nKi = new AtomicReference<>();
    private final AtomicReference<g> nEd = new AtomicReference<>();

    @Deprecated
    public static f dQq() {
        return nKe;
    }

    f() {
    }

    public b dQr() {
        if (this.nKf.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.nKf.compareAndSet(null, nKj);
            } else {
                this.nKf.compareAndSet(null, (b) a);
            }
        }
        return this.nKf.get();
    }

    public d dQs() {
        if (this.nKg.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.nKg.compareAndSet(null, e.dQp());
            } else {
                this.nKg.compareAndSet(null, (d) a);
            }
        }
        return this.nKg.get();
    }

    public h dQt() {
        if (this.nKh.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.nKh.compareAndSet(null, i.dQD());
            } else {
                this.nKh.compareAndSet(null, (h) a);
            }
        }
        return this.nKh.get();
    }

    public a dQu() {
        if (this.nKi.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.nKi.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.nKi.compareAndSet(null, (a) a);
            }
        }
        return this.nKi.get();
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

    public g dQv() {
        if (this.nEd.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.nEd.compareAndSet(null, g.dQC());
            } else {
                this.nEd.compareAndSet(null, (g) a);
            }
        }
        return this.nEd.get();
    }
}

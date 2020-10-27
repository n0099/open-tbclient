package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
public class f {
    private static final f qaq = new f();
    static final b qav = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> qar = new AtomicReference<>();
    private final AtomicReference<d> qas = new AtomicReference<>();
    private final AtomicReference<h> qat = new AtomicReference<>();
    private final AtomicReference<a> qau = new AtomicReference<>();
    private final AtomicReference<g> pUp = new AtomicReference<>();

    @Deprecated
    public static f eCF() {
        return qaq;
    }

    f() {
    }

    public b eCG() {
        if (this.qar.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.qar.compareAndSet(null, qav);
            } else {
                this.qar.compareAndSet(null, (b) a2);
            }
        }
        return this.qar.get();
    }

    public d eCH() {
        if (this.qas.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.qas.compareAndSet(null, e.eCE());
            } else {
                this.qas.compareAndSet(null, (d) a2);
            }
        }
        return this.qas.get();
    }

    public h eCI() {
        if (this.qat.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.qat.compareAndSet(null, i.eCS());
            } else {
                this.qat.compareAndSet(null, (h) a2);
            }
        }
        return this.qat.get();
    }

    public a eCJ() {
        if (this.qau.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.qau.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.qau.compareAndSet(null, (a) a2);
            }
        }
        return this.qau.get();
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

    public g eCK() {
        if (this.pUp.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.pUp.compareAndSet(null, g.eCR());
            } else {
                this.pUp.compareAndSet(null, (g) a2);
            }
        }
        return this.pUp.get();
    }
}

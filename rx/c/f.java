package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class f {
    private static final f qFd = new f();
    static final b qFi = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> qFe = new AtomicReference<>();
    private final AtomicReference<d> qFf = new AtomicReference<>();
    private final AtomicReference<h> qFg = new AtomicReference<>();
    private final AtomicReference<a> qFh = new AtomicReference<>();
    private final AtomicReference<g> qze = new AtomicReference<>();

    @Deprecated
    public static f eNz() {
        return qFd;
    }

    f() {
    }

    public b eNA() {
        if (this.qFe.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.qFe.compareAndSet(null, qFi);
            } else {
                this.qFe.compareAndSet(null, (b) a2);
            }
        }
        return this.qFe.get();
    }

    public d eNB() {
        if (this.qFf.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.qFf.compareAndSet(null, e.eNy());
            } else {
                this.qFf.compareAndSet(null, (d) a2);
            }
        }
        return this.qFf.get();
    }

    public h eNC() {
        if (this.qFg.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.qFg.compareAndSet(null, i.eNM());
            } else {
                this.qFg.compareAndSet(null, (h) a2);
            }
        }
        return this.qFg.get();
    }

    public a eND() {
        if (this.qFh.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.qFh.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.qFh.compareAndSet(null, (a) a2);
            }
        }
        return this.qFh.get();
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

    public g eNE() {
        if (this.qze.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.qze.compareAndSet(null, g.eNL());
            } else {
                this.qze.compareAndSet(null, (g) a2);
            }
        }
        return this.qze.get();
    }
}

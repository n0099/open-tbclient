package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes15.dex */
public class f {
    private static final f qwR = new f();
    static final b qwW = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> qwS = new AtomicReference<>();
    private final AtomicReference<d> qwT = new AtomicReference<>();
    private final AtomicReference<h> qwU = new AtomicReference<>();
    private final AtomicReference<a> qwV = new AtomicReference<>();
    private final AtomicReference<g> qqS = new AtomicReference<>();

    @Deprecated
    public static f eOF() {
        return qwR;
    }

    f() {
    }

    public b eOG() {
        if (this.qwS.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.qwS.compareAndSet(null, qwW);
            } else {
                this.qwS.compareAndSet(null, (b) a2);
            }
        }
        return this.qwS.get();
    }

    public d eOH() {
        if (this.qwT.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.qwT.compareAndSet(null, e.eOE());
            } else {
                this.qwT.compareAndSet(null, (d) a2);
            }
        }
        return this.qwT.get();
    }

    public h eOI() {
        if (this.qwU.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.qwU.compareAndSet(null, i.eOS());
            } else {
                this.qwU.compareAndSet(null, (h) a2);
            }
        }
        return this.qwU.get();
    }

    public a eOJ() {
        if (this.qwV.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.qwV.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.qwV.compareAndSet(null, (a) a2);
            }
        }
        return this.qwV.get();
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

    public g eOK() {
        if (this.qqS.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.qqS.compareAndSet(null, g.eOR());
            } else {
                this.qqS.compareAndSet(null, (g) a2);
            }
        }
        return this.qqS.get();
    }
}

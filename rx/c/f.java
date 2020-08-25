package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class f {
    private static final f oJK = new f();
    static final b oJP = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> oJL = new AtomicReference<>();
    private final AtomicReference<d> oJM = new AtomicReference<>();
    private final AtomicReference<h> oJN = new AtomicReference<>();
    private final AtomicReference<a> oJO = new AtomicReference<>();
    private final AtomicReference<g> oDJ = new AtomicReference<>();

    @Deprecated
    public static f ekP() {
        return oJK;
    }

    f() {
    }

    public b ekQ() {
        if (this.oJL.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.oJL.compareAndSet(null, oJP);
            } else {
                this.oJL.compareAndSet(null, (b) a);
            }
        }
        return this.oJL.get();
    }

    public d ekR() {
        if (this.oJM.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.oJM.compareAndSet(null, e.ekO());
            } else {
                this.oJM.compareAndSet(null, (d) a);
            }
        }
        return this.oJM.get();
    }

    public h ekS() {
        if (this.oJN.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.oJN.compareAndSet(null, i.elc());
            } else {
                this.oJN.compareAndSet(null, (h) a);
            }
        }
        return this.oJN.get();
    }

    public a ekT() {
        if (this.oJO.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.oJO.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.oJO.compareAndSet(null, (a) a);
            }
        }
        return this.oJO.get();
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

    public g ekU() {
        if (this.oDJ.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.oDJ.compareAndSet(null, g.elb());
            } else {
                this.oDJ.compareAndSet(null, (g) a);
            }
        }
        return this.oDJ.get();
    }
}

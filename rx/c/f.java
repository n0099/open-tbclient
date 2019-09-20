package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class f {
    private static final f kEU = new f();
    static final b kEZ = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> kEV = new AtomicReference<>();
    private final AtomicReference<d> kEW = new AtomicReference<>();
    private final AtomicReference<h> kEX = new AtomicReference<>();
    private final AtomicReference<a> kEY = new AtomicReference<>();
    private final AtomicReference<g> kyc = new AtomicReference<>();

    @Deprecated
    public static f cRw() {
        return kEU;
    }

    f() {
    }

    public b cRx() {
        if (this.kEV.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.kEV.compareAndSet(null, kEZ);
            } else {
                this.kEV.compareAndSet(null, (b) a);
            }
        }
        return this.kEV.get();
    }

    public d cRy() {
        if (this.kEW.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.kEW.compareAndSet(null, e.cRv());
            } else {
                this.kEW.compareAndSet(null, (d) a);
            }
        }
        return this.kEW.get();
    }

    public h cRz() {
        if (this.kEX.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.kEX.compareAndSet(null, i.cRJ());
            } else {
                this.kEX.compareAndSet(null, (h) a);
            }
        }
        return this.kEX.get();
    }

    public a cRA() {
        if (this.kEY.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.kEY.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.kEY.compareAndSet(null, (a) a);
            }
        }
        return this.kEY.get();
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

    public g cRB() {
        if (this.kyc.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.kyc.compareAndSet(null, g.cRI());
            } else {
                this.kyc.compareAndSet(null, (g) a);
            }
        }
        return this.kyc.get();
    }
}

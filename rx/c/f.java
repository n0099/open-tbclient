package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class f {
    private static final f iET = new f();
    static final b iEY = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> iEU = new AtomicReference<>();
    private final AtomicReference<d> iEV = new AtomicReference<>();
    private final AtomicReference<h> iEW = new AtomicReference<>();
    private final AtomicReference<a> iEX = new AtomicReference<>();
    private final AtomicReference<g> isp = new AtomicReference<>();

    @Deprecated
    public static f cdr() {
        return iET;
    }

    f() {
    }

    public b cds() {
        if (this.iEU.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.iEU.compareAndSet(null, iEY);
            } else {
                this.iEU.compareAndSet(null, (b) a);
            }
        }
        return this.iEU.get();
    }

    public d cdt() {
        if (this.iEV.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.iEV.compareAndSet(null, e.cdq());
            } else {
                this.iEV.compareAndSet(null, (d) a);
            }
        }
        return this.iEV.get();
    }

    public h cdu() {
        if (this.iEW.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.iEW.compareAndSet(null, i.cdE());
            } else {
                this.iEW.compareAndSet(null, (h) a);
            }
        }
        return this.iEW.get();
    }

    public a cdv() {
        if (this.iEX.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.iEX.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.iEX.compareAndSet(null, (a) a);
            }
        }
        return this.iEX.get();
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

    public g cdw() {
        if (this.isp.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.isp.compareAndSet(null, g.cdD());
            } else {
                this.isp.compareAndSet(null, (g) a);
            }
        }
        return this.isp.get();
    }
}

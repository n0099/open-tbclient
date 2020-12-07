package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes12.dex */
public class f {
    private static final f pVp = new f();
    static final b pVu = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> pVq = new AtomicReference<>();
    private final AtomicReference<d> pVr = new AtomicReference<>();
    private final AtomicReference<h> pVs = new AtomicReference<>();
    private final AtomicReference<a> pVt = new AtomicReference<>();
    private final AtomicReference<g> pPo = new AtomicReference<>();

    @Deprecated
    public static f eGw() {
        return pVp;
    }

    f() {
    }

    public b eGx() {
        if (this.pVq.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.pVq.compareAndSet(null, pVu);
            } else {
                this.pVq.compareAndSet(null, (b) a2);
            }
        }
        return this.pVq.get();
    }

    public d eGy() {
        if (this.pVr.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.pVr.compareAndSet(null, e.eGv());
            } else {
                this.pVr.compareAndSet(null, (d) a2);
            }
        }
        return this.pVr.get();
    }

    public h eGz() {
        if (this.pVs.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.pVs.compareAndSet(null, i.eGJ());
            } else {
                this.pVs.compareAndSet(null, (h) a2);
            }
        }
        return this.pVs.get();
    }

    public a eGA() {
        if (this.pVt.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.pVt.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.pVt.compareAndSet(null, (a) a2);
            }
        }
        return this.pVt.get();
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

    public g eGB() {
        if (this.pPo.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.pPo.compareAndSet(null, g.eGI());
            } else {
                this.pPo.compareAndSet(null, (g) a2);
            }
        }
        return this.pPo.get();
    }
}

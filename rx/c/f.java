package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class f {
    private static final f ohf = new f();
    static final b ohk = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> ohg = new AtomicReference<>();
    private final AtomicReference<d> ohh = new AtomicReference<>();
    private final AtomicReference<h> ohi = new AtomicReference<>();
    private final AtomicReference<a> ohj = new AtomicReference<>();
    private final AtomicReference<g> obb = new AtomicReference<>();

    @Deprecated
    public static f dVo() {
        return ohf;
    }

    f() {
    }

    public b dVp() {
        if (this.ohg.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.ohg.compareAndSet(null, ohk);
            } else {
                this.ohg.compareAndSet(null, (b) a);
            }
        }
        return this.ohg.get();
    }

    public d dVq() {
        if (this.ohh.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.ohh.compareAndSet(null, e.dVn());
            } else {
                this.ohh.compareAndSet(null, (d) a);
            }
        }
        return this.ohh.get();
    }

    public h dVr() {
        if (this.ohi.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.ohi.compareAndSet(null, i.dVB());
            } else {
                this.ohi.compareAndSet(null, (h) a);
            }
        }
        return this.ohi.get();
    }

    public a dVs() {
        if (this.ohj.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.ohj.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.ohj.compareAndSet(null, (a) a);
            }
        }
        return this.ohj.get();
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

    public g dVt() {
        if (this.obb.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.obb.compareAndSet(null, g.dVA());
            } else {
                this.obb.compareAndSet(null, (g) a);
            }
        }
        return this.obb.get();
    }
}

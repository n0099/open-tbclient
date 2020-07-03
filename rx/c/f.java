package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class f {
    private static final f ohc = new f();
    static final b ohh = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> ohd = new AtomicReference<>();
    private final AtomicReference<d> ohe = new AtomicReference<>();
    private final AtomicReference<h> ohf = new AtomicReference<>();
    private final AtomicReference<a> ohg = new AtomicReference<>();
    private final AtomicReference<g> oaY = new AtomicReference<>();

    @Deprecated
    public static f dVk() {
        return ohc;
    }

    f() {
    }

    public b dVl() {
        if (this.ohd.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.ohd.compareAndSet(null, ohh);
            } else {
                this.ohd.compareAndSet(null, (b) a);
            }
        }
        return this.ohd.get();
    }

    public d dVm() {
        if (this.ohe.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.ohe.compareAndSet(null, e.dVj());
            } else {
                this.ohe.compareAndSet(null, (d) a);
            }
        }
        return this.ohe.get();
    }

    public h dVn() {
        if (this.ohf.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.ohf.compareAndSet(null, i.dVx());
            } else {
                this.ohf.compareAndSet(null, (h) a);
            }
        }
        return this.ohf.get();
    }

    public a dVo() {
        if (this.ohg.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.ohg.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.ohg.compareAndSet(null, (a) a);
            }
        }
        return this.ohg.get();
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

    public g dVp() {
        if (this.oaY.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.oaY.compareAndSet(null, g.dVw());
            } else {
                this.oaY.compareAndSet(null, (g) a);
            }
        }
        return this.oaY.get();
    }
}

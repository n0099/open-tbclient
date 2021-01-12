package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public class f {
    private static final f qtX = new f();
    static final b quc = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> qtY = new AtomicReference<>();
    private final AtomicReference<d> qtZ = new AtomicReference<>();
    private final AtomicReference<h> qua = new AtomicReference<>();
    private final AtomicReference<a> qub = new AtomicReference<>();
    private final AtomicReference<g> qnY = new AtomicReference<>();

    @Deprecated
    public static f eLt() {
        return qtX;
    }

    f() {
    }

    public b eLu() {
        if (this.qtY.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.qtY.compareAndSet(null, quc);
            } else {
                this.qtY.compareAndSet(null, (b) a2);
            }
        }
        return this.qtY.get();
    }

    public d eLv() {
        if (this.qtZ.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.qtZ.compareAndSet(null, e.eLs());
            } else {
                this.qtZ.compareAndSet(null, (d) a2);
            }
        }
        return this.qtZ.get();
    }

    public h eLw() {
        if (this.qua.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.qua.compareAndSet(null, i.eLG());
            } else {
                this.qua.compareAndSet(null, (h) a2);
            }
        }
        return this.qua.get();
    }

    public a eLx() {
        if (this.qub.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.qub.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.qub.compareAndSet(null, (a) a2);
            }
        }
        return this.qub.get();
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

    public g eLy() {
        if (this.qnY.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.qnY.compareAndSet(null, g.eLF());
            } else {
                this.qnY.compareAndSet(null, (g) a2);
            }
        }
        return this.qnY.get();
    }
}

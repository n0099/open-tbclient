package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class f {
    private static final f nTt = new f();
    static final b nTy = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> nTu = new AtomicReference<>();
    private final AtomicReference<d> nTv = new AtomicReference<>();
    private final AtomicReference<h> nTw = new AtomicReference<>();
    private final AtomicReference<a> nTx = new AtomicReference<>();
    private final AtomicReference<g> nNu = new AtomicReference<>();

    @Deprecated
    public static f dOW() {
        return nTt;
    }

    f() {
    }

    public b dOX() {
        if (this.nTu.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.nTu.compareAndSet(null, nTy);
            } else {
                this.nTu.compareAndSet(null, (b) a);
            }
        }
        return this.nTu.get();
    }

    public d dOY() {
        if (this.nTv.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.nTv.compareAndSet(null, e.dOV());
            } else {
                this.nTv.compareAndSet(null, (d) a);
            }
        }
        return this.nTv.get();
    }

    public h dOZ() {
        if (this.nTw.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.nTw.compareAndSet(null, i.dPj());
            } else {
                this.nTw.compareAndSet(null, (h) a);
            }
        }
        return this.nTw.get();
    }

    public a dPa() {
        if (this.nTx.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.nTx.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.nTx.compareAndSet(null, (a) a);
            }
        }
        return this.nTx.get();
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

    public g dPb() {
        if (this.nNu.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.nNu.compareAndSet(null, g.dPi());
            } else {
                this.nNu.compareAndSet(null, (g) a);
            }
        }
        return this.nNu.get();
    }
}

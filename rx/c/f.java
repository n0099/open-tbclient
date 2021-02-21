package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public class f {
    private static final f qEB = new f();
    static final b qEG = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> qEC = new AtomicReference<>();
    private final AtomicReference<d> qED = new AtomicReference<>();
    private final AtomicReference<h> qEE = new AtomicReference<>();
    private final AtomicReference<a> qEF = new AtomicReference<>();
    private final AtomicReference<g> qyC = new AtomicReference<>();

    @Deprecated
    public static f eNR() {
        return qEB;
    }

    f() {
    }

    public b eNS() {
        if (this.qEC.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.qEC.compareAndSet(null, qEG);
            } else {
                this.qEC.compareAndSet(null, (b) a2);
            }
        }
        return this.qEC.get();
    }

    public d eNT() {
        if (this.qED.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.qED.compareAndSet(null, e.eNQ());
            } else {
                this.qED.compareAndSet(null, (d) a2);
            }
        }
        return this.qED.get();
    }

    public h eNU() {
        if (this.qEE.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.qEE.compareAndSet(null, i.eOe());
            } else {
                this.qEE.compareAndSet(null, (h) a2);
            }
        }
        return this.qEE.get();
    }

    public a eNV() {
        if (this.qEF.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.qEF.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.qEF.compareAndSet(null, (a) a2);
            }
        }
        return this.qEF.get();
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

    public g eNW() {
        if (this.qyC.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.qyC.compareAndSet(null, g.eOd());
            } else {
                this.qyC.compareAndSet(null, (g) a2);
            }
        }
        return this.qyC.get();
    }
}

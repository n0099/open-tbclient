package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class f {
    private static final f oTH = new f();
    static final b oTM = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> oTI = new AtomicReference<>();
    private final AtomicReference<d> oTJ = new AtomicReference<>();
    private final AtomicReference<h> oTK = new AtomicReference<>();
    private final AtomicReference<a> oTL = new AtomicReference<>();
    private final AtomicReference<g> oNG = new AtomicReference<>();

    @Deprecated
    public static f eoW() {
        return oTH;
    }

    f() {
    }

    public b eoX() {
        if (this.oTI.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.oTI.compareAndSet(null, oTM);
            } else {
                this.oTI.compareAndSet(null, (b) a);
            }
        }
        return this.oTI.get();
    }

    public d eoY() {
        if (this.oTJ.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.oTJ.compareAndSet(null, e.eoV());
            } else {
                this.oTJ.compareAndSet(null, (d) a);
            }
        }
        return this.oTJ.get();
    }

    public h eoZ() {
        if (this.oTK.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.oTK.compareAndSet(null, i.epj());
            } else {
                this.oTK.compareAndSet(null, (h) a);
            }
        }
        return this.oTK.get();
    }

    public a epa() {
        if (this.oTL.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.oTL.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.oTL.compareAndSet(null, (a) a);
            }
        }
        return this.oTL.get();
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

    public g epb() {
        if (this.oNG.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.oNG.compareAndSet(null, g.epi());
            } else {
                this.oNG.compareAndSet(null, (g) a);
            }
        }
        return this.oNG.get();
    }
}

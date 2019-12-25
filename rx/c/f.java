package rx.c;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class f {
    private static final f njD = new f();
    static final b njI = new b() { // from class: rx.c.f.1
    };
    private final AtomicReference<b> njE = new AtomicReference<>();
    private final AtomicReference<d> njF = new AtomicReference<>();
    private final AtomicReference<h> njG = new AtomicReference<>();
    private final AtomicReference<a> njH = new AtomicReference<>();
    private final AtomicReference<g> ndB = new AtomicReference<>();

    @Deprecated
    public static f dHg() {
        return njD;
    }

    f() {
    }

    public b dHh() {
        if (this.njE.get() == null) {
            Object a = a(b.class, System.getProperties());
            if (a == null) {
                this.njE.compareAndSet(null, njI);
            } else {
                this.njE.compareAndSet(null, (b) a);
            }
        }
        return this.njE.get();
    }

    public d dHi() {
        if (this.njF.get() == null) {
            Object a = a(d.class, System.getProperties());
            if (a == null) {
                this.njF.compareAndSet(null, e.dHf());
            } else {
                this.njF.compareAndSet(null, (d) a);
            }
        }
        return this.njF.get();
    }

    public h dHj() {
        if (this.njG.get() == null) {
            Object a = a(h.class, System.getProperties());
            if (a == null) {
                this.njG.compareAndSet(null, i.dHt());
            } else {
                this.njG.compareAndSet(null, (h) a);
            }
        }
        return this.njG.get();
    }

    public a dHk() {
        if (this.njH.get() == null) {
            Object a = a(a.class, System.getProperties());
            if (a == null) {
                this.njH.compareAndSet(null, new a() { // from class: rx.c.f.2
                });
            } else {
                this.njH.compareAndSet(null, (a) a);
            }
        }
        return this.njH.get();
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

    public g dHl() {
        if (this.ndB.get() == null) {
            Object a = a(g.class, System.getProperties());
            if (a == null) {
                this.ndB.compareAndSet(null, g.dHs());
            } else {
                this.ndB.compareAndSet(null, (g) a);
            }
        }
        return this.ndB.get();
    }
}

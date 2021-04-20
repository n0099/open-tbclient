package h.r;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    public static final f f69007f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final h.r.b f69008g = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<h.r.b> f69009a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<d> f69010b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<h> f69011c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<h.r.a> f69012d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<g> f69013e = new AtomicReference<>();

    /* loaded from: classes7.dex */
    public static class a extends h.r.b {
    }

    /* loaded from: classes7.dex */
    public class b extends h.r.a {
        public b(f fVar) {
        }
    }

    @Deprecated
    public static f c() {
        return f69007f;
    }

    public static Object e(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it = properties2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String obj = entry.getKey().toString();
                if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                    String property2 = properties2.getProperty(str);
                    if (property2 == null) {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                    property = property2;
                }
            }
        }
        if (property != null) {
            try {
                return Class.forName(property).asSubclass(cls).newInstance();
            } catch (ClassCastException e2) {
                throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e2);
            } catch (ClassNotFoundException e3) {
                throw new IllegalStateException(simpleName + " implementation class not found: " + property, e3);
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e4);
            } catch (InstantiationException e5) {
                throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e5);
            }
        }
        return null;
    }

    public h.r.a a() {
        if (this.f69012d.get() == null) {
            Object e2 = e(h.r.a.class, System.getProperties());
            if (e2 == null) {
                this.f69012d.compareAndSet(null, new b(this));
            } else {
                this.f69012d.compareAndSet(null, (h.r.a) e2);
            }
        }
        return this.f69012d.get();
    }

    public h.r.b b() {
        if (this.f69009a.get() == null) {
            Object e2 = e(h.r.b.class, System.getProperties());
            if (e2 == null) {
                this.f69009a.compareAndSet(null, f69008g);
            } else {
                this.f69009a.compareAndSet(null, (h.r.b) e2);
            }
        }
        return this.f69009a.get();
    }

    public d d() {
        if (this.f69010b.get() == null) {
            Object e2 = e(d.class, System.getProperties());
            if (e2 == null) {
                this.f69010b.compareAndSet(null, e.f());
            } else {
                this.f69010b.compareAndSet(null, (d) e2);
            }
        }
        return this.f69010b.get();
    }

    public g f() {
        if (this.f69013e.get() == null) {
            Object e2 = e(g.class, System.getProperties());
            if (e2 == null) {
                this.f69013e.compareAndSet(null, g.h());
            } else {
                this.f69013e.compareAndSet(null, (g) e2);
            }
        }
        return this.f69013e.get();
    }

    public h g() {
        if (this.f69011c.get() == null) {
            Object e2 = e(h.class, System.getProperties());
            if (e2 == null) {
                this.f69011c.compareAndSet(null, i.e());
            } else {
                this.f69011c.compareAndSet(null, (h) e2);
            }
        }
        return this.f69011c.get();
    }
}

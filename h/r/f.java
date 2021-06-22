package h.r;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    public static final f f72101f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final h.r.b f72102g = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<h.r.b> f72103a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<d> f72104b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<h> f72105c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<h.r.a> f72106d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<g> f72107e = new AtomicReference<>();

    /* loaded from: classes8.dex */
    public static class a extends h.r.b {
    }

    /* loaded from: classes8.dex */
    public class b extends h.r.a {
        public b(f fVar) {
        }
    }

    @Deprecated
    public static f c() {
        return f72101f;
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
        if (this.f72106d.get() == null) {
            Object e2 = e(h.r.a.class, System.getProperties());
            if (e2 == null) {
                this.f72106d.compareAndSet(null, new b(this));
            } else {
                this.f72106d.compareAndSet(null, (h.r.a) e2);
            }
        }
        return this.f72106d.get();
    }

    public h.r.b b() {
        if (this.f72103a.get() == null) {
            Object e2 = e(h.r.b.class, System.getProperties());
            if (e2 == null) {
                this.f72103a.compareAndSet(null, f72102g);
            } else {
                this.f72103a.compareAndSet(null, (h.r.b) e2);
            }
        }
        return this.f72103a.get();
    }

    public d d() {
        if (this.f72104b.get() == null) {
            Object e2 = e(d.class, System.getProperties());
            if (e2 == null) {
                this.f72104b.compareAndSet(null, e.f());
            } else {
                this.f72104b.compareAndSet(null, (d) e2);
            }
        }
        return this.f72104b.get();
    }

    public g f() {
        if (this.f72107e.get() == null) {
            Object e2 = e(g.class, System.getProperties());
            if (e2 == null) {
                this.f72107e.compareAndSet(null, g.h());
            } else {
                this.f72107e.compareAndSet(null, (g) e2);
            }
        }
        return this.f72107e.get();
    }

    public h g() {
        if (this.f72105c.get() == null) {
            Object e2 = e(h.class, System.getProperties());
            if (e2 == null) {
                this.f72105c.compareAndSet(null, i.e());
            } else {
                this.f72105c.compareAndSet(null, (h) e2);
            }
        }
        return this.f72105c.get();
    }
}

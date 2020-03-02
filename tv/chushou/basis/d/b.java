package tv.chushou.basis.d;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b nVn;
    private static volatile Application sApplication;
    private final Map<String, Class<?>> nVo = new TreeMap();
    private final Map<String, Object> nVp = new TreeMap();
    private static final tv.chushou.a.a.c.b nVm = tv.chushou.a.a.c.a.dQf();
    private static volatile boolean sDebug = false;

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            sDebug = aVar.debug;
            sApplication = aVar.application;
            nVm.xc(aVar.debug);
            nVm.xd(aVar.nVq);
        }
    }

    public static boolean dPS() {
        return sDebug;
    }

    @SuppressLint({"PrivateApi"})
    public static Application dPT() {
        if (sApplication != null) {
            return sApplication;
        }
        if (sApplication == null) {
            synchronized (b.class) {
                if (sApplication == null) {
                    try {
                        sApplication = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
                    } catch (Exception e) {
                    }
                }
            }
        }
        return sApplication;
    }

    public static tv.chushou.a.a.c.b dPU() {
        return nVm;
    }

    public static b dPV() {
        if (nVn == null) {
            synchronized (b.class) {
                if (nVn == null) {
                    nVn = new b();
                }
            }
        }
        return nVn;
    }

    public void e(Class<?> cls, Class<?> cls2) {
        if (cls != null && cls2 != null) {
            if (!cls.isAssignableFrom(cls2)) {
                dPU().e("Router", "apiImpl must implements interface api");
                return;
            }
            String name = cls.getName();
            if (this.nVo.get(name) != null) {
                throw new IllegalStateException("Component " + name + " already has an implementation");
            }
            this.nVo.put(name, cls2);
        }
    }

    /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.Object>, java.util.Map */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [tv.chushou.basis.d.a] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object, tv.chushou.basis.d.a] */
    @Nullable
    public synchronized <T extends tv.chushou.basis.d.a> T S(Class<T> cls) {
        T t;
        T t2 = null;
        synchronized (this) {
            if (cls != null) {
                String name = cls.getName();
                Object obj = this.nVp.get(name);
                if (obj != null) {
                    t2 = (tv.chushou.basis.d.a) obj;
                } else {
                    Class<?> cls2 = this.nVo.get(name);
                    if (cls2 != null) {
                        try {
                            ?? r0 = (tv.chushou.basis.d.a) cls2.newInstance();
                            try {
                                r0.init(dPT());
                                this.nVp.put(name, r0);
                                t = r0;
                            } catch (Exception e) {
                                t2 = r0;
                                e = e;
                                dPU().e("Router", "component " + name + " newInstance failed", e);
                                if (t2 == null) {
                                    dPU().e(null, "Router getComponet:" + cls.getName() + " failed");
                                }
                                return t2;
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } else {
                        t = null;
                    }
                    t2 = t;
                    if (t2 == null && dPS()) {
                        dPU().e(null, "Router getComponet:" + cls.getName() + " failed");
                    }
                }
            }
        }
        return t2;
    }

    /* loaded from: classes5.dex */
    public static class a {
        Application application;
        boolean debug;
        boolean nVq;

        public a(Application application) {
            this.application = application;
        }

        public a xb(boolean z) {
            this.debug = z;
            return this;
        }
    }
}

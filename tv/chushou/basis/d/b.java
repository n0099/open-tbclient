package tv.chushou.basis.d;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b nLX;
    private static volatile Application sApplication;
    private final Map<String, Class<?>> nLY = new TreeMap();
    private final Map<String, Object> nLZ = new TreeMap();
    private static final tv.chushou.a.a.c.b nLW = tv.chushou.a.a.c.a.dRw();
    private static volatile boolean sDebug = false;

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            sDebug = aVar.debug;
            sApplication = aVar.application;
            nLW.showLog(aVar.debug);
            nLW.xn(aVar.nMa);
        }
    }

    public static boolean ND() {
        return sDebug;
    }

    @SuppressLint({"PrivateApi"})
    public static Application dRk() {
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

    public static tv.chushou.a.a.c.b dRl() {
        return nLW;
    }

    public static b dRm() {
        if (nLX == null) {
            synchronized (b.class) {
                if (nLX == null) {
                    nLX = new b();
                }
            }
        }
        return nLX;
    }

    public void e(Class<?> cls, Class<?> cls2) {
        if (cls != null && cls2 != null) {
            if (!cls.isAssignableFrom(cls2)) {
                dRl().e("Router", "apiImpl must implements interface api");
                return;
            }
            String name = cls.getName();
            if (this.nLY.get(name) != null) {
                throw new IllegalStateException("Component " + name + " already has an implementation");
            }
            this.nLY.put(name, cls2);
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
                Object obj = this.nLZ.get(name);
                if (obj != null) {
                    t2 = (tv.chushou.basis.d.a) obj;
                } else {
                    Class<?> cls2 = this.nLY.get(name);
                    if (cls2 != null) {
                        try {
                            ?? r0 = (tv.chushou.basis.d.a) cls2.newInstance();
                            try {
                                r0.init(dRk());
                                this.nLZ.put(name, r0);
                                t = r0;
                            } catch (Exception e) {
                                t2 = r0;
                                e = e;
                                dRl().e("Router", "component " + name + " newInstance failed", e);
                                if (t2 == null) {
                                    dRl().e(null, "Router getComponet:" + cls.getName() + " failed");
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
                    if (t2 == null && ND()) {
                        dRl().e(null, "Router getComponet:" + cls.getName() + " failed");
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
        boolean nMa;

        public a(Application application) {
            this.application = application;
        }

        public a xm(boolean z) {
            this.debug = z;
            return this;
        }
    }
}

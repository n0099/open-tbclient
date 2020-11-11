package tv.chushou.basis.d;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class b {
    private static volatile b qlD;
    private static volatile Application sApplication;
    private final Map<String, Class<?>> qlE = new TreeMap();
    private final Map<String, Object> qlF = new TreeMap();
    private static final tv.chushou.a.a.c.b qlC = tv.chushou.a.a.c.a.eHz();
    private static volatile boolean sDebug = false;

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            sDebug = aVar.debug;
            sApplication = aVar.application;
            qlC.showLog(aVar.debug);
            qlC.Br(aVar.qlG);
        }
    }

    public static boolean abT() {
        return sDebug;
    }

    @SuppressLint({"PrivateApi"})
    public static Application eHo() {
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

    public static tv.chushou.a.a.c.b eHp() {
        return qlC;
    }

    public static b eHq() {
        if (qlD == null) {
            synchronized (b.class) {
                if (qlD == null) {
                    qlD = new b();
                }
            }
        }
        return qlD;
    }

    public void e(Class<?> cls, Class<?> cls2) {
        if (cls != null && cls2 != null) {
            if (!cls.isAssignableFrom(cls2)) {
                eHp().e("Router", "apiImpl must implements interface api");
                return;
            }
            String name = cls.getName();
            if (this.qlE.get(name) != null) {
                throw new IllegalStateException("Component " + name + " already has an implementation");
            }
            this.qlE.put(name, cls2);
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
                Object obj = this.qlF.get(name);
                if (obj != null) {
                    t2 = (tv.chushou.basis.d.a) obj;
                } else {
                    Class<?> cls2 = this.qlE.get(name);
                    if (cls2 != null) {
                        try {
                            ?? r0 = (tv.chushou.basis.d.a) cls2.newInstance();
                            try {
                                r0.init(eHo());
                                this.qlF.put(name, r0);
                                t = r0;
                            } catch (Exception e) {
                                t2 = r0;
                                e = e;
                                eHp().e("Router", "component " + name + " newInstance failed", e);
                                if (t2 == null) {
                                    eHp().e(null, "Router getComponet:" + cls.getName() + " failed");
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
                    if (t2 == null && abT()) {
                        eHp().e(null, "Router getComponet:" + cls.getName() + " failed");
                    }
                }
            }
        }
        return t2;
    }

    /* loaded from: classes6.dex */
    public static class a {
        Application application;
        boolean debug;
        boolean qlG;

        public a(Application application) {
            this.application = application;
        }

        public a Bq(boolean z) {
            this.debug = z;
            return this;
        }
    }
}

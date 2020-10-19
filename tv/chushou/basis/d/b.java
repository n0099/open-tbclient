package tv.chushou.basis.d;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class b {
    private static volatile b pkT;
    private static volatile Application sApplication;
    private final Map<String, Class<?>> pkU = new TreeMap();
    private final Map<String, Object> pkV = new TreeMap();
    private static final tv.chushou.a.a.c.b pkS = tv.chushou.a.a.c.a.etM();
    private static volatile boolean sDebug = false;

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            sDebug = aVar.debug;
            sApplication = aVar.application;
            pkS.showLog(aVar.debug);
            pkS.zY(aVar.pkW);
        }
    }

    public static boolean XA() {
        return sDebug;
    }

    @SuppressLint({"PrivateApi"})
    public static Application etB() {
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

    public static tv.chushou.a.a.c.b etC() {
        return pkS;
    }

    public static b etD() {
        if (pkT == null) {
            synchronized (b.class) {
                if (pkT == null) {
                    pkT = new b();
                }
            }
        }
        return pkT;
    }

    public void e(Class<?> cls, Class<?> cls2) {
        if (cls != null && cls2 != null) {
            if (!cls.isAssignableFrom(cls2)) {
                etC().e("Router", "apiImpl must implements interface api");
                return;
            }
            String name = cls.getName();
            if (this.pkU.get(name) != null) {
                throw new IllegalStateException("Component " + name + " already has an implementation");
            }
            this.pkU.put(name, cls2);
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
                Object obj = this.pkV.get(name);
                if (obj != null) {
                    t2 = (tv.chushou.basis.d.a) obj;
                } else {
                    Class<?> cls2 = this.pkU.get(name);
                    if (cls2 != null) {
                        try {
                            ?? r0 = (tv.chushou.basis.d.a) cls2.newInstance();
                            try {
                                r0.init(etB());
                                this.pkV.put(name, r0);
                                t = r0;
                            } catch (Exception e) {
                                t2 = r0;
                                e = e;
                                etC().e("Router", "component " + name + " newInstance failed", e);
                                if (t2 == null) {
                                    etC().e(null, "Router getComponet:" + cls.getName() + " failed");
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
                    if (t2 == null && XA()) {
                        etC().e(null, "Router getComponet:" + cls.getName() + " failed");
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
        boolean pkW;

        public a(Application application) {
            this.application = application;
        }

        public a zX(boolean z) {
            this.debug = z;
            return this;
        }
    }
}

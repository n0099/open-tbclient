package d.o.a.e.b.o.b;

import d.o.a.e.b.l.e;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f71342a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f71343b;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f71344a = new a();
    }

    public static a a() {
        return b.f71344a;
    }

    public c b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        c remove;
        synchronized (this.f71342a) {
            remove = this.f71342a.remove(str);
        }
        if (remove != null) {
            if (e.Q(remove.k(), list)) {
                try {
                    remove.d();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (remove.i() && remove.h()) {
                    return remove;
                }
            }
            try {
                remove.c();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public void c(int i2) {
    }

    public void d(String str, c cVar) {
        synchronized (this.f71342a) {
            this.f71342a.put(str, cVar);
        }
    }

    public boolean e(String str) {
        c cVar = this.f71342a.get(str);
        if (cVar != null) {
            if (cVar.j()) {
                return true;
            }
            return cVar.i() && cVar.h();
        }
        return false;
    }

    public d f(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        d remove;
        synchronized (this.f71343b) {
            remove = this.f71343b.remove(str);
        }
        if (remove != null) {
            if (e.Q(remove.f(), list)) {
                try {
                    remove.e();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (remove.h() && remove.g()) {
                    return remove;
                }
            }
            try {
                remove.d();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public a() {
        this.f71342a = new HashMap();
        this.f71343b = new LinkedHashMap(3);
    }
}

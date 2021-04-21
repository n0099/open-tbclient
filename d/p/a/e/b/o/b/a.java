package d.p.a.e.b.o.b;

import d.p.a.e.b.l.e;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, c> f68347a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f68348b;

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f68349a = new a();
    }

    public static a a() {
        return b.f68349a;
    }

    public c b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        c remove;
        synchronized (this.f68347a) {
            remove = this.f68347a.remove(str);
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

    public void c(int i) {
    }

    public void d(String str, c cVar) {
        synchronized (this.f68347a) {
            this.f68347a.put(str, cVar);
        }
    }

    public boolean e(String str) {
        c cVar = this.f68347a.get(str);
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
        synchronized (this.f68348b) {
            remove = this.f68348b.remove(str);
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
        this.f68347a = new HashMap();
        this.f68348b = new LinkedHashMap(3);
    }
}

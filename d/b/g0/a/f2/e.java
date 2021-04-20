package d.b.g0.a.f2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.common.internal.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class e implements d.b.g0.a.f2.b, d {
    public static Handler m = new Handler(Looper.getMainLooper());
    public final Map<d.b.g0.a.f2.c<?>, Set<b>> l = new HashMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f44860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Set f44861f;

        public a(e eVar, Set set, Set set2) {
            this.f44860e = set;
            this.f44861f = set2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (b bVar : this.f44860e) {
                bVar.onCallback(this.f44861f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b extends d.b.g0.a.i2.u0.b<Set<d.b.g0.a.f2.c<?>>> {
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final e f44862a = new e();
    }

    public static e a() {
        return c.f44862a;
    }

    public final <T> boolean b(T... tArr) {
        return tArr == null || tArr.length < 1;
    }

    public e c(Set<d.b.g0.a.f2.c<?>> set) {
        if (set.isEmpty()) {
            return this;
        }
        HashSet hashSet = new HashSet();
        synchronized (this.l) {
            for (d.b.g0.a.f2.c<?> cVar : set) {
                hashSet.addAll(i(cVar));
            }
        }
        d(hashSet, set);
        return this;
    }

    public final e d(Set<b> set, Set<d.b.g0.a.f2.c<?>> set2) {
        m.post(new a(this, set, set2));
        return this;
    }

    public e e(d.b.g0.a.f2.c<?>... cVarArr) {
        c(Sets.newHashSet(cVarArr));
        return this;
    }

    public e f(d.b.g0.a.f2.a aVar) {
        String aVar2 = aVar == null ? "" : aVar.toString();
        if (d.b.g0.a.f2.b.f44849a) {
            Log.i("Tracer-ErrCode", aVar2);
        }
        d.b.g0.a.c0.c.b("Tracer-ErrCode", aVar2);
        return this;
    }

    public e g(b bVar, d.b.g0.a.f2.c<?>... cVarArr) {
        if (bVar != null) {
            synchronized (this.l) {
                Set<d.b.g0.a.f2.c<?>> keySet = b(cVarArr) ? this.l.keySet() : Sets.newHashSet(cVarArr);
                for (d.b.g0.a.f2.c<?> cVar : keySet) {
                    if (cVar != null) {
                        i(cVar).add(bVar);
                    }
                }
                d(Sets.newHashSet(bVar), keySet);
            }
        }
        return this;
    }

    public e h(d.b.g0.a.f2.c<?>... cVarArr) {
        synchronized (this.l) {
            for (d.b.g0.a.f2.c<?> cVar : cVarArr) {
                if (!this.l.containsKey(cVar)) {
                    this.l.put(cVar, new HashSet());
                }
            }
        }
        return this;
    }

    public final Set<b> i(@NonNull d.b.g0.a.f2.c<?> cVar) {
        Set<b> set = this.l.get(cVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.l.put(cVar, hashSet);
            return hashSet;
        }
        return set;
    }

    public e j(b bVar, d.b.g0.a.f2.c<?>... cVarArr) {
        if (bVar != null) {
            synchronized (this.l) {
                for (d.b.g0.a.f2.c<?> cVar : b(cVarArr) ? this.l.keySet() : Sets.newHashSet(cVarArr)) {
                    if (cVar != null) {
                        i(cVar).remove(bVar);
                    }
                }
            }
        }
        return this;
    }
}

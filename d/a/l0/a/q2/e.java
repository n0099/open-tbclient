package d.a.l0.a.q2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.common.internal.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class e implements d.a.l0.a.q2.b, d {
    public final Map<d.a.l0.a.q2.c<?>, Set<b>> l = new HashMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f47911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Set f47912f;

        public a(e eVar, Set set, Set set2) {
            this.f47911e = set;
            this.f47912f = set2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (b bVar : this.f47911e) {
                bVar.onCallback(this.f47912f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b extends d.a.l0.a.v2.e1.b<Set<d.a.l0.a.q2.c<?>>> {
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final e f47913a = new e();
    }

    public static e a() {
        return c.f47913a;
    }

    public final <T> boolean b(T... tArr) {
        return tArr == null || tArr.length < 1;
    }

    public e c(Set<d.a.l0.a.q2.c<?>> set) {
        if (set.isEmpty()) {
            return this;
        }
        HashSet hashSet = new HashSet();
        synchronized (this.l) {
            for (d.a.l0.a.q2.c<?> cVar : set) {
                hashSet.addAll(i(cVar));
            }
        }
        d(hashSet, set);
        return this;
    }

    public final e d(Set<b> set, Set<d.a.l0.a.q2.c<?>> set2) {
        d.a.l0.a.r1.k.i.a.k().j(new a(this, set, set2));
        return this;
    }

    public e e(d.a.l0.a.q2.c<?>... cVarArr) {
        c(Sets.newHashSet(cVarArr));
        return this;
    }

    public e f(d.a.l0.a.q2.a aVar) {
        String aVar2 = aVar == null ? "" : aVar.toString();
        if (d.a.l0.a.q2.b.f47899a) {
            Log.i("Tracer-ErrCode", aVar2);
        }
        d.a.l0.a.e0.d.b("Tracer-ErrCode", aVar2);
        return this;
    }

    public e g(b bVar, d.a.l0.a.q2.c<?>... cVarArr) {
        if (bVar != null) {
            synchronized (this.l) {
                Set<d.a.l0.a.q2.c<?>> keySet = b(cVarArr) ? this.l.keySet() : Sets.newHashSet(cVarArr);
                for (d.a.l0.a.q2.c<?> cVar : keySet) {
                    if (cVar != null) {
                        i(cVar).add(bVar);
                    }
                }
                d(Sets.newHashSet(bVar), keySet);
            }
        }
        return this;
    }

    public e h(d.a.l0.a.q2.c<?>... cVarArr) {
        synchronized (this.l) {
            for (d.a.l0.a.q2.c<?> cVar : cVarArr) {
                if (!this.l.containsKey(cVar)) {
                    this.l.put(cVar, new HashSet());
                }
            }
        }
        return this;
    }

    public final Set<b> i(@NonNull d.a.l0.a.q2.c<?> cVar) {
        Set<b> set = this.l.get(cVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.l.put(cVar, hashSet);
            return hashSet;
        }
        return set;
    }

    public e j(b bVar, d.a.l0.a.q2.c<?>... cVarArr) {
        if (bVar != null) {
            synchronized (this.l) {
                for (d.a.l0.a.q2.c<?> cVar : b(cVarArr) ? this.l.keySet() : Sets.newHashSet(cVarArr)) {
                    if (cVar != null) {
                        i(cVar).remove(bVar);
                    }
                }
            }
        }
        return this;
    }
}

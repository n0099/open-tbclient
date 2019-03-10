package com.facebook.imagepipeline.c;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.imagepipeline.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class h<K, V> implements com.facebook.common.memory.b, t<K, V> {
    static final long jGa = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> jFX;
    @GuardedBy("this")
    final g<K, b<K, V>> jGb;
    @GuardedBy("this")
    final g<K, b<K, V>> jGc;
    private final a jGe;
    private final com.facebook.common.internal.i<u> jGf;
    @GuardedBy("this")
    protected u jGg;
    @GuardedBy("this")
    final Map<Bitmap, Object> jGd = new WeakHashMap();
    @GuardedBy("this")
    private long jGh = SystemClock.uptimeMillis();

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    public interface c<K> {
        void c(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b<K, V> {
        public final com.facebook.common.references.a<V> jGl;
        @Nullable
        public final c<K> jGn;
        public final K key;
        public int clientCount = 0;
        public boolean jGm = false;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.jGl = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.jGn = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.jFX = acVar;
        this.jGb = new g<>(a(acVar));
        this.jGc = new g<>(a(acVar));
        this.jGe = aVar;
        this.jGf = iVar;
        this.jGg = this.jGf.get();
        if (z) {
            fVar.a(new f.a() { // from class: com.facebook.imagepipeline.c.h.1
            });
        }
    }

    private ac<b<K, V>> a(final ac<V> acVar) {
        return new ac<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.ac
            /* renamed from: j */
            public int aT(b<K, V> bVar) {
                return acVar.aT(bVar.jGl.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        return a(k, aVar, null);
    }

    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar, c<K> cVar) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar2;
        com.facebook.common.references.a<V> aVar3;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.internal.g.checkNotNull(aVar);
        cwt();
        synchronized (this) {
            remove = this.jGb.remove(k);
            b<K, V> remove2 = this.jGc.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aW(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.jGc.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        cwu();
        return aVar3;
    }

    private synchronized boolean aW(V v) {
        boolean z;
        int aT = this.jFX.aT(v);
        if (aT <= this.jGg.jGB && cwv() <= this.jGg.jGy - 1) {
            z = cww() <= this.jGg.jGx - aT;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    @Nullable
    public com.facebook.common.references.a<V> aX(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.jGb.remove(k);
            b<K, V> bVar = this.jGc.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        cwt();
        cwu();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.jGl.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
            @Override // com.facebook.common.references.c
            public void release(V v) {
                h.this.b(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b<K, V> bVar) {
        boolean c2;
        com.facebook.common.references.a<V> i;
        com.facebook.common.internal.g.checkNotNull(bVar);
        synchronized (this) {
            h(bVar);
            c2 = c(bVar);
            i = i(bVar);
        }
        com.facebook.common.references.a.c(i);
        if (!c2) {
            bVar = null;
        }
        e(bVar);
        cwt();
        cwu();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.jGm || bVar.clientCount != 0) {
            z = false;
        } else {
            this.jGb.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.jGc.a(predicate).isEmpty();
    }

    private synchronized void cwt() {
        if (this.jGh + jGa <= SystemClock.uptimeMillis()) {
            this.jGh = SystemClock.uptimeMillis();
            this.jGg = this.jGf.get();
        }
    }

    private void cwu() {
        ArrayList<b<K, V>> cB;
        synchronized (this) {
            cB = cB(Math.min(this.jGg.jGA, this.jGg.jGy - cwv()), Math.min(this.jGg.jGz, this.jGg.jGx - cww()));
            aI(cB);
        }
        aG(cB);
        aH(cB);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> cB(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.jGb.getCount() <= max && this.jGb.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.jGb.getCount() <= max && this.jGb.getSizeInBytes() <= max2) {
                    break;
                }
                K cws = this.jGb.cws();
                this.jGb.remove(cws);
                arrayList.add(this.jGc.remove(cws));
            }
        }
        return arrayList;
    }

    private void aG(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void aH(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.jGn != null) {
            bVar.jGn.c(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.jGn != null) {
            bVar.jGn.c(bVar.key, true);
        }
    }

    private synchronized void aI(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
        }
    }

    private synchronized void f(b<K, V> bVar) {
        synchronized (this) {
            com.facebook.common.internal.g.checkNotNull(bVar);
            com.facebook.common.internal.g.checkState(bVar.jGm ? false : true);
            bVar.jGm = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.jGm);
        bVar.clientCount++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.clientCount > 0);
        bVar.clientCount--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.jGm && bVar.clientCount == 0) ? bVar.jGl : null;
    }

    public synchronized int cwv() {
        return this.jGc.getCount() - this.jGb.getCount();
    }

    public synchronized int cww() {
        return this.jGc.getSizeInBytes() - this.jGb.getSizeInBytes();
    }
}

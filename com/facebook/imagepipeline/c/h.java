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
    static final long jFn = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> jFk;
    @GuardedBy("this")
    final g<K, b<K, V>> jFo;
    @GuardedBy("this")
    final g<K, b<K, V>> jFp;
    private final a jFr;
    private final com.facebook.common.internal.i<u> jFs;
    @GuardedBy("this")
    protected u jFt;
    @GuardedBy("this")
    final Map<Bitmap, Object> jFq = new WeakHashMap();
    @GuardedBy("this")
    private long jFu = SystemClock.uptimeMillis();

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
        @Nullable
        public final c<K> jFA;
        public final com.facebook.common.references.a<V> jFy;
        public final K key;
        public int clientCount = 0;
        public boolean jFz = false;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.jFy = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.jFA = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.jFk = acVar;
        this.jFo = new g<>(a(acVar));
        this.jFp = new g<>(a(acVar));
        this.jFr = aVar;
        this.jFs = iVar;
        this.jFt = this.jFs.get();
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
            public int aP(b<K, V> bVar) {
                return acVar.aP(bVar.jFy.get());
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
        cwp();
        synchronized (this) {
            remove = this.jFo.remove(k);
            b<K, V> remove2 = this.jFp.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aS(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.jFp.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        cwq();
        return aVar3;
    }

    private synchronized boolean aS(V v) {
        boolean z;
        int aP = this.jFk.aP(v);
        if (aP <= this.jFt.jFO && cwr() <= this.jFt.jFL - 1) {
            z = cws() <= this.jFt.jFK - aP;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    @Nullable
    public com.facebook.common.references.a<V> aT(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.jFo.remove(k);
            b<K, V> bVar = this.jFp.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        cwp();
        cwq();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.jFy.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
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
        cwp();
        cwq();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.jFz || bVar.clientCount != 0) {
            z = false;
        } else {
            this.jFo.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.jFp.a(predicate).isEmpty();
    }

    private synchronized void cwp() {
        if (this.jFu + jFn <= SystemClock.uptimeMillis()) {
            this.jFu = SystemClock.uptimeMillis();
            this.jFt = this.jFs.get();
        }
    }

    private void cwq() {
        ArrayList<b<K, V>> cB;
        synchronized (this) {
            cB = cB(Math.min(this.jFt.jFN, this.jFt.jFL - cwr()), Math.min(this.jFt.jFM, this.jFt.jFK - cws()));
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
        if (this.jFo.getCount() <= max && this.jFo.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.jFo.getCount() <= max && this.jFo.getSizeInBytes() <= max2) {
                    break;
                }
                K cwo = this.jFo.cwo();
                this.jFo.remove(cwo);
                arrayList.add(this.jFp.remove(cwo));
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
        if (bVar != null && bVar.jFA != null) {
            bVar.jFA.c(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.jFA != null) {
            bVar.jFA.c(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.jFz ? false : true);
            bVar.jFz = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.jFz);
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
        return (bVar.jFz && bVar.clientCount == 0) ? bVar.jFy : null;
    }

    public synchronized int cwr() {
        return this.jFp.getCount() - this.jFo.getCount();
    }

    public synchronized int cws() {
        return this.jFp.getSizeInBytes() - this.jFo.getSizeInBytes();
    }
}

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
    static final long kgX = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> kgU;
    @GuardedBy("this")
    final g<K, b<K, V>> kgY;
    @GuardedBy("this")
    final g<K, b<K, V>> kgZ;
    private final a khb;
    private final com.facebook.common.internal.i<u> khc;
    @GuardedBy("this")
    protected u khd;
    @GuardedBy("this")
    final Map<Bitmap, Object> kha = new WeakHashMap();
    @GuardedBy("this")
    private long khe = SystemClock.uptimeMillis();

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> khi;
        public int khj = 0;
        public boolean khk = false;
        @Nullable
        public final c<K> khl;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.khi = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.khl = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.kgU = acVar;
        this.kgY = new g<>(a(acVar));
        this.kgZ = new g<>(a(acVar));
        this.khb = aVar;
        this.khc = iVar;
        this.khd = this.khc.get();
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
            public int aM(b<K, V> bVar) {
                return acVar.aM(bVar.khi.get());
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
        cFv();
        synchronized (this) {
            remove = this.kgY.remove(k);
            b<K, V> remove2 = this.kgZ.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aP((h<K, V>) aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.kgZ.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
        d(remove);
        cFw();
        return aVar3;
    }

    private synchronized boolean aP(V v) {
        boolean z;
        int aM = this.kgU.aM(v);
        if (aM <= this.khd.khA && cFx() <= this.khd.khx - 1) {
            z = cFy() <= this.khd.khw - aM;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    @Nullable
    public com.facebook.common.references.a<V> aQ(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.kgY.remove(k);
            b<K, V> bVar = this.kgZ.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        cFv();
        cFw();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.khi.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i);
        if (!c2) {
            bVar = null;
        }
        e(bVar);
        cFv();
        cFw();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.khk || bVar.khj != 0) {
            z = false;
        } else {
            this.kgY.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.kgZ.a(predicate).isEmpty();
    }

    private synchronized void cFv() {
        if (this.khe + kgX <= SystemClock.uptimeMillis()) {
            this.khe = SystemClock.uptimeMillis();
            this.khd = this.khc.get();
        }
    }

    private void cFw() {
        ArrayList<b<K, V>> cF;
        synchronized (this) {
            cF = cF(Math.min(this.khd.khz, this.khd.khx - cFx()), Math.min(this.khd.khy, this.khd.khw - cFy()));
            aQ((ArrayList) cF);
        }
        aO(cF);
        aP((ArrayList) cF);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> cF(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.kgY.getCount() <= max && this.kgY.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.kgY.getCount() <= max && this.kgY.getSizeInBytes() <= max2) {
                    break;
                }
                K cFu = this.kgY.cFu();
                this.kgY.remove(cFu);
                arrayList.add(this.kgZ.remove(cFu));
            }
        }
        return arrayList;
    }

    private void aO(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i(it.next()));
            }
        }
    }

    private void aP(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.khl != null) {
            bVar.khl.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.khl != null) {
            bVar.khl.d(bVar.key, true);
        }
    }

    private synchronized void aQ(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.khk ? false : true);
            bVar.khk = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.khk);
        bVar.khj++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.khj > 0);
        bVar.khj--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.khk && bVar.khj == 0) ? bVar.khi : null;
    }

    public synchronized int cFx() {
        return this.kgZ.getCount() - this.kgY.getCount();
    }

    public synchronized int cFy() {
        return this.kgZ.getSizeInBytes() - this.kgY.getSizeInBytes();
    }
}

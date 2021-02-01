package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long pHl = TimeUnit.MINUTES.toMillis(5);
    private final v<V> pHi;
    @GuardedBy("this")
    final g<K, b<K, V>> pHm;
    @GuardedBy("this")
    final g<K, b<K, V>> pHn;
    private final a pHp;
    private final com.facebook.common.internal.j<q> pHq;
    @GuardedBy("this")
    protected q pHr;
    @GuardedBy("this")
    final Map<Bitmap, Object> pHo = new WeakHashMap();
    @GuardedBy("this")
    private long pHs = SystemClock.uptimeMillis();

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface c<K> {
        void e(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> pHw;
        public int pHx = 0;
        public boolean pHy = false;
        @Nullable
        public final c<K> pHz;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.pHw = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.pHz = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.pHi = vVar;
        this.pHm = new g<>(a(vVar));
        this.pHn = new g<>(a(vVar));
        this.pHp = aVar;
        this.pHq = jVar;
        this.pHr = this.pHq.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.pHw.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        return a(k, aVar, null);
    }

    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar, c<K> cVar) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar2;
        com.facebook.common.references.a<V> aVar3;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.internal.g.checkNotNull(aVar);
        evK();
        synchronized (this) {
            remove = this.pHm.remove(k);
            b<K, V> remove2 = this.pHn.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.pHn.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        evL();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.pHi.bq(v);
        if (bq <= this.pHr.pHH && evM() <= this.pHr.pHE - 1) {
            z = evN() <= this.pHr.pHD - bq;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.b.p
    @Nullable
    public com.facebook.common.references.a<V> bu(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.pHm.remove(k);
            b<K, V> bVar = this.pHn.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        evK();
        evL();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.pHw.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.b.h.2
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
        evK();
        evL();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.pHy || bVar.pHx != 0) {
            z = false;
        } else {
            this.pHm.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bv(K k) {
        b<K, V> remove;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.references.a<V> aVar = null;
        synchronized (this) {
            remove = this.pHm.remove(k);
            if (remove != null) {
                b<K, V> remove2 = this.pHn.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.pHx == 0);
                com.facebook.common.references.a<V> aVar2 = remove2.pHw;
                z = true;
                aVar = aVar2;
            } else {
                z = false;
            }
        }
        if (z) {
            d(remove);
        }
        return aVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        ArrayList<b<K, V>> b2;
        ArrayList<b<K, V>> b3;
        synchronized (this) {
            b2 = this.pHm.b(hVar);
            b3 = this.pHn.b(hVar);
            bn(b3);
        }
        bl(b3);
        bm(b2);
        evK();
        evL();
        return b3.size();
    }

    @Override // com.facebook.imagepipeline.b.p
    public synchronized boolean d(com.facebook.common.internal.h<K> hVar) {
        return !this.pHn.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.pHn.contains(k);
    }

    private synchronized void evK() {
        if (this.pHs + pHl <= SystemClock.uptimeMillis()) {
            this.pHs = SystemClock.uptimeMillis();
            this.pHr = this.pHq.get();
        }
    }

    private void evL() {
        ArrayList<b<K, V>> dZ;
        synchronized (this) {
            dZ = dZ(Math.min(this.pHr.pHG, this.pHr.pHE - evM()), Math.min(this.pHr.pHF, this.pHr.pHD - evN()));
            bn(dZ);
        }
        bl(dZ);
        bm(dZ);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dZ(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.pHm.getCount() <= max && this.pHm.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.pHm.getCount() <= max && this.pHm.getSizeInBytes() <= max2) {
                    break;
                }
                K evJ = this.pHm.evJ();
                this.pHm.remove(evJ);
                arrayList.add(this.pHn.remove(evJ));
            }
        }
        return arrayList;
    }

    private void bl(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bm(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pHz != null) {
            bVar.pHz.e(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pHz != null) {
            bVar.pHz.e(bVar.key, true);
        }
    }

    private synchronized void bn(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.pHy ? false : true);
            bVar.pHy = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.pHy);
        bVar.pHx++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.pHx > 0);
        bVar.pHx--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.pHy && bVar.pHx == 0) ? bVar.pHw : null;
    }

    public synchronized int evM() {
        return this.pHn.getCount() - this.pHm.getCount();
    }

    public synchronized int evN() {
        return this.pHn.getSizeInBytes() - this.pHm.getSizeInBytes();
    }
}

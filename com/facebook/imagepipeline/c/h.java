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
    static final long kgp = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> kgm;
    @GuardedBy("this")
    final g<K, b<K, V>> kgq;
    @GuardedBy("this")
    final g<K, b<K, V>> kgr;
    private final a kgt;
    private final com.facebook.common.internal.i<u> kgu;
    @GuardedBy("this")
    protected u kgv;
    @GuardedBy("this")
    final Map<Bitmap, Object> kgs = new WeakHashMap();
    @GuardedBy("this")
    private long kgw = SystemClock.uptimeMillis();

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
        public final K key;
        public final com.facebook.common.references.a<V> kgA;
        public int kgB = 0;
        public boolean kgC = false;
        @Nullable
        public final c<K> kgD;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.kgA = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.kgD = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.kgm = acVar;
        this.kgq = new g<>(a(acVar));
        this.kgr = new g<>(a(acVar));
        this.kgt = aVar;
        this.kgu = iVar;
        this.kgv = this.kgu.get();
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
            public int aR(b<K, V> bVar) {
                return acVar.aR(bVar.kgA.get());
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
        cHK();
        synchronized (this) {
            remove = this.kgq.remove(k);
            b<K, V> remove2 = this.kgr.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aU(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.kgr.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        cHL();
        return aVar3;
    }

    private synchronized boolean aU(V v) {
        boolean z;
        int aR = this.kgm.aR(v);
        if (aR <= this.kgv.kgR && cHM() <= this.kgv.kgO - 1) {
            z = cHN() <= this.kgv.kgN - aR;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    @Nullable
    public com.facebook.common.references.a<V> aV(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.kgq.remove(k);
            b<K, V> bVar = this.kgr.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        cHK();
        cHL();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.kgA.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
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
        cHK();
        cHL();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.kgC || bVar.kgB != 0) {
            z = false;
        } else {
            this.kgq.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.kgr.a(predicate).isEmpty();
    }

    private synchronized void cHK() {
        if (this.kgw + kgp <= SystemClock.uptimeMillis()) {
            this.kgw = SystemClock.uptimeMillis();
            this.kgv = this.kgu.get();
        }
    }

    private void cHL() {
        ArrayList<b<K, V>> cN;
        synchronized (this) {
            cN = cN(Math.min(this.kgv.kgQ, this.kgv.kgO - cHM()), Math.min(this.kgv.kgP, this.kgv.kgN - cHN()));
            aM(cN);
        }
        aK(cN);
        aL(cN);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> cN(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.kgq.getCount() <= max && this.kgq.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.kgq.getCount() <= max && this.kgq.getSizeInBytes() <= max2) {
                    break;
                }
                K cHJ = this.kgq.cHJ();
                this.kgq.remove(cHJ);
                arrayList.add(this.kgr.remove(cHJ));
            }
        }
        return arrayList;
    }

    private void aK(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void aL(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.kgD != null) {
            bVar.kgD.c(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.kgD != null) {
            bVar.kgD.c(bVar.key, true);
        }
    }

    private synchronized void aM(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.kgC ? false : true);
            bVar.kgC = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.kgC);
        bVar.kgB++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.kgB > 0);
        bVar.kgB--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.kgC && bVar.kgB == 0) ? bVar.kgA : null;
    }

    public synchronized int cHM() {
        return this.kgr.getCount() - this.kgq.getCount();
    }

    public synchronized int cHN() {
        return this.kgr.getSizeInBytes() - this.kgq.getSizeInBytes();
    }
}

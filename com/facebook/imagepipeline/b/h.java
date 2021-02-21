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
    static final long pHL = TimeUnit.MINUTES.toMillis(5);
    private final v<V> pHI;
    @GuardedBy("this")
    final g<K, b<K, V>> pHM;
    @GuardedBy("this")
    final g<K, b<K, V>> pHN;
    private final a pHP;
    private final com.facebook.common.internal.j<q> pHQ;
    @GuardedBy("this")
    protected q pHR;
    @GuardedBy("this")
    final Map<Bitmap, Object> pHO = new WeakHashMap();
    @GuardedBy("this")
    private long pHS = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> pHW;
        public int pHX = 0;
        public boolean pHY = false;
        @Nullable
        public final c<K> pHZ;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.pHW = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.pHZ = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.pHI = vVar;
        this.pHM = new g<>(a(vVar));
        this.pHN = new g<>(a(vVar));
        this.pHP = aVar;
        this.pHQ = jVar;
        this.pHR = this.pHQ.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.pHW.get());
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
        evS();
        synchronized (this) {
            remove = this.pHM.remove(k);
            b<K, V> remove2 = this.pHN.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.pHN.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        evT();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.pHI.bq(v);
        if (bq <= this.pHR.pIh && evU() <= this.pHR.pIe - 1) {
            z = evV() <= this.pHR.pId - bq;
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
            remove = this.pHM.remove(k);
            b<K, V> bVar = this.pHN.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        evS();
        evT();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.pHW.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.b.h.2
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
        evS();
        evT();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.pHY || bVar.pHX != 0) {
            z = false;
        } else {
            this.pHM.put(bVar.key, bVar);
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
            remove = this.pHM.remove(k);
            if (remove != null) {
                b<K, V> remove2 = this.pHN.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.pHX == 0);
                com.facebook.common.references.a<V> aVar2 = remove2.pHW;
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
            b2 = this.pHM.b(hVar);
            b3 = this.pHN.b(hVar);
            bn(b3);
        }
        bl(b3);
        bm(b2);
        evS();
        evT();
        return b3.size();
    }

    @Override // com.facebook.imagepipeline.b.p
    public synchronized boolean d(com.facebook.common.internal.h<K> hVar) {
        return !this.pHN.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.pHN.contains(k);
    }

    private synchronized void evS() {
        if (this.pHS + pHL <= SystemClock.uptimeMillis()) {
            this.pHS = SystemClock.uptimeMillis();
            this.pHR = this.pHQ.get();
        }
    }

    private void evT() {
        ArrayList<b<K, V>> ea;
        synchronized (this) {
            ea = ea(Math.min(this.pHR.pIg, this.pHR.pIe - evU()), Math.min(this.pHR.pIf, this.pHR.pId - evV()));
            bn(ea);
        }
        bl(ea);
        bm(ea);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> ea(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.pHM.getCount() <= max && this.pHM.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.pHM.getCount() <= max && this.pHM.getSizeInBytes() <= max2) {
                    break;
                }
                K evR = this.pHM.evR();
                this.pHM.remove(evR);
                arrayList.add(this.pHN.remove(evR));
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
        if (bVar != null && bVar.pHZ != null) {
            bVar.pHZ.e(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pHZ != null) {
            bVar.pHZ.e(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.pHY ? false : true);
            bVar.pHY = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.pHY);
        bVar.pHX++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.pHX > 0);
        bVar.pHX--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.pHY && bVar.pHX == 0) ? bVar.pHW : null;
    }

    public synchronized int evU() {
        return this.pHN.getCount() - this.pHM.getCount();
    }

    public synchronized int evV() {
        return this.pHN.getSizeInBytes() - this.pHM.getSizeInBytes();
    }
}

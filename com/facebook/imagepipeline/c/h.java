package com.facebook.imagepipeline.c;

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
/* loaded from: classes11.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long lMv = TimeUnit.MINUTES.toMillis(5);
    private final com.facebook.common.internal.j<q> lMA;
    @GuardedBy("this")
    protected q lMB;
    private final v<V> lMs;
    @GuardedBy("this")
    final g<K, b<K, V>> lMw;
    @GuardedBy("this")
    final g<K, b<K, V>> lMx;
    private final a lMz;
    @GuardedBy("this")
    final Map<Bitmap, Object> lMy = new WeakHashMap();
    @GuardedBy("this")
    private long lMC = SystemClock.uptimeMillis();

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* loaded from: classes11.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> lMG;
        public int lMH = 0;
        public boolean lMI = false;
        @Nullable
        public final c<K> lMJ;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.lMG = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b((com.facebook.common.references.a) aVar));
            this.lMJ = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.lMs = vVar;
        this.lMw = new g<>(a(vVar));
        this.lMx = new g<>(a(vVar));
        this.lMz = aVar;
        this.lMA = jVar;
        this.lMB = this.lMA.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bg(b<K, V> bVar) {
                return vVar.bg(bVar.lMG.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.c.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        return a(k, aVar, null);
    }

    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar, c<K> cVar) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar2;
        com.facebook.common.references.a<V> aVar3;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.internal.g.checkNotNull(aVar);
        dlz();
        synchronized (this) {
            remove = this.lMw.remove(k);
            b<K, V> remove2 = this.lMx.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bj(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.lMx.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dlA();
        return aVar3;
    }

    private synchronized boolean bj(V v) {
        boolean z;
        int bg = this.lMs.bg(v);
        if (bg <= this.lMB.lMR && dlB() <= this.lMB.lMO - 1) {
            z = dlC() <= this.lMB.lMN - bg;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bk(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.lMw.remove(k);
            b<K, V> bVar = this.lMx.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dlz();
        dlA();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.lMG.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dlz();
        dlA();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.lMI || bVar.lMH != 0) {
            z = false;
        } else {
            this.lMw.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bl(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.lMw.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.lMx.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.lMH == 0);
                aVar = remove2.lMG;
                z = true;
            }
        }
        if (z) {
            d(remove);
        }
        return aVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public int c(com.facebook.common.internal.h<K> hVar) {
        ArrayList<b<K, V>> b2;
        ArrayList<b<K, V>> b3;
        synchronized (this) {
            b2 = this.lMw.b(hVar);
            b3 = this.lMx.b(hVar);
            bd(b3);
        }
        bb(b3);
        bc(b2);
        dlz();
        dlA();
        return b3.size();
    }

    @Override // com.facebook.imagepipeline.c.p
    public synchronized boolean d(com.facebook.common.internal.h<K> hVar) {
        return !this.lMx.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.lMx.contains(k);
    }

    private synchronized void dlz() {
        if (this.lMC + lMv <= SystemClock.uptimeMillis()) {
            this.lMC = SystemClock.uptimeMillis();
            this.lMB = this.lMA.get();
        }
    }

    private void dlA() {
        ArrayList<b<K, V>> dw;
        synchronized (this) {
            dw = dw(Math.min(this.lMB.lMQ, this.lMB.lMO - dlB()), Math.min(this.lMB.lMP, this.lMB.lMN - dlC()));
            bd(dw);
        }
        bb(dw);
        bc(dw);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dw(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.lMw.getCount() <= max && this.lMw.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.lMw.getCount() <= max && this.lMw.getSizeInBytes() <= max2) {
                    break;
                }
                K dly = this.lMw.dly();
                this.lMw.remove(dly);
                arrayList.add(this.lMx.remove(dly));
            }
        }
        return arrayList;
    }

    private void bb(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bc(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.lMJ != null) {
            bVar.lMJ.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.lMJ != null) {
            bVar.lMJ.d(bVar.key, true);
        }
    }

    private synchronized void bd(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.lMI ? false : true);
            bVar.lMI = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.lMI);
        bVar.lMH++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.lMH > 0);
        bVar.lMH--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.lMI && bVar.lMH == 0) ? bVar.lMG : null;
    }

    public synchronized int dlB() {
        return this.lMx.getCount() - this.lMw.getCount();
    }

    public synchronized int dlC() {
        return this.lMx.getSizeInBytes() - this.lMw.getSizeInBytes();
    }
}

package com.facebook.imagepipeline.c;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.common.memory.MemoryTrimType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long lQT = TimeUnit.MINUTES.toMillis(5);
    private final v<V> lQQ;
    @GuardedBy("this")
    final g<K, b<K, V>> lQU;
    @GuardedBy("this")
    final g<K, b<K, V>> lQV;
    private final a lQX;
    private final com.facebook.common.internal.j<q> lQY;
    @GuardedBy("this")
    protected q lQZ;
    @GuardedBy("this")
    final Map<Bitmap, Object> lQW = new WeakHashMap();
    @GuardedBy("this")
    private long lRa = SystemClock.uptimeMillis();

    /* loaded from: classes13.dex */
    public interface a {
        double b(MemoryTrimType memoryTrimType);
    }

    /* loaded from: classes13.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> lRe;
        public int lRf = 0;
        public boolean lRg = false;
        @Nullable
        public final c<K> lRh;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.lRe = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b((com.facebook.common.references.a) aVar));
            this.lRh = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.lQQ = vVar;
        this.lQU = new g<>(a(vVar));
        this.lQV = new g<>(a(vVar));
        this.lQX = aVar;
        this.lQY = jVar;
        this.lQZ = this.lQY.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bj(b<K, V> bVar) {
                return vVar.bj(bVar.lRe.get());
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
        dnT();
        synchronized (this) {
            remove = this.lQU.remove(k);
            b<K, V> remove2 = this.lQV.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bm(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.lQV.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dnU();
        return aVar3;
    }

    private synchronized boolean bm(V v) {
        boolean z;
        int bj = this.lQQ.bj(v);
        if (bj <= this.lQZ.lRp && dnV() <= this.lQZ.lRm - 1) {
            z = dnW() <= this.lQZ.lRl - bj;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bn(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.lQU.remove(k);
            b<K, V> bVar = this.lQV.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dnT();
        dnU();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.lRe.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dnT();
        dnU();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.lRg || bVar.lRf != 0) {
            z = false;
        } else {
            this.lQU.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bo(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.lQU.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.lQV.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.lRf == 0);
                aVar = remove2.lRe;
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
            b2 = this.lQU.b(hVar);
            b3 = this.lQV.b(hVar);
            bd(b3);
        }
        bb(b3);
        bc(b2);
        dnT();
        dnU();
        return b3.size();
    }

    @Override // com.facebook.imagepipeline.c.p
    public synchronized boolean d(com.facebook.common.internal.h<K> hVar) {
        return !this.lQV.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.lQV.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dx;
        double b2 = this.lQX.b(memoryTrimType);
        synchronized (this) {
            dx = dx(Integer.MAX_VALUE, Math.max(0, ((int) ((1.0d - b2) * this.lQV.getSizeInBytes())) - dnW()));
            bd(dx);
        }
        bb(dx);
        bc(dx);
        dnT();
        dnU();
    }

    private synchronized void dnT() {
        if (this.lRa + lQT <= SystemClock.uptimeMillis()) {
            this.lRa = SystemClock.uptimeMillis();
            this.lQZ = this.lQY.get();
        }
    }

    private void dnU() {
        ArrayList<b<K, V>> dx;
        synchronized (this) {
            dx = dx(Math.min(this.lQZ.lRo, this.lQZ.lRm - dnV()), Math.min(this.lQZ.lRn, this.lQZ.lRl - dnW()));
            bd(dx);
        }
        bb(dx);
        bc(dx);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dx(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.lQU.getCount() <= max && this.lQU.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.lQU.getCount() <= max && this.lQU.getSizeInBytes() <= max2) {
                    break;
                }
                K dnS = this.lQU.dnS();
                this.lQU.remove(dnS);
                arrayList.add(this.lQV.remove(dnS));
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
        if (bVar != null && bVar.lRh != null) {
            bVar.lRh.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.lRh != null) {
            bVar.lRh.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.lRg ? false : true);
            bVar.lRg = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.lRg);
        bVar.lRf++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.lRf > 0);
        bVar.lRf--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.lRg && bVar.lRf == 0) ? bVar.lRe : null;
    }

    public synchronized int dnV() {
        return this.lQV.getCount() - this.lQU.getCount();
    }

    public synchronized int dnW() {
        return this.lQV.getSizeInBytes() - this.lQU.getSizeInBytes();
    }
}

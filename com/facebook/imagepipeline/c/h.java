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
    static final long lSM = TimeUnit.MINUTES.toMillis(5);
    private final v<V> lSJ;
    @GuardedBy("this")
    final g<K, b<K, V>> lSN;
    @GuardedBy("this")
    final g<K, b<K, V>> lSO;
    private final a lSQ;
    private final com.facebook.common.internal.j<q> lSR;
    @GuardedBy("this")
    protected q lSS;
    @GuardedBy("this")
    final Map<Bitmap, Object> lSP = new WeakHashMap();
    @GuardedBy("this")
    private long lST = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> lSX;
        public int lSY = 0;
        public boolean lSZ = false;
        @Nullable
        public final c<K> lTa;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.lSX = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b((com.facebook.common.references.a) aVar));
            this.lTa = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.lSJ = vVar;
        this.lSN = new g<>(a(vVar));
        this.lSO = new g<>(a(vVar));
        this.lSQ = aVar;
        this.lSR = jVar;
        this.lSS = this.lSR.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bj(b<K, V> bVar) {
                return vVar.bj(bVar.lSX.get());
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
        dot();
        synchronized (this) {
            remove = this.lSN.remove(k);
            b<K, V> remove2 = this.lSO.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bm(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.lSO.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dou();
        return aVar3;
    }

    private synchronized boolean bm(V v) {
        boolean z;
        int bj = this.lSJ.bj(v);
        if (bj <= this.lSS.lTi && dov() <= this.lSS.lTf - 1) {
            z = dow() <= this.lSS.lTe - bj;
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
            remove = this.lSN.remove(k);
            b<K, V> bVar = this.lSO.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dot();
        dou();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.lSX.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dot();
        dou();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.lSZ || bVar.lSY != 0) {
            z = false;
        } else {
            this.lSN.put(bVar.key, bVar);
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
            remove = this.lSN.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.lSO.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.lSY == 0);
                aVar = remove2.lSX;
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
            b2 = this.lSN.b(hVar);
            b3 = this.lSO.b(hVar);
            bd(b3);
        }
        bb(b3);
        bc(b2);
        dot();
        dou();
        return b3.size();
    }

    @Override // com.facebook.imagepipeline.c.p
    public synchronized boolean d(com.facebook.common.internal.h<K> hVar) {
        return !this.lSO.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.lSO.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dy;
        double b2 = this.lSQ.b(memoryTrimType);
        synchronized (this) {
            dy = dy(Integer.MAX_VALUE, Math.max(0, ((int) ((1.0d - b2) * this.lSO.getSizeInBytes())) - dow()));
            bd(dy);
        }
        bb(dy);
        bc(dy);
        dot();
        dou();
    }

    private synchronized void dot() {
        if (this.lST + lSM <= SystemClock.uptimeMillis()) {
            this.lST = SystemClock.uptimeMillis();
            this.lSS = this.lSR.get();
        }
    }

    private void dou() {
        ArrayList<b<K, V>> dy;
        synchronized (this) {
            dy = dy(Math.min(this.lSS.lTh, this.lSS.lTf - dov()), Math.min(this.lSS.lTg, this.lSS.lTe - dow()));
            bd(dy);
        }
        bb(dy);
        bc(dy);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dy(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.lSN.getCount() <= max && this.lSN.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.lSN.getCount() <= max && this.lSN.getSizeInBytes() <= max2) {
                    break;
                }
                K dos = this.lSN.dos();
                this.lSN.remove(dos);
                arrayList.add(this.lSO.remove(dos));
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
        if (bVar != null && bVar.lTa != null) {
            bVar.lTa.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.lTa != null) {
            bVar.lTa.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.lSZ ? false : true);
            bVar.lSZ = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.lSZ);
        bVar.lSY++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.lSY > 0);
        bVar.lSY--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.lSZ && bVar.lSY == 0) ? bVar.lSX : null;
    }

    public synchronized int dov() {
        return this.lSO.getCount() - this.lSN.getCount();
    }

    public synchronized int dow() {
        return this.lSO.getSizeInBytes() - this.lSN.getSizeInBytes();
    }
}

package com.facebook.imagepipeline.c;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.v7.widget.ActivityChooserView;
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
/* loaded from: classes12.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long nDT = TimeUnit.MINUTES.toMillis(5);
    private final v<V> nDQ;
    @GuardedBy("this")
    final g<K, b<K, V>> nDU;
    @GuardedBy("this")
    final g<K, b<K, V>> nDV;
    private final a nDX;
    private final com.facebook.common.internal.j<q> nDY;
    @GuardedBy("this")
    protected q nDZ;
    @GuardedBy("this")
    final Map<Bitmap, Object> nDW = new WeakHashMap();
    @GuardedBy("this")
    private long nEa = SystemClock.uptimeMillis();

    /* loaded from: classes12.dex */
    public interface a {
        double b(MemoryTrimType memoryTrimType);
    }

    /* loaded from: classes12.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> nEe;
        public int nEf = 0;
        public boolean nEg = false;
        @Nullable
        public final c<K> nEh;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.nEe = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.nEh = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.nDQ = vVar;
        this.nDU = new g<>(a(vVar));
        this.nDV = new g<>(a(vVar));
        this.nDX = aVar;
        this.nDY = jVar;
        this.nDZ = this.nDY.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bj(b<K, V> bVar) {
                return vVar.bj(bVar.nEe.get());
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
        dVT();
        synchronized (this) {
            remove = this.nDU.remove(k);
            b<K, V> remove2 = this.nDV.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bm((h<K, V>) aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.nDV.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dVU();
        return aVar3;
    }

    private synchronized boolean bm(V v) {
        boolean z;
        int bj = this.nDQ.bj(v);
        if (bj <= this.nDZ.nEp && dVV() <= this.nDZ.nEm - 1) {
            z = dVW() <= this.nDZ.nEl - bj;
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
            remove = this.nDU.remove(k);
            b<K, V> bVar = this.nDV.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dVT();
        dVU();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.nEe.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dVT();
        dVU();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.nEg || bVar.nEf != 0) {
            z = false;
        } else {
            this.nDU.put(bVar.key, bVar);
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
            remove = this.nDU.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.nDV.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.nEf == 0);
                aVar = remove2.nEe;
                z = true;
            }
        }
        if (z) {
            d(remove);
        }
        return aVar;
    }

    @Override // com.facebook.imagepipeline.c.p
    public synchronized boolean b(com.facebook.common.internal.h<K> hVar) {
        return !this.nDV.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.nDV.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dK;
        double b2 = this.nDX.b(memoryTrimType);
        synchronized (this) {
            dK = dK(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.nDV.getSizeInBytes())) - dVW()));
            bm((ArrayList) dK);
        }
        bk(dK);
        bl(dK);
        dVT();
        dVU();
    }

    private synchronized void dVT() {
        if (this.nEa + nDT <= SystemClock.uptimeMillis()) {
            this.nEa = SystemClock.uptimeMillis();
            this.nDZ = this.nDY.get();
        }
    }

    private void dVU() {
        ArrayList<b<K, V>> dK;
        synchronized (this) {
            dK = dK(Math.min(this.nDZ.nEo, this.nDZ.nEm - dVV()), Math.min(this.nDZ.nEn, this.nDZ.nEl - dVW()));
            bm((ArrayList) dK);
        }
        bk(dK);
        bl(dK);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dK(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.nDU.getCount() <= max && this.nDU.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.nDU.getCount() <= max && this.nDU.getSizeInBytes() <= max2) {
                    break;
                }
                K dVS = this.nDU.dVS();
                this.nDU.remove(dVS);
                arrayList.add(this.nDV.remove(dVS));
            }
        }
        return arrayList;
    }

    private void bk(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bl(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.nEh != null) {
            bVar.nEh.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.nEh != null) {
            bVar.nEh.d(bVar.key, true);
        }
    }

    private synchronized void bm(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.nEg ? false : true);
            bVar.nEg = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.nEg);
        bVar.nEf++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.nEf > 0);
        bVar.nEf--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.nEg && bVar.nEf == 0) ? bVar.nEe : null;
    }

    public synchronized int dVV() {
        return this.nDV.getCount() - this.nDU.getCount();
    }

    public synchronized int dVW() {
        return this.nDV.getSizeInBytes() - this.nDU.getSizeInBytes();
    }
}

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
/* loaded from: classes13.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long mut = TimeUnit.MINUTES.toMillis(5);
    private final v<V> muq;
    @GuardedBy("this")
    final g<K, b<K, V>> muu;
    @GuardedBy("this")
    final g<K, b<K, V>> muv;
    private final a mux;
    private final com.facebook.common.internal.j<q> muy;
    @GuardedBy("this")
    protected q muz;
    @GuardedBy("this")
    final Map<Bitmap, Object> muw = new WeakHashMap();
    @GuardedBy("this")
    private long muA = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> muE;
        public int muF = 0;
        public boolean muG = false;
        @Nullable
        public final c<K> muH;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.muE = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.muH = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.muq = vVar;
        this.muu = new g<>(a(vVar));
        this.muv = new g<>(a(vVar));
        this.mux = aVar;
        this.muy = jVar;
        this.muz = this.muy.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int be(b<K, V> bVar) {
                return vVar.be(bVar.muE.get());
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
        dxG();
        synchronized (this) {
            remove = this.muu.remove(k);
            b<K, V> remove2 = this.muv.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bh(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.muv.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dxH();
        return aVar3;
    }

    private synchronized boolean bh(V v) {
        boolean z;
        int be = this.muq.be(v);
        if (be <= this.muz.muP && dxI() <= this.muz.muM - 1) {
            z = dxJ() <= this.muz.muL - be;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bi(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.muu.remove(k);
            b<K, V> bVar = this.muv.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dxG();
        dxH();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.muE.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dxG();
        dxH();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.muG || bVar.muF != 0) {
            z = false;
        } else {
            this.muu.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bj(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.muu.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.muv.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.muF == 0);
                aVar = remove2.muE;
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
        return !this.muv.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.muv.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dn;
        double b2 = this.mux.b(memoryTrimType);
        synchronized (this) {
            dn = dn(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.muv.getSizeInBytes())) - dxJ()));
            bc(dn);
        }
        ba(dn);
        bb(dn);
        dxG();
        dxH();
    }

    private synchronized void dxG() {
        if (this.muA + mut <= SystemClock.uptimeMillis()) {
            this.muA = SystemClock.uptimeMillis();
            this.muz = this.muy.get();
        }
    }

    private void dxH() {
        ArrayList<b<K, V>> dn;
        synchronized (this) {
            dn = dn(Math.min(this.muz.muO, this.muz.muM - dxI()), Math.min(this.muz.muN, this.muz.muL - dxJ()));
            bc(dn);
        }
        ba(dn);
        bb(dn);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dn(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.muu.getCount() <= max && this.muu.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.muu.getCount() <= max && this.muu.getSizeInBytes() <= max2) {
                    break;
                }
                K dxF = this.muu.dxF();
                this.muu.remove(dxF);
                arrayList.add(this.muv.remove(dxF));
            }
        }
        return arrayList;
    }

    private void ba(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bb(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.muH != null) {
            bVar.muH.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.muH != null) {
            bVar.muH.d(bVar.key, true);
        }
    }

    private synchronized void bc(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.muG ? false : true);
            bVar.muG = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.muG);
        bVar.muF++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.muF > 0);
        bVar.muF--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.muG && bVar.muF == 0) ? bVar.muE : null;
    }

    public synchronized int dxI() {
        return this.muv.getCount() - this.muu.getCount();
    }

    public synchronized int dxJ() {
        return this.muv.getSizeInBytes() - this.muu.getSizeInBytes();
    }
}

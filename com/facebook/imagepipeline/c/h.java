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
    static final long may = TimeUnit.MINUTES.toMillis(5);
    @GuardedBy("this")
    final g<K, b<K, V>> maA;
    private final a maC;
    private final com.facebook.common.internal.j<q> maD;
    @GuardedBy("this")
    protected q maE;
    private final v<V> mau;
    @GuardedBy("this")
    final g<K, b<K, V>> maz;
    @GuardedBy("this")
    final Map<Bitmap, Object> maB = new WeakHashMap();
    @GuardedBy("this")
    private long maF = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> maJ;
        public int maK = 0;
        public boolean maL = false;
        @Nullable
        public final c<K> maM;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.maJ = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.maM = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.mau = vVar;
        this.maz = new g<>(a(vVar));
        this.maA = new g<>(a(vVar));
        this.maC = aVar;
        this.maD = jVar;
        this.maE = this.maD.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int aZ(b<K, V> bVar) {
                return vVar.aZ(bVar.maJ.get());
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
        dqq();
        synchronized (this) {
            remove = this.maz.remove(k);
            b<K, V> remove2 = this.maA.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bc(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.maA.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
        d(remove);
        dqr();
        return aVar3;
    }

    private synchronized boolean bc(V v) {
        boolean z;
        int aZ = this.mau.aZ(v);
        if (aZ <= this.maE.maU && dqs() <= this.maE.maR - 1) {
            z = dqt() <= this.maE.maQ - aZ;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bd(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.maz.remove(k);
            b<K, V> bVar = this.maA.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dqq();
        dqr();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.maJ.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dqq();
        dqr();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.maL || bVar.maK != 0) {
            z = false;
        } else {
            this.maz.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> be(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.maz.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.maA.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.maK == 0);
                aVar = remove2.maJ;
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
        return !this.maA.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.maA.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> di;
        double b2 = this.maC.b(memoryTrimType);
        synchronized (this) {
            di = di(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.maA.getSizeInBytes())) - dqt()));
            bb(di);
        }
        aZ(di);
        ba(di);
        dqq();
        dqr();
    }

    private synchronized void dqq() {
        if (this.maF + may <= SystemClock.uptimeMillis()) {
            this.maF = SystemClock.uptimeMillis();
            this.maE = this.maD.get();
        }
    }

    private void dqr() {
        ArrayList<b<K, V>> di;
        synchronized (this) {
            di = di(Math.min(this.maE.maT, this.maE.maR - dqs()), Math.min(this.maE.maS, this.maE.maQ - dqt()));
            bb(di);
        }
        aZ(di);
        ba(di);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> di(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.maz.getCount() <= max && this.maz.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.maz.getCount() <= max && this.maz.getSizeInBytes() <= max2) {
                    break;
                }
                K dqp = this.maz.dqp();
                this.maz.remove(dqp);
                arrayList.add(this.maA.remove(dqp));
            }
        }
        return arrayList;
    }

    private void aZ(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i(it.next()));
            }
        }
    }

    private void ba(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.maM != null) {
            bVar.maM.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.maM != null) {
            bVar.maM.d(bVar.key, true);
        }
    }

    private synchronized void bb(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.maL ? false : true);
            bVar.maL = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.maL);
        bVar.maK++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.maK > 0);
        bVar.maK--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.maL && bVar.maK == 0) ? bVar.maJ : null;
    }

    public synchronized int dqs() {
        return this.maA.getCount() - this.maz.getCount();
    }

    public synchronized int dqt() {
        return this.maA.getSizeInBytes() - this.maz.getSizeInBytes();
    }
}

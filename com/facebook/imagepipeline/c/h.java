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
/* loaded from: classes3.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long mZO = TimeUnit.MINUTES.toMillis(5);
    private final v<V> mZL;
    @GuardedBy("this")
    final g<K, b<K, V>> mZP;
    @GuardedBy("this")
    final g<K, b<K, V>> mZQ;
    private final a mZS;
    private final com.facebook.common.internal.j<q> mZT;
    @GuardedBy("this")
    protected q mZU;
    @GuardedBy("this")
    final Map<Bitmap, Object> mZR = new WeakHashMap();
    @GuardedBy("this")
    private long mZV = SystemClock.uptimeMillis();

    /* loaded from: classes3.dex */
    public interface a {
        double b(MemoryTrimType memoryTrimType);
    }

    /* loaded from: classes3.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> mZZ;
        public int naa = 0;
        public boolean nab = false;
        @Nullable
        public final c<K> nac;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.mZZ = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.nac = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.mZL = vVar;
        this.mZP = new g<>(a(vVar));
        this.mZQ = new g<>(a(vVar));
        this.mZS = aVar;
        this.mZT = jVar;
        this.mZU = this.mZT.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bf(b<K, V> bVar) {
                return vVar.bf(bVar.mZZ.get());
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
        dFN();
        synchronized (this) {
            remove = this.mZP.remove(k);
            b<K, V> remove2 = this.mZQ.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bi(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.mZQ.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dFO();
        return aVar3;
    }

    private synchronized boolean bi(V v) {
        boolean z;
        int bf = this.mZL.bf(v);
        if (bf <= this.mZU.nak && dFP() <= this.mZU.nah - 1) {
            z = dFQ() <= this.mZU.nag - bf;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bj(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.mZP.remove(k);
            b<K, V> bVar = this.mZQ.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dFN();
        dFO();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.mZZ.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dFN();
        dFO();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.nab || bVar.naa != 0) {
            z = false;
        } else {
            this.mZP.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bk(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.mZP.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.mZQ.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.naa == 0);
                aVar = remove2.mZZ;
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
        return !this.mZQ.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.mZQ.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dy;
        double b2 = this.mZS.b(memoryTrimType);
        synchronized (this) {
            dy = dy(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.mZQ.getSizeInBytes())) - dFQ()));
            be(dy);
        }
        bc(dy);
        bd(dy);
        dFN();
        dFO();
    }

    private synchronized void dFN() {
        if (this.mZV + mZO <= SystemClock.uptimeMillis()) {
            this.mZV = SystemClock.uptimeMillis();
            this.mZU = this.mZT.get();
        }
    }

    private void dFO() {
        ArrayList<b<K, V>> dy;
        synchronized (this) {
            dy = dy(Math.min(this.mZU.naj, this.mZU.nah - dFP()), Math.min(this.mZU.nai, this.mZU.nag - dFQ()));
            be(dy);
        }
        bc(dy);
        bd(dy);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dy(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.mZP.getCount() <= max && this.mZP.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.mZP.getCount() <= max && this.mZP.getSizeInBytes() <= max2) {
                    break;
                }
                K dFM = this.mZP.dFM();
                this.mZP.remove(dFM);
                arrayList.add(this.mZQ.remove(dFM));
            }
        }
        return arrayList;
    }

    private void bc(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bd(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.nac != null) {
            bVar.nac.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.nac != null) {
            bVar.nac.d(bVar.key, true);
        }
    }

    private synchronized void be(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.nab ? false : true);
            bVar.nab = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.nab);
        bVar.naa++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.naa > 0);
        bVar.naa--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.nab && bVar.naa == 0) ? bVar.mZZ : null;
    }

    public synchronized int dFP() {
        return this.mZQ.getCount() - this.mZP.getCount();
    }

    public synchronized int dFQ() {
        return this.mZQ.getSizeInBytes() - this.mZP.getSizeInBytes();
    }
}

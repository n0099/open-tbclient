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
    static final long oKE = TimeUnit.MINUTES.toMillis(5);
    private final v<V> oKB;
    @GuardedBy("this")
    final g<K, b<K, V>> oKF;
    @GuardedBy("this")
    final g<K, b<K, V>> oKG;
    private final a oKI;
    private final com.facebook.common.internal.j<q> oKJ;
    @GuardedBy("this")
    protected q oKK;
    @GuardedBy("this")
    final Map<Bitmap, Object> oKH = new WeakHashMap();
    @GuardedBy("this")
    private long oKL = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> oKP;
        public int oKQ = 0;
        public boolean oKR = false;
        @Nullable
        public final c<K> oKS;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.oKP = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.oKS = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.oKB = vVar;
        this.oKF = new g<>(a(vVar));
        this.oKG = new g<>(a(vVar));
        this.oKI = aVar;
        this.oKJ = jVar;
        this.oKK = this.oKJ.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.oKP.get());
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
        ejC();
        synchronized (this) {
            remove = this.oKF.remove(k);
            b<K, V> remove2 = this.oKG.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.oKG.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        ejD();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.oKB.bq(v);
        if (bq <= this.oKK.oLa && ejE() <= this.oKK.oKX - 1) {
            z = ejF() <= this.oKK.oKW - bq;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bu(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.oKF.remove(k);
            b<K, V> bVar = this.oKG.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        ejC();
        ejD();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.oKP.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        ejC();
        ejD();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.oKR || bVar.oKQ != 0) {
            z = false;
        } else {
            this.oKF.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bv(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.oKF.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.oKG.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.oKQ == 0);
                aVar = remove2.oKP;
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
        return !this.oKG.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.oKG.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dT;
        double b2 = this.oKI.b(memoryTrimType);
        synchronized (this) {
            dT = dT(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.oKG.getSizeInBytes())) - ejF()));
            bq(dT);
        }
        bo(dT);
        bp(dT);
        ejC();
        ejD();
    }

    private synchronized void ejC() {
        if (this.oKL + oKE <= SystemClock.uptimeMillis()) {
            this.oKL = SystemClock.uptimeMillis();
            this.oKK = this.oKJ.get();
        }
    }

    private void ejD() {
        ArrayList<b<K, V>> dT;
        synchronized (this) {
            dT = dT(Math.min(this.oKK.oKZ, this.oKK.oKX - ejE()), Math.min(this.oKK.oKY, this.oKK.oKW - ejF()));
            bq(dT);
        }
        bo(dT);
        bp(dT);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dT(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.oKF.getCount() <= max && this.oKF.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.oKF.getCount() <= max && this.oKF.getSizeInBytes() <= max2) {
                    break;
                }
                K ejB = this.oKF.ejB();
                this.oKF.remove(ejB);
                arrayList.add(this.oKG.remove(ejB));
            }
        }
        return arrayList;
    }

    private void bo(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bp(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.oKS != null) {
            bVar.oKS.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.oKS != null) {
            bVar.oKS.d(bVar.key, true);
        }
    }

    private synchronized void bq(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.oKR ? false : true);
            bVar.oKR = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.oKR);
        bVar.oKQ++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.oKQ > 0);
        bVar.oKQ--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.oKR && bVar.oKQ == 0) ? bVar.oKP : null;
    }

    public synchronized int ejE() {
        return this.oKG.getCount() - this.oKF.getCount();
    }

    public synchronized int ejF() {
        return this.oKG.getSizeInBytes() - this.oKF.getSizeInBytes();
    }
}

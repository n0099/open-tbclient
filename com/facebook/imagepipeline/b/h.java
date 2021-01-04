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
/* loaded from: classes6.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long pzW = TimeUnit.MINUTES.toMillis(5);
    private final a pAa;
    private final com.facebook.common.internal.j<q> pAb;
    @GuardedBy("this")
    protected q pAc;
    private final v<V> pzT;
    @GuardedBy("this")
    final g<K, b<K, V>> pzX;
    @GuardedBy("this")
    final g<K, b<K, V>> pzY;
    @GuardedBy("this")
    final Map<Bitmap, Object> pzZ = new WeakHashMap();
    @GuardedBy("this")
    private long pAd = SystemClock.uptimeMillis();

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* loaded from: classes6.dex */
    public interface c<K> {
        void e(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> pAh;
        public int pAi = 0;
        public boolean pAj = false;
        @Nullable
        public final c<K> pAk;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.pAh = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.pAk = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.pzT = vVar;
        this.pzX = new g<>(a(vVar));
        this.pzY = new g<>(a(vVar));
        this.pAa = aVar;
        this.pAb = jVar;
        this.pAc = this.pAb.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.pAh.get());
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
        ewI();
        synchronized (this) {
            remove = this.pzX.remove(k);
            b<K, V> remove2 = this.pzY.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt((h<K, V>) aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.pzY.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        ewJ();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.pzT.bq(v);
        if (bq <= this.pAc.pAs && ewK() <= this.pAc.pAp - 1) {
            z = ewL() <= this.pAc.pAo - bq;
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
            remove = this.pzX.remove(k);
            b<K, V> bVar = this.pzY.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        ewI();
        ewJ();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.pAh.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.b.h.2
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
        ewI();
        ewJ();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.pAj || bVar.pAi != 0) {
            z = false;
        } else {
            this.pzX.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.b.p
    public synchronized boolean b(com.facebook.common.internal.h<K> hVar) {
        return !this.pzY.a(hVar).isEmpty();
    }

    private synchronized void ewI() {
        if (this.pAd + pzW <= SystemClock.uptimeMillis()) {
            this.pAd = SystemClock.uptimeMillis();
            this.pAc = this.pAb.get();
        }
    }

    private void ewJ() {
        ArrayList<b<K, V>> ea;
        synchronized (this) {
            ea = ea(Math.min(this.pAc.pAr, this.pAc.pAp - ewK()), Math.min(this.pAc.pAq, this.pAc.pAo - ewL()));
            bt((ArrayList) ea);
        }
        br(ea);
        bs(ea);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> ea(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.pzX.getCount() <= max && this.pzX.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.pzX.getCount() <= max && this.pzX.getSizeInBytes() <= max2) {
                    break;
                }
                K ewH = this.pzX.ewH();
                this.pzX.remove(ewH);
                arrayList.add(this.pzY.remove(ewH));
            }
        }
        return arrayList;
    }

    private void br(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bs(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pAk != null) {
            bVar.pAk.e(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pAk != null) {
            bVar.pAk.e(bVar.key, true);
        }
    }

    private synchronized void bt(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.pAj ? false : true);
            bVar.pAj = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.pAj);
        bVar.pAi++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.pAi > 0);
        bVar.pAi--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.pAj && bVar.pAi == 0) ? bVar.pAh : null;
    }

    public synchronized int ewK() {
        return this.pzY.getCount() - this.pzX.getCount();
    }

    public synchronized int ewL() {
        return this.pzY.getSizeInBytes() - this.pzX.getSizeInBytes();
    }
}

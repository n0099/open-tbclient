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
/* loaded from: classes7.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long pkq = TimeUnit.MINUTES.toMillis(5);
    private final v<V> pkn;
    @GuardedBy("this")
    final g<K, b<K, V>> pkr;
    @GuardedBy("this")
    final g<K, b<K, V>> pks;
    private final a pku;
    private final com.facebook.common.internal.j<q> pkv;
    @GuardedBy("this")
    protected q pkw;
    @GuardedBy("this")
    final Map<Bitmap, Object> pkt = new WeakHashMap();
    @GuardedBy("this")
    private long pkx = SystemClock.uptimeMillis();

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* loaded from: classes7.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> pkB;
        public int pkC = 0;
        public boolean pkD = false;
        @Nullable
        public final c<K> pkE;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.pkB = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.pkE = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.pkn = vVar;
        this.pkr = new g<>(a(vVar));
        this.pks = new g<>(a(vVar));
        this.pku = aVar;
        this.pkv = jVar;
        this.pkw = this.pkv.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.pkB.get());
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
        esY();
        synchronized (this) {
            remove = this.pkr.remove(k);
            b<K, V> remove2 = this.pks.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt((h<K, V>) aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.pks.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        esZ();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.pkn.bq(v);
        if (bq <= this.pkw.pkM && eta() <= this.pkw.pkJ - 1) {
            z = etb() <= this.pkw.pkI - bq;
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
            remove = this.pkr.remove(k);
            b<K, V> bVar = this.pks.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        esY();
        esZ();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.pkB.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.b.h.2
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
        esY();
        esZ();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.pkD || bVar.pkC != 0) {
            z = false;
        } else {
            this.pkr.put(bVar.key, bVar);
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
            remove = this.pkr.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.pks.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.pkC == 0);
                aVar = remove2.pkB;
                z = true;
            }
        }
        if (z) {
            d(remove);
        }
        return aVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public synchronized boolean b(com.facebook.common.internal.h<K> hVar) {
        return !this.pks.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.pks.contains(k);
    }

    private synchronized void esY() {
        if (this.pkx + pkq <= SystemClock.uptimeMillis()) {
            this.pkx = SystemClock.uptimeMillis();
            this.pkw = this.pkv.get();
        }
    }

    private void esZ() {
        ArrayList<b<K, V>> ec;
        synchronized (this) {
            ec = ec(Math.min(this.pkw.pkL, this.pkw.pkJ - eta()), Math.min(this.pkw.pkK, this.pkw.pkI - etb()));
            bt((ArrayList) ec);
        }
        br(ec);
        bs(ec);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> ec(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.pkr.getCount() <= max && this.pkr.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.pkr.getCount() <= max && this.pkr.getSizeInBytes() <= max2) {
                    break;
                }
                K esX = this.pkr.esX();
                this.pkr.remove(esX);
                arrayList.add(this.pks.remove(esX));
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
        if (bVar != null && bVar.pkE != null) {
            bVar.pkE.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pkE != null) {
            bVar.pkE.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.pkD ? false : true);
            bVar.pkD = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.pkD);
        bVar.pkC++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.pkC > 0);
        bVar.pkC--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.pkD && bVar.pkC == 0) ? bVar.pkB : null;
    }

    public synchronized int eta() {
        return this.pks.getCount() - this.pkr.getCount();
    }

    public synchronized int etb() {
        return this.pks.getSizeInBytes() - this.pkr.getSizeInBytes();
    }
}

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
    static final long pks = TimeUnit.MINUTES.toMillis(5);
    private final v<V> pkp;
    @GuardedBy("this")
    final g<K, b<K, V>> pkt;
    @GuardedBy("this")
    final g<K, b<K, V>> pku;
    private final a pkw;
    private final com.facebook.common.internal.j<q> pkx;
    @GuardedBy("this")
    protected q pky;
    @GuardedBy("this")
    final Map<Bitmap, Object> pkv = new WeakHashMap();
    @GuardedBy("this")
    private long pkz = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> pkD;
        public int pkE = 0;
        public boolean pkF = false;
        @Nullable
        public final c<K> pkG;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.pkD = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.pkG = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.pkp = vVar;
        this.pkt = new g<>(a(vVar));
        this.pku = new g<>(a(vVar));
        this.pkw = aVar;
        this.pkx = jVar;
        this.pky = this.pkx.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.pkD.get());
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
        esZ();
        synchronized (this) {
            remove = this.pkt.remove(k);
            b<K, V> remove2 = this.pku.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt((h<K, V>) aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.pku.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        eta();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.pkp.bq(v);
        if (bq <= this.pky.pkO && etb() <= this.pky.pkL - 1) {
            z = etc() <= this.pky.pkK - bq;
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
            remove = this.pkt.remove(k);
            b<K, V> bVar = this.pku.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        esZ();
        eta();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.pkD.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.b.h.2
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
        esZ();
        eta();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.pkF || bVar.pkE != 0) {
            z = false;
        } else {
            this.pkt.put(bVar.key, bVar);
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
            remove = this.pkt.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.pku.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.pkE == 0);
                aVar = remove2.pkD;
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
        return !this.pku.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.pku.contains(k);
    }

    private synchronized void esZ() {
        if (this.pkz + pks <= SystemClock.uptimeMillis()) {
            this.pkz = SystemClock.uptimeMillis();
            this.pky = this.pkx.get();
        }
    }

    private void eta() {
        ArrayList<b<K, V>> ec;
        synchronized (this) {
            ec = ec(Math.min(this.pky.pkN, this.pky.pkL - etb()), Math.min(this.pky.pkM, this.pky.pkK - etc()));
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
        if (this.pkt.getCount() <= max && this.pkt.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.pkt.getCount() <= max && this.pkt.getSizeInBytes() <= max2) {
                    break;
                }
                K esY = this.pkt.esY();
                this.pkt.remove(esY);
                arrayList.add(this.pku.remove(esY));
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
        if (bVar != null && bVar.pkG != null) {
            bVar.pkG.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pkG != null) {
            bVar.pkG.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.pkF ? false : true);
            bVar.pkF = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.pkF);
        bVar.pkE++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.pkE > 0);
        bVar.pkE--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.pkF && bVar.pkE == 0) ? bVar.pkD : null;
    }

    public synchronized int etb() {
        return this.pku.getCount() - this.pkt.getCount();
    }

    public synchronized int etc() {
        return this.pku.getSizeInBytes() - this.pkt.getSizeInBytes();
    }
}

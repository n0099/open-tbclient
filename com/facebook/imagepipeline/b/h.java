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
/* loaded from: classes5.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long pxc = TimeUnit.MINUTES.toMillis(5);
    private final v<V> pwZ;
    @GuardedBy("this")
    final g<K, b<K, V>> pxd;
    @GuardedBy("this")
    final g<K, b<K, V>> pxe;
    private final a pxg;
    private final com.facebook.common.internal.j<q> pxh;
    @GuardedBy("this")
    protected q pxi;
    @GuardedBy("this")
    final Map<Bitmap, Object> pxf = new WeakHashMap();
    @GuardedBy("this")
    private long pxj = SystemClock.uptimeMillis();

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface c<K> {
        void e(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> pxn;
        public int pxo = 0;
        public boolean pxp = false;
        @Nullable
        public final c<K> pxq;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.pxn = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.pxq = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.pwZ = vVar;
        this.pxd = new g<>(a(vVar));
        this.pxe = new g<>(a(vVar));
        this.pxg = aVar;
        this.pxh = jVar;
        this.pxi = this.pxh.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.pxn.get());
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
        ets();
        synchronized (this) {
            remove = this.pxd.remove(k);
            b<K, V> remove2 = this.pxe.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.pxe.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        ett();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.pwZ.bq(v);
        if (bq <= this.pxi.pxy && etu() <= this.pxi.pxv - 1) {
            z = etv() <= this.pxi.pxu - bq;
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
            remove = this.pxd.remove(k);
            b<K, V> bVar = this.pxe.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        ets();
        ett();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.pxn.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.b.h.2
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
        ets();
        ett();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.pxp || bVar.pxo != 0) {
            z = false;
        } else {
            this.pxd.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bv(K k) {
        b<K, V> remove;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.references.a<V> aVar = null;
        synchronized (this) {
            remove = this.pxd.remove(k);
            if (remove != null) {
                b<K, V> remove2 = this.pxe.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.pxo == 0);
                com.facebook.common.references.a<V> aVar2 = remove2.pxn;
                z = true;
                aVar = aVar2;
            } else {
                z = false;
            }
        }
        if (z) {
            d(remove);
        }
        return aVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public synchronized boolean b(com.facebook.common.internal.h<K> hVar) {
        return !this.pxe.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.pxe.contains(k);
    }

    private synchronized void ets() {
        if (this.pxj + pxc <= SystemClock.uptimeMillis()) {
            this.pxj = SystemClock.uptimeMillis();
            this.pxi = this.pxh.get();
        }
    }

    private void ett() {
        ArrayList<b<K, V>> ec;
        synchronized (this) {
            ec = ec(Math.min(this.pxi.pxx, this.pxi.pxv - etu()), Math.min(this.pxi.pxw, this.pxi.pxu - etv()));
            bo(ec);
        }
        bm(ec);
        bn(ec);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> ec(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.pxd.getCount() <= max && this.pxd.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.pxd.getCount() <= max && this.pxd.getSizeInBytes() <= max2) {
                    break;
                }
                K etr = this.pxd.etr();
                this.pxd.remove(etr);
                arrayList.add(this.pxe.remove(etr));
            }
        }
        return arrayList;
    }

    private void bm(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bn(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pxq != null) {
            bVar.pxq.e(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pxq != null) {
            bVar.pxq.e(bVar.key, true);
        }
    }

    private synchronized void bo(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.pxp ? false : true);
            bVar.pxp = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.pxp);
        bVar.pxo++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.pxo > 0);
        bVar.pxo--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.pxp && bVar.pxo == 0) ? bVar.pxn : null;
    }

    public synchronized int etu() {
        return this.pxe.getCount() - this.pxd.getCount();
    }

    public synchronized int etv() {
        return this.pxe.getSizeInBytes() - this.pxd.getSizeInBytes();
    }
}

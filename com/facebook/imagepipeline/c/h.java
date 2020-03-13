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
    static final long lRg = TimeUnit.MINUTES.toMillis(5);
    private final v<V> lRd;
    @GuardedBy("this")
    final g<K, b<K, V>> lRh;
    @GuardedBy("this")
    final g<K, b<K, V>> lRi;
    private final a lRk;
    private final com.facebook.common.internal.j<q> lRl;
    @GuardedBy("this")
    protected q lRm;
    @GuardedBy("this")
    final Map<Bitmap, Object> lRj = new WeakHashMap();
    @GuardedBy("this")
    private long lRn = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> lRr;
        public int lRs = 0;
        public boolean lRt = false;
        @Nullable
        public final c<K> lRu;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.lRr = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b((com.facebook.common.references.a) aVar));
            this.lRu = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.lRd = vVar;
        this.lRh = new g<>(a(vVar));
        this.lRi = new g<>(a(vVar));
        this.lRk = aVar;
        this.lRl = jVar;
        this.lRm = this.lRl.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bj(b<K, V> bVar) {
                return vVar.bj(bVar.lRr.get());
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
        dnW();
        synchronized (this) {
            remove = this.lRh.remove(k);
            b<K, V> remove2 = this.lRi.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bm(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.lRi.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dnX();
        return aVar3;
    }

    private synchronized boolean bm(V v) {
        boolean z;
        int bj = this.lRd.bj(v);
        if (bj <= this.lRm.lRC && dnY() <= this.lRm.lRz - 1) {
            z = dnZ() <= this.lRm.lRy - bj;
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
            remove = this.lRh.remove(k);
            b<K, V> bVar = this.lRi.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dnW();
        dnX();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.lRr.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dnW();
        dnX();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.lRt || bVar.lRs != 0) {
            z = false;
        } else {
            this.lRh.put(bVar.key, bVar);
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
            remove = this.lRh.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.lRi.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.lRs == 0);
                aVar = remove2.lRr;
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
            b2 = this.lRh.b(hVar);
            b3 = this.lRi.b(hVar);
            bd(b3);
        }
        bb(b3);
        bc(b2);
        dnW();
        dnX();
        return b3.size();
    }

    @Override // com.facebook.imagepipeline.c.p
    public synchronized boolean d(com.facebook.common.internal.h<K> hVar) {
        return !this.lRi.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.lRi.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dx;
        double b2 = this.lRk.b(memoryTrimType);
        synchronized (this) {
            dx = dx(Integer.MAX_VALUE, Math.max(0, ((int) ((1.0d - b2) * this.lRi.getSizeInBytes())) - dnZ()));
            bd(dx);
        }
        bb(dx);
        bc(dx);
        dnW();
        dnX();
    }

    private synchronized void dnW() {
        if (this.lRn + lRg <= SystemClock.uptimeMillis()) {
            this.lRn = SystemClock.uptimeMillis();
            this.lRm = this.lRl.get();
        }
    }

    private void dnX() {
        ArrayList<b<K, V>> dx;
        synchronized (this) {
            dx = dx(Math.min(this.lRm.lRB, this.lRm.lRz - dnY()), Math.min(this.lRm.lRA, this.lRm.lRy - dnZ()));
            bd(dx);
        }
        bb(dx);
        bc(dx);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dx(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.lRh.getCount() <= max && this.lRh.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.lRh.getCount() <= max && this.lRh.getSizeInBytes() <= max2) {
                    break;
                }
                K dnV = this.lRh.dnV();
                this.lRh.remove(dnV);
                arrayList.add(this.lRi.remove(dnV));
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
        if (bVar != null && bVar.lRu != null) {
            bVar.lRu.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.lRu != null) {
            bVar.lRu.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.lRt ? false : true);
            bVar.lRt = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.lRt);
        bVar.lRs++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.lRs > 0);
        bVar.lRs--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.lRt && bVar.lRs == 0) ? bVar.lRr : null;
    }

    public synchronized int dnY() {
        return this.lRi.getCount() - this.lRh.getCount();
    }

    public synchronized int dnZ() {
        return this.lRi.getSizeInBytes() - this.lRh.getSizeInBytes();
    }
}

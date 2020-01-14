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
/* loaded from: classes12.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long lQm = TimeUnit.MINUTES.toMillis(5);
    private final v<V> lQj;
    @GuardedBy("this")
    final g<K, b<K, V>> lQn;
    @GuardedBy("this")
    final g<K, b<K, V>> lQo;
    private final a lQq;
    private final com.facebook.common.internal.j<q> lQr;
    @GuardedBy("this")
    protected q lQs;
    @GuardedBy("this")
    final Map<Bitmap, Object> lQp = new WeakHashMap();
    @GuardedBy("this")
    private long lQt = SystemClock.uptimeMillis();

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
        @Nullable
        public final c<K> lQA;
        public final com.facebook.common.references.a<V> lQx;
        public int lQy = 0;
        public boolean lQz = false;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.lQx = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b((com.facebook.common.references.a) aVar));
            this.lQA = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.lQj = vVar;
        this.lQn = new g<>(a(vVar));
        this.lQo = new g<>(a(vVar));
        this.lQq = aVar;
        this.lQr = jVar;
        this.lQs = this.lQr.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bh(b<K, V> bVar) {
                return vVar.bh(bVar.lQx.get());
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
        dmG();
        synchronized (this) {
            remove = this.lQn.remove(k);
            b<K, V> remove2 = this.lQo.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bk(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.lQo.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dmH();
        return aVar3;
    }

    private synchronized boolean bk(V v) {
        boolean z;
        int bh = this.lQj.bh(v);
        if (bh <= this.lQs.lQI && dmI() <= this.lQs.lQF - 1) {
            z = dmJ() <= this.lQs.lQE - bh;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bl(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.lQn.remove(k);
            b<K, V> bVar = this.lQo.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dmG();
        dmH();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.lQx.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dmG();
        dmH();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.lQz || bVar.lQy != 0) {
            z = false;
        } else {
            this.lQn.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bm(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.lQn.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.lQo.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.lQy == 0);
                aVar = remove2.lQx;
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
            b2 = this.lQn.b(hVar);
            b3 = this.lQo.b(hVar);
            be(b3);
        }
        bc(b3);
        bd(b2);
        dmG();
        dmH();
        return b3.size();
    }

    @Override // com.facebook.imagepipeline.c.p
    public synchronized boolean d(com.facebook.common.internal.h<K> hVar) {
        return !this.lQo.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.lQo.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> du;
        double b2 = this.lQq.b(memoryTrimType);
        synchronized (this) {
            du = du(Integer.MAX_VALUE, Math.max(0, ((int) ((1.0d - b2) * this.lQo.getSizeInBytes())) - dmJ()));
            be(du);
        }
        bc(du);
        bd(du);
        dmG();
        dmH();
    }

    private synchronized void dmG() {
        if (this.lQt + lQm <= SystemClock.uptimeMillis()) {
            this.lQt = SystemClock.uptimeMillis();
            this.lQs = this.lQr.get();
        }
    }

    private void dmH() {
        ArrayList<b<K, V>> du;
        synchronized (this) {
            du = du(Math.min(this.lQs.lQH, this.lQs.lQF - dmI()), Math.min(this.lQs.lQG, this.lQs.lQE - dmJ()));
            be(du);
        }
        bc(du);
        bd(du);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> du(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.lQn.getCount() <= max && this.lQn.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.lQn.getCount() <= max && this.lQn.getSizeInBytes() <= max2) {
                    break;
                }
                K dmF = this.lQn.dmF();
                this.lQn.remove(dmF);
                arrayList.add(this.lQo.remove(dmF));
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
        if (bVar != null && bVar.lQA != null) {
            bVar.lQA.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.lQA != null) {
            bVar.lQA.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.lQz ? false : true);
            bVar.lQz = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.lQz);
        bVar.lQy++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.lQy > 0);
        bVar.lQy--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.lQz && bVar.lQy == 0) ? bVar.lQx : null;
    }

    public synchronized int dmI() {
        return this.lQo.getCount() - this.lQn.getCount();
    }

    public synchronized int dmJ() {
        return this.lQo.getSizeInBytes() - this.lQn.getSizeInBytes();
    }
}

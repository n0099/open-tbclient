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
    static final long oTX = TimeUnit.MINUTES.toMillis(5);
    private final v<V> oTU;
    @GuardedBy("this")
    final g<K, b<K, V>> oTY;
    @GuardedBy("this")
    final g<K, b<K, V>> oTZ;
    private final a oUb;
    private final com.facebook.common.internal.j<q> oUc;
    @GuardedBy("this")
    protected q oUd;
    @GuardedBy("this")
    final Map<Bitmap, Object> oUa = new WeakHashMap();
    @GuardedBy("this")
    private long oUe = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> oUi;
        public int oUj = 0;
        public boolean oUk = false;
        @Nullable
        public final c<K> oUl;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.oUi = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.oUl = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.oTU = vVar;
        this.oTY = new g<>(a(vVar));
        this.oTZ = new g<>(a(vVar));
        this.oUb = aVar;
        this.oUc = jVar;
        this.oUd = this.oUc.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.oUi.get());
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
        ens();
        synchronized (this) {
            remove = this.oTY.remove(k);
            b<K, V> remove2 = this.oTZ.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.oTZ.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        ent();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.oTU.bq(v);
        if (bq <= this.oUd.oUt && enu() <= this.oUd.oUq - 1) {
            z = env() <= this.oUd.oUp - bq;
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
            remove = this.oTY.remove(k);
            b<K, V> bVar = this.oTZ.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        ens();
        ent();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.oUi.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        ens();
        ent();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.oUk || bVar.oUj != 0) {
            z = false;
        } else {
            this.oTY.put(bVar.key, bVar);
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
            remove = this.oTY.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.oTZ.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.oUj == 0);
                aVar = remove2.oUi;
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
        return !this.oTZ.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.oTZ.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dW;
        double b2 = this.oUb.b(memoryTrimType);
        synchronized (this) {
            dW = dW(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.oTZ.getSizeInBytes())) - env()));
            bq(dW);
        }
        bo(dW);
        bp(dW);
        ens();
        ent();
    }

    private synchronized void ens() {
        if (this.oUe + oTX <= SystemClock.uptimeMillis()) {
            this.oUe = SystemClock.uptimeMillis();
            this.oUd = this.oUc.get();
        }
    }

    private void ent() {
        ArrayList<b<K, V>> dW;
        synchronized (this) {
            dW = dW(Math.min(this.oUd.oUs, this.oUd.oUq - enu()), Math.min(this.oUd.oUr, this.oUd.oUp - env()));
            bq(dW);
        }
        bo(dW);
        bp(dW);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dW(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.oTY.getCount() <= max && this.oTY.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.oTY.getCount() <= max && this.oTY.getSizeInBytes() <= max2) {
                    break;
                }
                K enr = this.oTY.enr();
                this.oTY.remove(enr);
                arrayList.add(this.oTZ.remove(enr));
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
        if (bVar != null && bVar.oUl != null) {
            bVar.oUl.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.oUl != null) {
            bVar.oUl.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.oUk ? false : true);
            bVar.oUk = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.oUk);
        bVar.oUj++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.oUj > 0);
        bVar.oUj--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.oUk && bVar.oUj == 0) ? bVar.oUi : null;
    }

    public synchronized int enu() {
        return this.oTZ.getCount() - this.oTY.getCount();
    }

    public synchronized int env() {
        return this.oTZ.getSizeInBytes() - this.oTY.getSizeInBytes();
    }
}

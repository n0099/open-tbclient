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
/* loaded from: classes17.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long oVA = TimeUnit.MINUTES.toMillis(5);
    @GuardedBy("this")
    final g<K, b<K, V>> oVB;
    @GuardedBy("this")
    final g<K, b<K, V>> oVC;
    private final a oVE;
    private final com.facebook.common.internal.j<q> oVF;
    @GuardedBy("this")
    protected q oVG;
    private final v<V> oVx;
    @GuardedBy("this")
    final Map<Bitmap, Object> oVD = new WeakHashMap();
    @GuardedBy("this")
    private long oVH = SystemClock.uptimeMillis();

    /* loaded from: classes17.dex */
    public interface a {
        double b(MemoryTrimType memoryTrimType);
    }

    /* loaded from: classes17.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> oVL;
        public int oVM = 0;
        public boolean oVN = false;
        @Nullable
        public final c<K> oVO;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.oVL = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.oVO = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.oVx = vVar;
        this.oVB = new g<>(a(vVar));
        this.oVC = new g<>(a(vVar));
        this.oVE = aVar;
        this.oVF = jVar;
        this.oVG = this.oVF.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int br(b<K, V> bVar) {
                return vVar.br(bVar.oVL.get());
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
        enq();
        synchronized (this) {
            remove = this.oVB.remove(k);
            b<K, V> remove2 = this.oVC.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bu(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.oVC.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        enr();
        return aVar3;
    }

    private synchronized boolean bu(V v) {
        boolean z;
        int br = this.oVx.br(v);
        if (br <= this.oVG.oVW && ens() <= this.oVG.oVT - 1) {
            z = ent() <= this.oVG.oVS - br;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bv(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.oVB.remove(k);
            b<K, V> bVar = this.oVC.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        enq();
        enr();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.oVL.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        enq();
        enr();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.oVN || bVar.oVM != 0) {
            z = false;
        } else {
            this.oVB.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bw(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.oVB.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.oVC.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.oVM == 0);
                aVar = remove2.oVL;
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
        return !this.oVC.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.oVC.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dX;
        double b2 = this.oVE.b(memoryTrimType);
        synchronized (this) {
            dX = dX(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.oVC.getSizeInBytes())) - ent()));
            br(dX);
        }
        bp(dX);
        bq(dX);
        enq();
        enr();
    }

    private synchronized void enq() {
        if (this.oVH + oVA <= SystemClock.uptimeMillis()) {
            this.oVH = SystemClock.uptimeMillis();
            this.oVG = this.oVF.get();
        }
    }

    private void enr() {
        ArrayList<b<K, V>> dX;
        synchronized (this) {
            dX = dX(Math.min(this.oVG.oVV, this.oVG.oVT - ens()), Math.min(this.oVG.oVU, this.oVG.oVS - ent()));
            br(dX);
        }
        bp(dX);
        bq(dX);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dX(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.oVB.getCount() <= max && this.oVB.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.oVB.getCount() <= max && this.oVB.getSizeInBytes() <= max2) {
                    break;
                }
                K enp = this.oVB.enp();
                this.oVB.remove(enp);
                arrayList.add(this.oVC.remove(enp));
            }
        }
        return arrayList;
    }

    private void bp(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bq(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.oVO != null) {
            bVar.oVO.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.oVO != null) {
            bVar.oVO.d(bVar.key, true);
        }
    }

    private synchronized void br(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.oVN ? false : true);
            bVar.oVN = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.oVN);
        bVar.oVM++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.oVM > 0);
        bVar.oVM--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.oVN && bVar.oVM == 0) ? bVar.oVL : null;
    }

    public synchronized int ens() {
        return this.oVC.getCount() - this.oVB.getCount();
    }

    public synchronized int ent() {
        return this.oVC.getSizeInBytes() - this.oVB.getSizeInBytes();
    }
}

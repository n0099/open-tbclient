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
    static final long nTm = TimeUnit.MINUTES.toMillis(5);
    private final v<V> nTj;
    @GuardedBy("this")
    final g<K, b<K, V>> nTn;
    @GuardedBy("this")
    final g<K, b<K, V>> nTo;
    private final a nTq;
    private final com.facebook.common.internal.j<q> nTr;
    @GuardedBy("this")
    protected q nTs;
    @GuardedBy("this")
    final Map<Bitmap, Object> nTp = new WeakHashMap();
    @GuardedBy("this")
    private long nTt = SystemClock.uptimeMillis();

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
        public final c<K> nTA;
        public final com.facebook.common.references.a<V> nTx;
        public int nTy = 0;
        public boolean nTz = false;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.nTx = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.nTA = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.nTj = vVar;
        this.nTn = new g<>(a(vVar));
        this.nTo = new g<>(a(vVar));
        this.nTq = aVar;
        this.nTr = jVar;
        this.nTs = this.nTr.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bm(b<K, V> bVar) {
                return vVar.bm(bVar.nTx.get());
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
        dZE();
        synchronized (this) {
            remove = this.nTn.remove(k);
            b<K, V> remove2 = this.nTo.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bp(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.nTo.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dZF();
        return aVar3;
    }

    private synchronized boolean bp(V v) {
        boolean z;
        int bm = this.nTj.bm(v);
        if (bm <= this.nTs.nTI && dZG() <= this.nTs.nTF - 1) {
            z = dZH() <= this.nTs.nTE - bm;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bq(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.nTn.remove(k);
            b<K, V> bVar = this.nTo.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dZE();
        dZF();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.nTx.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dZE();
        dZF();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.nTz || bVar.nTy != 0) {
            z = false;
        } else {
            this.nTn.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> br(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.nTn.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.nTo.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.nTy == 0);
                aVar = remove2.nTx;
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
        return !this.nTo.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.nTo.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dK;
        double b2 = this.nTq.b(memoryTrimType);
        synchronized (this) {
            dK = dK(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.nTo.getSizeInBytes())) - dZH()));
            bm(dK);
        }
        bk(dK);
        bl(dK);
        dZE();
        dZF();
    }

    private synchronized void dZE() {
        if (this.nTt + nTm <= SystemClock.uptimeMillis()) {
            this.nTt = SystemClock.uptimeMillis();
            this.nTs = this.nTr.get();
        }
    }

    private void dZF() {
        ArrayList<b<K, V>> dK;
        synchronized (this) {
            dK = dK(Math.min(this.nTs.nTH, this.nTs.nTF - dZG()), Math.min(this.nTs.nTG, this.nTs.nTE - dZH()));
            bm(dK);
        }
        bk(dK);
        bl(dK);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dK(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.nTn.getCount() <= max && this.nTn.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.nTn.getCount() <= max && this.nTn.getSizeInBytes() <= max2) {
                    break;
                }
                K dZD = this.nTn.dZD();
                this.nTn.remove(dZD);
                arrayList.add(this.nTo.remove(dZD));
            }
        }
        return arrayList;
    }

    private void bk(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bl(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.nTA != null) {
            bVar.nTA.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.nTA != null) {
            bVar.nTA.d(bVar.key, true);
        }
    }

    private synchronized void bm(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.nTz ? false : true);
            bVar.nTz = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.nTz);
        bVar.nTy++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.nTy > 0);
        bVar.nTy--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.nTz && bVar.nTy == 0) ? bVar.nTx : null;
    }

    public synchronized int dZG() {
        return this.nTo.getCount() - this.nTn.getCount();
    }

    public synchronized int dZH() {
        return this.nTo.getSizeInBytes() - this.nTn.getSizeInBytes();
    }
}

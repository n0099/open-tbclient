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
/* loaded from: classes13.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long mRC = TimeUnit.MINUTES.toMillis(5);
    @GuardedBy("this")
    final g<K, b<K, V>> mRD;
    @GuardedBy("this")
    final g<K, b<K, V>> mRE;
    private final a mRG;
    private final com.facebook.common.internal.j<q> mRH;
    @GuardedBy("this")
    protected q mRI;
    private final v<V> mRz;
    @GuardedBy("this")
    final Map<Bitmap, Object> mRF = new WeakHashMap();
    @GuardedBy("this")
    private long mRJ = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> mRN;
        public int mRO = 0;
        public boolean mRP = false;
        @Nullable
        public final c<K> mRQ;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.mRN = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.mRQ = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.mRz = vVar;
        this.mRD = new g<>(a(vVar));
        this.mRE = new g<>(a(vVar));
        this.mRG = aVar;
        this.mRH = jVar;
        this.mRI = this.mRH.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bf(b<K, V> bVar) {
                return vVar.bf(bVar.mRN.get());
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
        dCw();
        synchronized (this) {
            remove = this.mRD.remove(k);
            b<K, V> remove2 = this.mRE.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bi(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.mRE.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dCx();
        return aVar3;
    }

    private synchronized boolean bi(V v) {
        boolean z;
        int bf = this.mRz.bf(v);
        if (bf <= this.mRI.mRY && dCy() <= this.mRI.mRV - 1) {
            z = dCz() <= this.mRI.mRU - bf;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bj(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.mRD.remove(k);
            b<K, V> bVar = this.mRE.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dCw();
        dCx();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.mRN.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dCw();
        dCx();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.mRP || bVar.mRO != 0) {
            z = false;
        } else {
            this.mRD.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bk(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.mRD.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.mRE.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.mRO == 0);
                aVar = remove2.mRN;
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
        return !this.mRE.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.mRE.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dw;
        double b2 = this.mRG.b(memoryTrimType);
        synchronized (this) {
            dw = dw(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.mRE.getSizeInBytes())) - dCz()));
            bd(dw);
        }
        bb(dw);
        bc(dw);
        dCw();
        dCx();
    }

    private synchronized void dCw() {
        if (this.mRJ + mRC <= SystemClock.uptimeMillis()) {
            this.mRJ = SystemClock.uptimeMillis();
            this.mRI = this.mRH.get();
        }
    }

    private void dCx() {
        ArrayList<b<K, V>> dw;
        synchronized (this) {
            dw = dw(Math.min(this.mRI.mRX, this.mRI.mRV - dCy()), Math.min(this.mRI.mRW, this.mRI.mRU - dCz()));
            bd(dw);
        }
        bb(dw);
        bc(dw);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dw(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.mRD.getCount() <= max && this.mRD.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.mRD.getCount() <= max && this.mRD.getSizeInBytes() <= max2) {
                    break;
                }
                K dCv = this.mRD.dCv();
                this.mRD.remove(dCv);
                arrayList.add(this.mRE.remove(dCv));
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
        if (bVar != null && bVar.mRQ != null) {
            bVar.mRQ.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.mRQ != null) {
            bVar.mRQ.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.mRP ? false : true);
            bVar.mRP = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.mRP);
        bVar.mRO++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.mRO > 0);
        bVar.mRO--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.mRP && bVar.mRO == 0) ? bVar.mRN : null;
    }

    public synchronized int dCy() {
        return this.mRE.getCount() - this.mRD.getCount();
    }

    public synchronized int dCz() {
        return this.mRE.getSizeInBytes() - this.mRD.getSizeInBytes();
    }
}

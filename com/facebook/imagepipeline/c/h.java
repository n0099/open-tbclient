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
    static final long mvD = TimeUnit.MINUTES.toMillis(5);
    private final v<V> mvA;
    @GuardedBy("this")
    final g<K, b<K, V>> mvE;
    @GuardedBy("this")
    final g<K, b<K, V>> mvF;
    private final a mvH;
    private final com.facebook.common.internal.j<q> mvI;
    @GuardedBy("this")
    protected q mvJ;
    @GuardedBy("this")
    final Map<Bitmap, Object> mvG = new WeakHashMap();
    @GuardedBy("this")
    private long mvK = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> mvO;
        public int mvP = 0;
        public boolean mvQ = false;
        @Nullable
        public final c<K> mvR;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.mvO = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.mvR = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.mvA = vVar;
        this.mvE = new g<>(a(vVar));
        this.mvF = new g<>(a(vVar));
        this.mvH = aVar;
        this.mvI = jVar;
        this.mvJ = this.mvI.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int be(b<K, V> bVar) {
                return vVar.be(bVar.mvO.get());
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
        dxU();
        synchronized (this) {
            remove = this.mvE.remove(k);
            b<K, V> remove2 = this.mvF.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bh(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.mvF.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dxV();
        return aVar3;
    }

    private synchronized boolean bh(V v) {
        boolean z;
        int be = this.mvA.be(v);
        if (be <= this.mvJ.mvZ && dxW() <= this.mvJ.mvW - 1) {
            z = dxX() <= this.mvJ.mvV - be;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> bi(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.mvE.remove(k);
            b<K, V> bVar = this.mvF.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dxU();
        dxV();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.mvO.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dxU();
        dxV();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.mvQ || bVar.mvP != 0) {
            z = false;
        } else {
            this.mvE.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bj(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.mvE.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.mvF.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.mvP == 0);
                aVar = remove2.mvO;
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
        return !this.mvF.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.mvF.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dn;
        double b2 = this.mvH.b(memoryTrimType);
        synchronized (this) {
            dn = dn(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.mvF.getSizeInBytes())) - dxX()));
            bc(dn);
        }
        ba(dn);
        bb(dn);
        dxU();
        dxV();
    }

    private synchronized void dxU() {
        if (this.mvK + mvD <= SystemClock.uptimeMillis()) {
            this.mvK = SystemClock.uptimeMillis();
            this.mvJ = this.mvI.get();
        }
    }

    private void dxV() {
        ArrayList<b<K, V>> dn;
        synchronized (this) {
            dn = dn(Math.min(this.mvJ.mvY, this.mvJ.mvW - dxW()), Math.min(this.mvJ.mvX, this.mvJ.mvV - dxX()));
            bc(dn);
        }
        ba(dn);
        bb(dn);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dn(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.mvE.getCount() <= max && this.mvE.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.mvE.getCount() <= max && this.mvE.getSizeInBytes() <= max2) {
                    break;
                }
                K dxT = this.mvE.dxT();
                this.mvE.remove(dxT);
                arrayList.add(this.mvF.remove(dxT));
            }
        }
        return arrayList;
    }

    private void ba(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bb(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.mvR != null) {
            bVar.mvR.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.mvR != null) {
            bVar.mvR.d(bVar.key, true);
        }
    }

    private synchronized void bc(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.mvQ ? false : true);
            bVar.mvQ = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.mvQ);
        bVar.mvP++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.mvP > 0);
        bVar.mvP--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.mvQ && bVar.mvP == 0) ? bVar.mvO : null;
    }

    public synchronized int dxW() {
        return this.mvF.getCount() - this.mvE.getCount();
    }

    public synchronized int dxX() {
        return this.mvF.getSizeInBytes() - this.mvE.getSizeInBytes();
    }
}

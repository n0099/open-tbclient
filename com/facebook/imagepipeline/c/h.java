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
/* loaded from: classes8.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long ntD = TimeUnit.MINUTES.toMillis(5);
    private final v<V> ntA;
    @GuardedBy("this")
    final g<K, b<K, V>> ntE;
    @GuardedBy("this")
    final g<K, b<K, V>> ntF;
    private final a ntH;
    private final com.facebook.common.internal.j<q> ntI;
    @GuardedBy("this")
    protected q ntJ;
    @GuardedBy("this")
    final Map<Bitmap, Object> ntG = new WeakHashMap();
    @GuardedBy("this")
    private long ntK = SystemClock.uptimeMillis();

    /* loaded from: classes8.dex */
    public interface a {
        double b(MemoryTrimType memoryTrimType);
    }

    /* loaded from: classes8.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> ntO;
        public int ntP = 0;
        public boolean ntQ = false;
        @Nullable
        public final c<K> ntR;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.ntO = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.ntR = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.ntA = vVar;
        this.ntE = new g<>(a(vVar));
        this.ntF = new g<>(a(vVar));
        this.ntH = aVar;
        this.ntI = jVar;
        this.ntJ = this.ntI.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bh(b<K, V> bVar) {
                return vVar.bh(bVar.ntO.get());
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
        dRM();
        synchronized (this) {
            remove = this.ntE.remove(k);
            b<K, V> remove2 = this.ntF.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bk((h<K, V>) aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.ntF.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dRN();
        return aVar3;
    }

    private synchronized boolean bk(V v) {
        boolean z;
        int bh = this.ntA.bh(v);
        if (bh <= this.ntJ.ntZ && dRO() <= this.ntJ.ntW - 1) {
            z = dRP() <= this.ntJ.ntV - bh;
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
            remove = this.ntE.remove(k);
            b<K, V> bVar = this.ntF.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dRM();
        dRN();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.ntO.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dRM();
        dRN();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.ntQ || bVar.ntP != 0) {
            z = false;
        } else {
            this.ntE.put(bVar.key, bVar);
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
            remove = this.ntE.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.ntF.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.ntP == 0);
                aVar = remove2.ntO;
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
        return !this.ntF.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.ntF.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dG;
        double b2 = this.ntH.b(memoryTrimType);
        synchronized (this) {
            dG = dG(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.ntF.getSizeInBytes())) - dRP()));
            bk((ArrayList) dG);
        }
        bi(dG);
        bj(dG);
        dRM();
        dRN();
    }

    private synchronized void dRM() {
        if (this.ntK + ntD <= SystemClock.uptimeMillis()) {
            this.ntK = SystemClock.uptimeMillis();
            this.ntJ = this.ntI.get();
        }
    }

    private void dRN() {
        ArrayList<b<K, V>> dG;
        synchronized (this) {
            dG = dG(Math.min(this.ntJ.ntY, this.ntJ.ntW - dRO()), Math.min(this.ntJ.ntX, this.ntJ.ntV - dRP()));
            bk((ArrayList) dG);
        }
        bi(dG);
        bj(dG);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dG(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.ntE.getCount() <= max && this.ntE.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.ntE.getCount() <= max && this.ntE.getSizeInBytes() <= max2) {
                    break;
                }
                K dRL = this.ntE.dRL();
                this.ntE.remove(dRL);
                arrayList.add(this.ntF.remove(dRL));
            }
        }
        return arrayList;
    }

    private void bi(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bj(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.ntR != null) {
            bVar.ntR.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.ntR != null) {
            bVar.ntR.d(bVar.key, true);
        }
    }

    private synchronized void bk(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.ntQ ? false : true);
            bVar.ntQ = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.ntQ);
        bVar.ntP++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.ntP > 0);
        bVar.ntP--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.ntQ && bVar.ntP == 0) ? bVar.ntO : null;
    }

    public synchronized int dRO() {
        return this.ntF.getCount() - this.ntE.getCount();
    }

    public synchronized int dRP() {
        return this.ntF.getSizeInBytes() - this.ntE.getSizeInBytes();
    }
}

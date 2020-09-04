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
    static final long ntV = TimeUnit.MINUTES.toMillis(5);
    private final v<V> ntS;
    @GuardedBy("this")
    final g<K, b<K, V>> ntW;
    @GuardedBy("this")
    final g<K, b<K, V>> ntX;
    private final a ntZ;
    private final com.facebook.common.internal.j<q> nua;
    @GuardedBy("this")
    protected q nub;
    @GuardedBy("this")
    final Map<Bitmap, Object> ntY = new WeakHashMap();
    @GuardedBy("this")
    private long nuc = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> nug;
        public int nuh = 0;
        public boolean nui = false;
        @Nullable
        public final c<K> nuj;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.nug = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.nuj = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.ntS = vVar;
        this.ntW = new g<>(a(vVar));
        this.ntX = new g<>(a(vVar));
        this.ntZ = aVar;
        this.nua = jVar;
        this.nub = this.nua.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bh(b<K, V> bVar) {
                return vVar.bh(bVar.nug.get());
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
        dRV();
        synchronized (this) {
            remove = this.ntW.remove(k);
            b<K, V> remove2 = this.ntX.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bk((h<K, V>) aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.ntX.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dRW();
        return aVar3;
    }

    private synchronized boolean bk(V v) {
        boolean z;
        int bh = this.ntS.bh(v);
        if (bh <= this.nub.nus && dRX() <= this.nub.nup - 1) {
            z = dRY() <= this.nub.nuo - bh;
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
            remove = this.ntW.remove(k);
            b<K, V> bVar = this.ntX.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dRV();
        dRW();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.nug.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dRV();
        dRW();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.nui || bVar.nuh != 0) {
            z = false;
        } else {
            this.ntW.put(bVar.key, bVar);
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
            remove = this.ntW.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.ntX.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.nuh == 0);
                aVar = remove2.nug;
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
        return !this.ntX.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.ntX.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dG;
        double b2 = this.ntZ.b(memoryTrimType);
        synchronized (this) {
            dG = dG(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.ntX.getSizeInBytes())) - dRY()));
            bk((ArrayList) dG);
        }
        bi(dG);
        bj(dG);
        dRV();
        dRW();
    }

    private synchronized void dRV() {
        if (this.nuc + ntV <= SystemClock.uptimeMillis()) {
            this.nuc = SystemClock.uptimeMillis();
            this.nub = this.nua.get();
        }
    }

    private void dRW() {
        ArrayList<b<K, V>> dG;
        synchronized (this) {
            dG = dG(Math.min(this.nub.nur, this.nub.nup - dRX()), Math.min(this.nub.nuq, this.nub.nuo - dRY()));
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
        if (this.ntW.getCount() <= max && this.ntW.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.ntW.getCount() <= max && this.ntW.getSizeInBytes() <= max2) {
                    break;
                }
                K dRU = this.ntW.dRU();
                this.ntW.remove(dRU);
                arrayList.add(this.ntX.remove(dRU));
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
        if (bVar != null && bVar.nuj != null) {
            bVar.nuj.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.nuj != null) {
            bVar.nuj.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.nui ? false : true);
            bVar.nui = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.nui);
        bVar.nuh++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.nuh > 0);
        bVar.nuh--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.nui && bVar.nuh == 0) ? bVar.nug : null;
    }

    public synchronized int dRX() {
        return this.ntX.getCount() - this.ntW.getCount();
    }

    public synchronized int dRY() {
        return this.ntX.getSizeInBytes() - this.ntW.getSizeInBytes();
    }
}

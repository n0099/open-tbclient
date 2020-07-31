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
/* loaded from: classes3.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long mZM = TimeUnit.MINUTES.toMillis(5);
    private final v<V> mZJ;
    @GuardedBy("this")
    final g<K, b<K, V>> mZN;
    @GuardedBy("this")
    final g<K, b<K, V>> mZO;
    private final a mZQ;
    private final com.facebook.common.internal.j<q> mZR;
    @GuardedBy("this")
    protected q mZS;
    @GuardedBy("this")
    final Map<Bitmap, Object> mZP = new WeakHashMap();
    @GuardedBy("this")
    private long mZT = SystemClock.uptimeMillis();

    /* loaded from: classes3.dex */
    public interface a {
        double b(MemoryTrimType memoryTrimType);
    }

    /* loaded from: classes3.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> mZX;
        public int mZY = 0;
        public boolean mZZ = false;
        @Nullable
        public final c<K> naa;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.mZX = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.naa = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.mZJ = vVar;
        this.mZN = new g<>(a(vVar));
        this.mZO = new g<>(a(vVar));
        this.mZQ = aVar;
        this.mZR = jVar;
        this.mZS = this.mZR.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int bf(b<K, V> bVar) {
                return vVar.bf(bVar.mZX.get());
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
        dFM();
        synchronized (this) {
            remove = this.mZN.remove(k);
            b<K, V> remove2 = this.mZO.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bi(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.mZO.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        dFN();
        return aVar3;
    }

    private synchronized boolean bi(V v) {
        boolean z;
        int bf = this.mZJ.bf(v);
        if (bf <= this.mZS.nai && dFO() <= this.mZS.naf - 1) {
            z = dFP() <= this.mZS.nae - bf;
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
            remove = this.mZN.remove(k);
            b<K, V> bVar = this.mZO.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dFM();
        dFN();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.mZX.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dFM();
        dFN();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.mZZ || bVar.mZY != 0) {
            z = false;
        } else {
            this.mZN.put(bVar.key, bVar);
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
            remove = this.mZN.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.mZO.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.mZY == 0);
                aVar = remove2.mZX;
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
        return !this.mZO.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.mZO.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> dy;
        double b2 = this.mZQ.b(memoryTrimType);
        synchronized (this) {
            dy = dy(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.mZO.getSizeInBytes())) - dFP()));
            be(dy);
        }
        bc(dy);
        bd(dy);
        dFM();
        dFN();
    }

    private synchronized void dFM() {
        if (this.mZT + mZM <= SystemClock.uptimeMillis()) {
            this.mZT = SystemClock.uptimeMillis();
            this.mZS = this.mZR.get();
        }
    }

    private void dFN() {
        ArrayList<b<K, V>> dy;
        synchronized (this) {
            dy = dy(Math.min(this.mZS.nah, this.mZS.naf - dFO()), Math.min(this.mZS.nag, this.mZS.nae - dFP()));
            be(dy);
        }
        bc(dy);
        bd(dy);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> dy(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.mZN.getCount() <= max && this.mZN.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.mZN.getCount() <= max && this.mZN.getSizeInBytes() <= max2) {
                    break;
                }
                K dFL = this.mZN.dFL();
                this.mZN.remove(dFL);
                arrayList.add(this.mZO.remove(dFL));
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
        if (bVar != null && bVar.naa != null) {
            bVar.naa.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.naa != null) {
            bVar.naa.d(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.mZZ ? false : true);
            bVar.mZZ = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.mZZ);
        bVar.mZY++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.mZY > 0);
        bVar.mZY--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.mZZ && bVar.mZY == 0) ? bVar.mZX : null;
    }

    public synchronized int dFO() {
        return this.mZO.getCount() - this.mZN.getCount();
    }

    public synchronized int dFP() {
        return this.mZO.getSizeInBytes() - this.mZN.getSizeInBytes();
    }
}

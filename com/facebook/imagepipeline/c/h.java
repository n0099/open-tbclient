package com.facebook.imagepipeline.c;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.imagepipeline.b.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class h<K, V> implements com.facebook.common.memory.b, t<K, V> {
    static final long jFH = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> jFE;
    @GuardedBy("this")
    final g<K, b<K, V>> jFI;
    @GuardedBy("this")
    final g<K, b<K, V>> jFJ;
    private final a jFL;
    private final com.facebook.common.internal.i<u> jFM;
    @GuardedBy("this")
    protected u jFN;
    @GuardedBy("this")
    final Map<Bitmap, Object> jFK = new WeakHashMap();
    @GuardedBy("this")
    private long jFO = SystemClock.uptimeMillis();

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    public interface c<K> {
        void c(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b<K, V> {
        public final com.facebook.common.references.a<V> jFS;
        @Nullable
        public final c<K> jFU;
        public final K key;
        public int clientCount = 0;
        public boolean jFT = false;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.jFS = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.jFU = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.jFE = acVar;
        this.jFI = new g<>(a(acVar));
        this.jFJ = new g<>(a(acVar));
        this.jFL = aVar;
        this.jFM = iVar;
        this.jFN = this.jFM.get();
        if (z) {
            fVar.a(new f.a() { // from class: com.facebook.imagepipeline.c.h.1
            });
        }
    }

    private ac<b<K, V>> a(final ac<V> acVar) {
        return new ac<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.ac
            /* renamed from: j */
            public int aS(b<K, V> bVar) {
                return acVar.aS(bVar.jFS.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.c.t
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        return a(k, aVar, null);
    }

    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar, c<K> cVar) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar2;
        com.facebook.common.references.a<V> aVar3;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.internal.g.checkNotNull(aVar);
        cwj();
        synchronized (this) {
            remove = this.jFI.remove(k);
            b<K, V> remove2 = this.jFJ.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aV(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.jFJ.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        cwk();
        return aVar3;
    }

    private synchronized boolean aV(V v) {
        boolean z;
        int aS = this.jFE.aS(v);
        if (aS <= this.jFN.jGi && cwl() <= this.jFN.jGf - 1) {
            z = cwm() <= this.jFN.jGe - aS;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    @Nullable
    public com.facebook.common.references.a<V> aW(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.jFI.remove(k);
            b<K, V> bVar = this.jFJ.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        cwj();
        cwk();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.jFS.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
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
        cwj();
        cwk();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.jFT || bVar.clientCount != 0) {
            z = false;
        } else {
            this.jFI.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.jFJ.a(predicate).isEmpty();
    }

    private synchronized void cwj() {
        if (this.jFO + jFH <= SystemClock.uptimeMillis()) {
            this.jFO = SystemClock.uptimeMillis();
            this.jFN = this.jFM.get();
        }
    }

    private void cwk() {
        ArrayList<b<K, V>> cB;
        synchronized (this) {
            cB = cB(Math.min(this.jFN.jGh, this.jFN.jGf - cwl()), Math.min(this.jFN.jGg, this.jFN.jGe - cwm()));
            aI(cB);
        }
        aG(cB);
        aH(cB);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> cB(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.jFI.getCount() <= max && this.jFI.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.jFI.getCount() <= max && this.jFI.getSizeInBytes() <= max2) {
                    break;
                }
                K cwi = this.jFI.cwi();
                this.jFI.remove(cwi);
                arrayList.add(this.jFJ.remove(cwi));
            }
        }
        return arrayList;
    }

    private void aG(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void aH(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.jFU != null) {
            bVar.jFU.c(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.jFU != null) {
            bVar.jFU.c(bVar.key, true);
        }
    }

    private synchronized void aI(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.jFT ? false : true);
            bVar.jFT = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.jFT);
        bVar.clientCount++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.clientCount > 0);
        bVar.clientCount--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.jFT && bVar.clientCount == 0) ? bVar.jFS : null;
    }

    public synchronized int cwl() {
        return this.jFJ.getCount() - this.jFI.getCount();
    }

    public synchronized int cwm() {
        return this.jFJ.getSizeInBytes() - this.jFI.getSizeInBytes();
    }
}

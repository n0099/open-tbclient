package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long pBD = TimeUnit.MINUTES.toMillis(5);
    private final v<V> pBA;
    @GuardedBy("this")
    final g<K, b<K, V>> pBE;
    @GuardedBy("this")
    final g<K, b<K, V>> pBF;
    private final a pBH;
    private final com.facebook.common.internal.j<q> pBI;
    @GuardedBy("this")
    protected q pBJ;
    @GuardedBy("this")
    final Map<Bitmap, Object> pBG = new WeakHashMap();
    @GuardedBy("this")
    private long pBK = SystemClock.uptimeMillis();

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface c<K> {
        void e(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> pBO;
        public int pBP = 0;
        public boolean pBQ = false;
        @Nullable
        public final c<K> pBR;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.pBO = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.pBR = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.pBA = vVar;
        this.pBE = new g<>(a(vVar));
        this.pBF = new g<>(a(vVar));
        this.pBH = aVar;
        this.pBI = jVar;
        this.pBJ = this.pBI.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: j */
            public int bq(b<K, V> bVar) {
                return vVar.bq(bVar.pBO.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.b.p
    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar) {
        return a(k, aVar, null);
    }

    public com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar, c<K> cVar) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar2;
        com.facebook.common.references.a<V> aVar3;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.internal.g.checkNotNull(aVar);
        exk();
        synchronized (this) {
            remove = this.pBE.remove(k);
            b<K, V> remove2 = this.pBF.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bt((h<K, V>) aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.pBF.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        exl();
        return aVar3;
    }

    private synchronized boolean bt(V v) {
        boolean z;
        int bq = this.pBA.bq(v);
        if (bq <= this.pBJ.pBZ && exm() <= this.pBJ.pBW - 1) {
            z = exn() <= this.pBJ.pBV - bq;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.b.p
    @Nullable
    public com.facebook.common.references.a<V> bu(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.pBE.remove(k);
            b<K, V> bVar = this.pBF.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        exk();
        exl();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.pBO.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.b.h.2
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
        exk();
        exl();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.pBQ || bVar.pBP != 0) {
            z = false;
        } else {
            this.pBE.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bv(K k) {
        b<K, V> remove;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.references.a<V> aVar = null;
        synchronized (this) {
            remove = this.pBE.remove(k);
            if (remove != null) {
                b<K, V> remove2 = this.pBF.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.pBP == 0);
                com.facebook.common.references.a<V> aVar2 = remove2.pBO;
                z = true;
                aVar = aVar2;
            } else {
                z = false;
            }
        }
        if (z) {
            d(remove);
        }
        return aVar;
    }

    @Override // com.facebook.imagepipeline.b.p
    public synchronized boolean b(com.facebook.common.internal.h<K> hVar) {
        return !this.pBF.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.pBF.contains(k);
    }

    private synchronized void exk() {
        if (this.pBK + pBD <= SystemClock.uptimeMillis()) {
            this.pBK = SystemClock.uptimeMillis();
            this.pBJ = this.pBI.get();
        }
    }

    private void exl() {
        ArrayList<b<K, V>> ec;
        synchronized (this) {
            ec = ec(Math.min(this.pBJ.pBY, this.pBJ.pBW - exm()), Math.min(this.pBJ.pBX, this.pBJ.pBV - exn()));
            bt((ArrayList) ec);
        }
        br(ec);
        bs(ec);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> ec(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.pBE.getCount() <= max && this.pBE.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.pBE.getCount() <= max && this.pBE.getSizeInBytes() <= max2) {
                    break;
                }
                K exj = this.pBE.exj();
                this.pBE.remove(exj);
                arrayList.add(this.pBF.remove(exj));
            }
        }
        return arrayList;
    }

    private void br(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bs(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pBR != null) {
            bVar.pBR.e(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pBR != null) {
            bVar.pBR.e(bVar.key, true);
        }
    }

    private synchronized void bt(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.pBQ ? false : true);
            bVar.pBQ = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.pBQ);
        bVar.pBP++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.pBP > 0);
        bVar.pBP--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.pBQ && bVar.pBP == 0) ? bVar.pBO : null;
    }

    public synchronized int exm() {
        return this.pBF.getCount() - this.pBE.getCount();
    }

    public synchronized int exn() {
        return this.pBF.getSizeInBytes() - this.pBE.getSizeInBytes();
    }
}

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
    static final long pJQ = TimeUnit.MINUTES.toMillis(5);
    private final v<V> pJN;
    @GuardedBy("this")
    final g<K, b<K, V>> pJR;
    @GuardedBy("this")
    final g<K, b<K, V>> pJS;
    private final a pJU;
    private final com.facebook.common.internal.j<q> pJV;
    @GuardedBy("this")
    protected q pJW;
    @GuardedBy("this")
    final Map<Bitmap, Object> pJT = new WeakHashMap();
    @GuardedBy("this")
    private long pJX = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> pKb;
        public int pKc = 0;
        public boolean pKd = false;
        @Nullable
        public final c<K> pKe;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.pKb = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.pKe = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.pJN = vVar;
        this.pJR = new g<>(a(vVar));
        this.pJS = new g<>(a(vVar));
        this.pJU = aVar;
        this.pJV = jVar;
        this.pJW = this.pJV.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.b.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: j */
            public int bs(b<K, V> bVar) {
                return vVar.bs(bVar.pKb.get());
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
        ewb();
        synchronized (this) {
            remove = this.pJR.remove(k);
            b<K, V> remove2 = this.pJS.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bv(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.pJS.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        ewc();
        return aVar3;
    }

    private synchronized boolean bv(V v) {
        boolean z;
        int bs = this.pJN.bs(v);
        if (bs <= this.pJW.pKm && ewd() <= this.pJW.pKj - 1) {
            z = ewe() <= this.pJW.pKi - bs;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.b.p
    @Nullable
    public com.facebook.common.references.a<V> bw(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.pJR.remove(k);
            b<K, V> bVar = this.pJS.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        ewb();
        ewc();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.pKb.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.b.h.2
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
        ewb();
        ewc();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.pKd || bVar.pKc != 0) {
            z = false;
        } else {
            this.pJR.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bx(K k) {
        b<K, V> remove;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        com.facebook.common.references.a<V> aVar = null;
        synchronized (this) {
            remove = this.pJR.remove(k);
            if (remove != null) {
                b<K, V> remove2 = this.pJS.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.pKc == 0);
                com.facebook.common.references.a<V> aVar2 = remove2.pKb;
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
    public int c(com.facebook.common.internal.h<K> hVar) {
        ArrayList<b<K, V>> b2;
        ArrayList<b<K, V>> b3;
        synchronized (this) {
            b2 = this.pJR.b(hVar);
            b3 = this.pJS.b(hVar);
            bn(b3);
        }
        bl(b3);
        bm(b2);
        ewb();
        ewc();
        return b3.size();
    }

    @Override // com.facebook.imagepipeline.b.p
    public synchronized boolean d(com.facebook.common.internal.h<K> hVar) {
        return !this.pJS.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.pJS.contains(k);
    }

    private synchronized void ewb() {
        if (this.pJX + pJQ <= SystemClock.uptimeMillis()) {
            this.pJX = SystemClock.uptimeMillis();
            this.pJW = this.pJV.get();
        }
    }

    private void ewc() {
        ArrayList<b<K, V>> ea;
        synchronized (this) {
            ea = ea(Math.min(this.pJW.pKl, this.pJW.pKj - ewd()), Math.min(this.pJW.pKk, this.pJW.pKi - ewe()));
            bn(ea);
        }
        bl(ea);
        bm(ea);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> ea(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.pJR.getCount() <= max && this.pJR.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.pJR.getCount() <= max && this.pJR.getSizeInBytes() <= max2) {
                    break;
                }
                K ewa = this.pJR.ewa();
                this.pJR.remove(ewa);
                arrayList.add(this.pJS.remove(ewa));
            }
        }
        return arrayList;
    }

    private void bl(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void bm(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pKe != null) {
            bVar.pKe.e(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.pKe != null) {
            bVar.pKe.e(bVar.key, true);
        }
    }

    private synchronized void bn(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.pKd ? false : true);
            bVar.pKd = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.pKd);
        bVar.pKc++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.pKc > 0);
        bVar.pKc--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.pKd && bVar.pKc == 0) ? bVar.pKb : null;
    }

    public synchronized int ewd() {
        return this.pJS.getCount() - this.pJR.getCount();
    }

    public synchronized int ewe() {
        return this.pJS.getSizeInBytes() - this.pJR.getSizeInBytes();
    }
}

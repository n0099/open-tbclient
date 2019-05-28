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
    static final long jYb = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> jXY;
    @GuardedBy("this")
    final g<K, b<K, V>> jYc;
    @GuardedBy("this")
    final g<K, b<K, V>> jYd;
    private final a jYf;
    private final com.facebook.common.internal.i<u> jYg;
    @GuardedBy("this")
    protected u jYh;
    @GuardedBy("this")
    final Map<Bitmap, Object> jYe = new WeakHashMap();
    @GuardedBy("this")
    private long jYi = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> jYm;
        @Nullable
        public final c<K> jYo;
        public final K key;
        public int clientCount = 0;
        public boolean jYn = false;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.jYm = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.jYo = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.jXY = acVar;
        this.jYc = new g<>(a(acVar));
        this.jYd = new g<>(a(acVar));
        this.jYf = aVar;
        this.jYg = iVar;
        this.jYh = this.jYg.get();
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
            public int aR(b<K, V> bVar) {
                return acVar.aR(bVar.jYm.get());
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
        cEn();
        synchronized (this) {
            remove = this.jYc.remove(k);
            b<K, V> remove2 = this.jYd.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aU(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.jYd.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        cEo();
        return aVar3;
    }

    private synchronized boolean aU(V v) {
        boolean z;
        int aR = this.jXY.aR(v);
        if (aR <= this.jYh.jYC && cEp() <= this.jYh.jYz - 1) {
            z = cEq() <= this.jYh.jYy - aR;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    @Nullable
    public com.facebook.common.references.a<V> aV(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.jYc.remove(k);
            b<K, V> bVar = this.jYd.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        cEn();
        cEo();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.jYm.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
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
        cEn();
        cEo();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.jYn || bVar.clientCount != 0) {
            z = false;
        } else {
            this.jYc.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.jYd.a(predicate).isEmpty();
    }

    private synchronized void cEn() {
        if (this.jYi + jYb <= SystemClock.uptimeMillis()) {
            this.jYi = SystemClock.uptimeMillis();
            this.jYh = this.jYg.get();
        }
    }

    private void cEo() {
        ArrayList<b<K, V>> cI;
        synchronized (this) {
            cI = cI(Math.min(this.jYh.jYB, this.jYh.jYz - cEp()), Math.min(this.jYh.jYA, this.jYh.jYy - cEq()));
            aM(cI);
        }
        aK(cI);
        aL(cI);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> cI(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.jYc.getCount() <= max && this.jYc.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.jYc.getCount() <= max && this.jYc.getSizeInBytes() <= max2) {
                    break;
                }
                K cEm = this.jYc.cEm();
                this.jYc.remove(cEm);
                arrayList.add(this.jYd.remove(cEm));
            }
        }
        return arrayList;
    }

    private void aK(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c(i(it.next()));
            }
        }
    }

    private void aL(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.jYo != null) {
            bVar.jYo.c(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.jYo != null) {
            bVar.jYo.c(bVar.key, true);
        }
    }

    private synchronized void aM(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.jYn ? false : true);
            bVar.jYn = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.jYn);
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
        return (bVar.jYn && bVar.clientCount == 0) ? bVar.jYm : null;
    }

    public synchronized int cEp() {
        return this.jYd.getCount() - this.jYc.getCount();
    }

    public synchronized int cEq() {
        return this.jYd.getSizeInBytes() - this.jYc.getSizeInBytes();
    }
}

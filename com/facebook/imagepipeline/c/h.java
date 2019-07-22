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
    static final long kfj = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> kfg;
    @GuardedBy("this")
    final g<K, b<K, V>> kfk;
    @GuardedBy("this")
    final g<K, b<K, V>> kfl;
    private final a kfn;
    private final com.facebook.common.internal.i<u> kfo;
    @GuardedBy("this")
    protected u kfp;
    @GuardedBy("this")
    final Map<Bitmap, Object> kfm = new WeakHashMap();
    @GuardedBy("this")
    private long kfq = SystemClock.uptimeMillis();

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
        public final K key;
        public final com.facebook.common.references.a<V> kfu;
        public int kfv = 0;
        public boolean kfw = false;
        @Nullable
        public final c<K> kfx;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.kfu = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.kfx = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.kfg = acVar;
        this.kfk = new g<>(a(acVar));
        this.kfl = new g<>(a(acVar));
        this.kfn = aVar;
        this.kfo = iVar;
        this.kfp = this.kfo.get();
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
                return acVar.aR(bVar.kfu.get());
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
        cHp();
        synchronized (this) {
            remove = this.kfk.remove(k);
            b<K, V> remove2 = this.kfl.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aU(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.kfl.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c(aVar2);
        d(remove);
        cHq();
        return aVar3;
    }

    private synchronized boolean aU(V v) {
        boolean z;
        int aR = this.kfg.aR(v);
        if (aR <= this.kfp.kfL && cHr() <= this.kfp.kfI - 1) {
            z = cHs() <= this.kfp.kfH - aR;
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
            remove = this.kfk.remove(k);
            b<K, V> bVar = this.kfl.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        cHp();
        cHq();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.kfu.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
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
        cHp();
        cHq();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.kfw || bVar.kfv != 0) {
            z = false;
        } else {
            this.kfk.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.kfl.a(predicate).isEmpty();
    }

    private synchronized void cHp() {
        if (this.kfq + kfj <= SystemClock.uptimeMillis()) {
            this.kfq = SystemClock.uptimeMillis();
            this.kfp = this.kfo.get();
        }
    }

    private void cHq() {
        ArrayList<b<K, V>> cN;
        synchronized (this) {
            cN = cN(Math.min(this.kfp.kfK, this.kfp.kfI - cHr()), Math.min(this.kfp.kfJ, this.kfp.kfH - cHs()));
            aM(cN);
        }
        aK(cN);
        aL(cN);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> cN(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.kfk.getCount() <= max && this.kfk.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.kfk.getCount() <= max && this.kfk.getSizeInBytes() <= max2) {
                    break;
                }
                K cHo = this.kfk.cHo();
                this.kfk.remove(cHo);
                arrayList.add(this.kfl.remove(cHo));
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
        if (bVar != null && bVar.kfx != null) {
            bVar.kfx.c(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.kfx != null) {
            bVar.kfx.c(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.kfw ? false : true);
            bVar.kfw = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.kfw);
        bVar.kfv++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.kfv > 0);
        bVar.kfv--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.kfw && bVar.kfv == 0) ? bVar.kfu : null;
    }

    public synchronized int cHr() {
        return this.kfl.getCount() - this.kfk.getCount();
    }

    public synchronized int cHs() {
        return this.kfl.getSizeInBytes() - this.kfk.getSizeInBytes();
    }
}

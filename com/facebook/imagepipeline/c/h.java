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
    static final long iqa = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> ipX;
    @GuardedBy("this")
    final g<K, b<K, V>> iqb;
    @GuardedBy("this")
    final g<K, b<K, V>> iqc;
    private final a iqe;
    private final com.facebook.common.internal.i<u> iqf;
    @GuardedBy("this")
    protected u iqg;
    @GuardedBy("this")
    final Map<Bitmap, Object> iqd = new WeakHashMap();
    @GuardedBy("this")
    private long iqh = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> iql;
        @Nullable
        public final c<K> iqn;
        public final K key;
        public int clientCount = 0;
        public boolean iqm = false;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.iql = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.iqn = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.ipX = acVar;
        this.iqb = new g<>(a(acVar));
        this.iqc = new g<>(a(acVar));
        this.iqe = aVar;
        this.iqf = iVar;
        this.iqg = this.iqf.get();
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
            public int aD(b<K, V> bVar) {
                return acVar.aD(bVar.iql.get());
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
        bXi();
        synchronized (this) {
            remove = this.iqb.remove(k);
            b<K, V> remove2 = this.iqc.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aG(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.iqc.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
        d(remove);
        bXj();
        return aVar3;
    }

    private synchronized boolean aG(V v) {
        boolean z;
        int aD = this.ipX.aD(v);
        if (aD <= this.iqg.iqB && bXk() <= this.iqg.iqy - 1) {
            z = bXl() <= this.iqg.iqx - aD;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    @Nullable
    public com.facebook.common.references.a<V> aH(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.iqb.remove(k);
            b<K, V> bVar = this.iqc.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        bXi();
        bXj();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.iql.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i);
        if (!c2) {
            bVar = null;
        }
        e(bVar);
        bXi();
        bXj();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.iqm || bVar.clientCount != 0) {
            z = false;
        } else {
            this.iqb.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.iqc.a(predicate).isEmpty();
    }

    private synchronized void bXi() {
        if (this.iqh + iqa <= SystemClock.uptimeMillis()) {
            this.iqh = SystemClock.uptimeMillis();
            this.iqg = this.iqf.get();
        }
    }

    private void bXj() {
        ArrayList<b<K, V>> cg;
        synchronized (this) {
            cg = cg(Math.min(this.iqg.iqA, this.iqg.iqy - bXk()), Math.min(this.iqg.iqz, this.iqg.iqx - bXl()));
            aF(cg);
        }
        aD(cg);
        aE(cg);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> cg(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.iqb.getCount() <= max && this.iqb.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.iqb.getCount() <= max && this.iqb.getSizeInBytes() <= max2) {
                    break;
                }
                K bXh = this.iqb.bXh();
                this.iqb.remove(bXh);
                arrayList.add(this.iqc.remove(bXh));
            }
        }
        return arrayList;
    }

    private void aD(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i(it.next()));
            }
        }
    }

    private void aE(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.iqn != null) {
            bVar.iqn.c(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.iqn != null) {
            bVar.iqn.c(bVar.key, true);
        }
    }

    private synchronized void aF(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.iqm ? false : true);
            bVar.iqm = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.iqm);
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
        return (bVar.iqm && bVar.clientCount == 0) ? bVar.iql : null;
    }

    public synchronized int bXk() {
        return this.iqc.getCount() - this.iqb.getCount();
    }

    public synchronized int bXl() {
        return this.iqc.getSizeInBytes() - this.iqb.getSizeInBytes();
    }
}

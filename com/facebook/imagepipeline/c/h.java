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
    static final long icK = TimeUnit.MINUTES.toMillis(5);
    private final ac<V> icH;
    @GuardedBy("this")
    final g<K, b<K, V>> icL;
    @GuardedBy("this")
    final g<K, b<K, V>> icM;
    private final a icO;
    private final com.facebook.common.internal.i<u> icP;
    @GuardedBy("this")
    protected u icQ;
    @GuardedBy("this")
    final Map<Bitmap, Object> icN = new WeakHashMap();
    @GuardedBy("this")
    private long icR = SystemClock.uptimeMillis();

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
        public final com.facebook.common.references.a<V> icV;
        @Nullable
        public final c<K> icX;
        public final K key;
        public int clientCount = 0;
        public boolean icW = false;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.icV = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.icX = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(ac<V> acVar, a aVar, com.facebook.common.internal.i<u> iVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        this.icH = acVar;
        this.icL = new g<>(a(acVar));
        this.icM = new g<>(a(acVar));
        this.icO = aVar;
        this.icP = iVar;
        this.icQ = this.icP.get();
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
                return acVar.aD(bVar.icV.get());
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
        bUj();
        synchronized (this) {
            remove = this.icL.remove(k);
            b<K, V> remove2 = this.icM.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (aG(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.icM.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
        d(remove);
        bUk();
        return aVar3;
    }

    private synchronized boolean aG(V v) {
        boolean z;
        int aD = this.icH.aD(v);
        if (aD <= this.icQ.idm && bUl() <= this.icQ.idi - 1) {
            z = bUm() <= this.icQ.idh - aD;
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
            remove = this.icL.remove(k);
            b<K, V> bVar = this.icM.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        bUj();
        bUk();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.icV.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.3
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
        bUj();
        bUk();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.icW || bVar.clientCount != 0) {
            z = false;
        } else {
            this.icL.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.t
    public synchronized boolean b(Predicate<K> predicate) {
        return !this.icM.a(predicate).isEmpty();
    }

    private synchronized void bUj() {
        if (this.icR + icK <= SystemClock.uptimeMillis()) {
            this.icR = SystemClock.uptimeMillis();
            this.icQ = this.icP.get();
        }
    }

    private void bUk() {
        ArrayList<b<K, V>> ce;
        synchronized (this) {
            ce = ce(Math.min(this.icQ.idk, this.icQ.idi - bUl()), Math.min(this.icQ.idj, this.icQ.idh - bUm()));
            aF(ce);
        }
        aD(ce);
        aE(ce);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> ce(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.icL.getCount() <= max && this.icL.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.icL.getCount() <= max && this.icL.getSizeInBytes() <= max2) {
                    break;
                }
                K bUi = this.icL.bUi();
                this.icL.remove(bUi);
                arrayList.add(this.icM.remove(bUi));
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
        if (bVar != null && bVar.icX != null) {
            bVar.icX.c(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.icX != null) {
            bVar.icX.c(bVar.key, true);
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
            com.facebook.common.internal.g.checkState(bVar.icW ? false : true);
            bVar.icW = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.icW);
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
        return (bVar.icW && bVar.clientCount == 0) ? bVar.icV : null;
    }

    public synchronized int bUl() {
        return this.icM.getCount() - this.icL.getCount();
    }

    public synchronized int bUm() {
        return this.icM.getSizeInBytes() - this.icL.getSizeInBytes();
    }
}

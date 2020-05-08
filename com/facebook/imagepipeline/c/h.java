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
/* loaded from: classes13.dex */
public class h<K, V> implements com.facebook.common.memory.b, p<K, V> {
    static final long maC = TimeUnit.MINUTES.toMillis(5);
    @GuardedBy("this")
    final g<K, b<K, V>> maD;
    @GuardedBy("this")
    final g<K, b<K, V>> maE;
    private final a maG;
    private final com.facebook.common.internal.j<q> maH;
    @GuardedBy("this")
    protected q maI;
    private final v<V> maz;
    @GuardedBy("this")
    final Map<Bitmap, Object> maF = new WeakHashMap();
    @GuardedBy("this")
    private long maJ = SystemClock.uptimeMillis();

    /* loaded from: classes13.dex */
    public interface a {
        double b(MemoryTrimType memoryTrimType);
    }

    /* loaded from: classes13.dex */
    public interface c<K> {
        void d(K k, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class b<K, V> {
        public final K key;
        public final com.facebook.common.references.a<V> maN;
        public int maO = 0;
        public boolean maP = false;
        @Nullable
        public final c<K> maQ;

        private b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            this.key = (K) com.facebook.common.internal.g.checkNotNull(k);
            this.maN = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(com.facebook.common.references.a.b(aVar));
            this.maQ = cVar;
        }

        static <K, V> b<K, V> b(K k, com.facebook.common.references.a<V> aVar, @Nullable c<K> cVar) {
            return new b<>(k, aVar, cVar);
        }
    }

    public h(v<V> vVar, a aVar, com.facebook.common.internal.j<q> jVar) {
        this.maz = vVar;
        this.maD = new g<>(a(vVar));
        this.maE = new g<>(a(vVar));
        this.maG = aVar;
        this.maH = jVar;
        this.maI = this.maH.get();
    }

    private v<b<K, V>> a(final v<V> vVar) {
        return new v<b<K, V>>() { // from class: com.facebook.imagepipeline.c.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: j */
            public int ba(b<K, V> bVar) {
                return vVar.ba(bVar.maN.get());
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
        dqn();
        synchronized (this) {
            remove = this.maD.remove(k);
            b<K, V> remove2 = this.maE.remove(k);
            if (remove2 != null) {
                f(remove2);
                aVar2 = i(remove2);
            } else {
                aVar2 = null;
            }
            if (bd(aVar.get())) {
                b<K, V> b2 = b.b(k, aVar, cVar);
                this.maE.put(k, b2);
                aVar3 = a(b2);
            } else {
                aVar3 = null;
            }
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
        d(remove);
        dqo();
        return aVar3;
    }

    private synchronized boolean bd(V v) {
        boolean z;
        int ba = this.maz.ba(v);
        if (ba <= this.maI.maY && dqp() <= this.maI.maV - 1) {
            z = dqq() <= this.maI.maU - ba;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.c.p
    @Nullable
    public com.facebook.common.references.a<V> be(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.maD.remove(k);
            b<K, V> bVar = this.maE.get(k);
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = a(bVar);
            }
        }
        d(remove);
        dqn();
        dqo();
        return aVar;
    }

    private synchronized com.facebook.common.references.a<V> a(final b<K, V> bVar) {
        g(bVar);
        return com.facebook.common.references.a.a(bVar.maN.get(), new com.facebook.common.references.c<V>() { // from class: com.facebook.imagepipeline.c.h.2
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
        dqn();
        dqo();
    }

    private synchronized boolean c(b<K, V> bVar) {
        boolean z;
        if (bVar.maP || bVar.maO != 0) {
            z = false;
        } else {
            this.maD.put(bVar.key, bVar);
            z = true;
        }
        return z;
    }

    @Nullable
    public com.facebook.common.references.a<V> bf(K k) {
        b<K, V> remove;
        com.facebook.common.references.a<V> aVar;
        boolean z;
        com.facebook.common.internal.g.checkNotNull(k);
        synchronized (this) {
            remove = this.maD.remove(k);
            if (remove == null) {
                aVar = null;
                z = false;
            } else {
                b<K, V> remove2 = this.maE.remove(k);
                com.facebook.common.internal.g.checkNotNull(remove2);
                com.facebook.common.internal.g.checkState(remove2.maO == 0);
                aVar = remove2.maN;
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
        return !this.maE.a(hVar).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.maE.contains(k);
    }

    @Override // com.facebook.common.memory.b
    public void a(MemoryTrimType memoryTrimType) {
        ArrayList<b<K, V>> di;
        double b2 = this.maG.b(memoryTrimType);
        synchronized (this) {
            di = di(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Math.max(0, ((int) ((1.0d - b2) * this.maE.getSizeInBytes())) - dqq()));
            bb(di);
        }
        aZ(di);
        ba(di);
        dqn();
        dqo();
    }

    private synchronized void dqn() {
        if (this.maJ + maC <= SystemClock.uptimeMillis()) {
            this.maJ = SystemClock.uptimeMillis();
            this.maI = this.maH.get();
        }
    }

    private void dqo() {
        ArrayList<b<K, V>> di;
        synchronized (this) {
            di = di(Math.min(this.maI.maX, this.maI.maV - dqp()), Math.min(this.maI.maW, this.maI.maU - dqq()));
            bb(di);
        }
        aZ(di);
        ba(di);
    }

    @Nullable
    private synchronized ArrayList<b<K, V>> di(int i, int i2) {
        ArrayList<b<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.maD.getCount() <= max && this.maD.getSizeInBytes() <= max2) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            while (true) {
                if (this.maD.getCount() <= max && this.maD.getSizeInBytes() <= max2) {
                    break;
                }
                K dqm = this.maD.dqm();
                this.maD.remove(dqm);
                arrayList.add(this.maE.remove(dqm));
            }
        }
        return arrayList;
    }

    private void aZ(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) i(it.next()));
            }
        }
    }

    private void ba(@Nullable ArrayList<b<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<b<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    private static <K, V> void d(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.maQ != null) {
            bVar.maQ.d(bVar.key, false);
        }
    }

    private static <K, V> void e(@Nullable b<K, V> bVar) {
        if (bVar != null && bVar.maQ != null) {
            bVar.maQ.d(bVar.key, true);
        }
    }

    private synchronized void bb(@Nullable ArrayList<b<K, V>> arrayList) {
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
            com.facebook.common.internal.g.checkState(bVar.maP ? false : true);
            bVar.maP = true;
        }
    }

    private synchronized void g(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(!bVar.maP);
        bVar.maO++;
    }

    private synchronized void h(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkState(bVar.maO > 0);
        bVar.maO--;
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> i(b<K, V> bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        return (bVar.maP && bVar.maO == 0) ? bVar.maN : null;
    }

    public synchronized int dqp() {
        return this.maE.getCount() - this.maD.getCount();
    }

    public synchronized int dqq() {
        return this.maE.getSizeInBytes() - this.maD.getSizeInBytes();
    }
}

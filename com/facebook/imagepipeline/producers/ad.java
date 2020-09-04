package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.common.Priority;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> nyd;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> nzh = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.nyd = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bs;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bs = bs(b);
                if (bs == null) {
                    bs = bt(b);
                    z = true;
                }
            }
        } while (!bs.f(kVar, akVar));
        if (!z) {
            return;
        }
        bs.dVX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bs(K k) {
        return this.nzh.get(k);
    }

    private synchronized ad<K, T>.a bt(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.nzh.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.nzh.get(k) == aVar) {
            this.nzh.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> nzi = com.facebook.common.internal.i.dOI();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T nzj;
        @GuardedBy("Multiplexer.this")
        private float nzk;
        @GuardedBy("Multiplexer.this")
        private int nzl;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d nzm;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0876a nzn;
        private final K yC;

        public a(K k) {
            this.yC = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bs(this.yC) != this) {
                    return false;
                }
                this.nzi.add(create);
                List<al> dVY = dVY();
                List<al> dWc = dWc();
                List<al> dWa = dWa();
                Closeable closeable = this.nzj;
                float f = this.nzk;
                int i = this.nzl;
                d.fL(dVY);
                d.fN(dWc);
                d.fM(dWa);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.nzj) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aD(f);
                        }
                        kVar.h(closeable, i);
                        closeSafely(closeable);
                    }
                }
                a(create, akVar);
                return true;
            }
        }

        private void a(final Pair<k<T>, ak> pair, ak akVar) {
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ad.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dRP() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.nzi.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.nzi.isEmpty()) {
                            list2 = null;
                            dVar = a.this.nzm;
                            list = null;
                        } else {
                            List dVY = a.this.dVY();
                            list = a.this.dWc();
                            list2 = dVY;
                            dVar = null;
                            list3 = a.this.dWa();
                        }
                    }
                    d.fL(list2);
                    d.fN(list);
                    d.fM(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dOD();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVE() {
                    d.fL(a.this.dVY());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVF() {
                    d.fM(a.this.dWa());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVG() {
                    d.fN(a.this.dWc());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVX() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.nzm == null);
                com.facebook.common.internal.g.checkArgument(this.nzn == null);
                if (this.nzi.isEmpty()) {
                    ad.this.a((ad) this.yC, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.nzi.iterator().next().second;
                this.nzm = new d(akVar.dVx(), akVar.getId(), akVar.dVy(), akVar.dQd(), akVar.dVz(), dVZ(), dWb(), dWd());
                this.nzn = new C0876a();
                ad.this.nyd.c(this.nzn, this.nzm);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dVY() {
            return this.nzm == null ? null : this.nzm.yg(dVZ());
        }

        private synchronized boolean dVZ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nzi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dVA()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dWa() {
            List<al> yh;
            if (this.nzm == null) {
                yh = null;
            } else {
                yh = this.nzm.yh(dWb());
            }
            return yh;
        }

        private synchronized boolean dWb() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nzi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dVC()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dWc() {
            return this.nzm == null ? null : this.nzm.a(dWd());
        }

        private synchronized Priority dWd() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.nzi.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dVB());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0876a c0876a, Throwable th) {
            synchronized (this) {
                if (this.nzn == c0876a) {
                    Iterator<Pair<k<T>, ak>> it = this.nzi.iterator();
                    this.nzi.clear();
                    ad.this.a((ad) this.yC, (ad<ad, T>.a) this);
                    closeSafely(this.nzj);
                    this.nzj = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).E(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0876a c0876a, T t, int i) {
            synchronized (this) {
                if (this.nzn == c0876a) {
                    closeSafely(this.nzj);
                    this.nzj = null;
                    Iterator<Pair<k<T>, ak>> it = this.nzi.iterator();
                    if (b.Mm(i)) {
                        this.nzj = (T) ad.this.g(t);
                        this.nzl = i;
                    } else {
                        this.nzi.clear();
                        ad.this.a((ad) this.yC, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).h(t, i);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0876a c0876a) {
            synchronized (this) {
                if (this.nzn == c0876a) {
                    this.nzn = null;
                    this.nzm = null;
                    closeSafely(this.nzj);
                    this.nzj = null;
                    dVX();
                }
            }
        }

        public void a(ad<K, T>.a.C0876a c0876a, float f) {
            synchronized (this) {
                if (this.nzn == c0876a) {
                    this.nzk = f;
                    Iterator<Pair<k<T>, ak>> it = this.nzi.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aD(f);
                        }
                    }
                }
            }
        }

        private void closeSafely(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.imagepipeline.producers.ad$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0876a extends b<T> {
            private C0876a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void D(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dUi() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aS(float f) {
                a.this.a(this, f);
            }
        }
    }
}

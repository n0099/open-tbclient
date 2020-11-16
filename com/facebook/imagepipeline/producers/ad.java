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
/* loaded from: classes15.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> oZF;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> paL = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.oZF = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bC;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bC = bC(b);
                if (bC == null) {
                    bC = bD(b);
                    z = true;
                }
            }
        } while (!bC.f(kVar, akVar));
        if (!z) {
            return;
        }
        bC.ert();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bC(K k) {
        return this.paL.get(k);
    }

    private synchronized ad<K, T>.a bD(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.paL.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.paL.get(k) == aVar) {
            this.paL.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> paM = com.facebook.common.internal.i.ekc();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T paN;
        @GuardedBy("Multiplexer.this")
        private float paO;
        @GuardedBy("Multiplexer.this")
        private int paP;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d paQ;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0985a paR;
        private final K yT;

        public a(K k) {
            this.yT = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bC(this.yT) != this) {
                    return false;
                }
                this.paM.add(create);
                List<al> eru = eru();
                List<al> ery = ery();
                List<al> erw = erw();
                Closeable closeable = this.paN;
                float f = this.paO;
                int i = this.paP;
                d.gC(eru);
                d.gE(ery);
                d.gD(erw);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.paN) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aU(f);
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
                public void enk() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.paM.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.paM.isEmpty()) {
                            list2 = null;
                            dVar = a.this.paQ;
                            list = null;
                        } else {
                            List eru = a.this.eru();
                            list = a.this.ery();
                            list2 = eru;
                            dVar = null;
                            list3 = a.this.erw();
                        }
                    }
                    d.gC(list2);
                    d.gE(list);
                    d.gD(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).ejX();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void era() {
                    d.gC(a.this.eru());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void erb() {
                    d.gD(a.this.erw());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void erc() {
                    d.gE(a.this.ery());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ert() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.paQ == null);
                com.facebook.common.internal.g.checkArgument(this.paR == null);
                if (this.paM.isEmpty()) {
                    ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.paM.iterator().next().second;
                this.paQ = new d(akVar.eqT(), akVar.getId(), akVar.eqU(), akVar.elx(), akVar.eqV(), erv(), erx(), erz());
                this.paR = new C0985a();
                ad.this.oZF.c(this.paR, this.paQ);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eru() {
            return this.paQ == null ? null : this.paQ.Aw(erv());
        }

        private synchronized boolean erv() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.paM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).eqW()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> erw() {
            List<al> Ax;
            if (this.paQ == null) {
                Ax = null;
            } else {
                Ax = this.paQ.Ax(erx());
            }
            return Ax;
        }

        private synchronized boolean erx() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.paM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).eqY()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ery() {
            return this.paQ == null ? null : this.paQ.a(erz());
        }

        private synchronized Priority erz() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.paM.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).eqX());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0985a c0985a, Throwable th) {
            synchronized (this) {
                if (this.paR == c0985a) {
                    Iterator<Pair<k<T>, ak>> it = this.paM.iterator();
                    this.paM.clear();
                    ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    closeSafely(this.paN);
                    this.paN = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).E(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0985a c0985a, T t, int i) {
            synchronized (this) {
                if (this.paR == c0985a) {
                    closeSafely(this.paN);
                    this.paN = null;
                    Iterator<Pair<k<T>, ak>> it = this.paM.iterator();
                    if (b.Qm(i)) {
                        this.paN = (T) ad.this.g(t);
                        this.paP = i;
                    } else {
                        this.paM.clear();
                        ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C0985a c0985a) {
            synchronized (this) {
                if (this.paR == c0985a) {
                    this.paR = null;
                    this.paQ = null;
                    closeSafely(this.paN);
                    this.paN = null;
                    ert();
                }
            }
        }

        public void a(ad<K, T>.a.C0985a c0985a, float f) {
            synchronized (this) {
                if (this.paR == c0985a) {
                    this.paO = f;
                    Iterator<Pair<k<T>, ak>> it = this.paM.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aU(f);
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
        /* loaded from: classes15.dex */
        public class C0985a extends b<T> {
            private C0985a() {
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
            protected void epE() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void by(float f) {
                a.this.a(this, f);
            }
        }
    }
}

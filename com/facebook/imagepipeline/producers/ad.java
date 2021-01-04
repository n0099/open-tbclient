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
/* loaded from: classes5.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> pDZ;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> pFe = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T h(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.pDZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bA;
        K b2 = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bA = bA(b2);
                if (bA == null) {
                    bA = bB(b2);
                    z = true;
                }
            }
        } while (!bA.e(kVar, akVar));
        if (!z) {
            return;
        }
        bA.eAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bA(K k) {
        return this.pFe.get(k);
    }

    private synchronized ad<K, T>.a bB(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.pFe.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.pFe.get(k) == aVar) {
            this.pFe.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        private final K mKey;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> pFf = com.facebook.common.internal.i.etV();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T pFg;
        @GuardedBy("Multiplexer.this")
        private float pFh;
        @GuardedBy("Multiplexer.this")
        private int pFi;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d pFj;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C1026a pFk;

        public a(K k) {
            this.mKey = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean e(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bA(this.mKey) != this) {
                    return false;
                }
                this.pFf.add(create);
                List<al> eAE = eAE();
                List<al> eAI = eAI();
                List<al> eAG = eAG();
                Closeable closeable = this.pFg;
                float f = this.pFh;
                int i = this.pFi;
                d.gN(eAE);
                d.gP(eAI);
                d.gO(eAG);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.pFg) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.h(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aX(f);
                        }
                        kVar.g(closeable, i);
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
                public void eAk() {
                    boolean remove;
                    List list;
                    List list2;
                    List list3;
                    d dVar;
                    synchronized (a.this) {
                        remove = a.this.pFf.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            list3 = null;
                            dVar = null;
                        } else if (a.this.pFf.isEmpty()) {
                            dVar = a.this.pFj;
                            list = null;
                            list2 = null;
                            list3 = null;
                        } else {
                            list3 = a.this.eAE();
                            list2 = a.this.eAI();
                            list = a.this.eAG();
                            dVar = null;
                        }
                    }
                    d.gN(list3);
                    d.gP(list2);
                    d.gO(list);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).etQ();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAl() {
                    d.gN(a.this.eAE());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAm() {
                    d.gO(a.this.eAG());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAn() {
                    d.gP(a.this.eAI());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eAD() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.pFj == null);
                com.facebook.common.internal.g.checkArgument(this.pFk == null);
                if (this.pFf.isEmpty()) {
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.pFf.iterator().next().second;
                this.pFj = new d(akVar.eAd(), akVar.getId(), akVar.eAe(), akVar.evp(), akVar.eAf(), eAF(), eAH(), eAJ());
                this.pFk = new C1026a();
                ad.this.pDZ.a(this.pFk, this.pFj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eAE() {
            return this.pFj == null ? null : this.pFj.Bf(eAF());
        }

        private synchronized boolean eAF() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pFf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).eAg()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eAG() {
            List<al> Bg;
            if (this.pFj == null) {
                Bg = null;
            } else {
                Bg = this.pFj.Bg(eAH());
            }
            return Bg;
        }

        private synchronized boolean eAH() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pFf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).eAi()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eAI() {
            return this.pFj == null ? null : this.pFj.a(eAJ());
        }

        private synchronized Priority eAJ() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.pFf.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).eAh());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C1026a c1026a, Throwable th) {
            synchronized (this) {
                if (this.pFk == c1026a) {
                    Iterator<Pair<k<T>, ak>> it = this.pFf.iterator();
                    this.pFf.clear();
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    closeSafely(this.pFg);
                    this.pFg = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).D(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1026a c1026a, T t, int i) {
            synchronized (this) {
                if (this.pFk == c1026a) {
                    closeSafely(this.pFg);
                    this.pFg = null;
                    Iterator<Pair<k<T>, ak>> it = this.pFf.iterator();
                    if (b.Rg(i)) {
                        this.pFg = (T) ad.this.h(t);
                        this.pFi = i;
                    } else {
                        this.pFf.clear();
                        ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).g(t, i);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1026a c1026a) {
            synchronized (this) {
                if (this.pFk == c1026a) {
                    this.pFk = null;
                    this.pFj = null;
                    closeSafely(this.pFg);
                    this.pFg = null;
                    eAD();
                }
            }
        }

        public void a(ad<K, T>.a.C1026a c1026a, float f) {
            synchronized (this) {
                if (this.pFk == c1026a) {
                    this.pFh = f;
                    Iterator<Pair<k<T>, ak>> it = this.pFf.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aX(f);
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
        /* loaded from: classes5.dex */
        public class C1026a extends b<T> {
            private C1026a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void C(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void eyT() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bK(float f) {
                a.this.a(this, f);
            }
        }
    }
}

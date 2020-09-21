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
/* loaded from: classes25.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> nIa;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> nJe = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.nIa = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bu;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bu = bu(b);
                if (bu == null) {
                    bu = bv(b);
                    z = true;
                }
            }
        } while (!bu.f(kVar, akVar));
        if (!z) {
            return;
        }
        bu.dZV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bu(K k) {
        return this.nJe.get(k);
    }

    private synchronized ad<K, T>.a bv(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.nJe.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.nJe.get(k) == aVar) {
            this.nJe.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> nJf = com.facebook.common.internal.i.dSG();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T nJg;
        @GuardedBy("Multiplexer.this")
        private float nJh;
        @GuardedBy("Multiplexer.this")
        private int nJi;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d nJj;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0873a nJk;
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
                if (ad.this.bu(this.yC) != this) {
                    return false;
                }
                this.nJf.add(create);
                List<al> dZW = dZW();
                List<al> eaa = eaa();
                List<al> dZY = dZY();
                Closeable closeable = this.nJg;
                float f = this.nJh;
                int i = this.nJi;
                d.fU(dZW);
                d.fW(eaa);
                d.fV(dZY);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.nJg) {
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
                public void dVN() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.nJf.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.nJf.isEmpty()) {
                            list2 = null;
                            dVar = a.this.nJj;
                            list = null;
                        } else {
                            List dZW = a.this.dZW();
                            list = a.this.eaa();
                            list2 = dZW;
                            dVar = null;
                            list3 = a.this.dZY();
                        }
                    }
                    d.fU(list2);
                    d.fW(list);
                    d.fV(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dSB();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dZC() {
                    d.fU(a.this.dZW());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dZD() {
                    d.fV(a.this.dZY());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dZE() {
                    d.fW(a.this.eaa());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dZV() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.nJj == null);
                com.facebook.common.internal.g.checkArgument(this.nJk == null);
                if (this.nJf.isEmpty()) {
                    ad.this.a((ad) this.yC, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.nJf.iterator().next().second;
                this.nJj = new d(akVar.dZv(), akVar.getId(), akVar.dZw(), akVar.dUb(), akVar.dZx(), dZX(), dZZ(), eab());
                this.nJk = new C0873a();
                ad.this.nIa.c(this.nJk, this.nJj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dZW() {
            return this.nJj == null ? null : this.nJj.yp(dZX());
        }

        private synchronized boolean dZX() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nJf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dZy()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dZY() {
            List<al> yq;
            if (this.nJj == null) {
                yq = null;
            } else {
                yq = this.nJj.yq(dZZ());
            }
            return yq;
        }

        private synchronized boolean dZZ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nJf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dZA()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eaa() {
            return this.nJj == null ? null : this.nJj.a(eab());
        }

        private synchronized Priority eab() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.nJf.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dZz());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0873a c0873a, Throwable th) {
            synchronized (this) {
                if (this.nJk == c0873a) {
                    Iterator<Pair<k<T>, ak>> it = this.nJf.iterator();
                    this.nJf.clear();
                    ad.this.a((ad) this.yC, (ad<ad, T>.a) this);
                    closeSafely(this.nJg);
                    this.nJg = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).E(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0873a c0873a, T t, int i) {
            synchronized (this) {
                if (this.nJk == c0873a) {
                    closeSafely(this.nJg);
                    this.nJg = null;
                    Iterator<Pair<k<T>, ak>> it = this.nJf.iterator();
                    if (b.MR(i)) {
                        this.nJg = (T) ad.this.g(t);
                        this.nJi = i;
                    } else {
                        this.nJf.clear();
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

        public void a(ad<K, T>.a.C0873a c0873a) {
            synchronized (this) {
                if (this.nJk == c0873a) {
                    this.nJk = null;
                    this.nJj = null;
                    closeSafely(this.nJg);
                    this.nJg = null;
                    dZV();
                }
            }
        }

        public void a(ad<K, T>.a.C0873a c0873a, float f) {
            synchronized (this) {
                if (this.nJk == c0873a) {
                    this.nJh = f;
                    Iterator<Pair<k<T>, ak>> it = this.nJf.iterator();
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
        /* loaded from: classes25.dex */
        public class C0873a extends b<T> {
            private C0873a() {
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
            protected void dYg() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aS(float f) {
                a.this.a(this, f);
            }
        }
    }
}

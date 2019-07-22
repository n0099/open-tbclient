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
/* loaded from: classes2.dex */
public abstract class ad<K, T extends Closeable> implements ai<T> {
    private final ai<T> kjj;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> kkr = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.kjj = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a bb;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                bb = bb(b);
                if (bb == null) {
                    bb = bc(b);
                    z = true;
                }
            }
        } while (!bb.f(jVar, ajVar));
        if (!z) {
            return;
        }
        bb.cKZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bb(K k) {
        return this.kkr.get(k);
    }

    private synchronized ad<K, T>.a bc(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.kkr.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.kkr.get(k) == aVar) {
            this.kkr.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final K jo;
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> kks = com.facebook.common.internal.h.cEE();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T kkt;
        @GuardedBy("Multiplexer.this")
        private float kku;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d kkv;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0454a kkw;

        public a(K k) {
            this.jo = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.facebook.imagepipeline.producers.j<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(j<T> jVar, aj ajVar) {
            Pair<j<T>, aj> create = Pair.create(jVar, ajVar);
            synchronized (this) {
                if (ad.this.bb(this.jo) != this) {
                    return false;
                }
                this.kks.add(create);
                List<ak> cLa = cLa();
                List<ak> cLe = cLe();
                List<ak> cLc = cLc();
                Closeable closeable = this.kkt;
                float f = this.kku;
                d.eI(cLa);
                d.eK(cLe);
                d.eJ(cLc);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.kkt) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.f(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.aR(f);
                        }
                        jVar.e(closeable, false);
                        c(closeable);
                    }
                }
                a(create, ajVar);
                return true;
            }
        }

        private void a(final Pair<j<T>, aj> pair, aj ajVar) {
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ad.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKI() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.kks.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.kks.isEmpty()) {
                            list2 = null;
                            dVar = a.this.kkv;
                            list = null;
                        } else {
                            List cLa = a.this.cLa();
                            list = a.this.cLe();
                            list2 = cLa;
                            dVar = null;
                            list3 = a.this.cLc();
                        }
                    }
                    d.eI(list2);
                    d.eK(list);
                    d.eJ(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).cEA();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKJ() {
                    d.eI(a.this.cLa());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKK() {
                    d.eJ(a.this.cLc());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKL() {
                    d.eK(a.this.cLe());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cKZ() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.kkv == null);
                com.facebook.common.internal.g.checkArgument(this.kkw == null);
                if (this.kks.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.kks.iterator().next().second;
                this.kkv = new d(ajVar.cKB(), ajVar.getId(), ajVar.cKC(), ajVar.cFU(), ajVar.cKD(), cLb(), cLd(), cLf());
                this.kkw = new C0454a();
                ad.this.kjj.a(this.kkw, this.kkv);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cLa() {
            return this.kkv == null ? null : this.kkv.sA(cLb());
        }

        private synchronized boolean cLb() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cKE()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cLc() {
            List<ak> sB;
            if (this.kkv == null) {
                sB = null;
            } else {
                sB = this.kkv.sB(cLd());
            }
            return sB;
        }

        private synchronized boolean cLd() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cKG()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cLe() {
            return this.kkv == null ? null : this.kkv.a(cLf());
        }

        private synchronized Priority cLf() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.kks.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cKF());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0454a c0454a, Throwable th) {
            synchronized (this) {
                if (this.kkw == c0454a) {
                    Iterator<Pair<j<T>, aj>> it = this.kks.iterator();
                    this.kks.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.kkt);
                    this.kkt = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0454a c0454a, T t, boolean z) {
            synchronized (this) {
                if (this.kkw == c0454a) {
                    c(this.kkt);
                    this.kkt = null;
                    Iterator<Pair<j<T>, aj>> it = this.kks.iterator();
                    if (!z) {
                        this.kkt = (T) ad.this.f(t);
                    } else {
                        this.kks.clear();
                        ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).e(t, z);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0454a c0454a) {
            synchronized (this) {
                if (this.kkw == c0454a) {
                    this.kkw = null;
                    this.kkv = null;
                    c(this.kkt);
                    this.kkt = null;
                    cKZ();
                }
            }
        }

        public void a(ad<K, T>.a.C0454a c0454a, float f) {
            synchronized (this) {
                if (this.kkw == c0454a) {
                    this.kku = f;
                    Iterator<Pair<j<T>, aj>> it = this.kks.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).aR(f);
                        }
                    }
                }
            }
        }

        private void c(Closeable closeable) {
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
        /* loaded from: classes2.dex */
        public class C0454a extends b<T> {
            private C0454a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: b */
            public void d(T t, boolean z) {
                a.this.a(this, t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void A(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cJv() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bf(float f) {
                a.this.a(this, f);
            }
        }
    }
}

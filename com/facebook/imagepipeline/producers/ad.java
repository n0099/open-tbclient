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
    private final ai<T> kkp;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> klx = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.kkp = aiVar;
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
        bb.cLu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bb(K k) {
        return this.klx.get(k);
    }

    private synchronized ad<K, T>.a bc(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.klx.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.klx.get(k) == aVar) {
            this.klx.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final K jo;
        @GuardedBy("Multiplexer.this")
        private float klA;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d klB;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0460a klC;
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> kly = com.facebook.common.internal.h.cEZ();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T klz;

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
                this.kly.add(create);
                List<ak> cLv = cLv();
                List<ak> cLz = cLz();
                List<ak> cLx = cLx();
                Closeable closeable = this.klz;
                float f = this.klA;
                d.eH(cLv);
                d.eJ(cLz);
                d.eI(cLx);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.klz) {
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
                public void cLd() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.kly.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.kly.isEmpty()) {
                            list2 = null;
                            dVar = a.this.klB;
                            list = null;
                        } else {
                            List cLv = a.this.cLv();
                            list = a.this.cLz();
                            list2 = cLv;
                            dVar = null;
                            list3 = a.this.cLx();
                        }
                    }
                    d.eH(list2);
                    d.eJ(list);
                    d.eI(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).cEV();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLe() {
                    d.eH(a.this.cLv());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLf() {
                    d.eI(a.this.cLx());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLg() {
                    d.eJ(a.this.cLz());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cLu() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.klB == null);
                com.facebook.common.internal.g.checkArgument(this.klC == null);
                if (this.kly.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.kly.iterator().next().second;
                this.klB = new d(ajVar.cKW(), ajVar.getId(), ajVar.cKX(), ajVar.cGp(), ajVar.cKY(), cLw(), cLy(), cLA());
                this.klC = new C0460a();
                ad.this.kkp.a(this.klC, this.klB);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cLv() {
            return this.klB == null ? null : this.klB.sB(cLw());
        }

        private synchronized boolean cLw() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kly.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cKZ()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cLx() {
            List<ak> sC;
            if (this.klB == null) {
                sC = null;
            } else {
                sC = this.klB.sC(cLy());
            }
            return sC;
        }

        private synchronized boolean cLy() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kly.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cLb()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cLz() {
            return this.klB == null ? null : this.klB.a(cLA());
        }

        private synchronized Priority cLA() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.kly.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cLa());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0460a c0460a, Throwable th) {
            synchronized (this) {
                if (this.klC == c0460a) {
                    Iterator<Pair<j<T>, aj>> it = this.kly.iterator();
                    this.kly.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.klz);
                    this.klz = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0460a c0460a, T t, boolean z) {
            synchronized (this) {
                if (this.klC == c0460a) {
                    c(this.klz);
                    this.klz = null;
                    Iterator<Pair<j<T>, aj>> it = this.kly.iterator();
                    if (!z) {
                        this.klz = (T) ad.this.f(t);
                    } else {
                        this.kly.clear();
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

        public void a(ad<K, T>.a.C0460a c0460a) {
            synchronized (this) {
                if (this.klC == c0460a) {
                    this.klC = null;
                    this.klB = null;
                    c(this.klz);
                    this.klz = null;
                    cLu();
                }
            }
        }

        public void a(ad<K, T>.a.C0460a c0460a, float f) {
            synchronized (this) {
                if (this.klC == c0460a) {
                    this.klA = f;
                    Iterator<Pair<j<T>, aj>> it = this.kly.iterator();
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
        public class C0460a extends b<T> {
            private C0460a() {
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
            protected void cJQ() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bf(float f) {
                a.this.a(this, f);
            }
        }
    }
}

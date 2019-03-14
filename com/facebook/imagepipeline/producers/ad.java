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
    private final ai<T> jJQ;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> jKY = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.jJQ = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a bd;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                bd = bd(b);
                if (bd == null) {
                    bd = be(b);
                    z = true;
                }
            }
        } while (!bd.f(jVar, ajVar));
        if (!z) {
            return;
        }
        bd.cAf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bd(K k) {
        return this.jKY.get(k);
    }

    private synchronized ad<K, T>.a be(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.jKY.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.jKY.get(k) == aVar) {
            this.jKY.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> jKZ = com.facebook.common.internal.h.ctM();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T jLa;
        @GuardedBy("Multiplexer.this")
        private float jLb;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d jLc;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0436a jLd;
        private final K jo;

        public a(K k) {
            this.jo = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.facebook.imagepipeline.producers.j<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(j<T> jVar, aj ajVar) {
            Pair<j<T>, aj> create = Pair.create(jVar, ajVar);
            synchronized (this) {
                if (ad.this.bd(this.jo) != this) {
                    return false;
                }
                this.jKZ.add(create);
                List<ak> cAg = cAg();
                List<ak> cAk = cAk();
                List<ak> cAi = cAi();
                Closeable closeable = this.jLa;
                float f = this.jLb;
                d.eA(cAg);
                d.eC(cAk);
                d.eB(cAi);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.jLa) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.f(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.aM(f);
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
                public void czO() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.jKZ.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.jKZ.isEmpty()) {
                            list2 = null;
                            dVar = a.this.jLc;
                            list = null;
                        } else {
                            List cAg = a.this.cAg();
                            list = a.this.cAk();
                            list2 = cAg;
                            dVar = null;
                            list3 = a.this.cAi();
                        }
                    }
                    d.eA(list2);
                    d.eC(list);
                    d.eB(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).ctI();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czP() {
                    d.eA(a.this.cAg());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czQ() {
                    d.eB(a.this.cAi());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czR() {
                    d.eC(a.this.cAk());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cAf() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.jLc == null);
                com.facebook.common.internal.g.checkArgument(this.jLd == null);
                if (this.jKZ.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.jKZ.iterator().next().second;
                this.jLc = new d(ajVar.czH(), ajVar.getId(), ajVar.czI(), ajVar.cvd(), ajVar.czJ(), cAh(), cAj(), cAl());
                this.jLd = new C0436a();
                ad.this.jJQ.a(this.jLd, this.jLc);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cAg() {
            return this.jLc == null ? null : this.jLc.rv(cAh());
        }

        private synchronized boolean cAh() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.jKZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).czK()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cAi() {
            List<ak> rw;
            if (this.jLc == null) {
                rw = null;
            } else {
                rw = this.jLc.rw(cAj());
            }
            return rw;
        }

        private synchronized boolean cAj() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.jKZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).czM()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cAk() {
            return this.jLc == null ? null : this.jLc.a(cAl());
        }

        private synchronized Priority cAl() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.jKZ.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).czL());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0436a c0436a, Throwable th) {
            synchronized (this) {
                if (this.jLd == c0436a) {
                    Iterator<Pair<j<T>, aj>> it = this.jKZ.iterator();
                    this.jKZ.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.jLa);
                    this.jLa = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0436a c0436a, T t, boolean z) {
            synchronized (this) {
                if (this.jLd == c0436a) {
                    c(this.jLa);
                    this.jLa = null;
                    Iterator<Pair<j<T>, aj>> it = this.jKZ.iterator();
                    if (!z) {
                        this.jLa = (T) ad.this.f(t);
                    } else {
                        this.jKZ.clear();
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

        public void a(ad<K, T>.a.C0436a c0436a) {
            synchronized (this) {
                if (this.jLd == c0436a) {
                    this.jLd = null;
                    this.jLc = null;
                    c(this.jLa);
                    this.jLa = null;
                    cAf();
                }
            }
        }

        public void a(ad<K, T>.a.C0436a c0436a, float f) {
            synchronized (this) {
                if (this.jLd == c0436a) {
                    this.jLb = f;
                    Iterator<Pair<j<T>, aj>> it = this.jKZ.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).aM(f);
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
        public class C0436a extends b<T> {
            private C0436a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: b */
            public void d(T t, boolean z) {
                a.this.a(this, t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cyC() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void ba(float f) {
                a.this.a(this, f);
            }
        }
    }
}

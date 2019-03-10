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
    private final ai<T> jJY;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> jLg = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.jJY = aiVar;
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
        bd.cAc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bd(K k) {
        return this.jLg.get(k);
    }

    private synchronized ad<K, T>.a be(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.jLg.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.jLg.get(k) == aVar) {
            this.jLg.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> jLh = com.facebook.common.internal.h.ctJ();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T jLi;
        @GuardedBy("Multiplexer.this")
        private float jLj;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d jLk;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0343a jLl;
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
                this.jLh.add(create);
                List<ak> cAd = cAd();
                List<ak> cAh = cAh();
                List<ak> cAf = cAf();
                Closeable closeable = this.jLi;
                float f = this.jLj;
                d.eA(cAd);
                d.eC(cAh);
                d.eB(cAf);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.jLi) {
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
                public void czL() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.jLh.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.jLh.isEmpty()) {
                            list2 = null;
                            dVar = a.this.jLk;
                            list = null;
                        } else {
                            List cAd = a.this.cAd();
                            list = a.this.cAh();
                            list2 = cAd;
                            dVar = null;
                            list3 = a.this.cAf();
                        }
                    }
                    d.eA(list2);
                    d.eC(list);
                    d.eB(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).ctF();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czM() {
                    d.eA(a.this.cAd());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czN() {
                    d.eB(a.this.cAf());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czO() {
                    d.eC(a.this.cAh());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cAc() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.jLk == null);
                com.facebook.common.internal.g.checkArgument(this.jLl == null);
                if (this.jLh.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.jLh.iterator().next().second;
                this.jLk = new d(ajVar.czE(), ajVar.getId(), ajVar.czF(), ajVar.cva(), ajVar.czG(), cAe(), cAg(), cAi());
                this.jLl = new C0343a();
                ad.this.jJY.a(this.jLl, this.jLk);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cAd() {
            return this.jLk == null ? null : this.jLk.rv(cAe());
        }

        private synchronized boolean cAe() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.jLh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).czH()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cAf() {
            List<ak> rw;
            if (this.jLk == null) {
                rw = null;
            } else {
                rw = this.jLk.rw(cAg());
            }
            return rw;
        }

        private synchronized boolean cAg() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.jLh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).czJ()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cAh() {
            return this.jLk == null ? null : this.jLk.a(cAi());
        }

        private synchronized Priority cAi() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.jLh.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).czI());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0343a c0343a, Throwable th) {
            synchronized (this) {
                if (this.jLl == c0343a) {
                    Iterator<Pair<j<T>, aj>> it = this.jLh.iterator();
                    this.jLh.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.jLi);
                    this.jLi = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0343a c0343a, T t, boolean z) {
            synchronized (this) {
                if (this.jLl == c0343a) {
                    c(this.jLi);
                    this.jLi = null;
                    Iterator<Pair<j<T>, aj>> it = this.jLh.iterator();
                    if (!z) {
                        this.jLi = (T) ad.this.f(t);
                    } else {
                        this.jLh.clear();
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

        public void a(ad<K, T>.a.C0343a c0343a) {
            synchronized (this) {
                if (this.jLl == c0343a) {
                    this.jLl = null;
                    this.jLk = null;
                    c(this.jLi);
                    this.jLi = null;
                    cAc();
                }
            }
        }

        public void a(ad<K, T>.a.C0343a c0343a, float f) {
            synchronized (this) {
                if (this.jLl == c0343a) {
                    this.jLj = f;
                    Iterator<Pair<j<T>, aj>> it = this.jLh.iterator();
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
        public class C0343a extends b<T> {
            private C0343a() {
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
            protected void cyz() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void ba(float f) {
                a.this.a(this, f);
            }
        }
    }
}

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
    private final ai<T> kkh;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> klp = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.kkh = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a aW;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                aW = aW(b);
                if (aW == null) {
                    aW = aX(b);
                    z = true;
                }
            }
        } while (!aW.f(jVar, ajVar));
        if (!z) {
            return;
        }
        aW.cJd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a aW(K k) {
        return this.klp.get(k);
    }

    private synchronized ad<K, T>.a aX(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.klp.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.klp.get(k) == aVar) {
            this.klp.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final K bv;
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> klq = com.facebook.common.internal.h.cCJ();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T klr;
        @GuardedBy("Multiplexer.this")
        private float kls;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d klt;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0561a klu;

        public a(K k) {
            this.bv = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.facebook.imagepipeline.producers.j<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(j<T> jVar, aj ajVar) {
            Pair<j<T>, aj> create = Pair.create(jVar, ajVar);
            synchronized (this) {
                if (ad.this.aW(this.bv) != this) {
                    return false;
                }
                this.klq.add(create);
                List<ak> cJe = cJe();
                List<ak> cJi = cJi();
                List<ak> cJg = cJg();
                Closeable closeable = this.klr;
                float f = this.kls;
                d.eU(cJe);
                d.eW(cJi);
                d.eV(cJg);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.klr) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.e(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.av(f);
                        }
                        jVar.f(closeable, false);
                        b(closeable);
                    }
                }
                a(create, ajVar);
                return true;
            }
        }

        private void a(final Pair<j<T>, aj> pair, aj ajVar) {
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ad.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIM() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.klq.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.klq.isEmpty()) {
                            list2 = null;
                            dVar = a.this.klt;
                            list = null;
                        } else {
                            List cJe = a.this.cJe();
                            list = a.this.cJi();
                            list2 = cJe;
                            dVar = null;
                            list3 = a.this.cJg();
                        }
                    }
                    d.eU(list2);
                    d.eW(list);
                    d.eV(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).cCF();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIN() {
                    d.eU(a.this.cJe());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIO() {
                    d.eV(a.this.cJg());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIP() {
                    d.eW(a.this.cJi());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cJd() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.klt == null);
                com.facebook.common.internal.g.checkArgument(this.klu == null);
                if (this.klq.isEmpty()) {
                    ad.this.a((ad) this.bv, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.klq.iterator().next().second;
                this.klt = new d(ajVar.cIF(), ajVar.getId(), ajVar.cIG(), ajVar.cDZ(), ajVar.cIH(), cJf(), cJh(), cJj());
                this.klu = new C0561a();
                ad.this.kkh.a(this.klu, this.klt);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cJe() {
            return this.klt == null ? null : this.klt.sj(cJf());
        }

        private synchronized boolean cJf() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.klq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cII()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cJg() {
            List<ak> sk;
            if (this.klt == null) {
                sk = null;
            } else {
                sk = this.klt.sk(cJh());
            }
            return sk;
        }

        private synchronized boolean cJh() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.klq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cIK()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cJi() {
            return this.klt == null ? null : this.klt.a(cJj());
        }

        private synchronized Priority cJj() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.klq.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cIJ());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0561a c0561a, Throwable th) {
            synchronized (this) {
                if (this.klu == c0561a) {
                    Iterator<Pair<j<T>, aj>> it = this.klq.iterator();
                    this.klq.clear();
                    ad.this.a((ad) this.bv, (ad<ad, T>.a) this);
                    b(this.klr);
                    this.klr = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0561a c0561a, T t, boolean z) {
            synchronized (this) {
                if (this.klu == c0561a) {
                    b(this.klr);
                    this.klr = null;
                    Iterator<Pair<j<T>, aj>> it = this.klq.iterator();
                    if (!z) {
                        this.klr = (T) ad.this.e(t);
                    } else {
                        this.klq.clear();
                        ad.this.a((ad) this.bv, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).f(t, z);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0561a c0561a) {
            synchronized (this) {
                if (this.klu == c0561a) {
                    this.klu = null;
                    this.klt = null;
                    b(this.klr);
                    this.klr = null;
                    cJd();
                }
            }
        }

        public void a(ad<K, T>.a.C0561a c0561a, float f) {
            synchronized (this) {
                if (this.klu == c0561a) {
                    this.kls = f;
                    Iterator<Pair<j<T>, aj>> it = this.klq.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).av(f);
                        }
                    }
                }
            }
        }

        private void b(Closeable closeable) {
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
        public class C0561a extends b<T> {
            private C0561a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: b */
            public void e(T t, boolean z) {
                a.this.a(this, t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void A(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cHz() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aJ(float f) {
                a.this.a(this, f);
            }
        }
    }
}

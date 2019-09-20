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
    private final ai<T> kmM;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> knU = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.kmM = aiVar;
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
        bb.cMi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bb(K k) {
        return this.knU.get(k);
    }

    private synchronized ad<K, T>.a bc(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.knU.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.knU.get(k) == aVar) {
            this.knU.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final K jo;
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> knV = com.facebook.common.internal.h.cFN();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T knW;
        @GuardedBy("Multiplexer.this")
        private float knX;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d knY;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0471a knZ;

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
                this.knV.add(create);
                List<ak> cMj = cMj();
                List<ak> cMn = cMn();
                List<ak> cMl = cMl();
                Closeable closeable = this.knW;
                float f = this.knX;
                d.eH(cMj);
                d.eJ(cMn);
                d.eI(cMl);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.knW) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.f(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.aS(f);
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
                public void cLR() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.knV.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.knV.isEmpty()) {
                            list2 = null;
                            dVar = a.this.knY;
                            list = null;
                        } else {
                            List cMj = a.this.cMj();
                            list = a.this.cMn();
                            list2 = cMj;
                            dVar = null;
                            list3 = a.this.cMl();
                        }
                    }
                    d.eH(list2);
                    d.eJ(list);
                    d.eI(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).cFJ();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLS() {
                    d.eH(a.this.cMj());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLT() {
                    d.eI(a.this.cMl());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLU() {
                    d.eJ(a.this.cMn());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cMi() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.knY == null);
                com.facebook.common.internal.g.checkArgument(this.knZ == null);
                if (this.knV.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.knV.iterator().next().second;
                this.knY = new d(ajVar.cLK(), ajVar.getId(), ajVar.cLL(), ajVar.cHd(), ajVar.cLM(), cMk(), cMm(), cMo());
                this.knZ = new C0471a();
                ad.this.kmM.a(this.knZ, this.knY);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cMj() {
            return this.knY == null ? null : this.knY.sE(cMk());
        }

        private synchronized boolean cMk() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.knV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cLN()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cMl() {
            List<ak> sF;
            if (this.knY == null) {
                sF = null;
            } else {
                sF = this.knY.sF(cMm());
            }
            return sF;
        }

        private synchronized boolean cMm() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.knV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cLP()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cMn() {
            return this.knY == null ? null : this.knY.a(cMo());
        }

        private synchronized Priority cMo() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.knV.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cLO());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0471a c0471a, Throwable th) {
            synchronized (this) {
                if (this.knZ == c0471a) {
                    Iterator<Pair<j<T>, aj>> it = this.knV.iterator();
                    this.knV.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.knW);
                    this.knW = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0471a c0471a, T t, boolean z) {
            synchronized (this) {
                if (this.knZ == c0471a) {
                    c(this.knW);
                    this.knW = null;
                    Iterator<Pair<j<T>, aj>> it = this.knV.iterator();
                    if (!z) {
                        this.knW = (T) ad.this.f(t);
                    } else {
                        this.knV.clear();
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

        public void a(ad<K, T>.a.C0471a c0471a) {
            synchronized (this) {
                if (this.knZ == c0471a) {
                    this.knZ = null;
                    this.knY = null;
                    c(this.knW);
                    this.knW = null;
                    cMi();
                }
            }
        }

        public void a(ad<K, T>.a.C0471a c0471a, float f) {
            synchronized (this) {
                if (this.knZ == c0471a) {
                    this.knX = f;
                    Iterator<Pair<j<T>, aj>> it = this.knV.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).aS(f);
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
        public class C0471a extends b<T> {
            private C0471a() {
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
            protected void cKE() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bg(float f) {
                a.this.a(this, f);
            }
        }
    }
}

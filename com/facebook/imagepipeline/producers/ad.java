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
    private final ai<T> kbY;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> kdg = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.kbY = aiVar;
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
        bb.cHU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bb(K k) {
        return this.kdg.get(k);
    }

    private synchronized ad<K, T>.a bc(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.kdg.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.kdg.get(k) == aVar) {
            this.kdg.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final K jo;
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> kdh = com.facebook.common.internal.h.cBC();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T kdi;
        @GuardedBy("Multiplexer.this")
        private float kdj;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d kdk;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0455a kdl;

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
                this.kdh.add(create);
                List<ak> cHV = cHV();
                List<ak> cHZ = cHZ();
                List<ak> cHX = cHX();
                Closeable closeable = this.kdi;
                float f = this.kdj;
                d.eF(cHV);
                d.eH(cHZ);
                d.eG(cHX);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.kdi) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.f(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.aQ(f);
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
                public void cHD() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.kdh.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.kdh.isEmpty()) {
                            list2 = null;
                            dVar = a.this.kdk;
                            list = null;
                        } else {
                            List cHV = a.this.cHV();
                            list = a.this.cHZ();
                            list2 = cHV;
                            dVar = null;
                            list3 = a.this.cHX();
                        }
                    }
                    d.eF(list2);
                    d.eH(list);
                    d.eG(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).cBy();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHE() {
                    d.eF(a.this.cHV());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHF() {
                    d.eG(a.this.cHX());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHG() {
                    d.eH(a.this.cHZ());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cHU() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.kdk == null);
                com.facebook.common.internal.g.checkArgument(this.kdl == null);
                if (this.kdh.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.kdh.iterator().next().second;
                this.kdk = new d(ajVar.cHw(), ajVar.getId(), ajVar.cHx(), ajVar.cCS(), ajVar.cHy(), cHW(), cHY(), cIa());
                this.kdl = new C0455a();
                ad.this.kbY.a(this.kdl, this.kdk);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cHV() {
            return this.kdk == null ? null : this.kdk.sk(cHW());
        }

        private synchronized boolean cHW() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kdh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cHz()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cHX() {
            List<ak> sl;
            if (this.kdk == null) {
                sl = null;
            } else {
                sl = this.kdk.sl(cHY());
            }
            return sl;
        }

        private synchronized boolean cHY() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kdh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cHB()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cHZ() {
            return this.kdk == null ? null : this.kdk.a(cIa());
        }

        private synchronized Priority cIa() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.kdh.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cHA());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0455a c0455a, Throwable th) {
            synchronized (this) {
                if (this.kdl == c0455a) {
                    Iterator<Pair<j<T>, aj>> it = this.kdh.iterator();
                    this.kdh.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.kdi);
                    this.kdi = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0455a c0455a, T t, boolean z) {
            synchronized (this) {
                if (this.kdl == c0455a) {
                    c(this.kdi);
                    this.kdi = null;
                    Iterator<Pair<j<T>, aj>> it = this.kdh.iterator();
                    if (!z) {
                        this.kdi = (T) ad.this.f(t);
                    } else {
                        this.kdh.clear();
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

        public void a(ad<K, T>.a.C0455a c0455a) {
            synchronized (this) {
                if (this.kdl == c0455a) {
                    this.kdl = null;
                    this.kdk = null;
                    c(this.kdi);
                    this.kdi = null;
                    cHU();
                }
            }
        }

        public void a(ad<K, T>.a.C0455a c0455a, float f) {
            synchronized (this) {
                if (this.kdl == c0455a) {
                    this.kdj = f;
                    Iterator<Pair<j<T>, aj>> it = this.kdh.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).aQ(f);
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
        public class C0455a extends b<T> {
            private C0455a() {
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
            protected void cGr() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void be(float f) {
                a.this.a(this, f);
            }
        }
    }
}

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
    private final ai<T> kcc;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> kdk = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.kcc = aiVar;
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
        bb.cHV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bb(K k) {
        return this.kdk.get(k);
    }

    private synchronized ad<K, T>.a bc(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.kdk.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.kdk.get(k) == aVar) {
            this.kdk.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final K jo;
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> kdl = com.facebook.common.internal.h.cBD();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T kdm;
        @GuardedBy("Multiplexer.this")
        private float kdn;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d kdo;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0455a kdp;

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
                this.kdl.add(create);
                List<ak> cHW = cHW();
                List<ak> cIa = cIa();
                List<ak> cHY = cHY();
                Closeable closeable = this.kdm;
                float f = this.kdn;
                d.eF(cHW);
                d.eH(cIa);
                d.eG(cHY);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.kdm) {
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
                public void cHE() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.kdl.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.kdl.isEmpty()) {
                            list2 = null;
                            dVar = a.this.kdo;
                            list = null;
                        } else {
                            List cHW = a.this.cHW();
                            list = a.this.cIa();
                            list2 = cHW;
                            dVar = null;
                            list3 = a.this.cHY();
                        }
                    }
                    d.eF(list2);
                    d.eH(list);
                    d.eG(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).cBz();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHF() {
                    d.eF(a.this.cHW());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHG() {
                    d.eG(a.this.cHY());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHH() {
                    d.eH(a.this.cIa());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cHV() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.kdo == null);
                com.facebook.common.internal.g.checkArgument(this.kdp == null);
                if (this.kdl.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.kdl.iterator().next().second;
                this.kdo = new d(ajVar.cHx(), ajVar.getId(), ajVar.cHy(), ajVar.cCT(), ajVar.cHz(), cHX(), cHZ(), cIb());
                this.kdp = new C0455a();
                ad.this.kcc.a(this.kdp, this.kdo);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cHW() {
            return this.kdo == null ? null : this.kdo.sl(cHX());
        }

        private synchronized boolean cHX() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kdl.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cHA()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cHY() {
            List<ak> sm;
            if (this.kdo == null) {
                sm = null;
            } else {
                sm = this.kdo.sm(cHZ());
            }
            return sm;
        }

        private synchronized boolean cHZ() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kdl.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cHC()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cIa() {
            return this.kdo == null ? null : this.kdo.a(cIb());
        }

        private synchronized Priority cIb() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.kdl.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cHB());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0455a c0455a, Throwable th) {
            synchronized (this) {
                if (this.kdp == c0455a) {
                    Iterator<Pair<j<T>, aj>> it = this.kdl.iterator();
                    this.kdl.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.kdm);
                    this.kdm = null;
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
                if (this.kdp == c0455a) {
                    c(this.kdm);
                    this.kdm = null;
                    Iterator<Pair<j<T>, aj>> it = this.kdl.iterator();
                    if (!z) {
                        this.kdm = (T) ad.this.f(t);
                    } else {
                        this.kdl.clear();
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
                if (this.kdp == c0455a) {
                    this.kdp = null;
                    this.kdo = null;
                    c(this.kdm);
                    this.kdm = null;
                    cHV();
                }
            }
        }

        public void a(ad<K, T>.a.C0455a c0455a, float f) {
            synchronized (this) {
                if (this.kdp == c0455a) {
                    this.kdn = f;
                    Iterator<Pair<j<T>, aj>> it = this.kdl.iterator();
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
            protected void cGs() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void be(float f) {
                a.this.a(this, f);
            }
        }
    }
}

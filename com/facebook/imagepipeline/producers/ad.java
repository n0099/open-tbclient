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
    private final ai<T> kbZ;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> kdh = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.kbZ = aiVar;
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
        bb.cHW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bb(K k) {
        return this.kdh.get(k);
    }

    private synchronized ad<K, T>.a bc(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.kdh.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.kdh.get(k) == aVar) {
            this.kdh.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final K jo;
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> kdi = com.facebook.common.internal.h.cBE();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T kdj;
        @GuardedBy("Multiplexer.this")
        private float kdk;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d kdl;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0455a kdm;

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
                this.kdi.add(create);
                List<ak> cHX = cHX();
                List<ak> cIb = cIb();
                List<ak> cHZ = cHZ();
                Closeable closeable = this.kdj;
                float f = this.kdk;
                d.eF(cHX);
                d.eH(cIb);
                d.eG(cHZ);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.kdj) {
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
                public void cHF() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.kdi.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.kdi.isEmpty()) {
                            list2 = null;
                            dVar = a.this.kdl;
                            list = null;
                        } else {
                            List cHX = a.this.cHX();
                            list = a.this.cIb();
                            list2 = cHX;
                            dVar = null;
                            list3 = a.this.cHZ();
                        }
                    }
                    d.eF(list2);
                    d.eH(list);
                    d.eG(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).cBA();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHG() {
                    d.eF(a.this.cHX());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHH() {
                    d.eG(a.this.cHZ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHI() {
                    d.eH(a.this.cIb());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cHW() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.kdl == null);
                com.facebook.common.internal.g.checkArgument(this.kdm == null);
                if (this.kdi.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.kdi.iterator().next().second;
                this.kdl = new d(ajVar.cHy(), ajVar.getId(), ajVar.cHz(), ajVar.cCU(), ajVar.cHA(), cHY(), cIa(), cIc());
                this.kdm = new C0455a();
                ad.this.kbZ.a(this.kdm, this.kdl);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cHX() {
            return this.kdl == null ? null : this.kdl.sk(cHY());
        }

        private synchronized boolean cHY() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kdi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cHB()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cHZ() {
            List<ak> sl;
            if (this.kdl == null) {
                sl = null;
            } else {
                sl = this.kdl.sl(cIa());
            }
            return sl;
        }

        private synchronized boolean cIa() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kdi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cHD()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cIb() {
            return this.kdl == null ? null : this.kdl.a(cIc());
        }

        private synchronized Priority cIc() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.kdi.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cHC());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0455a c0455a, Throwable th) {
            synchronized (this) {
                if (this.kdm == c0455a) {
                    Iterator<Pair<j<T>, aj>> it = this.kdi.iterator();
                    this.kdi.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.kdj);
                    this.kdj = null;
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
                if (this.kdm == c0455a) {
                    c(this.kdj);
                    this.kdj = null;
                    Iterator<Pair<j<T>, aj>> it = this.kdi.iterator();
                    if (!z) {
                        this.kdj = (T) ad.this.f(t);
                    } else {
                        this.kdi.clear();
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
                if (this.kdm == c0455a) {
                    this.kdm = null;
                    this.kdl = null;
                    c(this.kdj);
                    this.kdj = null;
                    cHW();
                }
            }
        }

        public void a(ad<K, T>.a.C0455a c0455a, float f) {
            synchronized (this) {
                if (this.kdm == c0455a) {
                    this.kdk = f;
                    Iterator<Pair<j<T>, aj>> it = this.kdi.iterator();
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
            protected void cGt() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void be(float f) {
                a.this.a(this, f);
            }
        }
    }
}

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
    private final ai<T> jJF;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> jKN = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.jJF = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a bc;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                bc = bc(b);
                if (bc == null) {
                    bc = bd(b);
                    z = true;
                }
            }
        } while (!bc.f(jVar, ajVar));
        if (!z) {
            return;
        }
        bc.czS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bc(K k) {
        return this.jKN.get(k);
    }

    private synchronized ad<K, T>.a bd(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.jKN.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.jKN.get(k) == aVar) {
            this.jKN.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> jKO = com.facebook.common.internal.h.ctz();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T jKP;
        @GuardedBy("Multiplexer.this")
        private float jKQ;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d jKR;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0340a jKS;
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
                if (ad.this.bc(this.jo) != this) {
                    return false;
                }
                this.jKO.add(create);
                List<ak> czT = czT();
                List<ak> czX = czX();
                List<ak> czV = czV();
                Closeable closeable = this.jKP;
                float f = this.jKQ;
                d.eA(czT);
                d.eC(czX);
                d.eB(czV);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.jKP) {
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
                public void czB() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.jKO.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.jKO.isEmpty()) {
                            list2 = null;
                            dVar = a.this.jKR;
                            list = null;
                        } else {
                            List czT = a.this.czT();
                            list = a.this.czX();
                            list2 = czT;
                            dVar = null;
                            list3 = a.this.czV();
                        }
                    }
                    d.eA(list2);
                    d.eC(list);
                    d.eB(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).ctv();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czC() {
                    d.eA(a.this.czT());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czD() {
                    d.eB(a.this.czV());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czE() {
                    d.eC(a.this.czX());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void czS() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.jKR == null);
                com.facebook.common.internal.g.checkArgument(this.jKS == null);
                if (this.jKO.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.jKO.iterator().next().second;
                this.jKR = new d(ajVar.czu(), ajVar.getId(), ajVar.czv(), ajVar.cuQ(), ajVar.czw(), czU(), czW(), czY());
                this.jKS = new C0340a();
                ad.this.jJF.a(this.jKS, this.jKR);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> czT() {
            return this.jKR == null ? null : this.jKR.rv(czU());
        }

        private synchronized boolean czU() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.jKO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).czx()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> czV() {
            List<ak> rw;
            if (this.jKR == null) {
                rw = null;
            } else {
                rw = this.jKR.rw(czW());
            }
            return rw;
        }

        private synchronized boolean czW() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.jKO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).czz()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> czX() {
            return this.jKR == null ? null : this.jKR.a(czY());
        }

        private synchronized Priority czY() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.jKO.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).czy());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0340a c0340a, Throwable th) {
            synchronized (this) {
                if (this.jKS == c0340a) {
                    Iterator<Pair<j<T>, aj>> it = this.jKO.iterator();
                    this.jKO.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.jKP);
                    this.jKP = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0340a c0340a, T t, boolean z) {
            synchronized (this) {
                if (this.jKS == c0340a) {
                    c(this.jKP);
                    this.jKP = null;
                    Iterator<Pair<j<T>, aj>> it = this.jKO.iterator();
                    if (!z) {
                        this.jKP = (T) ad.this.f(t);
                    } else {
                        this.jKO.clear();
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

        public void a(ad<K, T>.a.C0340a c0340a) {
            synchronized (this) {
                if (this.jKS == c0340a) {
                    this.jKS = null;
                    this.jKR = null;
                    c(this.jKP);
                    this.jKP = null;
                    czS();
                }
            }
        }

        public void a(ad<K, T>.a.C0340a c0340a, float f) {
            synchronized (this) {
                if (this.jKS == c0340a) {
                    this.jKQ = f;
                    Iterator<Pair<j<T>, aj>> it = this.jKO.iterator();
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
        public class C0340a extends b<T> {
            private C0340a() {
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
            protected void cyp() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void ba(float f) {
                a.this.a(this, f);
            }
        }
    }
}

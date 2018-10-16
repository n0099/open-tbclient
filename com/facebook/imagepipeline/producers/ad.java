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
    private final ai<T> igI;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> ihQ = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.igI = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a aN;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                aN = aN(b);
                if (aN == null) {
                    aN = aO(b);
                    z = true;
                }
            }
        } while (!aN.f(jVar, ajVar));
        if (!z) {
            return;
        }
        aN.bXO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a aN(K k) {
        return this.ihQ.get(k);
    }

    private synchronized ad<K, T>.a aO(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.ihQ.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.ihQ.get(k) == aVar) {
            this.ihQ.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> ihR = com.facebook.common.internal.h.bRC();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T ihS;
        @GuardedBy("Multiplexer.this")
        private float ihT;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d ihU;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0323a ihV;
        private final K jn;

        public a(K k) {
            this.jn = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.facebook.imagepipeline.producers.j<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(j<T> jVar, aj ajVar) {
            Pair<j<T>, aj> create = Pair.create(jVar, ajVar);
            synchronized (this) {
                if (ad.this.aN(this.jn) != this) {
                    return false;
                }
                this.ihR.add(create);
                List<ak> bXP = bXP();
                List<ak> bXT = bXT();
                List<ak> bXR = bXR();
                Closeable closeable = this.ihS;
                float f = this.ihT;
                d.es(bXP);
                d.eu(bXT);
                d.et(bXR);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.ihS) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.e(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.ax(f);
                        }
                        jVar.e(closeable, false);
                        closeSafely(closeable);
                    }
                }
                a(create, ajVar);
                return true;
            }
        }

        private void a(final Pair<j<T>, aj> pair, aj ajVar) {
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ad.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXx() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.ihR.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.ihR.isEmpty()) {
                            list2 = null;
                            dVar = a.this.ihU;
                            list = null;
                        } else {
                            List bXP = a.this.bXP();
                            list = a.this.bXT();
                            list2 = bXP;
                            dVar = null;
                            list3 = a.this.bXR();
                        }
                    }
                    d.es(list2);
                    d.eu(list);
                    d.et(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).bRy();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXy() {
                    d.es(a.this.bXP());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXz() {
                    d.et(a.this.bXR());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXA() {
                    d.eu(a.this.bXT());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bXO() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.ihU == null);
                com.facebook.common.internal.g.checkArgument(this.ihV == null);
                if (this.ihR.isEmpty()) {
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.ihR.iterator().next().second;
                this.ihU = new d(ajVar.bXq(), ajVar.getId(), ajVar.bXr(), ajVar.bST(), ajVar.bXs(), bXQ(), bXS(), bXU());
                this.ihV = new C0323a();
                ad.this.igI.a(this.ihV, this.ihU);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bXP() {
            return this.ihU == null ? null : this.ihU.oH(bXQ());
        }

        private synchronized boolean bXQ() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.ihR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).bXt()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bXR() {
            List<ak> oI;
            if (this.ihU == null) {
                oI = null;
            } else {
                oI = this.ihU.oI(bXS());
            }
            return oI;
        }

        private synchronized boolean bXS() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.ihR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).bXv()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bXT() {
            return this.ihU == null ? null : this.ihU.a(bXU());
        }

        private synchronized Priority bXU() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.ihR.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).bXu());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0323a c0323a, Throwable th) {
            synchronized (this) {
                if (this.ihV == c0323a) {
                    Iterator<Pair<j<T>, aj>> it = this.ihR.iterator();
                    this.ihR.clear();
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    closeSafely(this.ihS);
                    this.ihS = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0323a c0323a, T t, boolean z) {
            synchronized (this) {
                if (this.ihV == c0323a) {
                    closeSafely(this.ihS);
                    this.ihS = null;
                    Iterator<Pair<j<T>, aj>> it = this.ihR.iterator();
                    if (!z) {
                        this.ihS = (T) ad.this.e(t);
                    } else {
                        this.ihR.clear();
                        ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C0323a c0323a) {
            synchronized (this) {
                if (this.ihV == c0323a) {
                    this.ihV = null;
                    this.ihU = null;
                    closeSafely(this.ihS);
                    this.ihS = null;
                    bXO();
                }
            }
        }

        public void a(ad<K, T>.a.C0323a c0323a, float f) {
            synchronized (this) {
                if (this.ihV == c0323a) {
                    this.ihT = f;
                    Iterator<Pair<j<T>, aj>> it = this.ihR.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).ax(f);
                        }
                    }
                }
            }
        }

        private void closeSafely(Closeable closeable) {
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
        public class C0323a extends b<T> {
            private C0323a() {
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
            protected void bWl() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aK(float f) {
                a.this.a(this, f);
            }
        }
    }
}

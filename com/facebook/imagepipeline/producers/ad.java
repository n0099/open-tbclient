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
/* loaded from: classes18.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> oYc;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> oZg = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.oYc = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bB;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bB = bB(b);
                if (bB == null) {
                    bB = bC(b);
                    z = true;
                }
            }
        } while (!bB.f(kVar, akVar));
        if (!z) {
            return;
        }
        bB.erv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bB(K k) {
        return this.oZg.get(k);
    }

    private synchronized ad<K, T>.a bC(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.oZg.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.oZg.get(k) == aVar) {
            this.oZg.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> oZh = com.facebook.common.internal.i.eke();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T oZi;
        @GuardedBy("Multiplexer.this")
        private float oZj;
        @GuardedBy("Multiplexer.this")
        private int oZk;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d oZl;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0982a oZm;
        private final K yT;

        public a(K k) {
            this.yT = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bB(this.yT) != this) {
                    return false;
                }
                this.oZh.add(create);
                List<al> erw = erw();
                List<al> erA = erA();
                List<al> ery = ery();
                Closeable closeable = this.oZi;
                float f = this.oZj;
                int i = this.oZk;
                d.gC(erw);
                d.gE(erA);
                d.gD(ery);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.oZi) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aN(f);
                        }
                        kVar.h(closeable, i);
                        closeSafely(closeable);
                    }
                }
                a(create, akVar);
                return true;
            }
        }

        private void a(final Pair<k<T>, ak> pair, ak akVar) {
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ad.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enm() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.oZh.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.oZh.isEmpty()) {
                            list2 = null;
                            dVar = a.this.oZl;
                            list = null;
                        } else {
                            List erw = a.this.erw();
                            list = a.this.erA();
                            list2 = erw;
                            dVar = null;
                            list3 = a.this.ery();
                        }
                    }
                    d.gC(list2);
                    d.gE(list);
                    d.gD(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).ejZ();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void erc() {
                    d.gC(a.this.erw());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void erd() {
                    d.gD(a.this.ery());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ere() {
                    d.gE(a.this.erA());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void erv() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.oZl == null);
                com.facebook.common.internal.g.checkArgument(this.oZm == null);
                if (this.oZh.isEmpty()) {
                    ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.oZh.iterator().next().second;
                this.oZl = new d(akVar.eqV(), akVar.getId(), akVar.eqW(), akVar.elz(), akVar.eqX(), erx(), erz(), erB());
                this.oZm = new C0982a();
                ad.this.oYc.c(this.oZm, this.oZl);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> erw() {
            return this.oZl == null ? null : this.oZl.Ap(erx());
        }

        private synchronized boolean erx() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.oZh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).eqY()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ery() {
            List<al> Aq;
            if (this.oZl == null) {
                Aq = null;
            } else {
                Aq = this.oZl.Aq(erz());
            }
            return Aq;
        }

        private synchronized boolean erz() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.oZh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).era()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> erA() {
            return this.oZl == null ? null : this.oZl.a(erB());
        }

        private synchronized Priority erB() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.oZh.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).eqZ());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0982a c0982a, Throwable th) {
            synchronized (this) {
                if (this.oZm == c0982a) {
                    Iterator<Pair<k<T>, ak>> it = this.oZh.iterator();
                    this.oZh.clear();
                    ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    closeSafely(this.oZi);
                    this.oZi = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).E(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0982a c0982a, T t, int i) {
            synchronized (this) {
                if (this.oZm == c0982a) {
                    closeSafely(this.oZi);
                    this.oZi = null;
                    Iterator<Pair<k<T>, ak>> it = this.oZh.iterator();
                    if (b.PJ(i)) {
                        this.oZi = (T) ad.this.g(t);
                        this.oZk = i;
                    } else {
                        this.oZh.clear();
                        ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).h(t, i);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0982a c0982a) {
            synchronized (this) {
                if (this.oZm == c0982a) {
                    this.oZm = null;
                    this.oZl = null;
                    closeSafely(this.oZi);
                    this.oZi = null;
                    erv();
                }
            }
        }

        public void a(ad<K, T>.a.C0982a c0982a, float f) {
            synchronized (this) {
                if (this.oZm == c0982a) {
                    this.oZj = f;
                    Iterator<Pair<k<T>, ak>> it = this.oZh.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aN(f);
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
        /* loaded from: classes18.dex */
        public class C0982a extends b<T> {
            private C0982a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void D(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void epG() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void br(float f) {
                a.this.a(this, f);
            }
        }
    }
}

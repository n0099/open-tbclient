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
/* loaded from: classes3.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> pFG;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> pGL = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T h(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.pFG = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bB;
        K b2 = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bB = bB(b2);
                if (bB == null) {
                    bB = bC(b2);
                    z = true;
                }
            }
        } while (!bB.e(kVar, akVar));
        if (!z) {
            return;
        }
        bB.eBh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bB(K k) {
        return this.pGL.get(k);
    }

    private synchronized ad<K, T>.a bC(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.pGL.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.pGL.get(k) == aVar) {
            this.pGL.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        private final K mKey;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> pGM = com.facebook.common.internal.i.eub();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T pGN;
        @GuardedBy("Multiplexer.this")
        private float pGO;
        @GuardedBy("Multiplexer.this")
        private int pGP;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d pGQ;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C1067a pGR;

        public a(K k) {
            this.mKey = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean e(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bB(this.mKey) != this) {
                    return false;
                }
                this.pGM.add(create);
                List<al> eBi = eBi();
                List<al> eBm = eBm();
                List<al> eBk = eBk();
                Closeable closeable = this.pGN;
                float f = this.pGO;
                int i = this.pGP;
                d.gO(eBi);
                d.gQ(eBm);
                d.gP(eBk);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.pGN) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.h(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aX(f);
                        }
                        kVar.g(closeable, i);
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
                public void eAO() {
                    boolean remove;
                    List list;
                    List list2;
                    List list3;
                    d dVar;
                    synchronized (a.this) {
                        remove = a.this.pGM.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            list3 = null;
                            dVar = null;
                        } else if (a.this.pGM.isEmpty()) {
                            dVar = a.this.pGQ;
                            list = null;
                            list2 = null;
                            list3 = null;
                        } else {
                            list3 = a.this.eBi();
                            list2 = a.this.eBm();
                            list = a.this.eBk();
                            dVar = null;
                        }
                    }
                    d.gO(list3);
                    d.gQ(list2);
                    d.gP(list);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).etW();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAP() {
                    d.gO(a.this.eBi());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAQ() {
                    d.gP(a.this.eBk());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAR() {
                    d.gQ(a.this.eBm());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eBh() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.pGQ == null);
                com.facebook.common.internal.g.checkArgument(this.pGR == null);
                if (this.pGM.isEmpty()) {
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.pGM.iterator().next().second;
                this.pGQ = new d(akVar.eAH(), akVar.getId(), akVar.eAI(), akVar.evw(), akVar.eAJ(), eBj(), eBl(), eBn());
                this.pGR = new C1067a();
                ad.this.pFG.a(this.pGR, this.pGQ);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eBi() {
            return this.pGQ == null ? null : this.pGQ.Bf(eBj());
        }

        private synchronized boolean eBj() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pGM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).eAK()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eBk() {
            List<al> Bg;
            if (this.pGQ == null) {
                Bg = null;
            } else {
                Bg = this.pGQ.Bg(eBl());
            }
            return Bg;
        }

        private synchronized boolean eBl() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pGM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).eAM()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eBm() {
            return this.pGQ == null ? null : this.pGQ.a(eBn());
        }

        private synchronized Priority eBn() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.pGM.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).eAL());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C1067a c1067a, Throwable th) {
            synchronized (this) {
                if (this.pGR == c1067a) {
                    Iterator<Pair<k<T>, ak>> it = this.pGM.iterator();
                    this.pGM.clear();
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    closeSafely(this.pGN);
                    this.pGN = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).D(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1067a c1067a, T t, int i) {
            synchronized (this) {
                if (this.pGR == c1067a) {
                    closeSafely(this.pGN);
                    this.pGN = null;
                    Iterator<Pair<k<T>, ak>> it = this.pGM.iterator();
                    if (b.Rw(i)) {
                        this.pGN = (T) ad.this.h(t);
                        this.pGP = i;
                    } else {
                        this.pGM.clear();
                        ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).g(t, i);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1067a c1067a) {
            synchronized (this) {
                if (this.pGR == c1067a) {
                    this.pGR = null;
                    this.pGQ = null;
                    closeSafely(this.pGN);
                    this.pGN = null;
                    eBh();
                }
            }
        }

        public void a(ad<K, T>.a.C1067a c1067a, float f) {
            synchronized (this) {
                if (this.pGR == c1067a) {
                    this.pGO = f;
                    Iterator<Pair<k<T>, ak>> it = this.pGM.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aX(f);
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
        /* loaded from: classes3.dex */
        public class C1067a extends b<T> {
            private C1067a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void C(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void ezv() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bK(float f) {
                a.this.a(this, f);
            }
        }
    }
}

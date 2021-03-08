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
/* loaded from: classes5.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> pNT;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> pOY = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.pNT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bD;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bD = bD(b);
                if (bD == null) {
                    bD = bE(b);
                    z = true;
                }
            }
        } while (!bD.e(kVar, akVar));
        if (!z) {
            return;
        }
        bD.ezY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bD(K k) {
        return this.pOY.get(k);
    }

    private synchronized ad<K, T>.a bE(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.pOY.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.pOY.get(k) == aVar) {
            this.pOY.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        private final K mKey;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> pOZ = com.facebook.common.internal.i.esR();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T pPa;
        @GuardedBy("Multiplexer.this")
        private float pPb;
        @GuardedBy("Multiplexer.this")
        private int pPc;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d pPd;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C1071a pPe;

        public a(K k) {
            this.mKey = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean e(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bD(this.mKey) != this) {
                    return false;
                }
                this.pOZ.add(create);
                List<al> ezZ = ezZ();
                List<al> eAd = eAd();
                List<al> eAb = eAb();
                Closeable closeable = this.pPa;
                float f = this.pPb;
                int i = this.pPc;
                d.gM(ezZ);
                d.gO(eAd);
                d.gN(eAb);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.pPa) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.f(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.be(f);
                        }
                        kVar.f(closeable, i);
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
                public void ezF() {
                    boolean remove;
                    List list;
                    List list2;
                    List list3;
                    d dVar;
                    synchronized (a.this) {
                        remove = a.this.pOZ.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            list3 = null;
                            dVar = null;
                        } else if (a.this.pOZ.isEmpty()) {
                            dVar = a.this.pPd;
                            list = null;
                            list2 = null;
                            list3 = null;
                        } else {
                            list3 = a.this.ezZ();
                            list2 = a.this.eAd();
                            list = a.this.eAb();
                            dVar = null;
                        }
                    }
                    d.gM(list3);
                    d.gO(list2);
                    d.gN(list);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).esM();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezG() {
                    d.gM(a.this.ezZ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezH() {
                    d.gN(a.this.eAb());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezI() {
                    d.gO(a.this.eAd());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezY() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.pPd == null);
                com.facebook.common.internal.g.checkArgument(this.pPe == null);
                if (this.pOZ.isEmpty()) {
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.pOZ.iterator().next().second;
                this.pPd = new d(akVar.ezy(), akVar.getId(), akVar.ezz(), akVar.eum(), akVar.ezA(), eAa(), eAc(), eAe());
                this.pPe = new C1071a();
                ad.this.pNT.a(this.pPe, this.pPd);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ezZ() {
            return this.pPd == null ? null : this.pPd.Bs(eAa());
        }

        private synchronized boolean eAa() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pOZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).ezB()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eAb() {
            List<al> Bt;
            if (this.pPd == null) {
                Bt = null;
            } else {
                Bt = this.pPd.Bt(eAc());
            }
            return Bt;
        }

        private synchronized boolean eAc() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pOZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).ezD()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> eAd() {
            return this.pPd == null ? null : this.pPd.a(eAe());
        }

        private synchronized Priority eAe() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.pOZ.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).ezC());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C1071a c1071a, Throwable th) {
            synchronized (this) {
                if (this.pPe == c1071a) {
                    Iterator<Pair<k<T>, ak>> it = this.pOZ.iterator();
                    this.pOZ.clear();
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    closeSafely(this.pPa);
                    this.pPa = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1071a c1071a, T t, int i) {
            synchronized (this) {
                if (this.pPe == c1071a) {
                    closeSafely(this.pPa);
                    this.pPa = null;
                    Iterator<Pair<k<T>, ak>> it = this.pOZ.iterator();
                    if (b.Qp(i)) {
                        this.pPa = (T) ad.this.f(t);
                        this.pPc = i;
                    } else {
                        this.pOZ.clear();
                        ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).f(t, i);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1071a c1071a) {
            synchronized (this) {
                if (this.pPe == c1071a) {
                    this.pPe = null;
                    this.pPd = null;
                    closeSafely(this.pPa);
                    this.pPa = null;
                    ezY();
                }
            }
        }

        public void a(ad<K, T>.a.C1071a c1071a, float f) {
            synchronized (this) {
                if (this.pPe == c1071a) {
                    this.pPb = f;
                    Iterator<Pair<k<T>, ak>> it = this.pOZ.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).be(f);
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
        /* loaded from: classes5.dex */
        public class C1071a extends b<T> {
            private C1071a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void e(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void eyn() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bR(float f) {
                a.this.a(this, f);
            }
        }
    }
}

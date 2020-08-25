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
/* loaded from: classes8.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> nxL;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> nyP = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.nxL = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bs;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bs = bs(b);
                if (bs == null) {
                    bs = bt(b);
                    z = true;
                }
            }
        } while (!bs.f(kVar, akVar));
        if (!z) {
            return;
        }
        bs.dVO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bs(K k) {
        return this.nyP.get(k);
    }

    private synchronized ad<K, T>.a bt(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.nyP.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.nyP.get(k) == aVar) {
            this.nyP.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> nyQ = com.facebook.common.internal.i.dOz();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T nyR;
        @GuardedBy("Multiplexer.this")
        private float nyS;
        @GuardedBy("Multiplexer.this")
        private int nyT;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d nyU;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0876a nyV;
        private final K yC;

        public a(K k) {
            this.yC = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bs(this.yC) != this) {
                    return false;
                }
                this.nyQ.add(create);
                List<al> dVP = dVP();
                List<al> dVT = dVT();
                List<al> dVR = dVR();
                Closeable closeable = this.nyR;
                float f = this.nyS;
                int i = this.nyT;
                d.fL(dVP);
                d.fN(dVT);
                d.fM(dVR);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.nyR) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aD(f);
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
                public void dRG() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.nyQ.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.nyQ.isEmpty()) {
                            list2 = null;
                            dVar = a.this.nyU;
                            list = null;
                        } else {
                            List dVP = a.this.dVP();
                            list = a.this.dVT();
                            list2 = dVP;
                            dVar = null;
                            list3 = a.this.dVR();
                        }
                    }
                    d.fL(list2);
                    d.fN(list);
                    d.fM(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dOu();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVv() {
                    d.fL(a.this.dVP());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVw() {
                    d.fM(a.this.dVR());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVx() {
                    d.fN(a.this.dVT());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVO() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.nyU == null);
                com.facebook.common.internal.g.checkArgument(this.nyV == null);
                if (this.nyQ.isEmpty()) {
                    ad.this.a((ad) this.yC, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.nyQ.iterator().next().second;
                this.nyU = new d(akVar.dVo(), akVar.getId(), akVar.dVp(), akVar.dPU(), akVar.dVq(), dVQ(), dVS(), dVU());
                this.nyV = new C0876a();
                ad.this.nxL.c(this.nyV, this.nyU);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dVP() {
            return this.nyU == null ? null : this.nyU.ye(dVQ());
        }

        private synchronized boolean dVQ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nyQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dVr()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dVR() {
            List<al> yf;
            if (this.nyU == null) {
                yf = null;
            } else {
                yf = this.nyU.yf(dVS());
            }
            return yf;
        }

        private synchronized boolean dVS() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nyQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dVt()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dVT() {
            return this.nyU == null ? null : this.nyU.a(dVU());
        }

        private synchronized Priority dVU() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.nyQ.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dVs());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0876a c0876a, Throwable th) {
            synchronized (this) {
                if (this.nyV == c0876a) {
                    Iterator<Pair<k<T>, ak>> it = this.nyQ.iterator();
                    this.nyQ.clear();
                    ad.this.a((ad) this.yC, (ad<ad, T>.a) this);
                    closeSafely(this.nyR);
                    this.nyR = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).E(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0876a c0876a, T t, int i) {
            synchronized (this) {
                if (this.nyV == c0876a) {
                    closeSafely(this.nyR);
                    this.nyR = null;
                    Iterator<Pair<k<T>, ak>> it = this.nyQ.iterator();
                    if (b.Mm(i)) {
                        this.nyR = (T) ad.this.g(t);
                        this.nyT = i;
                    } else {
                        this.nyQ.clear();
                        ad.this.a((ad) this.yC, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C0876a c0876a) {
            synchronized (this) {
                if (this.nyV == c0876a) {
                    this.nyV = null;
                    this.nyU = null;
                    closeSafely(this.nyR);
                    this.nyR = null;
                    dVO();
                }
            }
        }

        public void a(ad<K, T>.a.C0876a c0876a, float f) {
            synchronized (this) {
                if (this.nyV == c0876a) {
                    this.nyS = f;
                    Iterator<Pair<k<T>, ak>> it = this.nyQ.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aD(f);
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
        /* loaded from: classes8.dex */
        public class C0876a extends b<T> {
            private C0876a() {
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
            protected void dTZ() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aS(float f) {
                a.this.a(this, f);
            }
        }
    }
}

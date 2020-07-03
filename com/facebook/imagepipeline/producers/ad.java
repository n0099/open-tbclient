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
/* loaded from: classes12.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> mVP;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> mWU = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.mVP = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bq;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bq = bq(b);
                if (bq == null) {
                    bq = br(b);
                    z = true;
                }
            }
        } while (!bq.f(kVar, akVar));
        if (!z) {
            return;
        }
        bq.dGy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bq(K k) {
        return this.mWU.get(k);
    }

    private synchronized ad<K, T>.a br(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.mWU.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.mWU.get(k) == aVar) {
            this.mWU.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> mWV = com.facebook.common.internal.i.dzi();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T mWW;
        @GuardedBy("Multiplexer.this")
        private float mWX;
        @GuardedBy("Multiplexer.this")
        private int mWY;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d mWZ;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0808a mXa;
        private final K yd;

        public a(K k) {
            this.yd = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bq(this.yd) != this) {
                    return false;
                }
                this.mWV.add(create);
                List<al> dGz = dGz();
                List<al> dGD = dGD();
                List<al> dGB = dGB();
                Closeable closeable = this.mWW;
                float f = this.mWX;
                int i = this.mWY;
                d.fs(dGz);
                d.fu(dGD);
                d.ft(dGB);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.mWW) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.ay(f);
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
                public void dCq() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.mWV.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.mWV.isEmpty()) {
                            list2 = null;
                            dVar = a.this.mWZ;
                            list = null;
                        } else {
                            List dGz = a.this.dGz();
                            list = a.this.dGD();
                            list2 = dGz;
                            dVar = null;
                            list3 = a.this.dGB();
                        }
                    }
                    d.fs(list2);
                    d.fu(list);
                    d.ft(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dzd();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGf() {
                    d.fs(a.this.dGz());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGg() {
                    d.ft(a.this.dGB());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGh() {
                    d.fu(a.this.dGD());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dGy() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.mWZ == null);
                com.facebook.common.internal.g.checkArgument(this.mXa == null);
                if (this.mWV.isEmpty()) {
                    ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.mWV.iterator().next().second;
                this.mWZ = new d(akVar.dFY(), akVar.getId(), akVar.dFZ(), akVar.dAD(), akVar.dGa(), dGA(), dGC(), dGE());
                this.mXa = new C0808a();
                ad.this.mVP.c(this.mXa, this.mWZ);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dGz() {
            return this.mWZ == null ? null : this.mWZ.wI(dGA());
        }

        private synchronized boolean dGA() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mWV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dGb()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dGB() {
            List<al> wJ;
            if (this.mWZ == null) {
                wJ = null;
            } else {
                wJ = this.mWZ.wJ(dGC());
            }
            return wJ;
        }

        private synchronized boolean dGC() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mWV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dGd()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dGD() {
            return this.mWZ == null ? null : this.mWZ.a(dGE());
        }

        private synchronized Priority dGE() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.mWV.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dGc());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0808a c0808a, Throwable th) {
            synchronized (this) {
                if (this.mXa == c0808a) {
                    Iterator<Pair<k<T>, ak>> it = this.mWV.iterator();
                    this.mWV.clear();
                    ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
                    closeSafely(this.mWW);
                    this.mWW = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).G(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0808a c0808a, T t, int i) {
            synchronized (this) {
                if (this.mXa == c0808a) {
                    closeSafely(this.mWW);
                    this.mWW = null;
                    Iterator<Pair<k<T>, ak>> it = this.mWV.iterator();
                    if (b.Jn(i)) {
                        this.mWW = (T) ad.this.g(t);
                        this.mWY = i;
                    } else {
                        this.mWV.clear();
                        ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C0808a c0808a) {
            synchronized (this) {
                if (this.mXa == c0808a) {
                    this.mXa = null;
                    this.mWZ = null;
                    closeSafely(this.mWW);
                    this.mWW = null;
                    dGy();
                }
            }
        }

        public void a(ad<K, T>.a.C0808a c0808a, float f) {
            synchronized (this) {
                if (this.mXa == c0808a) {
                    this.mWX = f;
                    Iterator<Pair<k<T>, ak>> it = this.mWV.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).ay(f);
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
        /* loaded from: classes12.dex */
        public class C0808a extends b<T> {
            private C0808a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void F(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dEJ() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aN(float f) {
                a.this.a(this, f);
            }
        }
    }
}

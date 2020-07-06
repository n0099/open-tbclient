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
    private final aj<T> mVS;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> mWX = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.mVS = ajVar;
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
        bq.dGC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bq(K k) {
        return this.mWX.get(k);
    }

    private synchronized ad<K, T>.a br(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.mWX.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.mWX.get(k) == aVar) {
            this.mWX.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> mWY = com.facebook.common.internal.i.dzm();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T mWZ;
        @GuardedBy("Multiplexer.this")
        private float mXa;
        @GuardedBy("Multiplexer.this")
        private int mXb;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d mXc;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0809a mXd;
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
                this.mWY.add(create);
                List<al> dGD = dGD();
                List<al> dGH = dGH();
                List<al> dGF = dGF();
                Closeable closeable = this.mWZ;
                float f = this.mXa;
                int i = this.mXb;
                d.fs(dGD);
                d.fu(dGH);
                d.ft(dGF);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.mWZ) {
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
                public void dCu() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.mWY.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.mWY.isEmpty()) {
                            list2 = null;
                            dVar = a.this.mXc;
                            list = null;
                        } else {
                            List dGD = a.this.dGD();
                            list = a.this.dGH();
                            list2 = dGD;
                            dVar = null;
                            list3 = a.this.dGF();
                        }
                    }
                    d.fs(list2);
                    d.fu(list);
                    d.ft(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dzh();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGj() {
                    d.fs(a.this.dGD());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGk() {
                    d.ft(a.this.dGF());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGl() {
                    d.fu(a.this.dGH());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dGC() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.mXc == null);
                com.facebook.common.internal.g.checkArgument(this.mXd == null);
                if (this.mWY.isEmpty()) {
                    ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.mWY.iterator().next().second;
                this.mXc = new d(akVar.dGc(), akVar.getId(), akVar.dGd(), akVar.dAH(), akVar.dGe(), dGE(), dGG(), dGI());
                this.mXd = new C0809a();
                ad.this.mVS.c(this.mXd, this.mXc);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dGD() {
            return this.mXc == null ? null : this.mXc.wI(dGE());
        }

        private synchronized boolean dGE() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mWY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dGf()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dGF() {
            List<al> wJ;
            if (this.mXc == null) {
                wJ = null;
            } else {
                wJ = this.mXc.wJ(dGG());
            }
            return wJ;
        }

        private synchronized boolean dGG() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mWY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dGh()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dGH() {
            return this.mXc == null ? null : this.mXc.a(dGI());
        }

        private synchronized Priority dGI() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.mWY.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dGg());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0809a c0809a, Throwable th) {
            synchronized (this) {
                if (this.mXd == c0809a) {
                    Iterator<Pair<k<T>, ak>> it = this.mWY.iterator();
                    this.mWY.clear();
                    ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
                    closeSafely(this.mWZ);
                    this.mWZ = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).G(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0809a c0809a, T t, int i) {
            synchronized (this) {
                if (this.mXd == c0809a) {
                    closeSafely(this.mWZ);
                    this.mWZ = null;
                    Iterator<Pair<k<T>, ak>> it = this.mWY.iterator();
                    if (b.Jn(i)) {
                        this.mWZ = (T) ad.this.g(t);
                        this.mXb = i;
                    } else {
                        this.mWY.clear();
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

        public void a(ad<K, T>.a.C0809a c0809a) {
            synchronized (this) {
                if (this.mXd == c0809a) {
                    this.mXd = null;
                    this.mXc = null;
                    closeSafely(this.mWZ);
                    this.mWZ = null;
                    dGC();
                }
            }
        }

        public void a(ad<K, T>.a.C0809a c0809a, float f) {
            synchronized (this) {
                if (this.mXd == c0809a) {
                    this.mXa = f;
                    Iterator<Pair<k<T>, ak>> it = this.mWY.iterator();
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
        public class C0809a extends b<T> {
            private C0809a() {
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
            protected void dEN() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aN(float f) {
                a.this.a(this, f);
            }
        }
    }
}

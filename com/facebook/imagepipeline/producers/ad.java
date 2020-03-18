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
    private final aj<T> lWS;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> lXW = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T d(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.lWS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bu;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bu = bu(b);
                if (bu == null) {
                    bu = bv(b);
                    z = true;
                }
            }
        } while (!bu.f(kVar, akVar));
        if (!z) {
            return;
        }
        bu.dsv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bu(K k) {
        return this.lXW.get(k);
    }

    private synchronized ad<K, T>.a bv(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.lXW.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.lXW.get(k) == aVar) {
            this.lXW.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final K bz;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> lXX = com.facebook.common.internal.i.dlh();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T lXY;
        @GuardedBy("Multiplexer.this")
        private float lXZ;
        @GuardedBy("Multiplexer.this")
        private int lYa;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d lYb;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0669a lYc;

        public a(K k) {
            this.bz = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bu(this.bz) != this) {
                    return false;
                }
                this.lXX.add(create);
                List<al> dsw = dsw();
                List<al> dsA = dsA();
                List<al> dsy = dsy();
                Closeable closeable = this.lXY;
                float f = this.lXZ;
                int i = this.lYa;
                d.eW(dsw);
                d.eY(dsA);
                d.eX(dsy);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.lXY) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.d(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aK(f);
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
                public void don() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.lXX.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.lXX.isEmpty()) {
                            list2 = null;
                            dVar = a.this.lYb;
                            list = null;
                        } else {
                            List dsw = a.this.dsw();
                            list = a.this.dsA();
                            list2 = dsw;
                            dVar = null;
                            list3 = a.this.dsy();
                        }
                    }
                    d.eW(list2);
                    d.eY(list);
                    d.eX(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dlc();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dsc() {
                    d.eW(a.this.dsw());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dsd() {
                    d.eX(a.this.dsy());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dse() {
                    d.eY(a.this.dsA());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsv() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.lYb == null);
                com.facebook.common.internal.g.checkArgument(this.lYc == null);
                if (this.lXX.isEmpty()) {
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.lXX.iterator().next().second;
                this.lYb = new d(akVar.drV(), akVar.getId(), akVar.drW(), akVar.dmD(), akVar.drX(), dsx(), dsz(), dsB());
                this.lYc = new C0669a();
                ad.this.lWS.c(this.lYc, this.lYb);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dsw() {
            return this.lYb == null ? null : this.lYb.vz(dsx());
        }

        private synchronized boolean dsx() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lXX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).drY()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dsy() {
            List<al> vA;
            if (this.lYb == null) {
                vA = null;
            } else {
                vA = this.lYb.vA(dsz());
            }
            return vA;
        }

        private synchronized boolean dsz() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lXX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dsa()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dsA() {
            return this.lYb == null ? null : this.lYb.a(dsB());
        }

        private synchronized Priority dsB() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.lXX.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).drZ());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0669a c0669a, Throwable th) {
            synchronized (this) {
                if (this.lYc == c0669a) {
                    Iterator<Pair<k<T>, ak>> it = this.lXX.iterator();
                    this.lXX.clear();
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    closeSafely(this.lXY);
                    this.lXY = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0669a c0669a, T t, int i) {
            synchronized (this) {
                if (this.lYc == c0669a) {
                    closeSafely(this.lXY);
                    this.lXY = null;
                    Iterator<Pair<k<T>, ak>> it = this.lXX.iterator();
                    if (b.IQ(i)) {
                        this.lXY = (T) ad.this.d(t);
                        this.lYa = i;
                    } else {
                        this.lXX.clear();
                        ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C0669a c0669a) {
            synchronized (this) {
                if (this.lYc == c0669a) {
                    this.lYc = null;
                    this.lYb = null;
                    closeSafely(this.lXY);
                    this.lXY = null;
                    dsv();
                }
            }
        }

        public void a(ad<K, T>.a.C0669a c0669a, float f) {
            synchronized (this) {
                if (this.lYc == c0669a) {
                    this.lXZ = f;
                    Iterator<Pair<k<T>, ak>> it = this.lXX.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aK(f);
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
        public class C0669a extends b<T> {
            private C0669a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dqF() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bs(float f) {
                a.this.a(this, f);
            }
        }
    }
}

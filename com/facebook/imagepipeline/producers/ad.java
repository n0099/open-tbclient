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
    private final aj<T> lUZ;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> lWd = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T d(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.lUZ = ajVar;
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
        bu.drV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bu(K k) {
        return this.lWd.get(k);
    }

    private synchronized ad<K, T>.a bv(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.lWd.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.lWd.get(k) == aVar) {
            this.lWd.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final K bz;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> lWe = com.facebook.common.internal.i.dkH();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T lWf;
        @GuardedBy("Multiplexer.this")
        private float lWg;
        @GuardedBy("Multiplexer.this")
        private int lWh;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d lWi;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0668a lWj;

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
                this.lWe.add(create);
                List<al> drW = drW();
                List<al> dsa = dsa();
                List<al> drY = drY();
                Closeable closeable = this.lWf;
                float f = this.lWg;
                int i = this.lWh;
                d.eW(drW);
                d.eY(dsa);
                d.eX(drY);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.lWf) {
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
                public void dnN() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.lWe.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.lWe.isEmpty()) {
                            list2 = null;
                            dVar = a.this.lWi;
                            list = null;
                        } else {
                            List drW = a.this.drW();
                            list = a.this.dsa();
                            list2 = drW;
                            dVar = null;
                            list3 = a.this.drY();
                        }
                    }
                    d.eW(list2);
                    d.eY(list);
                    d.eX(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dkC();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drC() {
                    d.eW(a.this.drW());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drD() {
                    d.eX(a.this.drY());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drE() {
                    d.eY(a.this.dsa());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drV() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.lWi == null);
                com.facebook.common.internal.g.checkArgument(this.lWj == null);
                if (this.lWe.isEmpty()) {
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.lWe.iterator().next().second;
                this.lWi = new d(akVar.drv(), akVar.getId(), akVar.drw(), akVar.dmd(), akVar.drx(), drX(), drZ(), dsb());
                this.lWj = new C0668a();
                ad.this.lUZ.c(this.lWj, this.lWi);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> drW() {
            return this.lWi == null ? null : this.lWi.vs(drX());
        }

        private synchronized boolean drX() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lWe.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dry()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> drY() {
            List<al> vt;
            if (this.lWi == null) {
                vt = null;
            } else {
                vt = this.lWi.vt(drZ());
            }
            return vt;
        }

        private synchronized boolean drZ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lWe.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).drA()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dsa() {
            return this.lWi == null ? null : this.lWi.a(dsb());
        }

        private synchronized Priority dsb() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.lWe.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).drz());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0668a c0668a, Throwable th) {
            synchronized (this) {
                if (this.lWj == c0668a) {
                    Iterator<Pair<k<T>, ak>> it = this.lWe.iterator();
                    this.lWe.clear();
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    closeSafely(this.lWf);
                    this.lWf = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0668a c0668a, T t, int i) {
            synchronized (this) {
                if (this.lWj == c0668a) {
                    closeSafely(this.lWf);
                    this.lWf = null;
                    Iterator<Pair<k<T>, ak>> it = this.lWe.iterator();
                    if (b.IK(i)) {
                        this.lWf = (T) ad.this.d(t);
                        this.lWh = i;
                    } else {
                        this.lWe.clear();
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

        public void a(ad<K, T>.a.C0668a c0668a) {
            synchronized (this) {
                if (this.lWj == c0668a) {
                    this.lWj = null;
                    this.lWi = null;
                    closeSafely(this.lWf);
                    this.lWf = null;
                    drV();
                }
            }
        }

        public void a(ad<K, T>.a.C0668a c0668a, float f) {
            synchronized (this) {
                if (this.lWj == c0668a) {
                    this.lWg = f;
                    Iterator<Pair<k<T>, ak>> it = this.lWe.iterator();
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
        public class C0668a extends b<T> {
            private C0668a() {
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
            protected void dqf() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bs(float f) {
                a.this.a(this, f);
            }
        }
    }
}

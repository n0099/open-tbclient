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
    private final aj<T> lVb;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> lWf = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T d(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.lVb = ajVar;
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
        bu.drX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bu(K k) {
        return this.lWf.get(k);
    }

    private synchronized ad<K, T>.a bv(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.lWf.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.lWf.get(k) == aVar) {
            this.lWf.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final K bz;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> lWg = com.facebook.common.internal.i.dkJ();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T lWh;
        @GuardedBy("Multiplexer.this")
        private float lWi;
        @GuardedBy("Multiplexer.this")
        private int lWj;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d lWk;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0668a lWl;

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
                this.lWg.add(create);
                List<al> drY = drY();
                List<al> dsc = dsc();
                List<al> dsa = dsa();
                Closeable closeable = this.lWh;
                float f = this.lWi;
                int i = this.lWj;
                d.eW(drY);
                d.eY(dsc);
                d.eX(dsa);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.lWh) {
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
                public void dnP() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.lWg.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.lWg.isEmpty()) {
                            list2 = null;
                            dVar = a.this.lWk;
                            list = null;
                        } else {
                            List drY = a.this.drY();
                            list = a.this.dsc();
                            list2 = drY;
                            dVar = null;
                            list3 = a.this.dsa();
                        }
                    }
                    d.eW(list2);
                    d.eY(list);
                    d.eX(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dkE();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drE() {
                    d.eW(a.this.drY());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drF() {
                    d.eX(a.this.dsa());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drG() {
                    d.eY(a.this.dsc());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drX() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.lWk == null);
                com.facebook.common.internal.g.checkArgument(this.lWl == null);
                if (this.lWg.isEmpty()) {
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.lWg.iterator().next().second;
                this.lWk = new d(akVar.drx(), akVar.getId(), akVar.dry(), akVar.dmf(), akVar.drz(), drZ(), dsb(), dsd());
                this.lWl = new C0668a();
                ad.this.lVb.c(this.lWl, this.lWk);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> drY() {
            return this.lWk == null ? null : this.lWk.vs(drZ());
        }

        private synchronized boolean drZ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lWg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).drA()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dsa() {
            List<al> vt;
            if (this.lWk == null) {
                vt = null;
            } else {
                vt = this.lWk.vt(dsb());
            }
            return vt;
        }

        private synchronized boolean dsb() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lWg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).drC()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dsc() {
            return this.lWk == null ? null : this.lWk.a(dsd());
        }

        private synchronized Priority dsd() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.lWg.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).drB());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0668a c0668a, Throwable th) {
            synchronized (this) {
                if (this.lWl == c0668a) {
                    Iterator<Pair<k<T>, ak>> it = this.lWg.iterator();
                    this.lWg.clear();
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    closeSafely(this.lWh);
                    this.lWh = null;
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
                if (this.lWl == c0668a) {
                    closeSafely(this.lWh);
                    this.lWh = null;
                    Iterator<Pair<k<T>, ak>> it = this.lWg.iterator();
                    if (b.IK(i)) {
                        this.lWh = (T) ad.this.d(t);
                        this.lWj = i;
                    } else {
                        this.lWg.clear();
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
                if (this.lWl == c0668a) {
                    this.lWl = null;
                    this.lWk = null;
                    closeSafely(this.lWh);
                    this.lWh = null;
                    drX();
                }
            }
        }

        public void a(ad<K, T>.a.C0668a c0668a, float f) {
            synchronized (this) {
                if (this.lWl == c0668a) {
                    this.lWi = f;
                    Iterator<Pair<k<T>, ak>> it = this.lWg.iterator();
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
            protected void dqh() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bs(float f) {
                a.this.a(this, f);
            }
        }
    }
}

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
/* loaded from: classes9.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> lQz;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> lRD = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T d(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.lQz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a br;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                br = br(b);
                if (br == null) {
                    br = bs(b);
                    z = true;
                }
            }
        } while (!br.f(kVar, akVar));
        if (!z) {
            return;
        }
        br.dpx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a br(K k) {
        return this.lRD.get(k);
    }

    private synchronized ad<K, T>.a bs(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.lRD.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.lRD.get(k) == aVar) {
            this.lRD.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a {
        private final K bz;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> lRE = com.facebook.common.internal.i.dir();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T lRF;
        @GuardedBy("Multiplexer.this")
        private float lRG;
        @GuardedBy("Multiplexer.this")
        private int lRH;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d lRI;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0654a lRJ;

        public a(K k) {
            this.bz = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.br(this.bz) != this) {
                    return false;
                }
                this.lRE.add(create);
                List<al> dpy = dpy();
                List<al> dpC = dpC();
                List<al> dpA = dpA();
                Closeable closeable = this.lRF;
                float f = this.lRG;
                int i = this.lRH;
                d.fb(dpy);
                d.fd(dpC);
                d.fc(dpA);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.lRF) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.d(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aM(f);
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
                public void dlt() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.lRE.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.lRE.isEmpty()) {
                            list2 = null;
                            dVar = a.this.lRI;
                            list = null;
                        } else {
                            List dpy = a.this.dpy();
                            list = a.this.dpC();
                            list2 = dpy;
                            dVar = null;
                            list3 = a.this.dpA();
                        }
                    }
                    d.fb(list2);
                    d.fd(list);
                    d.fc(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dim();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dpe() {
                    d.fb(a.this.dpy());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dpf() {
                    d.fc(a.this.dpA());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dpg() {
                    d.fd(a.this.dpC());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dpx() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.lRI == null);
                com.facebook.common.internal.g.checkArgument(this.lRJ == null);
                if (this.lRE.isEmpty()) {
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.lRE.iterator().next().second;
                this.lRI = new d(akVar.doX(), akVar.getId(), akVar.doY(), akVar.djN(), akVar.doZ(), dpz(), dpB(), dpD());
                this.lRJ = new C0654a();
                ad.this.lQz.c(this.lRJ, this.lRI);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dpy() {
            return this.lRI == null ? null : this.lRI.vc(dpz());
        }

        private synchronized boolean dpz() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lRE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dpa()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dpA() {
            List<al> vd;
            if (this.lRI == null) {
                vd = null;
            } else {
                vd = this.lRI.vd(dpB());
            }
            return vd;
        }

        private synchronized boolean dpB() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lRE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dpc()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dpC() {
            return this.lRI == null ? null : this.lRI.a(dpD());
        }

        private synchronized Priority dpD() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.lRE.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dpb());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0654a c0654a, Throwable th) {
            synchronized (this) {
                if (this.lRJ == c0654a) {
                    Iterator<Pair<k<T>, ak>> it = this.lRE.iterator();
                    this.lRE.clear();
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    closeSafely(this.lRF);
                    this.lRF = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).D(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0654a c0654a, T t, int i) {
            synchronized (this) {
                if (this.lRJ == c0654a) {
                    closeSafely(this.lRF);
                    this.lRF = null;
                    Iterator<Pair<k<T>, ak>> it = this.lRE.iterator();
                    if (b.Iw(i)) {
                        this.lRF = (T) ad.this.d(t);
                        this.lRH = i;
                    } else {
                        this.lRE.clear();
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

        public void a(ad<K, T>.a.C0654a c0654a) {
            synchronized (this) {
                if (this.lRJ == c0654a) {
                    this.lRJ = null;
                    this.lRI = null;
                    closeSafely(this.lRF);
                    this.lRF = null;
                    dpx();
                }
            }
        }

        public void a(ad<K, T>.a.C0654a c0654a, float f) {
            synchronized (this) {
                if (this.lRJ == c0654a) {
                    this.lRG = f;
                    Iterator<Pair<k<T>, ak>> it = this.lRE.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aM(f);
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
        /* loaded from: classes9.dex */
        public class C0654a extends b<T> {
            private C0654a() {
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
            protected void dnL() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bt(float f) {
                a.this.a(this, f);
            }
        }
    }
}

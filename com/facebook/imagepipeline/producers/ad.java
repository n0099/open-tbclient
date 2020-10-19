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
    private final aj<T> nXr;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> nYv = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.nXr = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bx;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bx = bx(b);
                if (bx == null) {
                    bx = by(b);
                    z = true;
                }
            }
        } while (!bx.f(kVar, akVar));
        if (!z) {
            return;
        }
        bx.edG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bx(K k) {
        return this.nYv.get(k);
    }

    private synchronized ad<K, T>.a by(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.nYv.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.nYv.get(k) == aVar) {
            this.nYv.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a {
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d nYA;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0891a nYB;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> nYw = com.facebook.common.internal.i.dWr();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T nYx;
        @GuardedBy("Multiplexer.this")
        private float nYy;
        @GuardedBy("Multiplexer.this")
        private int nYz;
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
                if (ad.this.bx(this.yT) != this) {
                    return false;
                }
                this.nYw.add(create);
                List<al> edH = edH();
                List<al> edL = edL();
                List<al> edJ = edJ();
                Closeable closeable = this.nYx;
                float f = this.nYy;
                int i = this.nYz;
                d.fX(edH);
                d.fZ(edL);
                d.fY(edJ);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.nYx) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aJ(f);
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
                public void dZy() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.nYw.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.nYw.isEmpty()) {
                            list2 = null;
                            dVar = a.this.nYA;
                            list = null;
                        } else {
                            List edH = a.this.edH();
                            list = a.this.edL();
                            list2 = edH;
                            dVar = null;
                            list3 = a.this.edJ();
                        }
                    }
                    d.fX(list2);
                    d.fZ(list);
                    d.fY(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dWm();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void edn() {
                    d.fX(a.this.edH());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void edo() {
                    d.fY(a.this.edJ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void edp() {
                    d.fZ(a.this.edL());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void edG() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.nYA == null);
                com.facebook.common.internal.g.checkArgument(this.nYB == null);
                if (this.nYw.isEmpty()) {
                    ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.nYw.iterator().next().second;
                this.nYA = new d(akVar.edg(), akVar.getId(), akVar.edh(), akVar.dXM(), akVar.edi(), edI(), edK(), edM());
                this.nYB = new C0891a();
                ad.this.nXr.c(this.nYB, this.nYA);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> edH() {
            return this.nYA == null ? null : this.nYA.yW(edI());
        }

        private synchronized boolean edI() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nYw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).edj()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> edJ() {
            List<al> yX;
            if (this.nYA == null) {
                yX = null;
            } else {
                yX = this.nYA.yX(edK());
            }
            return yX;
        }

        private synchronized boolean edK() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nYw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).edl()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> edL() {
            return this.nYA == null ? null : this.nYA.a(edM());
        }

        private synchronized Priority edM() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.nYw.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).edk());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0891a c0891a, Throwable th) {
            synchronized (this) {
                if (this.nYB == c0891a) {
                    Iterator<Pair<k<T>, ak>> it = this.nYw.iterator();
                    this.nYw.clear();
                    ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    closeSafely(this.nYx);
                    this.nYx = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).E(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0891a c0891a, T t, int i) {
            synchronized (this) {
                if (this.nYB == c0891a) {
                    closeSafely(this.nYx);
                    this.nYx = null;
                    Iterator<Pair<k<T>, ak>> it = this.nYw.iterator();
                    if (b.Nx(i)) {
                        this.nYx = (T) ad.this.g(t);
                        this.nYz = i;
                    } else {
                        this.nYw.clear();
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

        public void a(ad<K, T>.a.C0891a c0891a) {
            synchronized (this) {
                if (this.nYB == c0891a) {
                    this.nYB = null;
                    this.nYA = null;
                    closeSafely(this.nYx);
                    this.nYx = null;
                    edG();
                }
            }
        }

        public void a(ad<K, T>.a.C0891a c0891a, float f) {
            synchronized (this) {
                if (this.nYB == c0891a) {
                    this.nYy = f;
                    Iterator<Pair<k<T>, ak>> it = this.nYw.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aJ(f);
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
        public class C0891a extends b<T> {
            private C0891a() {
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
            protected void ebR() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aY(float f) {
                a.this.a(this, f);
            }
        }
    }
}

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
    private final aj<T> myy;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> mzC = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.myy = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bp;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bp = bp(b);
                if (bp == null) {
                    bp = bq(b);
                    z = true;
                }
            }
        } while (!bp.f(kVar, akVar));
        if (!z) {
            return;
        }
        bp.dBI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bp(K k) {
        return this.mzC.get(k);
    }

    private synchronized ad<K, T>.a bq(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.mzC.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.mzC.get(k) == aVar) {
            this.mzC.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> mzD = com.facebook.common.internal.i.dur();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T mzE;
        @GuardedBy("Multiplexer.this")
        private float mzF;
        @GuardedBy("Multiplexer.this")
        private int mzG;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d mzH;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0788a mzI;
        private final K xD;

        public a(K k) {
            this.xD = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bp(this.xD) != this) {
                    return false;
                }
                this.mzD.add(create);
                List<al> dBJ = dBJ();
                List<al> dBN = dBN();
                List<al> dBL = dBL();
                Closeable closeable = this.mzE;
                float f = this.mzF;
                int i = this.mzG;
                d.fe(dBJ);
                d.fg(dBN);
                d.ff(dBL);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.mzE) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.at(f);
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
                public void dxA() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.mzD.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.mzD.isEmpty()) {
                            list2 = null;
                            dVar = a.this.mzH;
                            list = null;
                        } else {
                            List dBJ = a.this.dBJ();
                            list = a.this.dBN();
                            list2 = dBJ;
                            dVar = null;
                            list3 = a.this.dBL();
                        }
                    }
                    d.fe(list2);
                    d.fg(list);
                    d.ff(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dum();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBp() {
                    d.fe(a.this.dBJ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBq() {
                    d.ff(a.this.dBL());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBr() {
                    d.fg(a.this.dBN());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dBI() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.mzH == null);
                com.facebook.common.internal.g.checkArgument(this.mzI == null);
                if (this.mzD.isEmpty()) {
                    ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.mzD.iterator().next().second;
                this.mzH = new d(akVar.dBi(), akVar.getId(), akVar.dBj(), akVar.dvM(), akVar.dBk(), dBK(), dBM(), dBO());
                this.mzI = new C0788a();
                ad.this.myy.c(this.mzI, this.mzH);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dBJ() {
            return this.mzH == null ? null : this.mzH.wk(dBK());
        }

        private synchronized boolean dBK() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mzD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dBl()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dBL() {
            List<al> wl;
            if (this.mzH == null) {
                wl = null;
            } else {
                wl = this.mzH.wl(dBM());
            }
            return wl;
        }

        private synchronized boolean dBM() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mzD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dBn()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dBN() {
            return this.mzH == null ? null : this.mzH.a(dBO());
        }

        private synchronized Priority dBO() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.mzD.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dBm());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0788a c0788a, Throwable th) {
            synchronized (this) {
                if (this.mzI == c0788a) {
                    Iterator<Pair<k<T>, ak>> it = this.mzD.iterator();
                    this.mzD.clear();
                    ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
                    closeSafely(this.mzE);
                    this.mzE = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).G(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0788a c0788a, T t, int i) {
            synchronized (this) {
                if (this.mzI == c0788a) {
                    closeSafely(this.mzE);
                    this.mzE = null;
                    Iterator<Pair<k<T>, ak>> it = this.mzD.iterator();
                    if (b.Ie(i)) {
                        this.mzE = (T) ad.this.g(t);
                        this.mzG = i;
                    } else {
                        this.mzD.clear();
                        ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C0788a c0788a) {
            synchronized (this) {
                if (this.mzI == c0788a) {
                    this.mzI = null;
                    this.mzH = null;
                    closeSafely(this.mzE);
                    this.mzE = null;
                    dBI();
                }
            }
        }

        public void a(ad<K, T>.a.C0788a c0788a, float f) {
            synchronized (this) {
                if (this.mzI == c0788a) {
                    this.mzF = f;
                    Iterator<Pair<k<T>, ak>> it = this.mzD.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).at(f);
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
        public class C0788a extends b<T> {
            private C0788a() {
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
            protected void dzT() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aH(float f) {
                a.this.a(this, f);
            }
        }
    }
}

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
/* loaded from: classes3.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> pBg;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> pCl = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T h(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.pBg = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bB;
        K b2 = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bB = bB(b2);
                if (bB == null) {
                    bB = bC(b2);
                    z = true;
                }
            }
        } while (!bB.e(kVar, akVar));
        if (!z) {
            return;
        }
        bB.exp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bB(K k) {
        return this.pCl.get(k);
    }

    private synchronized ad<K, T>.a bC(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.pCl.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.pCl.get(k) == aVar) {
            this.pCl.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        private final K mKey;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> pCm = com.facebook.common.internal.i.eqh();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T pCn;
        @GuardedBy("Multiplexer.this")
        private float pCo;
        @GuardedBy("Multiplexer.this")
        private int pCp;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d pCq;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C1050a pCr;

        public a(K k) {
            this.mKey = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean e(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bB(this.mKey) != this) {
                    return false;
                }
                this.pCm.add(create);
                List<al> exq = exq();
                List<al> exu = exu();
                List<al> exs = exs();
                Closeable closeable = this.pCn;
                float f = this.pCo;
                int i = this.pCp;
                d.gO(exq);
                d.gQ(exu);
                d.gP(exs);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.pCn) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.h(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aX(f);
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
                public void ewW() {
                    boolean remove;
                    List list;
                    List list2;
                    List list3;
                    d dVar;
                    synchronized (a.this) {
                        remove = a.this.pCm.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            list3 = null;
                            dVar = null;
                        } else if (a.this.pCm.isEmpty()) {
                            dVar = a.this.pCq;
                            list = null;
                            list2 = null;
                            list3 = null;
                        } else {
                            list3 = a.this.exq();
                            list2 = a.this.exu();
                            list = a.this.exs();
                            dVar = null;
                        }
                    }
                    d.gO(list3);
                    d.gQ(list2);
                    d.gP(list);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).eqc();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewX() {
                    d.gO(a.this.exq());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewY() {
                    d.gP(a.this.exs());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewZ() {
                    d.gQ(a.this.exu());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exp() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.pCq == null);
                com.facebook.common.internal.g.checkArgument(this.pCr == null);
                if (this.pCm.isEmpty()) {
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.pCm.iterator().next().second;
                this.pCq = new d(akVar.ewP(), akVar.getId(), akVar.ewQ(), akVar.erD(), akVar.ewR(), exr(), ext(), exv());
                this.pCr = new C1050a();
                ad.this.pBg.a(this.pCr, this.pCq);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> exq() {
            return this.pCq == null ? null : this.pCq.Bb(exr());
        }

        private synchronized boolean exr() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pCm.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).ewS()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> exs() {
            List<al> Bc;
            if (this.pCq == null) {
                Bc = null;
            } else {
                Bc = this.pCq.Bc(ext());
            }
            return Bc;
        }

        private synchronized boolean ext() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pCm.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).ewU()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> exu() {
            return this.pCq == null ? null : this.pCq.a(exv());
        }

        private synchronized Priority exv() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.pCm.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).ewT());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C1050a c1050a, Throwable th) {
            synchronized (this) {
                if (this.pCr == c1050a) {
                    Iterator<Pair<k<T>, ak>> it = this.pCm.iterator();
                    this.pCm.clear();
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    closeSafely(this.pCn);
                    this.pCn = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).D(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1050a c1050a, T t, int i) {
            synchronized (this) {
                if (this.pCr == c1050a) {
                    closeSafely(this.pCn);
                    this.pCn = null;
                    Iterator<Pair<k<T>, ak>> it = this.pCm.iterator();
                    if (b.PP(i)) {
                        this.pCn = (T) ad.this.h(t);
                        this.pCp = i;
                    } else {
                        this.pCm.clear();
                        ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C1050a c1050a) {
            synchronized (this) {
                if (this.pCr == c1050a) {
                    this.pCr = null;
                    this.pCq = null;
                    closeSafely(this.pCn);
                    this.pCn = null;
                    exp();
                }
            }
        }

        public void a(ad<K, T>.a.C1050a c1050a, float f) {
            synchronized (this) {
                if (this.pCr == c1050a) {
                    this.pCo = f;
                    Iterator<Pair<k<T>, ak>> it = this.pCm.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aX(f);
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
        /* loaded from: classes3.dex */
        public class C1050a extends b<T> {
            private C1050a() {
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
            protected void evD() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bK(float f) {
                a.this.a(this, f);
            }
        }
    }
}

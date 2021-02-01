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
/* loaded from: classes5.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> pLo;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> pMt = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.pLo = ajVar;
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
        bB.ezH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bB(K k) {
        return this.pMt.get(k);
    }

    private synchronized ad<K, T>.a bC(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.pMt.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.pMt.get(k) == aVar) {
            this.pMt.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        private final K mKey;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> pMu = com.facebook.common.internal.i.esA();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T pMv;
        @GuardedBy("Multiplexer.this")
        private float pMw;
        @GuardedBy("Multiplexer.this")
        private int pMx;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d pMy;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C1054a pMz;

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
                this.pMu.add(create);
                List<al> ezI = ezI();
                List<al> ezM = ezM();
                List<al> ezK = ezK();
                Closeable closeable = this.pMv;
                float f = this.pMw;
                int i = this.pMx;
                d.gM(ezI);
                d.gO(ezM);
                d.gN(ezK);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.pMv) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.ba(f);
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
                public void ezo() {
                    boolean remove;
                    List list;
                    List list2;
                    List list3;
                    d dVar;
                    synchronized (a.this) {
                        remove = a.this.pMu.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            list3 = null;
                            dVar = null;
                        } else if (a.this.pMu.isEmpty()) {
                            dVar = a.this.pMy;
                            list = null;
                            list2 = null;
                            list3 = null;
                        } else {
                            list3 = a.this.ezI();
                            list2 = a.this.ezM();
                            list = a.this.ezK();
                            dVar = null;
                        }
                    }
                    d.gM(list3);
                    d.gO(list2);
                    d.gN(list);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).esv();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezp() {
                    d.gM(a.this.ezI());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezq() {
                    d.gN(a.this.ezK());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezr() {
                    d.gO(a.this.ezM());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezH() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.pMy == null);
                com.facebook.common.internal.g.checkArgument(this.pMz == null);
                if (this.pMu.isEmpty()) {
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.pMu.iterator().next().second;
                this.pMy = new d(akVar.ezh(), akVar.getId(), akVar.ezi(), akVar.etV(), akVar.ezj(), ezJ(), ezL(), ezN());
                this.pMz = new C1054a();
                ad.this.pLo.a(this.pMz, this.pMy);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ezI() {
            return this.pMy == null ? null : this.pMy.Bu(ezJ());
        }

        private synchronized boolean ezJ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pMu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).ezk()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ezK() {
            List<al> Bv;
            if (this.pMy == null) {
                Bv = null;
            } else {
                Bv = this.pMy.Bv(ezL());
            }
            return Bv;
        }

        private synchronized boolean ezL() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pMu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).ezm()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ezM() {
            return this.pMy == null ? null : this.pMy.a(ezN());
        }

        private synchronized Priority ezN() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.pMu.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).ezl());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C1054a c1054a, Throwable th) {
            synchronized (this) {
                if (this.pMz == c1054a) {
                    Iterator<Pair<k<T>, ak>> it = this.pMu.iterator();
                    this.pMu.clear();
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    closeSafely(this.pMv);
                    this.pMv = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1054a c1054a, T t, int i) {
            synchronized (this) {
                if (this.pMz == c1054a) {
                    closeSafely(this.pMv);
                    this.pMv = null;
                    Iterator<Pair<k<T>, ak>> it = this.pMu.iterator();
                    if (b.Qk(i)) {
                        this.pMv = (T) ad.this.g(t);
                        this.pMx = i;
                    } else {
                        this.pMu.clear();
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

        public void a(ad<K, T>.a.C1054a c1054a) {
            synchronized (this) {
                if (this.pMz == c1054a) {
                    this.pMz = null;
                    this.pMy = null;
                    closeSafely(this.pMv);
                    this.pMv = null;
                    ezH();
                }
            }
        }

        public void a(ad<K, T>.a.C1054a c1054a, float f) {
            synchronized (this) {
                if (this.pMz == c1054a) {
                    this.pMw = f;
                    Iterator<Pair<k<T>, ak>> it = this.pMu.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).ba(f);
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
        /* loaded from: classes5.dex */
        public class C1054a extends b<T> {
            private C1054a() {
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
            protected void exW() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bN(float f) {
                a.this.a(this, f);
            }
        }
    }
}

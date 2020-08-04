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
/* loaded from: classes4.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> ndV;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> nfa = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.ndV = ajVar;
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
        bq.dJP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bq(K k) {
        return this.nfa.get(k);
    }

    private synchronized ad<K, T>.a br(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.nfa.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.nfa.get(k) == aVar) {
            this.nfa.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> nfb = com.facebook.common.internal.i.dCz();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T nfc;
        @GuardedBy("Multiplexer.this")
        private float nfd;
        @GuardedBy("Multiplexer.this")
        private int nfe;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d nff;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0818a nfg;
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
                this.nfb.add(create);
                List<al> dJQ = dJQ();
                List<al> dJU = dJU();
                List<al> dJS = dJS();
                Closeable closeable = this.nfc;
                float f = this.nfd;
                int i = this.nfe;
                d.fB(dJQ);
                d.fD(dJU);
                d.fC(dJS);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.nfc) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.ax(f);
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
                public void dFH() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.nfb.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.nfb.isEmpty()) {
                            list2 = null;
                            dVar = a.this.nff;
                            list = null;
                        } else {
                            List dJQ = a.this.dJQ();
                            list = a.this.dJU();
                            list2 = dJQ;
                            dVar = null;
                            list3 = a.this.dJS();
                        }
                    }
                    d.fB(list2);
                    d.fD(list);
                    d.fC(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dCu();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJw() {
                    d.fB(a.this.dJQ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJx() {
                    d.fC(a.this.dJS());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJy() {
                    d.fD(a.this.dJU());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJP() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.nff == null);
                com.facebook.common.internal.g.checkArgument(this.nfg == null);
                if (this.nfb.isEmpty()) {
                    ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.nfb.iterator().next().second;
                this.nff = new d(akVar.dJp(), akVar.getId(), akVar.dJq(), akVar.dDU(), akVar.dJr(), dJR(), dJT(), dJV());
                this.nfg = new C0818a();
                ad.this.ndV.c(this.nfg, this.nff);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dJQ() {
            return this.nff == null ? null : this.nff.xn(dJR());
        }

        private synchronized boolean dJR() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nfb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dJs()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dJS() {
            List<al> xo;
            if (this.nff == null) {
                xo = null;
            } else {
                xo = this.nff.xo(dJT());
            }
            return xo;
        }

        private synchronized boolean dJT() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.nfb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dJu()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dJU() {
            return this.nff == null ? null : this.nff.a(dJV());
        }

        private synchronized Priority dJV() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.nfb.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dJt());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0818a c0818a, Throwable th) {
            synchronized (this) {
                if (this.nfg == c0818a) {
                    Iterator<Pair<k<T>, ak>> it = this.nfb.iterator();
                    this.nfb.clear();
                    ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
                    closeSafely(this.nfc);
                    this.nfc = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).F(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0818a c0818a, T t, int i) {
            synchronized (this) {
                if (this.nfg == c0818a) {
                    closeSafely(this.nfc);
                    this.nfc = null;
                    Iterator<Pair<k<T>, ak>> it = this.nfb.iterator();
                    if (b.JI(i)) {
                        this.nfc = (T) ad.this.g(t);
                        this.nfe = i;
                    } else {
                        this.nfb.clear();
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

        public void a(ad<K, T>.a.C0818a c0818a) {
            synchronized (this) {
                if (this.nfg == c0818a) {
                    this.nfg = null;
                    this.nff = null;
                    closeSafely(this.nfc);
                    this.nfc = null;
                    dJP();
                }
            }
        }

        public void a(ad<K, T>.a.C0818a c0818a, float f) {
            synchronized (this) {
                if (this.nfg == c0818a) {
                    this.nfd = f;
                    Iterator<Pair<k<T>, ak>> it = this.nfb.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).ax(f);
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
        /* loaded from: classes4.dex */
        public class C0818a extends b<T> {
            private C0818a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void E(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void dIa() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aM(float f) {
                a.this.a(this, f);
            }
        }
    }
}

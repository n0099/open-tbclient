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
    private final aj<T> ndT;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> neY = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.ndT = ajVar;
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
        bq.dJO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bq(K k) {
        return this.neY.get(k);
    }

    private synchronized ad<K, T>.a br(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.neY.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.neY.get(k) == aVar) {
            this.neY.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> neZ = com.facebook.common.internal.i.dCy();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T nfa;
        @GuardedBy("Multiplexer.this")
        private float nfb;
        @GuardedBy("Multiplexer.this")
        private int nfc;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d nfd;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0818a nfe;
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
                this.neZ.add(create);
                List<al> dJP = dJP();
                List<al> dJT = dJT();
                List<al> dJR = dJR();
                Closeable closeable = this.nfa;
                float f = this.nfb;
                int i = this.nfc;
                d.fB(dJP);
                d.fD(dJT);
                d.fC(dJR);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.nfa) {
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
                public void dFG() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.neZ.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.neZ.isEmpty()) {
                            list2 = null;
                            dVar = a.this.nfd;
                            list = null;
                        } else {
                            List dJP = a.this.dJP();
                            list = a.this.dJT();
                            list2 = dJP;
                            dVar = null;
                            list3 = a.this.dJR();
                        }
                    }
                    d.fB(list2);
                    d.fD(list);
                    d.fC(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dCt();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJv() {
                    d.fB(a.this.dJP());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJw() {
                    d.fC(a.this.dJR());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJx() {
                    d.fD(a.this.dJT());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJO() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.nfd == null);
                com.facebook.common.internal.g.checkArgument(this.nfe == null);
                if (this.neZ.isEmpty()) {
                    ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.neZ.iterator().next().second;
                this.nfd = new d(akVar.dJo(), akVar.getId(), akVar.dJp(), akVar.dDT(), akVar.dJq(), dJQ(), dJS(), dJU());
                this.nfe = new C0818a();
                ad.this.ndT.c(this.nfe, this.nfd);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dJP() {
            return this.nfd == null ? null : this.nfd.xn(dJQ());
        }

        private synchronized boolean dJQ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.neZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dJr()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dJR() {
            List<al> xo;
            if (this.nfd == null) {
                xo = null;
            } else {
                xo = this.nfd.xo(dJS());
            }
            return xo;
        }

        private synchronized boolean dJS() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.neZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dJt()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dJT() {
            return this.nfd == null ? null : this.nfd.a(dJU());
        }

        private synchronized Priority dJU() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.neZ.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dJs());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0818a c0818a, Throwable th) {
            synchronized (this) {
                if (this.nfe == c0818a) {
                    Iterator<Pair<k<T>, ak>> it = this.neZ.iterator();
                    this.neZ.clear();
                    ad.this.a((ad) this.yd, (ad<ad, T>.a) this);
                    closeSafely(this.nfa);
                    this.nfa = null;
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
                if (this.nfe == c0818a) {
                    closeSafely(this.nfa);
                    this.nfa = null;
                    Iterator<Pair<k<T>, ak>> it = this.neZ.iterator();
                    if (b.JI(i)) {
                        this.nfa = (T) ad.this.g(t);
                        this.nfc = i;
                    } else {
                        this.neZ.clear();
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
                if (this.nfe == c0818a) {
                    this.nfe = null;
                    this.nfd = null;
                    closeSafely(this.nfa);
                    this.nfa = null;
                    dJO();
                }
            }
        }

        public void a(ad<K, T>.a.C0818a c0818a, float f) {
            synchronized (this) {
                if (this.nfe == c0818a) {
                    this.nfb = f;
                    Iterator<Pair<k<T>, ak>> it = this.neZ.iterator();
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
            protected void dHZ() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aM(float f) {
                a.this.a(this, f);
            }
        }
    }
}

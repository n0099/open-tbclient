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
    private final aj<T> oOJ;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> oPN = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.oOJ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bB;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bB = bB(b);
                if (bB == null) {
                    bB = bC(b);
                    z = true;
                }
            }
        } while (!bB.f(kVar, akVar));
        if (!z) {
            return;
        }
        bB.enF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bB(K k) {
        return this.oPN.get(k);
    }

    private synchronized ad<K, T>.a bC(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.oPN.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.oPN.get(k) == aVar) {
            this.oPN.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> oPO = com.facebook.common.internal.i.egp();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T oPP;
        @GuardedBy("Multiplexer.this")
        private float oPQ;
        @GuardedBy("Multiplexer.this")
        private int oPR;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d oPS;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0963a oPT;
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
                if (ad.this.bB(this.yT) != this) {
                    return false;
                }
                this.oPO.add(create);
                List<al> enG = enG();
                List<al> enK = enK();
                List<al> enI = enI();
                Closeable closeable = this.oPP;
                float f = this.oPQ;
                int i = this.oPR;
                d.gt(enG);
                d.gv(enK);
                d.gu(enI);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.oPP) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aL(f);
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
                public void ejw() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.oPO.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.oPO.isEmpty()) {
                            list2 = null;
                            dVar = a.this.oPS;
                            list = null;
                        } else {
                            List enG = a.this.enG();
                            list = a.this.enK();
                            list2 = enG;
                            dVar = null;
                            list3 = a.this.enI();
                        }
                    }
                    d.gt(list2);
                    d.gv(list);
                    d.gu(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).egk();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enm() {
                    d.gt(a.this.enG());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enn() {
                    d.gu(a.this.enI());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eno() {
                    d.gv(a.this.enK());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void enF() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.oPS == null);
                com.facebook.common.internal.g.checkArgument(this.oPT == null);
                if (this.oPO.isEmpty()) {
                    ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.oPO.iterator().next().second;
                this.oPS = new d(akVar.enf(), akVar.getId(), akVar.eng(), akVar.ehK(), akVar.enh(), enH(), enJ(), enL());
                this.oPT = new C0963a();
                ad.this.oOJ.c(this.oPT, this.oPS);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> enG() {
            return this.oPS == null ? null : this.oPS.Ae(enH());
        }

        private synchronized boolean enH() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.oPO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).eni()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> enI() {
            List<al> Af;
            if (this.oPS == null) {
                Af = null;
            } else {
                Af = this.oPS.Af(enJ());
            }
            return Af;
        }

        private synchronized boolean enJ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.oPO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).enk()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> enK() {
            return this.oPS == null ? null : this.oPS.a(enL());
        }

        private synchronized Priority enL() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.oPO.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).enj());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0963a c0963a, Throwable th) {
            synchronized (this) {
                if (this.oPT == c0963a) {
                    Iterator<Pair<k<T>, ak>> it = this.oPO.iterator();
                    this.oPO.clear();
                    ad.this.a((ad) this.yT, (ad<ad, T>.a) this);
                    closeSafely(this.oPP);
                    this.oPP = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).E(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0963a c0963a, T t, int i) {
            synchronized (this) {
                if (this.oPT == c0963a) {
                    closeSafely(this.oPP);
                    this.oPP = null;
                    Iterator<Pair<k<T>, ak>> it = this.oPO.iterator();
                    if (b.Po(i)) {
                        this.oPP = (T) ad.this.g(t);
                        this.oPR = i;
                    } else {
                        this.oPO.clear();
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

        public void a(ad<K, T>.a.C0963a c0963a) {
            synchronized (this) {
                if (this.oPT == c0963a) {
                    this.oPT = null;
                    this.oPS = null;
                    closeSafely(this.oPP);
                    this.oPP = null;
                    enF();
                }
            }
        }

        public void a(ad<K, T>.a.C0963a c0963a, float f) {
            synchronized (this) {
                if (this.oPT == c0963a) {
                    this.oPQ = f;
                    Iterator<Pair<k<T>, ak>> it = this.oPO.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aL(f);
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
        public class C0963a extends b<T> {
            private C0963a() {
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
            protected void elP() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bp(float f) {
                a.this.a(this, f);
            }
        }
    }
}

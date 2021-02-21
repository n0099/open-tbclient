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
    private final aj<T> pLO;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> pMT = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.pLO = ajVar;
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
        bB.ezP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bB(K k) {
        return this.pMT.get(k);
    }

    private synchronized ad<K, T>.a bC(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.pMT.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.pMT.get(k) == aVar) {
            this.pMT.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a {
        private final K mKey;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> pMU = com.facebook.common.internal.i.esI();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T pMV;
        @GuardedBy("Multiplexer.this")
        private float pMW;
        @GuardedBy("Multiplexer.this")
        private int pMX;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d pMY;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C1056a pMZ;

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
                this.pMU.add(create);
                List<al> ezQ = ezQ();
                List<al> ezU = ezU();
                List<al> ezS = ezS();
                Closeable closeable = this.pMV;
                float f = this.pMW;
                int i = this.pMX;
                d.gM(ezQ);
                d.gO(ezU);
                d.gN(ezS);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.pMV) {
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
                public void ezw() {
                    boolean remove;
                    List list;
                    List list2;
                    List list3;
                    d dVar;
                    synchronized (a.this) {
                        remove = a.this.pMU.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            list3 = null;
                            dVar = null;
                        } else if (a.this.pMU.isEmpty()) {
                            dVar = a.this.pMY;
                            list = null;
                            list2 = null;
                            list3 = null;
                        } else {
                            list3 = a.this.ezQ();
                            list2 = a.this.ezU();
                            list = a.this.ezS();
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
                        ((k) pair.first).esD();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezx() {
                    d.gM(a.this.ezQ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezy() {
                    d.gN(a.this.ezS());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezz() {
                    d.gO(a.this.ezU());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezP() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.pMY == null);
                com.facebook.common.internal.g.checkArgument(this.pMZ == null);
                if (this.pMU.isEmpty()) {
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.pMU.iterator().next().second;
                this.pMY = new d(akVar.ezp(), akVar.getId(), akVar.ezq(), akVar.eud(), akVar.ezr(), ezR(), ezT(), ezV());
                this.pMZ = new C1056a();
                ad.this.pLO.a(this.pMZ, this.pMY);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ezQ() {
            return this.pMY == null ? null : this.pMY.Bu(ezR());
        }

        private synchronized boolean ezR() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pMU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).ezs()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ezS() {
            List<al> Bv;
            if (this.pMY == null) {
                Bv = null;
            } else {
                Bv = this.pMY.Bv(ezT());
            }
            return Bv;
        }

        private synchronized boolean ezT() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.pMU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).ezu()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ezU() {
            return this.pMY == null ? null : this.pMY.a(ezV());
        }

        private synchronized Priority ezV() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.pMU.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).ezt());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C1056a c1056a, Throwable th) {
            synchronized (this) {
                if (this.pMZ == c1056a) {
                    Iterator<Pair<k<T>, ak>> it = this.pMU.iterator();
                    this.pMU.clear();
                    ad.this.a((ad) this.mKey, (ad<ad, T>.a) this);
                    closeSafely(this.pMV);
                    this.pMV = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1056a c1056a, T t, int i) {
            synchronized (this) {
                if (this.pMZ == c1056a) {
                    closeSafely(this.pMV);
                    this.pMV = null;
                    Iterator<Pair<k<T>, ak>> it = this.pMU.iterator();
                    if (b.Ql(i)) {
                        this.pMV = (T) ad.this.g(t);
                        this.pMX = i;
                    } else {
                        this.pMU.clear();
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

        public void a(ad<K, T>.a.C1056a c1056a) {
            synchronized (this) {
                if (this.pMZ == c1056a) {
                    this.pMZ = null;
                    this.pMY = null;
                    closeSafely(this.pMV);
                    this.pMV = null;
                    ezP();
                }
            }
        }

        public void a(ad<K, T>.a.C1056a c1056a, float f) {
            synchronized (this) {
                if (this.pMZ == c1056a) {
                    this.pMW = f;
                    Iterator<Pair<k<T>, ak>> it = this.pMU.iterator();
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
        public class C1056a extends b<T> {
            private C1056a() {
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
            protected void eye() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bN(float f) {
                a.this.a(this, f);
            }
        }
    }
}

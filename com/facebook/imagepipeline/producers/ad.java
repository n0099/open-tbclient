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
/* loaded from: classes15.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> poz;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> ppF = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.poz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<T> kVar, ak akVar) {
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
        } while (!bB.e(kVar, akVar));
        if (!z) {
            return;
        }
        bB.ewW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bB(K k) {
        return this.ppF.get(k);
    }

    private synchronized ad<K, T>.a bC(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.ppF.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.ppF.get(k) == aVar) {
            this.ppF.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> ppG = com.facebook.common.internal.i.epS();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T ppH;
        @GuardedBy("Multiplexer.this")
        private float ppI;
        @GuardedBy("Multiplexer.this")
        private int ppJ;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d ppK;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C1000a ppL;
        private final K zI;

        public a(K k) {
            this.zI = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean e(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bB(this.zI) != this) {
                    return false;
                }
                this.ppG.add(create);
                List<al> ewX = ewX();
                List<al> exb = exb();
                List<al> ewZ = ewZ();
                Closeable closeable = this.ppH;
                float f = this.ppI;
                int i = this.ppJ;
                d.gR(ewX);
                d.gT(exb);
                d.gS(ewZ);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.ppH) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aV(f);
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
                public void ewD() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.ppG.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.ppG.isEmpty()) {
                            list2 = null;
                            dVar = a.this.ppK;
                            list = null;
                        } else {
                            List ewX = a.this.ewX();
                            list = a.this.exb();
                            list2 = ewX;
                            dVar = null;
                            list3 = a.this.ewZ();
                        }
                    }
                    d.gR(list2);
                    d.gT(list);
                    d.gS(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).epN();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewE() {
                    d.gR(a.this.ewX());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewF() {
                    d.gS(a.this.ewZ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewG() {
                    d.gT(a.this.exb());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ewW() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.ppK == null);
                com.facebook.common.internal.g.checkArgument(this.ppL == null);
                if (this.ppG.isEmpty()) {
                    ad.this.a((ad) this.zI, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.ppG.iterator().next().second;
                this.ppK = new d(akVar.eww(), akVar.getId(), akVar.ewx(), akVar.ern(), akVar.ewy(), ewY(), exa(), exc());
                this.ppL = new C1000a();
                ad.this.poz.a(this.ppL, this.ppK);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ewX() {
            return this.ppK == null ? null : this.ppK.AX(ewY());
        }

        private synchronized boolean ewY() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.ppG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).ewz()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ewZ() {
            List<al> AY;
            if (this.ppK == null) {
                AY = null;
            } else {
                AY = this.ppK.AY(exa());
            }
            return AY;
        }

        private synchronized boolean exa() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.ppG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).ewB()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> exb() {
            return this.ppK == null ? null : this.ppK.a(exc());
        }

        private synchronized Priority exc() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.ppG.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).ewA());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C1000a c1000a, Throwable th) {
            synchronized (this) {
                if (this.ppL == c1000a) {
                    Iterator<Pair<k<T>, ak>> it = this.ppG.iterator();
                    this.ppG.clear();
                    ad.this.a((ad) this.zI, (ad<ad, T>.a) this);
                    closeSafely(this.ppH);
                    this.ppH = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).E(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C1000a c1000a, T t, int i) {
            synchronized (this) {
                if (this.ppL == c1000a) {
                    closeSafely(this.ppH);
                    this.ppH = null;
                    Iterator<Pair<k<T>, ak>> it = this.ppG.iterator();
                    if (b.Ri(i)) {
                        this.ppH = (T) ad.this.g(t);
                        this.ppJ = i;
                    } else {
                        this.ppG.clear();
                        ad.this.a((ad) this.zI, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C1000a c1000a) {
            synchronized (this) {
                if (this.ppL == c1000a) {
                    this.ppL = null;
                    this.ppK = null;
                    closeSafely(this.ppH);
                    this.ppH = null;
                    ewW();
                }
            }
        }

        public void a(ad<K, T>.a.C1000a c1000a, float f) {
            synchronized (this) {
                if (this.ppL == c1000a) {
                    this.ppI = f;
                    Iterator<Pair<k<T>, ak>> it = this.ppG.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aV(f);
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
        /* loaded from: classes15.dex */
        public class C1000a extends b<T> {
            private C1000a() {
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
            protected void evk() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void by(float f) {
                a.this.a(this, f);
            }
        }
    }
}

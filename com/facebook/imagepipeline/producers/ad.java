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
    private final aj<T> pox;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> ppD = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.pox = ajVar;
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
        bB.ewV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bB(K k) {
        return this.ppD.get(k);
    }

    private synchronized ad<K, T>.a bC(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.ppD.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.ppD.get(k) == aVar) {
            this.ppD.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> ppE = com.facebook.common.internal.i.epR();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T ppF;
        @GuardedBy("Multiplexer.this")
        private float ppG;
        @GuardedBy("Multiplexer.this")
        private int ppH;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d ppI;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C1000a ppJ;
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
                this.ppE.add(create);
                List<al> ewW = ewW();
                List<al> exa = exa();
                List<al> ewY = ewY();
                Closeable closeable = this.ppF;
                float f = this.ppG;
                int i = this.ppH;
                d.gR(ewW);
                d.gT(exa);
                d.gS(ewY);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.ppF) {
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
                public void ewC() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.ppE.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.ppE.isEmpty()) {
                            list2 = null;
                            dVar = a.this.ppI;
                            list = null;
                        } else {
                            List ewW = a.this.ewW();
                            list = a.this.exa();
                            list2 = ewW;
                            dVar = null;
                            list3 = a.this.ewY();
                        }
                    }
                    d.gR(list2);
                    d.gT(list);
                    d.gS(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).epM();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewD() {
                    d.gR(a.this.ewW());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewE() {
                    d.gS(a.this.ewY());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewF() {
                    d.gT(a.this.exa());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ewV() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.ppI == null);
                com.facebook.common.internal.g.checkArgument(this.ppJ == null);
                if (this.ppE.isEmpty()) {
                    ad.this.a((ad) this.zI, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.ppE.iterator().next().second;
                this.ppI = new d(akVar.ewv(), akVar.getId(), akVar.eww(), akVar.erm(), akVar.ewx(), ewX(), ewZ(), exb());
                this.ppJ = new C1000a();
                ad.this.pox.a(this.ppJ, this.ppI);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ewW() {
            return this.ppI == null ? null : this.ppI.AX(ewX());
        }

        private synchronized boolean ewX() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.ppE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).ewy()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> ewY() {
            List<al> AY;
            if (this.ppI == null) {
                AY = null;
            } else {
                AY = this.ppI.AY(ewZ());
            }
            return AY;
        }

        private synchronized boolean ewZ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.ppE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).ewA()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> exa() {
            return this.ppI == null ? null : this.ppI.a(exb());
        }

        private synchronized Priority exb() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.ppE.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).ewz());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C1000a c1000a, Throwable th) {
            synchronized (this) {
                if (this.ppJ == c1000a) {
                    Iterator<Pair<k<T>, ak>> it = this.ppE.iterator();
                    this.ppE.clear();
                    ad.this.a((ad) this.zI, (ad<ad, T>.a) this);
                    closeSafely(this.ppF);
                    this.ppF = null;
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
                if (this.ppJ == c1000a) {
                    closeSafely(this.ppF);
                    this.ppF = null;
                    Iterator<Pair<k<T>, ak>> it = this.ppE.iterator();
                    if (b.Ri(i)) {
                        this.ppF = (T) ad.this.g(t);
                        this.ppH = i;
                    } else {
                        this.ppE.clear();
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
                if (this.ppJ == c1000a) {
                    this.ppJ = null;
                    this.ppI = null;
                    closeSafely(this.ppF);
                    this.ppF = null;
                    ewV();
                }
            }
        }

        public void a(ad<K, T>.a.C1000a c1000a, float f) {
            synchronized (this) {
                if (this.ppJ == c1000a) {
                    this.ppG = f;
                    Iterator<Pair<k<T>, ak>> it = this.ppE.iterator();
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
            protected void evj() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void by(float f) {
                a.this.a(this, f);
            }
        }
    }
}

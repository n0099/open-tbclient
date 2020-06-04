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
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> mAM = new HashMap();
    private final aj<T> mzI;

    protected abstract K b(ak akVar);

    protected abstract T g(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.mzI = ajVar;
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
        bp.dBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bp(K k) {
        return this.mAM.get(k);
    }

    private synchronized ad<K, T>.a bq(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.mAM.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.mAM.get(k) == aVar) {
            this.mAM.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> mAN = com.facebook.common.internal.i.duF();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T mAO;
        @GuardedBy("Multiplexer.this")
        private float mAP;
        @GuardedBy("Multiplexer.this")
        private int mAQ;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d mAR;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0789a mAS;
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
                this.mAN.add(create);
                List<al> dBX = dBX();
                List<al> dCb = dCb();
                List<al> dBZ = dBZ();
                Closeable closeable = this.mAO;
                float f = this.mAP;
                int i = this.mAQ;
                d.fg(dBX);
                d.fi(dCb);
                d.fh(dBZ);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.mAO) {
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
                public void dxO() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.mAN.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.mAN.isEmpty()) {
                            list2 = null;
                            dVar = a.this.mAR;
                            list = null;
                        } else {
                            List dBX = a.this.dBX();
                            list = a.this.dCb();
                            list2 = dBX;
                            dVar = null;
                            list3 = a.this.dBZ();
                        }
                    }
                    d.fg(list2);
                    d.fi(list);
                    d.fh(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).duA();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBD() {
                    d.fg(a.this.dBX());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBE() {
                    d.fh(a.this.dBZ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBF() {
                    d.fi(a.this.dCb());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dBW() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.mAR == null);
                com.facebook.common.internal.g.checkArgument(this.mAS == null);
                if (this.mAN.isEmpty()) {
                    ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.mAN.iterator().next().second;
                this.mAR = new d(akVar.dBw(), akVar.getId(), akVar.dBx(), akVar.dwa(), akVar.dBy(), dBY(), dCa(), dCc());
                this.mAS = new C0789a();
                ad.this.mzI.c(this.mAS, this.mAR);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dBX() {
            return this.mAR == null ? null : this.mAR.wm(dBY());
        }

        private synchronized boolean dBY() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mAN.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dBz()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dBZ() {
            List<al> wn;
            if (this.mAR == null) {
                wn = null;
            } else {
                wn = this.mAR.wn(dCa());
            }
            return wn;
        }

        private synchronized boolean dCa() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mAN.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dBB()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dCb() {
            return this.mAR == null ? null : this.mAR.a(dCc());
        }

        private synchronized Priority dCc() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.mAN.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dBA());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0789a c0789a, Throwable th) {
            synchronized (this) {
                if (this.mAS == c0789a) {
                    Iterator<Pair<k<T>, ak>> it = this.mAN.iterator();
                    this.mAN.clear();
                    ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
                    closeSafely(this.mAO);
                    this.mAO = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).G(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0789a c0789a, T t, int i) {
            synchronized (this) {
                if (this.mAS == c0789a) {
                    closeSafely(this.mAO);
                    this.mAO = null;
                    Iterator<Pair<k<T>, ak>> it = this.mAN.iterator();
                    if (b.Ig(i)) {
                        this.mAO = (T) ad.this.g(t);
                        this.mAQ = i;
                    } else {
                        this.mAN.clear();
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

        public void a(ad<K, T>.a.C0789a c0789a) {
            synchronized (this) {
                if (this.mAS == c0789a) {
                    this.mAS = null;
                    this.mAR = null;
                    closeSafely(this.mAO);
                    this.mAO = null;
                    dBW();
                }
            }
        }

        public void a(ad<K, T>.a.C0789a c0789a, float f) {
            synchronized (this) {
                if (this.mAS == c0789a) {
                    this.mAP = f;
                    Iterator<Pair<k<T>, ak>> it = this.mAN.iterator();
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
        public class C0789a extends b<T> {
            private C0789a() {
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
            protected void dAh() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aH(float f) {
                a.this.a(this, f);
            }
        }
    }
}

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
    private final aj<T> meD;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> mfH = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.meD = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bk;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bk = bk(b);
                if (bk == null) {
                    bk = bl(b);
                    z = true;
                }
            }
        } while (!bk.f(kVar, akVar));
        if (!z) {
            return;
        }
        bk.dut();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bk(K k) {
        return this.mfH.get(k);
    }

    private synchronized ad<K, T>.a bl(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.mfH.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.mfH.get(k) == aVar) {
            this.mfH.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> mfI = com.facebook.common.internal.i.dna();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T mfJ;
        @GuardedBy("Multiplexer.this")
        private float mfK;
        @GuardedBy("Multiplexer.this")
        private int mfL;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d mfM;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0712a mfN;
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
                if (ad.this.bk(this.xD) != this) {
                    return false;
                }
                this.mfI.add(create);
                List<al> duu = duu();
                List<al> duy = duy();
                List<al> duw = duw();
                Closeable closeable = this.mfJ;
                float f = this.mfK;
                int i = this.mfL;
                d.eX(duu);
                d.eZ(duy);
                d.eY(duw);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.mfJ) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.e(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.au(f);
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
                public void dqk() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.mfI.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.mfI.isEmpty()) {
                            list2 = null;
                            dVar = a.this.mfM;
                            list = null;
                        } else {
                            List duu = a.this.duu();
                            list = a.this.duy();
                            list2 = duu;
                            dVar = null;
                            list3 = a.this.duw();
                        }
                    }
                    d.eX(list2);
                    d.eZ(list);
                    d.eY(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dmV();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dua() {
                    d.eX(a.this.duu());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dub() {
                    d.eY(a.this.duw());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void duc() {
                    d.eZ(a.this.duy());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dut() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.mfM == null);
                com.facebook.common.internal.g.checkArgument(this.mfN == null);
                if (this.mfI.isEmpty()) {
                    ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.mfI.iterator().next().second;
                this.mfM = new d(akVar.dtT(), akVar.getId(), akVar.dtU(), akVar.dow(), akVar.dtV(), duv(), dux(), duz());
                this.mfN = new C0712a();
                ad.this.meD.c(this.mfN, this.mfM);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> duu() {
            return this.mfM == null ? null : this.mfM.vM(duv());
        }

        private synchronized boolean duv() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mfI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dtW()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> duw() {
            List<al> vN;
            if (this.mfM == null) {
                vN = null;
            } else {
                vN = this.mfM.vN(dux());
            }
            return vN;
        }

        private synchronized boolean dux() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mfI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dtY()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> duy() {
            return this.mfM == null ? null : this.mfM.a(duz());
        }

        private synchronized Priority duz() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.mfI.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dtX());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0712a c0712a, Throwable th) {
            synchronized (this) {
                if (this.mfN == c0712a) {
                    Iterator<Pair<k<T>, ak>> it = this.mfI.iterator();
                    this.mfI.clear();
                    ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
                    closeSafely(this.mfJ);
                    this.mfJ = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).G(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0712a c0712a, T t, int i) {
            synchronized (this) {
                if (this.mfN == c0712a) {
                    closeSafely(this.mfJ);
                    this.mfJ = null;
                    Iterator<Pair<k<T>, ak>> it = this.mfI.iterator();
                    if (b.Hs(i)) {
                        this.mfJ = (T) ad.this.e(t);
                        this.mfL = i;
                    } else {
                        this.mfI.clear();
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

        public void a(ad<K, T>.a.C0712a c0712a) {
            synchronized (this) {
                if (this.mfN == c0712a) {
                    this.mfN = null;
                    this.mfM = null;
                    closeSafely(this.mfJ);
                    this.mfJ = null;
                    dut();
                }
            }
        }

        public void a(ad<K, T>.a.C0712a c0712a, float f) {
            synchronized (this) {
                if (this.mfN == c0712a) {
                    this.mfK = f;
                    Iterator<Pair<k<T>, ak>> it = this.mfI.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).au(f);
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
        public class C0712a extends b<T> {
            private C0712a() {
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
            protected void dsD() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aI(float f) {
                a.this.a(this, f);
            }
        }
    }
}

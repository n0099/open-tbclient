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
    private final aj<T> meH;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> mfL = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.meH = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bl;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bl = bl(b);
                if (bl == null) {
                    bl = bm(b);
                    z = true;
                }
            }
        } while (!bl.f(kVar, akVar));
        if (!z) {
            return;
        }
        bl.dur();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bl(K k) {
        return this.mfL.get(k);
    }

    private synchronized ad<K, T>.a bm(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.mfL.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.mfL.get(k) == aVar) {
            this.mfL.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> mfM = com.facebook.common.internal.i.dmY();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T mfN;
        @GuardedBy("Multiplexer.this")
        private float mfO;
        @GuardedBy("Multiplexer.this")
        private int mfP;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d mfQ;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0733a mfR;
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
                if (ad.this.bl(this.xD) != this) {
                    return false;
                }
                this.mfM.add(create);
                List<al> dus = dus();
                List<al> duw = duw();
                List<al> duu = duu();
                Closeable closeable = this.mfN;
                float f = this.mfO;
                int i = this.mfP;
                d.eX(dus);
                d.eZ(duw);
                d.eY(duu);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.mfN) {
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
                public void dqi() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.mfM.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.mfM.isEmpty()) {
                            list2 = null;
                            dVar = a.this.mfQ;
                            list = null;
                        } else {
                            List dus = a.this.dus();
                            list = a.this.duw();
                            list2 = dus;
                            dVar = null;
                            list3 = a.this.duu();
                        }
                    }
                    d.eX(list2);
                    d.eZ(list);
                    d.eY(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).dmT();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dtY() {
                    d.eX(a.this.dus());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dtZ() {
                    d.eY(a.this.duu());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dua() {
                    d.eZ(a.this.duw());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dur() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.mfQ == null);
                com.facebook.common.internal.g.checkArgument(this.mfR == null);
                if (this.mfM.isEmpty()) {
                    ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.mfM.iterator().next().second;
                this.mfQ = new d(akVar.dtR(), akVar.getId(), akVar.dtS(), akVar.dou(), akVar.dtT(), dut(), duv(), dux());
                this.mfR = new C0733a();
                ad.this.meH.c(this.mfR, this.mfQ);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dus() {
            return this.mfQ == null ? null : this.mfQ.vM(dut());
        }

        private synchronized boolean dut() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mfM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dtU()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> duu() {
            List<al> vN;
            if (this.mfQ == null) {
                vN = null;
            } else {
                vN = this.mfQ.vN(duv());
            }
            return vN;
        }

        private synchronized boolean duv() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.mfM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dtW()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> duw() {
            return this.mfQ == null ? null : this.mfQ.a(dux());
        }

        private synchronized Priority dux() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.mfM.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dtV());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0733a c0733a, Throwable th) {
            synchronized (this) {
                if (this.mfR == c0733a) {
                    Iterator<Pair<k<T>, ak>> it = this.mfM.iterator();
                    this.mfM.clear();
                    ad.this.a((ad) this.xD, (ad<ad, T>.a) this);
                    closeSafely(this.mfN);
                    this.mfN = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).G(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0733a c0733a, T t, int i) {
            synchronized (this) {
                if (this.mfR == c0733a) {
                    closeSafely(this.mfN);
                    this.mfN = null;
                    Iterator<Pair<k<T>, ak>> it = this.mfM.iterator();
                    if (b.Hs(i)) {
                        this.mfN = (T) ad.this.e(t);
                        this.mfP = i;
                    } else {
                        this.mfM.clear();
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

        public void a(ad<K, T>.a.C0733a c0733a) {
            synchronized (this) {
                if (this.mfR == c0733a) {
                    this.mfR = null;
                    this.mfQ = null;
                    closeSafely(this.mfN);
                    this.mfN = null;
                    dur();
                }
            }
        }

        public void a(ad<K, T>.a.C0733a c0733a, float f) {
            synchronized (this) {
                if (this.mfR == c0733a) {
                    this.mfO = f;
                    Iterator<Pair<k<T>, ak>> it = this.mfM.iterator();
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
        public class C0733a extends b<T> {
            private C0733a() {
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
            protected void dsB() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aI(float f) {
                a.this.a(this, f);
            }
        }
    }
}

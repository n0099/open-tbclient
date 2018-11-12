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
/* loaded from: classes2.dex */
public abstract class ad<K, T extends Closeable> implements ai<T> {
    private final ai<T> iit;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> ijB = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.iit = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a aM;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                aM = aM(b);
                if (aM == null) {
                    aM = aN(b);
                    z = true;
                }
            }
        } while (!aM.f(jVar, ajVar));
        if (!z) {
            return;
        }
        aM.bXj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a aM(K k) {
        return this.ijB.get(k);
    }

    private synchronized ad<K, T>.a aN(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.ijB.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.ijB.get(k) == aVar) {
            this.ijB.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> ijC = com.facebook.common.internal.h.bQX();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T ijD;
        @GuardedBy("Multiplexer.this")
        private float ijE;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d ijF;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0351a ijG;
        private final K jn;

        public a(K k) {
            this.jn = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.facebook.imagepipeline.producers.j<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(j<T> jVar, aj ajVar) {
            Pair<j<T>, aj> create = Pair.create(jVar, ajVar);
            synchronized (this) {
                if (ad.this.aM(this.jn) != this) {
                    return false;
                }
                this.ijC.add(create);
                List<ak> bXk = bXk();
                List<ak> bXo = bXo();
                List<ak> bXm = bXm();
                Closeable closeable = this.ijD;
                float f = this.ijE;
                d.eq(bXk);
                d.es(bXo);
                d.er(bXm);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.ijD) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.e(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.az(f);
                        }
                        jVar.e(closeable, false);
                        closeSafely(closeable);
                    }
                }
                a(create, ajVar);
                return true;
            }
        }

        private void a(final Pair<j<T>, aj> pair, aj ajVar) {
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ad.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWS() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.ijC.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.ijC.isEmpty()) {
                            list2 = null;
                            dVar = a.this.ijF;
                            list = null;
                        } else {
                            List bXk = a.this.bXk();
                            list = a.this.bXo();
                            list2 = bXk;
                            dVar = null;
                            list3 = a.this.bXm();
                        }
                    }
                    d.eq(list2);
                    d.es(list);
                    d.er(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).bQT();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWT() {
                    d.eq(a.this.bXk());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWU() {
                    d.er(a.this.bXm());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWV() {
                    d.es(a.this.bXo());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bXj() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.ijF == null);
                com.facebook.common.internal.g.checkArgument(this.ijG == null);
                if (this.ijC.isEmpty()) {
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.ijC.iterator().next().second;
                this.ijF = new d(ajVar.bWL(), ajVar.getId(), ajVar.bWM(), ajVar.bSo(), ajVar.bWN(), bXl(), bXn(), bXp());
                this.ijG = new C0351a();
                ad.this.iit.a(this.ijG, this.ijF);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bXk() {
            return this.ijF == null ? null : this.ijF.oV(bXl());
        }

        private synchronized boolean bXl() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.ijC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).bWO()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bXm() {
            List<ak> oW;
            if (this.ijF == null) {
                oW = null;
            } else {
                oW = this.ijF.oW(bXn());
            }
            return oW;
        }

        private synchronized boolean bXn() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.ijC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).bWQ()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bXo() {
            return this.ijF == null ? null : this.ijF.a(bXp());
        }

        private synchronized Priority bXp() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.ijC.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).bWP());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0351a c0351a, Throwable th) {
            synchronized (this) {
                if (this.ijG == c0351a) {
                    Iterator<Pair<j<T>, aj>> it = this.ijC.iterator();
                    this.ijC.clear();
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    closeSafely(this.ijD);
                    this.ijD = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0351a c0351a, T t, boolean z) {
            synchronized (this) {
                if (this.ijG == c0351a) {
                    closeSafely(this.ijD);
                    this.ijD = null;
                    Iterator<Pair<j<T>, aj>> it = this.ijC.iterator();
                    if (!z) {
                        this.ijD = (T) ad.this.e(t);
                    } else {
                        this.ijC.clear();
                        ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).e(t, z);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0351a c0351a) {
            synchronized (this) {
                if (this.ijG == c0351a) {
                    this.ijG = null;
                    this.ijF = null;
                    closeSafely(this.ijD);
                    this.ijD = null;
                    bXj();
                }
            }
        }

        public void a(ad<K, T>.a.C0351a c0351a, float f) {
            synchronized (this) {
                if (this.ijG == c0351a) {
                    this.ijE = f;
                    Iterator<Pair<j<T>, aj>> it = this.ijC.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).az(f);
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
        /* loaded from: classes2.dex */
        public class C0351a extends b<T> {
            private C0351a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: b */
            public void d(T t, boolean z) {
                a.this.a(this, t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void A(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bVG() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aM(float f) {
                a.this.a(this, f);
            }
        }
    }
}

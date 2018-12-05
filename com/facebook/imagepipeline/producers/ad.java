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
    private final ai<T> ipF;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> iqN = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.ipF = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a aN;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                aN = aN(b);
                if (aN == null) {
                    aN = aO(b);
                    z = true;
                }
            }
        } while (!aN.f(jVar, ajVar));
        if (!z) {
            return;
        }
        aN.bZp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a aN(K k) {
        return this.iqN.get(k);
    }

    private synchronized ad<K, T>.a aO(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.iqN.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.iqN.get(k) == aVar) {
            this.iqN.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> iqO = com.facebook.common.internal.h.bTd();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T iqP;
        @GuardedBy("Multiplexer.this")
        private float iqQ;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d iqR;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0365a iqS;
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
                if (ad.this.aN(this.jn) != this) {
                    return false;
                }
                this.iqO.add(create);
                List<ak> bZq = bZq();
                List<ak> bZu = bZu();
                List<ak> bZs = bZs();
                Closeable closeable = this.iqP;
                float f = this.iqQ;
                d.eu(bZq);
                d.ew(bZu);
                d.ev(bZs);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.iqP) {
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
                public void bYY() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.iqO.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.iqO.isEmpty()) {
                            list2 = null;
                            dVar = a.this.iqR;
                            list = null;
                        } else {
                            List bZq = a.this.bZq();
                            list = a.this.bZu();
                            list2 = bZq;
                            dVar = null;
                            list3 = a.this.bZs();
                        }
                    }
                    d.eu(list2);
                    d.ew(list);
                    d.ev(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).bSZ();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bYZ() {
                    d.eu(a.this.bZq());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZa() {
                    d.ev(a.this.bZs());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZb() {
                    d.ew(a.this.bZu());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bZp() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.iqR == null);
                com.facebook.common.internal.g.checkArgument(this.iqS == null);
                if (this.iqO.isEmpty()) {
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.iqO.iterator().next().second;
                this.iqR = new d(ajVar.bYR(), ajVar.getId(), ajVar.bYS(), ajVar.bUu(), ajVar.bYT(), bZr(), bZt(), bZv());
                this.iqS = new C0365a();
                ad.this.ipF.a(this.iqS, this.iqR);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bZq() {
            return this.iqR == null ? null : this.iqR.oX(bZr());
        }

        private synchronized boolean bZr() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.iqO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).bYU()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bZs() {
            List<ak> oY;
            if (this.iqR == null) {
                oY = null;
            } else {
                oY = this.iqR.oY(bZt());
            }
            return oY;
        }

        private synchronized boolean bZt() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.iqO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).bYW()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> bZu() {
            return this.iqR == null ? null : this.iqR.a(bZv());
        }

        private synchronized Priority bZv() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.iqO.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).bYV());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0365a c0365a, Throwable th) {
            synchronized (this) {
                if (this.iqS == c0365a) {
                    Iterator<Pair<j<T>, aj>> it = this.iqO.iterator();
                    this.iqO.clear();
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    closeSafely(this.iqP);
                    this.iqP = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0365a c0365a, T t, boolean z) {
            synchronized (this) {
                if (this.iqS == c0365a) {
                    closeSafely(this.iqP);
                    this.iqP = null;
                    Iterator<Pair<j<T>, aj>> it = this.iqO.iterator();
                    if (!z) {
                        this.iqP = (T) ad.this.e(t);
                    } else {
                        this.iqO.clear();
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

        public void a(ad<K, T>.a.C0365a c0365a) {
            synchronized (this) {
                if (this.iqS == c0365a) {
                    this.iqS = null;
                    this.iqR = null;
                    closeSafely(this.iqP);
                    this.iqP = null;
                    bZp();
                }
            }
        }

        public void a(ad<K, T>.a.C0365a c0365a, float f) {
            synchronized (this) {
                if (this.iqS == c0365a) {
                    this.iqQ = f;
                    Iterator<Pair<j<T>, aj>> it = this.iqO.iterator();
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
        public class C0365a extends b<T> {
            private C0365a() {
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
            protected void bXM() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aM(float f) {
                a.this.a(this, f);
            }
        }
    }
}

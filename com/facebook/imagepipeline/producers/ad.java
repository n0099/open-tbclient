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
    private final ai<T> jJl;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> jKt = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T f(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.jJl = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a aZ;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                aZ = aZ(b);
                if (aZ == null) {
                    aZ = ba(b);
                    z = true;
                }
            }
        } while (!aZ.f(jVar, ajVar));
        if (!z) {
            return;
        }
        aZ.czY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a aZ(K k) {
        return this.jKt.get(k);
    }

    private synchronized ad<K, T>.a ba(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.jKt.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.jKt.get(k) == aVar) {
            this.jKt.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> jKu = com.facebook.common.internal.h.ctF();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T jKv;
        @GuardedBy("Multiplexer.this")
        private float jKw;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d jKx;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0436a jKy;
        private final K jo;

        public a(K k) {
            this.jo = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.facebook.imagepipeline.producers.j<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(j<T> jVar, aj ajVar) {
            Pair<j<T>, aj> create = Pair.create(jVar, ajVar);
            synchronized (this) {
                if (ad.this.aZ(this.jo) != this) {
                    return false;
                }
                this.jKu.add(create);
                List<ak> czZ = czZ();
                List<ak> cAd = cAd();
                List<ak> cAb = cAb();
                Closeable closeable = this.jKv;
                float f = this.jKw;
                d.ex(czZ);
                d.ez(cAd);
                d.ey(cAb);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.jKv) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.f(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.aM(f);
                        }
                        jVar.e(closeable, false);
                        c(closeable);
                    }
                }
                a(create, ajVar);
                return true;
            }
        }

        private void a(final Pair<j<T>, aj> pair, aj ajVar) {
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ad.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czH() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.jKu.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.jKu.isEmpty()) {
                            list2 = null;
                            dVar = a.this.jKx;
                            list = null;
                        } else {
                            List czZ = a.this.czZ();
                            list = a.this.cAd();
                            list2 = czZ;
                            dVar = null;
                            list3 = a.this.cAb();
                        }
                    }
                    d.ex(list2);
                    d.ez(list);
                    d.ey(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).ctB();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czI() {
                    d.ex(a.this.czZ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czJ() {
                    d.ey(a.this.cAb());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czK() {
                    d.ez(a.this.cAd());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void czY() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.jKx == null);
                com.facebook.common.internal.g.checkArgument(this.jKy == null);
                if (this.jKu.isEmpty()) {
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.jKu.iterator().next().second;
                this.jKx = new d(ajVar.czA(), ajVar.getId(), ajVar.czB(), ajVar.cuW(), ajVar.czC(), cAa(), cAc(), cAe());
                this.jKy = new C0436a();
                ad.this.jJl.a(this.jKy, this.jKx);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> czZ() {
            return this.jKx == null ? null : this.jKx.rv(cAa());
        }

        private synchronized boolean cAa() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.jKu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).czD()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cAb() {
            List<ak> rw;
            if (this.jKx == null) {
                rw = null;
            } else {
                rw = this.jKx.rw(cAc());
            }
            return rw;
        }

        private synchronized boolean cAc() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.jKu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).czF()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cAd() {
            return this.jKx == null ? null : this.jKx.a(cAe());
        }

        private synchronized Priority cAe() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.jKu.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).czE());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0436a c0436a, Throwable th) {
            synchronized (this) {
                if (this.jKy == c0436a) {
                    Iterator<Pair<j<T>, aj>> it = this.jKu.iterator();
                    this.jKu.clear();
                    ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
                    c(this.jKv);
                    this.jKv = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).C(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0436a c0436a, T t, boolean z) {
            synchronized (this) {
                if (this.jKy == c0436a) {
                    c(this.jKv);
                    this.jKv = null;
                    Iterator<Pair<j<T>, aj>> it = this.jKu.iterator();
                    if (!z) {
                        this.jKv = (T) ad.this.f(t);
                    } else {
                        this.jKu.clear();
                        ad.this.a((ad) this.jo, (ad<ad, T>.a) this);
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

        public void a(ad<K, T>.a.C0436a c0436a) {
            synchronized (this) {
                if (this.jKy == c0436a) {
                    this.jKy = null;
                    this.jKx = null;
                    c(this.jKv);
                    this.jKv = null;
                    czY();
                }
            }
        }

        public void a(ad<K, T>.a.C0436a c0436a, float f) {
            synchronized (this) {
                if (this.jKy == c0436a) {
                    this.jKw = f;
                    Iterator<Pair<j<T>, aj>> it = this.jKu.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).aM(f);
                        }
                    }
                }
            }
        }

        private void c(Closeable closeable) {
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
        public class C0436a extends b<T> {
            private C0436a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: b */
            public void d(T t, boolean z) {
                a.this.a(this, t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void B(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cyv() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void ba(float f) {
                a.this.a(this, f);
            }
        }
    }
}

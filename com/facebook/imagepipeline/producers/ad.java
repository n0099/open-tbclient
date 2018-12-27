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
    private final ai<T> isP;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> itX = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.isP = aiVar;
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
        aN.caf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a aN(K k) {
        return this.itX.get(k);
    }

    private synchronized ad<K, T>.a aO(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.itX.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.itX.get(k) == aVar) {
            this.itX.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> itY = com.facebook.common.internal.h.bTT();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T itZ;
        @GuardedBy("Multiplexer.this")
        private float iua;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d iub;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0365a iuc;
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
                this.itY.add(create);
                List<ak> cag = cag();
                List<ak> cak = cak();
                List<ak> cai = cai();
                Closeable closeable = this.itZ;
                float f = this.iua;
                d.ev(cag);
                d.ex(cak);
                d.ew(cai);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.itZ) {
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
                public void bZO() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.itY.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.itY.isEmpty()) {
                            list2 = null;
                            dVar = a.this.iub;
                            list = null;
                        } else {
                            List cag = a.this.cag();
                            list = a.this.cak();
                            list2 = cag;
                            dVar = null;
                            list3 = a.this.cai();
                        }
                    }
                    d.ev(list2);
                    d.ex(list);
                    d.ew(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).bTP();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZP() {
                    d.ev(a.this.cag());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZQ() {
                    d.ew(a.this.cai());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZR() {
                    d.ex(a.this.cak());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void caf() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.iub == null);
                com.facebook.common.internal.g.checkArgument(this.iuc == null);
                if (this.itY.isEmpty()) {
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.itY.iterator().next().second;
                this.iub = new d(ajVar.bZH(), ajVar.getId(), ajVar.bZI(), ajVar.bVk(), ajVar.bZJ(), cah(), caj(), cal());
                this.iuc = new C0365a();
                ad.this.isP.a(this.iuc, this.iub);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cag() {
            return this.iub == null ? null : this.iub.pa(cah());
        }

        private synchronized boolean cah() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.itY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).bZK()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cai() {
            List<ak> pb;
            if (this.iub == null) {
                pb = null;
            } else {
                pb = this.iub.pb(caj());
            }
            return pb;
        }

        private synchronized boolean caj() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.itY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).bZM()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cak() {
            return this.iub == null ? null : this.iub.a(cal());
        }

        private synchronized Priority cal() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.itY.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).bZL());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0365a c0365a, Throwable th) {
            synchronized (this) {
                if (this.iuc == c0365a) {
                    Iterator<Pair<j<T>, aj>> it = this.itY.iterator();
                    this.itY.clear();
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    closeSafely(this.itZ);
                    this.itZ = null;
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
                if (this.iuc == c0365a) {
                    closeSafely(this.itZ);
                    this.itZ = null;
                    Iterator<Pair<j<T>, aj>> it = this.itY.iterator();
                    if (!z) {
                        this.itZ = (T) ad.this.e(t);
                    } else {
                        this.itY.clear();
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
                if (this.iuc == c0365a) {
                    this.iuc = null;
                    this.iub = null;
                    closeSafely(this.itZ);
                    this.itZ = null;
                    caf();
                }
            }
        }

        public void a(ad<K, T>.a.C0365a c0365a, float f) {
            synchronized (this) {
                if (this.iuc == c0365a) {
                    this.iua = f;
                    Iterator<Pair<j<T>, aj>> it = this.itY.iterator();
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
            protected void bYC() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aM(float f) {
                a.this.a(this, f);
            }
        }
    }
}

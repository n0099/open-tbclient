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
    private final ai<T> itX;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> ivf = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.itX = aiVar;
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
        aN.caN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a aN(K k) {
        return this.ivf.get(k);
    }

    private synchronized ad<K, T>.a aO(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.ivf.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.ivf.get(k) == aVar) {
            this.ivf.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> ivg = com.facebook.common.internal.h.bUB();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T ivh;
        @GuardedBy("Multiplexer.this")
        private float ivi;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d ivj;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0364a ivk;
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
                this.ivg.add(create);
                List<ak> caO = caO();
                List<ak> caS = caS();
                List<ak> caQ = caQ();
                Closeable closeable = this.ivh;
                float f = this.ivi;
                d.ew(caO);
                d.ey(caS);
                d.ex(caQ);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.ivh) {
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
                public void caw() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.ivg.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.ivg.isEmpty()) {
                            list2 = null;
                            dVar = a.this.ivj;
                            list = null;
                        } else {
                            List caO = a.this.caO();
                            list = a.this.caS();
                            list2 = caO;
                            dVar = null;
                            list3 = a.this.caQ();
                        }
                    }
                    d.ew(list2);
                    d.ey(list);
                    d.ex(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).bUx();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cax() {
                    d.ew(a.this.caO());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cay() {
                    d.ex(a.this.caQ());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void caz() {
                    d.ey(a.this.caS());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void caN() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.ivj == null);
                com.facebook.common.internal.g.checkArgument(this.ivk == null);
                if (this.ivg.isEmpty()) {
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.ivg.iterator().next().second;
                this.ivj = new d(ajVar.cap(), ajVar.getId(), ajVar.caq(), ajVar.bVS(), ajVar.car(), caP(), caR(), caT());
                this.ivk = new C0364a();
                ad.this.itX.a(this.ivk, this.ivj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> caO() {
            return this.ivj == null ? null : this.ivj.pb(caP());
        }

        private synchronized boolean caP() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.ivg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cas()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> caQ() {
            List<ak> pc;
            if (this.ivj == null) {
                pc = null;
            } else {
                pc = this.ivj.pc(caR());
            }
            return pc;
        }

        private synchronized boolean caR() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.ivg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cau()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> caS() {
            return this.ivj == null ? null : this.ivj.a(caT());
        }

        private synchronized Priority caT() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.ivg.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cat());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0364a c0364a, Throwable th) {
            synchronized (this) {
                if (this.ivk == c0364a) {
                    Iterator<Pair<j<T>, aj>> it = this.ivg.iterator();
                    this.ivg.clear();
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    closeSafely(this.ivh);
                    this.ivh = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).B(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0364a c0364a, T t, boolean z) {
            synchronized (this) {
                if (this.ivk == c0364a) {
                    closeSafely(this.ivh);
                    this.ivh = null;
                    Iterator<Pair<j<T>, aj>> it = this.ivg.iterator();
                    if (!z) {
                        this.ivh = (T) ad.this.e(t);
                    } else {
                        this.ivg.clear();
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

        public void a(ad<K, T>.a.C0364a c0364a) {
            synchronized (this) {
                if (this.ivk == c0364a) {
                    this.ivk = null;
                    this.ivj = null;
                    closeSafely(this.ivh);
                    this.ivh = null;
                    caN();
                }
            }
        }

        public void a(ad<K, T>.a.C0364a c0364a, float f) {
            synchronized (this) {
                if (this.ivk == c0364a) {
                    this.ivi = f;
                    Iterator<Pair<j<T>, aj>> it = this.ivg.iterator();
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
        public class C0364a extends b<T> {
            private C0364a() {
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
            protected void bZk() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aM(float f) {
                a.this.a(this, f);
            }
        }
    }
}

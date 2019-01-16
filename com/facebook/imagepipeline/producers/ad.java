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
    private final ai<T> itW;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> ive = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.itW = aiVar;
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
        return this.ive.get(k);
    }

    private synchronized ad<K, T>.a aO(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.ive.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.ive.get(k) == aVar) {
            this.ive.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> ivf = com.facebook.common.internal.h.bUB();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T ivg;
        @GuardedBy("Multiplexer.this")
        private float ivh;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d ivi;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0364a ivj;
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
                this.ivf.add(create);
                List<ak> caO = caO();
                List<ak> caS = caS();
                List<ak> caQ = caQ();
                Closeable closeable = this.ivg;
                float f = this.ivh;
                d.ew(caO);
                d.ey(caS);
                d.ex(caQ);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.ivg) {
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
                        remove = a.this.ivf.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.ivf.isEmpty()) {
                            list2 = null;
                            dVar = a.this.ivi;
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
                com.facebook.common.internal.g.checkArgument(this.ivi == null);
                com.facebook.common.internal.g.checkArgument(this.ivj == null);
                if (this.ivf.isEmpty()) {
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.ivf.iterator().next().second;
                this.ivi = new d(ajVar.cap(), ajVar.getId(), ajVar.caq(), ajVar.bVS(), ajVar.car(), caP(), caR(), caT());
                this.ivj = new C0364a();
                ad.this.itW.a(this.ivj, this.ivi);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> caO() {
            return this.ivi == null ? null : this.ivi.pb(caP());
        }

        private synchronized boolean caP() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.ivf.iterator();
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
            if (this.ivi == null) {
                pc = null;
            } else {
                pc = this.ivi.pc(caR());
            }
            return pc;
        }

        private synchronized boolean caR() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.ivf.iterator();
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
            return this.ivi == null ? null : this.ivi.a(caT());
        }

        private synchronized Priority caT() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.ivf.iterator();
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
                if (this.ivj == c0364a) {
                    Iterator<Pair<j<T>, aj>> it = this.ivf.iterator();
                    this.ivf.clear();
                    ad.this.a((ad) this.jn, (ad<ad, T>.a) this);
                    closeSafely(this.ivg);
                    this.ivg = null;
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
                if (this.ivj == c0364a) {
                    closeSafely(this.ivg);
                    this.ivg = null;
                    Iterator<Pair<j<T>, aj>> it = this.ivf.iterator();
                    if (!z) {
                        this.ivg = (T) ad.this.e(t);
                    } else {
                        this.ivf.clear();
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
                if (this.ivj == c0364a) {
                    this.ivj = null;
                    this.ivi = null;
                    closeSafely(this.ivg);
                    this.ivg = null;
                    caN();
                }
            }
        }

        public void a(ad<K, T>.a.C0364a c0364a, float f) {
            synchronized (this) {
                if (this.ivj == c0364a) {
                    this.ivh = f;
                    Iterator<Pair<j<T>, aj>> it = this.ivf.iterator();
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

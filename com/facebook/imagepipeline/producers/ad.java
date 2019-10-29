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
    private final ai<T> kkY;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> kmg = new HashMap();

    protected abstract K b(aj ajVar);

    protected abstract T e(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ai<T> aiVar) {
        this.kkY = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<T> jVar, aj ajVar) {
        boolean z;
        ad<K, T>.a aW;
        K b = b(ajVar);
        do {
            z = false;
            synchronized (this) {
                aW = aW(b);
                if (aW == null) {
                    aW = aX(b);
                    z = true;
                }
            }
        } while (!aW.f(jVar, ajVar));
        if (!z) {
            return;
        }
        aW.cJf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a aW(K k) {
        return this.kmg.get(k);
    }

    private synchronized ad<K, T>.a aX(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.kmg.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.kmg.get(k) == aVar) {
            this.kmg.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        private final K bX;
        private final CopyOnWriteArraySet<Pair<j<T>, aj>> kmh = com.facebook.common.internal.h.cCL();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T kmi;
        @GuardedBy("Multiplexer.this")
        private float kmj;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d kmk;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0566a kml;

        public a(K k) {
            this.bX = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.facebook.imagepipeline.producers.j<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(j<T> jVar, aj ajVar) {
            Pair<j<T>, aj> create = Pair.create(jVar, ajVar);
            synchronized (this) {
                if (ad.this.aW(this.bX) != this) {
                    return false;
                }
                this.kmh.add(create);
                List<ak> cJg = cJg();
                List<ak> cJk = cJk();
                List<ak> cJi = cJi();
                Closeable closeable = this.kmi;
                float f = this.kmj;
                d.eU(cJg);
                d.eW(cJk);
                d.eV(cJi);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.kmi) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.e(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            jVar.av(f);
                        }
                        jVar.f(closeable, false);
                        b(closeable);
                    }
                }
                a(create, ajVar);
                return true;
            }
        }

        private void a(final Pair<j<T>, aj> pair, aj ajVar) {
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ad.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIO() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.kmh.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.kmh.isEmpty()) {
                            list2 = null;
                            dVar = a.this.kmk;
                            list = null;
                        } else {
                            List cJg = a.this.cJg();
                            list = a.this.cJk();
                            list2 = cJg;
                            dVar = null;
                            list3 = a.this.cJi();
                        }
                    }
                    d.eU(list2);
                    d.eW(list);
                    d.eV(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((j) pair.first).cCH();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIP() {
                    d.eU(a.this.cJg());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIQ() {
                    d.eV(a.this.cJi());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIR() {
                    d.eW(a.this.cJk());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cJf() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.kmk == null);
                com.facebook.common.internal.g.checkArgument(this.kml == null);
                if (this.kmh.isEmpty()) {
                    ad.this.a((ad) this.bX, (ad<ad, T>.a) this);
                    return;
                }
                aj ajVar = (aj) this.kmh.iterator().next().second;
                this.kmk = new d(ajVar.cIH(), ajVar.getId(), ajVar.cII(), ajVar.cEb(), ajVar.cIJ(), cJh(), cJj(), cJl());
                this.kml = new C0566a();
                ad.this.kkY.a(this.kml, this.kmk);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cJg() {
            return this.kmk == null ? null : this.kmk.sj(cJh());
        }

        private synchronized boolean cJh() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kmh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((aj) it.next().second).cIK()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cJi() {
            List<ak> sk;
            if (this.kmk == null) {
                sk = null;
            } else {
                sk = this.kmk.sk(cJj());
            }
            return sk;
        }

        private synchronized boolean cJj() {
            boolean z;
            Iterator<Pair<j<T>, aj>> it = this.kmh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((aj) it.next().second).cIM()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ak> cJk() {
            return this.kmk == null ? null : this.kmk.a(cJl());
        }

        private synchronized Priority cJl() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<j<T>, aj>> it = this.kmh.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((aj) it.next().second).cIL());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0566a c0566a, Throwable th) {
            synchronized (this) {
                if (this.kml == c0566a) {
                    Iterator<Pair<j<T>, aj>> it = this.kmh.iterator();
                    this.kmh.clear();
                    ad.this.a((ad) this.bX, (ad<ad, T>.a) this);
                    b(this.kmi);
                    this.kmi = null;
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).A(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0566a c0566a, T t, boolean z) {
            synchronized (this) {
                if (this.kml == c0566a) {
                    b(this.kmi);
                    this.kmi = null;
                    Iterator<Pair<j<T>, aj>> it = this.kmh.iterator();
                    if (!z) {
                        this.kmi = (T) ad.this.e(t);
                    } else {
                        this.kmh.clear();
                        ad.this.a((ad) this.bX, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).f(t, z);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0566a c0566a) {
            synchronized (this) {
                if (this.kml == c0566a) {
                    this.kml = null;
                    this.kmk = null;
                    b(this.kmi);
                    this.kmi = null;
                    cJf();
                }
            }
        }

        public void a(ad<K, T>.a.C0566a c0566a, float f) {
            synchronized (this) {
                if (this.kml == c0566a) {
                    this.kmj = f;
                    Iterator<Pair<j<T>, aj>> it = this.kmh.iterator();
                    while (it.hasNext()) {
                        Pair<j<T>, aj> next = it.next();
                        synchronized (next) {
                            ((j) next.first).av(f);
                        }
                    }
                }
            }
        }

        private void b(Closeable closeable) {
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
        public class C0566a extends b<T> {
            private C0566a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: b */
            public void e(T t, boolean z) {
                a.this.a(this, t, z);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void z(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void cHB() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void aJ(float f) {
                a.this.a(this, f);
            }
        }
    }
}

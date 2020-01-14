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
/* loaded from: classes10.dex */
public abstract class ad<K, T extends Closeable> implements aj<T> {
    private final aj<T> lUs;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> lVw = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T d(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.lUs = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<T> kVar, ak akVar) {
        boolean z;
        ad<K, T>.a bs;
        K b = b(akVar);
        do {
            z = false;
            synchronized (this) {
                bs = bs(b);
                if (bs == null) {
                    bs = bt(b);
                    z = true;
                }
            }
        } while (!bs.f(kVar, akVar));
        if (!z) {
            return;
        }
        bs.dqJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bs(K k) {
        return this.lVw.get(k);
    }

    private synchronized ad<K, T>.a bt(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.lVw.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.lVw.get(k) == aVar) {
            this.lVw.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a {
        private final K bz;
        @GuardedBy("Multiplexer.this")
        private int lVA;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d lVB;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0660a lVC;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> lVx = com.facebook.common.internal.i.dju();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T lVy;
        @GuardedBy("Multiplexer.this")
        private float lVz;

        public a(K k) {
            this.bz = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.facebook.imagepipeline.producers.ad */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.k<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean f(k<T> kVar, ak akVar) {
            Pair<k<T>, ak> create = Pair.create(kVar, akVar);
            synchronized (this) {
                if (ad.this.bs(this.bz) != this) {
                    return false;
                }
                this.lVx.add(create);
                List<al> dqK = dqK();
                List<al> dqO = dqO();
                List<al> dqM = dqM();
                Closeable closeable = this.lVy;
                float f = this.lVz;
                int i = this.lVA;
                d.fb(dqK);
                d.fd(dqO);
                d.fc(dqM);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.lVy) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = ad.this.d(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f > 0.0f) {
                            kVar.aL(f);
                        }
                        kVar.g(closeable, i);
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
                public void dmA() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.lVx.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.lVx.isEmpty()) {
                            list2 = null;
                            dVar = a.this.lVB;
                            list = null;
                        } else {
                            List dqK = a.this.dqK();
                            list = a.this.dqO();
                            list2 = dqK;
                            dVar = null;
                            list3 = a.this.dqM();
                        }
                    }
                    d.fb(list2);
                    d.fd(list);
                    d.fc(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).djp();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqq() {
                    d.fb(a.this.dqK());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqr() {
                    d.fc(a.this.dqM());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqs() {
                    d.fd(a.this.dqO());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqJ() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.lVB == null);
                com.facebook.common.internal.g.checkArgument(this.lVC == null);
                if (this.lVx.isEmpty()) {
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.lVx.iterator().next().second;
                this.lVB = new d(akVar.dqj(), akVar.getId(), akVar.dqk(), akVar.dkQ(), akVar.dql(), dqL(), dqN(), dqP());
                this.lVC = new C0660a();
                ad.this.lUs.c(this.lVC, this.lVB);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dqK() {
            return this.lVB == null ? null : this.lVB.vo(dqL());
        }

        private synchronized boolean dqL() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lVx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dqm()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dqM() {
            List<al> vp;
            if (this.lVB == null) {
                vp = null;
            } else {
                vp = this.lVB.vp(dqN());
            }
            return vp;
        }

        private synchronized boolean dqN() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lVx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dqo()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dqO() {
            return this.lVB == null ? null : this.lVB.a(dqP());
        }

        private synchronized Priority dqP() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.lVx.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dqn());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0660a c0660a, Throwable th) {
            synchronized (this) {
                if (this.lVC == c0660a) {
                    Iterator<Pair<k<T>, ak>> it = this.lVx.iterator();
                    this.lVx.clear();
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    closeSafely(this.lVy);
                    this.lVy = null;
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).D(th);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0660a c0660a, T t, int i) {
            synchronized (this) {
                if (this.lVC == c0660a) {
                    closeSafely(this.lVy);
                    this.lVy = null;
                    Iterator<Pair<k<T>, ak>> it = this.lVx.iterator();
                    if (b.IF(i)) {
                        this.lVy = (T) ad.this.d(t);
                        this.lVA = i;
                    } else {
                        this.lVx.clear();
                        ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    }
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).g(t, i);
                        }
                    }
                }
            }
        }

        public void a(ad<K, T>.a.C0660a c0660a) {
            synchronized (this) {
                if (this.lVC == c0660a) {
                    this.lVC = null;
                    this.lVB = null;
                    closeSafely(this.lVy);
                    this.lVy = null;
                    dqJ();
                }
            }
        }

        public void a(ad<K, T>.a.C0660a c0660a, float f) {
            synchronized (this) {
                if (this.lVC == c0660a) {
                    this.lVz = f;
                    Iterator<Pair<k<T>, ak>> it = this.lVx.iterator();
                    while (it.hasNext()) {
                        Pair<k<T>, ak> next = it.next();
                        synchronized (next) {
                            ((k) next.first).aL(f);
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
        /* loaded from: classes10.dex */
        public class C0660a extends b<T> {
            private C0660a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(T t, int i) {
                a.this.a(this, t, i);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void C(Throwable th) {
                a.this.a(this, th);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void doT() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bt(float f) {
                a.this.a(this, f);
            }
        }
    }
}

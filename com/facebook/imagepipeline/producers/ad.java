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
    private final aj<T> lUn;
    @GuardedBy("this")
    final Map<K, ad<K, T>.a> lVr = new HashMap();

    protected abstract K b(ak akVar);

    protected abstract T d(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(aj<T> ajVar) {
        this.lUn = ajVar;
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
        bs.dqH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ad<K, T>.a bs(K k) {
        return this.lVr.get(k);
    }

    private synchronized ad<K, T>.a bt(K k) {
        ad<K, T>.a aVar;
        aVar = new a(k);
        this.lVr.put(k, aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(K k, ad<K, T>.a aVar) {
        if (this.lVr.get(k) == aVar) {
            this.lVr.remove(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a {
        private final K bz;
        private final CopyOnWriteArraySet<Pair<k<T>, ak>> lVs = com.facebook.common.internal.i.djs();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T lVt;
        @GuardedBy("Multiplexer.this")
        private float lVu;
        @GuardedBy("Multiplexer.this")
        private int lVv;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private d lVw;
        @GuardedBy("Multiplexer.this")
        @Nullable
        private ad<K, T>.a.C0660a lVx;

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
                this.lVs.add(create);
                List<al> dqI = dqI();
                List<al> dqM = dqM();
                List<al> dqK = dqK();
                Closeable closeable = this.lVt;
                float f = this.lVu;
                int i = this.lVv;
                d.fb(dqI);
                d.fd(dqM);
                d.fc(dqK);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.lVt) {
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
                public void dmy() {
                    boolean remove;
                    List list;
                    List list2;
                    d dVar;
                    List list3 = null;
                    synchronized (a.this) {
                        remove = a.this.lVs.remove(pair);
                        if (!remove) {
                            list = null;
                            list2 = null;
                            dVar = null;
                        } else if (a.this.lVs.isEmpty()) {
                            list2 = null;
                            dVar = a.this.lVw;
                            list = null;
                        } else {
                            List dqI = a.this.dqI();
                            list = a.this.dqM();
                            list2 = dqI;
                            dVar = null;
                            list3 = a.this.dqK();
                        }
                    }
                    d.fb(list2);
                    d.fd(list);
                    d.fc(list3);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (remove) {
                        ((k) pair.first).djn();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqo() {
                    d.fb(a.this.dqI());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqp() {
                    d.fc(a.this.dqK());
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqq() {
                    d.fd(a.this.dqM());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqH() {
            synchronized (this) {
                com.facebook.common.internal.g.checkArgument(this.lVw == null);
                com.facebook.common.internal.g.checkArgument(this.lVx == null);
                if (this.lVs.isEmpty()) {
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    return;
                }
                ak akVar = (ak) this.lVs.iterator().next().second;
                this.lVw = new d(akVar.dqh(), akVar.getId(), akVar.dqi(), akVar.dkO(), akVar.dqj(), dqJ(), dqL(), dqN());
                this.lVx = new C0660a();
                ad.this.lUn.c(this.lVx, this.lVw);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dqI() {
            return this.lVw == null ? null : this.lVw.vo(dqJ());
        }

        private synchronized boolean dqJ() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lVs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!((ak) it.next().second).dqk()) {
                    z = false;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dqK() {
            List<al> vp;
            if (this.lVw == null) {
                vp = null;
            } else {
                vp = this.lVw.vp(dqL());
            }
            return vp;
        }

        private synchronized boolean dqL() {
            boolean z;
            Iterator<Pair<k<T>, ak>> it = this.lVs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (((ak) it.next().second).dqm()) {
                    z = true;
                    break;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<al> dqM() {
            return this.lVw == null ? null : this.lVw.a(dqN());
        }

        private synchronized Priority dqN() {
            Priority priority;
            Priority priority2 = Priority.LOW;
            Iterator<Pair<k<T>, ak>> it = this.lVs.iterator();
            while (true) {
                priority = priority2;
                if (it.hasNext()) {
                    priority2 = Priority.getHigherPriority(priority, ((ak) it.next().second).dql());
                }
            }
            return priority;
        }

        public void a(ad<K, T>.a.C0660a c0660a, Throwable th) {
            synchronized (this) {
                if (this.lVx == c0660a) {
                    Iterator<Pair<k<T>, ak>> it = this.lVs.iterator();
                    this.lVs.clear();
                    ad.this.a((ad) this.bz, (ad<ad, T>.a) this);
                    closeSafely(this.lVt);
                    this.lVt = null;
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
                if (this.lVx == c0660a) {
                    closeSafely(this.lVt);
                    this.lVt = null;
                    Iterator<Pair<k<T>, ak>> it = this.lVs.iterator();
                    if (b.IF(i)) {
                        this.lVt = (T) ad.this.d(t);
                        this.lVv = i;
                    } else {
                        this.lVs.clear();
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
                if (this.lVx == c0660a) {
                    this.lVx = null;
                    this.lVw = null;
                    closeSafely(this.lVt);
                    this.lVt = null;
                    dqH();
                }
            }
        }

        public void a(ad<K, T>.a.C0660a c0660a, float f) {
            synchronized (this) {
                if (this.lVx == c0660a) {
                    this.lVu = f;
                    Iterator<Pair<k<T>, ak>> it = this.lVs.iterator();
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
            protected void doR() {
                a.this.a(this);
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void bt(float f) {
                a.this.a(this, f);
            }
        }
    }
}

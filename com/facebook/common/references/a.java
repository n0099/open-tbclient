package com.facebook.common.references;

import com.facebook.common.internal.g;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public abstract class a<T> implements Closeable, Cloneable {
    @Nullable
    private static volatile c ijm;
    @GuardedBy("this")
    protected boolean HL;
    @Nullable
    protected Throwable ijn;
    protected final SharedReference<T> ijo;
    private static Class<a> ihJ = a.class;
    private static final com.facebook.common.references.c<Closeable> ijl = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.references.c
        /* renamed from: d */
        public void release(Closeable closeable) {
            try {
                com.facebook.common.internal.b.a(closeable, true);
            } catch (IOException e) {
            }
        }
    };
    private static volatile boolean ijp = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HL = false;
        this.ijo = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.bUj();
        this.ijn = bUf();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HL = false;
        this.ijo = new SharedReference<>(t, cVar);
        this.ijn = bUf();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, ijl);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return ijp ? new C0355a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HL) {
                this.HL = true;
                this.ijo.bUk();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HL);
        return this.ijo.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: bUa */
    public synchronized a<T> clone() {
        this.ijn = bUf();
        g.checkState(isValid());
        return bUc();
    }

    public synchronized a<T> bUb() {
        this.ijn = bUf();
        return isValid() ? bUc() : null;
    }

    private a<T> bUc() {
        return ijp ? new C0355a((SharedReference) this.ijo) : new b((SharedReference) this.ijo);
    }

    public synchronized boolean isValid() {
        return !this.HL;
    }

    public static boolean bUd() {
        return ijm != null;
    }

    public void s(Throwable th) {
        this.ijn = th;
    }

    public synchronized int bUe() {
        return isValid() ? System.identityHashCode(this.ijo.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.bUb();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable bUf() {
        if (ijm != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> ijq = new ReferenceQueue<>();
        private final C0356a ijr;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0356a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0356a ijs;
            private final SharedReference ijo;
            @GuardedBy("Destructor.class")
            private C0356a ijt;
            @GuardedBy("Destructor.class")
            private C0356a iju;
            @GuardedBy("this")
            private boolean ijv;

            public C0356a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.ijo = aVar.ijo;
                synchronized (C0356a.class) {
                    if (ijs != null) {
                        ijs.ijt = this;
                        this.iju = ijs;
                    }
                    ijs = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.ijv;
            }

            public void eA(boolean z) {
                synchronized (this) {
                    if (!this.ijv) {
                        this.ijv = true;
                        synchronized (C0356a.class) {
                            if (this.iju != null) {
                                this.iju.ijt = this.ijt;
                            }
                            if (this.ijt != null) {
                                this.ijt.iju = this.iju;
                            } else {
                                ijs = this.iju;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.ihJ, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ijo)), this.ijo.get().getClass().getSimpleName());
                        }
                        this.ijo.bUk();
                    }
                }
            }
        }

        static {
            new Thread(new Runnable() { // from class: com.facebook.common.references.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            ((C0356a) b.ijq.remove()).eA(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.ijr = new C0356a(this, ijq);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.ijr = new C0356a(this, ijq);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.ijr.eA(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.ijr.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0355a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0355a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0355a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.HL) {
                        c cVar = a.ijm;
                        if (cVar != null) {
                            cVar.a(this, this.ijn);
                        } else {
                            com.facebook.common.c.a.d(a.ihJ, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ijo)), this.ijo.get().getClass().getSimpleName());
                        }
                        close();
                    }
                }
            } finally {
                super.finalize();
            }
        }
    }
}

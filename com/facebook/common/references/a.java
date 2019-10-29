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
    private static volatile c kbm;
    @Nullable
    protected Throwable kbn;
    protected final SharedReference<T> kbo;
    @GuardedBy("this")
    protected boolean sO;
    private static Class<a> jZN = a.class;
    private static final com.facebook.common.references.c<Closeable> kbl = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean kbp = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.sO = false;
        this.kbo = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cDb();
        this.kbn = cCX();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.sO = false;
        this.kbo = new SharedReference<>(t, cVar);
        this.kbn = cCX();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, kbl);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return kbp ? new C0556a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.sO) {
                this.sO = true;
                this.kbo.cDc();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.sO);
        return this.kbo.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cCS */
    public synchronized a<T> clone() {
        this.kbn = cCX();
        g.checkState(isValid());
        return cCU();
    }

    public synchronized a<T> cCT() {
        this.kbn = cCX();
        return isValid() ? cCU() : null;
    }

    private a<T> cCU() {
        return kbp ? new C0556a((SharedReference) this.kbo) : new b((SharedReference) this.kbo);
    }

    public synchronized boolean isValid() {
        return !this.sO;
    }

    public static boolean cCV() {
        return kbm != null;
    }

    public void r(Throwable th) {
        this.kbn = th;
    }

    public synchronized int cCW() {
        return isValid() ? System.identityHashCode(this.kbo.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.cCT();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable cCX() {
        if (kbm != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> kbq = new ReferenceQueue<>();
        private final C0557a kbr;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0557a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0557a kbs;
            private final SharedReference kbo;
            @GuardedBy("Destructor.class")
            private C0557a kbt;
            @GuardedBy("Destructor.class")
            private C0557a kbu;
            @GuardedBy("this")
            private boolean kbv;

            public C0557a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.kbo = aVar.kbo;
                synchronized (C0557a.class) {
                    if (kbs != null) {
                        kbs.kbt = this;
                        this.kbu = kbs;
                    }
                    kbs = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.kbv;
            }

            public void hK(boolean z) {
                synchronized (this) {
                    if (!this.kbv) {
                        this.kbv = true;
                        synchronized (C0557a.class) {
                            if (this.kbu != null) {
                                this.kbu.kbt = this.kbt;
                            }
                            if (this.kbt != null) {
                                this.kbt.kbu = this.kbu;
                            } else {
                                kbs = this.kbu;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.c(a.jZN, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kbo)), this.kbo.get().getClass().getSimpleName());
                        }
                        this.kbo.cDc();
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
                            ((C0557a) b.kbq.remove()).hK(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.kbr = new C0557a(this, kbq);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.kbr = new C0557a(this, kbq);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.kbr.hK(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.kbr.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0556a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0556a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0556a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.sO) {
                        c cVar = a.kbm;
                        if (cVar != null) {
                            cVar.a(this, this.kbn);
                        } else {
                            com.facebook.common.c.a.c(a.jZN, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kbo)), this.kbo.get().getClass().getSimpleName());
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

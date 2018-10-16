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
    private static volatile c hXe;
    @GuardedBy("this")
    protected boolean HH;
    @Nullable
    protected Throwable hXf;
    protected final SharedReference<T> hXg;
    private static Class<a> hVB = a.class;
    private static final com.facebook.common.references.c<Closeable> hXd = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean hXh = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HH = false;
        this.hXg = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.bRS();
        this.hXf = bRO();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HH = false;
        this.hXg = new SharedReference<>(t, cVar);
        this.hXf = bRO();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, hXd);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return hXh ? new C0313a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HH) {
                this.HH = true;
                this.hXg.bRT();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HH);
        return this.hXg.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: bRJ */
    public synchronized a<T> clone() {
        this.hXf = bRO();
        g.checkState(isValid());
        return bRL();
    }

    public synchronized a<T> bRK() {
        this.hXf = bRO();
        return isValid() ? bRL() : null;
    }

    private a<T> bRL() {
        return hXh ? new C0313a((SharedReference) this.hXg) : new b((SharedReference) this.hXg);
    }

    public synchronized boolean isValid() {
        return !this.HH;
    }

    public static boolean bRM() {
        return hXe != null;
    }

    public void s(Throwable th) {
        this.hXf = th;
    }

    public synchronized int bRN() {
        return isValid() ? System.identityHashCode(this.hXg.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.bRK();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable bRO() {
        if (hXe != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> hXi = new ReferenceQueue<>();
        private final C0314a hXj;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0314a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0314a hXk;
            private final SharedReference hXg;
            @GuardedBy("Destructor.class")
            private C0314a hXl;
            @GuardedBy("Destructor.class")
            private C0314a hXm;
            @GuardedBy("this")
            private boolean hXn;

            public C0314a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.hXg = aVar.hXg;
                synchronized (C0314a.class) {
                    if (hXk != null) {
                        hXk.hXl = this;
                        this.hXm = hXk;
                    }
                    hXk = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.hXn;
            }

            public void er(boolean z) {
                synchronized (this) {
                    if (!this.hXn) {
                        this.hXn = true;
                        synchronized (C0314a.class) {
                            if (this.hXm != null) {
                                this.hXm.hXl = this.hXl;
                            }
                            if (this.hXl != null) {
                                this.hXl.hXm = this.hXm;
                            } else {
                                hXk = this.hXm;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.hVB, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.hXg)), this.hXg.get().getClass().getSimpleName());
                        }
                        this.hXg.bRT();
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
                            ((C0314a) b.hXi.remove()).er(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.hXj = new C0314a(this, hXi);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.hXj = new C0314a(this, hXi);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.hXj.er(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.hXj.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0313a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0313a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0313a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.HH) {
                        c cVar = a.hXe;
                        if (cVar != null) {
                            cVar.a(this, this.hXf);
                        } else {
                            com.facebook.common.c.a.d(a.hVB, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.hXg)), this.hXg.get().getClass().getSimpleName());
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

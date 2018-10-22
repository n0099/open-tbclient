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
    private static volatile c hXf;
    @GuardedBy("this")
    protected boolean HH;
    @Nullable
    protected Throwable hXg;
    protected final SharedReference<T> hXh;
    private static Class<a> hVC = a.class;
    private static final com.facebook.common.references.c<Closeable> hXe = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean hXi = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HH = false;
        this.hXh = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.bRS();
        this.hXg = bRO();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HH = false;
        this.hXh = new SharedReference<>(t, cVar);
        this.hXg = bRO();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, hXe);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return hXi ? new C0313a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HH) {
                this.HH = true;
                this.hXh.bRT();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HH);
        return this.hXh.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: bRJ */
    public synchronized a<T> clone() {
        this.hXg = bRO();
        g.checkState(isValid());
        return bRL();
    }

    public synchronized a<T> bRK() {
        this.hXg = bRO();
        return isValid() ? bRL() : null;
    }

    private a<T> bRL() {
        return hXi ? new C0313a((SharedReference) this.hXh) : new b((SharedReference) this.hXh);
    }

    public synchronized boolean isValid() {
        return !this.HH;
    }

    public static boolean bRM() {
        return hXf != null;
    }

    public void s(Throwable th) {
        this.hXg = th;
    }

    public synchronized int bRN() {
        return isValid() ? System.identityHashCode(this.hXh.get()) : 0;
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
        if (hXf != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> hXj = new ReferenceQueue<>();
        private final C0314a hXk;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0314a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0314a hXl;
            private final SharedReference hXh;
            @GuardedBy("Destructor.class")
            private C0314a hXm;
            @GuardedBy("Destructor.class")
            private C0314a hXn;
            @GuardedBy("this")
            private boolean hXo;

            public C0314a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.hXh = aVar.hXh;
                synchronized (C0314a.class) {
                    if (hXl != null) {
                        hXl.hXm = this;
                        this.hXn = hXl;
                    }
                    hXl = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.hXo;
            }

            public void er(boolean z) {
                synchronized (this) {
                    if (!this.hXo) {
                        this.hXo = true;
                        synchronized (C0314a.class) {
                            if (this.hXn != null) {
                                this.hXn.hXm = this.hXm;
                            }
                            if (this.hXm != null) {
                                this.hXm.hXn = this.hXn;
                            } else {
                                hXl = this.hXn;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.hVC, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.hXh)), this.hXh.get().getClass().getSimpleName());
                        }
                        this.hXh.bRT();
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
                            ((C0314a) b.hXj.remove()).er(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.hXk = new C0314a(this, hXj);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.hXk = new C0314a(this, hXj);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.hXk.er(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.hXk.isDestroyed();
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
                        c cVar = a.hXf;
                        if (cVar != null) {
                            cVar.a(this, this.hXg);
                        } else {
                            com.facebook.common.c.a.d(a.hVC, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.hXh)), this.hXh.get().getClass().getSimpleName());
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

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
    private static volatile c jSt;
    @GuardedBy("this")
    protected boolean Fx;
    @Nullable
    protected Throwable jSu;
    protected final SharedReference<T> jSv;
    private static Class<a> jQS = a.class;
    private static final com.facebook.common.references.c<Closeable> jSs = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.references.c
        /* renamed from: e */
        public void release(Closeable closeable) {
            try {
                com.facebook.common.internal.b.a(closeable, true);
            } catch (IOException e) {
            }
        }
    };
    private static volatile boolean jSw = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.Fx = false;
        this.jSv = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cBU();
        this.jSu = cBQ();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.Fx = false;
        this.jSv = new SharedReference<>(t, cVar);
        this.jSu = cBQ();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jSs);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jSw ? new C0445a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.Fx) {
                this.Fx = true;
                this.jSv.cBV();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.Fx);
        return this.jSv.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cBL */
    public synchronized a<T> clone() {
        this.jSu = cBQ();
        g.checkState(isValid());
        return cBN();
    }

    public synchronized a<T> cBM() {
        this.jSu = cBQ();
        return isValid() ? cBN() : null;
    }

    private a<T> cBN() {
        return jSw ? new C0445a((SharedReference) this.jSv) : new b((SharedReference) this.jSv);
    }

    public synchronized boolean isValid() {
        return !this.Fx;
    }

    public static boolean cBO() {
        return jSt != null;
    }

    public void s(Throwable th) {
        this.jSu = th;
    }

    public synchronized int cBP() {
        return isValid() ? System.identityHashCode(this.jSv.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.cBM();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable cBQ() {
        if (jSt != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jSx = new ReferenceQueue<>();
        private final C0446a jSy;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0446a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0446a jSz;
            @GuardedBy("Destructor.class")
            private C0446a jSA;
            @GuardedBy("Destructor.class")
            private C0446a jSB;
            @GuardedBy("this")
            private boolean jSC;
            private final SharedReference jSv;

            public C0446a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jSv = aVar.jSv;
                synchronized (C0446a.class) {
                    if (jSz != null) {
                        jSz.jSA = this;
                        this.jSB = jSz;
                    }
                    jSz = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jSC;
            }

            public void hw(boolean z) {
                synchronized (this) {
                    if (!this.jSC) {
                        this.jSC = true;
                        synchronized (C0446a.class) {
                            if (this.jSB != null) {
                                this.jSB.jSA = this.jSA;
                            }
                            if (this.jSA != null) {
                                this.jSA.jSB = this.jSB;
                            } else {
                                jSz = this.jSB;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jQS, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jSv)), this.jSv.get().getClass().getSimpleName());
                        }
                        this.jSv.cBV();
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
                            ((C0446a) b.jSx.remove()).hw(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jSy = new C0446a(this, jSx);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jSy = new C0446a(this, jSx);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jSy.hw(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jSy.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0445a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0445a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0445a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.Fx) {
                        c cVar = a.jSt;
                        if (cVar != null) {
                            cVar.a(this, this.jSu);
                        } else {
                            com.facebook.common.c.a.d(a.jQS, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jSv)), this.jSv.get().getClass().getSimpleName());
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

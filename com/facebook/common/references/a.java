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
    private static volatile c jSw;
    @GuardedBy("this")
    protected boolean Fw;
    @Nullable
    protected Throwable jSx;
    protected final SharedReference<T> jSy;
    private static Class<a> jQV = a.class;
    private static final com.facebook.common.references.c<Closeable> jSv = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean jSz = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.Fw = false;
        this.jSy = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cBT();
        this.jSx = cBP();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.Fw = false;
        this.jSy = new SharedReference<>(t, cVar);
        this.jSx = cBP();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jSv);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jSz ? new C0445a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.Fw) {
                this.Fw = true;
                this.jSy.cBU();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.Fw);
        return this.jSy.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cBK */
    public synchronized a<T> clone() {
        this.jSx = cBP();
        g.checkState(isValid());
        return cBM();
    }

    public synchronized a<T> cBL() {
        this.jSx = cBP();
        return isValid() ? cBM() : null;
    }

    private a<T> cBM() {
        return jSz ? new C0445a((SharedReference) this.jSy) : new b((SharedReference) this.jSy);
    }

    public synchronized boolean isValid() {
        return !this.Fw;
    }

    public static boolean cBN() {
        return jSw != null;
    }

    public void s(Throwable th) {
        this.jSx = th;
    }

    public synchronized int cBO() {
        return isValid() ? System.identityHashCode(this.jSy.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.cBL();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable cBP() {
        if (jSw != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jSA = new ReferenceQueue<>();
        private final C0446a jSB;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0446a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0446a jSC;
            @GuardedBy("Destructor.class")
            private C0446a jSD;
            @GuardedBy("Destructor.class")
            private C0446a jSE;
            @GuardedBy("this")
            private boolean jSF;
            private final SharedReference jSy;

            public C0446a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jSy = aVar.jSy;
                synchronized (C0446a.class) {
                    if (jSC != null) {
                        jSC.jSD = this;
                        this.jSE = jSC;
                    }
                    jSC = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jSF;
            }

            public void hw(boolean z) {
                synchronized (this) {
                    if (!this.jSF) {
                        this.jSF = true;
                        synchronized (C0446a.class) {
                            if (this.jSE != null) {
                                this.jSE.jSD = this.jSD;
                            }
                            if (this.jSD != null) {
                                this.jSD.jSE = this.jSE;
                            } else {
                                jSC = this.jSE;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jQV, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jSy)), this.jSy.get().getClass().getSimpleName());
                        }
                        this.jSy.cBU();
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
                            ((C0446a) b.jSA.remove()).hw(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jSB = new C0446a(this, jSA);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jSB = new C0446a(this, jSA);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jSB.hw(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jSB.isDestroyed();
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
                    if (!this.Fw) {
                        c cVar = a.jSw;
                        if (cVar != null) {
                            cVar.a(this, this.jSx);
                        } else {
                            com.facebook.common.c.a.d(a.jQV, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jSy)), this.jSy.get().getClass().getSimpleName());
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

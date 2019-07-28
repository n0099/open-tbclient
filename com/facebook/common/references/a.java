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
    private static volatile c jZA;
    @GuardedBy("this")
    protected boolean FD;
    @Nullable
    protected Throwable jZB;
    protected final SharedReference<T> jZC;
    private static Class<a> jYa = a.class;
    private static final com.facebook.common.references.c<Closeable> jZz = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean jZD = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.FD = false;
        this.jZC = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cEU();
        this.jZB = cEQ();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.FD = false;
        this.jZC = new SharedReference<>(t, cVar);
        this.jZB = cEQ();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jZz);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jZD ? new C0450a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.FD) {
                this.FD = true;
                this.jZC.cEV();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.FD);
        return this.jZC.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cEL */
    public synchronized a<T> clone() {
        this.jZB = cEQ();
        g.checkState(isValid());
        return cEN();
    }

    public synchronized a<T> cEM() {
        this.jZB = cEQ();
        return isValid() ? cEN() : null;
    }

    private a<T> cEN() {
        return jZD ? new C0450a((SharedReference) this.jZC) : new b((SharedReference) this.jZC);
    }

    public synchronized boolean isValid() {
        return !this.FD;
    }

    public static boolean cEO() {
        return jZA != null;
    }

    public void s(Throwable th) {
        this.jZB = th;
    }

    public synchronized int cEP() {
        return isValid() ? System.identityHashCode(this.jZC.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.cEM();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable cEQ() {
        if (jZA != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jZE = new ReferenceQueue<>();
        private final C0451a jZF;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0451a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0451a jZG;
            private final SharedReference jZC;
            @GuardedBy("Destructor.class")
            private C0451a jZH;
            @GuardedBy("Destructor.class")
            private C0451a jZI;
            @GuardedBy("this")
            private boolean jZJ;

            public C0451a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jZC = aVar.jZC;
                synchronized (C0451a.class) {
                    if (jZG != null) {
                        jZG.jZH = this;
                        this.jZI = jZG;
                    }
                    jZG = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jZJ;
            }

            public void hD(boolean z) {
                synchronized (this) {
                    if (!this.jZJ) {
                        this.jZJ = true;
                        synchronized (C0451a.class) {
                            if (this.jZI != null) {
                                this.jZI.jZH = this.jZH;
                            }
                            if (this.jZH != null) {
                                this.jZH.jZI = this.jZI;
                            } else {
                                jZG = this.jZI;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jYa, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jZC)), this.jZC.get().getClass().getSimpleName());
                        }
                        this.jZC.cEV();
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
                            ((C0451a) b.jZE.remove()).hD(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jZF = new C0451a(this, jZE);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jZF = new C0451a(this, jZE);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jZF.hD(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jZF.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0450a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0450a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0450a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.FD) {
                        c cVar = a.jZA;
                        if (cVar != null) {
                            cVar.a(this, this.jZB);
                        } else {
                            com.facebook.common.c.a.d(a.jYa, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jZC)), this.jZC.get().getClass().getSimpleName());
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

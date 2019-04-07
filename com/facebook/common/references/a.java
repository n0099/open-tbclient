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
    private static volatile c jzB;
    @GuardedBy("this")
    protected boolean HM;
    @Nullable
    protected Throwable jzC;
    protected final SharedReference<T> jzD;
    private static Class<a> jya = a.class;
    private static final com.facebook.common.references.c<Closeable> jzA = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean jzE = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HM = false;
        this.jzD = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.ctV();
        this.jzC = ctR();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HM = false;
        this.jzD = new SharedReference<>(t, cVar);
        this.jzC = ctR();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jzA);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jzE ? new C0426a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HM) {
                this.HM = true;
                this.jzD.ctW();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HM);
        return this.jzD.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: ctM */
    public synchronized a<T> clone() {
        this.jzC = ctR();
        g.checkState(isValid());
        return ctO();
    }

    public synchronized a<T> ctN() {
        this.jzC = ctR();
        return isValid() ? ctO() : null;
    }

    private a<T> ctO() {
        return jzE ? new C0426a((SharedReference) this.jzD) : new b((SharedReference) this.jzD);
    }

    public synchronized boolean isValid() {
        return !this.HM;
    }

    public static boolean ctP() {
        return jzB != null;
    }

    public void t(Throwable th) {
        this.jzC = th;
    }

    public synchronized int ctQ() {
        return isValid() ? System.identityHashCode(this.jzD.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.ctN();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable ctR() {
        if (jzB != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jzF = new ReferenceQueue<>();
        private final C0427a jzG;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0427a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0427a jzH;
            private final SharedReference jzD;
            @GuardedBy("Destructor.class")
            private C0427a jzI;
            @GuardedBy("Destructor.class")
            private C0427a jzJ;
            @GuardedBy("this")
            private boolean jzK;

            public C0427a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jzD = aVar.jzD;
                synchronized (C0427a.class) {
                    if (jzH != null) {
                        jzH.jzI = this;
                        this.jzJ = jzH;
                    }
                    jzH = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jzK;
            }

            public void gX(boolean z) {
                synchronized (this) {
                    if (!this.jzK) {
                        this.jzK = true;
                        synchronized (C0427a.class) {
                            if (this.jzJ != null) {
                                this.jzJ.jzI = this.jzI;
                            }
                            if (this.jzI != null) {
                                this.jzI.jzJ = this.jzJ;
                            } else {
                                jzH = this.jzJ;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jya, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jzD)), this.jzD.get().getClass().getSimpleName());
                        }
                        this.jzD.ctW();
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
                            ((C0427a) b.jzF.remove()).gX(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jzG = new C0427a(this, jzF);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jzG = new C0427a(this, jzF);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jzG.gX(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jzG.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0426a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0426a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0426a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.HM) {
                        c cVar = a.jzB;
                        if (cVar != null) {
                            cVar.a(this, this.jzC);
                        } else {
                            com.facebook.common.c.a.d(a.jya, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jzD)), this.jzD.get().getClass().getSimpleName());
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

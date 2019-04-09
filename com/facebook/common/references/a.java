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
    private static volatile c jzC;
    @GuardedBy("this")
    protected boolean HM;
    @Nullable
    protected Throwable jzD;
    protected final SharedReference<T> jzE;
    private static Class<a> jyb = a.class;
    private static final com.facebook.common.references.c<Closeable> jzB = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean jzF = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HM = false;
        this.jzE = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.ctV();
        this.jzD = ctR();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HM = false;
        this.jzE = new SharedReference<>(t, cVar);
        this.jzD = ctR();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jzB);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jzF ? new C0426a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HM) {
                this.HM = true;
                this.jzE.ctW();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HM);
        return this.jzE.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: ctM */
    public synchronized a<T> clone() {
        this.jzD = ctR();
        g.checkState(isValid());
        return ctO();
    }

    public synchronized a<T> ctN() {
        this.jzD = ctR();
        return isValid() ? ctO() : null;
    }

    private a<T> ctO() {
        return jzF ? new C0426a((SharedReference) this.jzE) : new b((SharedReference) this.jzE);
    }

    public synchronized boolean isValid() {
        return !this.HM;
    }

    public static boolean ctP() {
        return jzC != null;
    }

    public void t(Throwable th) {
        this.jzD = th;
    }

    public synchronized int ctQ() {
        return isValid() ? System.identityHashCode(this.jzE.get()) : 0;
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
        if (jzC != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jzG = new ReferenceQueue<>();
        private final C0427a jzH;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0427a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0427a jzI;
            private final SharedReference jzE;
            @GuardedBy("Destructor.class")
            private C0427a jzJ;
            @GuardedBy("Destructor.class")
            private C0427a jzK;
            @GuardedBy("this")
            private boolean jzL;

            public C0427a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jzE = aVar.jzE;
                synchronized (C0427a.class) {
                    if (jzI != null) {
                        jzI.jzJ = this;
                        this.jzK = jzI;
                    }
                    jzI = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jzL;
            }

            public void gX(boolean z) {
                synchronized (this) {
                    if (!this.jzL) {
                        this.jzL = true;
                        synchronized (C0427a.class) {
                            if (this.jzK != null) {
                                this.jzK.jzJ = this.jzJ;
                            }
                            if (this.jzJ != null) {
                                this.jzJ.jzK = this.jzK;
                            } else {
                                jzI = this.jzK;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jyb, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jzE)), this.jzE.get().getClass().getSimpleName());
                        }
                        this.jzE.ctW();
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
                            ((C0427a) b.jzG.remove()).gX(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jzH = new C0427a(this, jzG);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jzH = new C0427a(this, jzG);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jzH.gX(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jzH.isDestroyed();
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
                        c cVar = a.jzC;
                        if (cVar != null) {
                            cVar.a(this, this.jzD);
                        } else {
                            com.facebook.common.c.a.d(a.jyb, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jzE)), this.jzE.get().getClass().getSimpleName());
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

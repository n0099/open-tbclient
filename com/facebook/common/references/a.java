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
    private static volatile c jAh;
    @GuardedBy("this")
    protected boolean HM;
    @Nullable
    protected Throwable jAi;
    protected final SharedReference<T> jAj;
    private static Class<a> jyG = a.class;
    private static final com.facebook.common.references.c<Closeable> jAg = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean jAk = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HM = false;
        this.jAj = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cuc();
        this.jAi = ctY();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HM = false;
        this.jAj = new SharedReference<>(t, cVar);
        this.jAi = ctY();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jAg);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jAk ? new C0426a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HM) {
                this.HM = true;
                this.jAj.cud();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HM);
        return this.jAj.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: ctT */
    public synchronized a<T> clone() {
        this.jAi = ctY();
        g.checkState(isValid());
        return ctV();
    }

    public synchronized a<T> ctU() {
        this.jAi = ctY();
        return isValid() ? ctV() : null;
    }

    private a<T> ctV() {
        return jAk ? new C0426a((SharedReference) this.jAj) : new b((SharedReference) this.jAj);
    }

    public synchronized boolean isValid() {
        return !this.HM;
    }

    public static boolean ctW() {
        return jAh != null;
    }

    public void t(Throwable th) {
        this.jAi = th;
    }

    public synchronized int ctX() {
        return isValid() ? System.identityHashCode(this.jAj.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.ctU();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable ctY() {
        if (jAh != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jAl = new ReferenceQueue<>();
        private final C0427a jAm;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0427a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0427a jAn;
            private final SharedReference jAj;
            @GuardedBy("Destructor.class")
            private C0427a jAo;
            @GuardedBy("Destructor.class")
            private C0427a jAp;
            @GuardedBy("this")
            private boolean jAq;

            public C0427a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jAj = aVar.jAj;
                synchronized (C0427a.class) {
                    if (jAn != null) {
                        jAn.jAo = this;
                        this.jAp = jAn;
                    }
                    jAn = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jAq;
            }

            public void gY(boolean z) {
                synchronized (this) {
                    if (!this.jAq) {
                        this.jAq = true;
                        synchronized (C0427a.class) {
                            if (this.jAp != null) {
                                this.jAp.jAo = this.jAo;
                            }
                            if (this.jAo != null) {
                                this.jAo.jAp = this.jAp;
                            } else {
                                jAn = this.jAp;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jyG, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jAj)), this.jAj.get().getClass().getSimpleName());
                        }
                        this.jAj.cud();
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
                            ((C0427a) b.jAl.remove()).gY(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jAm = new C0427a(this, jAl);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jAm = new C0427a(this, jAl);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jAm.gY(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jAm.isDestroyed();
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
                        c cVar = a.jAh;
                        if (cVar != null) {
                            cVar.a(this, this.jAi);
                        } else {
                            com.facebook.common.c.a.d(a.jyG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jAj)), this.jAj.get().getClass().getSimpleName());
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

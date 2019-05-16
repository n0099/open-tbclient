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
    private static volatile c jSs;
    @GuardedBy("this")
    protected boolean Fx;
    @Nullable
    protected Throwable jSt;
    protected final SharedReference<T> jSu;
    private static Class<a> jQR = a.class;
    private static final com.facebook.common.references.c<Closeable> jSr = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean jSv = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.Fx = false;
        this.jSu = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cBS();
        this.jSt = cBO();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.Fx = false;
        this.jSu = new SharedReference<>(t, cVar);
        this.jSt = cBO();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jSr);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jSv ? new C0445a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.Fx) {
                this.Fx = true;
                this.jSu.cBT();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.Fx);
        return this.jSu.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cBJ */
    public synchronized a<T> clone() {
        this.jSt = cBO();
        g.checkState(isValid());
        return cBL();
    }

    public synchronized a<T> cBK() {
        this.jSt = cBO();
        return isValid() ? cBL() : null;
    }

    private a<T> cBL() {
        return jSv ? new C0445a((SharedReference) this.jSu) : new b((SharedReference) this.jSu);
    }

    public synchronized boolean isValid() {
        return !this.Fx;
    }

    public static boolean cBM() {
        return jSs != null;
    }

    public void s(Throwable th) {
        this.jSt = th;
    }

    public synchronized int cBN() {
        return isValid() ? System.identityHashCode(this.jSu.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.cBK();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable cBO() {
        if (jSs != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jSw = new ReferenceQueue<>();
        private final C0446a jSx;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0446a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0446a jSy;
            @GuardedBy("Destructor.class")
            private C0446a jSA;
            @GuardedBy("this")
            private boolean jSB;
            private final SharedReference jSu;
            @GuardedBy("Destructor.class")
            private C0446a jSz;

            public C0446a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jSu = aVar.jSu;
                synchronized (C0446a.class) {
                    if (jSy != null) {
                        jSy.jSz = this;
                        this.jSA = jSy;
                    }
                    jSy = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jSB;
            }

            public void hw(boolean z) {
                synchronized (this) {
                    if (!this.jSB) {
                        this.jSB = true;
                        synchronized (C0446a.class) {
                            if (this.jSA != null) {
                                this.jSA.jSz = this.jSz;
                            }
                            if (this.jSz != null) {
                                this.jSz.jSA = this.jSA;
                            } else {
                                jSy = this.jSA;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jQR, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jSu)), this.jSu.get().getClass().getSimpleName());
                        }
                        this.jSu.cBT();
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
                            ((C0446a) b.jSw.remove()).hw(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jSx = new C0446a(this, jSw);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jSx = new C0446a(this, jSw);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jSx.hw(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jSx.isDestroyed();
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
                        c cVar = a.jSs;
                        if (cVar != null) {
                            cVar.a(this, this.jSt);
                        } else {
                            com.facebook.common.c.a.d(a.jQR, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jSu)), this.jSu.get().getClass().getSimpleName());
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

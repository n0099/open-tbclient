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
    private static volatile c kaG;
    @GuardedBy("this")
    protected boolean FD;
    @Nullable
    protected Throwable kaH;
    protected final SharedReference<T> kaI;
    private static Class<a> jZg = a.class;
    private static final com.facebook.common.references.c<Closeable> kaF = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean kaJ = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.FD = false;
        this.kaI = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cFp();
        this.kaH = cFl();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.FD = false;
        this.kaI = new SharedReference<>(t, cVar);
        this.kaH = cFl();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, kaF);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return kaJ ? new C0450a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.FD) {
                this.FD = true;
                this.kaI.cFq();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.FD);
        return this.kaI.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cFg */
    public synchronized a<T> clone() {
        this.kaH = cFl();
        g.checkState(isValid());
        return cFi();
    }

    public synchronized a<T> cFh() {
        this.kaH = cFl();
        return isValid() ? cFi() : null;
    }

    private a<T> cFi() {
        return kaJ ? new C0450a((SharedReference) this.kaI) : new b((SharedReference) this.kaI);
    }

    public synchronized boolean isValid() {
        return !this.FD;
    }

    public static boolean cFj() {
        return kaG != null;
    }

    public void s(Throwable th) {
        this.kaH = th;
    }

    public synchronized int cFk() {
        return isValid() ? System.identityHashCode(this.kaI.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.cFh();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable cFl() {
        if (kaG != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> kaK = new ReferenceQueue<>();
        private final C0451a kaL;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0451a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0451a kaM;
            private final SharedReference kaI;
            @GuardedBy("Destructor.class")
            private C0451a kaN;
            @GuardedBy("Destructor.class")
            private C0451a kaO;
            @GuardedBy("this")
            private boolean kaP;

            public C0451a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.kaI = aVar.kaI;
                synchronized (C0451a.class) {
                    if (kaM != null) {
                        kaM.kaN = this;
                        this.kaO = kaM;
                    }
                    kaM = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.kaP;
            }

            public void hD(boolean z) {
                synchronized (this) {
                    if (!this.kaP) {
                        this.kaP = true;
                        synchronized (C0451a.class) {
                            if (this.kaO != null) {
                                this.kaO.kaN = this.kaN;
                            }
                            if (this.kaN != null) {
                                this.kaN.kaO = this.kaO;
                            } else {
                                kaM = this.kaO;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jZg, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kaI)), this.kaI.get().getClass().getSimpleName());
                        }
                        this.kaI.cFq();
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
                            ((C0451a) b.kaK.remove()).hD(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.kaL = new C0451a(this, kaK);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.kaL = new C0451a(this, kaK);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.kaL.hD(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.kaL.isDestroyed();
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
                        c cVar = a.kaG;
                        if (cVar != null) {
                            cVar.a(this, this.kaH);
                        } else {
                            com.facebook.common.c.a.d(a.jZg, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kaI)), this.kaI.get().getClass().getSimpleName());
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

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
    private static volatile c jAp;
    @GuardedBy("this")
    protected boolean HM;
    @Nullable
    protected Throwable jAq;
    protected final SharedReference<T> jAr;
    private static Class<a> jyO = a.class;
    private static final com.facebook.common.references.c<Closeable> jAo = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean jAs = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HM = false;
        this.jAr = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.ctZ();
        this.jAq = ctV();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HM = false;
        this.jAr = new SharedReference<>(t, cVar);
        this.jAq = ctV();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jAo);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jAs ? new C0333a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HM) {
                this.HM = true;
                this.jAr.cua();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HM);
        return this.jAr.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: ctQ */
    public synchronized a<T> clone() {
        this.jAq = ctV();
        g.checkState(isValid());
        return ctS();
    }

    public synchronized a<T> ctR() {
        this.jAq = ctV();
        return isValid() ? ctS() : null;
    }

    private a<T> ctS() {
        return jAs ? new C0333a((SharedReference) this.jAr) : new b((SharedReference) this.jAr);
    }

    public synchronized boolean isValid() {
        return !this.HM;
    }

    public static boolean ctT() {
        return jAp != null;
    }

    public void t(Throwable th) {
        this.jAq = th;
    }

    public synchronized int ctU() {
        return isValid() ? System.identityHashCode(this.jAr.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.ctR();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable ctV() {
        if (jAp != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jAt = new ReferenceQueue<>();
        private final C0334a jAu;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0334a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0334a jAv;
            private final SharedReference jAr;
            @GuardedBy("Destructor.class")
            private C0334a jAw;
            @GuardedBy("Destructor.class")
            private C0334a jAx;
            @GuardedBy("this")
            private boolean jAy;

            public C0334a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jAr = aVar.jAr;
                synchronized (C0334a.class) {
                    if (jAv != null) {
                        jAv.jAw = this;
                        this.jAx = jAv;
                    }
                    jAv = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jAy;
            }

            public void gY(boolean z) {
                synchronized (this) {
                    if (!this.jAy) {
                        this.jAy = true;
                        synchronized (C0334a.class) {
                            if (this.jAx != null) {
                                this.jAx.jAw = this.jAw;
                            }
                            if (this.jAw != null) {
                                this.jAw.jAx = this.jAx;
                            } else {
                                jAv = this.jAx;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jyO, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jAr)), this.jAr.get().getClass().getSimpleName());
                        }
                        this.jAr.cua();
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
                            ((C0334a) b.jAt.remove()).gY(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jAu = new C0334a(this, jAt);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jAu = new C0334a(this, jAt);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jAu.gY(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jAu.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0333a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0333a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0333a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.HM) {
                        c cVar = a.jAp;
                        if (cVar != null) {
                            cVar.a(this, this.jAq);
                        } else {
                            com.facebook.common.c.a.d(a.jyO, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jAr)), this.jAr.get().getClass().getSimpleName());
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

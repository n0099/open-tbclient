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
    private static volatile c kdd;
    @GuardedBy("this")
    protected boolean FD;
    @Nullable
    protected Throwable kde;
    protected final SharedReference<T> kdf;
    private static Class<a> kbD = a.class;
    private static final com.facebook.common.references.c<Closeable> kdc = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean kdg = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.FD = false;
        this.kdf = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cGd();
        this.kde = cFZ();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.FD = false;
        this.kdf = new SharedReference<>(t, cVar);
        this.kde = cFZ();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, kdc);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return kdg ? new C0461a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.FD) {
                this.FD = true;
                this.kdf.cGe();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.FD);
        return this.kdf.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cFU */
    public synchronized a<T> clone() {
        this.kde = cFZ();
        g.checkState(isValid());
        return cFW();
    }

    public synchronized a<T> cFV() {
        this.kde = cFZ();
        return isValid() ? cFW() : null;
    }

    private a<T> cFW() {
        return kdg ? new C0461a((SharedReference) this.kdf) : new b((SharedReference) this.kdf);
    }

    public synchronized boolean isValid() {
        return !this.FD;
    }

    public static boolean cFX() {
        return kdd != null;
    }

    public void s(Throwable th) {
        this.kde = th;
    }

    public synchronized int cFY() {
        return isValid() ? System.identityHashCode(this.kdf.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.cFV();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable cFZ() {
        if (kdd != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> kdh = new ReferenceQueue<>();
        private final C0462a kdi;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0462a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0462a kdj;
            private final SharedReference kdf;
            @GuardedBy("Destructor.class")
            private C0462a kdk;
            @GuardedBy("Destructor.class")
            private C0462a kdl;
            @GuardedBy("this")
            private boolean kdm;

            public C0462a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.kdf = aVar.kdf;
                synchronized (C0462a.class) {
                    if (kdj != null) {
                        kdj.kdk = this;
                        this.kdl = kdj;
                    }
                    kdj = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.kdm;
            }

            public void hG(boolean z) {
                synchronized (this) {
                    if (!this.kdm) {
                        this.kdm = true;
                        synchronized (C0462a.class) {
                            if (this.kdl != null) {
                                this.kdl.kdk = this.kdk;
                            }
                            if (this.kdk != null) {
                                this.kdk.kdl = this.kdl;
                            } else {
                                kdj = this.kdl;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.kbD, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kdf)), this.kdf.get().getClass().getSimpleName());
                        }
                        this.kdf.cGe();
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
                            ((C0462a) b.kdh.remove()).hG(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.kdi = new C0462a(this, kdh);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.kdi = new C0462a(this, kdh);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.kdi.hG(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.kdi.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0461a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0461a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0461a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.FD) {
                        c cVar = a.kdd;
                        if (cVar != null) {
                            cVar.a(this, this.kde);
                        } else {
                            com.facebook.common.c.a.d(a.kbD, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kdf)), this.kdf.get().getClass().getSimpleName());
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

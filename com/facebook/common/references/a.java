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
    private static volatile c ikt;
    @GuardedBy("this")
    protected boolean HL;
    @Nullable
    protected Throwable iku;
    protected final SharedReference<T> ikv;
    private static Class<a> iiQ = a.class;
    private static final com.facebook.common.references.c<Closeable> iks = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.references.c
        /* renamed from: d */
        public void release(Closeable closeable) {
            try {
                com.facebook.common.internal.b.a(closeable, true);
            } catch (IOException e) {
            }
        }
    };
    private static volatile boolean ikw = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HL = false;
        this.ikv = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.bUR();
        this.iku = bUN();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HL = false;
        this.ikv = new SharedReference<>(t, cVar);
        this.iku = bUN();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, iks);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return ikw ? new C0354a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HL) {
                this.HL = true;
                this.ikv.bUS();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HL);
        return this.ikv.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: bUI */
    public synchronized a<T> clone() {
        this.iku = bUN();
        g.checkState(isValid());
        return bUK();
    }

    public synchronized a<T> bUJ() {
        this.iku = bUN();
        return isValid() ? bUK() : null;
    }

    private a<T> bUK() {
        return ikw ? new C0354a((SharedReference) this.ikv) : new b((SharedReference) this.ikv);
    }

    public synchronized boolean isValid() {
        return !this.HL;
    }

    public static boolean bUL() {
        return ikt != null;
    }

    public void s(Throwable th) {
        this.iku = th;
    }

    public synchronized int bUM() {
        return isValid() ? System.identityHashCode(this.ikv.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.bUJ();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable bUN() {
        if (ikt != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> ikx = new ReferenceQueue<>();
        private final C0355a iky;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0355a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0355a ikz;
            @GuardedBy("Destructor.class")
            private C0355a ikA;
            @GuardedBy("Destructor.class")
            private C0355a ikB;
            @GuardedBy("this")
            private boolean ikC;
            private final SharedReference ikv;

            public C0355a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.ikv = aVar.ikv;
                synchronized (C0355a.class) {
                    if (ikz != null) {
                        ikz.ikA = this;
                        this.ikB = ikz;
                    }
                    ikz = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.ikC;
            }

            public void eD(boolean z) {
                synchronized (this) {
                    if (!this.ikC) {
                        this.ikC = true;
                        synchronized (C0355a.class) {
                            if (this.ikB != null) {
                                this.ikB.ikA = this.ikA;
                            }
                            if (this.ikA != null) {
                                this.ikA.ikB = this.ikB;
                            } else {
                                ikz = this.ikB;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.iiQ, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ikv)), this.ikv.get().getClass().getSimpleName());
                        }
                        this.ikv.bUS();
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
                            ((C0355a) b.ikx.remove()).eD(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.iky = new C0355a(this, ikx);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.iky = new C0355a(this, ikx);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.iky.eD(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.iky.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0354a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0354a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0354a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.HL) {
                        c cVar = a.ikt;
                        if (cVar != null) {
                            cVar.a(this, this.iku);
                        } else {
                            com.facebook.common.c.a.d(a.iiQ, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ikv)), this.ikv.get().getClass().getSimpleName());
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

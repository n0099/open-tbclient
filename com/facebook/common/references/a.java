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
    private static volatile c iku;
    @GuardedBy("this")
    protected boolean HL;
    @Nullable
    protected Throwable ikv;
    protected final SharedReference<T> ikw;
    private static Class<a> iiR = a.class;
    private static final com.facebook.common.references.c<Closeable> ikt = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean ikx = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HL = false;
        this.ikw = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.bUR();
        this.ikv = bUN();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HL = false;
        this.ikw = new SharedReference<>(t, cVar);
        this.ikv = bUN();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, ikt);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return ikx ? new C0354a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HL) {
                this.HL = true;
                this.ikw.bUS();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HL);
        return this.ikw.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: bUI */
    public synchronized a<T> clone() {
        this.ikv = bUN();
        g.checkState(isValid());
        return bUK();
    }

    public synchronized a<T> bUJ() {
        this.ikv = bUN();
        return isValid() ? bUK() : null;
    }

    private a<T> bUK() {
        return ikx ? new C0354a((SharedReference) this.ikw) : new b((SharedReference) this.ikw);
    }

    public synchronized boolean isValid() {
        return !this.HL;
    }

    public static boolean bUL() {
        return iku != null;
    }

    public void s(Throwable th) {
        this.ikv = th;
    }

    public synchronized int bUM() {
        return isValid() ? System.identityHashCode(this.ikw.get()) : 0;
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
        if (iku != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> iky = new ReferenceQueue<>();
        private final C0355a ikz;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0355a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0355a ikA;
            @GuardedBy("Destructor.class")
            private C0355a ikB;
            @GuardedBy("Destructor.class")
            private C0355a ikC;
            @GuardedBy("this")
            private boolean ikD;
            private final SharedReference ikw;

            public C0355a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.ikw = aVar.ikw;
                synchronized (C0355a.class) {
                    if (ikA != null) {
                        ikA.ikB = this;
                        this.ikC = ikA;
                    }
                    ikA = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.ikD;
            }

            public void eD(boolean z) {
                synchronized (this) {
                    if (!this.ikD) {
                        this.ikD = true;
                        synchronized (C0355a.class) {
                            if (this.ikC != null) {
                                this.ikC.ikB = this.ikB;
                            }
                            if (this.ikB != null) {
                                this.ikB.ikC = this.ikC;
                            } else {
                                ikA = this.ikC;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.iiR, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ikw)), this.ikw.get().getClass().getSimpleName());
                        }
                        this.ikw.bUS();
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
                            ((C0355a) b.iky.remove()).eD(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.ikz = new C0355a(this, iky);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.ikz = new C0355a(this, iky);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.ikz.eD(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.ikz.isDestroyed();
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
                        c cVar = a.iku;
                        if (cVar != null) {
                            cVar.a(this, this.ikv);
                        } else {
                            com.facebook.common.c.a.d(a.iiR, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ikw)), this.ikw.get().getClass().getSimpleName());
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

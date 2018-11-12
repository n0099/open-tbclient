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
    private static volatile c hYP;
    @GuardedBy("this")
    protected boolean HL;
    @Nullable
    protected Throwable hYQ;
    protected final SharedReference<T> hYR;
    private static Class<a> hXm = a.class;
    private static final com.facebook.common.references.c<Closeable> hYO = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean hYS = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HL = false;
        this.hYR = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.bRn();
        this.hYQ = bRj();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HL = false;
        this.hYR = new SharedReference<>(t, cVar);
        this.hYQ = bRj();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, hYO);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return hYS ? new C0341a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HL) {
                this.HL = true;
                this.hYR.bRo();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HL);
        return this.hYR.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: bRe */
    public synchronized a<T> clone() {
        this.hYQ = bRj();
        g.checkState(isValid());
        return bRg();
    }

    public synchronized a<T> bRf() {
        this.hYQ = bRj();
        return isValid() ? bRg() : null;
    }

    private a<T> bRg() {
        return hYS ? new C0341a((SharedReference) this.hYR) : new b((SharedReference) this.hYR);
    }

    public synchronized boolean isValid() {
        return !this.HL;
    }

    public static boolean bRh() {
        return hYP != null;
    }

    public void s(Throwable th) {
        this.hYQ = th;
    }

    public synchronized int bRi() {
        return isValid() ? System.identityHashCode(this.hYR.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.bRf();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable bRj() {
        if (hYP != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> hYT = new ReferenceQueue<>();
        private final C0342a hYU;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0342a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0342a hYV;
            private final SharedReference hYR;
            @GuardedBy("Destructor.class")
            private C0342a hYW;
            @GuardedBy("Destructor.class")
            private C0342a hYX;
            @GuardedBy("this")
            private boolean hYY;

            public C0342a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.hYR = aVar.hYR;
                synchronized (C0342a.class) {
                    if (hYV != null) {
                        hYV.hYW = this;
                        this.hYX = hYV;
                    }
                    hYV = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.hYY;
            }

            public void eA(boolean z) {
                synchronized (this) {
                    if (!this.hYY) {
                        this.hYY = true;
                        synchronized (C0342a.class) {
                            if (this.hYX != null) {
                                this.hYX.hYW = this.hYW;
                            }
                            if (this.hYW != null) {
                                this.hYW.hYX = this.hYX;
                            } else {
                                hYV = this.hYX;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.hXm, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.hYR)), this.hYR.get().getClass().getSimpleName());
                        }
                        this.hYR.bRo();
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
                            ((C0342a) b.hYT.remove()).eA(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.hYU = new C0342a(this, hYT);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.hYU = new C0342a(this, hYT);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.hYU.eA(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.hYU.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0341a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0341a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0341a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.HL) {
                        c cVar = a.hYP;
                        if (cVar != null) {
                            cVar.a(this, this.hYQ);
                        } else {
                            com.facebook.common.c.a.d(a.hXm, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.hYR)), this.hYR.get().getClass().getSimpleName());
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

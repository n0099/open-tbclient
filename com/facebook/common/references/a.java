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
    private static volatile c kav;
    @Nullable
    protected Throwable kaw;
    protected final SharedReference<T> kax;
    @GuardedBy("this")
    protected boolean sm;
    private static Class<a> jYW = a.class;
    private static final com.facebook.common.references.c<Closeable> kau = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean kay = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.sm = false;
        this.kax = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.cCZ();
        this.kaw = cCV();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.sm = false;
        this.kax = new SharedReference<>(t, cVar);
        this.kaw = cCV();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, kau);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return kay ? new C0556a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.sm) {
                this.sm = true;
                this.kax.cDa();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.sm);
        return this.kax.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: cCQ */
    public synchronized a<T> clone() {
        this.kaw = cCV();
        g.checkState(isValid());
        return cCS();
    }

    public synchronized a<T> cCR() {
        this.kaw = cCV();
        return isValid() ? cCS() : null;
    }

    private a<T> cCS() {
        return kay ? new C0556a((SharedReference) this.kax) : new b((SharedReference) this.kax);
    }

    public synchronized boolean isValid() {
        return !this.sm;
    }

    public static boolean cCT() {
        return kav != null;
    }

    public void s(Throwable th) {
        this.kaw = th;
    }

    public synchronized int cCU() {
        return isValid() ? System.identityHashCode(this.kax.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.cCR();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable cCV() {
        if (kav != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> kaz = new ReferenceQueue<>();
        private final C0557a kaA;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0557a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0557a kaB;
            @GuardedBy("Destructor.class")
            private C0557a kaC;
            @GuardedBy("Destructor.class")
            private C0557a kaD;
            @GuardedBy("this")
            private boolean kaE;
            private final SharedReference kax;

            public C0557a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.kax = aVar.kax;
                synchronized (C0557a.class) {
                    if (kaB != null) {
                        kaB.kaC = this;
                        this.kaD = kaB;
                    }
                    kaB = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.kaE;
            }

            public void hK(boolean z) {
                synchronized (this) {
                    if (!this.kaE) {
                        this.kaE = true;
                        synchronized (C0557a.class) {
                            if (this.kaD != null) {
                                this.kaD.kaC = this.kaC;
                            }
                            if (this.kaC != null) {
                                this.kaC.kaD = this.kaD;
                            } else {
                                kaB = this.kaD;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.c(a.jYW, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kax)), this.kax.get().getClass().getSimpleName());
                        }
                        this.kax.cDa();
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
                            ((C0557a) b.kaz.remove()).hK(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.kaA = new C0557a(this, kaz);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.kaA = new C0557a(this, kaz);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.kaA.hK(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.kaA.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0556a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0556a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0556a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.sm) {
                        c cVar = a.kav;
                        if (cVar != null) {
                            cVar.a(this, this.kaw);
                        } else {
                            com.facebook.common.c.a.c(a.jYW, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.kax)), this.kax.get().getClass().getSimpleName());
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

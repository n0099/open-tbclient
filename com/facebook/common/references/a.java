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
    private static volatile c jzW;
    @GuardedBy("this")
    protected boolean HM;
    @Nullable
    protected Throwable jzX;
    protected final SharedReference<T> jzY;
    private static Class<a> jyv = a.class;
    private static final com.facebook.common.references.c<Closeable> jzV = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean jzZ = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HM = false;
        this.jzY = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.ctP();
        this.jzX = ctL();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HM = false;
        this.jzY = new SharedReference<>(t, cVar);
        this.jzX = ctL();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a d(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, jzV);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return jzZ ? new C0330a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HM) {
                this.HM = true;
                this.jzY.ctQ();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HM);
        return this.jzY.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: ctG */
    public synchronized a<T> clone() {
        this.jzX = ctL();
        g.checkState(isValid());
        return ctI();
    }

    public synchronized a<T> ctH() {
        this.jzX = ctL();
        return isValid() ? ctI() : null;
    }

    private a<T> ctI() {
        return jzZ ? new C0330a((SharedReference) this.jzY) : new b((SharedReference) this.jzY);
    }

    public synchronized boolean isValid() {
        return !this.HM;
    }

    public static boolean ctJ() {
        return jzW != null;
    }

    public void t(Throwable th) {
        this.jzX = th;
    }

    public synchronized int ctK() {
        return isValid() ? System.identityHashCode(this.jzY.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.ctH();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable ctL() {
        if (jzW != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> jAa = new ReferenceQueue<>();
        private final C0331a jAb;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0331a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0331a jAc;
            @GuardedBy("Destructor.class")
            private C0331a jAd;
            @GuardedBy("Destructor.class")
            private C0331a jAe;
            @GuardedBy("this")
            private boolean jAf;
            private final SharedReference jzY;

            public C0331a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.jzY = aVar.jzY;
                synchronized (C0331a.class) {
                    if (jAc != null) {
                        jAc.jAd = this;
                        this.jAe = jAc;
                    }
                    jAc = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.jAf;
            }

            public void gY(boolean z) {
                synchronized (this) {
                    if (!this.jAf) {
                        this.jAf = true;
                        synchronized (C0331a.class) {
                            if (this.jAe != null) {
                                this.jAe.jAd = this.jAd;
                            }
                            if (this.jAd != null) {
                                this.jAd.jAe = this.jAe;
                            } else {
                                jAc = this.jAe;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.jyv, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jzY)), this.jzY.get().getClass().getSimpleName());
                        }
                        this.jzY.ctQ();
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
                            ((C0331a) b.jAa.remove()).gY(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.jAb = new C0331a(this, jAa);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.jAb = new C0331a(this, jAa);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.jAb.gY(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.jAb.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0330a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0330a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0330a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.HM) {
                        c cVar = a.jzW;
                        if (cVar != null) {
                            cVar.a(this, this.jzX);
                        } else {
                            com.facebook.common.c.a.d(a.jyv, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.jzY)), this.jzY.get().getClass().getSimpleName());
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

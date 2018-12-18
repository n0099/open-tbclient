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
    private static volatile c igc;
    @GuardedBy("this")
    protected boolean HL;
    @Nullable
    protected Throwable igd;
    protected final SharedReference<T> ige;
    private static Class<a> iez = a.class;
    private static final com.facebook.common.references.c<Closeable> igb = new com.facebook.common.references.c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private static volatile boolean igf = true;

    /* loaded from: classes2.dex */
    public interface c {
        void a(a<?> aVar, Throwable th);
    }

    private a(SharedReference<T> sharedReference) {
        this.HL = false;
        this.ige = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.bTs();
        this.igd = bTo();
    }

    private a(T t, com.facebook.common.references.c<T> cVar) {
        this.HL = false;
        this.ige = new SharedReference<>(t, cVar);
        this.igd = bTo();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    @Nullable
    public static a c(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return b(closeable, igb);
    }

    @Nullable
    public static <T> a<T> a(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        if (t == null) {
            return null;
        }
        return b(t, cVar);
    }

    private static <T> a<T> b(@Nullable T t, com.facebook.common.references.c<T> cVar) {
        return igf ? new C0355a(t, cVar) : new b(t, cVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.HL) {
                this.HL = true;
                this.ige.bTt();
            }
        }
    }

    public synchronized T get() {
        g.checkState(!this.HL);
        return this.ige.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: bTj */
    public synchronized a<T> clone() {
        this.igd = bTo();
        g.checkState(isValid());
        return bTl();
    }

    public synchronized a<T> bTk() {
        this.igd = bTo();
        return isValid() ? bTl() : null;
    }

    private a<T> bTl() {
        return igf ? new C0355a((SharedReference) this.ige) : new b((SharedReference) this.ige);
    }

    public synchronized boolean isValid() {
        return !this.HL;
    }

    public static boolean bTm() {
        return igc != null;
    }

    public void s(Throwable th) {
        this.igd = th;
    }

    public synchronized int bTn() {
        return isValid() ? System.identityHashCode(this.ige.get()) : 0;
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.bTk();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    @Nullable
    private static Throwable bTo() {
        if (igc != null) {
            return new Throwable();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<T> extends a<T> {
        private static final ReferenceQueue<a> igg = new ReferenceQueue<>();
        private final C0356a igh;

        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        /* renamed from: com.facebook.common.references.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0356a extends PhantomReference<a> {
            @GuardedBy("Destructor.class")
            private static C0356a igi;
            private final SharedReference ige;
            @GuardedBy("Destructor.class")
            private C0356a igj;
            @GuardedBy("Destructor.class")
            private C0356a igk;
            @GuardedBy("this")
            private boolean igl;

            public C0356a(a aVar, ReferenceQueue<? super a> referenceQueue) {
                super(aVar, referenceQueue);
                this.ige = aVar.ige;
                synchronized (C0356a.class) {
                    if (igi != null) {
                        igi.igj = this;
                        this.igk = igi;
                    }
                    igi = this;
                }
            }

            public synchronized boolean isDestroyed() {
                return this.igl;
            }

            public void eA(boolean z) {
                synchronized (this) {
                    if (!this.igl) {
                        this.igl = true;
                        synchronized (C0356a.class) {
                            if (this.igk != null) {
                                this.igk.igj = this.igj;
                            }
                            if (this.igj != null) {
                                this.igj.igk = this.igk;
                            } else {
                                igi = this.igk;
                            }
                        }
                        if (!z) {
                            com.facebook.common.c.a.d(a.iez, "GCed without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ige)), this.ige.get().getClass().getSimpleName());
                        }
                        this.ige.bTt();
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
                            ((C0356a) b.igg.remove()).eA(false);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }, "CloseableReferenceDestructorThread").start();
        }

        private b(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
            this.igh = new C0356a(this, igg);
        }

        private b(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
            this.igh = new C0356a(this, igg);
        }

        @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.igh.eA(true);
        }

        @Override // com.facebook.common.references.a
        public boolean isValid() {
            return !this.igh.isDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0355a<T> extends a<T> {
        @Override // com.facebook.common.references.a
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private C0355a(SharedReference<T> sharedReference) {
            super((SharedReference) sharedReference);
        }

        private C0355a(T t, com.facebook.common.references.c<T> cVar) {
            super(t, cVar);
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this) {
                    if (!this.HL) {
                        c cVar = a.igc;
                        if (cVar != null) {
                            cVar.a(this, this.igd);
                        } else {
                            com.facebook.common.c.a.d(a.iez, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ige)), this.ige.get().getClass().getSimpleName());
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

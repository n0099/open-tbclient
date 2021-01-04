package com.facebook.common.references;

import com.facebook.common.internal.g;
import com.facebook.infer.annotation.PropagatesNullable;
import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public final class a<T> implements Closeable, Cloneable {
    private static Class<a> prQ = a.class;
    private static final c<Closeable> ptq = new c<Closeable>() { // from class: com.facebook.common.references.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.references.c
        /* renamed from: g */
        public void release(Closeable closeable) {
            try {
                com.facebook.common.internal.b.close(closeable, true);
            } catch (IOException e) {
            }
        }
    };
    @GuardedBy("this")
    private boolean Rz = false;
    private final SharedReference<T> ptp;

    private a(SharedReference<T> sharedReference) {
        this.ptp = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.eug();
    }

    private a(T t, c<T> cVar) {
        this.ptp = new SharedReference<>(t, cVar);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    public static a f(@PropagatesNullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return new a(closeable, ptq);
    }

    public static <T> a<T> a(@PropagatesNullable T t, c<T> cVar) {
        if (t == null) {
            return null;
        }
        return new a<>(t, cVar);
    }

    public synchronized T get() {
        g.checkState(!this.Rz);
        return this.ptp.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eud */
    public synchronized a<T> clone() {
        g.checkState(isValid());
        return new a<>(this.ptp);
    }

    @Nullable
    public synchronized a<T> eue() {
        return isValid() ? clone() : null;
    }

    public synchronized boolean isValid() {
        return !this.Rz;
    }

    public int euf() {
        if (isValid()) {
            return System.identityHashCode(this.ptp.get());
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.Rz) {
                this.Rz = true;
                this.ptp.euh();
            }
        }
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.eue();
        }
        return null;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    public static void b(@Nullable Iterable<? extends a<?>> iterable) {
        if (iterable != null) {
            for (a<?> aVar : iterable) {
                c(aVar);
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.Rz) {
                    com.facebook.common.c.a.c((Class<?>) prQ, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ptp)), this.ptp.get().getClass().getName());
                    close();
                }
            }
        } finally {
            super.finalize();
        }
    }
}

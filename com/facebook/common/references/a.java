package com.facebook.common.references;

import com.facebook.common.internal.g;
import com.facebook.infer.annotation.PropagatesNullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public final class a<T> implements Closeable, Cloneable {
    private static Class<a> lIR = a.class;
    private static final c<Closeable> lKy = new c<Closeable>() { // from class: com.facebook.common.references.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.references.c
        /* renamed from: c */
        public void release(Closeable closeable) {
            try {
                com.facebook.common.internal.b.close(closeable, true);
            } catch (IOException e) {
            }
        }
    };
    private final SharedReference<T> lKx;
    @GuardedBy("this")
    private boolean vA = false;

    private a(SharedReference<T> sharedReference) {
        this.lKx = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.dlt();
    }

    private a(T t, c<T> cVar) {
        this.lKx = new SharedReference<>(t, cVar);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    public static a b(@PropagatesNullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return new a(closeable, lKy);
    }

    public static <T> a<T> a(@PropagatesNullable T t, c<T> cVar) {
        if (t == null) {
            return null;
        }
        return new a<>(t, cVar);
    }

    public synchronized T get() {
        g.checkState(!this.vA);
        return this.lKx.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: dlq */
    public synchronized a<T> clone() {
        g.checkState(isValid());
        return new a<>(this.lKx);
    }

    @Nullable
    public synchronized a<T> dlr() {
        return isValid() ? clone() : null;
    }

    public synchronized boolean isValid() {
        return !this.vA;
    }

    public int dls() {
        if (isValid()) {
            return System.identityHashCode(this.lKx.get());
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.vA) {
                this.vA = true;
                this.lKx.dlu();
            }
        }
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.dlr();
        }
        return null;
    }

    public static <T> List<a<T>> i(@PropagatesNullable Collection<a<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (a<T> aVar : collection) {
            arrayList.add(b((a) aVar));
        }
        return arrayList;
    }

    public static void c(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    public static void a(@Nullable Iterable<? extends a<?>> iterable) {
        if (iterable != null) {
            for (a<?> aVar : iterable) {
                c(aVar);
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.c.a.c(lIR, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.lKx)), this.lKx.get().getClass().getName());
                    close();
                }
            }
        } finally {
            super.finalize();
        }
    }
}

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
/* loaded from: classes12.dex */
public final class a<T> implements Closeable, Cloneable {
    private static Class<a> mPx = a.class;
    private static final c<Closeable> mRe = new c<Closeable>() { // from class: com.facebook.common.references.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.references.c
        /* renamed from: f */
        public void release(Closeable closeable) {
            try {
                com.facebook.common.internal.b.close(closeable, true);
            } catch (IOException e) {
            }
        }
    };
    @GuardedBy("this")
    private boolean Pi = false;
    private final SharedReference<T> mRd;

    private a(SharedReference<T> sharedReference) {
        this.mRd = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.dCK();
    }

    private a(T t, c<T> cVar) {
        this.mRd = new SharedReference<>(t, cVar);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    public static a e(@PropagatesNullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return new a(closeable, mRe);
    }

    public static <T> a<T> a(@PropagatesNullable T t, c<T> cVar) {
        if (t == null) {
            return null;
        }
        return new a<>(t, cVar);
    }

    public synchronized T get() {
        g.checkState(!this.Pi);
        return this.mRd.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: dCH */
    public synchronized a<T> clone() {
        g.checkState(isValid());
        return new a<>(this.mRd);
    }

    @Nullable
    public synchronized a<T> dCI() {
        return isValid() ? clone() : null;
    }

    public synchronized boolean isValid() {
        return !this.Pi;
    }

    public int dCJ() {
        if (isValid()) {
            return System.identityHashCode(this.mRd.get());
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.Pi) {
                this.Pi = true;
                this.mRd.dCL();
            }
        }
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.dCI();
        }
        return null;
    }

    public static <T> List<a<T>> k(@PropagatesNullable Collection<a<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (a<T> aVar : collection) {
            arrayList.add(b(aVar));
        }
        return arrayList;
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
                if (!this.Pi) {
                    com.facebook.common.c.a.c(mPx, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mRd)), this.mRd.get().getClass().getName());
                    close();
                }
            }
        } finally {
            super.finalize();
        }
    }
}

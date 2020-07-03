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
    private static Class<a> mHo = a.class;
    private static final c<Closeable> mIY = new c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private final SharedReference<T> mIX;

    private a(SharedReference<T> sharedReference) {
        this.mIX = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.dzu();
    }

    private a(T t, c<T> cVar) {
        this.mIX = new SharedReference<>(t, cVar);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    public static a e(@PropagatesNullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return new a(closeable, mIY);
    }

    public static <T> a<T> a(@PropagatesNullable T t, c<T> cVar) {
        if (t == null) {
            return null;
        }
        return new a<>(t, cVar);
    }

    public synchronized T get() {
        g.checkState(!this.Pi);
        return this.mIX.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: dzr */
    public synchronized a<T> clone() {
        g.checkState(isValid());
        return new a<>(this.mIX);
    }

    @Nullable
    public synchronized a<T> dzs() {
        return isValid() ? clone() : null;
    }

    public synchronized boolean isValid() {
        return !this.Pi;
    }

    public int dzt() {
        if (isValid()) {
            return System.identityHashCode(this.mIX.get());
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.Pi) {
                this.Pi = true;
                this.mIX.dzv();
            }
        }
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.dzs();
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
                    com.facebook.common.c.a.c(mHo, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mIX)), this.mIX.get().getClass().getName());
                    close();
                }
            }
        } finally {
            super.finalize();
        }
    }
}

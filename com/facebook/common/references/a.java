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
/* loaded from: classes3.dex */
public final class a<T> implements Closeable, Cloneable {
    private static Class<a> prR = a.class;
    private static final c<Closeable> pty = new c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private final SharedReference<T> ptx;

    private a(SharedReference<T> sharedReference) {
        this.ptx = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.eun();
    }

    private a(T t, c<T> cVar) {
        this.ptx = new SharedReference<>(t, cVar);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    public static a f(@PropagatesNullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return new a(closeable, pty);
    }

    public static <T> a<T> a(@PropagatesNullable T t, c<T> cVar) {
        if (t == null) {
            return null;
        }
        return new a<>(t, cVar);
    }

    public synchronized T get() {
        g.checkState(!this.Rz);
        return this.ptx.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: euk */
    public synchronized a<T> clone() {
        g.checkState(isValid());
        return new a<>(this.ptx);
    }

    @Nullable
    public synchronized a<T> eul() {
        return isValid() ? clone() : null;
    }

    public synchronized boolean isValid() {
        return !this.Rz;
    }

    public int eum() {
        if (isValid()) {
            return System.identityHashCode(this.ptx.get());
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.Rz) {
                this.Rz = true;
                this.ptx.euo();
            }
        }
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.eul();
        }
        return null;
    }

    public static <T> List<a<T>> m(@PropagatesNullable Collection<a<T>> collection) {
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
                if (!this.Rz) {
                    com.facebook.common.c.a.c((Class<?>) prR, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.ptx)), this.ptx.get().getClass().getName());
                    close();
                }
            }
        } finally {
            super.finalize();
        }
    }
}

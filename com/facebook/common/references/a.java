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
/* loaded from: classes9.dex */
public final class a<T> implements Closeable, Cloneable {
    private static Class<a> nju = a.class;
    private static final c<Closeable> nla = new c<Closeable>() { // from class: com.facebook.common.references.a.1
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
    private boolean PQ = false;
    private final SharedReference<T> nkZ;

    private a(SharedReference<T> sharedReference) {
        this.nkZ = (SharedReference) g.checkNotNull(sharedReference);
        sharedReference.dOL();
    }

    private a(T t, c<T> cVar) {
        this.nkZ = new SharedReference<>(t, cVar);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    public static a e(@PropagatesNullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return new a(closeable, nla);
    }

    public static <T> a<T> a(@PropagatesNullable T t, c<T> cVar) {
        if (t == null) {
            return null;
        }
        return new a<>(t, cVar);
    }

    public synchronized T get() {
        g.checkState(!this.PQ);
        return this.nkZ.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: dOI */
    public synchronized a<T> clone() {
        g.checkState(isValid());
        return new a<>(this.nkZ);
    }

    @Nullable
    public synchronized a<T> dOJ() {
        return isValid() ? clone() : null;
    }

    public synchronized boolean isValid() {
        return !this.PQ;
    }

    public int dOK() {
        if (isValid()) {
            return System.identityHashCode(this.nkZ.get());
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.PQ) {
                this.PQ = true;
                this.nkZ.dOM();
            }
        }
    }

    public static boolean a(@Nullable a<?> aVar) {
        return aVar != null && aVar.isValid();
    }

    @Nullable
    public static <T> a<T> b(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.dOJ();
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
                if (!this.PQ) {
                    com.facebook.common.c.a.c(nju, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.nkZ)), this.nkZ.get().getClass().getName());
                    close();
                }
            }
        } finally {
            super.finalize();
        }
    }
}

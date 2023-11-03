package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.PropagatesNullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public abstract class CloseableReference<T> implements Cloneable, Closeable {
    public static final int REF_TYPE_DEFAULT = 0;
    public static final int REF_TYPE_FINALIZER = 1;
    public static final int REF_TYPE_NOOP = 3;
    public static final int REF_TYPE_REF_COUNT = 2;
    @GuardedBy("this")
    public boolean mIsClosed = false;
    public final LeakHandler mLeakHandler;
    public final SharedReference<T> mSharedReference;
    @Nullable
    public final Throwable mStacktrace;
    public static Class<CloseableReference> TAG = CloseableReference.class;
    @CloseableRefType
    public static int sBitmapCloseableRefType = 0;
    public static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser<Closeable>() { // from class: com.facebook.common.references.CloseableReference.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Closeable closeable) {
            try {
                Closeables.close(closeable, true);
            } catch (IOException unused) {
            }
        }
    };
    public static final LeakHandler DEFAULT_LEAK_HANDLER = new LeakHandler() { // from class: com.facebook.common.references.CloseableReference.2
        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public boolean requiresStacktrace() {
            return false;
        }

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public void reportLeak(SharedReference<Object> sharedReference, @Nullable Throwable th) {
            FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.get().getClass().getName());
        }
    };

    /* loaded from: classes9.dex */
    public @interface CloseableRefType {
    }

    /* loaded from: classes9.dex */
    public interface LeakHandler {
        void reportLeak(SharedReference<Object> sharedReference, @Nullable Throwable th);

        boolean requiresStacktrace();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    /* renamed from: clone */
    public abstract CloseableReference<T> mo172clone();

    public static boolean useGc() {
        if (sBitmapCloseableRefType == 3) {
            return true;
        }
        return false;
    }

    @Nullable
    public synchronized CloseableReference<T> cloneOrNull() {
        if (isValid()) {
            return mo172clone();
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mIsClosed) {
                return;
            }
            this.mIsClosed = true;
            this.mSharedReference.deleteReference();
        }
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                this.mLeakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public synchronized T get() {
        boolean z;
        if (!this.mIsClosed) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.mSharedReference.get();
    }

    @VisibleForTesting
    public synchronized SharedReference<T> getUnderlyingReferenceTestOnly() {
        return this.mSharedReference;
    }

    public int getValueHash() {
        if (isValid()) {
            return System.identityHashCode(this.mSharedReference.get());
        }
        return 0;
    }

    public synchronized boolean isValid() {
        return !this.mIsClosed;
    }

    public CloseableReference(SharedReference<T> sharedReference, LeakHandler leakHandler, @Nullable Throwable th) {
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler) {
        Throwable th = null;
        if (t == null) {
            return null;
        }
        if (leakHandler.requiresStacktrace()) {
            th = new Throwable();
        }
        return of(t, resourceReleaser, leakHandler, th);
    }

    public CloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, @Nullable Throwable th) {
        this.mSharedReference = new SharedReference<>(t, resourceReleaser);
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler, @Nullable Throwable th) {
        if (t == null) {
            return null;
        }
        if ((t instanceof Bitmap) || (t instanceof HasBitmap)) {
            int i = sBitmapCloseableRefType;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return new NoOpCloseableReference(t, resourceReleaser, leakHandler, th);
                    }
                } else {
                    return new RefCountCloseableReference(t, resourceReleaser, leakHandler, th);
                }
            } else {
                return new FinalizerCloseableReference(t, resourceReleaser, leakHandler, th);
            }
        }
        return new DefaultCloseableReference(t, resourceReleaser, leakHandler, th);
    }

    @Nullable
    public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.cloneOrNull();
        }
        return null;
    }

    public static void closeSafely(@Nullable CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static boolean isValid(@Nullable CloseableReference<?> closeableReference) {
        if (closeableReference != null && closeableReference.isValid()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference of(@PropagatesNullable Closeable closeable) {
        return of(closeable, DEFAULT_CLOSEABLE_RELEASER);
    }

    public static void setDisableCloseableReferencesForBitmaps(@CloseableRefType int i) {
        sBitmapCloseableRefType = i;
    }

    public static <T> List<CloseableReference<T>> cloneOrNull(@PropagatesNullable Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (CloseableReference<T> closeableReference : collection) {
            arrayList.add(cloneOrNull(closeableReference));
        }
        return arrayList;
    }

    public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference<?> closeableReference : iterable) {
                closeSafely(closeableReference);
            }
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;Lcom/facebook/common/references/CloseableReference$LeakHandler;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference of(@PropagatesNullable Closeable closeable, LeakHandler leakHandler) {
        Throwable th = null;
        if (closeable == null) {
            return null;
        }
        ResourceReleaser<Closeable> resourceReleaser = DEFAULT_CLOSEABLE_RELEASER;
        if (leakHandler.requiresStacktrace()) {
            th = new Throwable();
        }
        return of(closeable, resourceReleaser, leakHandler, th);
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser) {
        return of(t, resourceReleaser, DEFAULT_LEAK_HANDLER);
    }
}

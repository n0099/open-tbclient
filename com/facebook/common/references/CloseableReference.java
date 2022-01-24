package com.facebook.common.references;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public final class CloseableReference<T> implements Cloneable, Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER;
    public static final LeakHandler DEFAULT_LEAK_HANDLER;
    public static Class<CloseableReference> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public boolean mIsClosed;
    public final LeakHandler mLeakHandler;
    public final SharedReference<T> mSharedReference;

    /* loaded from: classes3.dex */
    public interface LeakHandler {
        void reportLeak(SharedReference<Object> sharedReference);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1944323888, "Lcom/facebook/common/references/CloseableReference;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1944323888, "Lcom/facebook/common/references/CloseableReference;");
                return;
            }
        }
        TAG = CloseableReference.class;
        DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser<Closeable>() { // from class: com.facebook.common.references.CloseableReference.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Closeable closeable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, closeable) == null) {
                    try {
                        Closeables.close(closeable, true);
                    } catch (IOException unused) {
                    }
                }
            }
        };
        DEFAULT_LEAK_HANDLER = new LeakHandler() { // from class: com.facebook.common.references.CloseableReference.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public void reportLeak(SharedReference<Object> sharedReference) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, sharedReference) == null) {
                    FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.get().getClass().getName());
                }
            }
        };
    }

    public CloseableReference(SharedReference<T> sharedReference, LeakHandler leakHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sharedReference, leakHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsClosed = false;
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
        this.mLeakHandler = leakHandler;
    }

    public static void closeSafely(@Nullable CloseableReference<?> closeableReference) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, closeableReference) == null) || closeableReference == null) {
            return;
        }
        closeableReference.close();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference of(@PropagatesNullable Closeable closeable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, closeable)) == null) ? of(closeable, DEFAULT_CLOSEABLE_RELEASER) : (CloseableReference) invokeL.objValue;
    }

    @Nullable
    public synchronized CloseableReference<T> cloneOrNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (isValid()) {
                    return m112clone();
                }
                return null;
            }
        }
        return (CloseableReference) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                this.mIsClosed = true;
                this.mSharedReference.deleteReference();
            }
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                synchronized (this) {
                    if (this.mIsClosed) {
                        return;
                    }
                    this.mLeakHandler.reportLeak(this.mSharedReference);
                    close();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public synchronized T get() {
        InterceptResult invokeV;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                Preconditions.checkState(!this.mIsClosed);
                t = this.mSharedReference.get();
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    @VisibleForTesting
    public synchronized SharedReference<T> getUnderlyingReferenceTestOnly() {
        InterceptResult invokeV;
        SharedReference<T> sharedReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                sharedReference = this.mSharedReference;
            }
            return sharedReference;
        }
        return (SharedReference) invokeV.objValue;
    }

    public int getValueHash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (isValid()) {
                return System.identityHashCode(this.mSharedReference.get());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public synchronized boolean isValid() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                z = !this.mIsClosed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> iterable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, iterable) == null) || iterable == null) {
            return;
        }
        for (CloseableReference<?> closeableReference : iterable) {
            closeSafely(closeableReference);
        }
    }

    public static boolean isValid(@Nullable CloseableReference<?> closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, closeableReference)) == null) ? closeableReference != null && closeableReference.isValid() : invokeL.booleanValue;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;Lcom/facebook/common/references/CloseableReference$LeakHandler;)Lcom/facebook/common/references/CloseableReference<TT;>; */
    public static CloseableReference of(@PropagatesNullable Closeable closeable, LeakHandler leakHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, closeable, leakHandler)) == null) {
            if (closeable == null) {
                return null;
            }
            return new CloseableReference(closeable, DEFAULT_CLOSEABLE_RELEASER, leakHandler);
        }
        return (CloseableReference) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public synchronized CloseableReference<T> m112clone() {
        InterceptResult invokeV;
        CloseableReference<T> closeableReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                Preconditions.checkState(isValid());
                closeableReference = new CloseableReference<>(this.mSharedReference, this.mLeakHandler);
            }
            return closeableReference;
        }
        return (CloseableReference) invokeV.objValue;
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, t, resourceReleaser)) == null) ? of(t, resourceReleaser, DEFAULT_LEAK_HANDLER) : (CloseableReference) invokeLL.objValue;
    }

    @Nullable
    public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, closeableReference)) == null) {
            if (closeableReference != null) {
                return closeableReference.cloneOrNull();
            }
            return null;
        }
        return (CloseableReference) invokeL.objValue;
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, t, resourceReleaser, leakHandler)) == null) {
            if (t == null) {
                return null;
            }
            return new CloseableReference<>(t, resourceReleaser, leakHandler);
        }
        return (CloseableReference) invokeLLL.objValue;
    }

    public static <T> List<CloseableReference<T>> cloneOrNull(@PropagatesNullable Collection<CloseableReference<T>> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, collection)) == null) {
            if (collection == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            for (CloseableReference<T> closeableReference : collection) {
                arrayList.add(cloneOrNull(closeableReference));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public CloseableReference(T t, ResourceReleaser<T> resourceReleaser, LeakHandler leakHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, resourceReleaser, leakHandler};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsClosed = false;
        this.mSharedReference = new SharedReference<>(t, resourceReleaser);
        this.mLeakHandler = leakHandler;
    }
}

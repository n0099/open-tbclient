package com.facebook.common.references;

import android.graphics.Bitmap;
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
import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class CloseableReference implements Cloneable, Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ResourceReleaser DEFAULT_CLOSEABLE_RELEASER;
    public static final LeakHandler DEFAULT_LEAK_HANDLER;
    public static final int REF_TYPE_DEFAULT = 0;
    public static final int REF_TYPE_FINALIZER = 1;
    public static final int REF_TYPE_NOOP = 3;
    public static final int REF_TYPE_REF_COUNT = 2;
    public static Class TAG;
    public static int sBitmapCloseableRefType;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsClosed;
    public final LeakHandler mLeakHandler;
    public final SharedReference mSharedReference;
    @Nullable
    public final Throwable mStacktrace;

    /* loaded from: classes7.dex */
    public @interface CloseableRefType {
    }

    /* loaded from: classes7.dex */
    public interface LeakHandler {
        void reportLeak(SharedReference sharedReference, @Nullable Throwable th);

        boolean requiresStacktrace();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public abstract CloseableReference m76clone();

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
        sBitmapCloseableRefType = 0;
        DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser() { // from class: com.facebook.common.references.CloseableReference.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public boolean requiresStacktrace() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public void reportLeak(SharedReference sharedReference, @Nullable Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, sharedReference, th) == null) {
                    FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), sharedReference.get().getClass().getName());
                }
            }
        };
    }

    public CloseableReference(SharedReference sharedReference, LeakHandler leakHandler, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sharedReference, leakHandler, th};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsClosed = false;
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    public CloseableReference(Object obj, ResourceReleaser resourceReleaser, LeakHandler leakHandler, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, resourceReleaser, leakHandler, th};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsClosed = false;
        this.mSharedReference = new SharedReference(obj, resourceReleaser);
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    public static boolean useGc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (sBitmapCloseableRefType == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public synchronized CloseableReference cloneOrNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (isValid()) {
                    return m76clone();
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
                    this.mLeakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                    close();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public synchronized Object get() {
        InterceptResult invokeV;
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (!this.mIsClosed) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                obj = this.mSharedReference.get();
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public synchronized SharedReference getUnderlyingReferenceTestOnly() {
        InterceptResult invokeV;
        SharedReference sharedReference;
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

    @Nullable
    public static CloseableReference cloneOrNull(@Nullable CloseableReference closeableReference) {
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

    public static void closeSafely(@Nullable CloseableReference closeableReference) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, closeableReference) == null) && closeableReference != null) {
            closeableReference.close();
        }
    }

    public static boolean isValid(@Nullable CloseableReference closeableReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, closeableReference)) == null) {
            if (closeableReference != null && closeableReference.isValid()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static CloseableReference of(Closeable closeable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, closeable)) == null) {
            return of(closeable, DEFAULT_CLOSEABLE_RELEASER);
        }
        return (CloseableReference) invokeL.objValue;
    }

    public static void setDisableCloseableReferencesForBitmaps(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            sBitmapCloseableRefType = i;
        }
    }

    public static List cloneOrNull(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, collection)) == null) {
            if (collection == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(cloneOrNull((CloseableReference) it.next()));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void closeSafely(@Nullable Iterable iterable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, iterable) == null) && iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                closeSafely((CloseableReference) it.next());
            }
        }
    }

    public static CloseableReference of(Closeable closeable, LeakHandler leakHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, closeable, leakHandler)) == null) {
            Throwable th = null;
            if (closeable == null) {
                return null;
            }
            ResourceReleaser resourceReleaser = DEFAULT_CLOSEABLE_RELEASER;
            if (leakHandler.requiresStacktrace()) {
                th = new Throwable();
            }
            return of(closeable, resourceReleaser, leakHandler, th);
        }
        return (CloseableReference) invokeLL.objValue;
    }

    public static CloseableReference of(Object obj, ResourceReleaser resourceReleaser) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, obj, resourceReleaser)) == null) {
            return of(obj, resourceReleaser, DEFAULT_LEAK_HANDLER);
        }
        return (CloseableReference) invokeLL.objValue;
    }

    public static CloseableReference of(Object obj, ResourceReleaser resourceReleaser, LeakHandler leakHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, obj, resourceReleaser, leakHandler)) == null) {
            Throwable th = null;
            if (obj == null) {
                return null;
            }
            if (leakHandler.requiresStacktrace()) {
                th = new Throwable();
            }
            return of(obj, resourceReleaser, leakHandler, th);
        }
        return (CloseableReference) invokeLLL.objValue;
    }

    public static CloseableReference of(Object obj, ResourceReleaser resourceReleaser, LeakHandler leakHandler, @Nullable Throwable th) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, obj, resourceReleaser, leakHandler, th)) == null) {
            if (obj == null) {
                return null;
            }
            if ((obj instanceof Bitmap) || (obj instanceof HasBitmap)) {
                int i = sBitmapCloseableRefType;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return new NoOpCloseableReference(obj, resourceReleaser, leakHandler, th);
                        }
                    } else {
                        return new RefCountCloseableReference(obj, resourceReleaser, leakHandler, th);
                    }
                } else {
                    return new FinalizerCloseableReference(obj, resourceReleaser, leakHandler, th);
                }
            }
            return new DefaultCloseableReference(obj, resourceReleaser, leakHandler, th);
        }
        return (CloseableReference) invokeLLLL.objValue;
    }
}

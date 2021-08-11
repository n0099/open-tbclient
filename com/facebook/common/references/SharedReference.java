package com.facebook.common.references;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
@VisibleForTesting
/* loaded from: classes9.dex */
public class SharedReference<T> {
    public static /* synthetic */ Interceptable $ic;
    @GuardedBy("itself")
    public static final Map<Object, Integer> sLiveObjects;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public int mRefCount;
    public final ResourceReleaser<T> mResourceReleaser;
    @GuardedBy("this")
    public T mValue;

    /* loaded from: classes9.dex */
    public static class NullReferenceException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NullReferenceException() {
            super("Null shared reference");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(568629703, "Lcom/facebook/common/references/SharedReference;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(568629703, "Lcom/facebook/common/references/SharedReference;");
                return;
            }
        }
        sLiveObjects = new IdentityHashMap();
    }

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, resourceReleaser};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mValue = (T) Preconditions.checkNotNull(t);
        this.mResourceReleaser = (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser);
        this.mRefCount = 1;
        addLiveReference(t);
    }

    public static void addLiveReference(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, obj) == null) {
            synchronized (sLiveObjects) {
                Integer num = sLiveObjects.get(obj);
                if (num == null) {
                    sLiveObjects.put(obj, 1);
                } else {
                    sLiveObjects.put(obj, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    private synchronized int decreaseRefCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                ensureValid();
                Preconditions.checkArgument(this.mRefCount > 0);
                i2 = this.mRefCount - 1;
                this.mRefCount = i2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    private void ensureValid() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && !isValid(this)) {
            throw new NullReferenceException();
        }
    }

    public static void removeLiveReference(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj) == null) {
            synchronized (sLiveObjects) {
                Integer num = sLiveObjects.get(obj);
                if (num == null) {
                    FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
                } else if (num.intValue() == 1) {
                    sLiveObjects.remove(obj);
                } else {
                    sLiveObjects.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            }
        }
    }

    public synchronized void addReference() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                ensureValid();
                this.mRefCount++;
            }
        }
    }

    public synchronized boolean addReferenceIfValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (isValid()) {
                    addReference();
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void deleteReference() {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && decreaseRefCount() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            this.mResourceReleaser.release(t);
            removeLiveReference(t);
        }
    }

    public synchronized T get() {
        InterceptResult invokeV;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                t = this.mValue;
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    public synchronized int getRefCountTestOnly() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                i2 = this.mRefCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized boolean isValid() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                z = this.mRefCount > 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isValid(SharedReference<?> sharedReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, sharedReference)) == null) ? sharedReference != null && sharedReference.isValid() : invokeL.booleanValue;
    }
}

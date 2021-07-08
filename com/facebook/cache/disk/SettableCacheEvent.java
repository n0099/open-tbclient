package com.facebook.cache.disk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class SettableCacheEvent implements CacheEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_RECYCLED = 5;
    public static final Object RECYCLER_LOCK;
    public static SettableCacheEvent sFirstRecycledEvent;
    public static int sRecycledCount;
    public transient /* synthetic */ FieldHolder $fh;
    public CacheKey mCacheKey;
    public long mCacheLimit;
    public long mCacheSize;
    public CacheEventListener.EvictionReason mEvictionReason;
    public IOException mException;
    public long mItemSize;
    public SettableCacheEvent mNextRecycledEvent;
    public String mResourceId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1023963937, "Lcom/facebook/cache/disk/SettableCacheEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1023963937, "Lcom/facebook/cache/disk/SettableCacheEvent;");
                return;
            }
        }
        RECYCLER_LOCK = new Object();
    }

    public SettableCacheEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @ReturnsOwnership
    public static SettableCacheEvent obtain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (RECYCLER_LOCK) {
                if (sFirstRecycledEvent != null) {
                    SettableCacheEvent settableCacheEvent = sFirstRecycledEvent;
                    sFirstRecycledEvent = settableCacheEvent.mNextRecycledEvent;
                    settableCacheEvent.mNextRecycledEvent = null;
                    sRecycledCount--;
                    return settableCacheEvent;
                }
                return new SettableCacheEvent();
            }
        }
        return (SettableCacheEvent) invokeV.objValue;
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mCacheKey = null;
            this.mResourceId = null;
            this.mItemSize = 0L;
            this.mCacheLimit = 0L;
            this.mCacheSize = 0L;
            this.mException = null;
            this.mEvictionReason = null;
        }
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public CacheKey getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCacheKey : (CacheKey) invokeV.objValue;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getCacheLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCacheLimit : invokeV.longValue;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCacheSize : invokeV.longValue;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public CacheEventListener.EvictionReason getEvictionReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEvictionReason : (CacheEventListener.EvictionReason) invokeV.objValue;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public IOException getException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mException : (IOException) invokeV.objValue;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getItemSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mItemSize : invokeV.longValue;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @Nullable
    public String getResourceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mResourceId : (String) invokeV.objValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (RECYCLER_LOCK) {
                if (sRecycledCount < 5) {
                    reset();
                    sRecycledCount++;
                    if (sFirstRecycledEvent != null) {
                        this.mNextRecycledEvent = sFirstRecycledEvent;
                    }
                    sFirstRecycledEvent = this;
                }
            }
        }
    }

    public SettableCacheEvent setCacheKey(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cacheKey)) == null) {
            this.mCacheKey = cacheKey;
            return this;
        }
        return (SettableCacheEvent) invokeL.objValue;
    }

    public SettableCacheEvent setCacheLimit(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            this.mCacheLimit = j;
            return this;
        }
        return (SettableCacheEvent) invokeJ.objValue;
    }

    public SettableCacheEvent setCacheSize(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            this.mCacheSize = j;
            return this;
        }
        return (SettableCacheEvent) invokeJ.objValue;
    }

    public SettableCacheEvent setEvictionReason(CacheEventListener.EvictionReason evictionReason) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, evictionReason)) == null) {
            this.mEvictionReason = evictionReason;
            return this;
        }
        return (SettableCacheEvent) invokeL.objValue;
    }

    public SettableCacheEvent setException(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iOException)) == null) {
            this.mException = iOException;
            return this;
        }
        return (SettableCacheEvent) invokeL.objValue;
    }

    public SettableCacheEvent setItemSize(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            this.mItemSize = j;
            return this;
        }
        return (SettableCacheEvent) invokeJ.objValue;
    }

    public SettableCacheEvent setResourceId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.mResourceId = str;
            return this;
        }
        return (SettableCacheEvent) invokeL.objValue;
    }
}

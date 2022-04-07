package com.facebook.imagepipeline.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class StagingArea {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public Map<CacheKey, EncodedImage> mMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-444826623, "Lcom/facebook/imagepipeline/cache/StagingArea;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-444826623, "Lcom/facebook/imagepipeline/cache/StagingArea;");
                return;
            }
        }
        TAG = StagingArea.class;
    }

    public StagingArea() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMap = new HashMap();
    }

    public static StagingArea getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new StagingArea() : (StagingArea) invokeV.objValue;
    }

    private synchronized void logStats() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            synchronized (this) {
                FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
            }
        }
    }

    public void clearAll() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.mMap.values());
                this.mMap.clear();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                EncodedImage encodedImage = (EncodedImage) arrayList.get(i);
                if (encodedImage != null) {
                    encodedImage.close();
                }
            }
        }
    }

    public synchronized boolean containsKey(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheKey)) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(cacheKey);
                if (this.mMap.containsKey(cacheKey)) {
                    EncodedImage encodedImage = this.mMap.get(cacheKey);
                    synchronized (encodedImage) {
                        if (EncodedImage.isValid(encodedImage)) {
                            return true;
                        }
                        this.mMap.remove(cacheKey);
                        FLog.w(TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public synchronized EncodedImage get(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cacheKey)) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(cacheKey);
                EncodedImage encodedImage = this.mMap.get(cacheKey);
                if (encodedImage != null) {
                    synchronized (encodedImage) {
                        if (!EncodedImage.isValid(encodedImage)) {
                            this.mMap.remove(cacheKey);
                            FLog.w(TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                            return null;
                        }
                        encodedImage = EncodedImage.cloneOrNull(encodedImage);
                    }
                }
                return encodedImage;
            }
        }
        return (EncodedImage) invokeL.objValue;
    }

    public synchronized void put(CacheKey cacheKey, EncodedImage encodedImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cacheKey, encodedImage) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(cacheKey);
                Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
                EncodedImage.closeSafely(this.mMap.put(cacheKey, EncodedImage.cloneOrNull(encodedImage)));
                logStats();
            }
        }
    }

    public boolean remove(CacheKey cacheKey) {
        InterceptResult invokeL;
        EncodedImage remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cacheKey)) == null) {
            Preconditions.checkNotNull(cacheKey);
            synchronized (this) {
                remove = this.mMap.remove(cacheKey);
            }
            if (remove == null) {
                return false;
            }
            try {
                return remove.isValid();
            } finally {
                remove.close();
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean remove(CacheKey cacheKey, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cacheKey, encodedImage)) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(cacheKey);
                Preconditions.checkNotNull(encodedImage);
                Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
                EncodedImage encodedImage2 = this.mMap.get(cacheKey);
                if (encodedImage2 == null) {
                    return false;
                }
                CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage2.getByteBufferRef();
                CloseableReference<PooledByteBuffer> byteBufferRef2 = encodedImage.getByteBufferRef();
                if (byteBufferRef != null && byteBufferRef2 != null && byteBufferRef.get() == byteBufferRef2.get()) {
                    this.mMap.remove(cacheKey);
                    CloseableReference.closeSafely(byteBufferRef2);
                    CloseableReference.closeSafely(byteBufferRef);
                    EncodedImage.closeSafely(encodedImage2);
                    logStats();
                    return true;
                }
                CloseableReference.closeSafely(byteBufferRef2);
                CloseableReference.closeSafely(byteBufferRef);
                EncodedImage.closeSafely(encodedImage2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}

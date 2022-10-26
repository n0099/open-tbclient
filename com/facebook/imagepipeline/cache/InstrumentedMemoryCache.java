package com.facebook.imagepipeline.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
/* loaded from: classes7.dex */
public class InstrumentedMemoryCache implements MemoryCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MemoryCache mDelegate;
    public final MemoryCacheTracker mTracker;

    public InstrumentedMemoryCache(MemoryCache memoryCache, MemoryCacheTracker memoryCacheTracker) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryCache, memoryCacheTracker};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDelegate = memoryCache;
        this.mTracker = memoryCacheTracker;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference cache(Object obj, CloseableReference closeableReference) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, closeableReference)) == null) {
            this.mTracker.onCachePut(obj);
            return this.mDelegate.cache(obj, closeableReference);
        }
        return (CloseableReference) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, predicate)) == null) {
            return this.mDelegate.contains(predicate);
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            CloseableReference closeableReference = this.mDelegate.get(obj);
            if (closeableReference == null) {
                this.mTracker.onCacheMiss(obj);
            } else {
                this.mTracker.onCacheHit(obj);
            }
            return closeableReference;
        }
        return (CloseableReference) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            this.mDelegate.probe(obj);
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, predicate)) == null) {
            return this.mDelegate.removeAll(predicate);
        }
        return invokeL.intValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            return this.mDelegate.contains(obj);
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDelegate.getCount();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mDelegate.getSizeInBytes();
        }
        return invokeV.intValue;
    }
}

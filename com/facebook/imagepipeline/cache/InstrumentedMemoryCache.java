package com.facebook.imagepipeline.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
/* loaded from: classes4.dex */
public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MemoryCache<K, V> mDelegate;
    public final MemoryCacheTracker mTracker;

    public InstrumentedMemoryCache(MemoryCache<K, V> memoryCache, MemoryCacheTracker memoryCacheTracker) {
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
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k, closeableReference)) == null) {
            this.mTracker.onCachePut(k);
            return this.mDelegate.cache(k, closeableReference);
        }
        return (CloseableReference) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(Predicate<K> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, predicate)) == null) ? this.mDelegate.contains((Predicate) predicate) : invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k)) == null) {
            CloseableReference<V> closeableReference = this.mDelegate.get(k);
            if (closeableReference == null) {
                this.mTracker.onCacheMiss(k);
            } else {
                this.mTracker.onCacheHit(k);
            }
            return closeableReference;
        }
        return (CloseableReference) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDelegate.getCount() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getSizeInBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDelegate.getSizeInBytes() : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, k) == null) {
            this.mDelegate.probe(k);
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, predicate)) == null) ? this.mDelegate.removeAll(predicate) : invokeL.intValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k)) == null) ? this.mDelegate.contains((MemoryCache<K, V>) k) : invokeL.booleanValue;
    }
}

package com.facebook.imagepipeline.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class DiskStorageCacheFactory implements FileCacheFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DiskStorageFactory mDiskStorageFactory;

    public DiskStorageCacheFactory(DiskStorageFactory diskStorageFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {diskStorageFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDiskStorageFactory = diskStorageFactory;
    }

    public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig diskCacheConfig, DiskStorage diskStorage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, diskCacheConfig, diskStorage)) == null) ? buildDiskStorageCache(diskCacheConfig, diskStorage, Executors.newSingleThreadExecutor()) : (DiskStorageCache) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.core.FileCacheFactory
    public FileCache get(DiskCacheConfig diskCacheConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, diskCacheConfig)) == null) ? buildDiskStorageCache(diskCacheConfig, this.mDiskStorageFactory.get(diskCacheConfig)) : (FileCache) invokeL.objValue;
    }

    public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig diskCacheConfig, DiskStorage diskStorage, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, diskCacheConfig, diskStorage, executor)) == null) ? new DiskStorageCache(diskStorage, diskCacheConfig.getEntryEvictionComparatorSupplier(), new DiskStorageCache.Params(diskCacheConfig.getMinimumSizeLimit(), diskCacheConfig.getLowDiskSpaceSizeLimit(), diskCacheConfig.getDefaultSizeLimit()), diskCacheConfig.getCacheEventListener(), diskCacheConfig.getCacheErrorLogger(), diskCacheConfig.getDiskTrimmableRegistry(), diskCacheConfig.getContext(), executor, diskCacheConfig.getIndexPopulateAtStartupEnabled()) : (DiskStorageCache) invokeLLL.objValue;
    }
}

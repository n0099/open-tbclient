package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.download.center.clearcache.BaseClearCache;
import com.baidu.searchbox.download.center.clearcache.DiskManager;
import com.baidu.searchbox.download.center.clearcache.DiskUtilKt;
import com.baidu.searchbox.download.center.clearcache.IClearCacheContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
@Singleton
@Service
/* loaded from: classes6.dex */
public class g36 implements IClearCacheContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g36() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public void addClearCache(List<BaseClearCache> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public void cleanCacheMonitorUBC(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            DiskUtilKt.cleanCacheMonitorUBC(str);
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public void clearHistoryFile() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public List<File> getAppFileList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? DiskUtilKt.getAppFileList() : (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public BaseClearCache getDownloadClearCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (BaseClearCache) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public List<File> getUserAssetFileList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? DiskUtilKt.getUserAssetFileList() : (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public void notifyDiskLevelChanged(DiskManager.NotifyLevel notifyLevel, DiskManager.DiskLevel diskLevel, DiskManager.DiskLevel diskLevel2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, notifyLevel, diskLevel, diskLevel2) == null) {
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public void notifyPersonalClearCacheTipsChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public void registerDiskUsageLevelChangedObserver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.download.center.clearcache.IClearCacheContext
    public void startDownloadActivity(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
        }
    }
}

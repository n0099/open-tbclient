package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String globalDefaultSavePath;
    public String globalDefaultSaveTempPath;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static DownloadTask with(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Downloader.getInstance(context);
            return new DownloadTask();
        }
        return (DownloadTask) invokeL.objValue;
    }

    public void addMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69185a, false);
    }

    public void addNotificationListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69187c, false);
    }

    public void addSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69186b, false);
    }

    public boolean canResume(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? d.a().e(i2) : invokeI.booleanValue;
    }

    public void cancel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            cancel(i2, true);
        }
    }

    public void clearDownloadData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            d.a().d(i2, true);
        }
    }

    public void destoryDownloader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a();
        }
    }

    public void forceDownloadIngoreRecommendSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            d.a().n(i2);
        }
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? d.a().e() : (List) invokeV.objValue;
    }

    public long getCurBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? d.a().h(i2) : invokeI.longValue;
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? d.a().r(i2) : (IDownloadFileUriProvider) invokeI.objValue;
    }

    public int getDownloadId(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? d.a().a(str, str2) : invokeLL.intValue;
    }

    public DownloadInfo getDownloadInfo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? d.a().k(i2) : (DownloadInfo) invokeI.objValue;
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? d.a().a(str) : (List) invokeL.objValue;
    }

    public z getDownloadNotificationEventListener(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? d.a().l(i2) : (z) invokeI.objValue;
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? d.a().e(str) : (List) invokeL.objValue;
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? d.a().b(str) : (List) invokeL.objValue;
    }

    public File getGlobalSaveDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getGlobalSaveDir(this.globalDefaultSavePath, true) : (File) invokeV.objValue;
    }

    public File getGlobalSaveTempDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? getGlobalSaveDir(this.globalDefaultSaveTempPath, false) : (File) invokeV.objValue;
    }

    public r getReserveWifiStatusListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? c.Q() : (r) invokeV.objValue;
    }

    public int getStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? d.a().i(i2) : invokeI.intValue;
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? d.a().c(str) : (List) invokeL.objValue;
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? d.a().d(str) : (List) invokeL.objValue;
    }

    public boolean isDownloadCacheSyncSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? d.a().f() : invokeV.booleanValue;
    }

    public boolean isDownloadServiceForeground(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) ? d.a().c(i2).b() : invokeI.booleanValue;
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, downloadInfo)) == null) ? d.a().a(downloadInfo) : invokeL.booleanValue;
    }

    public boolean isDownloading(int i2) {
        InterceptResult invokeI;
        boolean j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (com.ss.android.socialbase.downloader.i.a.a(4194304)) {
                synchronized (this) {
                    j = d.a().j(i2);
                }
                return j;
            }
            return d.a().j(i2);
        }
        return invokeI.booleanValue;
    }

    public boolean isHttpServiceInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? d.a().d() : invokeV.booleanValue;
    }

    public void pause(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            d.a().d(i2);
        }
    }

    public void pauseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            d.a().c();
        }
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, kVar) == null) {
            d.a().a(kVar);
        }
    }

    public void registerDownloaderProcessConnectedListener(ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, acVar) == null) {
            d.a().a(acVar);
        }
    }

    public void removeMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048611, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69185a, false);
    }

    public void removeNotificationListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048612, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69187c, false);
    }

    public void removeSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048613, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69186b, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            d.a().a(i2, null, com.ss.android.socialbase.downloader.constants.f.f69185a, true);
        }
    }

    @Deprecated
    public void removeTaskNotificationListener(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            d.a().a(i2, null, com.ss.android.socialbase.downloader.constants.f.f69187c, true);
        }
    }

    @Deprecated
    public void removeTaskSubListener(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            d.a().a(i2, null, com.ss.android.socialbase.downloader.constants.f.f69186b, true);
        }
    }

    public void restart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            d.a().g(i2);
        }
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, list) == null) {
            d.a().a(list);
        }
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, list) == null) {
            d.a().b(list);
        }
    }

    public void resume(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            d.a().f(i2);
        }
    }

    public void setDefaultSavePath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (com.ss.android.socialbase.downloader.i.a.a(4194304)) {
                synchronized (this) {
                    c.b();
                }
                return;
            }
            c.b();
        }
    }

    public void setDownloadNotificationEventListener(int i2, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i2, zVar) == null) {
            d.a().a(i2, zVar);
        }
    }

    public void setLogLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            d.a().p(i2);
        }
    }

    @Deprecated
    public void setMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048626, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69185a, true);
    }

    @Deprecated
    public void setNotificationListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048628, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69187c, true);
    }

    public void setReserveWifiStatusListener(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, rVar) == null) {
            c.a(rVar);
        }
    }

    @Deprecated
    public void setSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048630, this, i2, iDownloadListener) == null) || iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69186b, true);
    }

    public void setThrottleNetSpeed(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            d.a().a(i2, j);
        }
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, kVar) == null) {
            d.a().b(kVar);
        }
    }

    public void unRegisterDownloaderProcessConnectedListener(ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, acVar) == null) {
            d.a().b(acVar);
        }
    }

    private File getGlobalSaveDir(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(65537, this, str, z)) != null) {
            return (File) invokeLZ.objValue;
        }
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    if (!z) {
                        return null;
                    }
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
        }
    }

    public void cancel(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d.a().c(i2, z);
        }
    }

    public void clearDownloadData(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d.a().d(i2, z);
        }
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) ? d.a().b(str, str2) : (DownloadInfo) invokeLL.objValue;
    }

    @Deprecated
    public void setMainThreadListener(int i2, IDownloadListener iDownloadListener, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), iDownloadListener, Boolean.valueOf(z)}) == null) || iDownloadListener == null) {
            return;
        }
        d.a().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.f69185a, true, z);
    }
}

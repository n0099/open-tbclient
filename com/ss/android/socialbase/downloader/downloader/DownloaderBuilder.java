package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class DownloaderBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g chunkAdjustCalculator;
    public h chunkCntCalculator;
    public ExecutorService chunkDownloadExecutor;
    public final Context context;
    public ExecutorService cpuThreadExecutor;
    public ExecutorService dbThreadExecutor;
    public j downloadCache;
    public List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers;
    public com.ss.android.socialbase.downloader.network.f downloadDns;
    public int downloadExpSwitch;
    public boolean downloadInMultiProcess;
    public l downloadLaunchHandler;
    public com.ss.android.socialbase.downloader.d.b downloadMonitorListener;
    public aa downloadSetting;
    public com.ss.android.socialbase.downloader.network.h headHttpService;
    public IDownloadHttpService httpService;
    public k idGenerator;
    public ExecutorService ioThreadExecutor;
    public int maxDownloadPoolSize;
    public ExecutorService mixApkDownloadExecutor;
    public ExecutorService mixDefaultDownloadExecutor;
    public ExecutorService mixFrequentDownloadExecutor;
    public q monitorConfig;
    public boolean needAutoRefreshUnSuccessTask;
    public af notificationClickCallback;
    public ExecutorService okHttpDispatcherExecutor;
    public u ttNetHandler;
    public int writeBufferSize;

    public DownloaderBuilder(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.downloadCompleteHandlers = new ArrayList();
        this.needAutoRefreshUnSuccessTask = true;
        this.downloadExpSwitch = 1056964607;
        this.context = context;
    }

    public DownloaderBuilder addDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            synchronized (this.downloadCompleteHandlers) {
                if (mVar != null) {
                    if (!this.downloadCompleteHandlers.contains(mVar)) {
                        this.downloadCompleteHandlers.add(mVar);
                        return this;
                    }
                }
                return this;
            }
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public Downloader build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new Downloader(this) : (Downloader) invokeV.objValue;
    }

    public DownloaderBuilder chunkAdjustCalculator(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar)) == null) {
            this.chunkAdjustCalculator = gVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder chunkCntCalculator(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) {
            this.chunkCntCalculator = hVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, executorService)) == null) {
            this.chunkDownloadExecutor = executorService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, executorService)) == null) {
            this.cpuThreadExecutor = executorService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, executorService)) == null) {
            this.dbThreadExecutor = executorService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder downloadCache(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jVar)) == null) {
            this.downloadCache = jVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder downloadDns(com.ss.android.socialbase.downloader.network.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar)) == null) {
            this.downloadDns = fVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder downloadExpSwitch(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.downloadExpSwitch = i2;
            return this;
        }
        return (DownloaderBuilder) invokeI.objValue;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.downloadInMultiProcess = z;
            return this;
        }
        return (DownloaderBuilder) invokeZ.objValue;
    }

    public DownloaderBuilder downloadLaunchHandler(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, lVar)) == null) {
            this.downloadLaunchHandler = lVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder downloadMonitorListener(com.ss.android.socialbase.downloader.d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bVar)) == null) {
            this.downloadMonitorListener = bVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder downloadSetting(aa aaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aaVar)) == null) {
            this.downloadSetting = aaVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public ExecutorService getCPUThreadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.cpuThreadExecutor : (ExecutorService) invokeV.objValue;
    }

    public g getChunkAdjustCalculator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.chunkAdjustCalculator : (g) invokeV.objValue;
    }

    public h getChunkCntCalculator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.chunkCntCalculator : (h) invokeV.objValue;
    }

    public ExecutorService getChunkThreadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.chunkDownloadExecutor : (ExecutorService) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.context : (Context) invokeV.objValue;
    }

    public ExecutorService getDBThreadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.dbThreadExecutor : (ExecutorService) invokeV.objValue;
    }

    public j getDownloadCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.downloadCache : (j) invokeV.objValue;
    }

    public List<com.ss.android.socialbase.downloader.depend.m> getDownloadCompleteHandlers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.downloadCompleteHandlers : (List) invokeV.objValue;
    }

    public com.ss.android.socialbase.downloader.network.f getDownloadDns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.downloadDns : (com.ss.android.socialbase.downloader.network.f) invokeV.objValue;
    }

    public int getDownloadExpSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.downloadExpSwitch : invokeV.intValue;
    }

    public l getDownloadLaunchHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.downloadLaunchHandler : (l) invokeV.objValue;
    }

    public com.ss.android.socialbase.downloader.d.b getDownloadMonitorListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.downloadMonitorListener : (com.ss.android.socialbase.downloader.d.b) invokeV.objValue;
    }

    public aa getDownloadSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.downloadSetting : (aa) invokeV.objValue;
    }

    public com.ss.android.socialbase.downloader.network.h getHeadHttpService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.headHttpService : (com.ss.android.socialbase.downloader.network.h) invokeV.objValue;
    }

    public IDownloadHttpService getHttpService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.httpService : (IDownloadHttpService) invokeV.objValue;
    }

    public ExecutorService getIOThreadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.ioThreadExecutor : (ExecutorService) invokeV.objValue;
    }

    public k getIdGenerator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.idGenerator : (k) invokeV.objValue;
    }

    public int getMaxDownloadPoolSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.maxDownloadPoolSize : invokeV.intValue;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mixApkDownloadExecutor : (ExecutorService) invokeV.objValue;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mixDefaultDownloadExecutor : (ExecutorService) invokeV.objValue;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mixFrequentDownloadExecutor : (ExecutorService) invokeV.objValue;
    }

    public q getMonitorConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.monitorConfig : (q) invokeV.objValue;
    }

    public af getNotificationClickCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.notificationClickCallback : (af) invokeV.objValue;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.okHttpDispatcherExecutor : (ExecutorService) invokeV.objValue;
    }

    public u getTTNetHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.ttNetHandler : (u) invokeV.objValue;
    }

    public int getWriteBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.writeBufferSize : invokeV.intValue;
    }

    public DownloaderBuilder headHttpService(com.ss.android.socialbase.downloader.network.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, hVar)) == null) {
            this.headHttpService = hVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, iDownloadHttpService)) == null) {
            this.httpService = iDownloadHttpService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder idGenerator(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, kVar)) == null) {
            this.idGenerator = kVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, executorService)) == null) {
            this.ioThreadExecutor = executorService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public boolean isDownloadInMultiProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.downloadInMultiProcess : invokeV.booleanValue;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
            this.maxDownloadPoolSize = i2;
            return this;
        }
        return (DownloaderBuilder) invokeI.objValue;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, executorService)) == null) {
            this.mixApkDownloadExecutor = executorService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, executorService)) == null) {
            this.mixDefaultDownloadExecutor = executorService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, executorService)) == null) {
            this.mixFrequentDownloadExecutor = executorService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder monitorConfig(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, qVar)) == null) {
            this.monitorConfig = qVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048626, this, z)) == null) {
            this.needAutoRefreshUnSuccessTask = z;
            return this;
        }
        return (DownloaderBuilder) invokeZ.objValue;
    }

    public DownloaderBuilder notificationClickCallback(af afVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, afVar)) == null) {
            this.notificationClickCallback = afVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, executorService)) == null) {
            this.okHttpDispatcherExecutor = executorService;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder ttNetHandler(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, uVar)) == null) {
            this.ttNetHandler = uVar;
            return this;
        }
        return (DownloaderBuilder) invokeL.objValue;
    }

    public DownloaderBuilder writeBufferSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            this.writeBufferSize = i2;
            return this;
        }
        return (DownloaderBuilder) invokeI.objValue;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.needAutoRefreshUnSuccessTask : invokeV.booleanValue;
    }
}

package com.ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.f;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DownloadTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean autoSetHashCodeForSameTask;
    public g chunkAdjustCalculator;
    public h chunkStrategy;
    public n depend;
    public r diskSpaceHandler;
    public final List<m> downloadCompleteHandlers;
    public DownloadInfo downloadInfo;
    public DownloadInfo.a downloadInfoBuilder;
    public IDownloadFileUriProvider fileUriProvider;
    public w forbiddenHandler;
    public int hashCodeForSameTask;
    public IDownloadInterceptor interceptor;
    public final SparseArray<IDownloadListener> mainThreadListeners;
    public x monitorDepend;
    public boolean needDelayForCacheSync;
    public af notificationClickCallback;
    public z notificationEventListener;
    public final SparseArray<IDownloadListener> notificationListeners;
    public s retryDelayTimeCalculator;
    public final SparseArray<f> singleListenerHashCodeMap;
    public final Map<f, IDownloadListener> singleListenerMap;
    public final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.a();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, sparseArray, sparseArray2) == null) || sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, sparseArray, sparseArray2) == null) {
            sparseArray.clear();
            for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
                int keyAt = sparseArray2.keyAt(i2);
                IDownloadListener iDownloadListener = sparseArray2.get(keyAt);
                if (iDownloadListener != null) {
                    sparseArray.put(keyAt, iDownloadListener);
                }
            }
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, this, sparseArray, sparseArray2) == null) || sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.remove(sparseArray2.keyAt(i2));
        }
    }

    private void setChunkCalculator() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || this.downloadInfo.getThrottleNetSpeed() <= 0) {
            return;
        }
        chunkStategy(new h(this) { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadTask a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.h
            public int a(long j2) {
                InterceptResult invokeJ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeJ = interceptable2.invokeJ(1048576, this, j2)) == null) {
                    return 1;
                }
                return invokeJ.intValue;
            }
        });
    }

    public DownloadTask addDownloadCompleteHandler(m mVar) {
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
        return (DownloadTask) invokeL.objValue;
    }

    public void addDownloadListener(int i2, IDownloadListener iDownloadListener, f fVar, boolean z) {
        Map<f, IDownloadListener> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) || iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(fVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i2, fVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i2, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.ss.android.socialbase.downloader.c.a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
            DownloadInfo downloadInfo = this.downloadInfo;
            if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
                this.downloadInfo.setAddListenerToSameTask(true);
            }
            addListenerToDownloadingSameTask(f.a);
            addListenerToDownloadingSameTask(f.f61676b);
            com.ss.android.socialbase.downloader.d.a.a(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
        }
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.downloadInfoBuilder.p(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public void asyncDownload(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            com.ss.android.socialbase.downloader.h.d.a(new Runnable(this, pVar) { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ p a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DownloadTask f61990b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61990b = this;
                    this.a = pVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int download = this.f61990b.download();
                        p pVar2 = this.a;
                        if (pVar2 != null) {
                            pVar2.a(download);
                        }
                    }
                }
            });
        }
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                IDownloadListener singleDownloadListener = getSingleDownloadListener(f.a);
                if (singleDownloadListener == null) {
                    singleDownloadListener = getSingleDownloadListener(f.f61676b);
                }
                if (singleDownloadListener != null) {
                    this.hashCodeForSameTask = singleDownloadListener.hashCode();
                }
                i2 = this.hashCodeForSameTask;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public DownloadTask autoResumed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.downloadInfoBuilder.f(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.autoSetHashCodeForSameTask = z;
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask backUpUrlRetryCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.downloadInfoBuilder.c(i2);
            return this;
        }
        return (DownloadTask) invokeI.objValue;
    }

    public DownloadTask backUpUrls(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, list)) == null) {
            this.downloadInfoBuilder.b(list);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public boolean canShowNotification() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            DownloadInfo downloadInfo = this.downloadInfo;
            if (downloadInfo != null) {
                return downloadInfo.canShowNotification();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public DownloadTask chunkAdjustCalculator(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, gVar)) == null) {
            this.chunkAdjustCalculator = gVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask chunkStategy(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, hVar)) == null) {
            this.chunkStrategy = hVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, downloadTask) == null) {
            this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
            this.chunkStrategy = downloadTask.chunkStrategy;
            this.singleListenerMap.clear();
            this.singleListenerMap.putAll(downloadTask.singleListenerMap);
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.clear();
                addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
            }
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.clear();
                addAll(downloadTask.subThreadListeners, this.subThreadListeners);
            }
            synchronized (this.notificationListeners) {
                this.notificationListeners.clear();
                addAll(downloadTask.notificationListeners, this.notificationListeners);
            }
            this.notificationEventListener = downloadTask.notificationEventListener;
            this.interceptor = downloadTask.interceptor;
            this.depend = downloadTask.depend;
            this.monitorDepend = downloadTask.monitorDepend;
            this.forbiddenHandler = downloadTask.forbiddenHandler;
            this.diskSpaceHandler = downloadTask.diskSpaceHandler;
            this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
            this.notificationClickCallback = downloadTask.notificationClickCallback;
            this.fileUriProvider = downloadTask.fileUriProvider;
            synchronized (this.downloadCompleteHandlers) {
                this.downloadCompleteHandlers.clear();
                this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
            }
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, downloadTask) == null) {
            for (Map.Entry<f, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
                if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                    this.singleListenerMap.put(entry.getKey(), entry.getValue());
                }
            }
            try {
                if (downloadTask.mainThreadListeners.size() != 0) {
                    synchronized (this.mainThreadListeners) {
                        removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                        addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                    }
                }
                if (downloadTask.subThreadListeners.size() != 0) {
                    synchronized (this.subThreadListeners) {
                        removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                        addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                    }
                }
                if (downloadTask.notificationListeners.size() != 0) {
                    synchronized (this.notificationListeners) {
                        removeAll(this.notificationListeners, downloadTask.notificationListeners);
                        addAll(downloadTask.notificationListeners, this.notificationListeners);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.downloadInfoBuilder.t(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask depend(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, nVar)) == null) {
            this.depend = nVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask diskSpaceHandler(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, rVar)) == null) {
            this.diskSpaceHandler = rVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask distinctDirectory(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.downloadInfoBuilder.u(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public int download() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            this.downloadInfo = this.downloadInfoBuilder.a();
            DownloadInfo b2 = com.ss.android.socialbase.downloader.downloader.c.x().b(this.downloadInfo.getId());
            if (b2 == null) {
                this.downloadInfo.generateTaskId();
                com.ss.android.socialbase.downloader.d.a.a(this, (BaseException) null, 0);
            } else {
                this.downloadInfo.copyTaskIdFromCacheData(b2);
            }
            setChunkCalculator();
            com.ss.android.socialbase.downloader.downloader.d.a().a(this);
            DownloadInfo downloadInfo = this.downloadInfo;
            if (downloadInfo == null) {
                return 0;
            }
            return downloadInfo.getId();
        }
        return invokeV.intValue;
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            this.downloadInfoBuilder.a(jSONObject);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, enqueueType)) == null) {
            this.downloadInfoBuilder.a(enqueueType);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask executorGroup(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            this.downloadInfoBuilder.f(i2);
            return this;
        }
        return (DownloadTask) invokeI.objValue;
    }

    public DownloadTask expectFileLength(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j2)) == null) {
            this.downloadInfoBuilder.a(j2);
            return this;
        }
        return (DownloadTask) invokeJ.objValue;
    }

    public DownloadTask expiredRedownload(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            this.downloadInfoBuilder.s(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask extra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.downloadInfoBuilder.f(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask extraHeaders(List<c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, list)) == null) {
            this.downloadInfoBuilder.a(list);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, iArr)) == null) {
            this.downloadInfoBuilder.b(iArr);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, iDownloadFileUriProvider)) == null) {
            this.fileUriProvider = iDownloadFileUriProvider;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask forbiddenHandler(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, wVar)) == null) {
            this.forbiddenHandler = wVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask force(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            this.downloadInfoBuilder.b(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public g getChunkAdjustCalculator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.chunkAdjustCalculator : (g) invokeV.objValue;
    }

    public h getChunkStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.chunkStrategy : (h) invokeV.objValue;
    }

    public n getDepend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.depend : (n) invokeV.objValue;
    }

    public r getDiskSpaceHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.diskSpaceHandler : (r) invokeV.objValue;
    }

    public m getDownloadCompleteHandlerByIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            synchronized (this.downloadCompleteHandlers) {
                if (i2 < this.downloadCompleteHandlers.size()) {
                    return this.downloadCompleteHandlers.get(i2);
                }
                return null;
            }
        }
        return (m) invokeI.objValue;
    }

    @NonNull
    public List<m> getDownloadCompleteHandlers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.downloadCompleteHandlers : (List) invokeV.objValue;
    }

    public int getDownloadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            DownloadInfo downloadInfo = this.downloadInfo;
            if (downloadInfo == null) {
                return 0;
            }
            return downloadInfo.getId();
        }
        return invokeV.intValue;
    }

    public DownloadInfo getDownloadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.downloadInfo : (DownloadInfo) invokeV.objValue;
    }

    public IDownloadListener getDownloadListenerByIndex(f fVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, fVar, i2)) == null) {
            SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
            if (downloadListeners == null || i2 < 0) {
                return null;
            }
            synchronized (downloadListeners) {
                if (i2 < downloadListeners.size()) {
                    return downloadListeners.get(downloadListeners.keyAt(i2));
                }
                return null;
            }
        }
        return (IDownloadListener) invokeLI.objValue;
    }

    public int getDownloadListenerSize(f fVar) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, fVar)) == null) {
            SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
            if (downloadListeners == null) {
                return 0;
            }
            synchronized (downloadListeners) {
                size = downloadListeners.size();
            }
            return size;
        }
        return invokeL.intValue;
    }

    public SparseArray<IDownloadListener> getDownloadListeners(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, fVar)) == null) {
            if (fVar == f.a) {
                return this.mainThreadListeners;
            }
            if (fVar == f.f61676b) {
                return this.subThreadListeners;
            }
            if (fVar == f.f61677c) {
                return this.notificationListeners;
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.fileUriProvider : (IDownloadFileUriProvider) invokeV.objValue;
    }

    public w getForbiddenHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.forbiddenHandler : (w) invokeV.objValue;
    }

    public int getHashCodeForSameTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.hashCodeForSameTask : invokeV.intValue;
    }

    public IDownloadInterceptor getInterceptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.interceptor : (IDownloadInterceptor) invokeV.objValue;
    }

    public x getMonitorDepend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.monitorDepend : (x) invokeV.objValue;
    }

    public af getNotificationClickCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.notificationClickCallback : (af) invokeV.objValue;
    }

    public z getNotificationEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.notificationEventListener : (z) invokeV.objValue;
    }

    public s getRetryDelayTimeCalculator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.retryDelayTimeCalculator : (s) invokeV.objValue;
    }

    public IDownloadListener getSingleDownloadListener(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, fVar)) == null) ? this.singleListenerMap.get(fVar) : (IDownloadListener) invokeL.objValue;
    }

    public DownloadTask hashCodeForSameTask(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
            this.hashCodeForSameTask = i2;
            return this;
        }
        return (DownloadTask) invokeI.objValue;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048628, this, z)) == null) {
            this.downloadInfoBuilder.m(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask iconUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            this.downloadInfoBuilder.l(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) {
            this.downloadInfoBuilder.n(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, iDownloadInterceptor)) == null) {
            this.interceptor = iDownloadInterceptor;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.autoSetHashCodeForSameTask : invokeV.booleanValue;
    }

    public boolean isNeedDelayForCacheSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.needDelayForCacheSync : invokeV.booleanValue;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048634, this, z)) == null) {
            this.downloadInfoBuilder.r(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, iDownloadListener)) == null) ? iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener) : (DownloadTask) invokeL.objValue;
    }

    public DownloadTask mainThreadListenerWithHashCode(int i2, IDownloadListener iDownloadListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048636, this, i2, iDownloadListener)) == null) {
            if (iDownloadListener != null) {
                synchronized (this.mainThreadListeners) {
                    this.mainThreadListeners.put(i2, iDownloadListener);
                }
                this.singleListenerMap.put(f.a, iDownloadListener);
                synchronized (this.singleListenerHashCodeMap) {
                    this.singleListenerHashCodeMap.put(i2, f.a);
                }
            }
            return this;
        }
        return (DownloadTask) invokeIL.objValue;
    }

    public DownloadTask maxBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i2)) == null) {
            this.downloadInfoBuilder.a(i2);
            return this;
        }
        return (DownloadTask) invokeI.objValue;
    }

    public DownloadTask maxProgressCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i2)) == null) {
            this.downloadInfoBuilder.d(i2);
            return this;
        }
        return (DownloadTask) invokeI.objValue;
    }

    public DownloadTask md5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, str)) == null) {
            this.downloadInfoBuilder.i(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask mimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, str)) == null) {
            this.downloadInfoBuilder.g(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask minProgressTimeMsInterval(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i2)) == null) {
            this.downloadInfoBuilder.e(i2);
            return this;
        }
        return (DownloadTask) invokeI.objValue;
    }

    public DownloadTask monitorDepend(x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, xVar)) == null) {
            this.monitorDepend = xVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask monitorScene(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, str)) == null) {
            this.downloadInfoBuilder.k(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask name(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, str)) == null) {
            this.downloadInfoBuilder.a(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048645, this, z)) == null) {
            this.downloadInfoBuilder.o(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048646, this, z)) == null) {
            this.downloadInfoBuilder.h(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048647, this, z)) == null) {
            this.downloadInfoBuilder.d(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048648, this, z)) == null) {
            this.downloadInfoBuilder.l(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask needPostProgress(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z)) == null) {
            this.downloadInfoBuilder.c(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask needRetryDelay(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048650, this, z)) == null) {
            this.downloadInfoBuilder.j(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048651, this, z)) == null) {
            this.downloadInfoBuilder.i(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048652, this, z)) == null) {
            this.downloadInfoBuilder.k(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048653, this, z)) == null) {
            this.downloadInfoBuilder.q(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048654, this, z)) == null) ? this : (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask notificationClickCallback(af afVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, afVar)) == null) {
            this.notificationClickCallback = afVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask notificationEventListener(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, zVar)) == null) {
            this.notificationEventListener = zVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, iDownloadListener)) == null) ? iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener) : (DownloadTask) invokeL.objValue;
    }

    public DownloadTask notificationListenerWithHashCode(int i2, IDownloadListener iDownloadListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048658, this, i2, iDownloadListener)) == null) {
            if (iDownloadListener != null) {
                synchronized (this.notificationListeners) {
                    this.notificationListeners.put(i2, iDownloadListener);
                }
                this.singleListenerMap.put(f.f61677c, iDownloadListener);
                synchronized (this.singleListenerHashCodeMap) {
                    this.singleListenerHashCodeMap.put(i2, f.f61677c);
                }
            }
            return this;
        }
        return (DownloadTask) invokeIL.objValue;
    }

    public DownloadTask onlyWifi(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048659, this, z)) == null) {
            this.downloadInfoBuilder.a(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask outIp(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, strArr)) == null) {
            this.downloadInfoBuilder.a(strArr);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask outSize(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, iArr)) == null) {
            this.downloadInfoBuilder.a(iArr);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask packageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, str)) == null) {
            this.downloadInfoBuilder.h(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public void removeDownloadListener(int i2, IDownloadListener iDownloadListener, f fVar, boolean z) {
        int indexOfValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Integer.valueOf(i2), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) {
            SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
            if (downloadListeners == null) {
                if (z && this.singleListenerMap.containsKey(fVar)) {
                    this.singleListenerMap.remove(fVar);
                    return;
                }
                return;
            }
            synchronized (downloadListeners) {
                if (z) {
                    if (this.singleListenerMap.containsKey(fVar)) {
                        iDownloadListener = this.singleListenerMap.get(fVar);
                        this.singleListenerMap.remove(fVar);
                    }
                    if (iDownloadListener != null && (indexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && indexOfValue < downloadListeners.size()) {
                        downloadListeners.removeAt(indexOfValue);
                    }
                } else {
                    downloadListeners.remove(i2);
                    synchronized (this.singleListenerHashCodeMap) {
                        f fVar2 = this.singleListenerHashCodeMap.get(i2);
                        if (fVar2 != null && this.singleListenerMap.containsKey(fVar2)) {
                            this.singleListenerMap.remove(fVar2);
                            this.singleListenerHashCodeMap.remove(i2);
                        }
                    }
                }
            }
        }
    }

    public DownloadTask retryCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048664, this, i2)) == null) {
            this.downloadInfoBuilder.b(i2);
            return this;
        }
        return (DownloadTask) invokeI.objValue;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, str)) == null) {
            this.downloadInfoBuilder.j(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask retryDelayTimeCalculator(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, sVar)) == null) {
            this.retryDelayTimeCalculator = sVar;
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask savePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, str)) == null) {
            this.downloadInfoBuilder.d(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask setAutoInstall(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048668, this, z)) == null) {
            this.downloadInfoBuilder.v(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask setDownloadCompleteHandlers(List<m> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048669, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                for (m mVar : list) {
                    addDownloadCompleteHandler(mVar);
                }
            }
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048670, this, sparseArray, fVar) == null) || sparseArray == null) {
            return;
        }
        try {
            if (fVar == f.a) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
            } else if (fVar == f.f61676b) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
            } else if (fVar == f.f61677c) {
                synchronized (this.notificationListeners) {
                    copyListeners(this.notificationListeners, sparseArray);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setNeedDelayForCacheSync(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z) == null) {
            this.needDelayForCacheSync = z;
        }
    }

    public void setNotificationEventListener(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, zVar) == null) {
            this.notificationEventListener = zVar;
        }
    }

    public DownloadTask showNotification(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048673, this, z)) == null) {
            this.downloadInfoBuilder.e(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048674, this, z)) == null) {
            this.downloadInfoBuilder.g(z);
            return this;
        }
        return (DownloadTask) invokeZ.objValue;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, iDownloadListener)) == null) ? iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener) : (DownloadTask) invokeL.objValue;
    }

    public DownloadTask subThreadListenerWithHashCode(int i2, IDownloadListener iDownloadListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048676, this, i2, iDownloadListener)) == null) {
            if (iDownloadListener != null) {
                synchronized (this.subThreadListeners) {
                    this.subThreadListeners.put(i2, iDownloadListener);
                }
                this.singleListenerMap.put(f.f61676b, iDownloadListener);
                synchronized (this.singleListenerHashCodeMap) {
                    this.singleListenerHashCodeMap.put(i2, f.f61676b);
                }
            }
            return this;
        }
        return (DownloadTask) invokeIL.objValue;
    }

    public DownloadTask tempPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, str)) == null) {
            this.downloadInfoBuilder.e(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask throttleNetSpeed(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048678, this, j2)) == null) {
            this.downloadInfoBuilder.b(j2);
            return this;
        }
        return (DownloadTask) invokeJ.objValue;
    }

    public DownloadTask title(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, str)) == null) {
            this.downloadInfoBuilder.b(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    public DownloadTask ttnetProtectTimeout(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048680, this, j2)) == null) {
            this.downloadInfoBuilder.c(j2);
            return this;
        }
        return (DownloadTask) invokeJ.objValue;
    }

    public DownloadTask url(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, str)) == null) {
            this.downloadInfoBuilder.c(str);
            return this;
        }
        return (DownloadTask) invokeL.objValue;
    }

    private void addListenerToDownloadingSameTask(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, fVar) == null) {
            SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(fVar);
            synchronized (downloadListeners) {
                for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                    IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                    if (iDownloadListener != null) {
                        com.ss.android.socialbase.downloader.downloader.d.a().b(getDownloadId(), iDownloadListener, fVar, false);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.downloadInfo = downloadInfo;
    }
}

package com.ksad.download;

import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.o;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.r;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class DownloadTask implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7092669850073266500L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean downloadEnablePause;
    public int mAllowedNetworkTypes;
    public transient com.kwai.filedownloader.a mBaseDownloadTask;
    public String mDestinationDir;
    public String mDestinationFileName;
    public transient List<c> mDownloadListeners;
    public boolean mIsCanceled;
    public int mNotificationVisibility;
    public Map<String, String> mRequestHeaders;
    public Serializable mTag;
    public String mUrl;
    public boolean mUserPause;
    public boolean mWakeInstallApk;
    public boolean notificationRemoved;

    /* loaded from: classes5.dex */
    public static class DownloadRequest implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3638290207248829674L;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean downloadEnablePause;
        public int mAllowedNetworkTypes;
        public String mDestinationDir;
        public String mDestinationFileName;
        public String mDownloadUrl;
        public boolean mInstallAfterDownload;
        @Deprecated
        public boolean mIsPhotoAdDownloadRequest;
        public int mNotificationVisibility;
        public final Map<String, String> mRequestHeaders;
        public Serializable mTag;

        public DownloadRequest(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRequestHeaders = new HashMap();
            this.mInstallAfterDownload = true;
            this.mIsPhotoAdDownloadRequest = false;
            this.mAllowedNetworkTypes = 3;
            this.mNotificationVisibility = 0;
            this.downloadEnablePause = false;
            if (!b.M().exists()) {
                b.M().mkdirs();
            }
            this.mDestinationDir = b.M().getPath();
            this.mDownloadUrl = str;
            NetworkInfo cv = ae.cv(b.getContext());
            if (cv == null || cv.getType() != 0) {
                this.mAllowedNetworkTypes = 2;
            } else {
                this.mAllowedNetworkTypes = 3;
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                am.dQ(str);
                if (str.contains(":")) {
                    throw new IllegalArgumentException("header may not contain ':'");
                }
                if (str2 == null) {
                    str2 = "";
                }
                this.mRequestHeaders.put(str, str2);
                return this;
            }
            return (DownloadRequest) invokeLL.objValue;
        }

        public int getAllowedNetworkTypes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAllowedNetworkTypes : invokeV.intValue;
        }

        public String getDestinationDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDestinationDir : (String) invokeV.objValue;
        }

        public String getDestinationFileName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDestinationFileName : (String) invokeV.objValue;
        }

        public String getDownloadUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDownloadUrl : (String) invokeV.objValue;
        }

        public Serializable getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTag : (Serializable) invokeV.objValue;
        }

        public boolean isDownloadEnablePause() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.downloadEnablePause : invokeV.booleanValue;
        }

        public boolean isPhotoAdDownloadRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIsPhotoAdDownloadRequest : invokeV.booleanValue;
        }

        public DownloadRequest setAllowedNetworkTypes(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.mAllowedNetworkTypes = i;
                return this;
            }
            return (DownloadRequest) invokeI.objValue;
        }

        public DownloadRequest setDestinationDir(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.mDestinationDir = str;
                return this;
            }
            return (DownloadRequest) invokeL.objValue;
        }

        public DownloadRequest setDestinationFileName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.mDestinationFileName = str;
                return this;
            }
            return (DownloadRequest) invokeL.objValue;
        }

        public void setDownloadEnablePause(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
                this.downloadEnablePause = z;
            }
        }

        public DownloadRequest setInstallAfterDownload(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.mInstallAfterDownload = z;
                return this;
            }
            return (DownloadRequest) invokeZ.objValue;
        }

        public void setIsPhotoAdDownloadRequest() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.mIsPhotoAdDownloadRequest = true;
            }
        }

        public DownloadRequest setNotificationVisibility(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                this.mNotificationVisibility = i;
                return this;
            }
            return (DownloadRequest) invokeI.objValue;
        }

        public DownloadRequest setTag(Serializable serializable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, serializable)) == null) {
                this.mTag = serializable;
                return this;
            }
            return (DownloadRequest) invokeL.objValue;
        }
    }

    public DownloadTask(DownloadRequest downloadRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadRequest};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDownloadListeners = new ArrayList();
        this.mIsCanceled = false;
        this.downloadEnablePause = false;
        this.notificationRemoved = false;
        initDownloadRequestParams(downloadRequest);
        instantiateDownloadTask();
        initDownloadTaskParams();
    }

    private void initDownloadRequestParams(DownloadRequest downloadRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, downloadRequest) == null) {
            this.mWakeInstallApk = downloadRequest.mInstallAfterDownload;
            this.mUrl = downloadRequest.mDownloadUrl;
            this.mAllowedNetworkTypes = downloadRequest.mAllowedNetworkTypes;
            this.mNotificationVisibility = downloadRequest.mNotificationVisibility;
            this.mDestinationDir = downloadRequest.mDestinationDir;
            this.mDestinationFileName = downloadRequest.mDestinationFileName;
            this.mRequestHeaders = downloadRequest.mRequestHeaders;
            this.mTag = downloadRequest.mTag;
            this.downloadEnablePause = downloadRequest.isDownloadEnablePause();
        }
    }

    private void initDownloadTaskParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mBaseDownloadTask.g(this.mTag);
            this.mBaseDownloadTask.bA((this.mAllowedNetworkTypes ^ 2) == 0);
            for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
                this.mBaseDownloadTask.eo(entry.getKey());
                this.mBaseDownloadTask.Y(entry.getKey(), entry.getValue());
            }
        }
    }

    private void notifyDownloadCompleted(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, aVar) == null) || (this.mNotificationVisibility & 2) == 0) {
            return;
        }
        e.S().j(this);
    }

    private void notifyDownloadError(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, aVar) == null) || (this.mNotificationVisibility & 1) == 0) {
            return;
        }
        e.S().i(this);
    }

    private void notifyDownloadPending(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, aVar) == null) || (this.mNotificationVisibility & 2) == 0) {
            return;
        }
        e.S().h(this);
    }

    private void notifyDownloadProgress(com.kwai.filedownloader.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, this, aVar, z) == null) {
            if ((aVar.getSmallFileTotalBytes() == 0 && aVar.getSmallFileSoFarBytes() == 0) || TextUtils.isEmpty(aVar.getFilename()) || (this.mNotificationVisibility & 1) == 0) {
                return;
            }
            e.S().a(this, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlockCompleted(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, aVar) == null) {
            try {
                Iterator<c> it = this.mDownloadListeners.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onCanceled(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, aVar) == null) {
            try {
                this.mIsCanceled = true;
                for (c cVar : this.mDownloadListeners) {
                    cVar.d(this);
                }
                aVar.cancel();
                e.S().v(getId());
                r.CZ().k(getId(), this.mBaseDownloadTask.getTargetFilePath());
                releaseDownloadTask();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, aVar) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.a(this);
                }
                notifyDownloadCompleted(aVar);
                if (this.mWakeInstallApk) {
                    installApk();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnected(com.kwai.filedownloader.a aVar, String str, boolean z, int i, int i2) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{aVar, str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            long j2 = i2;
            try {
                j = com.kwad.sdk.crash.utils.g.getAvailableBytes(new File(this.mDestinationDir).exists() ? this.mDestinationDir : Environment.getExternalStorageDirectory().getPath());
            } catch (Exception e) {
                e.printStackTrace();
                j = j2;
            }
            if (j < j2) {
                d.N().cancel(aVar.getId());
                e.S().v(aVar.getId());
                onLowStorage(aVar);
                return;
            }
            try {
                Iterator<c> it = this.mDownloadListeners.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                notifyDownloadProgress(aVar, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloading(com.kwai.filedownloader.a aVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65556, this, aVar, i, i2) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.a(this, i, i2);
                }
                notifyDownloadProgress(this.mBaseDownloadTask, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.kwai.filedownloader.a aVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, this, aVar, th) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.a(this, th);
                }
                notifyDownloadError(aVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onLowStorage(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, aVar) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.f(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause(com.kwai.filedownloader.a aVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65559, this, aVar, i, i2) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.c(this);
                }
                notifyDownloadProgress(aVar, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPending(com.kwai.filedownloader.a aVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65560, this, aVar, i, i2) == null) {
            try {
                Iterator<c> it = this.mDownloadListeners.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                notifyDownloadPending(aVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onResume(com.kwai.filedownloader.a aVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65561, this, aVar, i, i2) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.e(this);
                }
                notifyDownloadProgress(aVar, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStarted(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, aVar) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.b(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWarn(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, aVar) == null) {
            try {
                Iterator<c> it = this.mDownloadListeners.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            this.mDownloadListeners = new ArrayList();
        }
    }

    private void releaseDownloadTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.mBaseDownloadTask.a(null);
            clearListener();
        }
    }

    public void addListener(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || this.mDownloadListeners.contains(cVar)) {
            return;
        }
        this.mDownloadListeners.add(cVar);
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                onCanceled(this.mBaseDownloadTask);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void clearListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mDownloadListeners.clear();
        }
    }

    public int downLoadProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long smallFileTotalBytes = this.mBaseDownloadTask.getSmallFileTotalBytes();
            int smallFileSoFarBytes = smallFileTotalBytes != 0 ? (int) ((this.mBaseDownloadTask.getSmallFileSoFarBytes() * 100.0f) / ((float) smallFileTotalBytes)) : 0;
            if (smallFileSoFarBytes != 100 || o.J(new File(this.mBaseDownloadTask.getTargetFilePath()))) {
                return smallFileSoFarBytes;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getAllowedNetworkTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAllowedNetworkTypes : invokeV.intValue;
    }

    public String getDestinationDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDestinationDir : (String) invokeV.objValue;
    }

    public String getFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mBaseDownloadTask.getFilename() : (String) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBaseDownloadTask.getId() : invokeV.intValue;
    }

    public int getNotificationVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mNotificationVisibility : invokeV.intValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mBaseDownloadTask.getPath() : (String) invokeV.objValue;
    }

    public int getSmallFileSoFarBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mBaseDownloadTask.getSmallFileSoFarBytes() : invokeV.intValue;
    }

    public int getSmallFileTotalBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mBaseDownloadTask.getSmallFileTotalBytes() : invokeV.intValue;
    }

    public int getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mBaseDownloadTask.getSpeed() : invokeV.intValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mBaseDownloadTask.Ca() : invokeV.intValue;
    }

    public long getStatusUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mBaseDownloadTask.getStatusUpdateTime() : invokeV.longValue;
    }

    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mBaseDownloadTask.getTag() : invokeV.objValue;
    }

    public String getTargetFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mBaseDownloadTask.getTargetFilePath() : (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public void installApk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                b.b(this, this.mBaseDownloadTask.getTargetFilePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void instantiateDownloadTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            r.CZ();
            this.mBaseDownloadTask = r.eq(this.mUrl).by(true).bQ(3).c(TextUtils.isEmpty(this.mDestinationFileName) ? this.mDestinationDir : new File(this.mDestinationDir, this.mDestinationFileName).getPath(), TextUtils.isEmpty(this.mDestinationFileName)).a(new i(this) { // from class: com.ksad.download.DownloadTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadTask al;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.al = this;
                }

                @Override // com.kwai.filedownloader.i
                public final void a(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.al.onStarted(aVar);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public final void a(com.kwai.filedownloader.a aVar, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i, i2) == null) {
                        this.al.onPending(aVar, i, i2);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public final void a(com.kwai.filedownloader.a aVar, String str, boolean z, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                        this.al.onConnected(aVar, str, z, i, i2);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048579, this, aVar, th) == null) {
                        this.al.onError(aVar, th);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public final void b(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, aVar) == null) {
                        this.al.onBlockCompleted(aVar);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public final void b(com.kwai.filedownloader.a aVar, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048581, this, aVar, i, i2) == null) {
                        this.al.onDownloading(aVar, i, i2);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public final void c(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, aVar) == null) {
                        this.al.onCompleted(aVar);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public final void c(com.kwai.filedownloader.a aVar, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048583, this, aVar, i, i2) == null) {
                        this.al.onPause(aVar, i, i2);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public final void d(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
                        this.al.onWarn(aVar);
                    }
                }
            });
        }
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mIsCanceled : invokeV.booleanValue;
    }

    public boolean isCompleted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mBaseDownloadTask.Ca() == -3 : invokeV.booleanValue;
    }

    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mBaseDownloadTask.Ca() == -1 : invokeV.booleanValue;
    }

    public boolean isErrorBecauseWifiRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mBaseDownloadTask.Ch() && isError() && (this.mBaseDownloadTask.Cc() instanceof FileDownloadNetworkPolicyException) : invokeV.booleanValue;
    }

    public boolean isInvalid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mBaseDownloadTask.Ca() == 0 : invokeV.booleanValue;
    }

    public boolean isNotificationRemoved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.notificationRemoved : invokeV.booleanValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mBaseDownloadTask.Ca() == -2 : invokeV.booleanValue;
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mBaseDownloadTask.isRunning() : invokeV.booleanValue;
    }

    public boolean isUserPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mUserPause : invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mBaseDownloadTask.pause();
            notifyDownloadProgress(this.mBaseDownloadTask, true);
        }
    }

    public void removeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, cVar) == null) || cVar == null) {
            return;
        }
        this.mDownloadListeners.remove(cVar);
    }

    public void resume(DownloadRequest downloadRequest) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, downloadRequest) == null) && ae.isNetworkConnected(b.getContext())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (this.mBaseDownloadTask.isRunning()) {
                com.kwai.filedownloader.a aVar = this.mBaseDownloadTask;
                onResume(aVar, aVar.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
                return;
            }
            try {
                if (com.kwai.filedownloader.c.d.cy(this.mBaseDownloadTask.Ca())) {
                    this.mBaseDownloadTask.BS();
                }
                submit();
                onResume(this.mBaseDownloadTask, this.mBaseDownloadTask.getSmallFileSoFarBytes(), this.mBaseDownloadTask.getSmallFileTotalBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setAllowedNetworkTypes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.mAllowedNetworkTypes = i;
            this.mBaseDownloadTask.bA((i ^ 2) == 0);
        }
    }

    public void setNotificationRemoved(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.notificationRemoved = z;
        }
    }

    public void submit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            try {
                if (this.mBaseDownloadTask.isRunning()) {
                    return;
                }
                this.mBaseDownloadTask.start();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public com.kwai.filedownloader.a unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mBaseDownloadTask : (com.kwai.filedownloader.a) invokeV.objValue;
    }

    public void userPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.mUserPause = true;
            pause();
        }
    }
}

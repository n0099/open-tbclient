package com.ksad.download;

import android.content.Intent;
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
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.q;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class DownloadTask implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7092669850073266500L;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public static class DownloadRequest implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3638290207248829674L;
        public transient /* synthetic */ FieldHolder $fh;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!b.b().exists()) {
                b.b().mkdirs();
            }
            this.mDestinationDir = b.b().getPath();
            this.mDownloadUrl = str;
            NetworkInfo c2 = com.ksad.download.d.b.c(b.a());
            if (c2 == null || c2.getType() != 0) {
                this.mAllowedNetworkTypes = 2;
            } else {
                this.mAllowedNetworkTypes = 3;
            }
        }

        public DownloadRequest addRequestHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (str != null) {
                    if (str.contains(":")) {
                        throw new IllegalArgumentException("header may not contain ':'");
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    this.mRequestHeaders.put(str, str2);
                    return this;
                }
                throw new NullPointerException("header cannot be null");
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

        public boolean isPhotoAdDownloadRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsPhotoAdDownloadRequest : invokeV.booleanValue;
        }

        public DownloadRequest setAllowedNetworkTypes(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                this.mAllowedNetworkTypes = i2;
                return this;
            }
            return (DownloadRequest) invokeI.objValue;
        }

        public DownloadRequest setDestinationDir(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.mDestinationDir = str;
                return this;
            }
            return (DownloadRequest) invokeL.objValue;
        }

        public DownloadRequest setDestinationFileName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.mDestinationFileName = str;
                return this;
            }
            return (DownloadRequest) invokeL.objValue;
        }

        public DownloadRequest setInstallAfterDownload(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.mInstallAfterDownload = z;
                return this;
            }
            return (DownloadRequest) invokeZ.objValue;
        }

        public void setIsPhotoAdDownloadRequest() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.mIsPhotoAdDownloadRequest = true;
            }
        }

        public DownloadRequest setNotificationVisibility(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                this.mNotificationVisibility = i2;
                return this;
            }
            return (DownloadRequest) invokeI.objValue;
        }

        public DownloadRequest setTag(Serializable serializable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, serializable)) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDownloadListeners = new ArrayList();
        this.mIsCanceled = false;
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
        }
    }

    private void initDownloadTaskParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mBaseDownloadTask.a(this.mTag);
            this.mBaseDownloadTask.b((this.mAllowedNetworkTypes ^ 2) == 0);
            for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
                this.mBaseDownloadTask.b(entry.getKey());
                this.mBaseDownloadTask.a(entry.getKey(), entry.getValue());
            }
        }
    }

    private void notifyDownloadCompleted(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, aVar) == null) || (this.mNotificationVisibility & 2) == 0) {
            return;
        }
        e.a().b(this);
    }

    private void notifyDownloadPending(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, aVar) == null) || (this.mNotificationVisibility & 2) == 0) {
            return;
        }
        e.a().a(this);
    }

    private void notifyDownloadProgress(com.kwai.filedownloader.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, this, aVar, z) == null) {
            if ((aVar.s() == 0 && aVar.q() == 0) || TextUtils.isEmpty(aVar.n()) || (this.mNotificationVisibility & 1) == 0) {
                return;
            }
            e.a().a(this, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlockCompleted(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, aVar) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.a(this);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onCanceled(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, aVar) == null) {
            try {
                this.mIsCanceled = true;
                for (c cVar : this.mDownloadListeners) {
                    cVar.e(this);
                }
                aVar.g();
                e.a().a(getId());
                q.a().a(getId(), this.mBaseDownloadTask.o());
                releaseDownloadTask();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, aVar) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.b(this);
                }
                notifyDownloadCompleted(aVar);
                if (this.mWakeInstallApk) {
                    wakeInstallApk();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnected(com.kwai.filedownloader.a aVar, String str, boolean z, int i2, int i3) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{aVar, str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            long j2 = i3;
            try {
                j = com.ksad.download.d.a.a(new File(this.mDestinationDir).exists() ? this.mDestinationDir : Environment.getExternalStorageDirectory().getPath());
            } catch (Exception e2) {
                e2.printStackTrace();
                j = j2;
            }
            if (j < j2) {
                Intent intent = new Intent(com.kwad.sdk.core.download.a.n);
                intent.putExtra("download.intent.action.EXTRA_TASK_ID", aVar.h());
                b.a().sendBroadcast(intent);
                onLowStorage(aVar);
                return;
            }
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.a(this, str, z, i2, i3);
                }
                notifyDownloadProgress(aVar, false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloading(com.kwai.filedownloader.a aVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65555, this, aVar, i2, i3) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.b(this, i2, i3);
                }
                notifyDownloadProgress(this.mBaseDownloadTask, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.kwai.filedownloader.a aVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, aVar, th) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.a(this, th);
                }
                notifyDownloadProgress(aVar, true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onLowStorage(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, aVar) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.f(this);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause(com.kwai.filedownloader.a aVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65558, this, aVar, i2, i3) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.c(this, i2, i3);
                }
                notifyDownloadProgress(aVar, true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPending(com.kwai.filedownloader.a aVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65559, this, aVar, i2, i3) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.a(this, i2, i3);
                }
                notifyDownloadPending(aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onResume(com.kwai.filedownloader.a aVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65560, this, aVar, i2, i3) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.d(this, i2, i3);
                }
                notifyDownloadProgress(aVar, true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStarted(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, aVar) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.c(this);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWarn(com.kwai.filedownloader.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, aVar) == null) {
            try {
                for (c cVar : this.mDownloadListeners) {
                    cVar.d(this);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            this.mDownloadListeners = new ArrayList();
        }
    }

    private void releaseDownloadTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            this.mBaseDownloadTask.a((i) null);
            clearListener();
        }
    }

    private void wakeInstallApk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            b.a(this.mBaseDownloadTask.o());
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
            } catch (Exception e2) {
                e2.printStackTrace();
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
            long s = this.mBaseDownloadTask.s();
            int q = s != 0 ? (int) ((this.mBaseDownloadTask.q() * 100.0f) / ((float) s)) : 0;
            if (q != 100 || com.ksad.download.d.a.a(new File(this.mBaseDownloadTask.o()))) {
                return q;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mBaseDownloadTask.n() : (String) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBaseDownloadTask.h() : invokeV.intValue;
    }

    public int getNotificationVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mNotificationVisibility : invokeV.intValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mBaseDownloadTask.l() : (String) invokeV.objValue;
    }

    public int getSmallFileSoFarBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mBaseDownloadTask.q() : invokeV.intValue;
    }

    public int getSmallFileTotalBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mBaseDownloadTask.s() : invokeV.intValue;
    }

    public int getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mBaseDownloadTask.u() : invokeV.intValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mBaseDownloadTask.v() : invokeV.intValue;
    }

    public long getStatusUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mBaseDownloadTask.w() : invokeV.longValue;
    }

    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mBaseDownloadTask.z() : invokeV.objValue;
    }

    public String getTargetFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mBaseDownloadTask.o() : (String) invokeV.objValue;
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
                wakeInstallApk();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void instantiateDownloadTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.mBaseDownloadTask = q.a().a(this.mUrl).a(true).a(3).a(TextUtils.isEmpty(this.mDestinationFileName) ? this.mDestinationDir : new File(this.mDestinationDir, this.mDestinationFileName).getPath(), TextUtils.isEmpty(this.mDestinationFileName)).a(new i(this) { // from class: com.ksad.download.DownloadTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadTask f33532a;

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
                    this.f33532a = this;
                }

                @Override // com.kwai.filedownloader.i
                public void a(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.f33532a.onStarted(aVar);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void a(com.kwai.filedownloader.a aVar, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, i3) == null) {
                        this.f33532a.onPending(aVar, i2, i3);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void a(com.kwai.filedownloader.a aVar, String str, boolean z, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                        this.f33532a.onConnected(aVar, str, z, i2, i3);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void a(com.kwai.filedownloader.a aVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048579, this, aVar, th) == null) {
                        this.f33532a.onError(aVar, th);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void b(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, aVar) == null) {
                        this.f33532a.onBlockCompleted(aVar);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void b(com.kwai.filedownloader.a aVar, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048581, this, aVar, i2, i3) == null) {
                        this.f33532a.onDownloading(aVar, i2, i3);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void c(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, aVar) == null) {
                        this.f33532a.onCompleted(aVar);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void c(com.kwai.filedownloader.a aVar, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048583, this, aVar, i2, i3) == null) {
                        this.f33532a.onPause(aVar, i2, i3);
                    }
                }

                @Override // com.kwai.filedownloader.i
                public void d(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
                        this.f33532a.onWarn(aVar);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mBaseDownloadTask.v() == -3 : invokeV.booleanValue;
    }

    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mBaseDownloadTask.v() == -1 : invokeV.booleanValue;
    }

    public boolean isErrorBecauseWifiRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mBaseDownloadTask.E() && isError() && (this.mBaseDownloadTask.y() instanceof FileDownloadNetworkPolicyException) : invokeV.booleanValue;
    }

    public boolean isInvalid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mBaseDownloadTask.v() == 0 : invokeV.booleanValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mBaseDownloadTask.v() == -2 : invokeV.booleanValue;
    }

    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mBaseDownloadTask.c() : invokeV.booleanValue;
    }

    public boolean isUserPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mUserPause : invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mBaseDownloadTask.f();
            notifyDownloadProgress(this.mBaseDownloadTask, true);
        }
    }

    public void removeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) || cVar == null) {
            return;
        }
        this.mDownloadListeners.remove(cVar);
    }

    public void resume(DownloadRequest downloadRequest) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, downloadRequest) == null) && com.ksad.download.d.b.a(b.a())) {
            if (downloadRequest != null) {
                initDownloadRequestParams(downloadRequest);
                initDownloadTaskParams();
            }
            this.mUserPause = false;
            if (this.mBaseDownloadTask.c()) {
                return;
            }
            try {
                if (com.kwai.filedownloader.d.d.a(this.mBaseDownloadTask.v())) {
                    this.mBaseDownloadTask.b();
                }
                submit();
                onResume(this.mBaseDownloadTask, this.mBaseDownloadTask.q(), this.mBaseDownloadTask.s());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setAllowedNetworkTypes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.mAllowedNetworkTypes = i2;
            this.mBaseDownloadTask.b((i2 ^ 2) == 0);
        }
    }

    public void submit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            try {
                if (this.mBaseDownloadTask.c()) {
                    return;
                }
                this.mBaseDownloadTask.e();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public com.kwai.filedownloader.a unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mBaseDownloadTask : (com.kwai.filedownloader.a) invokeV.objValue;
    }

    public void userPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.mUserPause = true;
            pause();
        }
    }
}

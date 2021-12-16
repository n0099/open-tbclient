package com.ss.android.socialbase.downloader.depend;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes3.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AbsDownloadListener";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1133115154, "Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1133115154, "Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;");
        }
    }

    public AbsDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            com.ss.android.socialbase.downloader.c.a.b(str, " onCanceled -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, baseException) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            com.ss.android.socialbase.downloader.c.a.b(str, String.format("onFailed on %s because of : %s", objArr));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            com.ss.android.socialbase.downloader.c.a.b(str, " onFirstStart -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            com.ss.android.socialbase.downloader.c.a.b(str, " onFirstSuccess -- " + downloadInfo.getName());
        }
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            com.ss.android.socialbase.downloader.c.a.b(str, " onIntercept -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            com.ss.android.socialbase.downloader.c.a.b(str, " onPause -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            com.ss.android.socialbase.downloader.c.a.b(str, " onPrepare -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadInfo) == null) || !com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((((float) downloadInfo.getCurBytes()) / ((float) downloadInfo.getTotalBytes())) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadInfo, baseException) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            com.ss.android.socialbase.downloader.c.a.b(str, String.format("onRetry on %s because of : %s", objArr));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, downloadInfo, baseException) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            com.ss.android.socialbase.downloader.c.a.b(str, String.format("onRetryDelay on %s because of : %s", objArr));
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, downloadInfo) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            com.ss.android.socialbase.downloader.c.a.b(str, " onStart -- " + downloadInfo.getName());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, downloadInfo) == null) && com.ss.android.socialbase.downloader.c.a.a() && downloadInfo != null) {
            String str = TAG;
            com.ss.android.socialbase.downloader.c.a.b(str, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
        }
    }
}

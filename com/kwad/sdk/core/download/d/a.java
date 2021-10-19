package com.kwad.sdk.core.download.d;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.w;
import java.io.File;
/* loaded from: classes10.dex */
public class a implements AdDownloadProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f72045a;

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72045a = z;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            return w.a(str) + ".apk";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public void cancelDownload(Context context, String str, DownloadParams downloadParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, downloadParams) == null) {
            com.ksad.download.a.a.b(context, str);
        }
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    @Nullable
    public String getDownloadFilePath(DownloadParams downloadParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadParams)) == null) {
            if (TextUtils.isEmpty(downloadParams.mFileUrl)) {
                return null;
            }
            return com.ksad.download.b.b() + File.separator + a(downloadParams.mFileUrl);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public void pauseDownload(Context context, String str, DownloadParams downloadParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, downloadParams) == null) {
            com.ksad.download.a.a.a(context, str);
        }
    }

    @Override // com.kwad.sdk.export.proxy.AdDownloadProxy
    public void startDownload(Context context, String str, DownloadParams downloadParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, str, downloadParams) == null) {
            String str2 = downloadParams.mFileUrl;
            if (TextUtils.isEmpty(str2) || !URLUtil.isNetworkUrl(str2)) {
                return;
            }
            DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(downloadParams.mFileUrl);
            downloadRequest.setDestinationFileName(a(downloadParams.mFileUrl));
            downloadRequest.setTag(downloadParams);
            downloadRequest.setDownloadEnablePause(downloadParams.downloadEnablePause);
            downloadRequest.setNotificationVisibility(this.f72045a ? 3 : 0);
            com.ksad.download.a.a.a(context, str, downloadRequest);
        }
    }
}

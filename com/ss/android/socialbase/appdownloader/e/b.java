package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes2.dex */
public class b extends com.ss.android.socialbase.downloader.depend.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68966a;

    /* renamed from: b  reason: collision with root package name */
    public int f68967b;

    /* renamed from: c  reason: collision with root package name */
    public String f68968c;

    /* renamed from: d  reason: collision with root package name */
    public String f68969d;

    /* renamed from: e  reason: collision with root package name */
    public String f68970e;

    /* renamed from: f  reason: collision with root package name */
    public String f68971f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.notification.a f68972g;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context != null) {
            this.f68966a = context.getApplicationContext();
        } else {
            this.f68966a = com.ss.android.socialbase.downloader.downloader.c.N();
        }
        this.f68967b = i2;
        this.f68968c = str;
        this.f68969d = str2;
        this.f68970e = str3;
        this.f68971f = str4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.d
    public com.ss.android.socialbase.downloader.notification.a a() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f68972g == null && (context = this.f68966a) != null) {
                return new a(context, this.f68967b, this.f68968c, this.f68969d, this.f68970e, this.f68971f);
            }
            return this.f68972g;
        }
        return (com.ss.android.socialbase.downloader.notification.a) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, baseException) == null) || downloadInfo == null || this.f68966a == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) || downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) || downloadInfo == null || this.f68966a == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.f.b.a(downloadInfo);
        }
    }

    public b(com.ss.android.socialbase.downloader.notification.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68966a = com.ss.android.socialbase.downloader.downloader.c.N();
        this.f68972g = aVar;
    }
}

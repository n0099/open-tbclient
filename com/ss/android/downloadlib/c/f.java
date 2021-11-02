package com.ss.android.downloadlib.c;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements com.ss.android.socialbase.appdownloader.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68741a;

    public f(Context context) {
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
        this.f68741a = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            com.ss.android.downloadlib.a.a().a(str);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i2, int i3, String str, int i4, long j) {
        Context context;
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.a.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Long.valueOf(j)}) == null) || (context = this.f68741a) == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() == 0 || (a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        if (i3 == 1) {
            com.ss.android.downloadlib.a.a(downloadInfo, a2);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.a.a().a(downloadInfo, a2.b(), a2.l(), a2.e(), downloadInfo.getTitle(), a2.d(), downloadInfo.getTargetFilePath());
            }
        } else if (i3 == 3) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_install", com.ss.android.downloadlib.a.b(new JSONObject(), downloadInfo), a2);
        } else if (i3 == 5) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_pause", a2);
        } else if (i3 == 6) {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_continue", a2);
        } else if (i3 != 7) {
        } else {
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_click", a2);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (j.n() != null) {
                return j.n().a(z);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.f.a().a(downloadInfo);
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.d.a.a().a(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i2, int i3, String str, String str2, String str3) {
        Context context;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3}) == null) || (context = this.f68741a) == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.b.a().a(this.f68741a, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.ss.android.downloadlib.addownload.b.a().b() : invokeV.booleanValue;
    }
}

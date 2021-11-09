package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, downloadInfo) == null) {
            b(downloadInfo);
        }
    }

    public static void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, downloadInfo) == null) {
            Context N = com.ss.android.socialbase.downloader.downloader.c.N();
            boolean z = true;
            if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.c.b(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("auto_install_when_resume", 0) != 1) {
                z = false;
            }
            com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable(N, downloadInfo, z ? com.ss.android.socialbase.appdownloader.c.a(N, downloadInfo.getId(), false) : 2) { // from class: com.ss.android.socialbase.appdownloader.f.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f69016a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f69017b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f69018c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {N, downloadInfo, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69016a = N;
                    this.f69017b = downloadInfo;
                    this.f69018c = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.socialbase.appdownloader.c.d b2 = com.ss.android.socialbase.appdownloader.d.j().b();
                        z downloadNotificationEventListener = Downloader.getInstance(this.f69016a).getDownloadNotificationEventListener(this.f69017b.getId());
                        if (b2 == null && downloadNotificationEventListener == null) {
                            return;
                        }
                        File file = new File(this.f69017b.getSavePath(), this.f69017b.getName());
                        if (file.exists()) {
                            try {
                                PackageInfo a2 = com.ss.android.socialbase.appdownloader.c.a(this.f69017b, file);
                                if (a2 != null) {
                                    String packageName = (this.f69018c == 1 || TextUtils.isEmpty(this.f69017b.getPackageName())) ? a2.packageName : this.f69017b.getPackageName();
                                    if (b2 != null) {
                                        b2.a(this.f69017b.getId(), 1, packageName, -3, this.f69017b.getDownloadTime());
                                    }
                                    if (downloadNotificationEventListener != null) {
                                        downloadNotificationEventListener.a(1, this.f69017b, packageName, "");
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }
}

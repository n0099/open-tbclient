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
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f61558b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f61559c;

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
                    this.a = N;
                    this.f61558b = downloadInfo;
                    this.f61559c = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.socialbase.appdownloader.c.d b2 = com.ss.android.socialbase.appdownloader.d.j().b();
                        z downloadNotificationEventListener = Downloader.getInstance(this.a).getDownloadNotificationEventListener(this.f61558b.getId());
                        if (b2 == null && downloadNotificationEventListener == null) {
                            return;
                        }
                        File file = new File(this.f61558b.getSavePath(), this.f61558b.getName());
                        if (file.exists()) {
                            try {
                                PackageInfo a = com.ss.android.socialbase.appdownloader.c.a(this.f61558b, file);
                                if (a != null) {
                                    String packageName = (this.f61559c == 1 || TextUtils.isEmpty(this.f61558b.getPackageName())) ? a.packageName : this.f61558b.getPackageName();
                                    if (b2 != null) {
                                        b2.a(this.f61558b.getId(), 1, packageName, -3, this.f61558b.getDownloadTime());
                                    }
                                    if (downloadNotificationEventListener != null) {
                                        downloadNotificationEventListener.a(1, this.f61558b, packageName, "");
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

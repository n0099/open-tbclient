package com.kwad.sdk.ec.download;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.c.b;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.download.c;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.i;
import java.io.File;
/* loaded from: classes3.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f59000b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final AdInfo f59001c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f59002d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59003e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f59004f;

    public a(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, ksAppDownloadListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59000b = adTemplate;
        this.f59001c = d.j(adTemplate);
        DownloadStatusManager.a().a(this, this.f59000b);
        DownloadStatusManager.a().a(this.f59000b);
        this.f59004f = d.j(this.f59000b).downloadSafeInfo.downloadPauseEnable;
        this.f59002d = ksAppDownloadListener;
    }

    private int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            h();
            return 1;
        }
        return invokeL.intValue;
    }

    private void f() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (ksAppDownloadListener = this.f59002d) == null) {
            return;
        }
        AdInfo adInfo = this.f59001c;
        int i2 = adInfo.progress;
        int i3 = adInfo.status;
        if (i3 == 0) {
            ksAppDownloadListener.onIdle();
        } else if (i3 == 1) {
            ksAppDownloadListener.onProgressUpdate(0);
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.c) {
                ((com.kwad.sdk.core.download.a.c) ksAppDownloadListener).onDownloadStarted();
                return;
            }
            try {
                ksAppDownloadListener.onDownloadStarted();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        } else if (i3 == 2 || i3 == 3) {
            ksAppDownloadListener.onProgressUpdate(i2);
        } else if (i3 == 4) {
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.c) {
                ((com.kwad.sdk.core.download.a.c) ksAppDownloadListener).a(i2);
            }
        } else if (i3 == 7) {
            ksAppDownloadListener.onDownloadFailed();
        } else if (i3 == 8 || i3 == 9) {
            ksAppDownloadListener.onDownloadFinished();
        } else if (i3 != 12) {
        } else {
            ksAppDownloadListener.onInstalled();
        }
    }

    private void g() {
        AdDownloadProxy proxyForDownload;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String str = this.f59001c.adBaseInfo.appPackageName;
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                return;
            }
            if (ag.a(context, str)) {
                this.f59001c.status = 12;
                return;
            }
            AdInfo adInfo = this.f59001c;
            if (adInfo.status == 12) {
                adInfo.status = 0;
                adInfo.progress = 0;
            }
            AdInfo adInfo2 = this.f59001c;
            if (adInfo2.status == 8) {
                String str2 = adInfo2.downloadFilePath;
                if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                    AdInfo adInfo3 = this.f59001c;
                    adInfo3.status = 0;
                    adInfo3.progress = 0;
                }
            }
            if (this.f59001c.status != 0 || (proxyForDownload = KsAdSDKImpl.get().getProxyForDownload()) == null) {
                return;
            }
            String downloadFilePath = proxyForDownload.getDownloadFilePath(DownloadParams.transform(this.f59001c));
            if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists()) {
                return;
            }
            AdInfo adInfo4 = this.f59001c;
            adInfo4.downloadFilePath = downloadFilePath;
            adInfo4.status = 8;
        }
    }

    private void h() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        if (b.a(context)) {
            com.kwad.sdk.core.download.d.a(context, this.f59001c, Build.VERSION.SDK_INT >= 26 && an.a());
        } else {
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "no network while download app");
        }
    }

    private void i() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        com.kwad.sdk.core.download.d.a(context, this.f59001c.downloadId);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int a(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            g();
            switch (this.f59001c.status) {
                case 0:
                case 1:
                case 4:
                case 5:
                case 6:
                case 7:
                    i2 = b(context);
                    break;
                case 2:
                case 3:
                    if (!this.f59003e || !this.f59004f) {
                        i2 = 1;
                        break;
                    } else {
                        i();
                        i2 = 0;
                        break;
                    }
                    break;
                case 8:
                case 9:
                case 11:
                    d();
                    i2 = 0;
                    break;
                case 10:
                default:
                    i2 = 0;
                    break;
                case 12:
                    c();
                    i2 = 0;
                    break;
            }
            this.f59003e = false;
            return i2;
        }
        return invokeL.intValue;
    }

    @Override // com.kwad.sdk.core.download.c
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59001c.downloadId : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, str, i2, i3, i4) == null) && this.f59001c.downloadId.equals(str)) {
            AdInfo adInfo = this.f59001c;
            adInfo.status = 3;
            adInfo.progress = i2;
            adInfo.soFarBytes = i3;
            adInfo.totalBytes = i4;
            f();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, fVar) == null) {
            i.a(new Runnable(this) { // from class: com.kwad.sdk.ec.download.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.home.download.a.a().b(this.a.f59000b);
                        com.kwad.sdk.home.download.a.a().c(this.a.f59000b);
                    }
                }
            });
            com.kwad.sdk.core.a.a().d(d.j(this.f59000b).downloadId);
            this.f59001c.status = 12;
            f();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, int i2, String str2, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048580, this, str, i2, str2, fVar) == null) && this.f59001c.downloadId.equals(str)) {
            this.f59001c.status = 7;
            this.a = str2;
            f();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, fVar) == null) && this.f59001c.downloadId.equals(str)) {
            AdInfo adInfo = this.f59001c;
            if (adInfo.status != 1) {
                adInfo.status = 1;
            }
            f();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void a(String str, String str2, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, fVar) == null) && this.f59001c.downloadId.equals(str)) {
            AdInfo adInfo = this.f59001c;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            adInfo.status = 8;
            ApkCacheManager.a().b();
            f();
        }
    }

    public boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                boolean canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
                if (KsAdSDKImpl.get().isEnableInstallPermission() && !canRequestPackageInstalls && an.a()) {
                    Intent intent = new Intent("intent.action.requestInstallPermission");
                    intent.putExtra("needAllowDialog", true);
                    intent.putExtra("filePath", str);
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.sdk.core.download.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59001c.adBaseInfo.appPackageName : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.download.c
    public void b(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, fVar) == null) && this.f59001c.downloadId.equals(str)) {
            this.f59001c.status = 4;
            f();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            i.a(new Runnable(this) { // from class: com.kwad.sdk.ec.download.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.home.download.a.a().d(this.a.f59000b);
                    }
                }
            });
            if (ag.c(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.v(this.f59001c))) {
                com.kwad.sdk.core.report.a.e(this.f59000b);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void c(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, fVar) == null) && this.f59001c.downloadId.equals(str)) {
            this.f59001c.status = 2;
            f();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String str = this.f59001c.downloadFilePath;
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null && !TextUtils.isEmpty(str)) {
                if (a(context, str)) {
                    return;
                }
                KsAdSDKImpl.get().getProxyForAdInstall().installApp(context, str);
                return;
            }
            com.kwad.sdk.core.d.a.e("ApkDownloadHelper", "openApp fail appContext:" + context + "--filePath:" + str);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void d(String str, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, str, fVar) == null) && this.f59001c.downloadId.equals(str)) {
            this.f59001c.status = 5;
            f();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f59002d = null;
            DownloadStatusManager.a().a(this);
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public void e(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, fVar) == null) {
        }
    }
}

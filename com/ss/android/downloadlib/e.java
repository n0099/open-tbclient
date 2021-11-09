package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.i;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.t;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes2.dex */
public class e implements com.ss.android.download.api.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) {
            j.a(hVar);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            j.a(fVar);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kVar)) == null) {
            j.a(kVar);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar)) == null) {
            j.a(gVar);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iVar)) == null) {
            j.a(iVar);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.model.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            j.a(aVar);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            j.a(str);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            j.a(bVar);
            com.ss.android.socialbase.downloader.a.a.a().a(new a.c(this, bVar) { // from class: com.ss.android.downloadlib.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.download.api.config.b f68769a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f68770b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68770b = this;
                    this.f68769a = bVar;
                }
            });
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(DownloaderBuilder downloaderBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloaderBuilder)) == null) {
            if (downloaderBuilder.getNotificationClickCallback() == null) {
                downloaderBuilder.notificationClickCallback(new af(this) { // from class: com.ss.android.downloadlib.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f68771a;

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
                        this.f68771a = this;
                    }

                    private boolean d(DownloadInfo downloadInfo) {
                        InterceptResult invokeL2;
                        String a2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(65537, this, downloadInfo)) == null) {
                            t r = j.r();
                            if (r != null) {
                                com.ss.android.downloadad.api.a.b a3 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                                if (a3 != null && a3.c()) {
                                    a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("ad_notification_jump_url", (String) null);
                                } else {
                                    a2 = com.ss.android.downloadlib.addownload.h.a(downloadInfo);
                                }
                                if (TextUtils.isEmpty(a2)) {
                                    return false;
                                }
                                return r.a(j.getContext(), a2);
                            }
                            return false;
                        }
                        return invokeL2.booleanValue;
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.af
                    public boolean a(DownloadInfo downloadInfo) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, downloadInfo)) == null) {
                            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                            if (a2.b("notification_opt_2") == 1) {
                                if (downloadInfo.getStatus() == -2) {
                                    DownloadHandlerService.a(j.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.d.j().b(), Downloader.getInstance(j.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                                }
                                return true;
                            }
                            boolean d2 = d(downloadInfo);
                            if (a2.a("disable_delete_dialog", 0) == 1) {
                                return true;
                            }
                            return d2;
                        }
                        return invokeL2.booleanValue;
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.af
                    public boolean b(DownloadInfo downloadInfo) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) {
                            return false;
                        }
                        return invokeL2.booleanValue;
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.af
                    public boolean c(DownloadInfo downloadInfo) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                            if (downloadInfo == null) {
                                return false;
                            }
                            com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                            if (a2 != null) {
                                com.ss.android.downloadlib.b.a.a(a2);
                            } else {
                                com.ss.android.downloadlib.g.i.b(j.getContext(), downloadInfo.getPackageName());
                            }
                            com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                            return true;
                        }
                        return invokeL2.booleanValue;
                    }
                });
            }
            downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.c.c());
            Downloader.initOrCover(downloaderBuilder, true);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pVar)) == null) {
            j.a(pVar);
            return this;
        }
        return (com.ss.android.download.api.a) invokeL.objValue;
    }

    @Override // com.ss.android.download.api.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!j.v()) {
                com.ss.android.downloadlib.e.c.a().a("ttdownloader init error");
            }
            j.a(com.ss.android.downloadlib.e.c.a());
            try {
                com.ss.android.socialbase.appdownloader.d.j().b(j.u());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.ss.android.socialbase.appdownloader.d.j().a(a.a());
            d.a().b(new Runnable(this) { // from class: com.ss.android.downloadlib.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f68772a;

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
                    this.f68772a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.socialbase.appdownloader.f.d.a("");
                        if (com.ss.android.socialbase.appdownloader.f.d.n()) {
                            com.ss.android.socialbase.downloader.downloader.c.a(true);
                        }
                        com.ss.android.socialbase.appdownloader.f.e.a(j.getContext());
                    }
                }
            });
        }
    }
}

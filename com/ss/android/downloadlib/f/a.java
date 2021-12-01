package com.ss.android.downloadlib.f;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes2.dex */
public class a implements j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DownloadInfo downloadInfo, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, downloadInfo, aVar) == null) {
            com.ss.android.downloadad.api.a.b a = f.a().a(downloadInfo);
            boolean a2 = com.ss.android.downloadlib.b.f.a(a);
            boolean b2 = com.ss.android.downloadlib.b.f.b(a);
            if (a2 && b2) {
                com.ss.android.downloadlib.b.c.a(a, new com.ss.android.downloadlib.guide.install.a(this, aVar) { // from class: com.ss.android.downloadlib.f.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.ss.android.downloadlib.guide.install.a a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f61402b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61402b = this;
                        this.a = aVar;
                    }

                    @Override // com.ss.android.downloadlib.guide.install.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.a();
                        }
                    }
                });
            } else {
                aVar.a();
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, iVar) == null) {
            a(downloadInfo, new com.ss.android.downloadlib.guide.install.a(this, iVar) { // from class: com.ss.android.downloadlib.f.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ i a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61399b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61399b = this;
                    this.a = iVar;
                }

                @Override // com.ss.android.downloadlib.guide.install.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a();
                    }
                }
            });
        }
    }

    public void a(DownloadInfo downloadInfo, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, downloadInfo, aVar) == null) {
            com.ss.android.downloadad.api.a.b a = f.a().a(downloadInfo);
            if (a != null && com.ss.android.downloadlib.b.i.a(a)) {
                TTDelegateActivity.a(a, new com.ss.android.downloadlib.guide.install.a(this, downloadInfo, aVar) { // from class: com.ss.android.downloadlib.f.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadInfo a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.ss.android.downloadlib.guide.install.a f61400b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f61401c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, downloadInfo, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61401c = this;
                        this.a = downloadInfo;
                        this.f61400b = aVar;
                    }

                    @Override // com.ss.android.downloadlib.guide.install.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f61401c.b(this.a, this.f61400b);
                        }
                    }
                });
            } else {
                b(downloadInfo, aVar);
            }
        }
    }
}

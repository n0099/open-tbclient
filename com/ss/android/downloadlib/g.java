package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.download.api.a f61407b;

    /* renamed from: c  reason: collision with root package name */
    public final f f61408c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.downloadad.api.a f61409d;

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.downloadad.api.b f61410e;

    /* renamed from: f  reason: collision with root package name */
    public long f61411f;

    /* JADX INFO: Access modifiers changed from: private */
    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.f61408c : (f) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f61411f = System.currentTimeMillis();
        }
    }

    public com.ss.android.downloadad.api.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f61409d : (com.ss.android.downloadad.api.a) invokeV.objValue;
    }

    public com.ss.android.downloadad.api.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f61410e == null) {
                this.f61410e = b.a();
            }
            return this.f61410e;
        }
        return (com.ss.android.downloadad.api.b) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? j.m() : (String) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a().e();
        }
    }

    public g(Context context) {
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
        this.f61408c = f.a();
        this.f61407b = new e();
        this.f61411f = System.currentTimeMillis();
        b(context);
        this.f61409d = a.a();
    }

    public static g a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (g.class) {
                    if (a == null) {
                        com.ss.android.downloadlib.e.b.a(new Runnable(context) { // from class: com.ss.android.downloadlib.g.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {context};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = context;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    g unused = g.a = new g(this.a);
                                }
                            }
                        });
                    }
                }
            }
            return a;
        }
        return (g) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            j.a(context);
            Downloader.getInstance(j.getContext());
            com.ss.android.downloadlib.addownload.b.f.a().b();
            com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), "misc_config", new com.ss.android.downloadlib.c.g(), new com.ss.android.downloadlib.c.f(context), new c());
            com.ss.android.downloadlib.c.d dVar = new com.ss.android.downloadlib.c.d();
            com.ss.android.socialbase.appdownloader.d.j().a(dVar);
            Downloader.getInstance(context).registerDownloadCacheSyncListener(dVar);
            com.ss.android.socialbase.appdownloader.d.j().a(new k());
            com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.downloadlib.c.e());
            com.ss.android.socialbase.appdownloader.d.j().a(com.ss.android.downloadlib.f.c.a());
        }
    }

    public com.ss.android.download.api.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61407b : (com.ss.android.download.api.a) invokeV.objValue;
    }

    @MainThread
    public void a(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, context, i2, downloadStatusChangeListener, downloadModel) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, context, i2, downloadStatusChangeListener, downloadModel) { // from class: com.ss.android.downloadlib.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f61414b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusChangeListener f61415c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadModel f61416d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ g f61417e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Integer.valueOf(i2), downloadStatusChangeListener, downloadModel};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61417e = this;
                    this.a = context;
                    this.f61414b = i2;
                    this.f61415c = downloadStatusChangeListener;
                    this.f61416d = downloadModel;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61417e.h().a(this.a, this.f61414b, this.f61415c, this.f61416d);
                    }
                }
            });
        }
    }

    @MainThread
    public void a(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, u uVar, IDownloadButtonClickListener iDownloadButtonClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener}) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, j2, i2, downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener) { // from class: com.ss.android.downloadlib.g.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f61418b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f61419c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f61420d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f61421e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ u f61422f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ IDownloadButtonClickListener f61423g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ g f61424h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2), Integer.valueOf(i2), downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61424h = this;
                    this.a = str;
                    this.f61418b = j2;
                    this.f61419c = i2;
                    this.f61420d = downloadEventConfig;
                    this.f61421e = downloadController;
                    this.f61422f = uVar;
                    this.f61423g = iDownloadButtonClickListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61424h.h().a(this.a, this.f61418b, this.f61419c, this.f61420d, this.f61421e, this.f61422f, this.f61423g);
                    }
                }
            });
        }
    }

    @MainThread
    public void a(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), downloadEventConfig, downloadController}) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, j2, i2, downloadEventConfig, downloadController) { // from class: com.ss.android.downloadlib.g.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f61425b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f61426c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f61427d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f61428e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ g f61429f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2), Integer.valueOf(i2), downloadEventConfig, downloadController};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61429f = this;
                    this.a = str;
                    this.f61425b = j2;
                    this.f61426c = i2;
                    this.f61427d = downloadEventConfig;
                    this.f61428e = downloadController;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61429f.h().a(this.a, this.f61425b, this.f61426c, this.f61427d, this.f61428e);
                    }
                }
            });
        }
    }

    @MainThread
    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, i2) { // from class: com.ss.android.downloadlib.g.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f61430b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f61431c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61431c = this;
                    this.a = str;
                    this.f61430b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61431c.h().a(this.a, this.f61430b);
                    }
                }
            });
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f61411f : invokeV.longValue;
    }

    @MainThread
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, z) { // from class: com.ss.android.downloadlib.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f61412b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f61413c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61413c = this;
                    this.a = str;
                    this.f61412b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61413c.h().a(this.a, this.f61412b);
                    }
                }
            });
        }
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            h().a(aVar);
        }
    }

    public DownloadInfo a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), str);
        }
        return (DownloadInfo) invokeL.objValue;
    }
}

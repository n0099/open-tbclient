package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f68811a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.download.api.a f68812b;

    /* renamed from: c  reason: collision with root package name */
    public final f f68813c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.downloadad.api.a f68814d;

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.downloadad.api.b f68815e;

    /* renamed from: f  reason: collision with root package name */
    public long f68816f;

    /* JADX INFO: Access modifiers changed from: private */
    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? this.f68813c : (f) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f68816f = System.currentTimeMillis();
        }
    }

    public com.ss.android.downloadad.api.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f68814d : (com.ss.android.downloadad.api.a) invokeV.objValue;
    }

    public com.ss.android.downloadad.api.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f68815e == null) {
                this.f68815e = b.a();
            }
            return this.f68815e;
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
        this.f68813c = f.a();
        this.f68812b = new e();
        this.f68816f = System.currentTimeMillis();
        b(context);
        this.f68814d = a.a();
    }

    public static g a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f68811a == null) {
                synchronized (g.class) {
                    if (f68811a == null) {
                        com.ss.android.downloadlib.e.b.a(new Runnable(context) { // from class: com.ss.android.downloadlib.g.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Context f68817a;

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
                                this.f68817a = context;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    g unused = g.f68811a = new g(this.f68817a);
                                }
                            }
                        });
                    }
                }
            }
            return f68811a;
        }
        return (g) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68812b : (com.ss.android.download.api.a) invokeV.objValue;
    }

    @MainThread
    public void a(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, context, i2, downloadStatusChangeListener, downloadModel) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, context, i2, downloadStatusChangeListener, downloadModel) { // from class: com.ss.android.downloadlib.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f68821a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f68822b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusChangeListener f68823c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadModel f68824d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ g f68825e;

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
                    this.f68825e = this;
                    this.f68821a = context;
                    this.f68822b = i2;
                    this.f68823c = downloadStatusChangeListener;
                    this.f68824d = downloadModel;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68825e.h().a(this.f68821a, this.f68822b, this.f68823c, this.f68824d);
                    }
                }
            });
        }
    }

    @MainThread
    public void a(String str, long j, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, u uVar, IDownloadButtonClickListener iDownloadButtonClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener}) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, j, i2, downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener) { // from class: com.ss.android.downloadlib.g.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68826a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68827b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f68828c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f68829d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f68830e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ u f68831f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ IDownloadButtonClickListener f68832g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ g f68833h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j), Integer.valueOf(i2), downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68833h = this;
                    this.f68826a = str;
                    this.f68827b = j;
                    this.f68828c = i2;
                    this.f68829d = downloadEventConfig;
                    this.f68830e = downloadController;
                    this.f68831f = uVar;
                    this.f68832g = iDownloadButtonClickListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68833h.h().a(this.f68826a, this.f68827b, this.f68828c, this.f68829d, this.f68830e, this.f68831f, this.f68832g);
                    }
                }
            });
        }
    }

    @MainThread
    public void a(String str, long j, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), downloadEventConfig, downloadController}) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, j, i2, downloadEventConfig, downloadController) { // from class: com.ss.android.downloadlib.g.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68834a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68835b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f68836c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f68837d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f68838e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ g f68839f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j), Integer.valueOf(i2), downloadEventConfig, downloadController};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68839f = this;
                    this.f68834a = str;
                    this.f68835b = j;
                    this.f68836c = i2;
                    this.f68837d = downloadEventConfig;
                    this.f68838e = downloadController;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68839f.h().a(this.f68834a, this.f68835b, this.f68836c, this.f68837d, this.f68838e);
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68840a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f68841b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f68842c;

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
                    this.f68842c = this;
                    this.f68840a = str;
                    this.f68841b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68842c.h().a(this.f68840a, this.f68841b);
                    }
                }
            });
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f68816f : invokeV.longValue;
    }

    @MainThread
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, z) { // from class: com.ss.android.downloadlib.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68818a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f68819b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f68820c;

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
                    this.f68820c = this;
                    this.f68818a = str;
                    this.f68819b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68820c.h().a(this.f68818a, this.f68819b);
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

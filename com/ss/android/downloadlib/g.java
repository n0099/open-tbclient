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
    public static volatile g f68810a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.download.api.a f68811b;

    /* renamed from: c  reason: collision with root package name */
    public final f f68812c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.downloadad.api.a f68813d;

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.downloadad.api.b f68814e;

    /* renamed from: f  reason: collision with root package name */
    public long f68815f;

    /* JADX INFO: Access modifiers changed from: private */
    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? this.f68812c : (f) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f68815f = System.currentTimeMillis();
        }
    }

    public com.ss.android.downloadad.api.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f68813d : (com.ss.android.downloadad.api.a) invokeV.objValue;
    }

    public com.ss.android.downloadad.api.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f68814e == null) {
                this.f68814e = b.a();
            }
            return this.f68814e;
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
        this.f68812c = f.a();
        this.f68811b = new e();
        this.f68815f = System.currentTimeMillis();
        b(context);
        this.f68813d = a.a();
    }

    public static g a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f68810a == null) {
                synchronized (g.class) {
                    if (f68810a == null) {
                        com.ss.android.downloadlib.e.b.a(new Runnable(context) { // from class: com.ss.android.downloadlib.g.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Context f68816a;

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
                                this.f68816a = context;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    g unused = g.f68810a = new g(this.f68816a);
                                }
                            }
                        });
                    }
                }
            }
            return f68810a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68811b : (com.ss.android.download.api.a) invokeV.objValue;
    }

    @MainThread
    public void a(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, context, i2, downloadStatusChangeListener, downloadModel) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, context, i2, downloadStatusChangeListener, downloadModel) { // from class: com.ss.android.downloadlib.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f68820a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f68821b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusChangeListener f68822c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadModel f68823d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ g f68824e;

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
                    this.f68824e = this;
                    this.f68820a = context;
                    this.f68821b = i2;
                    this.f68822c = downloadStatusChangeListener;
                    this.f68823d = downloadModel;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68824e.h().a(this.f68820a, this.f68821b, this.f68822c, this.f68823d);
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
                public final /* synthetic */ String f68825a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68826b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f68827c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f68828d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f68829e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ u f68830f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ IDownloadButtonClickListener f68831g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ g f68832h;

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
                    this.f68832h = this;
                    this.f68825a = str;
                    this.f68826b = j;
                    this.f68827c = i2;
                    this.f68828d = downloadEventConfig;
                    this.f68829e = downloadController;
                    this.f68830f = uVar;
                    this.f68831g = iDownloadButtonClickListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68832h.h().a(this.f68825a, this.f68826b, this.f68827c, this.f68828d, this.f68829e, this.f68830f, this.f68831g);
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
                public final /* synthetic */ String f68833a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68834b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f68835c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f68836d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f68837e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ g f68838f;

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
                    this.f68838f = this;
                    this.f68833a = str;
                    this.f68834b = j;
                    this.f68835c = i2;
                    this.f68836d = downloadEventConfig;
                    this.f68837e = downloadController;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68838f.h().a(this.f68833a, this.f68834b, this.f68835c, this.f68836d, this.f68837e);
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
                public final /* synthetic */ String f68839a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f68840b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f68841c;

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
                    this.f68841c = this;
                    this.f68839a = str;
                    this.f68840b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68841c.h().a(this.f68839a, this.f68840b);
                    }
                }
            });
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f68815f : invokeV.longValue;
    }

    @MainThread
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, z) { // from class: com.ss.android.downloadlib.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68817a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f68818b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f68819c;

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
                    this.f68819c = this;
                    this.f68817a = str;
                    this.f68818b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68819c.h().a(this.f68817a, this.f68818b);
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

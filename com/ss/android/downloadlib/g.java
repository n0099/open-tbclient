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
    public static volatile g f69730a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.download.api.a f69731b;

    /* renamed from: c  reason: collision with root package name */
    public final f f69732c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.downloadad.api.a f69733d;

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.downloadad.api.b f69734e;

    /* renamed from: f  reason: collision with root package name */
    public long f69735f;

    /* JADX INFO: Access modifiers changed from: private */
    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? this.f69732c : (f) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f69735f = System.currentTimeMillis();
        }
    }

    public com.ss.android.downloadad.api.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f69733d : (com.ss.android.downloadad.api.a) invokeV.objValue;
    }

    public com.ss.android.downloadad.api.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f69734e == null) {
                this.f69734e = b.a();
            }
            return this.f69734e;
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
        this.f69732c = f.a();
        this.f69731b = new e();
        this.f69735f = System.currentTimeMillis();
        b(context);
        this.f69733d = a.a();
    }

    public static g a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f69730a == null) {
                synchronized (g.class) {
                    if (f69730a == null) {
                        com.ss.android.downloadlib.e.b.a(new Runnable(context) { // from class: com.ss.android.downloadlib.g.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Context f69736a;

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
                                this.f69736a = context;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    g unused = g.f69730a = new g(this.f69736a);
                                }
                            }
                        });
                    }
                }
            }
            return f69730a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69731b : (com.ss.android.download.api.a) invokeV.objValue;
    }

    @MainThread
    public void a(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, context, i2, downloadStatusChangeListener, downloadModel) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, context, i2, downloadStatusChangeListener, downloadModel) { // from class: com.ss.android.downloadlib.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f69740a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f69741b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusChangeListener f69742c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadModel f69743d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ g f69744e;

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
                    this.f69744e = this;
                    this.f69740a = context;
                    this.f69741b = i2;
                    this.f69742c = downloadStatusChangeListener;
                    this.f69743d = downloadModel;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69744e.h().a(this.f69740a, this.f69741b, this.f69742c, this.f69743d);
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
                public final /* synthetic */ String f69745a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f69746b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f69747c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f69748d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f69749e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ u f69750f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ IDownloadButtonClickListener f69751g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ g f69752h;

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
                    this.f69752h = this;
                    this.f69745a = str;
                    this.f69746b = j;
                    this.f69747c = i2;
                    this.f69748d = downloadEventConfig;
                    this.f69749e = downloadController;
                    this.f69750f = uVar;
                    this.f69751g = iDownloadButtonClickListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69752h.h().a(this.f69745a, this.f69746b, this.f69747c, this.f69748d, this.f69749e, this.f69750f, this.f69751g);
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
                public final /* synthetic */ String f69753a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f69754b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f69755c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f69756d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f69757e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ g f69758f;

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
                    this.f69758f = this;
                    this.f69753a = str;
                    this.f69754b = j;
                    this.f69755c = i2;
                    this.f69756d = downloadEventConfig;
                    this.f69757e = downloadController;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69758f.h().a(this.f69753a, this.f69754b, this.f69755c, this.f69756d, this.f69757e);
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
                public final /* synthetic */ String f69759a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f69760b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f69761c;

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
                    this.f69761c = this;
                    this.f69759a = str;
                    this.f69760b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69761c.h().a(this.f69759a, this.f69760b);
                    }
                }
            });
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f69735f : invokeV.longValue;
    }

    @MainThread
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            com.ss.android.downloadlib.e.b.a(new Runnable(this, str, z) { // from class: com.ss.android.downloadlib.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f69737a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f69738b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f69739c;

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
                    this.f69739c = this;
                    this.f69737a = str;
                    this.f69738b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69739c.h().a(this.f69737a, this.f69738b);
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

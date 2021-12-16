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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.download.api.a f61988b;

    /* renamed from: c  reason: collision with root package name */
    public final f f61989c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.downloadad.api.a f61990d;

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.downloadad.api.b f61991e;

    /* renamed from: f  reason: collision with root package name */
    public long f61992f;

    /* JADX INFO: Access modifiers changed from: private */
    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.f61989c : (f) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f61992f = System.currentTimeMillis();
        }
    }

    public com.ss.android.downloadad.api.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f61990d : (com.ss.android.downloadad.api.a) invokeV.objValue;
    }

    public com.ss.android.downloadad.api.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f61991e == null) {
                this.f61991e = b.a();
            }
            return this.f61991e;
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
        this.f61989c = f.a();
        this.f61988b = new e();
        this.f61992f = System.currentTimeMillis();
        b(context);
        this.f61990d = a.a();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61988b : (com.ss.android.download.api.a) invokeV.objValue;
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
                public final /* synthetic */ int f61995b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DownloadStatusChangeListener f61996c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadModel f61997d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ g f61998e;

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
                    this.f61998e = this;
                    this.a = context;
                    this.f61995b = i2;
                    this.f61996c = downloadStatusChangeListener;
                    this.f61997d = downloadModel;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61998e.h().a(this.a, this.f61995b, this.f61996c, this.f61997d);
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
                public final /* synthetic */ long f61999b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f62000c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f62001d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f62002e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ u f62003f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ IDownloadButtonClickListener f62004g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ g f62005h;

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
                    this.f62005h = this;
                    this.a = str;
                    this.f61999b = j2;
                    this.f62000c = i2;
                    this.f62001d = downloadEventConfig;
                    this.f62002e = downloadController;
                    this.f62003f = uVar;
                    this.f62004g = iDownloadButtonClickListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62005h.h().a(this.a, this.f61999b, this.f62000c, this.f62001d, this.f62002e, this.f62003f, this.f62004g);
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
                public final /* synthetic */ long f62006b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f62007c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DownloadEventConfig f62008d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadController f62009e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ g f62010f;

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
                    this.f62010f = this;
                    this.a = str;
                    this.f62006b = j2;
                    this.f62007c = i2;
                    this.f62008d = downloadEventConfig;
                    this.f62009e = downloadController;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62010f.h().a(this.a, this.f62006b, this.f62007c, this.f62008d, this.f62009e);
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
                public final /* synthetic */ int f62011b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f62012c;

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
                    this.f62012c = this;
                    this.a = str;
                    this.f62011b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62012c.h().a(this.a, this.f62011b);
                    }
                }
            });
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f61992f : invokeV.longValue;
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
                public final /* synthetic */ boolean f61993b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ g f61994c;

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
                    this.f61994c = this;
                    this.a = str;
                    this.f61993b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61994c.h().a(this.a, this.f61993b);
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

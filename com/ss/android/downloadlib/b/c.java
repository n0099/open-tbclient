package com.ss.android.downloadlib.b;

import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.a.a;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(com.ss.android.downloadad.api.a.b bVar, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bVar, aVar) == null) {
            boolean b2 = com.ss.android.socialbase.downloader.a.a.a().b();
            if (!b2 && Build.VERSION.SDK_INT >= 29) {
                l.b();
            }
            boolean b3 = com.ss.android.socialbase.downloader.a.a.a().b();
            if (!b2 && b3 && bVar != null) {
                bVar.l(true);
            }
            aVar.a();
            com.ss.android.socialbase.downloader.c.a.b("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + b3);
            if (b3) {
                return;
            }
            com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC2173a(bVar, aVar) { // from class: com.ss.android.downloadlib.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.downloadad.api.a.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadlib.guide.install.a f61934b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                    this.f61934b = aVar;
                }

                @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2173a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.socialbase.downloader.c.a.b("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                        com.ss.android.socialbase.downloader.a.a.a().b(this);
                        if (l.b(this.a)) {
                            return;
                        }
                        this.a.m(true);
                        com.ss.android.downloadlib.d.a.a().a("install_delay_invoke", this.a);
                        this.f61934b.a();
                    }
                }

                @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2173a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            });
        }
    }
}

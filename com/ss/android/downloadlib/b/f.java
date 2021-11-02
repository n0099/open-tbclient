package com.ss.android.downloadlib.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f68719a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1670992457, "Lcom/ss/android/downloadlib/b/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1670992457, "Lcom/ss/android/downloadlib/b/f;");
                return;
            }
        }
        f68719a = new Handler(Looper.getMainLooper());
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, i2) == null) || i2 <= 0) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable(bVar, i2) { // from class: com.ss.android.downloadlib.b.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.ss.android.downloadad.api.a.b f68724a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f68725b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68724a = bVar;
                this.f68725b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int i3 = 1;
                    if (l.c(this.f68724a.e())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!this.f68724a.aa()) {
                                i3 = 2;
                            }
                            jSONObject.putOpt("deeplink_source", Integer.valueOf(i3));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.d.a.a().a("deeplink_success_2", jSONObject, this.f68724a);
                        return;
                    }
                    f.b(this.f68724a, this.f68725b - 1);
                }
            }
        }, i(bVar) * 1000);
    }

    public static boolean c(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar)) == null) ? com.ss.android.downloadlib.g.e.a(bVar).b("app_link_opt_invoke_switch") == 1 : invokeL.booleanValue;
    }

    public static boolean d(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bVar)) == null) ? com.ss.android.downloadlib.g.e.a(bVar).b("app_link_opt_dialog_switch") == 1 : invokeL.booleanValue;
    }

    public static long e(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bVar)) == null) {
            if (bVar == null) {
                return 3000L;
            }
            return com.ss.android.downloadlib.g.e.a(bVar).a("app_link_opt_back_time_limit", 3) * 1000;
        }
        return invokeL.longValue;
    }

    public static long h(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bVar)) == null) ? com.ss.android.downloadlib.g.e.a(bVar).a("app_link_check_timeout", 300000L) : invokeL.longValue;
    }

    public static int i(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bVar)) == null) ? com.ss.android.downloadlib.g.e.a(bVar).a("app_link_check_delay", 1) : invokeL.intValue;
    }

    public static int j(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bVar)) == null) ? com.ss.android.downloadlib.g.e.a(bVar).a("app_link_check_count", 10) : invokeL.intValue;
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar, @NonNull h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bVar, hVar) == null) {
            boolean b2 = com.ss.android.socialbase.downloader.a.a.a().b();
            if (!b2 && Build.VERSION.SDK_INT >= 29) {
                l.b();
            }
            boolean b3 = com.ss.android.socialbase.downloader.a.a.a().b();
            boolean z = !b2 && b3;
            if (bVar != null) {
                bVar.l(z);
            }
            hVar.a(z);
            if (bVar == null) {
                return;
            }
            b(bVar, j(bVar));
            if (b3) {
                return;
            }
            com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC1983a(bVar, System.currentTimeMillis(), hVar) { // from class: com.ss.android.downloadlib.b.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadad.api.a.b f68720a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68721b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ h f68722c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, Long.valueOf(r7), hVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68720a = bVar;
                    this.f68721b = r7;
                    this.f68722c = hVar;
                }

                @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.ss.android.socialbase.downloader.a.a.a().b(this);
                        com.ss.android.downloadlib.d.a().a(new Runnable(this) { // from class: com.ss.android.downloadlib.b.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f68723a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f68723a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    boolean c2 = l.c(this.f68723a.f68720a.e());
                                    long e2 = f.e(this.f68723a.f68720a);
                                    if (!c2 || e2 >= System.currentTimeMillis() - this.f68723a.f68721b) {
                                        long h2 = f.h(this.f68723a.f68720a);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        AnonymousClass1 anonymousClass1 = this.f68723a;
                                        if (currentTimeMillis - anonymousClass1.f68721b > h2) {
                                            com.ss.android.downloadlib.d.a.a().a("deeplink_delay_timeout", this.f68723a.f68720a);
                                            return;
                                        }
                                        anonymousClass1.f68720a.l(true);
                                        com.ss.android.downloadlib.d.a.a().a("deeplink_delay_invoke", this.f68723a.f68720a);
                                        this.f68723a.f68722c.a(true);
                                        com.ss.android.downloadad.api.a.b bVar2 = this.f68723a.f68720a;
                                        f.b(bVar2, f.j(bVar2));
                                    }
                                }
                            }
                        });
                    }
                }

                @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            });
        }
    }

    public static boolean b(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar)) == null) ? com.ss.android.downloadlib.g.e.a(bVar).b("app_link_opt_install_switch") == 1 : invokeL.booleanValue;
    }

    public static boolean a(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? com.ss.android.downloadlib.g.e.a(bVar).b("app_link_opt_switch") == 1 : invokeL.booleanValue;
    }
}

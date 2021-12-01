package com.kwad.sdk.core.download.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.download.kwai.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.x;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-607230569, "Lcom/kwad/sdk/core/download/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-607230569, "Lcom/kwad/sdk/core/download/a/d;");
        }
    }

    public static int a(Context context, AdTemplate adTemplate, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, adTemplate, i2)) == null) {
            if (adTemplate == null || context == null) {
                return 0;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            String aJ = com.kwad.sdk.core.response.a.a.aJ(j2);
            String u = com.kwad.sdk.core.response.a.a.u(j2);
            int a2 = a(context, aJ);
            if (a2 == 1) {
                com.kwad.sdk.core.report.a.a(adTemplate, i2);
                a(context, aJ, u, adTemplate, i2);
            } else if (a2 == -1) {
                com.kwad.sdk.core.report.a.b(adTemplate, i2);
            }
            return a2;
        }
        return invokeLLI.intValue;
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return 0;
            }
            try {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setAction("android.intent.action.VIEW");
                parseUri.setFlags(268435456);
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 65536);
                if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    return 0;
                }
                context.startActivity(parseUri);
                return 1;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public static void a(Context context, String str, String str2, AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, adTemplate, Integer.valueOf(i2)}) == null) || a()) {
            return;
        }
        b(true);
        int d2 = x.a().d();
        int af = com.kwad.sdk.core.config.b.af();
        boolean z = af > 0 && com.kwad.sdk.core.config.b.ag();
        int abs = Math.abs(af);
        if (abs > 0) {
            ax.a(new Runnable(adTemplate, i2, context, z, d2, str, str2) { // from class: com.kwad.sdk.core.download.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f57374b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f57375c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ boolean f57376d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ int f57377e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f57378f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f57379g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {adTemplate, Integer.valueOf(i2), context, Boolean.valueOf(z), Integer.valueOf(d2), str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = adTemplate;
                    this.f57374b = i2;
                    this.f57375c = context;
                    this.f57376d = z;
                    this.f57377e = d2;
                    this.f57378f = str;
                    this.f57379g = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        d.b(false);
                        if (!x.a().b()) {
                            com.kwad.sdk.core.report.a.c(this.a, this.f57374b);
                            return;
                        }
                        int d3 = x.a().d();
                        Context context2 = this.f57375c;
                        if (context2 == null || !this.f57376d || d3 == 0 || d3 != this.f57377e) {
                            return;
                        }
                        d.b(context2, this.f57378f, this.f57379g, this.a);
                    }
                }
            }, null, abs * 1000);
        } else {
            b(false);
        }
    }

    public static void a(g.a aVar, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aVar, adTemplate) == null) {
            aVar.a().show();
            com.kwad.sdk.core.report.a.c(adTemplate, 158, null);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a : invokeV.booleanValue;
    }

    public static void b(Context context, String str, String str2, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, context, str, str2, adTemplate) == null) {
            g.a a2 = new g.a(Wrapper.wrapContextIfNeed(context)).a(String.format(Wrapper.wrapContextIfNeed(context).getString(R.string.ksad_deep_link_dialog_content), str2)).a(new g.b(adTemplate, context, str) { // from class: com.kwad.sdk.core.download.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdTemplate a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f57380b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f57381c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {adTemplate, context, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = adTemplate;
                    this.f57380b = context;
                    this.f57381c = str;
                }

                @Override // com.kwad.sdk.core.download.kwai.g.b
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.kwad.sdk.core.report.a.f(this.a, 159);
                        dialogInterface.dismiss();
                        ax.a(new Runnable(this) { // from class: com.kwad.sdk.core.download.a.d.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 a;

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
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass2 anonymousClass2 = this.a;
                                    d.a(anonymousClass2.f57380b, anonymousClass2.f57381c);
                                }
                            }
                        }, null, 100L);
                    }
                }

                @Override // com.kwad.sdk.core.download.kwai.g.b
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                        com.kwad.sdk.core.report.a.f(this.a, 160);
                        dialogInterface.dismiss();
                    }
                }

                @Override // com.kwad.sdk.core.download.kwai.g.b
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                    }
                }
            });
            if (context instanceof Activity) {
                if (((Activity) context).isFinishing()) {
                    return;
                }
            } else if (!(context instanceof ResContext)) {
                return;
            } else {
                ResContext resContext = (ResContext) context;
                if (!(resContext.getDelegatedContext() instanceof Activity) || ((Activity) resContext.getDelegatedContext()).isFinishing()) {
                    return;
                }
            }
            a(a2, adTemplate);
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            a = z;
        }
    }
}

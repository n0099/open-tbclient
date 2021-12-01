package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2015a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f57351b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f57352c;

        /* renamed from: d  reason: collision with root package name */
        public AdTemplate f57353d;

        /* renamed from: e  reason: collision with root package name */
        public b f57354e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f57355f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f57356g;

        /* renamed from: h  reason: collision with root package name */
        public int f57357h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f57358i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f57359j;

        /* renamed from: k  reason: collision with root package name */
        public p.a f57360k;
        public JSONObject l;
        public boolean m;

        public C2015a(Context context) {
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
            this.m = false;
            this.a = context;
        }

        public Context a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Context) invokeV.objValue;
        }

        public C2015a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f57357h = i2;
                return this;
            }
            return (C2015a) invokeI.objValue;
        }

        public C2015a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                this.f57354e = bVar;
                return this;
            }
            return (C2015a) invokeL.objValue;
        }

        public C2015a a(com.kwad.sdk.core.download.a.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
                this.f57355f = bVar;
                return this;
            }
            return (C2015a) invokeL.objValue;
        }

        public C2015a a(p.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
                this.f57360k = aVar;
                return this;
            }
            return (C2015a) invokeL.objValue;
        }

        public C2015a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adTemplate)) == null) {
                this.f57353d = adTemplate;
                return this;
            }
            return (C2015a) invokeL.objValue;
        }

        public C2015a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
                this.l = jSONObject;
                return this;
            }
            return (C2015a) invokeL.objValue;
        }

        public C2015a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f57356g = z;
                return this;
            }
            return (C2015a) invokeZ.objValue;
        }

        public C2015a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.f57358i = z;
                return this;
            }
            return (C2015a) invokeZ.objValue;
        }

        public AdTemplate b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f57353d : (AdTemplate) invokeV.objValue;
        }

        public C2015a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.f57359j = z;
                return this;
            }
            return (C2015a) invokeZ.objValue;
        }

        public b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f57354e : (b) invokeV.objValue;
        }

        public C2015a d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.m = z;
                return this;
            }
            return (C2015a) invokeZ.objValue;
        }

        public com.kwad.sdk.core.download.a.b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f57355f : (com.kwad.sdk.core.download.a.b) invokeV.objValue;
        }

        public C2015a e(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.f57352c = z;
                return this;
            }
            return (C2015a) invokeZ.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f57356g : invokeV.booleanValue;
        }

        public C2015a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
                this.f57351b = z;
                return this;
            }
            return (C2015a) invokeZ.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f57358i : invokeV.booleanValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f57357h : invokeV.intValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f57359j : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.m : invokeV.booleanValue;
        }

        public JSONObject j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.l : (JSONObject) invokeV.objValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f57352c : invokeV.booleanValue;
        }

        public boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f57351b : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, adTemplate, bVar, bVar2, Boolean.valueOf(z)})) == null) ? a(new C2015a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false)) : invokeCommon.intValue;
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, adTemplate, bVar, bVar2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            com.kwad.sdk.home.download.a.a().a(true);
            if (d.a(context, adTemplate, 1) == 1) {
                bVar.a();
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.B(j2)) {
                bVar.a();
                if (com.kwad.sdk.utils.f.a(context, com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2))) {
                    com.kwad.sdk.core.report.a.k(adTemplate);
                } else {
                    AdWebViewActivityProxy.launch(context, adTemplate);
                }
                return 0;
            } else if (bVar2 != null) {
                int a = bVar2.a(new C2015a(context).a(z).a(adTemplate).b(z2).d(false));
                int i2 = j2.status;
                if (i2 != 2 && i2 != 3) {
                    bVar.a();
                }
                return a;
            } else {
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    public static int a(C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c2015a)) == null) {
            if (c2015a.l()) {
                a(c2015a.a(), c2015a.b(), c2015a.c(), c2015a.d(), c2015a.f57356g, c2015a.f());
                return 0;
            } else if (com.kwad.sdk.core.download.a.b.c(c2015a) == 3) {
                return 0;
            } else {
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(c2015a.b());
                com.kwad.sdk.home.download.a.a().a(true);
                if (d.a(c2015a.a(), c2015a.b(), 1) == 1) {
                    c(c2015a);
                    return 0;
                } else if (c2015a.k() && (!com.kwad.sdk.core.response.a.a.B(j2) || g(c2015a))) {
                    c(c2015a);
                    f(c2015a);
                    return 0;
                } else if (!com.kwad.sdk.core.response.a.a.B(j2)) {
                    if (c2015a.b().isWebViewDownload) {
                        return e(c2015a);
                    }
                    boolean a = com.kwad.sdk.utils.f.a(c2015a.a(), com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2));
                    c(c2015a);
                    if (a) {
                        com.kwad.sdk.core.report.a.k(c2015a.b());
                        return 0;
                    }
                    AdWebViewActivityProxy.launch(c2015a.a(), c2015a.b());
                    return 0;
                } else {
                    if (com.kwad.sdk.core.response.a.a.B(j2)) {
                        if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                            c2015a.d(false);
                            c(c2015a);
                        } else {
                            c(c2015a);
                            if (!b(c2015a)) {
                                c2015a.d(true);
                            }
                        }
                        return e(c2015a);
                    }
                    return 0;
                }
            }
        }
        return invokeL.intValue;
    }

    public static boolean b(C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c2015a)) == null) {
            AdTemplate b2 = c2015a.b();
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
            if (!c2015a.k() || !com.kwad.sdk.core.response.a.a.V(j2) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j2)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c2015a.d().d()) {
                return false;
            }
            AdWebViewVideoActivityProxy.launch(c2015a.a(), b2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(C2015a c2015a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c2015a) == null) {
            d(c2015a);
            if (c2015a.c() != null) {
                c2015a.c().a();
            }
        }
    }

    public static void d(C2015a c2015a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, c2015a) == null) && c2015a.h()) {
            com.kwad.sdk.core.report.a.a(c2015a.f57353d, c2015a.f57360k, c2015a.j());
        }
    }

    public static int e(C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, c2015a)) == null) {
            com.kwad.sdk.core.download.a.b d2 = c2015a.d();
            if (d2 == null) {
                d2 = new com.kwad.sdk.core.download.a.b(c2015a.f57353d);
                c2015a.a(d2);
            }
            return d2.a(c2015a);
        }
        return invokeL.intValue;
    }

    public static void f(C2015a c2015a) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, c2015a) == null) {
            AdTemplate b2 = c2015a.b();
            Context a = c2015a.a();
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
            if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2))) {
                com.kwad.sdk.core.report.a.k(b2);
                return;
            }
            if (g(c2015a)) {
                i2 = 4;
            } else if (com.kwad.sdk.core.response.a.a.V(j2) && !b2.mAdWebVideoPageShowing) {
                AdWebViewVideoActivityProxy.launch(a, b2);
                return;
            } else {
                i2 = 0;
            }
            AdWebViewActivityProxy.launch(a, b2, i2);
        }
    }

    public static boolean g(C2015a c2015a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c2015a)) == null) {
            AdTemplate b2 = c2015a.b();
            return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
        }
        return invokeL.booleanValue;
    }
}

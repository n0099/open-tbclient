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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2076a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f57932b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f57933c;

        /* renamed from: d  reason: collision with root package name */
        public AdTemplate f57934d;

        /* renamed from: e  reason: collision with root package name */
        public b f57935e;

        /* renamed from: f  reason: collision with root package name */
        public com.kwad.sdk.core.download.a.b f57936f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f57937g;

        /* renamed from: h  reason: collision with root package name */
        public int f57938h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f57939i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f57940j;

        /* renamed from: k  reason: collision with root package name */
        public p.a f57941k;
        public JSONObject l;
        public boolean m;

        public C2076a(Context context) {
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

        public C2076a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.f57938h = i2;
                return this;
            }
            return (C2076a) invokeI.objValue;
        }

        public C2076a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                this.f57935e = bVar;
                return this;
            }
            return (C2076a) invokeL.objValue;
        }

        public C2076a a(com.kwad.sdk.core.download.a.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
                this.f57936f = bVar;
                return this;
            }
            return (C2076a) invokeL.objValue;
        }

        public C2076a a(p.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
                this.f57941k = aVar;
                return this;
            }
            return (C2076a) invokeL.objValue;
        }

        public C2076a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adTemplate)) == null) {
                this.f57934d = adTemplate;
                return this;
            }
            return (C2076a) invokeL.objValue;
        }

        public C2076a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
                this.l = jSONObject;
                return this;
            }
            return (C2076a) invokeL.objValue;
        }

        public C2076a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.f57937g = z;
                return this;
            }
            return (C2076a) invokeZ.objValue;
        }

        public C2076a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.f57939i = z;
                return this;
            }
            return (C2076a) invokeZ.objValue;
        }

        public AdTemplate b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f57934d : (AdTemplate) invokeV.objValue;
        }

        public C2076a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.f57940j = z;
                return this;
            }
            return (C2076a) invokeZ.objValue;
        }

        public b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f57935e : (b) invokeV.objValue;
        }

        public C2076a d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.m = z;
                return this;
            }
            return (C2076a) invokeZ.objValue;
        }

        public com.kwad.sdk.core.download.a.b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f57936f : (com.kwad.sdk.core.download.a.b) invokeV.objValue;
        }

        public C2076a e(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.f57933c = z;
                return this;
            }
            return (C2076a) invokeZ.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f57937g : invokeV.booleanValue;
        }

        public C2076a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
                this.f57932b = z;
                return this;
            }
            return (C2076a) invokeZ.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f57939i : invokeV.booleanValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f57938h : invokeV.intValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f57940j : invokeV.booleanValue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f57933c : invokeV.booleanValue;
        }

        public boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f57932b : invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.sdk.core.download.a.b bVar2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, adTemplate, bVar, bVar2, Boolean.valueOf(z)})) == null) ? a(new C2076a(context).a(adTemplate).a(bVar).a(bVar2).a(z).b(false)) : invokeCommon.intValue;
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
                int a = bVar2.a(new C2076a(context).a(z).a(adTemplate).b(z2).d(false));
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

    public static int a(C2076a c2076a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c2076a)) == null) {
            if (c2076a.l()) {
                a(c2076a.a(), c2076a.b(), c2076a.c(), c2076a.d(), c2076a.f57937g, c2076a.f());
                return 0;
            } else if (com.kwad.sdk.core.download.a.b.c(c2076a) == 3) {
                return 0;
            } else {
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(c2076a.b());
                com.kwad.sdk.home.download.a.a().a(true);
                if (d.a(c2076a.a(), c2076a.b(), 1) == 1) {
                    c(c2076a);
                    return 0;
                } else if (c2076a.k() && (!com.kwad.sdk.core.response.a.a.B(j2) || g(c2076a))) {
                    c(c2076a);
                    f(c2076a);
                    return 0;
                } else if (!com.kwad.sdk.core.response.a.a.B(j2)) {
                    if (c2076a.b().isWebViewDownload) {
                        return e(c2076a);
                    }
                    boolean a = com.kwad.sdk.utils.f.a(c2076a.a(), com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2));
                    c(c2076a);
                    if (a) {
                        com.kwad.sdk.core.report.a.k(c2076a.b());
                        return 0;
                    }
                    AdWebViewActivityProxy.launch(c2076a.a(), c2076a.b());
                    return 0;
                } else {
                    if (com.kwad.sdk.core.response.a.a.B(j2)) {
                        if (AdWebViewLandPageActivityProxy.showingAdWebViewLandPage || com.kwad.sdk.core.download.kwai.b.a()) {
                            c2076a.d(false);
                            c(c2076a);
                        } else {
                            c(c2076a);
                            if (!b(c2076a)) {
                                c2076a.d(true);
                            }
                        }
                        return e(c2076a);
                    }
                    return 0;
                }
            }
        }
        return invokeL.intValue;
    }

    public static boolean b(C2076a c2076a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c2076a)) == null) {
            AdTemplate b2 = c2076a.b();
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
            if (!c2076a.k() || !com.kwad.sdk.core.response.a.a.V(j2) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.G(j2)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c2076a.d().d()) {
                return false;
            }
            AdWebViewVideoActivityProxy.launch(c2076a.a(), b2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(C2076a c2076a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c2076a) == null) {
            d(c2076a);
            if (c2076a.c() != null) {
                c2076a.c().a();
            }
        }
    }

    public static void d(C2076a c2076a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, c2076a) == null) && c2076a.h()) {
            com.kwad.sdk.core.report.a.a(c2076a.f57934d, c2076a.f57941k, c2076a.j());
        }
    }

    public static int e(C2076a c2076a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, c2076a)) == null) {
            com.kwad.sdk.core.download.a.b d2 = c2076a.d();
            if (d2 == null) {
                d2 = new com.kwad.sdk.core.download.a.b(c2076a.f57934d);
                c2076a.a(d2);
            }
            return d2.a(c2076a);
        }
        return invokeL.intValue;
    }

    public static void f(C2076a c2076a) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, c2076a) == null) {
            AdTemplate b2 = c2076a.b();
            Context a = c2076a.a();
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(b2);
            if (com.kwad.sdk.utils.f.a(a, com.kwad.sdk.core.response.a.a.aL(j2), com.kwad.sdk.core.response.a.a.v(j2))) {
                com.kwad.sdk.core.report.a.k(b2);
                return;
            }
            if (g(c2076a)) {
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

    public static boolean g(C2076a c2076a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c2076a)) == null) {
            AdTemplate b2 = c2076a.b();
            return com.kwad.sdk.core.response.a.b.j(b2) && !b2.interactLandingPageShowing;
        }
        return invokeL.booleanValue;
    }
}

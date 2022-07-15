package com.kwad.components.core.c.a;

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
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.core.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0507a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public boolean b;
        public boolean c;
        public AdTemplate d;
        public b e;
        public com.kwad.components.core.c.a.b f;
        public boolean g;
        public long h;
        public int i;
        public boolean j;
        public boolean k;
        public u.b l;
        public JSONObject m;
        public boolean n;
        public boolean o;
        public int p;
        public int q;

        public C0507a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = false;
            this.a = context;
        }

        public final Context a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Context) invokeV.objValue;
        }

        public final C0507a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.i = i;
                return this;
            }
            return (C0507a) invokeI.objValue;
        }

        public final C0507a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.h = j;
                return this;
            }
            return (C0507a) invokeJ.objValue;
        }

        public final C0507a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
                this.e = bVar;
                return this;
            }
            return (C0507a) invokeL.objValue;
        }

        public final C0507a a(com.kwad.components.core.c.a.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
                this.f = bVar;
                return this;
            }
            return (C0507a) invokeL.objValue;
        }

        public final C0507a a(u.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
                this.l = bVar;
                return this;
            }
            return (C0507a) invokeL.objValue;
        }

        public final C0507a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, adTemplate)) == null) {
                this.d = adTemplate;
                return this;
            }
            return (C0507a) invokeL.objValue;
        }

        public final C0507a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
                this.m = jSONObject;
                return this;
            }
            return (C0507a) invokeL.objValue;
        }

        public final C0507a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.g = z;
                return this;
            }
            return (C0507a) invokeZ.objValue;
        }

        public final C0507a b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.p = i;
                return this;
            }
            return (C0507a) invokeI.objValue;
        }

        public final C0507a b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.j = z;
                return this;
            }
            return (C0507a) invokeZ.objValue;
        }

        public final AdTemplate b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : (AdTemplate) invokeV.objValue;
        }

        public final C0507a c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.q = i;
                return this;
            }
            return (C0507a) invokeI.objValue;
        }

        public final C0507a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.k = z;
                return this;
            }
            return (C0507a) invokeZ.objValue;
        }

        public final b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.e : (b) invokeV.objValue;
        }

        public final C0507a d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.n = z;
                return this;
            }
            return (C0507a) invokeZ.objValue;
        }

        public final com.kwad.components.core.c.a.b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f : (com.kwad.components.core.c.a.b) invokeV.objValue;
        }

        public final C0507a e(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                this.c = z;
                return this;
            }
            return (C0507a) invokeZ.objValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.g : invokeV.booleanValue;
        }

        public final long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.h : invokeV.longValue;
        }

        public final C0507a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
                this.b = z;
                return this;
            }
            return (C0507a) invokeZ.objValue;
        }

        public final C0507a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
                this.o = z;
                return this;
            }
            return (C0507a) invokeZ.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.j : invokeV.booleanValue;
        }

        public final int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.i : invokeV.intValue;
        }

        public final boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : invokeV.booleanValue;
        }

        public final u.b j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.l : (u.b) invokeV.objValue;
        }

        public final boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.n : invokeV.booleanValue;
        }

        public final JSONObject l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.m : (JSONObject) invokeV.objValue;
        }

        public final boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.c : invokeV.booleanValue;
        }

        public final boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.b : invokeV.booleanValue;
        }

        public final boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.o : invokeV.booleanValue;
        }

        public final int p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.p : invokeV.intValue;
        }

        public final int q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.q : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable com.kwad.components.core.c.a.b bVar2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, adTemplate, bVar, bVar2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
            if (c.a(new C0507a(context).a(adTemplate), 1) == 1) {
                bVar.a();
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.I(i)) {
                bVar.a();
                if (com.kwad.sdk.utils.d.a(context, com.kwad.sdk.core.response.a.a.be(i), com.kwad.sdk.core.response.a.a.C(i))) {
                    com.kwad.sdk.core.report.a.f(adTemplate, 0);
                } else {
                    AdWebViewActivityProxy.launch(context, adTemplate);
                }
                return 0;
            } else if (bVar2 != null) {
                int a = bVar2.a(new C0507a(context).a(z).a(adTemplate).b(z2).d(false));
                int i2 = i.status;
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

    public static int a(C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0507a)) == null) {
            if (c0507a.n()) {
                a(c0507a.a(), c0507a.b(), c0507a.c(), c0507a.d(), c0507a.g, c0507a.g());
                return 0;
            } else if (b(c0507a)) {
                return 0;
            } else {
                AdInfo i = com.kwad.sdk.core.response.a.d.i(c0507a.b());
                com.kwad.sdk.components.c.a(com.kwad.components.kwai.kwai.a.class);
                if (c.a(c0507a, 1) == 1) {
                    if (com.kwad.sdk.core.response.a.a.bb(i)) {
                        com.kwad.sdk.core.report.a.h(c0507a.b(), (int) Math.ceil(((float) c0507a.f()) / 1000.0f));
                    }
                    e(c0507a);
                    return 0;
                } else if (d.a(c0507a.a(), c0507a.b())) {
                    e(c0507a);
                    return 0;
                } else if (c0507a.m() && (!com.kwad.sdk.core.response.a.a.I(i) || i(c0507a))) {
                    e(c0507a);
                    h(c0507a);
                    return 0;
                } else if (!com.kwad.sdk.core.response.a.a.I(i)) {
                    if (c0507a.b().isWebViewDownload) {
                        return g(c0507a);
                    }
                    boolean a = com.kwad.sdk.utils.d.a(c0507a.a(), com.kwad.sdk.core.response.a.a.be(i), com.kwad.sdk.core.response.a.a.C(i));
                    e(c0507a);
                    if (a) {
                        com.kwad.sdk.core.report.a.f(c0507a.b(), 0);
                        return 0;
                    }
                    AdWebViewActivityProxy.launch(c0507a.a(), c0507a.b());
                    return 0;
                } else {
                    if (com.kwad.sdk.core.response.a.a.I(i)) {
                        if (c0507a.q() == 2 || c0507a.q() == 1) {
                            c0507a.d(false);
                            e(c0507a);
                        } else {
                            e(c0507a);
                            if (!c(c0507a)) {
                                c0507a.d(true);
                            }
                        }
                        return g(c0507a);
                    }
                    return 0;
                }
            }
        }
        return invokeL.intValue;
    }

    public static boolean b(C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0507a)) == null) ? com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(c0507a.b())) ? !c0507a.o() && com.kwad.components.core.c.a.b.b(c0507a) == 3 : d(c0507a) == 1 : invokeL.booleanValue;
    }

    public static boolean c(C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c0507a)) == null) {
            AdTemplate b2 = c0507a.b();
            AdInfo i = com.kwad.sdk.core.response.a.d.i(b2);
            if (!c0507a.m() || !com.kwad.sdk.core.response.a.a.a(i, com.kwad.sdk.core.config.d.x()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.N(i)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0507a.d().d()) {
                return false;
            }
            AdWebViewVideoActivityProxy.launch(c0507a.a(), b2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int d(C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c0507a)) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(c0507a.b());
            if (i.unDownloadConf.unDownloadRegionConf != null) {
                int h = c0507a.h();
                return h != 2 ? h != 3 ? i.unDownloadConf.unDownloadRegionConf.actionBarType : i.unDownloadConf.unDownloadRegionConf.materialJumpType : i.unDownloadConf.unDownloadRegionConf.describeBarType;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void e(C0507a c0507a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, c0507a) == null) {
            f(c0507a);
            if (c0507a.c() != null) {
                c0507a.c().a();
            }
        }
    }

    public static void f(C0507a c0507a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, c0507a) == null) && c0507a.i()) {
            com.kwad.sdk.core.report.a.a(c0507a.d, c0507a.l, c0507a.l());
        }
    }

    public static int g(C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, c0507a)) == null) {
            com.kwad.components.core.c.a.b d = c0507a.d();
            if (d == null) {
                d = new com.kwad.components.core.c.a.b(c0507a.d);
                c0507a.a(d);
            }
            return d.a(c0507a);
        }
        return invokeL.intValue;
    }

    public static void h(C0507a c0507a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, c0507a) == null) {
            AdTemplate b2 = c0507a.b();
            Context a = c0507a.a();
            AdInfo i = com.kwad.sdk.core.response.a.d.i(b2);
            if (com.kwad.sdk.utils.d.a(a, com.kwad.sdk.core.response.a.a.be(i), com.kwad.sdk.core.response.a.a.C(i))) {
                com.kwad.sdk.core.report.a.f(b2, 0);
            } else if (i(c0507a)) {
                AdWebViewActivityProxy.launch(a, b2, 4);
            } else if (!com.kwad.sdk.core.response.a.a.a(i, com.kwad.sdk.core.config.d.x()) || b2.mAdWebVideoPageShowing) {
                AdWebViewActivityProxy.launch(a, b2, 0);
            } else {
                AdWebViewVideoActivityProxy.launch(a, b2);
            }
        }
    }

    public static boolean i(C0507a c0507a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c0507a)) == null) {
            AdTemplate b2 = c0507a.b();
            return com.kwad.sdk.core.response.a.b.o(b2) && !b2.interactLandingPageShowing;
        }
        return invokeL.booleanValue;
    }
}

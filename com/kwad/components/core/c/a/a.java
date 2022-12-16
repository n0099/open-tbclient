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
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.core.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0594a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean DS;
        public boolean DT;
        public b DU;
        public c DV;
        public boolean DW;
        public long DX;
        public boolean DY;
        public boolean DZ;
        public u.b Ea;
        public JSONObject Eb;
        public boolean Ec;
        public boolean Ed;
        public int Ee;
        public int Ef;
        public AdTemplate adTemplate;
        public final Context context;
        public int gH;

        public C0594a(Context context) {
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
            this.Ec = false;
            this.context = context;
        }

        public final C0594a L(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
                this.adTemplate = adTemplate;
                return this;
            }
            return (C0594a) invokeL.objValue;
        }

        public final C0594a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.DU = bVar;
                return this;
            }
            return (C0594a) invokeL.objValue;
        }

        public final C0594a a(u.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                this.Ea = bVar;
                return this;
            }
            return (C0594a) invokeL.objValue;
        }

        public final C0594a ae(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.gH = i;
                return this;
            }
            return (C0594a) invokeI.objValue;
        }

        public final C0594a af(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.Ee = i;
                return this;
            }
            return (C0594a) invokeI.objValue;
        }

        public final C0594a ag(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.Ef = i;
                return this;
            }
            return (C0594a) invokeI.objValue;
        }

        public final C0594a aj(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.DW = z;
                return this;
            }
            return (C0594a) invokeZ.objValue;
        }

        public final C0594a ak(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.DY = z;
                return this;
            }
            return (C0594a) invokeZ.objValue;
        }

        public final C0594a al(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.DZ = z;
                return this;
            }
            return (C0594a) invokeZ.objValue;
        }

        public final C0594a am(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.Ec = z;
                return this;
            }
            return (C0594a) invokeZ.objValue;
        }

        public final C0594a an(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.DT = z;
                return this;
            }
            return (C0594a) invokeZ.objValue;
        }

        public final C0594a ao(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.DS = z;
                return this;
            }
            return (C0594a) invokeZ.objValue;
        }

        public final C0594a ap(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.Ed = z;
                return this;
            }
            return (C0594a) invokeZ.objValue;
        }

        public final C0594a b(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cVar)) == null) {
                this.DV = cVar;
                return this;
            }
            return (C0594a) invokeL.objValue;
        }

        public final C0594a c(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jSONObject)) == null) {
                this.Eb = jSONObject;
                return this;
            }
            return (C0594a) invokeL.objValue;
        }

        public final int cC() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.gH : invokeV.intValue;
        }

        public final JSONObject gP() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.Eb : (JSONObject) invokeV.objValue;
        }

        public final AdTemplate getAdTemplate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.adTemplate : (AdTemplate) invokeV.objValue;
        }

        public final c getApkDownloadHelper() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.DV : (c) invokeV.objValue;
        }

        public final u.b getClientParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.Ea : (u.b) invokeV.objValue;
        }

        public final Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.context : (Context) invokeV.objValue;
        }

        public final C0594a l(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
                this.DX = j;
                return this;
            }
            return (C0594a) invokeJ.objValue;
        }

        public final boolean mA() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.DZ : invokeV.booleanValue;
        }

        public final boolean mB() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.Ec : invokeV.booleanValue;
        }

        public final boolean mC() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.DT : invokeV.booleanValue;
        }

        public final boolean mD() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.DS : invokeV.booleanValue;
        }

        public final boolean mE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.Ed : invokeV.booleanValue;
        }

        public final int mF() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.Ee : invokeV.intValue;
        }

        public final int mG() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.Ef : invokeV.intValue;
        }

        public final b mw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.DU : (b) invokeV.objValue;
        }

        public final boolean mx() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.DW : invokeV.booleanValue;
        }

        public final long my() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.DX : invokeV.longValue;
        }

        public final boolean mz() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.DY : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, adTemplate, bVar, cVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            adTemplate.converted = true;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            if (d.a(new C0594a(context).L(adTemplate), 1) == 1) {
                bVar.onAdClicked();
                return 0;
            } else if (!com.kwad.sdk.core.response.a.a.am(bQ)) {
                bVar.onAdClicked();
                if (com.kwad.sdk.utils.d.e(context, com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ))) {
                    com.kwad.sdk.core.report.a.m(adTemplate, 0);
                } else {
                    AdWebViewActivityProxy.launch(context, adTemplate);
                }
                return 0;
            } else if (cVar != null) {
                int m = cVar.m(new C0594a(context).aj(z).L(adTemplate).ak(z2).am(false));
                int i = bQ.status;
                if (i != 2 && i != 3) {
                    bVar.onAdClicked();
                }
                return m;
            } else {
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    public static int a(C0594a c0594a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0594a)) == null) {
            c0594a.getAdTemplate().converted = true;
            if (c0594a.mD()) {
                a(c0594a.getContext(), c0594a.getAdTemplate(), c0594a.mw(), c0594a.getApkDownloadHelper(), c0594a.DW, c0594a.mz());
                return 0;
            } else if (b(c0594a)) {
                return 0;
            } else {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0594a.getAdTemplate());
                com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                if (d.a(c0594a, 1) == 1) {
                    if (com.kwad.sdk.core.response.a.a.bK(bQ)) {
                        com.kwad.sdk.core.report.a.o(c0594a.getAdTemplate(), (int) Math.ceil(((float) c0594a.my()) / 1000.0f));
                    }
                    e(c0594a);
                    return 0;
                } else if (e.d(c0594a.getContext(), c0594a.getAdTemplate())) {
                    e(c0594a);
                    return 0;
                } else if (c0594a.mC() && (!com.kwad.sdk.core.response.a.a.am(bQ) || i(c0594a))) {
                    e(c0594a);
                    h(c0594a);
                    return 0;
                } else if (!com.kwad.sdk.core.response.a.a.am(bQ)) {
                    if (c0594a.getAdTemplate().isWebViewDownload) {
                        return g(c0594a);
                    }
                    boolean e = com.kwad.sdk.utils.d.e(c0594a.getContext(), com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ));
                    e(c0594a);
                    if (e) {
                        com.kwad.sdk.core.report.a.m(c0594a.getAdTemplate(), 0);
                        return 0;
                    }
                    AdWebViewActivityProxy.launch(c0594a.getContext(), c0594a.getAdTemplate());
                    return 0;
                } else {
                    if (com.kwad.sdk.core.response.a.a.am(bQ)) {
                        if (c0594a.mG() == 2 || c0594a.mG() == 1) {
                            c0594a.am(false);
                            e(c0594a);
                        } else {
                            e(c0594a);
                            if (!c(c0594a)) {
                                c0594a.am(true);
                            }
                        }
                        return g(c0594a);
                    }
                    return 0;
                }
            }
        }
        return invokeL.intValue;
    }

    public static boolean b(C0594a c0594a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0594a)) == null) ? com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(c0594a.getAdTemplate())) ? !c0594a.mE() && c.s(c0594a) == 3 : d(c0594a) == 1 : invokeL.booleanValue;
    }

    public static boolean c(C0594a c0594a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c0594a)) == null) {
            AdTemplate adTemplate = c0594a.getAdTemplate();
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if (!c0594a.mC() || !com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ar(bQ)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0594a.getApkDownloadHelper().mO()) {
                return false;
            }
            AdWebViewVideoActivityProxy.launch(c0594a.getContext(), adTemplate);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int d(C0594a c0594a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c0594a)) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0594a.getAdTemplate());
            if (bQ.unDownloadConf.unDownloadRegionConf != null) {
                int cC = c0594a.cC();
                return cC != 2 ? cC != 3 ? bQ.unDownloadConf.unDownloadRegionConf.actionBarType : bQ.unDownloadConf.unDownloadRegionConf.materialJumpType : bQ.unDownloadConf.unDownloadRegionConf.describeBarType;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void e(C0594a c0594a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, c0594a) == null) {
            f(c0594a);
            if (c0594a.mw() != null) {
                c0594a.mw().onAdClicked();
            }
        }
    }

    public static void f(C0594a c0594a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, c0594a) == null) && c0594a.mA()) {
            com.kwad.sdk.core.report.a.a(c0594a.adTemplate, c0594a.Ea, c0594a.gP());
        }
    }

    public static int g(C0594a c0594a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, c0594a)) == null) {
            c apkDownloadHelper = c0594a.getApkDownloadHelper();
            if (apkDownloadHelper == null) {
                apkDownloadHelper = new c(c0594a.adTemplate);
                c0594a.b(apkDownloadHelper);
            }
            return apkDownloadHelper.m(c0594a);
        }
        return invokeL.intValue;
    }

    public static void h(C0594a c0594a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, c0594a) == null) {
            AdTemplate adTemplate = c0594a.getAdTemplate();
            Context context = c0594a.getContext();
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if (com.kwad.sdk.utils.d.e(context, com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ))) {
                com.kwad.sdk.core.report.a.m(adTemplate, 0);
            } else if (i(c0594a)) {
                AdWebViewActivityProxy.launch(context, adTemplate, 4);
            } else if (!com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || adTemplate.mAdWebVideoPageShowing) {
                AdWebViewActivityProxy.launch(context, adTemplate, 0);
            } else {
                AdWebViewVideoActivityProxy.launch(context, adTemplate);
            }
        }
    }

    public static boolean i(C0594a c0594a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c0594a)) == null) {
            AdTemplate adTemplate = c0594a.getAdTemplate();
            return com.kwad.sdk.core.response.a.b.bg(adTemplate) && !adTemplate.interactLandingPageShowing;
        }
        return invokeL.booleanValue;
    }
}

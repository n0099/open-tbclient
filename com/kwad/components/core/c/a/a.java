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
    public static class C0352a {
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

        public C0352a(Context context) {
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

        public final C0352a L(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
                this.adTemplate = adTemplate;
                return this;
            }
            return (C0352a) invokeL.objValue;
        }

        public final C0352a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.DU = bVar;
                return this;
            }
            return (C0352a) invokeL.objValue;
        }

        public final C0352a a(u.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                this.Ea = bVar;
                return this;
            }
            return (C0352a) invokeL.objValue;
        }

        public final C0352a ae(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.gH = i;
                return this;
            }
            return (C0352a) invokeI.objValue;
        }

        public final C0352a af(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.Ee = i;
                return this;
            }
            return (C0352a) invokeI.objValue;
        }

        public final C0352a ag(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.Ef = i;
                return this;
            }
            return (C0352a) invokeI.objValue;
        }

        public final C0352a aj(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.DW = z;
                return this;
            }
            return (C0352a) invokeZ.objValue;
        }

        public final C0352a ak(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.DY = z;
                return this;
            }
            return (C0352a) invokeZ.objValue;
        }

        public final C0352a al(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.DZ = z;
                return this;
            }
            return (C0352a) invokeZ.objValue;
        }

        public final C0352a am(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.Ec = z;
                return this;
            }
            return (C0352a) invokeZ.objValue;
        }

        public final C0352a an(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.DT = z;
                return this;
            }
            return (C0352a) invokeZ.objValue;
        }

        public final C0352a ao(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.DS = z;
                return this;
            }
            return (C0352a) invokeZ.objValue;
        }

        public final C0352a ap(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.Ed = z;
                return this;
            }
            return (C0352a) invokeZ.objValue;
        }

        public final C0352a b(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cVar)) == null) {
                this.DV = cVar;
                return this;
            }
            return (C0352a) invokeL.objValue;
        }

        public final C0352a c(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jSONObject)) == null) {
                this.Eb = jSONObject;
                return this;
            }
            return (C0352a) invokeL.objValue;
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

        public final C0352a l(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
                this.DX = j;
                return this;
            }
            return (C0352a) invokeJ.objValue;
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

    /* loaded from: classes5.dex */
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
            if (d.a(new C0352a(context).L(adTemplate), 1) == 1) {
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
                int m = cVar.m(new C0352a(context).aj(z).L(adTemplate).ak(z2).am(false));
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

    public static int a(C0352a c0352a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0352a)) == null) {
            c0352a.getAdTemplate().converted = true;
            if (c0352a.mD()) {
                a(c0352a.getContext(), c0352a.getAdTemplate(), c0352a.mw(), c0352a.getApkDownloadHelper(), c0352a.DW, c0352a.mz());
                return 0;
            } else if (b(c0352a)) {
                return 0;
            } else {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0352a.getAdTemplate());
                com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                if (d.a(c0352a, 1) == 1) {
                    if (com.kwad.sdk.core.response.a.a.bK(bQ)) {
                        com.kwad.sdk.core.report.a.o(c0352a.getAdTemplate(), (int) Math.ceil(((float) c0352a.my()) / 1000.0f));
                    }
                    e(c0352a);
                    return 0;
                } else if (e.d(c0352a.getContext(), c0352a.getAdTemplate())) {
                    e(c0352a);
                    return 0;
                } else if (c0352a.mC() && (!com.kwad.sdk.core.response.a.a.am(bQ) || i(c0352a))) {
                    e(c0352a);
                    h(c0352a);
                    return 0;
                } else if (!com.kwad.sdk.core.response.a.a.am(bQ)) {
                    if (c0352a.getAdTemplate().isWebViewDownload) {
                        return g(c0352a);
                    }
                    boolean e = com.kwad.sdk.utils.d.e(c0352a.getContext(), com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ));
                    e(c0352a);
                    if (e) {
                        com.kwad.sdk.core.report.a.m(c0352a.getAdTemplate(), 0);
                        return 0;
                    }
                    AdWebViewActivityProxy.launch(c0352a.getContext(), c0352a.getAdTemplate());
                    return 0;
                } else {
                    if (com.kwad.sdk.core.response.a.a.am(bQ)) {
                        if (c0352a.mG() == 2 || c0352a.mG() == 1) {
                            c0352a.am(false);
                            e(c0352a);
                        } else {
                            e(c0352a);
                            if (!c(c0352a)) {
                                c0352a.am(true);
                            }
                        }
                        return g(c0352a);
                    }
                    return 0;
                }
            }
        }
        return invokeL.intValue;
    }

    public static boolean b(C0352a c0352a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0352a)) == null) ? com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(c0352a.getAdTemplate())) ? !c0352a.mE() && c.s(c0352a) == 3 : d(c0352a) == 1 : invokeL.booleanValue;
    }

    public static boolean c(C0352a c0352a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c0352a)) == null) {
            AdTemplate adTemplate = c0352a.getAdTemplate();
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if (!c0352a.mC() || !com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ar(bQ)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0352a.getApkDownloadHelper().mO()) {
                return false;
            }
            AdWebViewVideoActivityProxy.launch(c0352a.getContext(), adTemplate);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int d(C0352a c0352a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c0352a)) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(c0352a.getAdTemplate());
            if (bQ.unDownloadConf.unDownloadRegionConf != null) {
                int cC = c0352a.cC();
                return cC != 2 ? cC != 3 ? bQ.unDownloadConf.unDownloadRegionConf.actionBarType : bQ.unDownloadConf.unDownloadRegionConf.materialJumpType : bQ.unDownloadConf.unDownloadRegionConf.describeBarType;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void e(C0352a c0352a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, c0352a) == null) {
            f(c0352a);
            if (c0352a.mw() != null) {
                c0352a.mw().onAdClicked();
            }
        }
    }

    public static void f(C0352a c0352a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, c0352a) == null) && c0352a.mA()) {
            com.kwad.sdk.core.report.a.a(c0352a.adTemplate, c0352a.Ea, c0352a.gP());
        }
    }

    public static int g(C0352a c0352a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, c0352a)) == null) {
            c apkDownloadHelper = c0352a.getApkDownloadHelper();
            if (apkDownloadHelper == null) {
                apkDownloadHelper = new c(c0352a.adTemplate);
                c0352a.b(apkDownloadHelper);
            }
            return apkDownloadHelper.m(c0352a);
        }
        return invokeL.intValue;
    }

    public static void h(C0352a c0352a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, c0352a) == null) {
            AdTemplate adTemplate = c0352a.getAdTemplate();
            Context context = c0352a.getContext();
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if (com.kwad.sdk.utils.d.e(context, com.kwad.sdk.core.response.a.a.bO(bQ), com.kwad.sdk.core.response.a.a.ag(bQ))) {
                com.kwad.sdk.core.report.a.m(adTemplate, 0);
            } else if (i(c0352a)) {
                AdWebViewActivityProxy.launch(context, adTemplate, 4);
            } else if (!com.kwad.sdk.core.response.a.a.c(bQ, com.kwad.sdk.core.config.d.lG()) || adTemplate.mAdWebVideoPageShowing) {
                AdWebViewActivityProxy.launch(context, adTemplate, 0);
            } else {
                AdWebViewVideoActivityProxy.launch(context, adTemplate);
            }
        }
    }

    public static boolean i(C0352a c0352a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c0352a)) == null) {
            AdTemplate adTemplate = c0352a.getAdTemplate();
            return com.kwad.sdk.core.response.a.b.bg(adTemplate) && !adTemplate.interactLandingPageShowing;
        }
        return invokeL.booleanValue;
    }
}

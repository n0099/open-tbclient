package com.kwad.sdk.core.response.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import java.util.Random;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static Random a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037665600, "Lcom/kwad/sdk/core/response/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037665600, "Lcom/kwad/sdk/core/response/a/b;");
                return;
            }
        }
        a = new Random();
    }

    public static int a(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            try {
                int i2 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
                if (i2 == 0) {
                    return a.nextBoolean() ? 1 : 2;
                }
                return i2;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return 1;
            }
        }
        return invokeL.intValue;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate a(@NonNull AdTemplate adTemplate, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, adTemplate, str)) == null) {
            for (AdMatrixInfo.MatrixTemplate matrixTemplate : a(adTemplate).styles.templateList) {
                if (at.a(str, matrixTemplate.templateId)) {
                    return matrixTemplate;
                }
            }
            return null;
        }
        return (AdMatrixInfo.MatrixTemplate) invokeLL.objValue;
    }

    @NonNull
    public static AdMatrixInfo a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) ? d.c(adTemplate) ? d.j(adTemplate).adMatrixInfo : new AdMatrixInfo() : (AdMatrixInfo) invokeL.objValue;
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, adTemplate)) == null) {
            AdInfo j2 = d.j(adTemplate);
            if (a.U(j2)) {
                return af.e(context) ? !a.g(j2) : a.g(j2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static String b(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adTemplate)) == null) {
            AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, p(adTemplate).templateId);
            return a2 != null ? a2.templateUrl : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adInfo)) == null) {
            try {
                return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static long c(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adTemplate)) == null) ? p(adTemplate).maxTimeOut : invokeL.longValue;
    }

    public static boolean c(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adInfo)) == null) {
            try {
                return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean d(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adTemplate)) == null) ? !TextUtils.isEmpty(b(adTemplate)) : invokeL.booleanValue;
    }

    @Nullable
    public static String e(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adTemplate)) == null) {
            AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, q(adTemplate).templateId);
            return a2 != null ? a2.templateUrl : "";
        }
        return (String) invokeL.objValue;
    }

    public static long f(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adTemplate)) == null) ? q(adTemplate).maxTimeOut : invokeL.longValue;
    }

    @Nullable
    public static String g(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adTemplate)) == null) {
            AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, r(adTemplate).templateId);
            return a2 != null ? a2.templateUrl : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean h(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adTemplate)) == null) ? !TextUtils.isEmpty(g(adTemplate)) : invokeL.booleanValue;
    }

    @Nullable
    public static String i(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adTemplate)) == null) {
            AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, s(adTemplate).templateId);
            return a2 != null ? a2.templateUrl : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean j(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adTemplate)) == null) {
            if (adTemplate.mAdScene == null || !af.a() || com.kwad.sdk.core.config.b.aa() || TextUtils.isEmpty(i(adTemplate))) {
                return false;
            }
            int adStyle = adTemplate.mAdScene.getAdStyle();
            if (adStyle == 1 || adStyle == 3 || adStyle == 2) {
                AdInfo j2 = d.j(adTemplate);
                return a.C(j2) && a.B(j2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static String k(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adTemplate)) == null) {
            AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, t(adTemplate).templateId);
            return a2 != null ? a2.templateUrl : "";
        }
        return (String) invokeL.objValue;
    }

    public static float l(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, adTemplate)) == null) ? (float) d.j(adTemplate).adStyleInfo.feedAdInfo.heightRatio : invokeL.floatValue;
    }

    public static boolean m(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, adTemplate)) == null) ? (TextUtils.isEmpty(k(adTemplate)) || TextUtils.isEmpty(d.j(adTemplate).adStyleInfo.feedAdInfo.templateConfig)) ? false : true : invokeL.booleanValue;
    }

    @Nullable
    public static String n(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, adTemplate)) == null) {
            AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, u(adTemplate).templateId);
            return a2 != null ? a2.templateUrl : "";
        }
        return (String) invokeL.objValue;
    }

    public static float o(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, adTemplate)) == null) {
            try {
                i2 = d.j(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
                i2 = 7;
            }
            return i2;
        }
        return invokeL.floatValue;
    }

    @NonNull
    public static AdMatrixInfo.ActionBarInfoNew p(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, adTemplate)) == null) ? a(adTemplate).adDataV2.actionBarInfo : (AdMatrixInfo.ActionBarInfoNew) invokeL.objValue;
    }

    @NonNull
    public static AdMatrixInfo.FullPageActionBarInfo q(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, adTemplate)) == null) ? a(adTemplate).adDataV2.fullPageActionBarInfo : (AdMatrixInfo.FullPageActionBarInfo) invokeL.objValue;
    }

    @NonNull
    public static AdMatrixInfo.EndCardInfo r(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, adTemplate)) == null) ? a(adTemplate).adDataV2.endCardInfo : (AdMatrixInfo.EndCardInfo) invokeL.objValue;
    }

    @NonNull
    public static AdMatrixInfo.InteractionInfo s(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, adTemplate)) == null) ? a(adTemplate).adDataV2.interactionInfo : (AdMatrixInfo.InteractionInfo) invokeL.objValue;
    }

    @NonNull
    public static AdMatrixInfo.FeedInfo t(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, adTemplate)) == null) ? a(adTemplate).adDataV2.feedInfo : (AdMatrixInfo.FeedInfo) invokeL.objValue;
    }

    @NonNull
    public static AdMatrixInfo.InterstitialCardInfo u(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, adTemplate)) == null) ? a(adTemplate).adDataV2.interstitialCardInfo : (AdMatrixInfo.InterstitialCardInfo) invokeL.objValue;
    }
}

package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static AdStyleInfo.PlayDetailInfo.PatchAdInfo a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) ? q(adTemplate).playDetailInfo.patchAdInfo : (AdStyleInfo.PlayDetailInfo.PatchAdInfo) invokeL.objValue;
    }

    public static String b(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) ? adTemplate == null ? "" : q(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardCallDescription : (String) invokeL.objValue;
    }

    public static String c(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) ? adTemplate == null ? "" : q(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardIconUrl : (String) invokeL.objValue;
    }

    public static String d(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) ? adTemplate == null ? "" : q(adTemplate).playEndInfo.endTopToolBarInfo.rewardIconUrl : (String) invokeL.objValue;
    }

    public static long e(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, adTemplate)) == null) {
            long j = adTemplate != null ? q(adTemplate).playDetailInfo.actionBarInfo.translateBtnShowTime : 0L;
            if (j > 0) {
                return j;
            }
            return 3000L;
        }
        return invokeL.longValue;
    }

    public static long f(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, adTemplate)) == null) {
            long j = adTemplate != null ? q(adTemplate).playDetailInfo.actionBarInfo.lightBtnShowTime : 0L;
            if (j > 0) {
                return j;
            }
            return 6000L;
        }
        return invokeL.longValue;
    }

    public static long g(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, adTemplate)) == null) {
            long j = adTemplate != null ? q(adTemplate).playDetailInfo.actionBarInfo.cardShowTime : 0L;
            if (j > 0) {
                return j;
            }
            return 9000L;
        }
        return invokeL.longValue;
    }

    public static int h(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adTemplate)) == null) {
            int i2 = adTemplate != null ? q(adTemplate).playEndInfo.adWebCardInfo.cardShowPlayCount : 0;
            if (i2 > 0) {
                return i2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static long i(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return 0L;
            }
            return q(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
        }
        return invokeL.longValue;
    }

    public static String j(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adTemplate)) == null) ? adTemplate == null ? "" : q(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription : (String) invokeL.objValue;
    }

    public static String k(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adTemplate)) == null) ? adTemplate == null ? "" : q(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription : (String) invokeL.objValue;
    }

    public static long l(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return 0L;
            }
            return q(adTemplate).playDetailInfo.detailWebCardInfo.maxTimeOut;
        }
        return invokeL.longValue;
    }

    public static long m(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, adTemplate)) == null) {
            long j = adTemplate != null ? q(adTemplate).playDetailInfo.detailWebCardInfo.cardShowTime : 0L;
            if (j > 0) {
                return j;
            }
            return 5000L;
        }
        return invokeL.longValue;
    }

    public static String n(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, adTemplate)) == null) {
            if (adTemplate != null) {
                return q(adTemplate).playDetailInfo.detailWebCardInfo.cardUrl;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean o(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, adTemplate)) == null) {
            if (adTemplate != null && c.c(adTemplate)) {
                AdStyleInfo.PlayDetailInfo playDetailInfo = q(adTemplate).playDetailInfo;
                if (playDetailInfo.type == 0) {
                    return false;
                }
                AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo = playDetailInfo.detailWebCardInfo;
                return !TextUtils.isEmpty(detailWebCardInfo.cardUrl) && com.kwad.sdk.core.config.a.a(detailWebCardInfo.cardUrl);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adTemplate)) == null) {
            if (adTemplate != null && c.c(adTemplate)) {
                AdStyleInfo.PlayEndInfo playEndInfo = q(adTemplate).playEndInfo;
                if (playEndInfo.type == 0) {
                    return false;
                }
                AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo = playEndInfo.adWebCardInfo;
                return !TextUtils.isEmpty(adWebCardInfo.cardUrl) && com.kwad.sdk.core.config.a.a(adWebCardInfo.cardUrl);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static AdStyleInfo q(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, adTemplate)) == null) ? c.j(adTemplate).adStyleInfo : (AdStyleInfo) invokeL.objValue;
    }
}

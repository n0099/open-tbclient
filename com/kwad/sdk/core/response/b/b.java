package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) ? adTemplate == null ? "" : k(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardCallDescription : (String) invokeL.objValue;
    }

    public static String b(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) ? adTemplate == null ? "" : k(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardIconUrl : (String) invokeL.objValue;
    }

    public static String c(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) ? adTemplate == null ? "" : k(adTemplate).playEndInfo.endTopToolBarInfo.rewardIconUrl : (String) invokeL.objValue;
    }

    public static long d(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return 0L;
            }
            return k(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
        }
        return invokeL.longValue;
    }

    public static String e(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate)) == null) ? adTemplate == null ? "" : k(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription : (String) invokeL.objValue;
    }

    public static String f(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, adTemplate)) == null) ? adTemplate == null ? "" : k(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription : (String) invokeL.objValue;
    }

    public static long g(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return 0L;
            }
            return k(adTemplate).playDetailInfo.detailWebCardInfo.maxTimeOut;
        }
        return invokeL.longValue;
    }

    public static String h(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adTemplate)) == null) {
            if (adTemplate != null) {
                return k(adTemplate).playDetailInfo.detailWebCardInfo.cardUrl;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean i(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adTemplate)) == null) {
            if (adTemplate != null && c.b(adTemplate)) {
                AdStyleInfo.PlayDetailInfo playDetailInfo = k(adTemplate).playDetailInfo;
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

    public static boolean j(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adTemplate)) == null) {
            if (adTemplate != null && c.b(adTemplate)) {
                AdStyleInfo.PlayEndInfo playEndInfo = k(adTemplate).playEndInfo;
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
    public static AdStyleInfo k(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, adTemplate)) == null) ? c.i(adTemplate).adStyleInfo : (AdStyleInfo) invokeL.objValue;
    }
}

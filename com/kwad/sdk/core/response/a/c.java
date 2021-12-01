package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) ? adTemplate == null ? "" : h(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardCallDescription : (String) invokeL.objValue;
    }

    public static String b(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) ? adTemplate == null ? "" : h(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardIconUrl : (String) invokeL.objValue;
    }

    public static String c(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) ? adTemplate == null ? "" : h(adTemplate).playEndInfo.endTopToolBarInfo.rewardIconUrl : (String) invokeL.objValue;
    }

    public static long d(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) {
            if (adTemplate == null) {
                return 0L;
            }
            return h(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
        }
        return invokeL.longValue;
    }

    public static String e(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate)) == null) ? adTemplate == null ? "" : h(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription : (String) invokeL.objValue;
    }

    public static String f(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adTemplate)) == null) ? adTemplate == null ? "" : h(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription : (String) invokeL.objValue;
    }

    public static boolean g(@Nullable AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adTemplate)) == null) {
            if (adTemplate != null && d.c(adTemplate)) {
                return h(adTemplate).slideClick;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static AdStyleInfo h(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, adTemplate)) == null) ? d.j(adTemplate).adStyleInfo : (AdStyleInfo) invokeL.objValue;
    }

    public static List<String> i(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, adTemplate)) == null) {
            AdStyleInfo h2 = h(adTemplate);
            ArrayList arrayList = new ArrayList();
            try {
                for (AdStyleInfo.ExposeTagInfo exposeTagInfo : h2.extraDisplayInfo.exposeTagInfoList) {
                    arrayList.add(exposeTagInfo.text);
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}

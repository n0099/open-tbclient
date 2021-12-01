package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoAd;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, photoInfo)) == null) ? photoInfo.videoInfo.videoUrl : (String) invokeL.objValue;
    }

    public static boolean a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
            PhotoAd photoAd = adTemplate.photoAd;
            return photoAd != null && photoAd.requestPatchEc;
        }
        return invokeL.booleanValue;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, photoInfo)) == null) ? photoInfo.videoInfo.manifest : (String) invokeL.objValue;
    }

    public static Long c(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, photoInfo)) == null) ? Long.valueOf(photoInfo.videoInfo.duration) : (Long) invokeL.objValue;
    }

    public static String d(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, photoInfo)) == null) ? photoInfo.coverInfo.blurBackgroundUrl : (String) invokeL.objValue;
    }

    public static long e(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, photoInfo)) == null) ? photoInfo.baseInfo.photoId : invokeL.longValue;
    }

    public static int f(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, photoInfo)) == null) ? photoInfo.baseInfo.contentSourceType : invokeL.intValue;
    }

    public static String g(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, photoInfo)) == null) ? photoInfo.baseInfo.recoExt : (String) invokeL.objValue;
    }

    public static long h(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, photoInfo)) == null) ? photoInfo.authorInfo.authorId : invokeL.longValue;
    }

    public static String i(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, photoInfo)) == null) ? photoInfo.authorInfo.authorIcon : (String) invokeL.objValue;
    }

    public static long j(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, photoInfo)) == null) ? photoInfo.tubeEpisode.tubeId : invokeL.longValue;
    }

    public static String k(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, photoInfo)) == null) ? photoInfo.tubeEpisode.tubeName : (String) invokeL.objValue;
    }

    public static String l(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, photoInfo)) == null) ? photoInfo.tubeEpisode.episodeName : (String) invokeL.objValue;
    }

    public static long m(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, photoInfo)) == null) ? photoInfo.mHotspotInfo.trendId : invokeL.longValue;
    }

    public static String n(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, photoInfo)) == null) ? photoInfo.mHotspotInfo.name : (String) invokeL.objValue;
    }

    public static String o(PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, photoInfo)) == null) ? photoInfo.baseInfo.sdkExtraData : (String) invokeL.objValue;
    }
}

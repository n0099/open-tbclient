package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.PhotoInfo;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, photoInfo)) == null) ? photoInfo.videoInfo.videoUrl : (String) invokeL.objValue;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, photoInfo)) == null) ? photoInfo.videoInfo.manifest : (String) invokeL.objValue;
    }

    public static Long c(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, photoInfo)) == null) ? Long.valueOf(photoInfo.videoInfo.duration) : (Long) invokeL.objValue;
    }

    public static long d(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, photoInfo)) == null) ? photoInfo.baseInfo.photoId : invokeL.longValue;
    }

    public static int e(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, photoInfo)) == null) ? photoInfo.baseInfo.contentSourceType : invokeL.intValue;
    }

    public static String f(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, photoInfo)) == null) ? photoInfo.baseInfo.recoExt : (String) invokeL.objValue;
    }

    public static long g(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, photoInfo)) == null) ? photoInfo.authorInfo.authorId : invokeL.longValue;
    }

    public static String h(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, photoInfo)) == null) ? photoInfo.authorInfo.authorIcon : (String) invokeL.objValue;
    }

    public static long i(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, photoInfo)) == null) ? photoInfo.tubeEpisode.tubeId : invokeL.longValue;
    }

    public static String j(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, photoInfo)) == null) ? photoInfo.tubeEpisode.tubeName : (String) invokeL.objValue;
    }

    public static String k(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, photoInfo)) == null) ? photoInfo.tubeEpisode.episodeName : (String) invokeL.objValue;
    }

    public static long l(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, photoInfo)) == null) ? photoInfo.mHotspotInfo.trendId : invokeL.longValue;
    }

    public static String m(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, photoInfo)) == null) ? photoInfo.mHotspotInfo.name : (String) invokeL.objValue;
    }
}

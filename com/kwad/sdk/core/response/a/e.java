package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.NewsInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(@NonNull NewsInfo newsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newsInfo)) == null) ? newsInfo.photoId : invokeL.longValue;
    }

    public static int b(@NonNull NewsInfo newsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, newsInfo)) == null) ? newsInfo.contentSourceType : invokeL.intValue;
    }

    public static int c(@NonNull NewsInfo newsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, newsInfo)) == null) {
            if (d(newsInfo)) {
                return 1;
            }
            if (e(newsInfo)) {
                return 3;
            }
            return f(newsInfo) ? 2 : 0;
        }
        return invokeL.intValue;
    }

    public static boolean d(@NonNull NewsInfo newsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, newsInfo)) == null) {
            List<NewsInfo.ImageInfo> list = newsInfo.thumbnailInfo;
            return list == null || list.isEmpty();
        }
        return invokeL.booleanValue;
    }

    public static boolean e(@NonNull NewsInfo newsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, newsInfo)) == null) {
            List<NewsInfo.ImageInfo> list = newsInfo.thumbnailInfo;
            return list != null && list.size() > 0 && newsInfo.thumbnailInfo.size() < 3;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(@NonNull NewsInfo newsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, newsInfo)) == null) {
            List<NewsInfo.ImageInfo> list = newsInfo.thumbnailInfo;
            return list != null && list.size() >= 3;
        }
        return invokeL.booleanValue;
    }

    public static String g(@NonNull NewsInfo newsInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, newsInfo)) == null) ? newsInfo.authorInfo.authorIcon : (String) invokeL.objValue;
    }
}

package com.kwad.sdk.glide.load.a.a;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.services.vod.VodClient;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) ? i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384 : invokeII.booleanValue;
    }

    public static boolean a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) ? uri != null && "content".equals(uri.getScheme()) && VodClient.PATH_MEDIA.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) ? a(uri) && d(uri) : invokeL.booleanValue;
    }

    public static boolean c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) ? a(uri) && !d(uri) : invokeL.booleanValue;
    }

    public static boolean d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, uri)) == null) ? uri.getPathSegments().contains("video") : invokeL.booleanValue;
    }
}

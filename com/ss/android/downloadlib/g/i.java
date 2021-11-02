package com.ss.android.downloadlib.g;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, uri)) == null) ? h.a(context, uri) : (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? h.b(context, str) : (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? h.c(context, str) : invokeLL.booleanValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? h.a(context, str) : (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, eVar, str)) == null) ? h.a(context, eVar, str) : (com.ss.android.downloadlib.addownload.b.g) invokeLLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str, com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, aVar)) == null) ? h.a(context, str, aVar) : (com.ss.android.downloadlib.addownload.b.g) invokeLLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(String str, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, aVar)) == null) ? h.b(str, aVar) : (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(@NonNull com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str, str2)) == null) ? h.a(bVar, str, str2) : (com.ss.android.downloadlib.addownload.b.g) invokeLLL.objValue;
    }
}

package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static h61 a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            h61 h61Var = new h61();
            if (uri != null) {
                String queryParameter = uri.getQueryParameter("downloaded_size");
                long longValue = !TextUtils.isEmpty(queryParameter) ? Long.valueOf(queryParameter).longValue() : 0L;
                String queryParameter2 = uri.getQueryParameter(PackageTable.TOTAL_SIZE);
                long longValue2 = TextUtils.isEmpty(queryParameter2) ? 0L : Long.valueOf(queryParameter2).longValue();
                h61Var.a = longValue;
                h61Var.b = longValue2;
            }
            return h61Var;
        }
        return (h61) invokeL.objValue;
    }

    public static Uri b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new Uri.Builder().scheme("content").authority(BundleOpProvider.j(ContextHolder.getApplicationContext())).build() : (Uri) invokeV.objValue;
    }

    public static Uri c(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) ? new Uri.Builder().scheme("content").authority(BundleOpProvider.j(ContextHolder.getApplicationContext())).path(str).appendQueryParameter("downloaded_size", String.valueOf(j)).appendQueryParameter(PackageTable.TOTAL_SIZE, String.valueOf(j2)).build() : (Uri) invokeCommon.objValue;
    }

    public static Uri d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? new Uri.Builder().scheme("content").authority(BundleOpProvider.j(ContextHolder.getApplicationContext())).path(str).build() : (Uri) invokeL.objValue;
    }

    public static Uri e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? new Uri.Builder().scheme("content").authority(BundleOpProvider.j(ContextHolder.getApplicationContext())).path(str).build() : (Uri) invokeL.objValue;
    }
}

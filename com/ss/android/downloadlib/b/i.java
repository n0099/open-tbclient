package com.ss.android.downloadlib.b;

import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) ? com.ss.android.socialbase.appdownloader.f.d.d() && Build.VERSION.SDK_INT < 29 && com.ss.android.downloadlib.addownload.j.k() != null && com.ss.android.downloadlib.addownload.j.k().a() && com.ss.android.downloadlib.g.e.a(aVar).b("invoke_app_form_background_switch") == 1 && aVar.q() : invokeL.booleanValue;
    }
}

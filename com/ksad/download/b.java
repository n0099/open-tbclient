package com.ksad.download;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f33533a;

    /* renamed from: b  reason: collision with root package name */
    public static File f33534b;

    /* renamed from: c  reason: collision with root package name */
    public static a f33535c;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f33533a : (Context) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            f33533a = context.getApplicationContext();
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            f33535c = aVar;
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, file) == null) {
            f33534b = file;
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, str) == null) {
            f33535c.installApp(a(), str);
        }
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f33534b : (File) invokeV.objValue;
    }
}

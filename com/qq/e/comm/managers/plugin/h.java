package com.qq.e.comm.managers.plugin;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f68006a;

    /* renamed from: b  reason: collision with root package name */
    public static String f68007b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(151737322, "Lcom/qq/e/comm/managers/plugin/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(151737322, "Lcom/qq/e/comm/managers/plugin/h;");
                return;
            }
        }
        f68006a = SystemUtil.buildNewPathByProcessName("e_qq_com_plugin");
        f68007b = SystemUtil.buildNewPathByProcessName("e_qq_com_dex");
    }

    public static File a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? context.getDir(f68007b, 0) : (File) invokeL.objValue;
    }

    public static File b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new File(context.getDir(f68006a, 0), "update_lc") : (File) invokeL.objValue;
    }

    public static File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? new File(context.getDir(f68006a, 0), "gdt_plugin.next") : (File) invokeL.objValue;
    }

    public static File d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? new File(context.getDir(f68006a, 0), "gdt_plugin.next.sig") : (File) invokeL.objValue;
    }

    public static File e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? new File(context.getDir(f68006a, 0), "gdt_plugin.jar") : (File) invokeL.objValue;
    }

    public static File f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? new File(context.getDir(f68006a, 0), "gdt_plugin.jar.sig") : (File) invokeL.objValue;
    }

    public static File g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? new File(context.getDir(f68006a, 0), "gdt_plugin.tmp") : (File) invokeL.objValue;
    }

    public static File h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? new File(context.getDir(f68006a, 0), "gdt_plugin.tmp.sig") : (File) invokeL.objValue;
    }
}

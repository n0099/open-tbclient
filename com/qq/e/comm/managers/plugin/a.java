package com.qq.e.comm.managers.plugin;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static Method a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f59078b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, th, str) == null) {
            try {
                Exception exc = new Exception("插件错误：" + str, th);
                if (f59078b) {
                    return;
                }
                if (a == null) {
                    Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                    a = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                a.invoke(null, exc);
            } catch (Throwable unused) {
                f59078b = true;
            }
        }
    }
}

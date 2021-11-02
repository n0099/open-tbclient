package com.qq.e.comm.managers.plugin;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Method f67993a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67994b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, th, str) == null) {
            try {
                Exception exc = new Exception("插件错误：" + str, th);
                if (f67994b) {
                    return;
                }
                if (f67993a == null) {
                    Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                    f67993a = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                f67993a.invoke(null, exc);
            } catch (Throwable unused) {
                f67994b = true;
            }
        }
    }
}

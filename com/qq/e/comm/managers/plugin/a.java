package com.qq.e.comm.managers.plugin;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Method f68913a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68914b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, th, str) == null) {
            try {
                Exception exc = new Exception("插件错误：" + str, th);
                if (f68914b) {
                    return;
                }
                if (f68913a == null) {
                    Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                    f68913a = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                f68913a.invoke(null, exc);
            } catch (Throwable unused) {
                f68914b = true;
            }
        }
    }
}

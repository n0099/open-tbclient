package com.kuaishou.aegon.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.aegon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0400a<T> {
        T get();
    }

    public static <T> T a(InterfaceC0400a<T> interfaceC0400a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, interfaceC0400a)) == null) {
            try {
                try {
                    return interfaceC0400a.get();
                } catch (UnsatisfiedLinkError unused) {
                    return interfaceC0400a.get();
                }
            } catch (UnsatisfiedLinkError unused2) {
                return interfaceC0400a.get();
            }
        }
        return (T) invokeL.objValue;
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            try {
                try {
                    runnable.run();
                } catch (UnsatisfiedLinkError unused) {
                    runnable.run();
                }
            } catch (UnsatisfiedLinkError unused2) {
                runnable.run();
            }
        }
    }

    public static void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            try {
                runnable.run();
            } catch (UnsatisfiedLinkError unused) {
            }
        }
    }
}

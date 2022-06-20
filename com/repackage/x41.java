package com.repackage;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Application application) {
        InterceptResult invokeL;
        Object f;
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, application)) == null) {
            try {
                Context baseContext = application.getBaseContext();
                if (baseContext == null || (f = i61.f(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) i61.f(f, "mClassLoader")) == null) {
                    return false;
                }
                y41 y41Var = new y41(classLoader.getParent(), classLoader);
                i61.k(f, "mClassLoader", y41Var);
                Thread.currentThread().setContextClassLoader(y41Var);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}

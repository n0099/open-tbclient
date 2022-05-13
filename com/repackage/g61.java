package com.repackage;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Application application) {
        InterceptResult invokeL;
        Object e;
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, application)) == null) {
            try {
                Context baseContext = application.getBaseContext();
                if (baseContext == null || (e = k71.e(baseContext, "mPackageInfo")) == null || (classLoader = (ClassLoader) k71.e(e, "mClassLoader")) == null) {
                    return false;
                }
                h61 h61Var = new h61(classLoader.getParent(), classLoader);
                k71.j(e, "mClassLoader", h61Var);
                Thread.currentThread().setContextClassLoader(h61Var);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}

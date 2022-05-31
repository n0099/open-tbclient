package com.repackage;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ga1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755684870, "Lcom/repackage/ga1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755684870, "Lcom/repackage/ga1;");
                return;
            }
        }
        ka1 e = ka1.e();
        la1 la1Var = new la1();
        e.f("splash_ad", la1Var);
        e.g(la1Var);
    }

    public static boolean a(Context context, String str, da1 da1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, da1Var)) == null) {
            if (ma1.g(str)) {
                return c(context, Uri.parse(str), da1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, da1 da1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, da1Var)) == null) {
            if (context == null) {
                context = fa1.a();
            }
            ka1 e = ka1.e();
            ja1 ja1Var = new ja1(uri, str);
            ja1Var.g(false);
            return e.b(context, ja1Var, da1Var);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, da1 da1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, da1Var)) == null) ? b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, da1Var) : invokeLLL.booleanValue;
    }
}

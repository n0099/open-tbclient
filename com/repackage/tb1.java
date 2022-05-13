package com.repackage;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755296626, "Lcom/repackage/tb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755296626, "Lcom/repackage/tb1;");
                return;
            }
        }
        xb1 e = xb1.e();
        yb1 yb1Var = new yb1();
        e.f("splash_ad", yb1Var);
        e.g(yb1Var);
    }

    public static boolean a(Context context, String str, qb1 qb1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, qb1Var)) == null) {
            if (zb1.g(str)) {
                return c(context, Uri.parse(str), qb1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, qb1 qb1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, qb1Var)) == null) {
            if (context == null) {
                context = sb1.a();
            }
            xb1 e = xb1.e();
            wb1 wb1Var = new wb1(uri, str);
            wb1Var.g(false);
            return e.b(context, wb1Var, qb1Var);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, qb1 qb1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, qb1Var)) == null) ? b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, qb1Var) : invokeLLL.booleanValue;
    }
}

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
public class gb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755683909, "Lcom/repackage/gb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755683909, "Lcom/repackage/gb1;");
                return;
            }
        }
        kb1 e = kb1.e();
        lb1 lb1Var = new lb1();
        e.f("splash_ad", lb1Var);
        e.g(lb1Var);
    }

    public static boolean a(Context context, String str, db1 db1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, db1Var)) == null) {
            if (mb1.g(str)) {
                return c(context, Uri.parse(str), db1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, db1 db1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, db1Var)) == null) {
            if (context == null) {
                context = fb1.a();
            }
            kb1 e = kb1.e();
            jb1 jb1Var = new jb1(uri, str);
            jb1Var.g(false);
            return e.b(context, jb1Var, db1Var);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, db1 db1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, db1Var)) == null) ? b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, db1Var) : invokeLLL.booleanValue;
    }
}

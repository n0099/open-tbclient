package d.a.h0.c;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1577630469, "Ld/a/h0/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1577630469, "Ld/a/h0/c/d;");
                return;
            }
        }
        h e2 = h.e();
        i iVar = new i();
        e2.f("splash_ad", iVar);
        e2.g(iVar);
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (j.g(str)) {
                return d(context, Uri.parse(str));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, uri, str)) == null) ? c(context, uri, str, null) : invokeLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, String str, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, uri, str, aVar)) == null) {
            if (context == null) {
                context = c.a();
            }
            h e2 = h.e();
            g gVar = new g(uri, str);
            gVar.k(false);
            return e2.b(context, gVar, aVar);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean d(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, uri)) == null) ? b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) : invokeLL.booleanValue;
    }
}

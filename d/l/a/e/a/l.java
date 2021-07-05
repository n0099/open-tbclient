package d.l.a.e.a;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            try {
                return context.getResources().getIdentifier(str, "string", context.getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return d.l.a.e.b.g.e.n().getResources().getIdentifier(str, "layout", d.l.a.e.b.g.e.n().getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                return d.l.a.e.b.g.e.n().getResources().getIdentifier(str, "drawable", str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? a(d.l.a.e.b.g.e.n(), str) : invokeL.intValue;
    }

    public static int e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, str2)) == null) {
            try {
                return d.l.a.e.b.g.e.n().getResources().getIdentifier(str, "attr", str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return c(str, d.l.a.e.b.g.e.n().getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            try {
                return d.l.a.e.b.g.e.n().getResources().getIdentifier(str, "style", d.l.a.e.b.g.e.n().getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                return d.l.a.e.b.g.e.n().getResources().getIdentifier(str, "id", d.l.a.e.b.g.e.n().getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            try {
                return d.l.a.e.b.g.e.n().getResources().getIdentifier(str, "color", d.l.a.e.b.g.e.n().getPackageName());
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }
}

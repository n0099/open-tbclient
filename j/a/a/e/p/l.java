package j.a.a.e.p;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) ? PayType.DXM_PAY_KJ.getChannel().equals(str) && PayType.DXM_PAY_KJ.getMethod().equals(str2) : invokeLL.booleanValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? a(str, str2) || PayType.MOCK_TEST_PAY.getChannel().equals(str) || PayType.UNION_PAY.getChannel().equals(str) : invokeLL.booleanValue;
    }
}

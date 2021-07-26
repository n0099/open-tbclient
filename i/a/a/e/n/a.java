package i.a.a.e.n;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IAppPayService a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) {
            IRevenue revenue = RevenueManager.instance().getRevenue(i2, i3);
            if (revenue == null) {
                RLog.error("CommonUtils", "getAppPayService null iRevenue", new Object[0]);
                return null;
            }
            return revenue.getAppPayService();
        }
        return (IAppPayService) invokeII.objValue;
    }
}

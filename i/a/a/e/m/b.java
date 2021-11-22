package i.a.a.e.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IEventReporter;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IEventReporter a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) {
            IRevenue revenue = RevenueManager.instance().getRevenue(i2, i3);
            if (revenue == null) {
                RLog.error("UIStatisticReporter", "getSDKReporter error revenue null", new Object[0]);
                return null;
            }
            return revenue.getEventReporter();
        }
        return (IEventReporter) invokeII.objValue;
    }

    public static void b(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65537, null, i2, i3, str) == null) {
            IEventReporter a2 = a(i2, i3);
            if (a2 == null) {
                RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
            } else {
                a2.reportUiEvent(str);
            }
        }
    }

    public static void c(int i2, int i3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
            IEventReporter a2 = a(i2, i3);
            if (a2 == null) {
                RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
            } else {
                a2.reportUiEvent(str, str2);
            }
        }
    }

    public static void d(int i2, int i3, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, str4}) == null) {
            IEventReporter a2 = a(i2, i3);
            if (a2 == null) {
                RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
            } else {
                a2.reportUvEvent(str, str2, str3, str4);
            }
        }
    }
}

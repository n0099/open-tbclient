package j.a.a.e.p;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PayFlowType a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 == PayFlowType.DIOALOG_PAY_FLOW.getTypeId()) {
                return PayFlowType.DIOALOG_PAY_FLOW;
            }
            if (i2 == PayFlowType.WALLET_PAY_FLOW.getTypeId()) {
                return PayFlowType.WALLET_PAY_FLOW;
            }
            return null;
        }
        return (PayFlowType) invokeI.objValue;
    }
}

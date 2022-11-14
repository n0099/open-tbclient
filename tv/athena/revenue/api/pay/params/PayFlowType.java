package tv.athena.revenue.api.pay.params;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class PayFlowType {
    public static final /* synthetic */ PayFlowType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayFlowType DIOALOG_PAY_FLOW;
    public static final PayFlowType WALLET_PAY_FLOW;
    public transient /* synthetic */ FieldHolder $fh;
    public final int typeId;
    public final String typeName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(122324122, "Ltv/athena/revenue/api/pay/params/PayFlowType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(122324122, "Ltv/athena/revenue/api/pay/params/PayFlowType;");
                return;
            }
        }
        DIOALOG_PAY_FLOW = new PayFlowType("DIOALOG_PAY_FLOW", 0, 1, "半屏充值流程");
        PayFlowType payFlowType = new PayFlowType("WALLET_PAY_FLOW", 1, 2, "全屏钱包充值流程");
        WALLET_PAY_FLOW = payFlowType;
        $VALUES = new PayFlowType[]{DIOALOG_PAY_FLOW, payFlowType};
    }

    public PayFlowType(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.typeId = i2;
        this.typeName = str2;
    }

    public static PayFlowType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PayFlowType) Enum.valueOf(PayFlowType.class, str);
        }
        return (PayFlowType) invokeL.objValue;
    }

    public static PayFlowType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PayFlowType[]) $VALUES.clone();
        }
        return (PayFlowType[]) invokeV.objValue;
    }

    public int getTypeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.typeId;
        }
        return invokeV.intValue;
    }

    public String getTypeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.typeName;
        }
        return (String) invokeV.objValue;
    }
}

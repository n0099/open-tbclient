package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayStatus;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "GET_PAY_INFO_SUCCESS", "GET_PAY_INFO_FAIL", "PAY_SUCCESS", "PAY_FAIL", "PAY_CANCEL", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class PayStatus {
    public static final /* synthetic */ PayStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayStatus GET_PAY_INFO_FAIL;
    public static final PayStatus GET_PAY_INFO_SUCCESS;
    public static final PayStatus PAY_CANCEL;
    public static final PayStatus PAY_FAIL;
    public static final PayStatus PAY_SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1344797195, "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1344797195, "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayStatus;");
                return;
            }
        }
        PayStatus payStatus = new PayStatus("GET_PAY_INFO_SUCCESS", 0);
        GET_PAY_INFO_SUCCESS = payStatus;
        PayStatus payStatus2 = new PayStatus("GET_PAY_INFO_FAIL", 1);
        GET_PAY_INFO_FAIL = payStatus2;
        PayStatus payStatus3 = new PayStatus("PAY_SUCCESS", 2);
        PAY_SUCCESS = payStatus3;
        PayStatus payStatus4 = new PayStatus("PAY_FAIL", 3);
        PAY_FAIL = payStatus4;
        PayStatus payStatus5 = new PayStatus("PAY_CANCEL", 4);
        PAY_CANCEL = payStatus5;
        $VALUES = new PayStatus[]{payStatus, payStatus2, payStatus3, payStatus4, payStatus5};
    }

    public static PayStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PayStatus) Enum.valueOf(PayStatus.class, str) : (PayStatus) invokeL.objValue;
    }

    public static PayStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PayStatus[]) $VALUES.clone() : (PayStatus[]) invokeV.objValue;
    }

    public PayStatus(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}

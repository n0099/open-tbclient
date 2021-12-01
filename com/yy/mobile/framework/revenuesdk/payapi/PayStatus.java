package com.yy.mobile.framework.revenuesdk.payapi;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class PayStatus {
    public static final /* synthetic */ PayStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayStatus APPLE_PAY_FAIL;
    public static final PayStatus CANCEL;
    public static final PayStatus CAN_NOT_USE;
    public static final PayStatus DEVICE_NOT_SUPPORT;
    public static final PayStatus OK;
    public static final PayStatus ORDER_RISK_ERROR;
    public static final PayStatus SEVER_ERROR;
    public static final PayStatus UNKNOWN;
    public static final PayStatus VALIDATE_FAIL;
    public static final PayStatus WRONG_ARGS;
    public transient /* synthetic */ FieldHolder $fh;
    public final int code;
    public final String msg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(586337878, "Lcom/yy/mobile/framework/revenuesdk/payapi/PayStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(586337878, "Lcom/yy/mobile/framework/revenuesdk/payapi/PayStatus;");
                return;
            }
        }
        OK = new PayStatus(StatHelper.SENSOR_OK, 0, 1, "请求成功");
        VALIDATE_FAIL = new PayStatus("VALIDATE_FAIL", 1, -1, "账号验证失败");
        CAN_NOT_USE = new PayStatus("CAN_NOT_USE", 2, -5, "账户已冻结");
        APPLE_PAY_FAIL = new PayStatus("APPLE_PAY_FAIL", 3, -14, "苹果支付凭证重复验证");
        WRONG_ARGS = new PayStatus("WRONG_ARGS", 4, ErrorCode.ARGS_ERROR, "参数错误，特指参数缺失");
        SEVER_ERROR = new PayStatus("SEVER_ERROR", 5, -500, "服务端错误");
        ORDER_RISK_ERROR = new PayStatus("ORDER_RISK_ERROR", 6, -18, "风控拦截");
        UNKNOWN = new PayStatus(RomUtils.UNKNOWN, 7, 0, "未知状态");
        CANCEL = new PayStatus("CANCEL", 8, -6001, "用户取消支付");
        PayStatus payStatus = new PayStatus("DEVICE_NOT_SUPPORT", 9, 3, "当前设备不支持该支付方式");
        DEVICE_NOT_SUPPORT = payStatus;
        $VALUES = new PayStatus[]{OK, VALIDATE_FAIL, CAN_NOT_USE, APPLE_PAY_FAIL, WRONG_ARGS, SEVER_ERROR, ORDER_RISK_ERROR, UNKNOWN, CANCEL, payStatus};
    }

    public PayStatus(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = i3;
        this.msg = str2;
    }

    public static PayStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (PayStatus) Enum.valueOf(PayStatus.class, str) : (PayStatus) invokeL.objValue;
    }

    public static PayStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (PayStatus[]) $VALUES.clone() : (PayStatus[]) invokeV.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msg : (String) invokeV.objValue;
    }

    public static PayStatus valueOf(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != -500) {
                if (i2 != -400) {
                    if (i2 != -18) {
                        if (i2 != -14) {
                            if (i2 != -5) {
                                if (i2 != -1) {
                                    if (i2 != 1) {
                                        return UNKNOWN;
                                    }
                                    return OK;
                                }
                                return VALIDATE_FAIL;
                            }
                            return CAN_NOT_USE;
                        }
                        return APPLE_PAY_FAIL;
                    }
                    return ORDER_RISK_ERROR;
                }
                return WRONG_ARGS;
            }
            return SEVER_ERROR;
        }
        return (PayStatus) invokeI.objValue;
    }
}

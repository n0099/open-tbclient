package com.yy.mobile.framework.revenuesdk.baseapi;

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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class PurchaseStatus {
    public static final /* synthetic */ PurchaseStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PurchaseStatus ORDER_FAIL;
    public static final PurchaseStatus ORDER_START;
    public static final PurchaseStatus ORDER_SUCCESS;
    public static final PurchaseStatus PAY_CANCEL;
    public static final PurchaseStatus PAY_FAIL;
    public static final PurchaseStatus PAY_START;
    public static final PurchaseStatus PAY_SUCCESS;
    public static final PurchaseStatus UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public final int code;
    public final String msg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(863336314, "Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(863336314, "Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;");
                return;
            }
        }
        UNKNOWN = new PurchaseStatus(RomUtils.UNKNOWN, 0, 0, "未知状态");
        ORDER_START = new PurchaseStatus("ORDER_START", 1, 100, "开始下单请求");
        ORDER_SUCCESS = new PurchaseStatus("ORDER_SUCCESS", 2, 101, "下单请求成功");
        ORDER_FAIL = new PurchaseStatus("ORDER_FAIL", 3, 102, "下单请求失败");
        PAY_START = new PurchaseStatus("PAY_START", 4, 110, "开始支付，支付页面拉起");
        PAY_CANCEL = new PurchaseStatus("PAY_CANCEL", 5, 111, "支付取消");
        PAY_SUCCESS = new PurchaseStatus("PAY_SUCCESS", 6, 112, EventAlias.PayEventAlias.PAY_SUCCESS);
        PurchaseStatus purchaseStatus = new PurchaseStatus("PAY_FAIL", 7, 113, EventAlias.PayEventAlias.PAY_FAIL);
        PAY_FAIL = purchaseStatus;
        $VALUES = new PurchaseStatus[]{UNKNOWN, ORDER_START, ORDER_SUCCESS, ORDER_FAIL, PAY_START, PAY_CANCEL, PAY_SUCCESS, purchaseStatus};
    }

    public PurchaseStatus(String str, int i, int i2, String str2) {
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
        this.code = i2;
        this.msg = str2;
    }

    public static PurchaseStatus valueOf(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            switch (i) {
                case 100:
                    return ORDER_START;
                case 101:
                    return ORDER_SUCCESS;
                case 102:
                    return ORDER_FAIL;
                default:
                    switch (i) {
                        case 110:
                            return PAY_START;
                        case 111:
                            return PAY_CANCEL;
                        case 112:
                            return PAY_SUCCESS;
                        case 113:
                            return PAY_FAIL;
                        default:
                            return UNKNOWN;
                    }
            }
        }
        return (PurchaseStatus) invokeI.objValue;
    }

    public static PurchaseStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (PurchaseStatus) Enum.valueOf(PurchaseStatus.class, str);
        }
        return (PurchaseStatus) invokeL.objValue;
    }

    public static PurchaseStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (PurchaseStatus[]) $VALUES.clone();
        }
        return (PurchaseStatus[]) invokeV.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.code;
        }
        return invokeV.intValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.msg;
        }
        return (String) invokeV.objValue;
    }
}

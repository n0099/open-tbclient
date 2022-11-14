package com.yy.mobile.framework.revenuesdk.payapi;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Keep
/* loaded from: classes8.dex */
public final class PayType {
    public static final /* synthetic */ PayType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayType ALI_PAY;
    public static final PayType ALI_PAY_SIGN;
    public static final PayType DXM_PAY;
    public static final PayType DXM_PAY_H5;
    public static final PayType DXM_PAY_KJ;
    public static final PayType MOCK_TEST_PAY;
    public static final PayType QQ_PAY;
    public static final PayType UNION_PAY;
    public static final PayType WECHAT_PAY;
    public static final PayType YY_COIN_PAY;
    public transient /* synthetic */ FieldHolder $fh;
    public final String channel;
    public final String method;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2003928910, "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2003928910, "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;");
                return;
            }
        }
        WECHAT_PAY = new PayType("WECHAT_PAY", 0, "Weixin", "WapApp");
        ALI_PAY = new PayType("ALI_PAY", 1, "Zfb", "WapApp");
        ALI_PAY_SIGN = new PayType("ALI_PAY_SIGN", 2, "Zfb", "PaySign");
        DXM_PAY = new PayType("DXM_PAY", 3, "Dxm", "WapApp");
        DXM_PAY_KJ = new PayType("DXM_PAY_KJ", 4, "Dxm", "WapKj");
        DXM_PAY_H5 = new PayType("DXM_PAY_H5", 5, "Dxm", "Wap");
        MOCK_TEST_PAY = new PayType("MOCK_TEST_PAY", 6, "Mock", "Balance");
        QQ_PAY = new PayType("QQ_PAY", 7, "Qq", "WapApp");
        UNION_PAY = new PayType("UNION_PAY", 8, "Unionpay", "WapAdvance");
        PayType payType = new PayType("YY_COIN_PAY", 9, "Yb", "Balance");
        YY_COIN_PAY = payType;
        $VALUES = new PayType[]{WECHAT_PAY, ALI_PAY, ALI_PAY_SIGN, DXM_PAY, DXM_PAY_KJ, DXM_PAY_H5, MOCK_TEST_PAY, QQ_PAY, UNION_PAY, payType};
    }

    public PayType(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str4 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.channel = str2;
        this.method = str3;
    }

    public static PayType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PayType) Enum.valueOf(PayType.class, str);
        }
        return (PayType) invokeL.objValue;
    }

    public static PayType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PayType[]) $VALUES.clone();
        }
        return (PayType[]) invokeV.objValue;
    }

    public String getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.channel;
        }
        return (String) invokeV.objValue;
    }

    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.method;
        }
        return (String) invokeV.objValue;
    }
}

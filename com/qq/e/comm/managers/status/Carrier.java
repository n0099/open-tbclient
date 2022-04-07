package com.qq.e.comm.managers.status;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class Carrier {
    public static /* synthetic */ Interceptable $ic;
    public static final Carrier CMCC;
    public static final Carrier TELECOM;
    public static final Carrier UNICOM;
    public static final Carrier UNKNOWN;
    public static final /* synthetic */ Carrier[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(310756443, "Lcom/qq/e/comm/managers/status/Carrier;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(310756443, "Lcom/qq/e/comm/managers/status/Carrier;");
                return;
            }
        }
        UNKNOWN = new Carrier(RomUtils.UNKNOWN, 0, 0);
        CMCC = new Carrier(OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE, 1, 1);
        UNICOM = new Carrier("UNICOM", 2, 2);
        Carrier carrier = new Carrier("TELECOM", 3, 3);
        TELECOM = carrier;
        b = new Carrier[]{UNKNOWN, CMCC, UNICOM, carrier};
    }

    public Carrier(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
    }

    public static Carrier valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Carrier) Enum.valueOf(Carrier.class, str) : (Carrier) invokeL.objValue;
    }

    public static Carrier[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Carrier[]) b.clone() : (Carrier[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }
}

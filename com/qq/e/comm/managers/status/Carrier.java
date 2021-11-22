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
/* loaded from: classes2.dex */
public final class Carrier {
    public static /* synthetic */ Interceptable $ic;
    public static final Carrier CMCC;
    public static final Carrier TELECOM;
    public static final Carrier UNICOM;
    public static final Carrier UNKNOWN;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ Carrier[] f68951b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68952a;

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
        f68951b = new Carrier[]{UNKNOWN, CMCC, UNICOM, carrier};
    }

    public Carrier(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68952a = i3;
    }

    public static Carrier valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Carrier) Enum.valueOf(Carrier.class, str) : (Carrier) invokeL.objValue;
    }

    public static Carrier[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Carrier[]) f68951b.clone() : (Carrier[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68952a : invokeV.intValue;
    }
}

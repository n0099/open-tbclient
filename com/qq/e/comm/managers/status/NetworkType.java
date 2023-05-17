package com.qq.e.comm.managers.status;

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
public final class NetworkType {
    public static /* synthetic */ Interceptable $ic;
    public static final NetworkType NET_2G;
    public static final NetworkType NET_3G;
    public static final NetworkType NET_4G;
    public static final NetworkType UNKNOWN;
    public static final NetworkType WIFI;
    public static final /* synthetic */ NetworkType[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1581042997, "Lcom/qq/e/comm/managers/status/NetworkType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1581042997, "Lcom/qq/e/comm/managers/status/NetworkType;");
                return;
            }
        }
        UNKNOWN = new NetworkType("UNKNOWN", 0, 0, 1, "unknown");
        WIFI = new NetworkType("WIFI", 1, 1, 2, "wifi");
        NET_2G = new NetworkType("NET_2G", 2, 2, 4, "2g");
        NET_3G = new NetworkType("NET_3G", 3, 3, 8, "3g");
        NetworkType networkType = new NetworkType("NET_4G", 4, 4, 16, "4g");
        NET_4G = networkType;
        d = new NetworkType[]{UNKNOWN, WIFI, NET_2G, NET_3G, networkType};
    }

    public NetworkType(String str, int i, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2};
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
        this.a = i2;
        this.b = i3;
        this.c = str2;
    }

    public static NetworkType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetworkType) Enum.valueOf(NetworkType.class, str) : (NetworkType) invokeL.objValue;
    }

    public static NetworkType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetworkType[]) d.clone() : (NetworkType[]) invokeV.objValue;
    }

    public int getConnValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public String getNameValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public int getPermValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : invokeV.intValue;
    }
}

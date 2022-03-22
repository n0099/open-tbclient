package com.yy.mobile.framework.revenuesdk.baseapi;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.HttpVersion;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Keep
/* loaded from: classes7.dex */
public final class ProtocolType {
    public static final /* synthetic */ ProtocolType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ProtocolType HTTP;
    public static final ProtocolType SERVICE;
    public static final ProtocolType UNKNOW;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(522978875, "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(522978875, "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;");
                return;
            }
        }
        UNKNOW = new ProtocolType("UNKNOW", 0);
        SERVICE = new ProtocolType("SERVICE", 1);
        ProtocolType protocolType = new ProtocolType(HttpVersion.HTTP, 2);
        HTTP = protocolType;
        $VALUES = new ProtocolType[]{UNKNOW, SERVICE, protocolType};
    }

    public ProtocolType(String str, int i) {
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

    public static ProtocolType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ProtocolType) Enum.valueOf(ProtocolType.class, str) : (ProtocolType) invokeL.objValue;
    }

    public static ProtocolType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ProtocolType[]) $VALUES.clone() : (ProtocolType[]) invokeV.objValue;
    }
}

package com.xiaomi.push.service.module;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Deprecated
/* loaded from: classes6.dex */
public final class PushChannelRegion {
    public static final /* synthetic */ PushChannelRegion[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PushChannelRegion China;
    public static final PushChannelRegion Europe;
    public static final PushChannelRegion Global;
    public static final PushChannelRegion India;
    public static final PushChannelRegion Russia;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-712867828, "Lcom/xiaomi/push/service/module/PushChannelRegion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-712867828, "Lcom/xiaomi/push/service/module/PushChannelRegion;");
                return;
            }
        }
        China = new PushChannelRegion("China", 0);
        Global = new PushChannelRegion("Global", 1);
        Europe = new PushChannelRegion("Europe", 2);
        Russia = new PushChannelRegion("Russia", 3);
        PushChannelRegion pushChannelRegion = new PushChannelRegion("India", 4);
        India = pushChannelRegion;
        $VALUES = new PushChannelRegion[]{China, Global, Europe, Russia, pushChannelRegion};
    }

    public PushChannelRegion(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PushChannelRegion valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PushChannelRegion) Enum.valueOf(PushChannelRegion.class, str) : (PushChannelRegion) invokeL.objValue;
    }

    public static PushChannelRegion[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PushChannelRegion[]) $VALUES.clone() : (PushChannelRegion[]) invokeV.objValue;
    }
}

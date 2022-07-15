package com.kwad.components.ad.reward.page;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class BackPressHandleResult {
    public static final /* synthetic */ BackPressHandleResult[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BackPressHandleResult HANDLED;
    public static final BackPressHandleResult HANDLED_CLOSE;
    public static final BackPressHandleResult NOT_HANDLED;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1379049773, "Lcom/kwad/components/ad/reward/page/BackPressHandleResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1379049773, "Lcom/kwad/components/ad/reward/page/BackPressHandleResult;");
                return;
            }
        }
        NOT_HANDLED = new BackPressHandleResult("NOT_HANDLED", 0, 1);
        HANDLED = new BackPressHandleResult("HANDLED", 1, 2);
        BackPressHandleResult backPressHandleResult = new BackPressHandleResult("HANDLED_CLOSE", 2, 3);
        HANDLED_CLOSE = backPressHandleResult;
        $VALUES = new BackPressHandleResult[]{NOT_HANDLED, HANDLED, backPressHandleResult};
    }

    public BackPressHandleResult(String str, int i, int i2) {
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
        this.value = i2;
    }

    public static BackPressHandleResult valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BackPressHandleResult) Enum.valueOf(BackPressHandleResult.class, str) : (BackPressHandleResult) invokeL.objValue;
    }

    public static BackPressHandleResult[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BackPressHandleResult[]) $VALUES.clone() : (BackPressHandleResult[]) invokeV.objValue;
    }
}

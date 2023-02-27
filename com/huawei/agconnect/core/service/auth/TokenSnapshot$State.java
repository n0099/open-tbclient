package com.huawei.agconnect.core.service.auth;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class TokenSnapshot$State {
    public static final /* synthetic */ TokenSnapshot$State[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TokenSnapshot$State SIGNED_IN;
    public static final TokenSnapshot$State SIGNED_OUT;
    public static final TokenSnapshot$State TOKEN_INVALID;
    public static final TokenSnapshot$State TOKEN_UPDATED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1409339993, "Lcom/huawei/agconnect/core/service/auth/TokenSnapshot$State;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1409339993, "Lcom/huawei/agconnect/core/service/auth/TokenSnapshot$State;");
                return;
            }
        }
        SIGNED_IN = new TokenSnapshot$State("SIGNED_IN", 0);
        TOKEN_UPDATED = new TokenSnapshot$State("TOKEN_UPDATED", 1);
        TOKEN_INVALID = new TokenSnapshot$State("TOKEN_INVALID", 2);
        TokenSnapshot$State tokenSnapshot$State = new TokenSnapshot$State("SIGNED_OUT", 3);
        SIGNED_OUT = tokenSnapshot$State;
        $VALUES = new TokenSnapshot$State[]{SIGNED_IN, TOKEN_UPDATED, TOKEN_INVALID, tokenSnapshot$State};
    }

    public TokenSnapshot$State(String str, int i) {
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

    public static TokenSnapshot$State valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TokenSnapshot$State) Enum.valueOf(TokenSnapshot$State.class, str) : (TokenSnapshot$State) invokeL.objValue;
    }

    public static TokenSnapshot$State[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TokenSnapshot$State[]) $VALUES.clone() : (TokenSnapshot$State[]) invokeV.objValue;
    }
}

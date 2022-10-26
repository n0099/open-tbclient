package com.google.android.gms.internal.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class zzl extends zzk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final char zza;

    public zzl(char c) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Character.valueOf(c)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = c;
    }

    @Override // com.google.android.gms.internal.common.zzo
    public final boolean zza(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c)})) == null) ? c == this.zza : invokeCommon.booleanValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.zza;
            char[] cArr = {'\\', 'u', 0, 0, 0, 0};
            for (int i2 = 0; i2 < 4; i2++) {
                cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
                i >>= 4;
            }
            String copyValueOf = String.copyValueOf(cArr);
            StringBuilder sb = new StringBuilder(String.valueOf(copyValueOf).length() + 18);
            sb.append("CharMatcher.is('");
            sb.append(copyValueOf);
            sb.append("')");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

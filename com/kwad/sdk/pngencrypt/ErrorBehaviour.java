package com.kwad.sdk.pngencrypt;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class ErrorBehaviour {
    public static final /* synthetic */ ErrorBehaviour[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ErrorBehaviour LENIENT1_CRC;
    public static final ErrorBehaviour LENIENT2_ANCILLARY;
    public static final ErrorBehaviour STRICT;
    public static final ErrorBehaviour SUPER_LENIENT;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final int f38668c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1312184754, "Lcom/kwad/sdk/pngencrypt/ErrorBehaviour;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1312184754, "Lcom/kwad/sdk/pngencrypt/ErrorBehaviour;");
                return;
            }
        }
        STRICT = new ErrorBehaviour("STRICT", 0, 0);
        LENIENT1_CRC = new ErrorBehaviour("LENIENT1_CRC", 1, 1);
        LENIENT2_ANCILLARY = new ErrorBehaviour("LENIENT2_ANCILLARY", 2, 3);
        ErrorBehaviour errorBehaviour = new ErrorBehaviour("SUPER_LENIENT", 3, 5);
        SUPER_LENIENT = errorBehaviour;
        $VALUES = new ErrorBehaviour[]{STRICT, LENIENT1_CRC, LENIENT2_ANCILLARY, errorBehaviour};
    }

    public ErrorBehaviour(String str, int i2, int i3) {
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
        this.f38668c = i3;
    }

    public static ErrorBehaviour valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ErrorBehaviour) Enum.valueOf(ErrorBehaviour.class, str) : (ErrorBehaviour) invokeL.objValue;
    }

    public static ErrorBehaviour[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ErrorBehaviour[]) $VALUES.clone() : (ErrorBehaviour[]) invokeV.objValue;
    }
}

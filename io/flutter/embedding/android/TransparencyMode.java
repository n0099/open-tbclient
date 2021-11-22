package io.flutter.embedding.android;

import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class TransparencyMode {
    public static final /* synthetic */ TransparencyMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TransparencyMode opaque;
    public static final TransparencyMode transparent;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1674821256, "Lio/flutter/embedding/android/TransparencyMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1674821256, "Lio/flutter/embedding/android/TransparencyMode;");
                return;
            }
        }
        opaque = new TransparencyMode("opaque", 0);
        TransparencyMode transparencyMode = new TransparencyMode(OpenFlutter.EXTRA_TRANSPARANT, 1);
        transparent = transparencyMode;
        $VALUES = new TransparencyMode[]{opaque, transparencyMode};
    }

    public TransparencyMode(String str, int i2) {
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

    public static TransparencyMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TransparencyMode) Enum.valueOf(TransparencyMode.class, str) : (TransparencyMode) invokeL.objValue;
    }

    public static TransparencyMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TransparencyMode[]) $VALUES.clone() : (TransparencyMode[]) invokeV.objValue;
    }
}

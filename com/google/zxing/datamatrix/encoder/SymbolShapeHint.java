package com.google.zxing.datamatrix.encoder;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class SymbolShapeHint {
    public static final /* synthetic */ SymbolShapeHint[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SymbolShapeHint FORCE_NONE;
    public static final SymbolShapeHint FORCE_RECTANGLE;
    public static final SymbolShapeHint FORCE_SQUARE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1357395355, "Lcom/google/zxing/datamatrix/encoder/SymbolShapeHint;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1357395355, "Lcom/google/zxing/datamatrix/encoder/SymbolShapeHint;");
                return;
            }
        }
        FORCE_NONE = new SymbolShapeHint("FORCE_NONE", 0);
        FORCE_SQUARE = new SymbolShapeHint("FORCE_SQUARE", 1);
        SymbolShapeHint symbolShapeHint = new SymbolShapeHint("FORCE_RECTANGLE", 2);
        FORCE_RECTANGLE = symbolShapeHint;
        $VALUES = new SymbolShapeHint[]{FORCE_NONE, FORCE_SQUARE, symbolShapeHint};
    }

    public SymbolShapeHint(String str, int i2) {
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

    public static SymbolShapeHint valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SymbolShapeHint) Enum.valueOf(SymbolShapeHint.class, str) : (SymbolShapeHint) invokeL.objValue;
    }

    public static SymbolShapeHint[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SymbolShapeHint[]) $VALUES.clone() : (SymbolShapeHint[]) invokeV.objValue;
    }
}

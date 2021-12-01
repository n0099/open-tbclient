package com.google.zxing;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class EncodeHintType {
    public static final /* synthetic */ EncodeHintType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EncodeHintType AZTEC_LAYERS;
    public static final EncodeHintType CHARACTER_SET;
    public static final EncodeHintType DATA_MATRIX_SHAPE;
    public static final EncodeHintType ERROR_CORRECTION;
    public static final EncodeHintType MARGIN;
    @Deprecated
    public static final EncodeHintType MAX_SIZE;
    @Deprecated
    public static final EncodeHintType MIN_SIZE;
    public static final EncodeHintType PDF417_COMPACT;
    public static final EncodeHintType PDF417_COMPACTION;
    public static final EncodeHintType PDF417_DIMENSIONS;
    public static final EncodeHintType QR_VERSION;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1975255805, "Lcom/google/zxing/EncodeHintType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1975255805, "Lcom/google/zxing/EncodeHintType;");
                return;
            }
        }
        ERROR_CORRECTION = new EncodeHintType("ERROR_CORRECTION", 0);
        CHARACTER_SET = new EncodeHintType("CHARACTER_SET", 1);
        DATA_MATRIX_SHAPE = new EncodeHintType("DATA_MATRIX_SHAPE", 2);
        MIN_SIZE = new EncodeHintType("MIN_SIZE", 3);
        MAX_SIZE = new EncodeHintType("MAX_SIZE", 4);
        MARGIN = new EncodeHintType("MARGIN", 5);
        PDF417_COMPACT = new EncodeHintType("PDF417_COMPACT", 6);
        PDF417_COMPACTION = new EncodeHintType("PDF417_COMPACTION", 7);
        PDF417_DIMENSIONS = new EncodeHintType("PDF417_DIMENSIONS", 8);
        AZTEC_LAYERS = new EncodeHintType("AZTEC_LAYERS", 9);
        EncodeHintType encodeHintType = new EncodeHintType("QR_VERSION", 10);
        QR_VERSION = encodeHintType;
        $VALUES = new EncodeHintType[]{ERROR_CORRECTION, CHARACTER_SET, DATA_MATRIX_SHAPE, MIN_SIZE, MAX_SIZE, MARGIN, PDF417_COMPACT, PDF417_COMPACTION, PDF417_DIMENSIONS, AZTEC_LAYERS, encodeHintType};
    }

    public EncodeHintType(String str, int i2) {
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

    public static EncodeHintType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EncodeHintType) Enum.valueOf(EncodeHintType.class, str) : (EncodeHintType) invokeL.objValue;
    }

    public static EncodeHintType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EncodeHintType[]) $VALUES.clone() : (EncodeHintType[]) invokeV.objValue;
    }
}

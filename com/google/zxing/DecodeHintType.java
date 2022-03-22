package com.google.zxing;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class DecodeHintType {
    public static final /* synthetic */ DecodeHintType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DecodeHintType ALLOWED_EAN_EXTENSIONS;
    public static final DecodeHintType ALLOWED_LENGTHS;
    public static final DecodeHintType ASSUME_CODE_39_CHECK_DIGIT;
    public static final DecodeHintType ASSUME_GS1;
    public static final DecodeHintType CHARACTER_SET;
    public static final DecodeHintType NEED_RESULT_POINT_CALLBACK;
    public static final DecodeHintType OTHER;
    public static final DecodeHintType POSSIBLE_FORMATS;
    public static final DecodeHintType PURE_BARCODE;
    public static final DecodeHintType RETURN_CODABAR_START_END;
    public static final DecodeHintType TRY_HARDER;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<?> valueType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(722764325, "Lcom/google/zxing/DecodeHintType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(722764325, "Lcom/google/zxing/DecodeHintType;");
                return;
            }
        }
        OTHER = new DecodeHintType("OTHER", 0, Object.class);
        PURE_BARCODE = new DecodeHintType("PURE_BARCODE", 1, Void.class);
        POSSIBLE_FORMATS = new DecodeHintType("POSSIBLE_FORMATS", 2, List.class);
        TRY_HARDER = new DecodeHintType("TRY_HARDER", 3, Void.class);
        CHARACTER_SET = new DecodeHintType("CHARACTER_SET", 4, String.class);
        ALLOWED_LENGTHS = new DecodeHintType("ALLOWED_LENGTHS", 5, int[].class);
        ASSUME_CODE_39_CHECK_DIGIT = new DecodeHintType("ASSUME_CODE_39_CHECK_DIGIT", 6, Void.class);
        ASSUME_GS1 = new DecodeHintType("ASSUME_GS1", 7, Void.class);
        RETURN_CODABAR_START_END = new DecodeHintType("RETURN_CODABAR_START_END", 8, Void.class);
        NEED_RESULT_POINT_CALLBACK = new DecodeHintType("NEED_RESULT_POINT_CALLBACK", 9, ResultPointCallback.class);
        DecodeHintType decodeHintType = new DecodeHintType("ALLOWED_EAN_EXTENSIONS", 10, int[].class);
        ALLOWED_EAN_EXTENSIONS = decodeHintType;
        $VALUES = new DecodeHintType[]{OTHER, PURE_BARCODE, POSSIBLE_FORMATS, TRY_HARDER, CHARACTER_SET, ALLOWED_LENGTHS, ASSUME_CODE_39_CHECK_DIGIT, ASSUME_GS1, RETURN_CODABAR_START_END, NEED_RESULT_POINT_CALLBACK, decodeHintType};
    }

    public DecodeHintType(String str, int i, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.valueType = cls;
    }

    public static DecodeHintType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DecodeHintType) Enum.valueOf(DecodeHintType.class, str) : (DecodeHintType) invokeL.objValue;
    }

    public static DecodeHintType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DecodeHintType[]) $VALUES.clone() : (DecodeHintType[]) invokeV.objValue;
    }

    public Class<?> getValueType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.valueType : (Class) invokeV.objValue;
    }
}

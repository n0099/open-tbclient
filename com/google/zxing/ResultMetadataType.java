package com.google.zxing;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class ResultMetadataType {
    public static final /* synthetic */ ResultMetadataType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ResultMetadataType BYTE_SEGMENTS;
    public static final ResultMetadataType ERROR_CORRECTION_LEVEL;
    public static final ResultMetadataType ISSUE_NUMBER;
    public static final ResultMetadataType ORIENTATION;
    public static final ResultMetadataType OTHER;
    public static final ResultMetadataType PDF417_EXTRA_METADATA;
    public static final ResultMetadataType POSSIBLE_COUNTRY;
    public static final ResultMetadataType STRUCTURED_APPEND_PARITY;
    public static final ResultMetadataType STRUCTURED_APPEND_SEQUENCE;
    public static final ResultMetadataType SUGGESTED_PRICE;
    public static final ResultMetadataType UPC_EAN_EXTENSION;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2072244434, "Lcom/google/zxing/ResultMetadataType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2072244434, "Lcom/google/zxing/ResultMetadataType;");
                return;
            }
        }
        OTHER = new ResultMetadataType("OTHER", 0);
        ORIENTATION = new ResultMetadataType("ORIENTATION", 1);
        BYTE_SEGMENTS = new ResultMetadataType("BYTE_SEGMENTS", 2);
        ERROR_CORRECTION_LEVEL = new ResultMetadataType("ERROR_CORRECTION_LEVEL", 3);
        ISSUE_NUMBER = new ResultMetadataType("ISSUE_NUMBER", 4);
        SUGGESTED_PRICE = new ResultMetadataType("SUGGESTED_PRICE", 5);
        POSSIBLE_COUNTRY = new ResultMetadataType("POSSIBLE_COUNTRY", 6);
        UPC_EAN_EXTENSION = new ResultMetadataType("UPC_EAN_EXTENSION", 7);
        PDF417_EXTRA_METADATA = new ResultMetadataType("PDF417_EXTRA_METADATA", 8);
        STRUCTURED_APPEND_SEQUENCE = new ResultMetadataType("STRUCTURED_APPEND_SEQUENCE", 9);
        ResultMetadataType resultMetadataType = new ResultMetadataType("STRUCTURED_APPEND_PARITY", 10);
        STRUCTURED_APPEND_PARITY = resultMetadataType;
        $VALUES = new ResultMetadataType[]{OTHER, ORIENTATION, BYTE_SEGMENTS, ERROR_CORRECTION_LEVEL, ISSUE_NUMBER, SUGGESTED_PRICE, POSSIBLE_COUNTRY, UPC_EAN_EXTENSION, PDF417_EXTRA_METADATA, STRUCTURED_APPEND_SEQUENCE, resultMetadataType};
    }

    public ResultMetadataType(String str, int i) {
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

    public static ResultMetadataType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ResultMetadataType) Enum.valueOf(ResultMetadataType.class, str);
        }
        return (ResultMetadataType) invokeL.objValue;
    }

    public static ResultMetadataType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ResultMetadataType[]) $VALUES.clone();
        }
        return (ResultMetadataType[]) invokeV.objValue;
    }
}

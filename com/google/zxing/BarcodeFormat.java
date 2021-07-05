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
public final class BarcodeFormat {
    public static final /* synthetic */ BarcodeFormat[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BarcodeFormat AZTEC;
    public static final BarcodeFormat CODABAR;
    public static final BarcodeFormat CODE_128;
    public static final BarcodeFormat CODE_39;
    public static final BarcodeFormat CODE_93;
    public static final BarcodeFormat DATA_MATRIX;
    public static final BarcodeFormat EAN_13;
    public static final BarcodeFormat EAN_8;
    public static final BarcodeFormat ITF;
    public static final BarcodeFormat MAXICODE;
    public static final BarcodeFormat PDF_417;
    public static final BarcodeFormat QR_CODE;
    public static final BarcodeFormat RSS_14;
    public static final BarcodeFormat RSS_EXPANDED;
    public static final BarcodeFormat UPC_A;
    public static final BarcodeFormat UPC_E;
    public static final BarcodeFormat UPC_EAN_EXTENSION;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-583642901, "Lcom/google/zxing/BarcodeFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-583642901, "Lcom/google/zxing/BarcodeFormat;");
                return;
            }
        }
        AZTEC = new BarcodeFormat("AZTEC", 0);
        CODABAR = new BarcodeFormat("CODABAR", 1);
        CODE_39 = new BarcodeFormat("CODE_39", 2);
        CODE_93 = new BarcodeFormat("CODE_93", 3);
        CODE_128 = new BarcodeFormat("CODE_128", 4);
        DATA_MATRIX = new BarcodeFormat("DATA_MATRIX", 5);
        EAN_8 = new BarcodeFormat("EAN_8", 6);
        EAN_13 = new BarcodeFormat("EAN_13", 7);
        ITF = new BarcodeFormat("ITF", 8);
        MAXICODE = new BarcodeFormat("MAXICODE", 9);
        PDF_417 = new BarcodeFormat("PDF_417", 10);
        QR_CODE = new BarcodeFormat("QR_CODE", 11);
        RSS_14 = new BarcodeFormat("RSS_14", 12);
        RSS_EXPANDED = new BarcodeFormat("RSS_EXPANDED", 13);
        UPC_A = new BarcodeFormat("UPC_A", 14);
        UPC_E = new BarcodeFormat("UPC_E", 15);
        BarcodeFormat barcodeFormat = new BarcodeFormat("UPC_EAN_EXTENSION", 16);
        UPC_EAN_EXTENSION = barcodeFormat;
        $VALUES = new BarcodeFormat[]{AZTEC, CODABAR, CODE_39, CODE_93, CODE_128, DATA_MATRIX, EAN_8, EAN_13, ITF, MAXICODE, PDF_417, QR_CODE, RSS_14, RSS_EXPANDED, UPC_A, UPC_E, barcodeFormat};
    }

    public BarcodeFormat(String str, int i2) {
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

    public static BarcodeFormat valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BarcodeFormat) Enum.valueOf(BarcodeFormat.class, str) : (BarcodeFormat) invokeL.objValue;
    }

    public static BarcodeFormat[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BarcodeFormat[]) $VALUES.clone() : (BarcodeFormat[]) invokeV.objValue;
    }
}

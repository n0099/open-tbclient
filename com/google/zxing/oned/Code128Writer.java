package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_CODE_B = 100;
    public static final int CODE_CODE_C = 99;
    public static final int CODE_FNC_1 = 102;
    public static final int CODE_FNC_2 = 97;
    public static final int CODE_FNC_3 = 96;
    public static final int CODE_FNC_4_B = 100;
    public static final int CODE_START_B = 104;
    public static final int CODE_START_C = 105;
    public static final int CODE_STOP = 106;
    public static final char ESCAPE_FNC_1 = 241;
    public static final char ESCAPE_FNC_2 = 242;
    public static final char ESCAPE_FNC_3 = 243;
    public static final char ESCAPE_FNC_4 = 244;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class CType {
        public static final /* synthetic */ CType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CType FNC_1;
        public static final CType ONE_DIGIT;
        public static final CType TWO_DIGITS;
        public static final CType UNCODABLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(310072367, "Lcom/google/zxing/oned/Code128Writer$CType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(310072367, "Lcom/google/zxing/oned/Code128Writer$CType;");
                    return;
                }
            }
            UNCODABLE = new CType("UNCODABLE", 0);
            ONE_DIGIT = new CType("ONE_DIGIT", 1);
            TWO_DIGITS = new CType("TWO_DIGITS", 2);
            CType cType = new CType("FNC_1", 3);
            FNC_1 = cType;
            $VALUES = new CType[]{UNCODABLE, ONE_DIGIT, TWO_DIGITS, cType};
        }

        public CType(String str, int i2) {
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

        public static CType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CType) Enum.valueOf(CType.class, str) : (CType) invokeL.objValue;
        }

        public static CType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CType[]) $VALUES.clone() : (CType[]) invokeV.objValue;
        }
    }

    public Code128Writer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int chooseCode(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        CType findCType;
        CType findCType2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, charSequence, i2, i3)) == null) {
            CType findCType3 = findCType(charSequence, i2);
            if (findCType3 != CType.UNCODABLE && findCType3 != CType.ONE_DIGIT) {
                if (i3 == 99) {
                    return i3;
                }
                if (i3 == 100) {
                    if (findCType3 == CType.FNC_1 || (findCType = findCType(charSequence, i2 + 2)) == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
                        return i3;
                    }
                    if (findCType == CType.FNC_1) {
                        return findCType(charSequence, i2 + 3) == CType.TWO_DIGITS ? 99 : 100;
                    }
                    int i4 = i2 + 4;
                    while (true) {
                        findCType2 = findCType(charSequence, i4);
                        if (findCType2 != CType.TWO_DIGITS) {
                            break;
                        }
                        i4 += 2;
                    }
                    return findCType2 == CType.ONE_DIGIT ? 100 : 99;
                }
                if (findCType3 == CType.FNC_1) {
                    findCType3 = findCType(charSequence, i2 + 1);
                }
                if (findCType3 == CType.TWO_DIGITS) {
                    return 99;
                }
            }
            return 100;
        }
        return invokeLII.intValue;
    }

    public static CType findCType(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, charSequence, i2)) == null) {
            int length = charSequence.length();
            if (i2 >= length) {
                return CType.UNCODABLE;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt == 241) {
                return CType.FNC_1;
            }
            if (charAt < '0' || charAt > '9') {
                return CType.UNCODABLE;
            }
            int i3 = i2 + 1;
            if (i3 >= length) {
                return CType.ONE_DIGIT;
            }
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 >= '0' && charAt2 <= '9') {
                return CType.TWO_DIGITS;
            }
            return CType.ONE_DIGIT;
        }
        return (CType) invokeLI.objValue;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            if (barcodeFormat == BarcodeFormat.CODE_128) {
                return super.encode(str, barcodeFormat, i2, i3, map);
            }
            throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int length = str.length();
            if (length > 0 && length <= 80) {
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = str.charAt(i3);
                    if (charAt < ' ' || charAt > '~') {
                        switch (charAt) {
                            case 241:
                            case 242:
                            case LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK /* 243 */:
                            case 244:
                                break;
                            default:
                                throw new IllegalArgumentException("Bad character in input: " + charAt);
                        }
                    }
                }
                ArrayList<int[]> arrayList = new ArrayList();
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 1;
                while (i4 < length) {
                    int chooseCode = chooseCode(str, i4, i6);
                    int i8 = 100;
                    if (chooseCode == i6) {
                        switch (str.charAt(i4)) {
                            case 241:
                                i8 = 102;
                                break;
                            case 242:
                                i8 = 97;
                                break;
                            case LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK /* 243 */:
                                i8 = 96;
                                break;
                            case 244:
                                break;
                            default:
                                if (i6 != 100) {
                                    i8 = Integer.parseInt(str.substring(i4, i4 + 2));
                                    i4++;
                                    break;
                                } else {
                                    i8 = str.charAt(i4) - ' ';
                                    break;
                                }
                        }
                        i4++;
                    } else {
                        i8 = i6 == 0 ? chooseCode == 100 ? 104 : 105 : chooseCode;
                        i6 = chooseCode;
                    }
                    arrayList.add(Code128Reader.CODE_PATTERNS[i8]);
                    i5 += i8 * i7;
                    if (i4 != 0) {
                        i7++;
                    }
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i5 % 103]);
                arrayList.add(Code128Reader.CODE_PATTERNS[106]);
                int i9 = 0;
                for (int[] iArr : arrayList) {
                    for (int i10 : iArr) {
                        i9 += i10;
                    }
                }
                boolean[] zArr = new boolean[i9];
                for (int[] iArr2 : arrayList) {
                    i2 += OneDimensionalCodeWriter.appendPattern(zArr, i2, iArr2, true);
                }
                return zArr;
            }
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        return (boolean[]) invokeL.objValue;
    }
}

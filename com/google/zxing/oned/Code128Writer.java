package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
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

        public CType(String str, int i) {
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

        public static CType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CType) Enum.valueOf(CType.class, str);
            }
            return (CType) invokeL.objValue;
        }

        public static CType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CType[]) $VALUES.clone();
            }
            return (CType[]) invokeV.objValue;
        }
    }

    public Code128Writer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int chooseCode(CharSequence charSequence, int i, int i2) {
        InterceptResult invokeLII;
        CType findCType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, charSequence, i, i2)) == null) {
            CType findCType2 = findCType(charSequence, i);
            if (findCType2 != CType.UNCODABLE && findCType2 != CType.ONE_DIGIT) {
                if (i2 == 99) {
                    return i2;
                }
                if (i2 == 100) {
                    if (findCType2 == CType.FNC_1) {
                        return i2;
                    }
                    CType findCType3 = findCType(charSequence, i + 2);
                    if (findCType3 != CType.UNCODABLE && findCType3 != CType.ONE_DIGIT) {
                        if (findCType3 == CType.FNC_1) {
                            if (findCType(charSequence, i + 3) != CType.TWO_DIGITS) {
                                return 100;
                            }
                            return 99;
                        }
                        int i3 = i + 4;
                        while (true) {
                            findCType = findCType(charSequence, i3);
                            if (findCType != CType.TWO_DIGITS) {
                                break;
                            }
                            i3 += 2;
                        }
                        if (findCType == CType.ONE_DIGIT) {
                            return 100;
                        }
                        return 99;
                    }
                    return i2;
                }
                if (findCType2 == CType.FNC_1) {
                    findCType2 = findCType(charSequence, i + 1);
                }
                if (findCType2 == CType.TWO_DIGITS) {
                    return 99;
                }
            }
            return 100;
        }
        return invokeLII.intValue;
    }

    public static CType findCType(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, charSequence, i)) == null) {
            int length = charSequence.length();
            if (i >= length) {
                return CType.UNCODABLE;
            }
            char charAt = charSequence.charAt(i);
            if (charAt == 241) {
                return CType.FNC_1;
            }
            if (charAt >= '0' && charAt <= '9') {
                int i2 = i + 1;
                if (i2 >= length) {
                    return CType.ONE_DIGIT;
                }
                char charAt2 = charSequence.charAt(i2);
                if (charAt2 >= '0' && charAt2 <= '9') {
                    return CType.TWO_DIGITS;
                }
                return CType.ONE_DIGIT;
            }
            return CType.UNCODABLE;
        }
        return (CType) invokeLI.objValue;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, barcodeFormat, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            if (barcodeFormat == BarcodeFormat.CODE_128) {
                return super.encode(str, barcodeFormat, i, i2, map);
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
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    if (charAt < ' ' || charAt > '~') {
                        switch (charAt) {
                            case MatroskaExtractor.ID_CUE_CLUSTER_POSITION /* 241 */:
                            case 242:
                            case 243:
                            case GDiffPatcher.COPY_UBYTE_UBYTE /* 244 */:
                                break;
                            default:
                                throw new IllegalArgumentException("Bad character in input: " + charAt);
                        }
                    }
                }
                ArrayList<int[]> arrayList = new ArrayList();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 1;
                while (i3 < length) {
                    int chooseCode = chooseCode(str, i3, i5);
                    int i7 = 100;
                    if (chooseCode == i5) {
                        switch (str.charAt(i3)) {
                            case MatroskaExtractor.ID_CUE_CLUSTER_POSITION /* 241 */:
                                i7 = 102;
                                break;
                            case 242:
                                i7 = 97;
                                break;
                            case 243:
                                i7 = 96;
                                break;
                            case GDiffPatcher.COPY_UBYTE_UBYTE /* 244 */:
                                break;
                            default:
                                if (i5 != 100) {
                                    i7 = Integer.parseInt(str.substring(i3, i3 + 2));
                                    i3++;
                                    break;
                                } else {
                                    i7 = str.charAt(i3) - ' ';
                                    break;
                                }
                        }
                        i3++;
                    } else {
                        if (i5 == 0) {
                            if (chooseCode == 100) {
                                i7 = 104;
                            } else {
                                i7 = 105;
                            }
                        } else {
                            i7 = chooseCode;
                        }
                        i5 = chooseCode;
                    }
                    arrayList.add(Code128Reader.CODE_PATTERNS[i7]);
                    i4 += i7 * i6;
                    if (i3 != 0) {
                        i6++;
                    }
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i4 % 103]);
                arrayList.add(Code128Reader.CODE_PATTERNS[106]);
                int i8 = 0;
                for (int[] iArr : arrayList) {
                    for (int i9 : iArr) {
                        i8 += i9;
                    }
                }
                boolean[] zArr = new boolean[i8];
                for (int[] iArr2 : arrayList) {
                    i += OneDimensionalCodeWriter.appendPattern(zArr, i, iArr2, true);
                }
                return zArr;
            }
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        return (boolean[]) invokeL.objValue;
    }
}

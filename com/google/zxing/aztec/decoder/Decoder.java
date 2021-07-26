package com.google.zxing.aztec.decoder;

import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.google.android.material.badge.BadgeDrawable;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class Decoder {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] DIGIT_TABLE;
    public static final String[] LOWER_TABLE;
    public static final String[] MIXED_TABLE;
    public static final String[] PUNCT_TABLE;
    public static final String[] UPPER_TABLE;
    public transient /* synthetic */ FieldHolder $fh;
    public AztecDetectorResult ddata;

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1048157042, "Lcom/google/zxing/aztec/decoder/Decoder$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1048157042, "Lcom/google/zxing/aztec/decoder/Decoder$1;");
                    return;
                }
            }
            int[] iArr = new int[Table.values().length];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Table {
        public static final /* synthetic */ Table[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Table BINARY;
        public static final Table DIGIT;
        public static final Table LOWER;
        public static final Table MIXED;
        public static final Table PUNCT;
        public static final Table UPPER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(645520277, "Lcom/google/zxing/aztec/decoder/Decoder$Table;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(645520277, "Lcom/google/zxing/aztec/decoder/Decoder$Table;");
                    return;
                }
            }
            UPPER = new Table("UPPER", 0);
            LOWER = new Table("LOWER", 1);
            MIXED = new Table("MIXED", 2);
            DIGIT = new Table("DIGIT", 3);
            PUNCT = new Table("PUNCT", 4);
            Table table = new Table("BINARY", 5);
            BINARY = table;
            $VALUES = new Table[]{UPPER, LOWER, MIXED, DIGIT, PUNCT, table};
        }

        public Table(String str, int i2) {
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

        public static Table valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Table) Enum.valueOf(Table.class, str) : (Table) invokeL.objValue;
        }

        public static Table[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Table[]) $VALUES.clone() : (Table[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1058125985, "Lcom/google/zxing/aztec/decoder/Decoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1058125985, "Lcom/google/zxing/aztec/decoder/Decoder;");
                return;
            }
        }
        UPPER_TABLE = new String[]{"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
        LOWER_TABLE = new String[]{"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", Config.APP_KEY, "l", "m", "n", Config.OS, "p", IAdRequestParam.COST_NAME, r.f7788a, "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
        MIXED_TABLE = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", TrackUI.SEPERATOR, "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", TNCManager.TNC_PROBE_HEADER_SECEPTOR, IStringUtil.WINDOWS_FOLDER_SEPARATOR, PayTypeItemView.PayTypeItemViewData.MASK_FLAG, "_", "`", "|", Constants.WAVE_SEPARATOR, "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
        PUNCT_TABLE = new String[]{"", "\r", Part.CRLF, ". ", StringUtil.ARRAY_ELEMENT_SEPARATOR, ": ", "!", "\"", "#", "$", "%", "&", "'", "(", SmallTailInfo.EMOTION_SUFFIX, "*", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", PreferencesUtil.LEFT_MOUNT, PreferencesUtil.RIGHT_MOUNT, StringUtil.ARRAY_START, "}", "CTRL_UL"};
        DIGIT_TABLE = new String[]{"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    }

    public Decoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zArr)) == null) {
            int length = (zArr.length + 7) / 8;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                bArr[i2] = readByte(zArr, i2 << 3);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        InterceptResult invokeL;
        GenericGF genericGF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, zArr)) == null) {
            int i2 = 8;
            if (this.ddata.getNbLayers() <= 2) {
                i2 = 6;
                genericGF = GenericGF.AZTEC_DATA_6;
            } else if (this.ddata.getNbLayers() <= 8) {
                genericGF = GenericGF.AZTEC_DATA_8;
            } else if (this.ddata.getNbLayers() <= 22) {
                i2 = 10;
                genericGF = GenericGF.AZTEC_DATA_10;
            } else {
                i2 = 12;
                genericGF = GenericGF.AZTEC_DATA_12;
            }
            int nbDatablocks = this.ddata.getNbDatablocks();
            int length = zArr.length / i2;
            if (length >= nbDatablocks) {
                int length2 = zArr.length % i2;
                int[] iArr = new int[length];
                int i3 = 0;
                while (i3 < length) {
                    iArr[i3] = readCode(zArr, length2, i2);
                    i3++;
                    length2 += i2;
                }
                try {
                    new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
                    int i4 = (1 << i2) - 1;
                    int i5 = 0;
                    for (int i6 = 0; i6 < nbDatablocks; i6++) {
                        int i7 = iArr[i6];
                        if (i7 == 0 || i7 == i4) {
                            throw FormatException.getFormatInstance();
                        }
                        if (i7 == 1 || i7 == i4 - 1) {
                            i5++;
                        }
                    }
                    boolean[] zArr2 = new boolean[(nbDatablocks * i2) - i5];
                    int i8 = 0;
                    for (int i9 = 0; i9 < nbDatablocks; i9++) {
                        int i10 = iArr[i9];
                        if (i10 == 1 || i10 == i4 - 1) {
                            Arrays.fill(zArr2, i8, (i8 + i2) - 1, i10 > 1);
                            i8 += i2 - 1;
                        } else {
                            int i11 = i2 - 1;
                            while (i11 >= 0) {
                                int i12 = i8 + 1;
                                zArr2[i8] = ((1 << i11) & i10) != 0;
                                i11--;
                                i8 = i12;
                            }
                        }
                    }
                    return zArr2;
                } catch (ReedSolomonException e2) {
                    throw FormatException.getFormatInstance(e2);
                }
            }
            throw FormatException.getFormatInstance();
        }
        return (boolean[]) invokeL.objValue;
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bitMatrix)) == null) {
            boolean isCompact = this.ddata.isCompact();
            int nbLayers = this.ddata.getNbLayers();
            int i2 = (isCompact ? 11 : 14) + (nbLayers << 2);
            int[] iArr = new int[i2];
            boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
            int i3 = 2;
            if (isCompact) {
                for (int i4 = 0; i4 < i2; i4++) {
                    iArr[i4] = i4;
                }
            } else {
                int i5 = i2 / 2;
                int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
                for (int i7 = 0; i7 < i5; i7++) {
                    int i8 = (i7 / 15) + i7;
                    iArr[(i5 - i7) - 1] = (i6 - i8) - 1;
                    iArr[i5 + i7] = i8 + i6 + 1;
                }
            }
            int i9 = 0;
            int i10 = 0;
            while (i9 < nbLayers) {
                int i11 = ((nbLayers - i9) << i3) + (isCompact ? 9 : 12);
                int i12 = i9 << 1;
                int i13 = (i2 - 1) - i12;
                int i14 = 0;
                while (i14 < i11) {
                    int i15 = i14 << 1;
                    int i16 = 0;
                    while (i16 < i3) {
                        int i17 = i12 + i16;
                        int i18 = i12 + i14;
                        zArr[i10 + i15 + i16] = bitMatrix.get(iArr[i17], iArr[i18]);
                        int i19 = iArr[i18];
                        int i20 = i13 - i16;
                        zArr[(i11 * 2) + i10 + i15 + i16] = bitMatrix.get(i19, iArr[i20]);
                        int i21 = i13 - i14;
                        zArr[(i11 * 4) + i10 + i15 + i16] = bitMatrix.get(iArr[i20], iArr[i21]);
                        zArr[(i11 * 6) + i10 + i15 + i16] = bitMatrix.get(iArr[i21], iArr[i17]);
                        i16++;
                        nbLayers = nbLayers;
                        isCompact = isCompact;
                        i3 = 2;
                    }
                    i14++;
                    i3 = 2;
                }
                i10 += i11 << 3;
                i9++;
                i3 = 2;
            }
            return zArr;
        }
        return (boolean[]) invokeL.objValue;
    }

    public static String getCharacter(Table table, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, table, i2)) == null) {
            int i3 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                return DIGIT_TABLE[i2];
                            }
                            throw new IllegalStateException("Bad table");
                        }
                        return PUNCT_TABLE[i2];
                    }
                    return MIXED_TABLE[i2];
                }
                return LOWER_TABLE[i2];
            }
            return UPPER_TABLE[i2];
        }
        return (String) invokeLI.objValue;
    }

    public static String getEncodedData(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, zArr)) == null) {
            int length = zArr.length;
            Table table = Table.UPPER;
            StringBuilder sb = new StringBuilder(20);
            Table table2 = table;
            int i2 = 0;
            while (i2 < length) {
                if (table != Table.BINARY) {
                    int i3 = table == Table.DIGIT ? 4 : 5;
                    if (length - i2 < i3) {
                        break;
                    }
                    int readCode = readCode(zArr, i2, i3);
                    i2 += i3;
                    String character = getCharacter(table, readCode);
                    if (character.startsWith("CTRL_")) {
                        table2 = getTable(character.charAt(5));
                        if (character.charAt(6) != 'L') {
                            table2 = table;
                            table = table2;
                        }
                    } else {
                        sb.append(character);
                    }
                    table = table2;
                } else if (length - i2 < 5) {
                    break;
                } else {
                    int readCode2 = readCode(zArr, i2, 5);
                    i2 += 5;
                    if (readCode2 == 0) {
                        if (length - i2 < 11) {
                            break;
                        }
                        readCode2 = readCode(zArr, i2, 11) + 31;
                        i2 += 11;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= readCode2) {
                            break;
                        } else if (length - i2 < 8) {
                            i2 = length;
                            break;
                        } else {
                            sb.append((char) readCode(zArr, i2, 8));
                            i2 += 8;
                            i4++;
                        }
                    }
                    table = table2;
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Table getTable(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 != 'B') {
                if (c2 != 'D') {
                    if (c2 != 'P') {
                        if (c2 != 'L') {
                            if (c2 != 'M') {
                                return Table.UPPER;
                            }
                            return Table.MIXED;
                        }
                        return Table.LOWER;
                    }
                    return Table.PUNCT;
                }
                return Table.DIGIT;
            }
            return Table.BINARY;
        }
        return (Table) invokeCommon.objValue;
    }

    public static String highLevelDecode(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, zArr)) == null) ? getEncodedData(zArr) : (String) invokeL.objValue;
    }

    public static byte readByte(boolean[] zArr, int i2) {
        InterceptResult invokeLI;
        int readCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, zArr, i2)) == null) {
            int length = zArr.length - i2;
            if (length >= 8) {
                readCode = readCode(zArr, i2, 8);
            } else {
                readCode = readCode(zArr, i2, length) << (8 - length);
            }
            return (byte) readCode;
        }
        return invokeLI.byteValue;
    }

    public static int readCode(boolean[] zArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, zArr, i2, i3)) == null) {
            int i4 = 0;
            for (int i5 = i2; i5 < i2 + i3; i5++) {
                i4 <<= 1;
                if (zArr[i5]) {
                    i4 |= 1;
                }
            }
            return i4;
        }
        return invokeLII.intValue;
    }

    public static int totalBitsInLayer(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            return ((z ? 88 : 112) + (i2 << 4)) * i2;
        }
        return invokeCommon.intValue;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aztecDetectorResult)) == null) {
            this.ddata = aztecDetectorResult;
            boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
            DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
            decoderResult.setNumBits(correctBits.length);
            return decoderResult;
        }
        return (DecoderResult) invokeL.objValue;
    }
}

package com.google.zxing.qrcode.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class Mode {
    public static final /* synthetic */ Mode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Mode ALPHANUMERIC;
    public static final Mode BYTE;
    public static final Mode ECI;
    public static final Mode FNC1_FIRST_POSITION;
    public static final Mode FNC1_SECOND_POSITION;
    public static final Mode HANZI;
    public static final Mode KANJI;
    public static final Mode NUMERIC;
    public static final Mode STRUCTURED_APPEND;
    public static final Mode TERMINATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bits;
    public final int[] characterCountBitsForVersions;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1021313645, "Lcom/google/zxing/qrcode/decoder/Mode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1021313645, "Lcom/google/zxing/qrcode/decoder/Mode;");
                return;
            }
        }
        TERMINATOR = new Mode("TERMINATOR", 0, new int[]{0, 0, 0}, 0);
        NUMERIC = new Mode("NUMERIC", 1, new int[]{10, 12, 14}, 1);
        ALPHANUMERIC = new Mode("ALPHANUMERIC", 2, new int[]{9, 11, 13}, 2);
        STRUCTURED_APPEND = new Mode("STRUCTURED_APPEND", 3, new int[]{0, 0, 0}, 3);
        BYTE = new Mode("BYTE", 4, new int[]{8, 16, 16}, 4);
        ECI = new Mode("ECI", 5, new int[]{0, 0, 0}, 7);
        KANJI = new Mode("KANJI", 6, new int[]{8, 10, 12}, 8);
        FNC1_FIRST_POSITION = new Mode("FNC1_FIRST_POSITION", 7, new int[]{0, 0, 0}, 5);
        FNC1_SECOND_POSITION = new Mode("FNC1_SECOND_POSITION", 8, new int[]{0, 0, 0}, 9);
        Mode mode = new Mode("HANZI", 9, new int[]{8, 10, 12}, 13);
        HANZI = mode;
        $VALUES = new Mode[]{TERMINATOR, NUMERIC, ALPHANUMERIC, STRUCTURED_APPEND, BYTE, ECI, KANJI, FNC1_FIRST_POSITION, FNC1_SECOND_POSITION, mode};
    }

    public Mode(String str, int i, int[] iArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), iArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.characterCountBitsForVersions = iArr;
        this.bits = i2;
    }

    public static Mode forBits(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 7) {
                                        if (i != 8) {
                                            if (i != 9) {
                                                if (i == 13) {
                                                    return HANZI;
                                                }
                                                throw new IllegalArgumentException();
                                            }
                                            return FNC1_SECOND_POSITION;
                                        }
                                        return KANJI;
                                    }
                                    return ECI;
                                }
                                return FNC1_FIRST_POSITION;
                            }
                            return BYTE;
                        }
                        return STRUCTURED_APPEND;
                    }
                    return ALPHANUMERIC;
                }
                return NUMERIC;
            }
            return TERMINATOR;
        }
        return (Mode) invokeI.objValue;
    }

    public static Mode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Mode) Enum.valueOf(Mode.class, str) : (Mode) invokeL.objValue;
    }

    public static Mode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Mode[]) $VALUES.clone() : (Mode[]) invokeV.objValue;
    }

    public int getBits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bits : invokeV.intValue;
    }

    public int getCharacterCountBits(Version version) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, version)) == null) {
            int versionNumber = version.getVersionNumber();
            return this.characterCountBitsForVersions[versionNumber <= 9 ? (char) 0 : versionNumber <= 26 ? (char) 1 : (char) 2];
        }
        return invokeL.intValue;
    }
}

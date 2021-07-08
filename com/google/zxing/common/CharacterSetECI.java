package com.google.zxing.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.base.CharEncoding;
import org.apache.http.protocol.HTTP;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class CharacterSetECI {
    public static final /* synthetic */ CharacterSetECI[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CharacterSetECI ASCII;
    public static final CharacterSetECI Big5;
    public static final CharacterSetECI Cp1250;
    public static final CharacterSetECI Cp1251;
    public static final CharacterSetECI Cp1252;
    public static final CharacterSetECI Cp1256;
    public static final CharacterSetECI Cp437;
    public static final CharacterSetECI EUC_KR;
    public static final CharacterSetECI GB18030;
    public static final CharacterSetECI ISO8859_1;
    public static final CharacterSetECI ISO8859_10;
    public static final CharacterSetECI ISO8859_11;
    public static final CharacterSetECI ISO8859_13;
    public static final CharacterSetECI ISO8859_14;
    public static final CharacterSetECI ISO8859_15;
    public static final CharacterSetECI ISO8859_16;
    public static final CharacterSetECI ISO8859_2;
    public static final CharacterSetECI ISO8859_3;
    public static final CharacterSetECI ISO8859_4;
    public static final CharacterSetECI ISO8859_5;
    public static final CharacterSetECI ISO8859_6;
    public static final CharacterSetECI ISO8859_7;
    public static final CharacterSetECI ISO8859_8;
    public static final CharacterSetECI ISO8859_9;
    public static final Map<String, CharacterSetECI> NAME_TO_ECI;
    public static final CharacterSetECI SJIS;
    public static final CharacterSetECI UTF8;
    public static final CharacterSetECI UnicodeBigUnmarked;
    public static final Map<Integer, CharacterSetECI> VALUE_TO_ECI;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] otherEncodingNames;
    public final int[] values;

    static {
        InterceptResult invokeClinit;
        CharacterSetECI[] values;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-532145274, "Lcom/google/zxing/common/CharacterSetECI;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-532145274, "Lcom/google/zxing/common/CharacterSetECI;");
                return;
            }
        }
        Cp437 = new CharacterSetECI("Cp437", 0, new int[]{0, 2}, new String[0]);
        ISO8859_1 = new CharacterSetECI(StringUtils.ISO88591, 1, new int[]{1, 3}, "ISO-8859-1");
        ISO8859_2 = new CharacterSetECI("ISO8859_2", 2, 4, "ISO-8859-2");
        ISO8859_3 = new CharacterSetECI("ISO8859_3", 3, 5, "ISO-8859-3");
        ISO8859_4 = new CharacterSetECI("ISO8859_4", 4, 6, "ISO-8859-4");
        ISO8859_5 = new CharacterSetECI("ISO8859_5", 5, 7, "ISO-8859-5");
        ISO8859_6 = new CharacterSetECI("ISO8859_6", 6, 8, "ISO-8859-6");
        ISO8859_7 = new CharacterSetECI("ISO8859_7", 7, 9, "ISO-8859-7");
        ISO8859_8 = new CharacterSetECI("ISO8859_8", 8, 10, "ISO-8859-8");
        ISO8859_9 = new CharacterSetECI("ISO8859_9", 9, 11, "ISO-8859-9");
        ISO8859_10 = new CharacterSetECI("ISO8859_10", 10, 12, "ISO-8859-10");
        ISO8859_11 = new CharacterSetECI("ISO8859_11", 11, 13, "ISO-8859-11");
        ISO8859_13 = new CharacterSetECI("ISO8859_13", 12, 15, "ISO-8859-13");
        ISO8859_14 = new CharacterSetECI("ISO8859_14", 13, 16, "ISO-8859-14");
        ISO8859_15 = new CharacterSetECI("ISO8859_15", 14, 17, "ISO-8859-15");
        ISO8859_16 = new CharacterSetECI("ISO8859_16", 15, 18, "ISO-8859-16");
        SJIS = new CharacterSetECI(StringUtils.SHIFT_JIS, 16, 20, "Shift_JIS");
        Cp1250 = new CharacterSetECI("Cp1250", 17, 21, "windows-1250");
        Cp1251 = new CharacterSetECI("Cp1251", 18, 22, "windows-1251");
        Cp1252 = new CharacterSetECI("Cp1252", 19, 23, "windows-1252");
        Cp1256 = new CharacterSetECI("Cp1256", 20, 24, "windows-1256");
        UnicodeBigUnmarked = new CharacterSetECI("UnicodeBigUnmarked", 21, 25, CharEncoding.UTF_16BE, "UnicodeBig");
        UTF8 = new CharacterSetECI(StringUtils.UTF8, 22, 26, "UTF-8");
        ASCII = new CharacterSetECI(HTTP.ASCII, 23, new int[]{27, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID}, "US-ASCII");
        Big5 = new CharacterSetECI("Big5", 24, 28);
        GB18030 = new CharacterSetECI("GB18030", 25, 29, StringUtils.GB2312, "EUC_CN", "GBK");
        CharacterSetECI characterSetECI = new CharacterSetECI("EUC_KR", 26, 30, "EUC-KR");
        EUC_KR = characterSetECI;
        $VALUES = new CharacterSetECI[]{Cp437, ISO8859_1, ISO8859_2, ISO8859_3, ISO8859_4, ISO8859_5, ISO8859_6, ISO8859_7, ISO8859_8, ISO8859_9, ISO8859_10, ISO8859_11, ISO8859_13, ISO8859_14, ISO8859_15, ISO8859_16, SJIS, Cp1250, Cp1251, Cp1252, Cp1256, UnicodeBigUnmarked, UTF8, ASCII, Big5, GB18030, characterSetECI};
        VALUE_TO_ECI = new HashMap();
        NAME_TO_ECI = new HashMap();
        for (CharacterSetECI characterSetECI2 : values()) {
            for (int i2 : characterSetECI2.values) {
                VALUE_TO_ECI.put(Integer.valueOf(i2), characterSetECI2);
            }
            NAME_TO_ECI.put(characterSetECI2.name(), characterSetECI2);
            for (String str : characterSetECI2.otherEncodingNames) {
                NAME_TO_ECI.put(str, characterSetECI2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CharacterSetECI(String str, int i2, int i3) {
        this(str, i2, new int[]{i3}, new String[0]);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (int[]) objArr2[2], (String[]) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static CharacterSetECI getCharacterSetECIByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? NAME_TO_ECI.get(str) : (CharacterSetECI) invokeL.objValue;
    }

    public static CharacterSetECI getCharacterSetECIByValue(int i2) throws FormatException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 >= 0 && i2 < 900) {
                return VALUE_TO_ECI.get(Integer.valueOf(i2));
            }
            throw FormatException.getFormatInstance();
        }
        return (CharacterSetECI) invokeI.objValue;
    }

    public static CharacterSetECI valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? (CharacterSetECI) Enum.valueOf(CharacterSetECI.class, str) : (CharacterSetECI) invokeL.objValue;
    }

    public static CharacterSetECI[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (CharacterSetECI[]) $VALUES.clone() : (CharacterSetECI[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.values[0] : invokeV.intValue;
    }

    public CharacterSetECI(String str, int i2, int i3, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), strArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.values = new int[]{i3};
        this.otherEncodingNames = strArr;
    }

    public CharacterSetECI(String str, int i2, int[] iArr, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), iArr, strArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }
}

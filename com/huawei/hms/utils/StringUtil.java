package com.huawei.hms.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.huawei.hms.framework.common.ExceptionCode;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class StringUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StringUtil() {
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

    public static String addByteForNum(String str, int i, char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), Character.valueOf(c)})) == null) {
            int length = str.length();
            if (length == i) {
                return str;
            }
            if (length > i) {
                return str.substring(length - i);
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (length < i) {
                stringBuffer.append(c);
                length++;
            }
            stringBuffer.append(str);
            return stringBuffer.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean checkVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(str).find();
        }
        return invokeL.booleanValue;
    }

    public static int convertVersion2Integer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!checkVersion(str)) {
                return 0;
            }
            String[] split = str.split("\\.");
            if (split.length < 3) {
                return 0;
            }
            int parseInt = (Integer.parseInt(split[0]) * ExceptionCode.CRASH_EXCEPTION) + (Integer.parseInt(split[1]) * DefaultOggSeeker.MATCH_BYTE_RANGE) + (Integer.parseInt(split[2]) * 1000);
            if (split.length == 4) {
                return parseInt + Integer.parseInt(split[3]);
            }
            return parseInt;
        }
        return invokeL.intValue;
    }

    public static String objDesc(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            if (obj == null) {
                return com.baidu.android.common.others.lang.StringUtil.NULL_STRING;
            }
            return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
        }
        return (String) invokeL.objValue;
    }
}

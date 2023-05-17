package com.huawei.hms.framework.common;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.secure.android.common.util.SafeString;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Locale;
/* loaded from: classes9.dex */
public class StringUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INIT_CAPACITY = 1024;
    public static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
    public static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    public static final String TAG = "StringUtils";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(919351295, "Lcom/huawei/hms/framework/common/StringUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(919351295, "Lcom/huawei/hms/framework/common/StringUtils;");
        }
    }

    public StringUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String anonymizeMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 != 0) {
                    charArray[i] = '*';
                }
            }
            return new String(charArray);
        }
        return (String) invokeL.objValue;
    }

    public static String getTraceInfo(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, th)) == null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            StringBuilder sb = new StringBuilder(1024);
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append("at ");
                sb.append(stackTraceElement.toString());
                sb.append(ParamableElem.DIVIDE_PARAM);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] str2Byte(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new byte[0];
            }
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", anonymizeMessage(e.getMessage()));
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String byte2Str(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return "";
            }
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", anonymizeMessage(e.getMessage()));
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean checkCompatible(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
            if (classLoader == null) {
                return false;
            }
            try {
                classLoader.loadClass(str);
                synchronized (StringUtils.class) {
                    IS_AEGIS_STRING_LIBRARY_LOADED = true;
                }
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static byte[] getBytes(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            return getBytes(String.valueOf(j));
        }
        return (byte[]) invokeJ.objValue;
    }

    public static String toLowerCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (str == null) {
                return "";
            }
            return str.toLowerCase(Locale.ROOT);
        }
        return (String) invokeL.objValue;
    }

    public static String collection2String(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, collection)) == null) {
            if (collection != null && !collection.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String str : collection) {
                    sb.append(str);
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
                return sb.toString().substring(0, sb.length() - 1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String format(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, objArr)) == null) {
            if (str == null) {
                return "";
            }
            return String.format(Locale.ROOT, str, objArr);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean strEquals(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (str != str2 && (str == null || !str.equals(str2))) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static byte[] getBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            byte[] bArr = new byte[0];
            if (str == null) {
                return bArr;
            }
            try {
                return str.getBytes(IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException unused) {
                Logger.w(TAG, "the content has error while it is converted to bytes");
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, str, charSequence, charSequence2)) == null) {
            if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
                try {
                    return SafeString.replace(str, charSequence, charSequence2);
                } catch (Throwable unused) {
                    Logger.w(TAG, "SafeString.substring error");
                }
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(charSequence)) {
                try {
                    return str.replace(charSequence, charSequence2);
                } catch (Exception unused2) {
                    return str;
                }
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public static String substring(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, str, i, i2)) == null) {
            if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
                try {
                    return SafeString.substring(str, i, i2);
                } catch (Throwable unused) {
                    Logger.w(TAG, "SafeString.substring error");
                }
            }
            if (!TextUtils.isEmpty(str) && i >= 0 && i2 <= str.length() && i2 >= i) {
                try {
                    return str.substring(i, i2);
                } catch (Exception unused2) {
                }
            }
            return "";
        }
        return (String) invokeLII.objValue;
    }

    public static boolean stringToBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            try {
                return Boolean.valueOf(str).booleanValue();
            } catch (NumberFormatException e) {
                Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e.getMessage()));
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static int stringToInteger(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e.getMessage()));
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static long stringToLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65551, null, str, j)) == null) {
            if (TextUtils.isEmpty(str)) {
                return j;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
                Logger.w(TAG, "String to Long catch NumberFormatException." + anonymizeMessage(e.getMessage()));
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public static String substring(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, str, i)) == null) {
            if (checkCompatible(SAFE_STRING_PATH)) {
                try {
                    return SafeString.substring(str, i);
                } catch (Throwable unused) {
                    Logger.w(TAG, "SafeString.substring error");
                }
            }
            if (!TextUtils.isEmpty(str) && str.length() >= i && i >= 0) {
                try {
                    return str.substring(i);
                } catch (Exception unused2) {
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }
}

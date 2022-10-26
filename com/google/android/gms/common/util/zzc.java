package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class zzc {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern zza;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1465918433, "Lcom/google/android/gms/common/util/zzc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1465918433, "Lcom/google/android/gms/common/util/zzc;");
                return;
            }
        }
        zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
    }

    public static String zza(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                Matcher matcher = zza.matcher(str);
                StringBuffer stringBuffer = null;
                while (matcher.find()) {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer();
                    }
                    matcher.appendReplacement(stringBuffer, new String(Character.toChars(Integer.parseInt(matcher.group().substring(2), 16))));
                }
                if (stringBuffer == null) {
                    return str;
                }
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}

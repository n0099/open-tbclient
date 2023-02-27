package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class LogsUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends Throwable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long d = 7129050843360571879L;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Throwable b;
        public Throwable c;

        public a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = th;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a = str;
            }
        }

        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.b = th;
            }
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Throwable th = this.b;
                if (th == this) {
                    return null;
                }
                return th;
            }
            return (Throwable) invokeV.objValue;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        @Override // java.lang.Throwable
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Throwable th = this.c;
                if (th == null) {
                    return "";
                }
                String name = th.getClass().getName();
                if (this.a != null) {
                    String str = name + ": ";
                    if (this.a.startsWith(str)) {
                        return this.a;
                    }
                    return str + this.a;
                }
                return name;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1554554793, "Lcom/huawei/secure/android/common/util/LogsUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1554554793, "Lcom/huawei/secure/android/common/util/LogsUtil;");
                return;
            }
        }
        a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int length = str.length();
            int i = 1;
            if (1 == length) {
                return String.valueOf('*');
            }
            StringBuilder sb = new StringBuilder(length);
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (a.matcher(String.valueOf(charAt)).matches()) {
                    if (i % 2 == 0) {
                        charAt = '*';
                    }
                    i++;
                }
                sb.append(charAt);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            StringBuilder sb = new StringBuilder(512);
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(a(str2));
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String c(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, str, z)) == null) {
            StringBuilder sb = new StringBuilder(512);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    sb.append(a(str));
                } else {
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) != null) || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, c(str2, false));
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, str, str2) != null) || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, c(str2, false));
    }

    public static void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                return;
            }
            Log.e(str, b(str2, str3));
        }
    }
}

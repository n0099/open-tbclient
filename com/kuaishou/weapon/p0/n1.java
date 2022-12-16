package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
/* loaded from: classes8.dex */
public class n1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public n1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public static String c(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                String str2 = new String(d.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2));
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                if (str2.length() >= 16) {
                    if (str2.length() > 16) {
                        substring = str2.substring(0, 16);
                    }
                    return new String(e.b(j.b(b.a(str2.substring(0, 16), str2.substring(0, 16), d.a(str.getBytes(), 2)), str2.substring(0, 16))));
                }
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                substring = sb.toString();
                str2 = substring;
                return new String(e.b(j.b(b.a(str2.substring(0, 16), str2.substring(0, 16), d.a(str.getBytes(), 2)), str2.substring(0, 16))));
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return a(str, new String(d.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                if (str2.length() < 16) {
                    int length = str2.length();
                    StringBuilder sb = new StringBuilder(str2);
                    for (int i = 0; i < 16 - length; i++) {
                        sb.append("0");
                    }
                    str2 = sb.toString();
                } else if (str2.length() > 16) {
                    str2 = str2.substring(0, 16);
                }
                byte[] a = d.a(str.getBytes(), 2);
                return new String(e.b(Engine.loadSuccess ? Engine.getInstance(this.a).dr(Engine.getInstance(this.a).dc(a, str2.substring(0, 16).getBytes()), str2.getBytes()) : j.b(b.a(str2.substring(0, 16), str2.substring(0, 16), a), str2.substring(0, 16))));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return b(str, new String(d.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            byte[] a = e.a(str.getBytes());
            if (Engine.loadSuccess) {
                bArr = Engine.getInstance(this.a).ac(Engine.getInstance(this.a).ar(a, str2.getBytes()), str2.substring(0, 16).getBytes());
            } else {
                try {
                    bArr = b.c(str2.substring(0, 16), str2.substring(0, 16), j.c(a, str2));
                } catch (Throwable unused) {
                    bArr = null;
                }
            }
            if (bArr != null && bArr.length > 0) {
                return d.c(bArr, 2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            try {
                return b(str, new String(d.a(str2.getBytes(), 2)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}

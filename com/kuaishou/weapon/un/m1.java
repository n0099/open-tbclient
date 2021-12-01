package com.kuaishou.weapon.un;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.jni.W;
/* loaded from: classes2.dex */
public class m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public m1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048 A[Catch: Exception -> 0x0087, TRY_LEAVE, TryCatch #0 {Exception -> 0x0087, blocks: (B:6:0x000a, B:9:0x0011, B:11:0x0017, B:17:0x0036, B:19:0x0048, B:12:0x001c, B:13:0x0026, B:15:0x002a, B:16:0x0032), top: B:29:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            if (str2 != null) {
                try {
                    if (str2.length() >= 16) {
                        if (str2.length() > 16) {
                            str2 = str2.substring(0, 16);
                        }
                        byte[] a = k1.a(str.getBytes(), 2);
                        W.getInstance(this.a);
                        return new String(o1.b(!W.loadSuccess ? W.getInstance(this.a).dr(W.getInstance(this.a).dc(a, str2.substring(0, 16).getBytes()), str2.getBytes()) : v1.b(i1.a(str2.substring(0, 16), str2.substring(0, 16), a), str2.substring(0, 16))));
                    }
                } catch (Exception unused) {
                    return null;
                }
            }
            int length = str2.length();
            StringBuilder sb = new StringBuilder(str2);
            for (int i2 = 0; i2 < 16 - length; i2++) {
                sb.append("0");
            }
            str2 = sb.toString();
            byte[] a2 = k1.a(str.getBytes(), 2);
            W.getInstance(this.a);
            return new String(o1.b(!W.loadSuccess ? W.getInstance(this.a).dr(W.getInstance(this.a).dc(a2, str2.substring(0, 16).getBytes()), str2.getBytes()) : v1.b(i1.a(str2.substring(0, 16), str2.substring(0, 16), a2), str2.substring(0, 16))));
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public static String c(String str) {
        String substring;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                String str2 = new String(k1.a(r1.t.getBytes(), 2));
                if (str2.length() >= 16) {
                    if (str2.length() > 16) {
                        substring = str2.substring(0, 16);
                    }
                    return new String(o1.b(v1.b(i1.a(str2.substring(0, 16), str2.substring(0, 16), k1.a(str.getBytes(), 2)), str2.substring(0, 16))));
                }
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i2 = 0; i2 < 16 - length; i2++) {
                    sb.append("0");
                }
                substring = sb.toString();
                str2 = substring;
                return new String(o1.b(v1.b(i1.a(str2.substring(0, 16), str2.substring(0, 16), k1.a(str.getBytes(), 2)), str2.substring(0, 16))));
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[Catch: Exception -> 0x0087, TRY_LEAVE, TryCatch #1 {Exception -> 0x0087, blocks: (B:6:0x000a, B:9:0x0011, B:11:0x0017, B:17:0x0036, B:19:0x0047, B:25:0x007c, B:28:0x0081, B:12:0x001c, B:13:0x0026, B:15:0x002a, B:16:0x0032), top: B:38:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String c(String str, String str2) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            if (str2 != null) {
                if (str2.length() >= 16) {
                    if (str2.length() > 16) {
                        str2 = str2.substring(0, 16);
                    }
                    byte[] a = o1.a(str.getBytes());
                    W.getInstance(this.a);
                    if (W.loadSuccess) {
                        try {
                            bArr = i1.c(str2.substring(0, 16), str2.substring(0, 16), v1.c(a, str2));
                        } catch (Throwable unused) {
                            bArr = null;
                        }
                    } else {
                        bArr = W.getInstance(this.a).ac(W.getInstance(this.a).ar(a, str2.getBytes()), str2.substring(0, 16).getBytes());
                    }
                    if (bArr != null && bArr.length >= 1) {
                        return k1.c(bArr, 2);
                    }
                    return null;
                }
            }
            int length = str2.length();
            StringBuilder sb = new StringBuilder(str2);
            for (int i2 = 0; i2 < 16 - length; i2++) {
                sb.append("0");
            }
            str2 = sb.toString();
            byte[] a2 = o1.a(str.getBytes());
            W.getInstance(this.a);
            if (W.loadSuccess) {
            }
            if (bArr != null) {
                return k1.c(bArr, 2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return b(str, new String(k1.a(r1.t.getBytes(), 2)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            try {
                return c(str, new String(k1.a(str2.getBytes(), 2)));
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
                return c(str, new String(k1.a(r1.t.getBytes(), 2)));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}

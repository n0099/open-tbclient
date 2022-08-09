package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vf1 {
    public static /* synthetic */ Interceptable $ic;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public vf1(Context context) {
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
        this.a = ze1.a;
    }

    public static synchronized vf1 a(Context context) {
        InterceptResult invokeL;
        vf1 vf1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (vf1.class) {
                vf1Var = new vf1(context);
            }
            return vf1Var;
        }
        return (vf1) invokeL.objValue;
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = xe1.b;
            String str4 = xe1.c;
            String str5 = "";
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return "";
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            try {
                str5 = c(str3, str4, currentTimeMillis);
            } catch (Throwable th) {
                kg1.d(th);
            }
            sb.append(f());
            sb.append(str);
            sb.append("/");
            sb.append("100");
            sb.append("/");
            sb.append(str3);
            sb.append("/");
            sb.append(currentTimeMillis);
            sb.append("/");
            sb.append(str5);
            sb.append("?skey=");
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public String c(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            try {
                return og1.b(str + j + str2);
            } catch (Throwable th) {
                kg1.d(th);
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                b = new String(mg1.e(Base64.decode(this.a, 0), "30212102dicudiab".getBytes(IMAudioTransRequest.CHARSET)));
            } catch (Throwable th) {
                kg1.d(th);
            }
        }
    }

    public byte[] e(byte[] bArr, String str) {
        InterceptResult invokeLL;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bArr, str)) == null) {
            try {
                bArr2 = ng1.b(str.getBytes(IMAudioTransRequest.CHARSET));
            } catch (Throwable th) {
                kg1.d(th);
                bArr2 = null;
            }
            return mg1.f(bArr2, bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(b)) {
                d();
            }
            return b;
        }
        return (String) invokeV.objValue;
    }
}

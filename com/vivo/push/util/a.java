package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a c;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public byte[] b;

    public a(Context context) {
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
        x.b().a(ContextDelegate.getContext(context));
        x b = x.b();
        this.a = b.c();
        this.b = b.d();
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (a.class) {
                    if (c == null) {
                        c = new a(context.getApplicationContext());
                    }
                }
            }
            return c;
        }
        return (a) invokeL.objValue;
    }

    public final String b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new String(f.a(f.a(a()), f.a(b()), Base64.decode(str, 2)), IMAudioTransRequest.CHARSET) : (String) invokeL.objValue;
    }

    private byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            byte[] bArr = this.b;
            return (bArr == null || bArr.length <= 0) ? x.b().d() : bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public final String a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String a = f.a(a());
            String a2 = f.a(b());
            byte[] bytes = str.getBytes(IMAudioTransRequest.CHARSET);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a2.getBytes(IMAudioTransRequest.CHARSET), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(a.getBytes(IMAudioTransRequest.CHARSET)));
            return Base64.encodeToString(cipher.doFinal(bytes), 2);
        }
        return (String) invokeL.objValue;
    }

    private byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            byte[] bArr = this.a;
            return (bArr == null || bArr.length <= 0) ? x.b().c() : bArr;
        }
        return (byte[]) invokeV.objValue;
    }
}

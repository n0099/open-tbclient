package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
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

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f59297c;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f59298b;

    public a(Context context) {
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
        x.b().a(ContextDelegate.getContext(context));
        x b2 = x.b();
        this.a = b2.c();
        this.f59298b = b2.d();
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f59297c == null) {
                synchronized (a.class) {
                    if (f59297c == null) {
                        f59297c = new a(context.getApplicationContext());
                    }
                }
            }
            return f59297c;
        }
        return (a) invokeL.objValue;
    }

    public final String b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new String(f.a(f.a(a()), f.a(b()), Base64.decode(str, 2)), "utf-8") : (String) invokeL.objValue;
    }

    private byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            byte[] bArr = this.f59298b;
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
            byte[] bytes = str.getBytes("utf-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(a2.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(a.getBytes("utf-8")));
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

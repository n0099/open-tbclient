package com.sdk.base.framework.f.i;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.sdk.base.framework.c.f;
import java.nio.charset.Charset;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class e extends com.sdk.base.framework.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f68255a = "com.sdk.base.framework.f.i.e";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68256b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065952421, "Lcom/sdk/base/framework/f/i/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065952421, "Lcom/sdk/base/framework/f/i/e;");
                return;
            }
        }
        f68256b = f.f68206b;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (com.sdk.base.framework.a.a.c.a(str).booleanValue()) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str.getBytes(Charset.defaultCharset()));
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            } catch (Exception e2) {
                com.sdk.base.framework.f.a.a(f68255a, LightappBusinessClient.MTD_ENCRYPT, e2.getMessage(), f68256b);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}

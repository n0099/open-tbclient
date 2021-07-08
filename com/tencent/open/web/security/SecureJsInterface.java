package com.tencent.open.web.security;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a;
import com.tencent.open.a.f;
/* loaded from: classes6.dex */
public class SecureJsInterface extends a.b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isPWDEdit;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39039a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1867105451, "Lcom/tencent/open/web/security/SecureJsInterface;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1867105451, "Lcom/tencent/open/web/security/SecureJsInterface;");
        }
    }

    public SecureJsInterface() {
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

    public void clearAllEdit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f.c("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
            try {
                JniInterface.clearAllPWD();
            } catch (Exception e2) {
                f.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e2.getMessage());
                throw new RuntimeException(e2);
            }
        }
    }

    public void curPosFromJS(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
            try {
                i2 = Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e2);
                i2 = -1;
            }
            if (i2 >= 0) {
                boolean z = a.f39042c;
                boolean z2 = a.f39041b;
                if (z2) {
                    if (Boolean.valueOf(JniInterface.BackSpaceChar(z2, i2)).booleanValue()) {
                        a.f39041b = false;
                        return;
                    }
                    return;
                }
                String str2 = a.f39040a;
                this.f39039a = str2;
                JniInterface.insetTextToArray(i2, str2, str2.length());
                f.a("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f39039a);
                return;
            }
            throw new RuntimeException("position is illegal.");
        }
    }

    @Override // com.tencent.open.a.b
    public boolean customCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public String getMD5FromNative() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            f.c("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
            try {
                String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
                f.a("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
                return pWDKeyToMD5;
            } catch (Exception e2) {
                f.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e2.getMessage());
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeV.objValue;
    }

    public void isPasswordEdit(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            f.c("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
            try {
                i2 = Integer.parseInt(str);
            } catch (Exception e2) {
                f.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e2.getMessage());
                i2 = -1;
            }
            if (i2 != 0 && i2 != 1) {
                throw new RuntimeException("is pswd edit flag is illegal.");
            }
            if (i2 == 0) {
                isPWDEdit = false;
            } else if (i2 == 1) {
                isPWDEdit = true;
            }
        }
    }
}

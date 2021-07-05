package com.qq.e.comm.util;

import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PublicKey f41069a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f41070b;

    /* renamed from: com.qq.e.comm.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0519a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f41071a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(519442790, "Lcom/qq/e/comm/util/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(519442790, "Lcom/qq/e/comm/util/a$a;");
                    return;
                }
            }
            f41071a = new a((byte) 0);
        }
    }

    public a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.f41069a = b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.f41070b = z;
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0519a.f41071a : (a) invokeV.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (this.f41069a != null) {
                byte[] decode = Base64.decode(str, 0);
                try {
                    Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
                    cipher.init(2, this.f41069a);
                    return new String(cipher.doFinal(decode), "UTF-8").trim();
                } catch (Throwable th) {
                    GDTLogger.e("ErrorWhileVerifySigNature", th);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static PublicKey b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (NullPointerException unused) {
                throw new Exception("公钥数据为空");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("无此算法");
            } catch (InvalidKeySpecException unused3) {
                throw new Exception("公钥非法");
            }
        }
        return (PublicKey) invokeL.objValue;
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? b(str, Md5Util.encode(str2)) : invokeLL.booleanValue;
    }

    public final boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (StringUtil.isEmpty(str2)) {
                return false;
            }
            if (this.f41070b) {
                String a2 = a(str);
                boolean equals = str2.equals(a2);
                GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + a2);
                return equals;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}

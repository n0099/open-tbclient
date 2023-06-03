package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] c;
    public transient /* synthetic */ FieldHolder $fh;
    public PublicKey a;
    public final boolean b;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-209489583, "Lcom/qq/e/comm/managers/plugin/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-209489583, "Lcom/qq/e/comm/managers/plugin/c$b;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(151737167, "Lcom/qq/e/comm/managers/plugin/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(151737167, "Lcom/qq/e/comm/managers/plugin/c;");
                return;
            }
        }
        c = new byte[]{82, 83, 65, 47, 69, 67, 66, 47, 80, 75, 67, 83, 49, 80, 97, 100, 100, 105, 110, 103};
    }

    public c() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.a = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        this.b = z;
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    private PublicKey a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
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

    public boolean a(String str, File file) {
        InterceptResult invokeLL;
        String str2;
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    fileInputStream = new FileInputStream(file);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str2 = d.a(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused4) {
                        }
                    }
                    str2 = "";
                    return a(str, str2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
                return a(str, str2);
            }
            str2 = "";
            return a(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (!this.b) {
                return true;
            }
            if (this.a != null) {
                byte[] decode = Base64.decode(str, 0);
                try {
                    Cipher cipher = Cipher.getInstance(new String(c, "UTF-8"));
                    cipher.init(2, this.a);
                    str3 = new String(cipher.doFinal(decode), "UTF-8").trim();
                } catch (Throwable unused) {
                    GDTLogger.d("ErrorWhileVerifySigNature");
                }
                boolean equals = str2.equals(str3);
                GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + str3);
                return equals;
            }
            str3 = null;
            boolean equals2 = str2.equals(str3);
            GDTLogger.d("Verify Result" + equals2 + "src=" + str2 + " & target=" + str3);
            return equals2;
        }
        return invokeLL.booleanValue;
    }
}

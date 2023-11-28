package com.kuaishou.weapon.p0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "AES/CBC/NoPadding";
    public static final int b = 16;
    public static final String c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
    public static final String d = "AES/CBC/PKCS5Padding";
    public static final String e = "AES";
    public static final String f = "AES/CBC/PKCS7Padding";
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte[] a(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] b(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, bArr, bArr2, z)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                byte[] bArr3 = new byte[16];
                for (int i = 0; i < 16; i++) {
                    bArr3[i] = 0;
                }
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                if (z) {
                    byte[] bArr4 = new byte[bArr2.length - 16];
                    System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                    bArr2 = bArr4;
                }
                return cipher.doFinal(bArr2);
            } catch (Throwable th) {
                System.out.println(th.getMessage());
                return null;
            }
        }
        return (byte[]) invokeLLZ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x009c, code lost:
        if (r8 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        CipherInputStream cipherInputStream;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, bArr)) == null) {
            try {
                String str3 = new String(bArr);
                if (str3.length() < 16) {
                    int length = str3.length();
                    StringBuilder sb = new StringBuilder(str3);
                    for (int i = 0; i < 16 - length; i++) {
                        sb.append("0");
                    }
                    str3 = sb.toString();
                } else if (str3.length() > 16) {
                    str3 = str3.substring(0, 16);
                }
                FileOutputStream fileOutputStream = null;
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                        try {
                            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                            byte[] bArr2 = new byte[16];
                            for (int i2 = 0; i2 < 16; i2++) {
                                bArr2[i2] = 0;
                            }
                            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr2));
                            cipherInputStream = new CipherInputStream(fileInputStream, cipher);
                        } catch (Throwable unused) {
                            cipherInputStream = null;
                        }
                        try {
                            byte[] bArr3 = new byte[1024];
                            while (true) {
                                int read = cipherInputStream.read(bArr3);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr3, 0, read);
                            }
                            cipherInputStream.close();
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                            }
                        } catch (Throwable unused4) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                        }
                    } catch (Throwable unused7) {
                        cipherInputStream = null;
                    }
                } catch (Throwable unused8) {
                    cipherInputStream = null;
                    fileInputStream = null;
                }
                try {
                    cipherInputStream.close();
                } catch (IOException unused9) {
                    return 0;
                }
            } catch (Throwable unused10) {
                return -1;
            }
        } else {
            return invokeLLL.intValue;
        }
    }
}

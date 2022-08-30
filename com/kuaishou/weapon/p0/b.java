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
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "AES/CBC/PKCS5Padding";
    public static final String b = "AES";
    public static final String c = "AES/CBC/PKCS7Padding";
    public static final String d = "AES/CBC/NoPadding";
    public static final int e = 16;
    public static final String f = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
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

    /* JADX WARN: Can't wrap try/catch for region: R(22:3|4|5|(3:(4:7|(2:10|8)|11|12)(21:67|(1:69)|14|15|16|17|18|19|20|(1:22)|23|24|25|26|27|(2:28|(1:30)(1:31))|32|34|35|37|38)|37|38)|13|14|15|16|17|18|19|20|(0)|23|24|25|26|27|(3:28|(0)(0)|30)|32|34|35) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
        r9 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        r8 = null;
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008c, code lost:
        if (r9 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0093, code lost:
        if (r4 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0095, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        if (r8 != null) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: all -> 0x0085, LOOP:1: B:20:0x0058->B:21:0x005a, LOOP_END, TryCatch #2 {all -> 0x0085, blocks: (B:19:0x0044, B:21:0x005a, B:22:0x005f), top: B:60:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077 A[Catch: all -> 0x0086, LOOP:2: B:25:0x0071->B:27:0x0077, LOOP_END, TryCatch #3 {all -> 0x0086, blocks: (B:24:0x006f, B:25:0x0071, B:27:0x0077, B:28:0x007b), top: B:62:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x007b A[EDGE_INSN: B:78:0x007b->B:28:0x007b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        String substring;
        CipherInputStream cipherInputStream;
        FileOutputStream fileOutputStream;
        int i;
        byte[] bArr2;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, bArr)) != null) {
            return invokeLLL.intValue;
        }
        try {
            String str3 = new String(bArr);
            try {
                if (str3.length() < 16) {
                    int length = str3.length();
                    StringBuilder sb = new StringBuilder(str3);
                    for (int i2 = 0; i2 < 16 - length; i2++) {
                        sb.append("0");
                    }
                    substring = sb.toString();
                } else {
                    if (str3.length() > 16) {
                        substring = str3.substring(0, 16);
                    }
                    FileOutputStream fileOutputStream2 = null;
                    FileInputStream fileInputStream = new FileInputStream(str);
                    fileOutputStream = new FileOutputStream(str2);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    byte[] bArr3 = new byte[16];
                    for (i = 0; i < 16; i++) {
                        bArr3[i] = 0;
                    }
                    cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                    cipherInputStream = new CipherInputStream(fileInputStream, cipher);
                    bArr2 = new byte[1024];
                    while (true) {
                        read = cipherInputStream.read(bArr2);
                        if (read != -1) {
                            break;
                        }
                        fileOutputStream.write(bArr2, 0, read);
                    }
                    cipherInputStream.close();
                    fileOutputStream.close();
                    fileInputStream.close();
                }
                fileInputStream.close();
            } catch (IOException unused) {
                try {
                    cipherInputStream.close();
                } catch (IOException unused2) {
                }
                return 0;
            }
            str3 = substring;
            FileOutputStream fileOutputStream22 = null;
            FileInputStream fileInputStream2 = new FileInputStream(str);
            fileOutputStream = new FileOutputStream(str2);
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr32 = new byte[16];
            while (i < 16) {
            }
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(bArr32));
            cipherInputStream = new CipherInputStream(fileInputStream2, cipher2);
            bArr2 = new byte[1024];
            while (true) {
                read = cipherInputStream.read(bArr2);
                if (read != -1) {
                }
                fileOutputStream.write(bArr2, 0, read);
            }
            cipherInputStream.close();
            fileOutputStream.close();
        } catch (Throwable unused3) {
            return -1;
        }
    }

    public static byte[] c(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }
}

package com.kuaishou.weapon.un;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public final class i1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "AES/CBC/PKCS5Padding";

    /* renamed from: b  reason: collision with root package name */
    public static final String f55120b = "AES";

    /* renamed from: c  reason: collision with root package name */
    public static final String f55121c = "AES/CBC/PKCS7Padding";

    /* renamed from: d  reason: collision with root package name */
    public static final String f55122d = "AES/CBC/NoPadding";
    public transient /* synthetic */ FieldHolder $fh;

    public i1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(File file, File file2, byte[] bArr) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65537, null, file, file2, bArr)) != null) {
            return invokeLLL.intValue;
        }
        if (file == null || !file.exists()) {
            return -1;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    int length = (int) file.length();
                    byte[] bArr3 = new byte[length];
                    while (true) {
                        int read = fileInputStream2.read(bArr3);
                        if (read == -1) {
                            break;
                        }
                        if (read < length) {
                            bArr2 = new byte[read];
                            System.arraycopy(bArr3, 0, bArr2, 0, read);
                        } else {
                            bArr2 = bArr3;
                        }
                        fileOutputStream.write(a(bArr, bArr2, false));
                    }
                    fileInputStream2.close();
                    fileOutputStream.close();
                    try {
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        l1.a(th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                                return -1;
                            }
                        }
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static byte[] a(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] a(String str, String str2, byte[] bArr, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, bArr, str3)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(str3);
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                byte[] bArr3 = new byte[16];
                for (int i2 = 0; i2 < 16; i2++) {
                    bArr3[i2] = 0;
                }
                cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                byte[] doFinal = cipher.doFinal(bArr2);
                int length = doFinal.length;
                byte[] bArr4 = new byte[length];
                System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
                PrintStream printStream = System.out;
                printStream.println("ret --- " + length);
                return bArr4;
            } catch (Throwable th) {
                l1.a(th);
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, bArr, bArr2, z)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                byte[] bArr3 = new byte[16];
                for (int i2 = 0; i2 < 16; i2++) {
                    bArr3[i2] = 0;
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

    /* JADX WARN: Can't wrap try/catch for region: R(12:(4:7|(2:10|8)|11|12)(24:104|(1:106)|14|15|16|17|18|20|21|(1:23)|24|25|26|27|28|(2:29|(1:31)(1:32))|33|35|36|37|38|39|40|41)|27|28|(3:29|(0)(0)|31)|33|35|36|37|38|39|40|41) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:3|4|5|(4:7|(2:10|8)|11|12)(24:104|(1:106)|14|15|16|17|18|20|21|(1:23)|24|25|26|27|28|(2:29|(1:31)(1:32))|33|35|36|37|38|39|40|41)|13|14|15|16|17|18|20|21|(0)|24|25|26|27|28|(3:29|(0)(0)|31)|33|35|36|37|38|39|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008b, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0097, code lost:
        r10 = r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009c, code lost:
        r10 = r9;
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a0, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a1, code lost:
        r9 = r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a4, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a5, code lost:
        r9 = null;
        r10 = r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a9, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00aa, code lost:
        r9 = r8;
        r8 = null;
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ae, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00af, code lost:
        r9 = null;
        r4 = null;
        r10 = r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b3, code lost:
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b6, code lost:
        if (r8 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bc, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bd, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
        if (r4 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c2, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c6, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c7, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ca, code lost:
        if (r9 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cd, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x007b A[EDGE_INSN: B:123:0x007b->B:28:0x007b ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: all -> 0x0096, Exception -> 0x009b, LOOP:1: B:20:0x0058->B:21:0x005a, LOOP_END, TryCatch #15 {Exception -> 0x009b, all -> 0x0096, blocks: (B:19:0x0044, B:21:0x005a, B:22:0x005f), top: B:119:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077 A[Catch: Exception -> 0x0094, all -> 0x00d1, LOOP:2: B:25:0x0071->B:27:0x0077, LOOP_END, TryCatch #6 {Exception -> 0x0094, blocks: (B:24:0x006f, B:25:0x0071, B:27:0x0077, B:28:0x007b), top: B:100:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        String substring;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        CipherInputStream cipherInputStream;
        FileOutputStream fileOutputStream2;
        int i2;
        byte[] bArr2;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65542, null, str, str2, bArr)) != null) {
            return invokeLLL.intValue;
        }
        try {
            String str3 = new String(bArr);
            try {
                if (str3.length() >= 16) {
                    if (str3.length() > 16) {
                        substring = str3.substring(0, 16);
                    }
                    fileOutputStream = null;
                    fileInputStream = new FileInputStream(str);
                    fileOutputStream2 = new FileOutputStream(str2);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    byte[] bArr3 = new byte[16];
                    for (i2 = 0; i2 < 16; i2++) {
                        bArr3[i2] = 0;
                    }
                    cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                    cipherInputStream = new CipherInputStream(fileInputStream, cipher);
                    bArr2 = new byte[1024];
                    while (true) {
                        read = cipherInputStream.read(bArr2);
                        if (read != -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr2, 0, read);
                    }
                    cipherInputStream.close();
                    fileOutputStream2.close();
                    fileInputStream.close();
                    cipherInputStream.close();
                    return 0;
                }
                int length = str3.length();
                StringBuilder sb = new StringBuilder(str3);
                for (int i3 = 0; i3 < 16 - length; i3++) {
                    sb.append("0");
                }
                substring = sb.toString();
                bArr2 = new byte[1024];
                while (true) {
                    read = cipherInputStream.read(bArr2);
                    if (read != -1) {
                    }
                    fileOutputStream2.write(bArr2, 0, read);
                }
                cipherInputStream.close();
                fileOutputStream2.close();
                fileInputStream.close();
                cipherInputStream.close();
                return 0;
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                CipherInputStream cipherInputStream2 = cipherInputStream;
                Throwable th2 = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (cipherInputStream2 != null) {
                    try {
                        cipherInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th2;
            }
            str3 = substring;
            fileOutputStream = null;
            fileInputStream = new FileInputStream(str);
            fileOutputStream2 = new FileOutputStream(str2);
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr32 = new byte[16];
            while (i2 < 16) {
            }
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(bArr32));
            cipherInputStream = new CipherInputStream(fileInputStream, cipher2);
        } catch (Exception e5) {
            e5.printStackTrace();
            return -1;
        }
    }

    public static byte[] c(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(4:7|(2:10|8)|11|12)(24:104|(1:106)|14|15|16|17|18|20|21|(1:23)|24|25|26|27|28|(2:29|(1:31)(1:32))|33|35|36|37|38|39|40|41)|27|28|(3:29|(0)(0)|31)|33|35|36|37|38|39|40|41) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:3|4|5|(4:7|(2:10|8)|11|12)(24:104|(1:106)|14|15|16|17|18|20|21|(1:23)|24|25|26|27|28|(2:29|(1:31)(1:32))|33|35|36|37|38|39|40|41)|13|14|15|16|17|18|20|21|(0)|24|25|26|27|28|(3:29|(0)(0)|31)|33|35|36|37|38|39|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008b, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0097, code lost:
        r10 = r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009c, code lost:
        r10 = r9;
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a0, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a1, code lost:
        r9 = r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a4, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a5, code lost:
        r9 = null;
        r10 = r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a9, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00aa, code lost:
        r9 = r8;
        r8 = null;
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ae, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00af, code lost:
        r9 = null;
        r4 = null;
        r10 = r8;
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b3, code lost:
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b6, code lost:
        if (r8 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bc, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bd, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
        if (r4 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c2, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c6, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c7, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ca, code lost:
        if (r9 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cd, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x007b A[EDGE_INSN: B:123:0x007b->B:28:0x007b ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: all -> 0x0096, Exception -> 0x009b, LOOP:1: B:20:0x0058->B:21:0x005a, LOOP_END, TryCatch #15 {Exception -> 0x009b, all -> 0x0096, blocks: (B:19:0x0044, B:21:0x005a, B:22:0x005f), top: B:119:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077 A[Catch: Exception -> 0x0094, all -> 0x00d1, LOOP:2: B:25:0x0070->B:27:0x0077, LOOP_END, TryCatch #6 {Exception -> 0x0094, blocks: (B:24:0x006e, B:25:0x0070, B:27:0x0077, B:28:0x007b), top: B:100:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        String substring;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        CipherInputStream cipherInputStream;
        FileOutputStream fileOutputStream2;
        int i2;
        byte[] bArr2;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65544, null, str, str2, bArr)) != null) {
            return invokeLLL.booleanValue;
        }
        try {
            String str3 = new String(bArr);
            try {
                if (str3.length() >= 16) {
                    if (str3.length() > 16) {
                        substring = str3.substring(0, 16);
                    }
                    fileOutputStream = null;
                    fileInputStream = new FileInputStream(str);
                    fileOutputStream2 = new FileOutputStream(str2);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    byte[] bArr3 = new byte[16];
                    for (i2 = 0; i2 < 16; i2++) {
                        bArr3[i2] = 0;
                    }
                    cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                    cipherInputStream = new CipherInputStream(fileInputStream, cipher);
                    bArr2 = new byte[1024];
                    while (true) {
                        read = cipherInputStream.read(bArr2);
                        if (read != -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr2, 0, read);
                    }
                    cipherInputStream.close();
                    fileOutputStream2.close();
                    fileInputStream.close();
                    cipherInputStream.close();
                    return true;
                }
                int length = str3.length();
                StringBuilder sb = new StringBuilder(str3);
                for (int i3 = 0; i3 < 16 - length; i3++) {
                    sb.append("0");
                }
                substring = sb.toString();
                bArr2 = new byte[1024];
                while (true) {
                    read = cipherInputStream.read(bArr2);
                    if (read != -1) {
                    }
                    fileOutputStream2.write(bArr2, 0, read);
                }
                cipherInputStream.close();
                fileOutputStream2.close();
                fileInputStream.close();
                cipherInputStream.close();
                return true;
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                CipherInputStream cipherInputStream2 = cipherInputStream;
                Throwable th2 = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (cipherInputStream2 != null) {
                    try {
                        cipherInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th2;
            }
            str3 = substring;
            fileOutputStream = null;
            fileInputStream = new FileInputStream(str);
            fileOutputStream2 = new FileOutputStream(str2);
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr32 = new byte[16];
            while (i2 < 16) {
            }
            cipher2.init(1, secretKeySpec2, new IvParameterSpec(bArr32));
            cipherInputStream = new CipherInputStream(fileInputStream, cipher2);
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }
}

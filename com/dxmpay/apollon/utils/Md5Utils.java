package com.dxmpay.apollon.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.NoProguard;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes12.dex */
public final class Md5Utils implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static char[] hexChars;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738050932, "Lcom/dxmpay/apollon/utils/Md5Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738050932, "Lcom/dxmpay/apollon/utils/Md5Utils;");
                return;
            }
        }
        hexChars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public Md5Utils() {
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

    public static String bytesToHexString(byte[] bArr, Character ch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, ch)) == null) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length * (ch == null ? 2 : 3));
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = (bArr[i2] >>> 4) & 15;
                int i4 = bArr[i2] & 15;
                if (i2 > 0 && ch != null) {
                    stringBuffer.append(ch.charValue());
                }
                stringBuffer.append(hexChars[i3]);
                stringBuffer.append(hexChars[i4]);
            }
            return stringBuffer.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized String encrypt(byte[] bArr) {
        InterceptResult invokeL;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            synchronized (Md5Utils.class) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b2 : digest) {
                        sb2.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                    }
                    sb = sb2.toString();
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return sb;
        }
        return (String) invokeL.objValue;
    }

    public static MessageDigest getDigest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (MessageDigest) invokeV.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0051: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:36:0x0051 */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMd5FromFile(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = null;
                str2 = null;
                str2 = null;
                str2 = null;
                str2 = null;
                FileInputStream fileInputStream3 = null;
                try {
                    try {
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                MessageDigest digest = getDigest();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    digest.update(bArr, 0, read);
                                }
                                str2 = md5Hex(digest.digest());
                                fileInputStream.close();
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return str2;
                            } catch (IOException e3) {
                                e = e3;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return str2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream3 = fileInputStream2;
                            if (fileInputStream3 != null) {
                                try {
                                    fileInputStream3.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        fileInputStream = null;
                    } catch (IOException e6) {
                        e = e6;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream3 != null) {
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                return str2;
            }
            throw new IllegalArgumentException("file path is empty");
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x001d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x002b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x000b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x000b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static String getMd5FromFileV2(String str) {
        Interceptable interceptable;
        InterceptResult invokeL;
        Interceptable interceptable2 = $ic;
        if (interceptable2 == null || (invokeL = (interceptable = interceptable2).invokeL(65542, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = null;
                str2 = null;
                str2 = null;
                FileInputStream fileInputStream = null;
                try {
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = interceptable;
                }
                try {
                    try {
                        interceptable = new FileInputStream(str);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        str2 = getMd5FromInputStream(interceptable);
                        interceptable.close();
                        interceptable = interceptable;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (interceptable != 0) {
                            interceptable.close();
                            interceptable = interceptable;
                        }
                        return str2;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    interceptable = 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
                return str2;
            }
            throw new IllegalArgumentException("file path is empty");
        }
        return (String) invokeL.objValue;
    }

    public static String getMd5FromInputStream(InputStream inputStream) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, inputStream)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                MessageDigest digest = getDigest();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    digest.update(bArr, 0, read);
                }
                for (byte b2 : digest.digest()) {
                    sb.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] md5(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) ? getDigest().digest(bArr) : (byte[]) invokeL.objValue;
    }

    public static String md5Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) ? bytesToHexString(md5(bArr), null) : (String) invokeL.objValue;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String toMD5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str != null) {
                try {
                    return encrypt(str.getBytes("GBK"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String toMD5NoEncode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (str != null) {
                return encrypt(str.getBytes());
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String toMD5UCS2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (str != null) {
                try {
                    return encrypt(new String(str.getBytes("GBK"), "GBK").getBytes("UTF-16LE"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String toMd5(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65553, null, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return toHexString(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static byte[] md5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? md5(str.getBytes()) : (byte[]) invokeL.objValue;
    }

    public static String md5Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? bytesToHexString(md5(str), null) : (String) invokeL.objValue;
    }

    public static String toMD5(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if (str != null) {
                try {
                    return encrypt(str.getBytes(str2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}

package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Locale;
/* loaded from: classes6.dex */
public class f11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(File file) {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        if (file == null || !file.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            byte[] bArr = new byte[102400];
            FileInputStream fileInputStream2 = new FileInputStream(file);
            do {
                try {
                    read = fileInputStream2.read(bArr, 0, 102400);
                    if (read < 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } while (read > 0);
            String b = b(messageDigest.digest(), "", false);
            try {
                fileInputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return b;
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase(Locale.getDefault());
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

    public static String c(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            if (str == null) {
                str = "";
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return b(messageDigest.digest(), "", z);
            } catch (Exception unused) {
                return String.valueOf(str.hashCode());
            }
        }
        return (String) invokeLZ.objValue;
    }
}

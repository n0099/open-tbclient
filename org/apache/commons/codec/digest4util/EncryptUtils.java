package org.apache.commons.codec.digest4util;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
@SuppressLint({"BDThrowableCheck"})
@Deprecated
/* loaded from: classes9.dex */
public class EncryptUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String ENCRYPT_MD5 = "MD5";
    public static final String ENCRYPT_SHA1 = "SHA-1";
    public static final String ENCRYPT_SHA256 = "SHA-256";
    public static final String ENCRYPT_SHA384 = "SHA-384";
    public static final String ENCRYPT_SHA512 = "SHA-512";
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public transient /* synthetic */ FieldHolder $fh;

    public EncryptUtils() {
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

    public static String encrypt(String str, byte[] bArr, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.reset();
                messageDigest.update(bArr);
                return toHexString(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeLLZ.objValue;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String encrypt(String str, File file, boolean z) {
        InterceptResult invokeLLZ;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(65537, null, str, file, z)) != null) {
            return (String) invokeLLZ.objValue;
        }
        FileInputStream fileInputStream2 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String hexString = toHexString(messageDigest.digest(), "", z);
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return hexString;
            } catch (FileNotFoundException unused2) {
            } catch (IOException unused3) {
            } catch (NoSuchAlgorithmException unused4) {
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused6) {
            fileInputStream = null;
        } catch (IOException unused7) {
            fileInputStream = null;
        } catch (NoSuchAlgorithmException unused8) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

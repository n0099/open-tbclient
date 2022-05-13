package com.repackage;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes6.dex */
public class he3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755651173, "Lcom/repackage/he3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755651173, "Lcom/repackage/he3;");
                return;
            }
        }
        a = eh1.a;
    }

    public static boolean a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, str)) == null) ? b(file, str, null) : invokeLL.booleanValue;
    }

    public static boolean b(File file, String str, bf3 bf3Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, file, str, bf3Var)) == null) {
            boolean z = file == null;
            if (z || !file.exists() || TextUtils.isEmpty(str)) {
                if (bf3Var != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("zipfile: isEmpty=");
                    sb.append(z);
                    sb.append("; exists=");
                    sb.append(z ? "" : Boolean.valueOf(file.exists()));
                    bf3Var.a = sb.toString();
                }
                return false;
            }
            ReadableByteChannel readableByteChannel = null;
            try {
                readableByteChannel = Channels.newChannel(new FileInputStream(file));
                return d(readableByteChannel, str, bf3Var);
            } catch (IOException e) {
                if (a) {
                    e.printStackTrace();
                }
                return false;
            } finally {
                xg4.d(readableByteChannel);
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(ReadableByteChannel readableByteChannel, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, readableByteChannel, str)) == null) ? d(readableByteChannel, str, null) : invokeLL.booleanValue;
    }

    public static boolean d(ReadableByteChannel readableByteChannel, String str, bf3 bf3Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, readableByteChannel, str, bf3Var)) == null) {
            boolean z = readableByteChannel == null;
            if (z || TextUtils.isEmpty(str)) {
                if (bf3Var != null) {
                    bf3Var.a = "zipSource isNullIs=" + z;
                }
                return false;
            }
            String c = zg4.c(false, readableByteChannel);
            if (bf3Var != null) {
                bf3Var.a = c;
            }
            try {
                String str2 = new String(e(Base64.decode(str.getBytes(IMAudioTransRequest.CHARSET), 8), f("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZuy3GEbahJc292fsyvrGneTJKQnzpdhNsJfDS5csb0MtmW+4JEvBH5wCZK5j4+nrRfKBF7JuTHe0nSWOZWNxgLU87pwCxozXSNrsiiOjsV+3KwYfdz5QlvvyCfvmllGObPqL7dWR92V2UYEWMSneBHtwDhCBCzmhAoOxZVsAq2wIDAQAB")), IMAudioTransRequest.CHARSET);
                if (bf3Var != null) {
                    bf3Var.b = str2;
                }
                return TextUtils.equals(str2, c);
            } catch (Exception e) {
                if (a) {
                    Log.i("SwanAppSignChecker", e.toString());
                    e.printStackTrace();
                }
                if (bf3Var != null) {
                    bf3Var.b = e.getLocalizedMessage();
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static byte[] e(byte[] bArr, PublicKey publicKey) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, publicKey)) == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicKey);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static PublicKey f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(IMAudioTransRequest.CHARSET), 0)));
            } catch (UnsupportedEncodingException | NullPointerException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
                return null;
            }
        }
        return (PublicKey) invokeL.objValue;
    }
}

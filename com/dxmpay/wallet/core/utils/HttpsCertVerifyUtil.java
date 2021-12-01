package com.dxmpay.wallet.core.utils;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
/* loaded from: classes12.dex */
public class HttpsCertVerifyUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpsCertVerifyUtil() {
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

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder("");
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? 3 == i2 || 4 == i2 || 5 == i2 : invokeI.booleanValue;
    }

    public static byte[] c(SslCertificate sslCertificate) {
        InterceptResult invokeL;
        Bundle saveState;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sslCertificate)) == null) {
            if (sslCertificate != null && (saveState = SslCertificate.saveState(sslCertificate)) != null && (byteArray = saveState.getByteArray("x509-certificate")) != null) {
                try {
                    return MessageDigest.getInstance("SHA-256").digest(CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray)).getEncoded());
                } catch (NoSuchAlgorithmException e2) {
                    e2.getMessage();
                } catch (CertificateException e3) {
                    e3.getMessage();
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null || str.trim().length() == 0) {
                return null;
            }
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                int indexOf = "0123456789abcdef".indexOf(charArray[i3]) << 4;
                int indexOf2 = "0123456789abcdef".indexOf(charArray[i3 + 1]);
                if (indexOf == -1 || indexOf2 == -1) {
                    return null;
                }
                bArr[i2] = (byte) (indexOf2 | indexOf);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = SdkInitResponse.getInstance().certWhiteList;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.split(",");
        }
        return (String[]) invokeV.objValue;
    }

    public static boolean isWhiteListVerificationPassed(SslError sslError) {
        InterceptResult invokeL;
        String[] e2;
        byte[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sslError)) == null) {
            if (sslError == null) {
                return false;
            }
            int primaryError = sslError.getPrimaryError();
            if (!b(primaryError) || (e2 = e()) == null || e2.length == 0 || (c2 = c(sslError.getCertificate())) == null) {
                return false;
            }
            for (String str : e2) {
                if (Arrays.equals(c2, d(str.toLowerCase()))) {
                    StatisticManager.onEventWithValues("#certificate_white_list_passed", Arrays.asList(primaryError + "", sslError.getUrl(), str));
                    return true;
                }
            }
            StatisticManager.onEventWithValues("#certificate_white_list_failed", Arrays.asList(primaryError + "", sslError.getUrl(), a(c2)));
            return false;
        }
        return invokeL.booleanValue;
    }
}

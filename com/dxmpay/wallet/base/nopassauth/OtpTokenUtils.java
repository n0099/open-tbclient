package com.dxmpay.wallet.base.nopassauth;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.b.a.b.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.beans.BeanConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes9.dex */
public final class OtpTokenUtils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static long f69169a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f69170b = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) ? "www.baidu.com".equals(str) || "m.baidu.com".equals(str) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(550219903, "Lcom/dxmpay/wallet/base/nopassauth/OtpTokenUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(550219903, "Lcom/dxmpay/wallet/base/nopassauth/OtpTokenUtils;");
        }
    }

    public OtpTokenUtils() {
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

    public static InputStream a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpURLConnection)) == null) {
            try {
                return httpURLConnection.getInputStream();
            } catch (IOException unused) {
                return httpURLConnection.getErrorStream();
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, bArr, z)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            byte[] bArr2 = new byte[bArr.length + 1];
            int i2 = 0;
            for (byte b2 : bArr) {
                bArr2[i2] = b2;
                i2++;
            }
            bArr2[bArr.length] = z ? (byte) 1 : (byte) 0;
            return bArr2;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public static String getEncryptTOtpCode(Context context, int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) ? !TextUtils.isEmpty(str) ? new c(str, i2, 0L, i3).a(context) : "" : (String) invokeCommon.objValue;
    }

    public static String getSN(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            String decryptProxy = SecurePay.getInstance().decryptProxy(str);
            if (TextUtils.isEmpty(decryptProxy) || (split = decryptProxy.split("\\|")) == null || split.length != 9) {
                return null;
            }
            return split[2];
        }
        return (String) invokeL.objValue;
    }

    public static String getSafeSavedData(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, context)) == null) {
            String passUid = WalletLoginHelper.getInstance().getPassUid();
            String str2 = SecurePay.getInstance().tokenDecrypt(str);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (bytes.length >= 1) {
                    byte[] bArr = new byte[bytes.length - 1];
                    System.arraycopy(bytes, 0, bArr, 0, bytes.length - 1);
                    if (bytes[bytes.length - 1] == 1 && !TextUtils.isEmpty(passUid)) {
                        bArr = xorArrayRepeat(bArr, passUid.getBytes("UTF-8"));
                    }
                    return new String(bArr, "UTF-8");
                }
                return "";
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getSafeSavedDataByUnionId(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, context)) == null) {
            String unionId = WalletLoginHelper.getInstance().getUnionId();
            String str2 = SecurePay.getInstance().tokenDecrypt(str);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (bytes.length >= 1) {
                    byte[] bArr = new byte[bytes.length - 1];
                    System.arraycopy(bytes, 0, bArr, 0, bytes.length - 1);
                    if (bytes[bytes.length - 1] == 1 && !TextUtils.isEmpty(unionId)) {
                        bArr = xorArrayRepeat(bArr, unionId.getBytes("UTF-8"));
                    }
                    return new String(bArr, "UTF-8");
                }
                return "";
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static long getmSyncWithServerTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? ((Long) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.base.nopassauth.OtpTokenUtils.f59934b, 0L)).longValue() : invokeL.longValue;
    }

    public static void setmSyncWithServerTime(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, null, context, j2) == null) {
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, com.baidu.wallet.base.nopassauth.OtpTokenUtils.f59934b, Long.valueOf(j2));
        }
    }

    public static long syncTime(long j2) {
        InterceptResult invokeJ;
        HttpsURLConnection httpsURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j2)) == null) {
            HttpsURLConnection httpsURLConnection2 = null;
            try {
                try {
                    f69169a = 0L;
                    httpsURLConnection = (HttpsURLConnection) new URL("https://www.baidu.com/").openConnection();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(f69170b * 1000);
                httpsURLConnection.setHostnameVerifier(new a());
                httpsURLConnection.connect();
                f69169a = httpsURLConnection.getDate() / 1000;
                if (httpsURLConnection != null) {
                    try {
                        InputStream a2 = a(httpsURLConnection);
                        if (a2 != null) {
                            a2.close();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    httpsURLConnection.disconnect();
                }
                return (System.currentTimeMillis() / 1000) - f69169a;
            } catch (Exception e4) {
                e = e4;
                httpsURLConnection2 = httpsURLConnection;
                e.printStackTrace();
                if (httpsURLConnection2 != null) {
                    try {
                        InputStream a3 = a(httpsURLConnection2);
                        if (a3 != null) {
                            a3.close();
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    httpsURLConnection2.disconnect();
                }
                return j2;
            } catch (Throwable th2) {
                th = th2;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    try {
                        InputStream a4 = a(httpsURLConnection2);
                        if (a4 != null) {
                            a4.close();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    httpsURLConnection2.disconnect();
                }
                throw th;
            }
        }
        return invokeJ.longValue;
    }

    public static String toSafeSavedData(String str, Context context) {
        InterceptResult invokeLL;
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, context)) == null) {
            String passUid = WalletLoginHelper.getInstance().getPassUid();
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (TextUtils.isEmpty(passUid)) {
                        b2 = b(str.getBytes("UTF-8"), false);
                    } else {
                        b2 = b(xorArrayRepeat(str.getBytes("UTF-8"), passUid.getBytes("UTF-8")), true);
                    }
                    return SecurePay.getInstance().tokenEncrypt(new String(b2, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String toSafeSavedDataByUnionId(String str, Context context) {
        InterceptResult invokeLL;
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, context)) == null) {
            String unionId = WalletLoginHelper.getInstance().getUnionId();
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (TextUtils.isEmpty(unionId)) {
                        b2 = b(str.getBytes("UTF-8"), false);
                    } else {
                        b2 = b(xorArrayRepeat(str.getBytes("UTF-8"), unionId.getBytes("UTF-8")), true);
                    }
                    return SecurePay.getInstance().tokenEncrypt(new String(b2, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] xorArrayRepeat(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[bArr.length];
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                bArr3[i3] = (byte) (bArr[i2] ^ bArr2[i3 % bArr2.length]);
                i2++;
                i3++;
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}

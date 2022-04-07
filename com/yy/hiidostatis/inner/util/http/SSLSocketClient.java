package com.yy.hiidostatis.inner.util.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.SecureRandom;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.CertificatePinner;
/* loaded from: classes8.dex */
public class SSLSocketClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALT_DNS_NAME = 2;
    public static final Pattern VERIFY_AS_IP_ADDRESS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-335473097, "Lcom/yy/hiidostatis/inner/util/http/SSLSocketClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-335473097, "Lcom/yy/hiidostatis/inner/util/http/SSLSocketClient;");
                return;
            }
        }
        VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public SSLSocketClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static HostnameVerifier getHostnameVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new HostnameVerifier() { // from class: com.yy.hiidostatis.inner.util.http.SSLSocketClient.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) {
                    if (SSLSocketClient.verifyAsIpAddress(str)) {
                        return SSLSocketClient.verifyIp(sSLSession);
                    }
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
                return invokeLL.booleanValue;
            }
        } : (HostnameVerifier) invokeV.objValue;
    }

    public static SSLSocketFactory getSSLSocketFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance(BdSailorConfig.SAILOR_BASE_SSL);
                sSLContext.init(null, null, new SecureRandom());
                return sSLContext.getSocketFactory();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (SSLSocketFactory) invokeV.objValue;
    }

    public static List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
        InterceptResult invokeLI;
        Integer num;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, x509Certificate, i)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                if (subjectAlternativeNames == null) {
                    return Collections.emptyList();
                }
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            } catch (CertificateParsingException unused) {
                return Collections.emptyList();
            }
        }
        return (List) invokeLI.objValue;
    }

    public static boolean verifyAsIpAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? VERIFY_AS_IP_ADDRESS.matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean verifyHostname(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith(IStringUtil.TOP_PATH) && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith(IStringUtil.TOP_PATH)) {
                if (!str.endsWith(".")) {
                    str = str + IStringUtil.EXTENSION_SEPARATOR;
                }
                if (!str2.endsWith(".")) {
                    str2 = str2 + IStringUtil.EXTENSION_SEPARATOR;
                }
                String lowerCase = str2.toLowerCase(Locale.US);
                if (!lowerCase.contains("*")) {
                    return str.equals(lowerCase);
                }
                if (!lowerCase.startsWith(CertificatePinner.Pin.WILDCARD) || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || CertificatePinner.Pin.WILDCARD.equals(lowerCase)) {
                    return false;
                }
                String substring = lowerCase.substring(1);
                if (str.endsWith(substring)) {
                    int length = str.length() - substring.length();
                    return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c A[Catch: SSLException -> 0x0035, TryCatch #0 {SSLException -> 0x0035, blocks: (B:5:0x0005, B:6:0x0016, B:8:0x001c, B:11:0x002c), top: B:20:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean verifyIp(SSLSession sSLSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sSLSession)) == null) {
            try {
                for (String str : getSubjectAltNames((X509Certificate) sSLSession.getPeerCertificates()[0], 2)) {
                    if (verifyHostname("mlog.bigda.com", str) || verifyHostname("mlog.hiido.com", str)) {
                        return true;
                    }
                    while (r4.hasNext()) {
                    }
                }
            } catch (SSLException unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

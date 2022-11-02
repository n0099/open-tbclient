package com.yy.gslbsdk.network;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.CertificatePinner;
/* loaded from: classes8.dex */
public class TlsSniSocketFactory extends SSLSocketFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public HttpsURLConnection conn;
    public HostnameVerifier hostnameVerifier;

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Socket) invokeV.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            return null;
        }
        return (Socket) invokeLI.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), inetAddress, Integer.valueOf(i2)})) == null) {
            return null;
        }
        return (Socket) invokeCommon.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, inetAddress, i)) == null) {
            return null;
        }
        return (Socket) invokeLI.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{inetAddress, Integer.valueOf(i), inetAddress2, Integer.valueOf(i2)})) == null) {
            return null;
        }
        return (Socket) invokeCommon.objValue;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static class HostnameVerifierEx implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ALT_DNS_NAME = 2;
        public static final Pattern VERIFY_AS_IP_ADDRESS;
        public transient /* synthetic */ FieldHolder $fh;
        public HttpsURLConnection mConn;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-15637550, "Lcom/yy/gslbsdk/network/TlsSniSocketFactory$HostnameVerifierEx;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-15637550, "Lcom/yy/gslbsdk/network/TlsSniSocketFactory$HostnameVerifierEx;");
                    return;
                }
            }
            VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        }

        public HostnameVerifierEx(HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpsURLConnection};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mConn = httpsURLConnection;
        }

        public static boolean verifyAsIpAddress(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
            }
            return invokeL.booleanValue;
        }

        public static List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
            InterceptResult invokeLI;
            Integer num;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, x509Certificate, i)) == null) {
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

        public static boolean verifyHostname(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
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
                    if (!str.endsWith(substring)) {
                        return false;
                    }
                    int length = str.length() - substring.length();
                    if (length > 0 && str.lastIndexOf(46, length - 1) != -1) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public static boolean verifyIp(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, sSLSession)) == null) {
                try {
                    for (String str2 : getSubjectAltNames((X509Certificate) sSLSession.getPeerCertificates()[0], 2)) {
                        if (verifyHostname(str, str2)) {
                            return true;
                        }
                    }
                } catch (SSLException unused) {
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                if (verifyAsIpAddress(str)) {
                    return verifyIp(str, sSLSession);
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    public TlsSniSocketFactory(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpsURLConnection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = TlsSniSocketFactory.class.getSimpleName();
        this.hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        this.conn = httpsURLConnection;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{socket, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            String requestProperty = this.conn.getRequestProperty("Host");
            if (requestProperty != null) {
                str = requestProperty;
            }
            InetAddress inetAddress = socket.getInetAddress();
            if (z) {
                socket.close();
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            if (Build.VERSION.SDK_INT >= 17) {
                sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            } else {
                try {
                    sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
                } catch (Exception unused) {
                }
            }
            if (this.hostnameVerifier.verify(str, sSLSocket.getSession())) {
                return sSLSocket;
            }
            throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        }
        return (Socket) invokeCommon.objValue;
    }
}

package okhttp3.internal.platform;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;
/* loaded from: classes9.dex */
public class Platform {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INFO = 4;
    public static final Platform PLATFORM;
    public static final int WARN = 5;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1228943758, "Lokhttp3/internal/platform/Platform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1228943758, "Lokhttp3/internal/platform/Platform;");
                return;
            }
        }
        PLATFORM = findPlatform();
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public Platform() {
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

    public static List<String> alpnProtocolNames(List<Protocol> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Protocol protocol = list.get(i2);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static byte[] concatLengthPrefixed(List<Protocol> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            Buffer buffer = new Buffer();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Protocol protocol = list.get(i2);
                if (protocol != Protocol.HTTP_1_0) {
                    buffer.writeByte(protocol.toString().length());
                    buffer.writeUtf8(protocol.toString());
                }
            }
            return buffer.readByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static Platform findPlatform() {
        InterceptResult invokeV;
        Platform buildIfSupported;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Platform buildIfSupported2 = AndroidPlatform.buildIfSupported();
            if (buildIfSupported2 != null) {
                return buildIfSupported2;
            }
            if (!isConscryptPreferred() || (buildIfSupported = ConscryptPlatform.buildIfSupported()) == null) {
                Jdk9Platform buildIfSupported3 = Jdk9Platform.buildIfSupported();
                if (buildIfSupported3 != null) {
                    return buildIfSupported3;
                }
                Platform buildIfSupported4 = JdkWithJettyBootPlatform.buildIfSupported();
                return buildIfSupported4 != null ? buildIfSupported4 : new Platform();
            }
            return buildIfSupported;
        }
        return (Platform) invokeV.objValue;
    }

    public static Platform get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? PLATFORM : (Platform) invokeV.objValue;
    }

    public static boolean isConscryptPreferred() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
                return true;
            }
            return "Conscrypt".equals(Security.getProviders()[0].getName());
        }
        return invokeV.booleanValue;
    }

    public static <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        InterceptResult invokeLLL;
        Object readFieldOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, cls, str)) == null) {
            for (Class<?> cls2 = obj.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 != null && cls.isInstance(obj2)) {
                        return cls.cast(obj2);
                    }
                    return null;
                } catch (IllegalAccessException unused) {
                    throw new AssertionError();
                } catch (NoSuchFieldException unused2) {
                }
            }
            if (str.equals("delegate") || (readFieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                return null;
            }
            return (T) readFieldOrNull(readFieldOrNull, cls, str);
        }
        return (T) invokeLLL.objValue;
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sSLSocket) == null) {
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x509TrustManager)) == null) ? new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager)) : (CertificateChainCleaner) invokeL.objValue;
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, x509TrustManager)) == null) ? new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers()) : (TrustRootIndex) invokeL.objValue;
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sSLSocketFactory) == null) {
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, sSLSocket, str, list) == null) {
        }
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, socket, inetSocketAddress, i2) == null) {
            socket.connect(inetSocketAddress, i2);
        }
    }

    public String getPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "OkHttp" : (String) invokeV.objValue;
    }

    public SSLContext getSSLContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if ("1.7".equals(System.getProperty("java.specification.version"))) {
                try {
                    return SSLContext.getInstance("TLSv1.2");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            try {
                return SSLContext.getInstance("TLS");
            } catch (NoSuchAlgorithmException e2) {
                throw new IllegalStateException("No TLS provider", e2);
            }
        }
        return (SSLContext) invokeV.objValue;
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, sSLSocket)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public Object getStackTraceForCloseable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (logger.isLoggable(Level.FINE)) {
                return new Throwable(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void log(int i2, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i2, str, th) == null) {
            logger.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
        }
    }

    public void logCloseableLeak(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, obj) == null) {
            if (obj == null) {
                str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
            }
            log(5, str, (Throwable) obj);
        }
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, sSLSocketFactory)) == null) {
            try {
                Object readFieldOrNull = readFieldOrNull(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
                if (readFieldOrNull == null) {
                    return null;
                }
                return (X509TrustManager) readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return (X509TrustManager) invokeL.objValue;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocketFactory)) == null) {
            X509TrustManager trustManager = trustManager(sSLSocketFactory);
            if (trustManager != null) {
                return buildCertificateChainCleaner(trustManager);
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
        }
        return (CertificateChainCleaner) invokeL.objValue;
    }
}

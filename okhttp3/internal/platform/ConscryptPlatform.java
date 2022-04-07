package okhttp3.internal.platform;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;
/* loaded from: classes8.dex */
public class ConscryptPlatform extends Platform {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ConscryptPlatform() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Platform buildIfSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class.forName("org.conscrypt.ConscryptEngineSocket");
                if (Conscrypt.isAvailable()) {
                    return new ConscryptPlatform();
                }
                return null;
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return (Platform) invokeV.objValue;
    }

    private Provider getProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new OpenSSLProvider() : (Provider) invokeV.objValue;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sSLSocketFactory) == null) && Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocket, str, list) == null) {
            if (Conscrypt.isConscrypt(sSLSocket)) {
                if (str != null) {
                    Conscrypt.setUseSessionTickets(sSLSocket, true);
                    Conscrypt.setHostname(sSLSocket, str);
                }
                Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.alpnProtocolNames(list).toArray(new String[0]));
                return;
            }
            super.configureTlsExtensions(sSLSocket, str, list);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext getSSLContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return SSLContext.getInstance("TLS", getProvider());
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
        return (SSLContext) invokeV.objValue;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sSLSocket)) == null) {
            if (Conscrypt.isConscrypt(sSLSocket)) {
                return Conscrypt.getApplicationProtocol(sSLSocket);
            }
            return super.getSelectedProtocol(sSLSocket);
        }
        return (String) invokeL.objValue;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sSLSocketFactory)) == null) {
            if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
                return super.trustManager(sSLSocketFactory);
            }
            try {
                Object readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, Object.class, "sslParameters");
                if (readFieldOrNull != null) {
                    return (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
                }
                return null;
            } catch (Exception e) {
                throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
            }
        }
        return (X509TrustManager) invokeL.objValue;
    }
}

package okhttp3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;
/* loaded from: classes3.dex */
public final class Handshake {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CipherSuite cipherSuite;
    public final List<Certificate> localCertificates;
    public final List<Certificate> peerCertificates;
    public final TlsVersion tlsVersion;

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tlsVersion, cipherSuite, list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.peerCertificates = list;
        this.localCertificates = list2;
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        InterceptResult invokeL;
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sSLSession)) == null) {
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
                    CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
                    String protocol = sSLSession.getProtocol();
                    if (protocol != null) {
                        if (!PolyActivity.NONE_PANEL_TYPE.equals(protocol)) {
                            TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
                            try {
                                certificateArr = sSLSession.getPeerCertificates();
                            } catch (SSLPeerUnverifiedException unused) {
                                certificateArr = null;
                            }
                            if (certificateArr != null) {
                                emptyList = Util.immutableList(certificateArr);
                            } else {
                                emptyList = Collections.emptyList();
                            }
                            Certificate[] localCertificates = sSLSession.getLocalCertificates();
                            if (localCertificates != null) {
                                emptyList2 = Util.immutableList(localCertificates);
                            } else {
                                emptyList2 = Collections.emptyList();
                            }
                            return new Handshake(forJavaName2, forJavaName, emptyList, emptyList2);
                        }
                        throw new IOException("tlsVersion == NONE");
                    }
                    throw new IllegalStateException("tlsVersion == null");
                }
                throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
            }
            throw new IllegalStateException("cipherSuite == null");
        }
        return (Handshake) invokeL.objValue;
    }

    public CipherSuite cipherSuite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cipherSuite : (CipherSuite) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof Handshake) {
                Handshake handshake = (Handshake) obj;
                return this.tlsVersion.equals(handshake.tlsVersion) && this.cipherSuite.equals(handshake.cipherSuite) && this.peerCertificates.equals(handshake.peerCertificates) && this.localCertificates.equals(handshake.localCertificates);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + this.peerCertificates.hashCode()) * 31) + this.localCertificates.hashCode() : invokeV.intValue;
    }

    public List<Certificate> localCertificates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.localCertificates : (List) invokeV.objValue;
    }

    @Nullable
    public Principal localPrincipal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.localCertificates.isEmpty()) {
                return null;
            }
            return ((X509Certificate) this.localCertificates.get(0)).getSubjectX500Principal();
        }
        return (Principal) invokeV.objValue;
    }

    public List<Certificate> peerCertificates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.peerCertificates : (List) invokeV.objValue;
    }

    @Nullable
    public Principal peerPrincipal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.peerCertificates.isEmpty()) {
                return null;
            }
            return ((X509Certificate) this.peerCertificates.get(0)).getSubjectX500Principal();
        }
        return (Principal) invokeV.objValue;
    }

    public TlsVersion tlsVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.tlsVersion : (TlsVersion) invokeV.objValue;
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, tlsVersion, cipherSuite, list, list2)) == null) {
            if (tlsVersion != null) {
                if (cipherSuite != null) {
                    return new Handshake(tlsVersion, cipherSuite, Util.immutableList(list), Util.immutableList(list2));
                }
                throw new NullPointerException("cipherSuite == null");
            }
            throw new NullPointerException("tlsVersion == null");
        }
        return (Handshake) invokeLLLL.objValue;
    }
}

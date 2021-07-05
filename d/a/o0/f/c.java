package d.a.o0.f;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46370a;

    /* renamed from: b  reason: collision with root package name */
    public static SSLSocketFactory f46371b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public X509TrustManager f46372a;

        public a(c cVar, X509TrustManager x509TrustManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, x509TrustManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46372a = null;
            this.f46372a = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
                this.f46372a.checkClientTrusted(x509CertificateArr, str);
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
                try {
                    this.f46372a.checkServerTrusted(x509CertificateArr, str);
                } catch (Throwable th) {
                    d.a.o0.l.c.d(th);
                    if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                        return;
                    }
                    if (th instanceof CertificateException) {
                        throw th;
                    }
                    throw new CertificateException();
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46372a.getAcceptedIssuers() : (X509Certificate[]) invokeV.objValue;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public static void b(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, httpsURLConnection) == null) {
            try {
                if (f46370a == null) {
                    synchronized (c.class) {
                        f46370a = new c();
                    }
                }
                f46370a.c(httpsURLConnection);
            } catch (Throwable th) {
                d.a.o0.l.c.d(th);
            }
        }
    }

    @SuppressLint({"TrulyRandom"})
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (f46371b != null) {
                    return;
                }
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length >= 1 && (trustManagers[0] instanceof X509TrustManager)) {
                    sSLContext.init(null, new TrustManager[]{new a(this, (X509TrustManager) trustManagers[0])}, new SecureRandom());
                    f46371b = sSLContext.getSocketFactory();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected default trust managers:");
                sb.append(Arrays.toString(trustManagers));
                throw new IllegalStateException(sb.toString());
            } catch (Throwable th) {
                d.a.o0.l.c.d(th);
            }
        }
    }

    public final void c(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpsURLConnection) == null) || httpsURLConnection == null) {
            return;
        }
        try {
            if (f46371b == null) {
                return;
            }
            httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            httpsURLConnection.setSSLSocketFactory(f46371b);
        } catch (Throwable th) {
            d.a.o0.l.c.d(th);
        }
    }
}

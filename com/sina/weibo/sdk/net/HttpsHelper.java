package com.sina.weibo.sdk.net;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes2.dex */
public final class HttpsHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SSLSocketFactory mSSLSocketFactory;

    /* loaded from: classes2.dex */
    public static class CustomX509TrustManager implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<X509TrustManager> mTrustManagers;

        public CustomX509TrustManager(KeyStore... keyStoreArr) {
            TrustManager[] trustManagers;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyStoreArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTrustManagers = new ArrayList();
            ArrayList<TrustManagerFactory> arrayList = new ArrayList();
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                arrayList.add(trustManagerFactory);
                for (KeyStore keyStore : keyStoreArr) {
                    TrustManagerFactory trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory2.init(keyStore);
                    arrayList.add(trustManagerFactory2);
                }
                for (TrustManagerFactory trustManagerFactory3 : arrayList) {
                    for (TrustManager trustManager : trustManagerFactory3.getTrustManagers()) {
                        if (trustManager instanceof X509TrustManager) {
                            this.mTrustManagers.add((X509TrustManager) trustManager);
                        }
                    }
                }
                if (this.mTrustManagers.size() != 0) {
                    return;
                }
                throw new RuntimeException("Couldn't find any X509TrustManagers");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
                this.mTrustManagers.get(0).checkClientTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
                for (X509TrustManager x509TrustManager : this.mTrustManagers) {
                    x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList arrayList = new ArrayList();
                for (X509TrustManager x509TrustManager : this.mTrustManagers) {
                    arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
                }
                return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
            }
            return (X509Certificate[]) invokeV.objValue;
        }
    }

    public HttpsHelper() {
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

    private SSLSocketFactory getSSLSocketFactory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) {
            if (this.mSSLSocketFactory == null) {
                try {
                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    keyStore.load(null, null);
                    keyStore.setCertificateEntry("get_global_ca", loadCertificate(context));
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, new TrustManager[]{new CustomX509TrustManager(keyStore)}, null);
                    this.mSSLSocketFactory = sSLContext.getSocketFactory();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (KeyManagementException e3) {
                    e3.printStackTrace();
                } catch (KeyStoreException e4) {
                    e4.printStackTrace();
                } catch (NoSuchAlgorithmException e5) {
                    e5.printStackTrace();
                } catch (CertificateException e6) {
                    e6.printStackTrace();
                }
            }
            return this.mSSLSocketFactory;
        }
        return (SSLSocketFactory) invokeL.objValue;
    }

    private Certificate loadCertificate(Context context) throws CertificateException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open("weibocn.cer"));
            try {
                return certificateFactory.generateCertificate(bufferedInputStream);
            } finally {
                bufferedInputStream.close();
            }
        }
        return (Certificate) invokeL.objValue;
    }
}

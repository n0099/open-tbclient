package com.cmic.sso.sdk.b.e;

import android.util.Base64;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
/* loaded from: classes12.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public X509Certificate a;

    /* renamed from: b  reason: collision with root package name */
    public SSLContext f54967b;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(str);
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("cert", this.a);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance(BdSailorConfig.SAILOR_BASE_SSL);
            this.f54967b = sSLContext;
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str) {
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, str) == null) && this.a == null) {
            ByteArrayInputStream byteArrayInputStream2 = null;
            try {
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                } catch (CertificateException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.a = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
                byteArrayInputStream.close();
            } catch (CertificateException e4) {
                e = e4;
                byteArrayInputStream2 = byteArrayInputStream;
                e.printStackTrace();
                if (byteArrayInputStream2 != null) {
                    byteArrayInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream2 = byteArrayInputStream;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public SSLContext a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54967b : (SSLContext) invokeV.objValue;
    }
}

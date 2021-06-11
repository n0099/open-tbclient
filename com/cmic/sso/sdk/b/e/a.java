package com.cmic.sso.sdk.b.e;

import android.util.Base64;
import com.baidu.browser.sailor.BdSailorConfig;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public X509Certificate f30645a;

    /* renamed from: b  reason: collision with root package name */
    public SSLContext f30646b;

    public a(String str) {
        a(str);
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("cert", this.f30645a);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance(BdSailorConfig.SAILOR_BASE_SSL);
            this.f30646b = sSLContext;
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str) {
        ByteArrayInputStream byteArrayInputStream;
        if (this.f30645a == null) {
            ByteArrayInputStream byteArrayInputStream2 = null;
            try {
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
                    } catch (CertificateException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    this.f30645a = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
                    byteArrayInputStream.close();
                } catch (CertificateException e3) {
                    e = e3;
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
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    public SSLContext a() {
        return this.f30646b;
    }
}

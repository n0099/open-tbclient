package com;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements X509TrustManager {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

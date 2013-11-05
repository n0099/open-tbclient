package defpackage;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bl  reason: default package */
/* loaded from: classes.dex */
public class bl implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f381a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.f381a = bkVar;
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

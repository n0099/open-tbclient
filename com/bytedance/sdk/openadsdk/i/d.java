package com.bytedance.sdk.openadsdk.i;

import com.bytedance.sdk.openadsdk.utils.al;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.security.cert.Certificate;
/* loaded from: classes4.dex */
public class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final d f7512a = new d();

    private d() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            if (!"is.snssdk.com".equalsIgnoreCase(str) && !"pangolin.snssdk.com".equalsIgnoreCase(str)) {
                return true;
            }
            return al.a((Certificate[]) sSLSession.getPeerCertificateChain());
        } catch (Throwable th) {
            return true;
        }
    }
}

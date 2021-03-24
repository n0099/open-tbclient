package com.sdk.base.framework.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
/* loaded from: classes6.dex */
public final class i implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}

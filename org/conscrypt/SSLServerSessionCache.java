package org.conscrypt;

import javax.net.ssl.SSLSession;
/* loaded from: classes12.dex */
interface SSLServerSessionCache {
    byte[] getSessionData(byte[] bArr);

    void putSessionData(SSLSession sSLSession, byte[] bArr);
}

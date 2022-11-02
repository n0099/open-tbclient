package org.webrtc;
/* loaded from: classes9.dex */
public interface SSLCertificateVerifier {
    @CalledByNative
    boolean verify(byte[] bArr);
}

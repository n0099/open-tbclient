package org.webrtc;

import javax.annotation.Nullable;
import org.webrtc.PeerConnection;
/* loaded from: classes.dex */
public final class PeerConnectionDependencies {
    public final PeerConnection.Observer observer;
    public final SSLCertificateVerifier sslCertificateVerifier;

    /* loaded from: classes7.dex */
    public static class Builder {
        public PeerConnection.Observer observer;
        public SSLCertificateVerifier sslCertificateVerifier;

        public Builder(PeerConnection.Observer observer) {
            this.observer = observer;
        }

        public PeerConnectionDependencies createPeerConnectionDependencies() {
            return new PeerConnectionDependencies(this.observer, this.sslCertificateVerifier);
        }

        public Builder setSSLCertificateVerifier(SSLCertificateVerifier sSLCertificateVerifier) {
            this.sslCertificateVerifier = sSLCertificateVerifier;
            return this;
        }
    }

    public PeerConnectionDependencies(PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier) {
        this.observer = observer;
        this.sslCertificateVerifier = sSLCertificateVerifier;
    }

    public static Builder builder(PeerConnection.Observer observer) {
        return new Builder(observer);
    }

    public PeerConnection.Observer getObserver() {
        return this.observer;
    }

    @Nullable
    public SSLCertificateVerifier getSSLCertificateVerifier() {
        return this.sslCertificateVerifier;
    }
}

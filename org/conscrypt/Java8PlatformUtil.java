package org.conscrypt;

import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class Java8PlatformUtil {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        Java7PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl);
        sSLParametersImpl.setUseCipherSuitesOrder(sSLParameters.getUseCipherSuitesOrder());
        List<SNIServerName> serverNames = sSLParameters.getServerNames();
        if (serverNames != null) {
            for (SNIServerName sNIServerName : serverNames) {
                if (sNIServerName.getType() == 0) {
                    abstractConscryptSocket.setHostname(((SNIHostName) sNIServerName).getAsciiName());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        Java7PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl);
        sSLParameters.setUseCipherSuitesOrder(sSLParametersImpl.getUseCipherSuitesOrder());
        if (sSLParametersImpl.getUseSni() && AddressUtils.isValidSniHostname(abstractConscryptSocket.getHostname())) {
            sSLParameters.setServerNames(Collections.singletonList(new SNIHostName(abstractConscryptSocket.getHostname())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        Java7PlatformUtil.setSSLParameters(sSLParameters, sSLParametersImpl);
        sSLParametersImpl.setUseCipherSuitesOrder(sSLParameters.getUseCipherSuitesOrder());
        List<SNIServerName> serverNames = sSLParameters.getServerNames();
        if (serverNames != null) {
            for (SNIServerName sNIServerName : serverNames) {
                if (sNIServerName.getType() == 0) {
                    conscryptEngine.setHostname(((SNIHostName) sNIServerName).getAsciiName());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        Java7PlatformUtil.getSSLParameters(sSLParameters, sSLParametersImpl);
        sSLParameters.setUseCipherSuitesOrder(sSLParametersImpl.getUseCipherSuitesOrder());
        if (sSLParametersImpl.getUseSni() && AddressUtils.isValidSniHostname(conscryptEngine.getHostname())) {
            sSLParameters.setServerNames(Collections.singletonList(new SNIHostName(conscryptEngine.getHostname())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLEngine wrapEngine(ConscryptEngine conscryptEngine) {
        return new Java8EngineWrapper(conscryptEngine);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLEngine unwrapEngine(SSLEngine sSLEngine) {
        return Java8EngineWrapper.getDelegate(sSLEngine);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLSession wrapSSLSession(ConscryptSession conscryptSession) {
        return new Java8ExtendedSSLSession(conscryptSession);
    }

    private Java8PlatformUtil() {
    }
}

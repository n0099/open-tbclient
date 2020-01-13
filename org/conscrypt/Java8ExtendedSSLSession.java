package org.conscrypt;

import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
/* loaded from: classes5.dex */
class Java8ExtendedSSLSession extends Java7ExtendedSSLSession {
    public Java8ExtendedSSLSession(ConscryptSession conscryptSession) {
        super(conscryptSession);
    }

    @Override // javax.net.ssl.ExtendedSSLSession
    public final List<SNIServerName> getRequestedServerNames() {
        String requestedServerName = getDelegate().getRequestedServerName();
        if (requestedServerName == null) {
            return null;
        }
        return Collections.singletonList(new SNIHostName(requestedServerName));
    }
}

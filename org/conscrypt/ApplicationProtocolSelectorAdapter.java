package org.conscrypt;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocket;
/* loaded from: classes12.dex */
final class ApplicationProtocolSelectorAdapter {
    private static final int NO_PROTOCOL_SELECTED = -1;
    private final SSLEngine engine;
    private final ApplicationProtocolSelector selector;
    private final SSLSocket socket;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApplicationProtocolSelectorAdapter(SSLEngine sSLEngine, ApplicationProtocolSelector applicationProtocolSelector) {
        this.engine = (SSLEngine) Preconditions.checkNotNull(sSLEngine, "engine");
        this.socket = null;
        this.selector = (ApplicationProtocolSelector) Preconditions.checkNotNull(applicationProtocolSelector, "selector");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApplicationProtocolSelectorAdapter(SSLSocket sSLSocket, ApplicationProtocolSelector applicationProtocolSelector) {
        this.engine = null;
        this.socket = (SSLSocket) Preconditions.checkNotNull(sSLSocket, "socket");
        this.selector = (ApplicationProtocolSelector) Preconditions.checkNotNull(applicationProtocolSelector, "selector");
    }

    int selectApplicationProtocol(byte[] bArr) {
        String selectApplicationProtocol;
        if (bArr == null || bArr.length == 0) {
            return -1;
        }
        List<String> asList = Arrays.asList(SSLUtils.decodeProtocols(bArr));
        if (this.engine != null) {
            selectApplicationProtocol = this.selector.selectApplicationProtocol(this.engine, asList);
        } else {
            selectApplicationProtocol = this.selector.selectApplicationProtocol(this.socket, asList);
        }
        if (selectApplicationProtocol == null || selectApplicationProtocol.isEmpty()) {
            return -1;
        }
        int i = 0;
        Iterator<String> it = asList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return -1;
            }
            String next = it.next();
            if (!selectApplicationProtocol.equals(next)) {
                i = next.length() + 1 + i2;
            } else {
                return i2;
            }
        }
    }
}

package org.conscrypt;

import javax.net.ssl.SSLException;
/* loaded from: classes12.dex */
public abstract class HandshakeListener {
    public abstract void onHandshakeFinished() throws SSLException;
}

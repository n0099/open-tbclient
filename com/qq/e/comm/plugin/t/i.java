package com.qq.e.comm.plugin.t;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
/* loaded from: classes4.dex */
public abstract class i implements b {
    public abstract void a(int i, Exception exc);

    @Override // com.qq.e.comm.plugin.t.b
    public void a(Exception exc) {
        a(exc instanceof SocketTimeoutException ? 3002 : exc instanceof UnknownHostException ? 3003 : exc instanceof ConnectException ? 3001 : exc instanceof SSLHandshakeException ? 3004 : 3000, exc);
    }
}

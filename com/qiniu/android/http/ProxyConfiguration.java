package com.qiniu.android.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class ProxyConfiguration {
    public final String nhp;
    public final Proxy.Type nhq;
    public final String password;
    public final int port;
    public final String user;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Proxy proxy() {
        return new Proxy(this.nhq, new InetSocketAddress(this.nhp, this.port));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Authenticator authenticator() {
        return new Authenticator() { // from class: com.qiniu.android.http.ProxyConfiguration.1
            @Override // okhttp3.Authenticator
            public Request authenticate(Route route, Response response) throws IOException {
                return response.request().newBuilder().header(AUTH.PROXY_AUTH_RESP, Credentials.basic(ProxyConfiguration.this.user, ProxyConfiguration.this.password)).header("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).build();
            }
        };
    }
}

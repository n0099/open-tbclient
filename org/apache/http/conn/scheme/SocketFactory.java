package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes8.dex */
public interface SocketFactory {
    Socket connectSocket(Socket socket, String str, int i2, InetAddress inetAddress, int i3, HttpParams httpParams) throws IOException, UnknownHostException, ConnectTimeoutException;

    Socket createSocket() throws IOException;

    boolean isSecure(Socket socket) throws IllegalArgumentException;
}

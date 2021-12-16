package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;
@Deprecated
/* loaded from: classes4.dex */
public interface HostNameResolver {
    InetAddress resolve(String str) throws IOException;
}

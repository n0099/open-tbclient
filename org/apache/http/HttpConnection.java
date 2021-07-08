package org.apache.http;

import java.io.IOException;
@Deprecated
/* loaded from: classes9.dex */
public interface HttpConnection {
    void close() throws IOException;

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int i2);

    void shutdown() throws IOException;
}

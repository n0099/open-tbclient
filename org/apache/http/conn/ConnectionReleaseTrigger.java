package org.apache.http.conn;

import java.io.IOException;
@Deprecated
/* loaded from: classes10.dex */
public interface ConnectionReleaseTrigger {
    void abortConnection() throws IOException;

    void releaseConnection() throws IOException;
}

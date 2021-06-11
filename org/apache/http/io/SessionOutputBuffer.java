package org.apache.http.io;

import java.io.IOException;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes8.dex */
public interface SessionOutputBuffer {
    void flush() throws IOException;

    HttpTransportMetrics getMetrics();

    void write(int i2) throws IOException;

    void write(byte[] bArr) throws IOException;

    void write(byte[] bArr, int i2, int i3) throws IOException;

    void writeLine(String str) throws IOException;

    void writeLine(CharArrayBuffer charArrayBuffer) throws IOException;
}

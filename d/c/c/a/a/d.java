package d.c.c.a.a;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes5.dex */
public interface d extends p, WritableByteChannel {
    d b(String str) throws IOException;

    c c();

    d c(byte[] bArr) throws IOException;

    d c(byte[] bArr, int i, int i2) throws IOException;

    @Override // d.c.c.a.a.p, java.io.Flushable
    void flush() throws IOException;

    d g(int i) throws IOException;

    d h(int i) throws IOException;

    d h(long j) throws IOException;

    d i(int i) throws IOException;

    d u() throws IOException;
}

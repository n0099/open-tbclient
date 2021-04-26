package d.b.c.a.a;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes5.dex */
public interface d extends p, WritableByteChannel {
    d b(String str) throws IOException;

    c c();

    d c(byte[] bArr) throws IOException;

    d c(byte[] bArr, int i2, int i3) throws IOException;

    @Override // d.b.c.a.a.p, java.io.Flushable
    void flush() throws IOException;

    d g(int i2) throws IOException;

    d h(int i2) throws IOException;

    d h(long j) throws IOException;

    d i(int i2) throws IOException;

    d u() throws IOException;
}

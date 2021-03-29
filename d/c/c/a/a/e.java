package d.c.c.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public interface e extends q, ReadableByteChannel {
    void a(long j) throws IOException;

    void a(byte[] bArr) throws IOException;

    com.bytedance.sdk.a.a.f c(long j) throws IOException;

    @Deprecated
    c c();

    String e(long j) throws IOException;

    boolean e() throws IOException;

    InputStream f();

    byte[] f(long j) throws IOException;

    void g(long j) throws IOException;

    byte h() throws IOException;

    String i(Charset charset) throws IOException;

    short i() throws IOException;

    int j() throws IOException;

    boolean j(long j, com.bytedance.sdk.a.a.f fVar) throws IOException;

    long k(byte b2) throws IOException;

    short k() throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    String p() throws IOException;
}

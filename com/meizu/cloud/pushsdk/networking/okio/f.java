package com.meizu.cloud.pushsdk.networking.okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
/* loaded from: classes3.dex */
public final class f {
    private static final Logger a = Logger.getLogger(f.class.getName());

    private f() {
    }

    public static d a(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        return new h(lVar);
    }

    public static c a(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        return new g(kVar);
    }

    public static k a(OutputStream outputStream) {
        return a(outputStream, new m());
    }

    private static k a(final OutputStream outputStream, final m mVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (mVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new k() { // from class: com.meizu.cloud.pushsdk.networking.okio.f.1
            @Override // com.meizu.cloud.pushsdk.networking.okio.k
            public void a(b bVar, long j) throws IOException {
                n.a(bVar.b, 0L, j);
                while (j > 0) {
                    m.this.a();
                    i iVar = bVar.a;
                    int min = (int) Math.min(j, iVar.c - iVar.b);
                    outputStream.write(iVar.a, iVar.b, min);
                    iVar.b += min;
                    j -= min;
                    bVar.b -= min;
                    if (iVar.b == iVar.c) {
                        bVar.a = iVar.a();
                        j.a(iVar);
                    }
                }
            }

            @Override // com.meizu.cloud.pushsdk.networking.okio.k, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // com.meizu.cloud.pushsdk.networking.okio.k, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.networking.okio.l
            public void close() throws IOException {
                outputStream.close();
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static l a(InputStream inputStream) {
        return a(inputStream, new m());
    }

    private static l a(final InputStream inputStream, final m mVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (mVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new l() { // from class: com.meizu.cloud.pushsdk.networking.okio.f.2
            @Override // com.meizu.cloud.pushsdk.networking.okio.l
            public long b(b bVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                m.this.a();
                i c = bVar.c(1);
                int read = inputStream.read(c.a, c.c, (int) Math.min(j, 2048 - c.c));
                if (read == -1) {
                    return -1L;
                }
                c.c += read;
                bVar.b += read;
                return read;
            }

            @Override // com.meizu.cloud.pushsdk.networking.okio.l, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static l a(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileInputStream(file));
    }
}

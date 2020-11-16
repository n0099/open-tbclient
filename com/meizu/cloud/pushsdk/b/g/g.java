package com.meizu.cloud.pushsdk.b.g;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
/* loaded from: classes15.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f4351a = Logger.getLogger(g.class.getName());

    private g() {
    }

    public static c a(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        return new h(lVar);
    }

    public static d a(m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        return new i(mVar);
    }

    public static l a(OutputStream outputStream) {
        return a(outputStream, new n());
    }

    private static l a(final OutputStream outputStream, final n nVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new l() { // from class: com.meizu.cloud.pushsdk.b.g.g.1
            @Override // com.meizu.cloud.pushsdk.b.g.l
            public void a(b bVar, long j) throws IOException {
                o.a(bVar.b, 0L, j);
                while (j > 0) {
                    n.this.a();
                    j jVar = bVar.f4347a;
                    int min = (int) Math.min(j, jVar.c - jVar.b);
                    outputStream.write(jVar.f4357a, jVar.b, min);
                    jVar.b += min;
                    j -= min;
                    bVar.b -= min;
                    if (jVar.b == jVar.c) {
                        bVar.f4347a = jVar.a();
                        k.a(jVar);
                    }
                }
            }

            @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static m a(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileInputStream(file));
    }

    public static m a(InputStream inputStream) {
        return a(inputStream, new n());
    }

    private static m a(final InputStream inputStream, final n nVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new m() { // from class: com.meizu.cloud.pushsdk.b.g.g.2
            @Override // com.meizu.cloud.pushsdk.b.g.m
            public long b(b bVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                n.this.a();
                j c = bVar.c(1);
                int read = inputStream.read(c.f4357a, c.c, (int) Math.min(j, 2048 - c.c));
                if (read == -1) {
                    return -1L;
                }
                c.c += read;
                bVar.b += read;
                return read;
            }

            @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }
}

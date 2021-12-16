package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
/* loaded from: classes3.dex */
public final class g {
    public static final Logger a = Logger.getLogger(g.class.getName());

    public static c a(l lVar) {
        if (lVar != null) {
            return new h(lVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static d a(m mVar) {
        if (mVar != null) {
            return new i(mVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static l a(OutputStream outputStream) {
        return a(outputStream, new n());
    }

    public static l a(final OutputStream outputStream, final n nVar) {
        if (outputStream != null) {
            if (nVar != null) {
                return new l() { // from class: com.meizu.cloud.pushsdk.b.g.g.1
                    @Override // com.meizu.cloud.pushsdk.b.g.l
                    public void a(b bVar, long j2) throws IOException {
                        o.a(bVar.f60909b, 0L, j2);
                        while (j2 > 0) {
                            n.this.a();
                            j jVar = bVar.a;
                            int min = (int) Math.min(j2, jVar.f60921c - jVar.f60920b);
                            outputStream.write(jVar.a, jVar.f60920b, min);
                            int i2 = jVar.f60920b + min;
                            jVar.f60920b = i2;
                            long j3 = min;
                            j2 -= j3;
                            bVar.f60909b -= j3;
                            if (i2 == jVar.f60921c) {
                                bVar.a = jVar.a();
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
                        return "sink(" + outputStream + SmallTailInfo.EMOTION_SUFFIX;
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static m a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static m a(InputStream inputStream) {
        return a(inputStream, new n());
    }

    public static m a(final InputStream inputStream, final n nVar) {
        if (inputStream != null) {
            if (nVar != null) {
                return new m() { // from class: com.meizu.cloud.pushsdk.b.g.g.2
                    @Override // com.meizu.cloud.pushsdk.b.g.m
                    public long b(b bVar, long j2) throws IOException {
                        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                        if (i2 < 0) {
                            throw new IllegalArgumentException("byteCount < 0: " + j2);
                        } else if (i2 == 0) {
                            return 0L;
                        } else {
                            n.this.a();
                            j c2 = bVar.c(1);
                            int read = inputStream.read(c2.a, c2.f60921c, (int) Math.min(j2, 2048 - c2.f60921c));
                            if (read == -1) {
                                return -1L;
                            }
                            c2.f60921c += read;
                            long j3 = read;
                            bVar.f60909b += j3;
                            return j3;
                        }
                    }

                    @Override // com.meizu.cloud.pushsdk.b.g.m, java.lang.AutoCloseable
                    public void close() throws IOException {
                        inputStream.close();
                    }

                    public String toString() {
                        return "source(" + inputStream + SmallTailInfo.EMOTION_SUFFIX;
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }
}

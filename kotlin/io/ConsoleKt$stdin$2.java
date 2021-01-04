package kotlin.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
final class ConsoleKt$stdin$2 extends Lambda implements kotlin.jvm.a.a<BufferedReader> {
    public static final ConsoleKt$stdin$2 INSTANCE = new ConsoleKt$stdin$2();

    ConsoleKt$stdin$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.a.a
    public final BufferedReader invoke() {
        return new BufferedReader(new InputStreamReader(new InputStream() { // from class: kotlin.io.ConsoleKt$stdin$2.1
            @Override // java.io.InputStream
            public int read() {
                return System.in.read();
            }

            @Override // java.io.InputStream
            public void reset() {
                System.in.reset();
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr) {
                p.o(bArr, com.baidu.pass.biometrics.face.liveness.d.b.f4080a);
                return System.in.read(bArr);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                System.in.close();
            }

            @Override // java.io.InputStream
            public void mark(int i) {
                System.in.mark(i);
            }

            @Override // java.io.InputStream
            public long skip(long j) {
                return System.in.skip(j);
            }

            @Override // java.io.InputStream
            public int available() {
                return System.in.available();
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return System.in.markSupported();
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                p.o(bArr, com.baidu.pass.biometrics.face.liveness.d.b.f4080a);
                return System.in.read(bArr, i, i2);
            }
        }));
    }
}

package d.a.i0.a.h0.o.h.g;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class f extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public InputStream f42322e;

    /* renamed from: f  reason: collision with root package name */
    public d f42323f;

    public f(@NonNull InputStream inputStream, @NonNull d dVar) {
        this.f42322e = inputStream;
        this.f42323f = dVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f42322e.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        d.a.i0.t.d.d(this.f42322e);
        this.f42323f.a();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        super.mark(i2);
        this.f42322e.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f42322e.markSupported();
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        int read = this.f42322e.read(bArr);
        this.f42323f.c(bArr, 0, read);
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f42322e.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        this.f42322e.skip(j);
        return super.skip(j);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int read = this.f42322e.read(bArr, i2, i3);
        this.f42323f.c(bArr, i2, read);
        return read;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f42322e.read();
    }
}

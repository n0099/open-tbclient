package d.a.l0.a.h0.o.h.g;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class f extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public InputStream f46172e;

    /* renamed from: f  reason: collision with root package name */
    public d f46173f;

    public f(@NonNull InputStream inputStream, @NonNull d dVar) {
        this.f46172e = inputStream;
        this.f46173f = dVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f46172e.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        d.a.l0.t.d.d(this.f46172e);
        this.f46173f.a();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        super.mark(i2);
        this.f46172e.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f46172e.markSupported();
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        int read = this.f46172e.read(bArr);
        this.f46173f.c(bArr, 0, read);
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f46172e.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        this.f46172e.skip(j);
        return super.skip(j);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int read = this.f46172e.read(bArr, i2, i3);
        this.f46173f.c(bArr, i2, read);
        return read;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f46172e.read();
    }
}

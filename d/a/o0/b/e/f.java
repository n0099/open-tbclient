package d.a.o0.b.e;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public abstract class f extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public IOException f63876e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63877f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63878g;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f63877f = true;
    }

    public void n() throws IOException {
        IOException iOException = this.f63876e;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void o() throws IOException {
        if (!this.f63878g) {
            if (this.f63877f) {
                throw new IOException("Stream has been closed.");
            }
            return;
        }
        n();
        throw new IOException("Writing after request completed.");
    }

    public abstract void q() throws IOException;

    public abstract UploadDataProvider r();

    public abstract void s() throws IOException;

    public void t(IOException iOException) {
        this.f63876e = iOException;
        this.f63878g = true;
    }
}

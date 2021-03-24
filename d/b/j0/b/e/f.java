package d.b.j0.b.e;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public abstract class f extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public IOException f63824e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63825f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63826g;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f63825f = true;
    }

    public void n() throws IOException {
        IOException iOException = this.f63824e;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void o() throws IOException {
        if (!this.f63826g) {
            if (this.f63825f) {
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
        this.f63824e = iOException;
        this.f63826g = true;
    }
}

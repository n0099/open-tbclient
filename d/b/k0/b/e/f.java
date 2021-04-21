package d.b.k0.b.e;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public abstract class f extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public IOException f64825e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64826f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64827g;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f64826f = true;
    }

    public void n() throws IOException {
        IOException iOException = this.f64825e;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void o() throws IOException {
        if (!this.f64827g) {
            if (this.f64826f) {
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
        this.f64825e = iOException;
        this.f64827g = true;
    }
}

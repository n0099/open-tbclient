package d.a.p0.b.e;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public abstract class f extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public IOException f67698e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67699f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67700g;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f67699f = true;
    }

    public void n() throws IOException {
        IOException iOException = this.f67698e;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void o() throws IOException {
        if (!this.f67700g) {
            if (this.f67699f) {
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
        this.f67698e = iOException;
        this.f67700g = true;
    }
}

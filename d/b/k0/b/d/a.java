package d.b.k0.b.d;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a extends InputStream {
    public static final String i = a.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public InputStream f64802e;

    /* renamed from: f  reason: collision with root package name */
    public b f64803f;

    /* renamed from: g  reason: collision with root package name */
    public long f64804g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64805h = false;

    public a(InputStream inputStream, b bVar) {
        this.f64802e = inputStream;
        this.f64803f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f64802e.available();
        } catch (IOException e2) {
            this.f64803f.a(e2, this.f64804g);
            throw e2;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f64805h) {
            return;
        }
        this.f64805h = true;
        try {
            try {
                if (this.f64802e.read() == -1) {
                    this.f64803f.onComplete(this.f64804g);
                } else {
                    this.f64803f.b(this.f64804g);
                }
                this.f64802e.close();
            } catch (Exception unused) {
                this.f64802e.close();
            } catch (Throwable th) {
                try {
                    this.f64802e.close();
                } catch (Exception e2) {
                    this.f64803f.a(e2, this.f64804g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f64803f.a(e3, this.f64804g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f64805h) {
            return -1;
        }
        try {
            int read = this.f64802e.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.f64804g += read;
            } else {
                this.f64805h = true;
                this.f64803f.onComplete(this.f64804g);
            }
            return read;
        } catch (IOException e2) {
            this.f64803f.a(e2, this.f64804g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.f64802e.reset();
        } catch (IOException e2) {
            this.f64803f.a(e2, this.f64804g);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f64802e.skip(j);
        this.f64804g += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f64805h) {
            return -1;
        }
        try {
            int read = this.f64802e.read(bArr, i2, i3);
            if (read >= 0) {
                this.f64804g += read;
            } else {
                this.f64805h = true;
                this.f64803f.onComplete(this.f64804g);
            }
            return read;
        } catch (IOException e2) {
            this.f64803f.a(e2, this.f64804g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f64805h) {
            return -1;
        }
        try {
            int read = this.f64802e.read();
            if (read >= 0) {
                this.f64804g += read;
            } else {
                this.f64805h = true;
                this.f64803f.onComplete(this.f64804g);
            }
            return read;
        } catch (IOException e2) {
            this.f64803f.a(e2, this.f64804g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }
}

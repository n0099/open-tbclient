package d.b.j0.b.d;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a extends InputStream {
    public static final String i = a.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public InputStream f64502e;

    /* renamed from: f  reason: collision with root package name */
    public b f64503f;

    /* renamed from: g  reason: collision with root package name */
    public long f64504g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64505h = false;

    public a(InputStream inputStream, b bVar) {
        this.f64502e = inputStream;
        this.f64503f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f64502e.available();
        } catch (IOException e2) {
            this.f64503f.a(e2, this.f64504g);
            throw e2;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f64505h) {
            return;
        }
        this.f64505h = true;
        try {
            try {
                if (this.f64502e.read() == -1) {
                    this.f64503f.onComplete(this.f64504g);
                } else {
                    this.f64503f.b(this.f64504g);
                }
                this.f64502e.close();
            } catch (Exception unused) {
                this.f64502e.close();
            } catch (Throwable th) {
                try {
                    this.f64502e.close();
                } catch (Exception e2) {
                    this.f64503f.a(e2, this.f64504g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f64503f.a(e3, this.f64504g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f64505h) {
            return -1;
        }
        try {
            int read = this.f64502e.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.f64504g += read;
            } else {
                this.f64505h = true;
                this.f64503f.onComplete(this.f64504g);
            }
            return read;
        } catch (IOException e2) {
            this.f64503f.a(e2, this.f64504g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.f64502e.reset();
        } catch (IOException e2) {
            this.f64503f.a(e2, this.f64504g);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f64502e.skip(j);
        this.f64504g += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f64505h) {
            return -1;
        }
        try {
            int read = this.f64502e.read(bArr, i2, i3);
            if (read >= 0) {
                this.f64504g += read;
            } else {
                this.f64505h = true;
                this.f64503f.onComplete(this.f64504g);
            }
            return read;
        } catch (IOException e2) {
            this.f64503f.a(e2, this.f64504g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f64505h) {
            return -1;
        }
        try {
            int read = this.f64502e.read();
            if (read >= 0) {
                this.f64504g += read;
            } else {
                this.f64505h = true;
                this.f64503f.onComplete(this.f64504g);
            }
            return read;
        } catch (IOException e2) {
            this.f64503f.a(e2, this.f64504g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }
}

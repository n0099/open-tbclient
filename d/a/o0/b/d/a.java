package d.a.o0.b.d;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a extends InputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final String f63848i = a.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public InputStream f63849e;

    /* renamed from: f  reason: collision with root package name */
    public b f63850f;

    /* renamed from: g  reason: collision with root package name */
    public long f63851g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63852h = false;

    public a(InputStream inputStream, b bVar) {
        this.f63849e = inputStream;
        this.f63850f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f63849e.available();
        } catch (IOException e2) {
            this.f63850f.b(e2, this.f63851g);
            throw e2;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f63852h) {
            return;
        }
        this.f63852h = true;
        try {
            try {
                if (this.f63849e.read() == -1) {
                    this.f63850f.onComplete(this.f63851g);
                } else {
                    this.f63850f.a(this.f63851g);
                }
                this.f63849e.close();
            } catch (Exception unused) {
                this.f63849e.close();
            } catch (Throwable th) {
                try {
                    this.f63849e.close();
                } catch (Exception e2) {
                    this.f63850f.b(e2, this.f63851g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f63850f.b(e3, this.f63851g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f63852h) {
            return -1;
        }
        try {
            int read = this.f63849e.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.f63851g += read;
            } else {
                this.f63852h = true;
                this.f63850f.onComplete(this.f63851g);
            }
            return read;
        } catch (IOException e2) {
            this.f63850f.b(e2, this.f63851g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63848i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.f63849e.reset();
        } catch (IOException e2) {
            this.f63850f.b(e2, this.f63851g);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f63849e.skip(j);
        this.f63851g += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f63852h) {
            return -1;
        }
        try {
            int read = this.f63849e.read(bArr, i2, i3);
            if (read >= 0) {
                this.f63851g += read;
            } else {
                this.f63852h = true;
                this.f63850f.onComplete(this.f63851g);
            }
            return read;
        } catch (IOException e2) {
            this.f63850f.b(e2, this.f63851g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63848i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f63852h) {
            return -1;
        }
        try {
            int read = this.f63849e.read();
            if (read >= 0) {
                this.f63851g += read;
            } else {
                this.f63852h = true;
                this.f63850f.onComplete(this.f63851g);
            }
            return read;
        } catch (IOException e2) {
            this.f63850f.b(e2, this.f63851g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63848i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }
}

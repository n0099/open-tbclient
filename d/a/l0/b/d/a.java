package d.a.l0.b.d;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a extends InputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final String f63798i = a.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public InputStream f63799e;

    /* renamed from: f  reason: collision with root package name */
    public b f63800f;

    /* renamed from: g  reason: collision with root package name */
    public long f63801g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63802h = false;

    public a(InputStream inputStream, b bVar) {
        this.f63799e = inputStream;
        this.f63800f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f63799e.available();
        } catch (IOException e2) {
            this.f63800f.b(e2, this.f63801g);
            throw e2;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f63802h) {
            return;
        }
        this.f63802h = true;
        try {
            try {
                if (this.f63799e.read() == -1) {
                    this.f63800f.onComplete(this.f63801g);
                } else {
                    this.f63800f.a(this.f63801g);
                }
                this.f63799e.close();
            } catch (Exception unused) {
                this.f63799e.close();
            } catch (Throwable th) {
                try {
                    this.f63799e.close();
                } catch (Exception e2) {
                    this.f63800f.b(e2, this.f63801g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f63800f.b(e3, this.f63801g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f63802h) {
            return -1;
        }
        try {
            int read = this.f63799e.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.f63801g += read;
            } else {
                this.f63802h = true;
                this.f63800f.onComplete(this.f63801g);
            }
            return read;
        } catch (IOException e2) {
            this.f63800f.b(e2, this.f63801g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63798i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.f63799e.reset();
        } catch (IOException e2) {
            this.f63800f.b(e2, this.f63801g);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f63799e.skip(j);
        this.f63801g += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f63802h) {
            return -1;
        }
        try {
            int read = this.f63799e.read(bArr, i2, i3);
            if (read >= 0) {
                this.f63801g += read;
            } else {
                this.f63802h = true;
                this.f63800f.onComplete(this.f63801g);
            }
            return read;
        } catch (IOException e2) {
            this.f63800f.b(e2, this.f63801g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63798i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f63802h) {
            return -1;
        }
        try {
            int read = this.f63799e.read();
            if (read >= 0) {
                this.f63801g += read;
            } else {
                this.f63802h = true;
                this.f63800f.onComplete(this.f63801g);
            }
            return read;
        } catch (IOException e2) {
            this.f63800f.b(e2, this.f63801g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63798i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }
}

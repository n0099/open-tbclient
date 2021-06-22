package d.a.p0.b.d;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a extends InputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final String f67670i = a.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public InputStream f67671e;

    /* renamed from: f  reason: collision with root package name */
    public b f67672f;

    /* renamed from: g  reason: collision with root package name */
    public long f67673g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67674h = false;

    public a(InputStream inputStream, b bVar) {
        this.f67671e = inputStream;
        this.f67672f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f67671e.available();
        } catch (IOException e2) {
            this.f67672f.b(e2, this.f67673g);
            throw e2;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f67674h) {
            return;
        }
        this.f67674h = true;
        try {
            try {
                if (this.f67671e.read() == -1) {
                    this.f67672f.onComplete(this.f67673g);
                } else {
                    this.f67672f.a(this.f67673g);
                }
                this.f67671e.close();
            } catch (Exception unused) {
                this.f67671e.close();
            } catch (Throwable th) {
                try {
                    this.f67671e.close();
                } catch (Exception e2) {
                    this.f67672f.b(e2, this.f67673g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f67672f.b(e3, this.f67673g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f67674h) {
            return -1;
        }
        try {
            int read = this.f67671e.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.f67673g += read;
            } else {
                this.f67674h = true;
                this.f67672f.onComplete(this.f67673g);
            }
            return read;
        } catch (IOException e2) {
            this.f67672f.b(e2, this.f67673g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f67670i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.f67671e.reset();
        } catch (IOException e2) {
            this.f67672f.b(e2, this.f67673g);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f67671e.skip(j);
        this.f67673g += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f67674h) {
            return -1;
        }
        try {
            int read = this.f67671e.read(bArr, i2, i3);
            if (read >= 0) {
                this.f67673g += read;
            } else {
                this.f67674h = true;
                this.f67672f.onComplete(this.f67673g);
            }
            return read;
        } catch (IOException e2) {
            this.f67672f.b(e2, this.f67673g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f67670i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f67674h) {
            return -1;
        }
        try {
            int read = this.f67671e.read();
            if (read >= 0) {
                this.f67673g += read;
            } else {
                this.f67674h = true;
                this.f67672f.onComplete(this.f67673g);
            }
            return read;
        } catch (IOException e2) {
            this.f67672f.b(e2, this.f67673g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f67670i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }
}

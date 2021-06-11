package d.a.o0.b.d;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a extends InputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final String f67566i = a.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public InputStream f67567e;

    /* renamed from: f  reason: collision with root package name */
    public b f67568f;

    /* renamed from: g  reason: collision with root package name */
    public long f67569g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67570h = false;

    public a(InputStream inputStream, b bVar) {
        this.f67567e = inputStream;
        this.f67568f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f67567e.available();
        } catch (IOException e2) {
            this.f67568f.b(e2, this.f67569g);
            throw e2;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f67570h) {
            return;
        }
        this.f67570h = true;
        try {
            try {
                if (this.f67567e.read() == -1) {
                    this.f67568f.onComplete(this.f67569g);
                } else {
                    this.f67568f.a(this.f67569g);
                }
                this.f67567e.close();
            } catch (Exception unused) {
                this.f67567e.close();
            } catch (Throwable th) {
                try {
                    this.f67567e.close();
                } catch (Exception e2) {
                    this.f67568f.b(e2, this.f67569g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f67568f.b(e3, this.f67569g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f67570h) {
            return -1;
        }
        try {
            int read = this.f67567e.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.f67569g += read;
            } else {
                this.f67570h = true;
                this.f67568f.onComplete(this.f67569g);
            }
            return read;
        } catch (IOException e2) {
            this.f67568f.b(e2, this.f67569g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f67566i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.f67567e.reset();
        } catch (IOException e2) {
            this.f67568f.b(e2, this.f67569g);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f67567e.skip(j);
        this.f67569g += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f67570h) {
            return -1;
        }
        try {
            int read = this.f67567e.read(bArr, i2, i3);
            if (read >= 0) {
                this.f67569g += read;
            } else {
                this.f67570h = true;
                this.f67568f.onComplete(this.f67569g);
            }
            return read;
        } catch (IOException e2) {
            this.f67568f.b(e2, this.f67569g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f67566i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f67570h) {
            return -1;
        }
        try {
            int read = this.f67567e.read();
            if (read >= 0) {
                this.f67569g += read;
            } else {
                this.f67570h = true;
                this.f67568f.onComplete(this.f67569g);
            }
            return read;
        } catch (IOException e2) {
            this.f67568f.b(e2, this.f67569g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f67566i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }
}

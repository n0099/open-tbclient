package d.a.k0.b.d;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a extends InputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final String f63094i = a.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public InputStream f63095e;

    /* renamed from: f  reason: collision with root package name */
    public b f63096f;

    /* renamed from: g  reason: collision with root package name */
    public long f63097g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63098h = false;

    public a(InputStream inputStream, b bVar) {
        this.f63095e = inputStream;
        this.f63096f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f63095e.available();
        } catch (IOException e2) {
            this.f63096f.b(e2, this.f63097g);
            throw e2;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f63098h) {
            return;
        }
        this.f63098h = true;
        try {
            try {
                if (this.f63095e.read() == -1) {
                    this.f63096f.onComplete(this.f63097g);
                } else {
                    this.f63096f.a(this.f63097g);
                }
                this.f63095e.close();
            } catch (Exception unused) {
                this.f63095e.close();
            } catch (Throwable th) {
                try {
                    this.f63095e.close();
                } catch (Exception e2) {
                    this.f63096f.b(e2, this.f63097g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f63096f.b(e3, this.f63097g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.f63098h) {
            return -1;
        }
        try {
            int read = this.f63095e.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.f63097g += read;
            } else {
                this.f63098h = true;
                this.f63096f.onComplete(this.f63097g);
            }
            return read;
        } catch (IOException e2) {
            this.f63096f.b(e2, this.f63097g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63094i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.f63095e.reset();
        } catch (IOException e2) {
            this.f63096f.b(e2, this.f63097g);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f63095e.skip(j);
        this.f63097g += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f63098h) {
            return -1;
        }
        try {
            int read = this.f63095e.read(bArr, i2, i3);
            if (read >= 0) {
                this.f63097g += read;
            } else {
                this.f63098h = true;
                this.f63096f.onComplete(this.f63097g);
            }
            return read;
        } catch (IOException e2) {
            this.f63096f.b(e2, this.f63097g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63094i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f63098h) {
            return -1;
        }
        try {
            int read = this.f63095e.read();
            if (read >= 0) {
                this.f63097g += read;
            } else {
                this.f63098h = true;
                this.f63096f.onComplete(this.f63097g);
            }
            return read;
        } catch (IOException e2) {
            this.f63096f.b(e2, this.f63097g);
            throw e2;
        } catch (IllegalStateException e3) {
            Log.e(f63094i, "Exception reading data from InputStream", e3);
            return -1;
        }
    }
}

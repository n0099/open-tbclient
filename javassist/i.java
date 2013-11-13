package javassist;

import java.io.FileOutputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
class i extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private FileOutputStream f2856a = null;
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str) {
        this.b = str;
    }

    private void a() {
        if (this.f2856a == null) {
            this.f2856a = new FileOutputStream(this.b);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        a();
        this.f2856a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        a();
        this.f2856a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        a();
        this.f2856a.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f2856a.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
        this.f2856a.close();
    }
}

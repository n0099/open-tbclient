package d.o.a.e.b.n;

import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.ss.android.socialbase.downloader.exception.BaseException;
import d.o.a.e.b.l.e;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public BufferedOutputStream f66720e;

    /* renamed from: f  reason: collision with root package name */
    public FileDescriptor f66721f;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f66722g;

    public c(File file, int i2) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f66722g = randomAccessFile;
            this.f66721f = randomAccessFile.getFD();
            if (i2 > 0) {
                if (i2 < 8192) {
                    i2 = 8192;
                } else if (i2 > 131072) {
                    i2 = 131072;
                }
                this.f66720e = new BufferedOutputStream(new FileOutputStream(this.f66722g.getFD()), i2);
                return;
            }
            this.f66720e = new BufferedOutputStream(new FileOutputStream(this.f66722g.getFD()));
        } catch (IOException e2) {
            throw new BaseException((int) ScanCodeConstant.B_SAO_C_NORMAL_AUTH_SERVICE_TYPE, e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) throws IOException {
        this.f66720e.write(bArr, i2, i3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        e.C(this.f66722g, this.f66720e);
    }

    public void n() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f66720e;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f66721f;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void o() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f66720e;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void p(long j) throws IOException {
        this.f66722g.setLength(j);
    }

    public void q() throws IOException {
        FileDescriptor fileDescriptor = this.f66721f;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void a(long j) throws IOException {
        this.f66722g.seek(j);
    }
}

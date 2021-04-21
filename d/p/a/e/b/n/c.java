package d.p.a.e.b.n;

import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.ss.android.socialbase.downloader.exception.BaseException;
import d.p.a.e.b.l.e;
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
    public BufferedOutputStream f68344e;

    /* renamed from: f  reason: collision with root package name */
    public FileDescriptor f68345f;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f68346g;

    public c(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f68346g = randomAccessFile;
            this.f68345f = randomAccessFile.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = 131072;
                }
                this.f68344e = new BufferedOutputStream(new FileOutputStream(this.f68346g.getFD()), i);
                return;
            }
            this.f68344e = new BufferedOutputStream(new FileOutputStream(this.f68346g.getFD()));
        } catch (IOException e2) {
            throw new BaseException((int) ScanCodeConstant.B_SAO_C_NORMAL_AUTH_SERVICE_TYPE, e2);
        }
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        this.f68344e.write(bArr, i, i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        e.C(this.f68346g, this.f68344e);
    }

    public void n() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f68344e;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f68345f;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void o() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f68344e;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void p(long j) throws IOException {
        this.f68346g.setLength(j);
    }

    public void q() throws IOException {
        FileDescriptor fileDescriptor = this.f68345f;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void a(long j) throws IOException {
        this.f68346g.seek(j);
    }
}

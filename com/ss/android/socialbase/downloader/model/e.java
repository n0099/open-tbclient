package com.ss.android.socialbase.downloader.model;

import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public class e implements Closeable {
    public BufferedOutputStream a;

    /* renamed from: b  reason: collision with root package name */
    public FileDescriptor f60233b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f60234c;

    public e(File file, int i2) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f60234c = randomAccessFile;
            this.f60233b = randomAccessFile.getFD();
            if (i2 > 0) {
                if (i2 < 8192) {
                    i2 = 8192;
                } else if (i2 > 131072) {
                    i2 = 131072;
                }
                this.a = new BufferedOutputStream(new FileOutputStream(this.f60234c.getFD()), i2);
                return;
            }
            this.a = new BufferedOutputStream(new FileOutputStream(this.f60234c.getFD()));
        } catch (IOException e2) {
            throw new BaseException((int) ScanCodeConstant.B_SAO_C_NORMAL_AUTH_SERVICE_TYPE, e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) throws IOException {
        this.a.write(bArr, i2, i3);
    }

    public void b() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void c() throws IOException {
        FileDescriptor fileDescriptor = this.f60233b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        f.a(this.f60234c, this.a);
    }

    public void a() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f60233b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void b(long j2) throws IOException {
        this.f60234c.setLength(j2);
    }

    public void a(long j2) throws IOException {
        this.f60234c.seek(j2);
    }
}

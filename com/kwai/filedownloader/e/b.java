package com.kwai.filedownloader.e;

import com.kwai.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public class b implements com.kwai.filedownloader.e.a {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedOutputStream f37759a;

    /* renamed from: b  reason: collision with root package name */
    public final FileDescriptor f37760b;

    /* renamed from: c  reason: collision with root package name */
    public final RandomAccessFile f37761c;

    /* loaded from: classes7.dex */
    public static class a implements c.e {
        @Override // com.kwai.filedownloader.f.c.e
        public com.kwai.filedownloader.e.a a(File file) {
            return new b(file);
        }

        @Override // com.kwai.filedownloader.f.c.e
        public boolean a() {
            return true;
        }
    }

    public b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f37761c = randomAccessFile;
        this.f37760b = randomAccessFile.getFD();
        this.f37759a = new BufferedOutputStream(new FileOutputStream(this.f37761c.getFD()));
    }

    @Override // com.kwai.filedownloader.e.a
    public void a() {
        this.f37759a.flush();
        this.f37760b.sync();
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(long j) {
        this.f37761c.seek(j);
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(byte[] bArr, int i2, int i3) {
        this.f37759a.write(bArr, i2, i3);
    }

    @Override // com.kwai.filedownloader.e.a
    public void b() {
        this.f37759a.close();
        this.f37761c.close();
    }

    @Override // com.kwai.filedownloader.e.a
    public void b(long j) {
        this.f37761c.setLength(j);
    }
}

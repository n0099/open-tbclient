package com.kwai.filedownloader.e;

import com.kwai.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class b implements com.kwai.filedownloader.e.a {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedOutputStream f36995a;

    /* renamed from: b  reason: collision with root package name */
    public final FileDescriptor f36996b;

    /* renamed from: c  reason: collision with root package name */
    public final RandomAccessFile f36997c;

    /* loaded from: classes6.dex */
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
        this.f36997c = randomAccessFile;
        this.f36996b = randomAccessFile.getFD();
        this.f36995a = new BufferedOutputStream(new FileOutputStream(this.f36997c.getFD()));
    }

    @Override // com.kwai.filedownloader.e.a
    public void a() {
        this.f36995a.flush();
        this.f36996b.sync();
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(long j) {
        this.f36997c.seek(j);
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(byte[] bArr, int i, int i2) {
        this.f36995a.write(bArr, i, i2);
    }

    @Override // com.kwai.filedownloader.e.a
    public void b() {
        this.f36995a.close();
        this.f36997c.close();
    }

    @Override // com.kwai.filedownloader.e.a
    public void b(long j) {
        this.f36997c.setLength(j);
    }
}

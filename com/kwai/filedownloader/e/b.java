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
    public final BufferedOutputStream f37857a;

    /* renamed from: b  reason: collision with root package name */
    public final FileDescriptor f37858b;

    /* renamed from: c  reason: collision with root package name */
    public final RandomAccessFile f37859c;

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
        this.f37859c = randomAccessFile;
        this.f37858b = randomAccessFile.getFD();
        this.f37857a = new BufferedOutputStream(new FileOutputStream(this.f37859c.getFD()));
    }

    @Override // com.kwai.filedownloader.e.a
    public void a() {
        this.f37857a.flush();
        this.f37858b.sync();
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(long j) {
        this.f37859c.seek(j);
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(byte[] bArr, int i2, int i3) {
        this.f37857a.write(bArr, i2, i3);
    }

    @Override // com.kwai.filedownloader.e.a
    public void b() {
        this.f37857a.close();
        this.f37859c.close();
    }

    @Override // com.kwai.filedownloader.e.a
    public void b(long j) {
        this.f37859c.setLength(j);
    }
}

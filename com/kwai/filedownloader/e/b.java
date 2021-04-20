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
    public final BufferedOutputStream f37284a;

    /* renamed from: b  reason: collision with root package name */
    public final FileDescriptor f37285b;

    /* renamed from: c  reason: collision with root package name */
    public final RandomAccessFile f37286c;

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
        this.f37286c = randomAccessFile;
        this.f37285b = randomAccessFile.getFD();
        this.f37284a = new BufferedOutputStream(new FileOutputStream(this.f37286c.getFD()));
    }

    @Override // com.kwai.filedownloader.e.a
    public void a() {
        this.f37284a.flush();
        this.f37285b.sync();
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(long j) {
        this.f37286c.seek(j);
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(byte[] bArr, int i, int i2) {
        this.f37284a.write(bArr, i, i2);
    }

    @Override // com.kwai.filedownloader.e.a
    public void b() {
        this.f37284a.close();
        this.f37286c.close();
    }

    @Override // com.kwai.filedownloader.e.a
    public void b(long j) {
        this.f37286c.setLength(j);
    }
}

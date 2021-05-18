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
    public final BufferedOutputStream f34346a;

    /* renamed from: b  reason: collision with root package name */
    public final FileDescriptor f34347b;

    /* renamed from: c  reason: collision with root package name */
    public final RandomAccessFile f34348c;

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
        this.f34348c = randomAccessFile;
        this.f34347b = randomAccessFile.getFD();
        this.f34346a = new BufferedOutputStream(new FileOutputStream(this.f34348c.getFD()));
    }

    @Override // com.kwai.filedownloader.e.a
    public void a() {
        this.f34346a.flush();
        this.f34347b.sync();
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(long j) {
        this.f34348c.seek(j);
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(byte[] bArr, int i2, int i3) {
        this.f34346a.write(bArr, i2, i3);
    }

    @Override // com.kwai.filedownloader.e.a
    public void b() {
        this.f34346a.close();
        this.f34348c.close();
    }

    @Override // com.kwai.filedownloader.e.a
    public void b(long j) {
        this.f34348c.setLength(j);
    }
}

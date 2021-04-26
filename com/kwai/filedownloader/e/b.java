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
    public final BufferedOutputStream f35101a;

    /* renamed from: b  reason: collision with root package name */
    public final FileDescriptor f35102b;

    /* renamed from: c  reason: collision with root package name */
    public final RandomAccessFile f35103c;

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
        this.f35103c = randomAccessFile;
        this.f35102b = randomAccessFile.getFD();
        this.f35101a = new BufferedOutputStream(new FileOutputStream(this.f35103c.getFD()));
    }

    @Override // com.kwai.filedownloader.e.a
    public void a() {
        this.f35101a.flush();
        this.f35102b.sync();
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(long j) {
        this.f35103c.seek(j);
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(byte[] bArr, int i2, int i3) {
        this.f35101a.write(bArr, i2, i3);
    }

    @Override // com.kwai.filedownloader.e.a
    public void b() {
        this.f35101a.close();
        this.f35103c.close();
    }

    @Override // com.kwai.filedownloader.e.a
    public void b(long j) {
        this.f35103c.setLength(j);
    }
}

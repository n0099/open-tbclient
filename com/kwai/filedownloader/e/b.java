package com.kwai.filedownloader.e;

import com.kwai.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public class b implements com.kwai.filedownloader.e.a {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedOutputStream f11216a;

    /* renamed from: b  reason: collision with root package name */
    private final FileDescriptor f11217b;
    private final RandomAccessFile c;

    /* loaded from: classes5.dex */
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

    b(File file) {
        this.c = new RandomAccessFile(file, "rw");
        this.f11217b = this.c.getFD();
        this.f11216a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()));
    }

    @Override // com.kwai.filedownloader.e.a
    public void a() {
        this.f11216a.flush();
        this.f11217b.sync();
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(long j) {
        this.c.seek(j);
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(byte[] bArr, int i, int i2) {
        this.f11216a.write(bArr, i, i2);
    }

    @Override // com.kwai.filedownloader.e.a
    public void b() {
        this.f11216a.close();
        this.c.close();
    }

    @Override // com.kwai.filedownloader.e.a
    public void b(long j) {
        this.c.setLength(j);
    }
}

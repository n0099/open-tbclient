package com.ss.android.socialbase.downloader.g;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class f implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private BufferedOutputStream f13160a;

    /* renamed from: b  reason: collision with root package name */
    private FileDescriptor f13161b;
    private RandomAccessFile c;

    public f(File file, int i) throws com.ss.android.socialbase.downloader.e.a {
        try {
            this.c = new RandomAccessFile(file, "rw");
            this.f13161b = this.c.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = 131072;
                }
                this.f13160a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()), i);
                return;
            }
            this.f13160a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()));
        } catch (IOException e) {
            throw new com.ss.android.socialbase.downloader.e.a(1039, e);
        }
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        this.f13160a.write(bArr, i, i2);
    }

    public void a() throws IOException {
        if (this.f13160a != null) {
            this.f13160a.flush();
        }
        if (this.f13161b != null) {
            this.f13161b.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.ss.android.socialbase.downloader.m.d.a(this.c, this.f13160a);
    }

    public void a(long j) throws IOException {
        this.c.seek(j);
    }

    public void b(long j) throws IOException {
        this.c.setLength(j);
    }
}

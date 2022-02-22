package com.kwad.sdk.core.videocache.kwai;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class b implements com.kwad.sdk.core.videocache.a {
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public final a f56516b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f56517c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f56516b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.a = file2;
            this.f56517c = new RandomAccessFile(this.a, exists ? "r" : "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized int a(byte[] bArr, long j2, int i2) {
        try {
            this.f56517c.seek(j2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(a()), Integer.valueOf(bArr.length)), e2);
        }
        return this.f56517c.read(bArr, 0, i2);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized long a() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.a, e2);
        }
        return (int) this.f56517c.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i2) {
        try {
            if (d()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.a + " is completed!");
            }
            this.f56517c.seek(a());
            this.f56517c.write(bArr, 0, i2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.f56517c, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void b() {
        try {
            this.f56517c.close();
            this.f56516b.a(this.a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.a, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.a.getParentFile(), this.a.getName().substring(0, this.a.getName().length() - 9));
        if (!this.a.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.a + " to " + file + " for completion!");
        }
        this.a = file;
        try {
            this.f56517c = new RandomAccessFile(this.a, "r");
            this.f56516b.a(this.a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.a + " as disc cache", e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        return !a(this.a);
    }
}

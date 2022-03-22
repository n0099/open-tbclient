package com.kwad.sdk.core.videocache.kwai;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.videocache.a {
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public final a f39961b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f39962c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f39961b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.a = file2;
            this.f39962c = new RandomAccessFile(this.a, exists ? "r" : "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.f39962c.seek(j);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e2);
        }
        return this.f39962c.read(bArr, 0, i);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized long a() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.a, e2);
        }
        return (int) this.f39962c.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (d()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.a + " is completed!");
            }
            this.f39962c.seek(a());
            this.f39962c.write(bArr, 0, i);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.f39962c, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void b() {
        try {
            this.f39962c.close();
            this.f39961b.a(this.a);
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
            this.f39962c = new RandomAccessFile(this.a, "r");
            this.f39961b.a(this.a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.a + " as disc cache", e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        return !a(this.a);
    }
}

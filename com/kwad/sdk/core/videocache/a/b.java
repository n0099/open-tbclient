package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public class b implements com.kwad.sdk.core.videocache.a {

    /* renamed from: a  reason: collision with root package name */
    public File f9772a;

    /* renamed from: b  reason: collision with root package name */
    private final a f9773b;
    private RandomAccessFile c;

    public b(File file, a aVar) {
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f9773b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            this.f9772a = exists ? file : new File(file.getParentFile(), file.getName() + ".download");
            this.c = new RandomAccessFile(this.f9772a, exists ? "r" : "rw");
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.c.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
        }
        return this.c.read(bArr, 0, i);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized long a() {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.f9772a, e);
        }
        return (int) this.c.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (d()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.f9772a + " is completed!");
            }
            this.c.seek(a());
            this.c.write(bArr, 0, i);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void b() {
        try {
            this.c.close();
            this.f9773b.a(this.f9772a);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.f9772a, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void c() {
        if (!d()) {
            b();
            File file = new File(this.f9772a.getParentFile(), this.f9772a.getName().substring(0, this.f9772a.getName().length() - ".download".length()));
            if (!this.f9772a.renameTo(file)) {
                throw new ProxyCacheException("Error renaming file " + this.f9772a + " to " + file + " for completion!");
            }
            this.f9772a = file;
            try {
                this.c = new RandomAccessFile(this.f9772a, "r");
                this.f9773b.a(this.f9772a);
            } catch (IOException e) {
                throw new ProxyCacheException("Error opening " + this.f9772a + " as disc cache", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        return !a(this.f9772a);
    }
}

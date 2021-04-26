package com.kwad.sdk.core.videocache.a;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.videocache.a {

    /* renamed from: a  reason: collision with root package name */
    public File f33530a;

    /* renamed from: b  reason: collision with root package name */
    public final a f33531b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f33532c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f33531b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.f33530a = file2;
            this.f33532c = new RandomAccessFile(this.f33530a, exists ? r.f7975a : "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized int a(byte[] bArr, long j, int i2) {
        try {
            this.f33532c.seek(j);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e2);
        }
        return this.f33532c.read(bArr, 0, i2);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized long a() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.f33530a, e2);
        }
        return (int) this.f33532c.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i2) {
        try {
            if (d()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.f33530a + " is completed!");
            }
            this.f33532c.seek(a());
            this.f33532c.write(bArr, 0, i2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.f33532c, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void b() {
        try {
            this.f33532c.close();
            this.f33531b.a(this.f33530a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.f33530a, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f33530a.getParentFile(), this.f33530a.getName().substring(0, this.f33530a.getName().length() - 9));
        if (!this.f33530a.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.f33530a + " to " + file + " for completion!");
        }
        this.f33530a = file;
        try {
            this.f33532c = new RandomAccessFile(this.f33530a, r.f7975a);
            this.f33531b.a(this.f33530a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.f33530a + " as disc cache", e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        return !a(this.f33530a);
    }
}

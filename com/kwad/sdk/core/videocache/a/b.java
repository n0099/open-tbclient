package com.kwad.sdk.core.videocache.a;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.videocache.a {

    /* renamed from: a  reason: collision with root package name */
    public File f34894a;

    /* renamed from: b  reason: collision with root package name */
    public final a f34895b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f34896c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f34895b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.f34894a = file2;
            this.f34896c = new RandomAccessFile(this.f34894a, exists ? r.f7715a : "rw");
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
            this.f34896c.seek(j);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e2);
        }
        return this.f34896c.read(bArr, 0, i2);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized long a() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.f34894a, e2);
        }
        return (int) this.f34896c.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i2) {
        try {
            if (d()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.f34894a + " is completed!");
            }
            this.f34896c.seek(a());
            this.f34896c.write(bArr, 0, i2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.f34896c, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void b() {
        try {
            this.f34896c.close();
            this.f34895b.a(this.f34894a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.f34894a, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f34894a.getParentFile(), this.f34894a.getName().substring(0, this.f34894a.getName().length() - 9));
        if (!this.f34894a.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.f34894a + " to " + file + " for completion!");
        }
        this.f34894a = file;
        try {
            this.f34896c = new RandomAccessFile(this.f34894a, r.f7715a);
            this.f34895b.a(this.f34894a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.f34894a + " as disc cache", e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        return !a(this.f34894a);
    }
}

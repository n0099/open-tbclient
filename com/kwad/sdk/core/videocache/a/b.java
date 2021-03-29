package com.kwad.sdk.core.videocache.a;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.videocache.a {

    /* renamed from: a  reason: collision with root package name */
    public File f34156a;

    /* renamed from: b  reason: collision with root package name */
    public final a f34157b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f34158c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f34157b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.f34156a = file2;
            this.f34158c = new RandomAccessFile(this.f34156a, exists ? r.f7664a : "rw");
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
            this.f34158c.seek(j);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e2);
        }
        return this.f34158c.read(bArr, 0, i);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized long a() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.f34156a, e2);
        }
        return (int) this.f34158c.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (d()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.f34156a + " is completed!");
            }
            this.f34158c.seek(a());
            this.f34158c.write(bArr, 0, i);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.f34158c, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void b() {
        try {
            this.f34158c.close();
            this.f34157b.a(this.f34156a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.f34156a, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f34156a.getParentFile(), this.f34156a.getName().substring(0, this.f34156a.getName().length() - 9));
        if (!this.f34156a.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.f34156a + " to " + file + " for completion!");
        }
        this.f34156a = file;
        try {
            this.f34158c = new RandomAccessFile(this.f34156a, r.f7664a);
            this.f34157b.a(this.f34156a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.f34156a + " as disc cache", e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        return !a(this.f34156a);
    }
}

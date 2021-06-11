package com.kwad.sdk.core.videocache.a;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public class b implements com.kwad.sdk.core.videocache.a {

    /* renamed from: a  reason: collision with root package name */
    public File f34796a;

    /* renamed from: b  reason: collision with root package name */
    public final a f34797b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f34798c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f34797b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.f34796a = file2;
            this.f34798c = new RandomAccessFile(this.f34796a, exists ? r.f7715a : "rw");
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
            this.f34798c.seek(j);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e2);
        }
        return this.f34798c.read(bArr, 0, i2);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized long a() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.f34796a, e2);
        }
        return (int) this.f34798c.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i2) {
        try {
            if (d()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.f34796a + " is completed!");
            }
            this.f34798c.seek(a());
            this.f34798c.write(bArr, 0, i2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.f34798c, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void b() {
        try {
            this.f34798c.close();
            this.f34797b.a(this.f34796a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.f34796a, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f34796a.getParentFile(), this.f34796a.getName().substring(0, this.f34796a.getName().length() - 9));
        if (!this.f34796a.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.f34796a + " to " + file + " for completion!");
        }
        this.f34796a = file;
        try {
            this.f34798c = new RandomAccessFile(this.f34796a, r.f7715a);
            this.f34797b.a(this.f34796a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.f34796a + " as disc cache", e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        return !a(this.f34796a);
    }
}

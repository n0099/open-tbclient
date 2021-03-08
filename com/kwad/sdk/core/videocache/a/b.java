package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.videocache.a {

    /* renamed from: a  reason: collision with root package name */
    public File f6283a;
    private final a b;
    private RandomAccessFile c;

    public b(File file, a aVar) {
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            this.f6283a = exists ? file : new File(file.getParentFile(), file.getName() + ".download");
            this.c = new RandomAccessFile(this.f6283a, exists ? "r" : VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
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
            throw new ProxyCacheException("Error reading length of file " + this.f6283a, e);
        }
        return (int) this.c.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (d()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.f6283a + " is completed!");
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
            this.b.a(this.f6283a);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.f6283a, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized void c() {
        if (!d()) {
            b();
            File file = new File(this.f6283a.getParentFile(), this.f6283a.getName().substring(0, this.f6283a.getName().length() - ".download".length()));
            if (!this.f6283a.renameTo(file)) {
                throw new ProxyCacheException("Error renaming file " + this.f6283a + " to " + file + " for completion!");
            }
            this.f6283a = file;
            try {
                this.c = new RandomAccessFile(this.f6283a, "r");
                this.b.a(this.f6283a);
            } catch (IOException e) {
                throw new ProxyCacheException("Error opening " + this.f6283a + " as disc cache", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public synchronized boolean d() {
        return !a(this.f6283a);
    }
}

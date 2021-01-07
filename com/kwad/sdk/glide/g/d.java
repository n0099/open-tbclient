package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* loaded from: classes5.dex */
public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<d> f10318a = k.a(0);

    /* renamed from: b  reason: collision with root package name */
    private InputStream f10319b;
    private IOException c;

    d() {
    }

    @NonNull
    public static d a(@NonNull InputStream inputStream) {
        d poll;
        synchronized (f10318a) {
            poll = f10318a.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.b(inputStream);
        return poll;
    }

    @Nullable
    public IOException a() {
        return this.c;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f10319b.available();
    }

    public void b() {
        this.c = null;
        this.f10319b = null;
        synchronized (f10318a) {
            f10318a.offer(this);
        }
    }

    void b(@NonNull InputStream inputStream) {
        this.f10319b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10319b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f10319b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f10319b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f10319b.read();
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f10319b.read(bArr);
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f10319b.read(bArr, i, i2);
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f10319b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f10319b.skip(j);
        } catch (IOException e) {
            this.c = e;
            return 0L;
        }
    }
}

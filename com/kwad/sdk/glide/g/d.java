package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* loaded from: classes7.dex */
public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final Queue<d> f35897a = k.a(0);

    /* renamed from: b  reason: collision with root package name */
    public InputStream f35898b;

    /* renamed from: c  reason: collision with root package name */
    public IOException f35899c;

    @NonNull
    public static d a(@NonNull InputStream inputStream) {
        d poll;
        synchronized (f35897a) {
            poll = f35897a.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.b(inputStream);
        return poll;
    }

    @Nullable
    public IOException a() {
        return this.f35899c;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f35898b.available();
    }

    public void b() {
        this.f35899c = null;
        this.f35898b = null;
        synchronized (f35897a) {
            f35897a.offer(this);
        }
    }

    public void b(@NonNull InputStream inputStream) {
        this.f35898b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f35898b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f35898b.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f35898b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f35898b.read();
        } catch (IOException e2) {
            this.f35899c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f35898b.read(bArr);
        } catch (IOException e2) {
            this.f35899c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f35898b.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f35899c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f35898b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f35898b.skip(j);
        } catch (IOException e2) {
            this.f35899c = e2;
            return 0L;
        }
    }
}

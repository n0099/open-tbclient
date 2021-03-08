package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* loaded from: classes3.dex */
public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<d> f6630a = k.a(0);
    private InputStream b;
    private IOException c;

    d() {
    }

    @NonNull
    public static d a(@NonNull InputStream inputStream) {
        d poll;
        synchronized (f6630a) {
            poll = f6630a.poll();
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
        return this.b.available();
    }

    public void b() {
        this.c = null;
        this.b = null;
        synchronized (f6630a) {
            f6630a.offer(this);
        }
    }

    void b(@NonNull InputStream inputStream) {
        this.b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.b.read();
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.b.read(bArr);
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.b.read(bArr, i, i2);
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.b.skip(j);
        } catch (IOException e) {
            this.c = e;
            return 0L;
        }
    }
}

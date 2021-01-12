package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* loaded from: classes4.dex */
public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<d> f10018a = k.a(0);

    /* renamed from: b  reason: collision with root package name */
    private InputStream f10019b;
    private IOException c;

    d() {
    }

    @NonNull
    public static d a(@NonNull InputStream inputStream) {
        d poll;
        synchronized (f10018a) {
            poll = f10018a.poll();
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
        return this.f10019b.available();
    }

    public void b() {
        this.c = null;
        this.f10019b = null;
        synchronized (f10018a) {
            f10018a.offer(this);
        }
    }

    void b(@NonNull InputStream inputStream) {
        this.f10019b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10019b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f10019b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f10019b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f10019b.read();
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f10019b.read(bArr);
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f10019b.read(bArr, i, i2);
        } catch (IOException e) {
            this.c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f10019b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f10019b.skip(j);
        } catch (IOException e) {
            this.c = e;
            return 0L;
        }
    }
}

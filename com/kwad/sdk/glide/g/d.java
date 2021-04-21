package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* loaded from: classes6.dex */
public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final Queue<d> f35598a = k.a(0);

    /* renamed from: b  reason: collision with root package name */
    public InputStream f35599b;

    /* renamed from: c  reason: collision with root package name */
    public IOException f35600c;

    @NonNull
    public static d a(@NonNull InputStream inputStream) {
        d poll;
        synchronized (f35598a) {
            poll = f35598a.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.b(inputStream);
        return poll;
    }

    @Nullable
    public IOException a() {
        return this.f35600c;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f35599b.available();
    }

    public void b() {
        this.f35600c = null;
        this.f35599b = null;
        synchronized (f35598a) {
            f35598a.offer(this);
        }
    }

    public void b(@NonNull InputStream inputStream) {
        this.f35599b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f35599b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f35599b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f35599b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f35599b.read();
        } catch (IOException e2) {
            this.f35600c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f35599b.read(bArr);
        } catch (IOException e2) {
            this.f35600c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f35599b.read(bArr, i, i2);
        } catch (IOException e2) {
            this.f35600c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f35599b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f35599b.skip(j);
        } catch (IOException e2) {
            this.f35600c = e2;
            return 0L;
        }
    }
}

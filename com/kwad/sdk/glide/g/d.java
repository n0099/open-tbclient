package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* loaded from: classes7.dex */
public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final Queue<d> f35995a = k.a(0);

    /* renamed from: b  reason: collision with root package name */
    public InputStream f35996b;

    /* renamed from: c  reason: collision with root package name */
    public IOException f35997c;

    @NonNull
    public static d a(@NonNull InputStream inputStream) {
        d poll;
        synchronized (f35995a) {
            poll = f35995a.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.b(inputStream);
        return poll;
    }

    @Nullable
    public IOException a() {
        return this.f35997c;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f35996b.available();
    }

    public void b() {
        this.f35997c = null;
        this.f35996b = null;
        synchronized (f35995a) {
            f35995a.offer(this);
        }
    }

    public void b(@NonNull InputStream inputStream) {
        this.f35996b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f35996b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f35996b.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f35996b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f35996b.read();
        } catch (IOException e2) {
            this.f35997c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f35996b.read(bArr);
        } catch (IOException e2) {
            this.f35997c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f35996b.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f35997c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f35996b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f35996b.skip(j);
        } catch (IOException e2) {
            this.f35997c = e2;
            return 0L;
        }
    }
}

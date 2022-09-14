package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class a implements Closeable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public int ajp;
    public boolean ajq;
    public long ajr;
    public byte[] buf;
    public boolean eof;
    public int offset;
    public InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i) {
        this.eof = false;
        this.ajq = true;
        this.ajr = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    private int a(f fVar, int i) {
        xS();
        if (i <= 0 || i >= this.ajp) {
            i = this.ajp;
        }
        if (i <= 0) {
            if (!this.eof) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException("This should not happen"));
            }
            return fVar.isDone() ? -1 : 0;
        }
        int b = fVar.b(this.buf, this.offset, i);
        if (b > 0) {
            this.offset += b;
            this.ajp -= b;
        }
        if (b > 0) {
            return b;
        }
        if (!fVar.isDone()) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("This should not happen!"));
        }
        return -1;
    }

    private void xS() {
        if (this.ajp > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int read = this.stream.read(this.buf);
            this.ajp = read;
            if (read == 0) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.ajr += read;
            }
        } catch (IOException e) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException(e));
        }
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public final void aV(boolean z) {
        this.ajq = z;
    }

    public final int b(f fVar, int i) {
        int i2 = 36;
        while (i2 > 0) {
            int a = a(fVar, i2);
            if (a <= 0) {
                return a;
            }
            i2 -= a;
        }
        return 36;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.ajp = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.ajq) {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
        this.stream = null;
    }
}

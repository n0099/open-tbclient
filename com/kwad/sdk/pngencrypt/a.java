package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class a implements Closeable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public int aIf;
    public boolean aIg;
    public long aIh;
    public byte[] buf;
    public boolean eof;
    public int offset;
    public InputStream stream;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.aIf = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.aIg) {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
        this.stream = null;
    }

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public final void bC(boolean z) {
        this.aIg = z;
    }

    public a(InputStream inputStream, int i) {
        this.eof = false;
        this.aIg = true;
        this.aIh = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
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

    private void HV() {
        if (this.aIf <= 0 && !this.eof) {
            try {
                this.offset = 0;
                int read = this.stream.read(this.buf);
                this.aIf = read;
                if (read == 0) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen: stream.read(buf) returned 0"));
                } else if (read < 0) {
                    close();
                } else {
                    this.aIh += read;
                }
            } catch (IOException e) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(e));
            }
        }
    }

    private int a(f fVar, int i) {
        HV();
        if (i <= 0 || i >= this.aIf) {
            i = this.aIf;
        }
        if (i > 0) {
            int b = fVar.b(this.buf, this.offset, i);
            if (b > 0) {
                this.offset += b;
                this.aIf -= b;
            }
            if (b > 0) {
                return b;
            }
            if (!fVar.isDone()) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen!"));
            }
            return -1;
        }
        if (!this.eof) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen"));
        }
        if (fVar.isDone()) {
            return -1;
        }
        return 0;
    }
}

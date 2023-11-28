package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class o implements Closeable {
    public ErrorBehaviour aIz = ErrorBehaviour.STRICT;
    public final boolean aJV;
    public final c aJW;
    public final a aJX;
    public final w aJY;
    public int aJZ;
    public final k aJz;
    public i<? extends Object> aKa;

    public o(InputStream inputStream, boolean z) {
        this.aJZ = -1;
        a aVar = new a(inputStream);
        this.aJX = aVar;
        boolean z2 = true;
        aVar.bC(true);
        c IG = IG();
        this.aJW = IG;
        try {
            if (this.aJX.b(IG, 36) != 36) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.aJz = this.aJW.Ig();
            if (this.aJW.Ih() == null) {
                z2 = false;
            }
            this.aJV = z2;
            au(5024024L);
            as(901001001L);
            at(2024024L);
            this.aJY = new w(this.aJW.aIF);
            a(m.Iz());
            this.aJZ = -1;
        } catch (RuntimeException e) {
            this.aJX.close();
            this.aJW.close();
            throw e;
        }
    }

    private void IC() {
        while (true) {
            c cVar = this.aJW;
            if (cVar.aIE < 4) {
                if (this.aJX.a(cVar) <= 0) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Premature ending reading first chunks"));
                }
            } else {
                return;
            }
        }
    }

    private void IF() {
        this.aJW.bE(false);
    }

    public static c IG() {
        return new c(false);
    }

    public final w ID() {
        if (this.aJW.Ie()) {
            IC();
        }
        return this.aJY;
    }

    public final void IE() {
        IF();
        if (this.aJW.Ie()) {
            IC();
        }
        end();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aJW);
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aJX);
    }

    public final String toString() {
        return this.aJz.toString() + " interlaced=" + this.aJV;
    }

    private void a(i<? extends Object> iVar) {
        this.aKa = iVar;
    }

    private void as(long j) {
        this.aJW.as(901001001L);
    }

    private void at(long j) {
        this.aJW.at(2024024L);
    }

    private void au(long j) {
        this.aJW.au(5024024L);
    }

    public final void end() {
        try {
            if (this.aJW.Ie()) {
                IC();
            }
            if (this.aJW.If() != null && !this.aJW.If().isDone()) {
                this.aJW.If().Im();
            }
            while (!this.aJW.isDone() && this.aJX.a(this.aJW) > 0) {
            }
        } finally {
            close();
        }
    }
}

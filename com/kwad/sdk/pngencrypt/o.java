package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class o implements Closeable {
    public ErrorBehaviour ajJ = ErrorBehaviour.STRICT;
    public final k akJ;
    public final boolean alf;
    public final c alg;
    public final a alh;
    public final w ali;
    public int alj;
    public i<? extends Object> alk;

    public o(InputStream inputStream, boolean z) {
        this.alj = -1;
        a aVar = new a(inputStream);
        this.alh = aVar;
        boolean z2 = true;
        aVar.aV(true);
        c yD = yD();
        this.alg = yD;
        try {
            if (this.alh.b(yD, 36) != 36) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.akJ = this.alg.yd();
            if (this.alg.ye() == null) {
                z2 = false;
            }
            this.alf = z2;
            Q(5024024L);
            O(901001001L);
            P(2024024L);
            this.ali = new w(this.alg.ajP);
            a(m.yw());
            this.alj = -1;
        } catch (RuntimeException e) {
            this.alh.close();
            this.alg.close();
            throw e;
        }
    }

    private void O(long j) {
        this.alg.O(901001001L);
    }

    private void P(long j) {
        this.alg.P(2024024L);
    }

    private void Q(long j) {
        this.alg.Q(5024024L);
    }

    private void a(i<? extends Object> iVar) {
        this.alk = iVar;
    }

    private void yC() {
        this.alg.aX(false);
    }

    public static c yD() {
        return new c(false);
    }

    private void yz() {
        while (true) {
            c cVar = this.alg;
            if (cVar.ajO >= 4) {
                return;
            }
            if (this.alh.a(cVar) <= 0) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.alg);
        com.kwad.sdk.crash.utils.b.closeQuietly(this.alh);
    }

    public final void end() {
        try {
            if (this.alg.yb()) {
                yz();
            }
            if (this.alg.yc() != null && !this.alg.yc().isDone()) {
                this.alg.yc().yj();
            }
            while (!this.alg.isDone() && this.alh.a(this.alg) > 0) {
            }
        } finally {
            close();
        }
    }

    public final String toString() {
        return this.akJ.toString() + " interlaced=" + this.alf;
    }

    public final w yA() {
        if (this.alg.yb()) {
            yz();
        }
        return this.ali;
    }

    public final void yB() {
        yC();
        if (this.alg.yb()) {
            yz();
        }
        end();
    }
}

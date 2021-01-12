package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class d {
    private static d pvR;
    private int pvS;
    @Nullable
    private List<c.a> pvT;
    private final c.a pvU = new a();

    private d() {
        etb();
    }

    public void gL(@Nullable List<c.a> list) {
        this.pvT = list;
        etb();
    }

    public c w(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pvS];
        int a2 = a(this.pvS, inputStream, bArr);
        c p = this.pvU.p(bArr, a2);
        if (p == null || p == c.pvP) {
            if (this.pvT != null) {
                for (c.a aVar : this.pvT) {
                    c p2 = aVar.p(bArr, a2);
                    if (p2 != null && p2 != c.pvP) {
                        return p2;
                    }
                }
            }
            return c.pvP;
        }
        return p;
    }

    private void etb() {
        this.pvS = this.pvU.getHeaderSize();
        if (this.pvT != null) {
            for (c.a aVar : this.pvT) {
                this.pvS = Math.max(this.pvS, aVar.getHeaderSize());
            }
        }
    }

    private static int a(int i, InputStream inputStream, byte[] bArr) throws IOException {
        g.checkNotNull(inputStream);
        g.checkNotNull(bArr);
        g.checkArgument(bArr.length >= i);
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i);
                return com.facebook.common.internal.a.a(inputStream, bArr, 0, i);
            } finally {
                inputStream.reset();
            }
        }
        return com.facebook.common.internal.a.a(inputStream, bArr, 0, i);
    }

    public static synchronized d etc() {
        d dVar;
        synchronized (d.class) {
            if (pvR == null) {
                pvR = new d();
            }
            dVar = pvR;
        }
        return dVar;
    }

    public static c x(InputStream inputStream) throws IOException {
        return etc().w(inputStream);
    }

    public static c y(InputStream inputStream) {
        try {
            return x(inputStream);
        } catch (IOException e) {
            throw l.t(e);
        }
    }
}

package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private static d nRR;
    private int nRS;
    @Nullable
    private List<c.a> nRT;
    private final c.a nRU = new a();

    private d() {
        dZm();
    }

    public void fU(@Nullable List<c.a> list) {
        this.nRT = list;
        dZm();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.nRS];
        int a2 = a(this.nRS, inputStream, bArr);
        c p = this.nRU.p(bArr, a2);
        if (p == null || p == c.nRP) {
            if (this.nRT != null) {
                for (c.a aVar : this.nRT) {
                    c p2 = aVar.p(bArr, a2);
                    if (p2 != null && p2 != c.nRP) {
                        return p2;
                    }
                }
            }
            return c.nRP;
        }
        return p;
    }

    private void dZm() {
        this.nRS = this.nRU.getHeaderSize();
        if (this.nRT != null) {
            for (c.a aVar : this.nRT) {
                this.nRS = Math.max(this.nRS, aVar.getHeaderSize());
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

    public static synchronized d dZn() {
        d dVar;
        synchronized (d.class) {
            if (nRR == null) {
                nRR = new d();
            }
            dVar = nRR;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return dZn().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

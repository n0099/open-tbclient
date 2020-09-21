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
    private static d nCy;
    @Nullable
    private List<c.a> nCA;
    private final c.a nCB = new a();
    private int nCz;

    private d() {
        dVB();
    }

    public void fR(@Nullable List<c.a> list) {
        this.nCA = list;
        dVB();
    }

    public c r(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.nCz];
        int a = a(this.nCz, inputStream, bArr);
        c n = this.nCB.n(bArr, a);
        if (n == null || n == c.nCw) {
            if (this.nCA != null) {
                for (c.a aVar : this.nCA) {
                    c n2 = aVar.n(bArr, a);
                    if (n2 != null && n2 != c.nCw) {
                        return n2;
                    }
                }
            }
            return c.nCw;
        }
        return n;
    }

    private void dVB() {
        this.nCz = this.nCB.getHeaderSize();
        if (this.nCA != null) {
            for (c.a aVar : this.nCA) {
                this.nCz = Math.max(this.nCz, aVar.getHeaderSize());
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

    public static synchronized d dVC() {
        d dVar;
        synchronized (d.class) {
            if (nCy == null) {
                nCy = new d();
            }
            dVar = nCy;
        }
        return dVar;
    }

    public static c s(InputStream inputStream) throws IOException {
        return dVC().r(inputStream);
    }

    public static c t(InputStream inputStream) {
        try {
            return s(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

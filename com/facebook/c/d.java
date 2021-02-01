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
    private static d pGa;
    private int pGb;
    @Nullable
    private List<c.a> pGc;
    private final c.a pGd = new a();

    private d() {
        evt();
    }

    public void gJ(@Nullable List<c.a> list) {
        this.pGc = list;
        evt();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pGb];
        int a2 = a(this.pGb, inputStream, bArr);
        c o = this.pGd.o(bArr, a2);
        if (o == null || o == c.pFY) {
            if (this.pGc != null) {
                for (c.a aVar : this.pGc) {
                    c o2 = aVar.o(bArr, a2);
                    if (o2 != null && o2 != c.pFY) {
                        return o2;
                    }
                }
            }
            return c.pFY;
        }
        return o;
    }

    private void evt() {
        this.pGb = this.pGd.getHeaderSize();
        if (this.pGc != null) {
            for (c.a aVar : this.pGc) {
                this.pGb = Math.max(this.pGb, aVar.getHeaderSize());
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

    public static synchronized d evu() {
        d dVar;
        synchronized (d.class) {
            if (pGa == null) {
                pGa = new d();
            }
            dVar = pGa;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return evu().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.s(e);
        }
    }
}

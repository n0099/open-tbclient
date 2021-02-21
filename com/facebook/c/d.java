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
    private static d pGA;
    private int pGB;
    @Nullable
    private List<c.a> pGC;
    private final c.a pGD = new a();

    private d() {
        evB();
    }

    public void gJ(@Nullable List<c.a> list) {
        this.pGC = list;
        evB();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pGB];
        int a2 = a(this.pGB, inputStream, bArr);
        c o = this.pGD.o(bArr, a2);
        if (o == null || o == c.pGy) {
            if (this.pGC != null) {
                for (c.a aVar : this.pGC) {
                    c o2 = aVar.o(bArr, a2);
                    if (o2 != null && o2 != c.pGy) {
                        return o2;
                    }
                }
            }
            return c.pGy;
        }
        return o;
    }

    private void evB() {
        this.pGB = this.pGD.getHeaderSize();
        if (this.pGC != null) {
            for (c.a aVar : this.pGC) {
                this.pGB = Math.max(this.pGB, aVar.getHeaderSize());
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

    public static synchronized d evC() {
        d dVar;
        synchronized (d.class) {
            if (pGA == null) {
                pGA = new d();
            }
            dVar = pGA;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return evC().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.s(e);
        }
    }
}

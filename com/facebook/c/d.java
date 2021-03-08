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
    private static d pIF;
    private int pIG;
    @Nullable
    private List<c.a> pIH;
    private final c.a pII = new a();

    private d() {
        evK();
    }

    public void gJ(@Nullable List<c.a> list) {
        this.pIH = list;
        evK();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pIG];
        int a2 = a(this.pIG, inputStream, bArr);
        c o = this.pII.o(bArr, a2);
        if (o == null || o == c.pID) {
            if (this.pIH != null) {
                for (c.a aVar : this.pIH) {
                    c o2 = aVar.o(bArr, a2);
                    if (o2 != null && o2 != c.pID) {
                        return o2;
                    }
                }
            }
            return c.pID;
        }
        return o;
    }

    private void evK() {
        this.pIG = this.pII.getHeaderSize();
        if (this.pIH != null) {
            for (c.a aVar : this.pIH) {
                this.pIG = Math.max(this.pIG, aVar.getHeaderSize());
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

    public static synchronized d evL() {
        d dVar;
        synchronized (d.class) {
            if (pIF == null) {
                pIF = new d();
            }
            dVar = pIF;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return evL().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.s(e);
        }
    }
}

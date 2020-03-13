package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private static d lPN;
    private int lPO;
    @Nullable
    private List<c.a> lPP;
    private final c.a lPQ = new a();

    private d() {
        dnE();
    }

    public void eT(@Nullable List<c.a> list) {
        this.lPP = list;
        dnE();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lPO];
        int a = a(this.lPO, inputStream, bArr);
        c r = this.lPQ.r(bArr, a);
        if (r == null || r == c.lPL) {
            if (this.lPP != null) {
                for (c.a aVar : this.lPP) {
                    c r2 = aVar.r(bArr, a);
                    if (r2 != null && r2 != c.lPL) {
                        return r2;
                    }
                }
            }
            return c.lPL;
        }
        return r;
    }

    private void dnE() {
        this.lPO = this.lPQ.getHeaderSize();
        if (this.lPP != null) {
            for (c.a aVar : this.lPP) {
                this.lPO = Math.max(this.lPO, aVar.getHeaderSize());
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

    public static synchronized d dnF() {
        d dVar;
        synchronized (d.class) {
            if (lPN == null) {
                lPN = new d();
            }
            dVar = lPN;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return dnF().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.t(e);
        }
    }
}

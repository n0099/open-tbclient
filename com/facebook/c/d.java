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
    private static d lPC;
    private int lPD;
    @Nullable
    private List<c.a> lPE;
    private final c.a lPF = new a();

    private d() {
        dnD();
    }

    public void eT(@Nullable List<c.a> list) {
        this.lPE = list;
        dnD();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lPD];
        int a = a(this.lPD, inputStream, bArr);
        c r = this.lPF.r(bArr, a);
        if (r == null || r == c.lPA) {
            if (this.lPE != null) {
                for (c.a aVar : this.lPE) {
                    c r2 = aVar.r(bArr, a);
                    if (r2 != null && r2 != c.lPA) {
                        return r2;
                    }
                }
            }
            return c.lPA;
        }
        return r;
    }

    private void dnD() {
        this.lPD = this.lPF.getHeaderSize();
        if (this.lPE != null) {
            for (c.a aVar : this.lPE) {
                this.lPD = Math.max(this.lPD, aVar.getHeaderSize());
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

    public static synchronized d dnE() {
        d dVar;
        synchronized (d.class) {
            if (lPC == null) {
                lPC = new d();
            }
            dVar = lPC;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return dnE().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.t(e);
        }
    }
}

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
    private static d lPA;
    private int lPB;
    @Nullable
    private List<c.a> lPC;
    private final c.a lPD = new a();

    private d() {
        dnB();
    }

    public void eT(@Nullable List<c.a> list) {
        this.lPC = list;
        dnB();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lPB];
        int a = a(this.lPB, inputStream, bArr);
        c r = this.lPD.r(bArr, a);
        if (r == null || r == c.lPy) {
            if (this.lPC != null) {
                for (c.a aVar : this.lPC) {
                    c r2 = aVar.r(bArr, a);
                    if (r2 != null && r2 != c.lPy) {
                        return r2;
                    }
                }
            }
            return c.lPy;
        }
        return r;
    }

    private void dnB() {
        this.lPB = this.lPD.getHeaderSize();
        if (this.lPC != null) {
            for (c.a aVar : this.lPC) {
                this.lPB = Math.max(this.lPB, aVar.getHeaderSize());
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

    public static synchronized d dnC() {
        d dVar;
        synchronized (d.class) {
            if (lPA == null) {
                lPA = new d();
            }
            dVar = lPA;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return dnC().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.t(e);
        }
    }
}

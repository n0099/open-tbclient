package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class d {
    private static d pjg;
    private int pjh;
    @Nullable
    private List<c.a> pji;
    private final c.a pjj = new a();

    private d() {
        esJ();
    }

    public void gO(@Nullable List<c.a> list) {
        this.pji = list;
        esJ();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pjh];
        int a2 = a(this.pjh, inputStream, bArr);
        c q = this.pjj.q(bArr, a2);
        if (q == null || q == c.pje) {
            if (this.pji != null) {
                for (c.a aVar : this.pji) {
                    c q2 = aVar.q(bArr, a2);
                    if (q2 != null && q2 != c.pje) {
                        return q2;
                    }
                }
            }
            return c.pje;
        }
        return q;
    }

    private void esJ() {
        this.pjh = this.pjj.getHeaderSize();
        if (this.pji != null) {
            for (c.a aVar : this.pji) {
                this.pjh = Math.max(this.pjh, aVar.getHeaderSize());
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

    public static synchronized d esK() {
        d dVar;
        synchronized (d.class) {
            if (pjg == null) {
                pjg = new d();
            }
            dVar = pjg;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return esK().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

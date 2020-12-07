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
    private static d pje;
    private int pjf;
    @Nullable
    private List<c.a> pjg;
    private final c.a pjh = new a();

    private d() {
        esI();
    }

    public void gO(@Nullable List<c.a> list) {
        this.pjg = list;
        esI();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pjf];
        int a2 = a(this.pjf, inputStream, bArr);
        c q = this.pjh.q(bArr, a2);
        if (q == null || q == c.pjc) {
            if (this.pjg != null) {
                for (c.a aVar : this.pjg) {
                    c q2 = aVar.q(bArr, a2);
                    if (q2 != null && q2 != c.pjc) {
                        return q2;
                    }
                }
            }
            return c.pjc;
        }
        return q;
    }

    private void esI() {
        this.pjf = this.pjh.getHeaderSize();
        if (this.pjg != null) {
            for (c.a aVar : this.pjg) {
                this.pjf = Math.max(this.pjf, aVar.getHeaderSize());
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

    public static synchronized d esJ() {
        d dVar;
        synchronized (d.class) {
            if (pje == null) {
                pje = new d();
            }
            dVar = pje;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return esJ().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

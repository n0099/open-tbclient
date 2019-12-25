package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class d {
    private static d lLd;
    private int lLe;
    @Nullable
    private List<c.a> lLf;
    private final c.a lLg = new a();

    private d() {
        dlh();
    }

    public void eY(@Nullable List<c.a> list) {
        this.lLf = list;
        dlh();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lLe];
        int a = a(this.lLe, inputStream, bArr);
        c p = this.lLg.p(bArr, a);
        if (p == null || p == c.lLb) {
            if (this.lLf != null) {
                for (c.a aVar : this.lLf) {
                    c p2 = aVar.p(bArr, a);
                    if (p2 != null && p2 != c.lLb) {
                        return p2;
                    }
                }
            }
            return c.lLb;
        }
        return p;
    }

    private void dlh() {
        this.lLe = this.lLg.getHeaderSize();
        if (this.lLf != null) {
            for (c.a aVar : this.lLf) {
                this.lLe = Math.max(this.lLe, aVar.getHeaderSize());
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

    public static synchronized d dli() {
        d dVar;
        synchronized (d.class) {
            if (lLd == null) {
                lLd = new d();
            }
            dVar = lLd;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return dli().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.u(e);
        }
    }
}

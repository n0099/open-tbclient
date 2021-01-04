package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class d {
    private static d pzh;
    private int pzi;
    @Nullable
    private List<c.a> pzj;
    private final c.a pzk = new a();

    private d() {
        ewy();
    }

    public void gL(@Nullable List<c.a> list) {
        this.pzj = list;
        ewy();
    }

    public c w(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pzi];
        int a2 = a(this.pzi, inputStream, bArr);
        c p = this.pzk.p(bArr, a2);
        if (p == null || p == c.pzf) {
            if (this.pzj != null) {
                for (c.a aVar : this.pzj) {
                    c p2 = aVar.p(bArr, a2);
                    if (p2 != null && p2 != c.pzf) {
                        return p2;
                    }
                }
            }
            return c.pzf;
        }
        return p;
    }

    private void ewy() {
        this.pzi = this.pzk.getHeaderSize();
        if (this.pzj != null) {
            for (c.a aVar : this.pzj) {
                this.pzi = Math.max(this.pzi, aVar.getHeaderSize());
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

    public static synchronized d ewz() {
        d dVar;
        synchronized (d.class) {
            if (pzh == null) {
                pzh = new d();
            }
            dVar = pzh;
        }
        return dVar;
    }

    public static c x(InputStream inputStream) throws IOException {
        return ewz().w(inputStream);
    }

    public static c y(InputStream inputStream) {
        try {
            return x(inputStream);
        } catch (IOException e) {
            throw l.t(e);
        }
    }
}

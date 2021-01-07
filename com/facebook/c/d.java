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
    private static d pAs;
    private int pAt;
    @Nullable
    private List<c.a> pAu;
    private final c.a pAv = new a();

    private d() {
        ewT();
    }

    public void gL(@Nullable List<c.a> list) {
        this.pAu = list;
        ewT();
    }

    public c w(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pAt];
        int a2 = a(this.pAt, inputStream, bArr);
        c p = this.pAv.p(bArr, a2);
        if (p == null || p == c.pAq) {
            if (this.pAu != null) {
                for (c.a aVar : this.pAu) {
                    c p2 = aVar.p(bArr, a2);
                    if (p2 != null && p2 != c.pAq) {
                        return p2;
                    }
                }
            }
            return c.pAq;
        }
        return p;
    }

    private void ewT() {
        this.pAt = this.pAv.getHeaderSize();
        if (this.pAu != null) {
            for (c.a aVar : this.pAu) {
                this.pAt = Math.max(this.pAt, aVar.getHeaderSize());
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

    public static synchronized d ewU() {
        d dVar;
        synchronized (d.class) {
            if (pAs == null) {
                pAs = new d();
            }
            dVar = pAs;
        }
        return dVar;
    }

    public static c x(InputStream inputStream) throws IOException {
        return ewU().w(inputStream);
    }

    public static c y(InputStream inputStream) {
        try {
            return x(inputStream);
        } catch (IOException e) {
            throw l.t(e);
        }
    }
}

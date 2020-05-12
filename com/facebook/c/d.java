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
    private static d lZc;
    private int lZd;
    @Nullable
    private List<c.a> lZe;
    private final c.a lZf = new a();

    private d() {
        dpW();
    }

    public void eU(@Nullable List<c.a> list) {
        this.lZe = list;
        dpW();
    }

    public c q(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lZd];
        int a = a(this.lZd, inputStream, bArr);
        c n = this.lZf.n(bArr, a);
        if (n == null || n == c.lZa) {
            if (this.lZe != null) {
                for (c.a aVar : this.lZe) {
                    c n2 = aVar.n(bArr, a);
                    if (n2 != null && n2 != c.lZa) {
                        return n2;
                    }
                }
            }
            return c.lZa;
        }
        return n;
    }

    private void dpW() {
        this.lZd = this.lZf.getHeaderSize();
        if (this.lZe != null) {
            for (c.a aVar : this.lZe) {
                this.lZd = Math.max(this.lZd, aVar.getHeaderSize());
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

    public static synchronized d dpX() {
        d dVar;
        synchronized (d.class) {
            if (lZc == null) {
                lZc = new d();
            }
            dVar = lZc;
        }
        return dVar;
    }

    public static c r(InputStream inputStream) throws IOException {
        return dpX().q(inputStream);
    }

    public static c s(InputStream inputStream) {
        try {
            return r(inputStream);
        } catch (IOException e) {
            throw l.y(e);
        }
    }
}

package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private static d lOO;
    private int lOP;
    @Nullable
    private List<c.a> lOQ;
    private final c.a lOR = new a();

    private d() {
        dmm();
    }

    public void eY(@Nullable List<c.a> list) {
        this.lOQ = list;
        dmm();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lOP];
        int a = a(this.lOP, inputStream, bArr);
        c p = this.lOR.p(bArr, a);
        if (p == null || p == c.lOM) {
            if (this.lOQ != null) {
                for (c.a aVar : this.lOQ) {
                    c p2 = aVar.p(bArr, a);
                    if (p2 != null && p2 != c.lOM) {
                        return p2;
                    }
                }
            }
            return c.lOM;
        }
        return p;
    }

    private void dmm() {
        this.lOP = this.lOR.getHeaderSize();
        if (this.lOQ != null) {
            for (c.a aVar : this.lOQ) {
                this.lOP = Math.max(this.lOP, aVar.getHeaderSize());
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

    public static synchronized d dmn() {
        d dVar;
        synchronized (d.class) {
            if (lOO == null) {
                lOO = new d();
            }
            dVar = lOO;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return dmn().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.u(e);
        }
    }
}

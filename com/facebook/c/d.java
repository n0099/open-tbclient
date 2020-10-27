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
    private static d oJj;
    private int oJk;
    @Nullable
    private List<c.a> oJl;
    private final c.a oJm = new a();

    private d() {
        ejk();
    }

    public void gq(@Nullable List<c.a> list) {
        this.oJl = list;
        ejk();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.oJk];
        int a2 = a(this.oJk, inputStream, bArr);
        c p = this.oJm.p(bArr, a2);
        if (p == null || p == c.oJh) {
            if (this.oJl != null) {
                for (c.a aVar : this.oJl) {
                    c p2 = aVar.p(bArr, a2);
                    if (p2 != null && p2 != c.oJh) {
                        return p2;
                    }
                }
            }
            return c.oJh;
        }
        return p;
    }

    private void ejk() {
        this.oJk = this.oJm.getHeaderSize();
        if (this.oJl != null) {
            for (c.a aVar : this.oJl) {
                this.oJk = Math.max(this.oJk, aVar.getHeaderSize());
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

    public static synchronized d ejl() {
        d dVar;
        synchronized (d.class) {
            if (oJj == null) {
                oJj = new d();
            }
            dVar = oJj;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return ejl().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

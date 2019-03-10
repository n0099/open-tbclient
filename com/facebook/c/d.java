package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class d {
    private static d jFo;
    private int jFp;
    @Nullable
    private List<c.a> jFq;
    private final c.a jFr = new a();

    private d() {
        cwj();
    }

    public void ey(@Nullable List<c.a> list) {
        this.jFq = list;
        cwj();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.jFp];
        int a = a(this.jFp, inputStream, bArr);
        if (this.jFq != null) {
            for (c.a aVar : this.jFq) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.jFm) {
                    return j;
                }
            }
        }
        c j2 = this.jFr.j(bArr, a);
        if (j2 == null) {
            return c.jFm;
        }
        return j2;
    }

    private void cwj() {
        this.jFp = this.jFr.getHeaderSize();
        if (this.jFq != null) {
            for (c.a aVar : this.jFq) {
                this.jFp = Math.max(this.jFp, aVar.getHeaderSize());
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

    public static synchronized d cwk() {
        d dVar;
        synchronized (d.class) {
            if (jFo == null) {
                jFo = new d();
            }
            dVar = jFo;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cwk().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.s(e);
        }
    }
}

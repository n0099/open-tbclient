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
    private static d jXo;
    private int jXp;
    @Nullable
    private List<c.a> jXq;
    private final c.a jXr = new a();

    private d() {
        cEb();
    }

    public void eD(@Nullable List<c.a> list) {
        this.jXq = list;
        cEb();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.jXp];
        int a = a(this.jXp, inputStream, bArr);
        if (this.jXq != null) {
            for (c.a aVar : this.jXq) {
                c l = aVar.l(bArr, a);
                if (l != null && l != c.jXm) {
                    return l;
                }
            }
        }
        c l2 = this.jXr.l(bArr, a);
        if (l2 == null) {
            return c.jXm;
        }
        return l2;
    }

    private void cEb() {
        this.jXp = this.jXr.getHeaderSize();
        if (this.jXq != null) {
            for (c.a aVar : this.jXq) {
                this.jXp = Math.max(this.jXp, aVar.getHeaderSize());
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

    public static synchronized d cEc() {
        d dVar;
        synchronized (d.class) {
            if (jXo == null) {
                jXo = new d();
            }
            dVar = jXo;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cEc().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

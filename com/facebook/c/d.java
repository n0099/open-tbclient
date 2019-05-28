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
    private static d jXp;
    private int jXq;
    @Nullable
    private List<c.a> jXr;
    private final c.a jXs = new a();

    private d() {
        cEd();
    }

    public void eD(@Nullable List<c.a> list) {
        this.jXr = list;
        cEd();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.jXq];
        int a = a(this.jXq, inputStream, bArr);
        if (this.jXr != null) {
            for (c.a aVar : this.jXr) {
                c l = aVar.l(bArr, a);
                if (l != null && l != c.jXn) {
                    return l;
                }
            }
        }
        c l2 = this.jXs.l(bArr, a);
        if (l2 == null) {
            return c.jXn;
        }
        return l2;
    }

    private void cEd() {
        this.jXq = this.jXs.getHeaderSize();
        if (this.jXr != null) {
            for (c.a aVar : this.jXr) {
                this.jXq = Math.max(this.jXq, aVar.getHeaderSize());
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

    public static synchronized d cEe() {
        d dVar;
        synchronized (d.class) {
            if (jXp == null) {
                jXp = new d();
            }
            dVar = jXp;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cEe().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

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
    private static d jXs;
    private int jXt;
    @Nullable
    private List<c.a> jXu;
    private final c.a jXv = new a();

    private d() {
        cEc();
    }

    public void eD(@Nullable List<c.a> list) {
        this.jXu = list;
        cEc();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.jXt];
        int a = a(this.jXt, inputStream, bArr);
        if (this.jXu != null) {
            for (c.a aVar : this.jXu) {
                c l = aVar.l(bArr, a);
                if (l != null && l != c.jXq) {
                    return l;
                }
            }
        }
        c l2 = this.jXv.l(bArr, a);
        if (l2 == null) {
            return c.jXq;
        }
        return l2;
    }

    private void cEc() {
        this.jXt = this.jXv.getHeaderSize();
        if (this.jXu != null) {
            for (c.a aVar : this.jXu) {
                this.jXt = Math.max(this.jXt, aVar.getHeaderSize());
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

    public static synchronized d cEd() {
        d dVar;
        synchronized (d.class) {
            if (jXs == null) {
                jXs = new d();
            }
            dVar = jXs;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cEd().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

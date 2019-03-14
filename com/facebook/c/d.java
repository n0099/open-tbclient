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
    private static d jFg;
    private int jFh;
    @Nullable
    private List<c.a> jFi;
    private final c.a jFj = new a();

    private d() {
        cwm();
    }

    public void ey(@Nullable List<c.a> list) {
        this.jFi = list;
        cwm();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.jFh];
        int a = a(this.jFh, inputStream, bArr);
        if (this.jFi != null) {
            for (c.a aVar : this.jFi) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.jFe) {
                    return j;
                }
            }
        }
        c j2 = this.jFj.j(bArr, a);
        if (j2 == null) {
            return c.jFe;
        }
        return j2;
    }

    private void cwm() {
        this.jFh = this.jFj.getHeaderSize();
        if (this.jFi != null) {
            for (c.a aVar : this.jFi) {
                this.jFh = Math.max(this.jFh, aVar.getHeaderSize());
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

    public static synchronized d cwn() {
        d dVar;
        synchronized (d.class) {
            if (jFg == null) {
                jFg = new d();
            }
            dVar = jFg;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cwn().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.s(e);
        }
    }
}

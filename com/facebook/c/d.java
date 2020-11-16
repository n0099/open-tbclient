package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public class d {
    private static d oUf;
    private int oUg;
    @Nullable
    private List<c.a> oUh;
    private final c.a oUi = new a();

    private d() {
        emX();
    }

    public void gz(@Nullable List<c.a> list) {
        this.oUh = list;
        emX();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.oUg];
        int a2 = a(this.oUg, inputStream, bArr);
        c p = this.oUi.p(bArr, a2);
        if (p == null || p == c.oUd) {
            if (this.oUh != null) {
                for (c.a aVar : this.oUh) {
                    c p2 = aVar.p(bArr, a2);
                    if (p2 != null && p2 != c.oUd) {
                        return p2;
                    }
                }
            }
            return c.oUd;
        }
        return p;
    }

    private void emX() {
        this.oUg = this.oUi.getHeaderSize();
        if (this.oUh != null) {
            for (c.a aVar : this.oUh) {
                this.oUg = Math.max(this.oUg, aVar.getHeaderSize());
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

    public static synchronized d emY() {
        d dVar;
        synchronized (d.class) {
            if (oUf == null) {
                oUf = new d();
            }
            dVar = oUf;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return emY().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

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
    private static d pvS;
    private int pvT;
    @Nullable
    private List<c.a> pvU;
    private final c.a pvV = new a();

    private d() {
        etb();
    }

    public void gL(@Nullable List<c.a> list) {
        this.pvU = list;
        etb();
    }

    public c w(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.pvT];
        int a2 = a(this.pvT, inputStream, bArr);
        c p = this.pvV.p(bArr, a2);
        if (p == null || p == c.pvQ) {
            if (this.pvU != null) {
                for (c.a aVar : this.pvU) {
                    c p2 = aVar.p(bArr, a2);
                    if (p2 != null && p2 != c.pvQ) {
                        return p2;
                    }
                }
            }
            return c.pvQ;
        }
        return p;
    }

    private void etb() {
        this.pvT = this.pvV.getHeaderSize();
        if (this.pvU != null) {
            for (c.a aVar : this.pvU) {
                this.pvT = Math.max(this.pvT, aVar.getHeaderSize());
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

    public static synchronized d etc() {
        d dVar;
        synchronized (d.class) {
            if (pvS == null) {
                pvS = new d();
            }
            dVar = pvS;
        }
        return dVar;
    }

    public static c x(InputStream inputStream) throws IOException {
        return etc().w(inputStream);
    }

    public static c y(InputStream inputStream) {
        try {
            return x(inputStream);
        } catch (IOException e) {
            throw l.t(e);
        }
    }
}

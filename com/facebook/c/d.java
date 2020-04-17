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
    private static d lYY;
    private int lYZ;
    @Nullable
    private List<c.a> lZa;
    private final c.a lZb = new a();

    private d() {
        dpY();
    }

    public void eU(@Nullable List<c.a> list) {
        this.lZa = list;
        dpY();
    }

    public c q(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lYZ];
        int a = a(this.lYZ, inputStream, bArr);
        c n = this.lZb.n(bArr, a);
        if (n == null || n == c.lYW) {
            if (this.lZa != null) {
                for (c.a aVar : this.lZa) {
                    c n2 = aVar.n(bArr, a);
                    if (n2 != null && n2 != c.lYW) {
                        return n2;
                    }
                }
            }
            return c.lYW;
        }
        return n;
    }

    private void dpY() {
        this.lYZ = this.lZb.getHeaderSize();
        if (this.lZa != null) {
            for (c.a aVar : this.lZa) {
                this.lYZ = Math.max(this.lYZ, aVar.getHeaderSize());
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

    public static synchronized d dpZ() {
        d dVar;
        synchronized (d.class) {
            if (lYY == null) {
                lYY = new d();
            }
            dVar = lYY;
        }
        return dVar;
    }

    public static c r(InputStream inputStream) throws IOException {
        return dpZ().q(inputStream);
    }

    public static c s(InputStream inputStream) {
        try {
            return r(inputStream);
        } catch (IOException e) {
            throw l.y(e);
        }
    }
}

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
    private static d ipo;
    private int ipp;
    @Nullable
    private List<c.a> ipq;
    private final c.a ipr = new a();

    private d() {
        bWY();
    }

    public void eu(@Nullable List<c.a> list) {
        this.ipq = list;
        bWY();
    }

    public c q(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.ipp];
        int a = a(this.ipp, inputStream, bArr);
        if (this.ipq != null) {
            for (c.a aVar : this.ipq) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.ipm) {
                    return j;
                }
            }
        }
        c j2 = this.ipr.j(bArr, a);
        if (j2 == null) {
            return c.ipm;
        }
        return j2;
    }

    private void bWY() {
        this.ipp = this.ipr.getHeaderSize();
        if (this.ipq != null) {
            for (c.a aVar : this.ipq) {
                this.ipp = Math.max(this.ipp, aVar.getHeaderSize());
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

    public static synchronized d bWZ() {
        d dVar;
        synchronized (d.class) {
            if (ipo == null) {
                ipo = new d();
            }
            dVar = ipo;
        }
        return dVar;
    }

    public static c r(InputStream inputStream) throws IOException {
        return bWZ().q(inputStream);
    }

    public static c s(InputStream inputStream) {
        try {
            return r(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

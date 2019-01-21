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
    private static d ipp;
    private int ipq;
    @Nullable
    private List<c.a> ipr;
    private final c.a ips = new a();

    private d() {
        bWY();
    }

    public void eu(@Nullable List<c.a> list) {
        this.ipr = list;
        bWY();
    }

    public c q(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.ipq];
        int a = a(this.ipq, inputStream, bArr);
        if (this.ipr != null) {
            for (c.a aVar : this.ipr) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.ipn) {
                    return j;
                }
            }
        }
        c j2 = this.ips.j(bArr, a);
        if (j2 == null) {
            return c.ipn;
        }
        return j2;
    }

    private void bWY() {
        this.ipq = this.ips.getHeaderSize();
        if (this.ipr != null) {
            for (c.a aVar : this.ipr) {
                this.ipq = Math.max(this.ipq, aVar.getHeaderSize());
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
            if (ipp == null) {
                ipp = new d();
            }
            dVar = ipp;
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

package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class d {
    private static d nsi;
    private int nsj;
    @Nullable
    private List<c.a> nsk;
    private final c.a nsl = new a();

    private d() {
        dRu();
    }

    public void fI(@Nullable List<c.a> list) {
        this.nsk = list;
        dRu();
    }

    public c r(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.nsj];
        int a = a(this.nsj, inputStream, bArr);
        c o = this.nsl.o(bArr, a);
        if (o == null || o == c.nsg) {
            if (this.nsk != null) {
                for (c.a aVar : this.nsk) {
                    c o2 = aVar.o(bArr, a);
                    if (o2 != null && o2 != c.nsg) {
                        return o2;
                    }
                }
            }
            return c.nsg;
        }
        return o;
    }

    private void dRu() {
        this.nsj = this.nsl.getHeaderSize();
        if (this.nsk != null) {
            for (c.a aVar : this.nsk) {
                this.nsj = Math.max(this.nsj, aVar.getHeaderSize());
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

    public static synchronized d dRv() {
        d dVar;
        synchronized (d.class) {
            if (nsi == null) {
                nsi = new d();
            }
            dVar = nsi;
        }
        return dVar;
    }

    public static c s(InputStream inputStream) throws IOException {
        return dRv().r(inputStream);
    }

    public static c t(InputStream inputStream) {
        try {
            return s(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

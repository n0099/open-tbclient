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
    private static d nsA;
    private int nsB;
    @Nullable
    private List<c.a> nsC;
    private final c.a nsD = new a();

    private d() {
        dRD();
    }

    public void fI(@Nullable List<c.a> list) {
        this.nsC = list;
        dRD();
    }

    public c r(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.nsB];
        int a = a(this.nsB, inputStream, bArr);
        c o = this.nsD.o(bArr, a);
        if (o == null || o == c.nsy) {
            if (this.nsC != null) {
                for (c.a aVar : this.nsC) {
                    c o2 = aVar.o(bArr, a);
                    if (o2 != null && o2 != c.nsy) {
                        return o2;
                    }
                }
            }
            return c.nsy;
        }
        return o;
    }

    private void dRD() {
        this.nsB = this.nsD.getHeaderSize();
        if (this.nsC != null) {
            for (c.a aVar : this.nsC) {
                this.nsB = Math.max(this.nsB, aVar.getHeaderSize());
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

    public static synchronized d dRE() {
        d dVar;
        synchronized (d.class) {
            if (nsA == null) {
                nsA = new d();
            }
            dVar = nsA;
        }
        return dVar;
    }

    public static c s(InputStream inputStream) throws IOException {
        return dRE().r(inputStream);
    }

    public static c t(InputStream inputStream) {
        try {
            return s(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

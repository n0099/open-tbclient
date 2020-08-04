package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class d {
    private static d mYt;
    private int mYu;
    @Nullable
    private List<c.a> mYv;
    private final c.a mYw = new a();

    private d() {
        dFv();
    }

    public void fy(@Nullable List<c.a> list) {
        this.mYv = list;
        dFv();
    }

    public c q(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.mYu];
        int a = a(this.mYu, inputStream, bArr);
        c o = this.mYw.o(bArr, a);
        if (o == null || o == c.mYr) {
            if (this.mYv != null) {
                for (c.a aVar : this.mYv) {
                    c o2 = aVar.o(bArr, a);
                    if (o2 != null && o2 != c.mYr) {
                        return o2;
                    }
                }
            }
            return c.mYr;
        }
        return o;
    }

    private void dFv() {
        this.mYu = this.mYw.getHeaderSize();
        if (this.mYv != null) {
            for (c.a aVar : this.mYv) {
                this.mYu = Math.max(this.mYu, aVar.getHeaderSize());
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

    public static synchronized d dFw() {
        d dVar;
        synchronized (d.class) {
            if (mYt == null) {
                mYt = new d();
            }
            dVar = mYt;
        }
        return dVar;
    }

    public static c r(InputStream inputStream) throws IOException {
        return dFw().q(inputStream);
    }

    public static c s(InputStream inputStream) {
        try {
            return r(inputStream);
        } catch (IOException e) {
            throw l.x(e);
        }
    }
}

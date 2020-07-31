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
    private static d mYr;
    private int mYs;
    @Nullable
    private List<c.a> mYt;
    private final c.a mYu = new a();

    private d() {
        dFu();
    }

    public void fy(@Nullable List<c.a> list) {
        this.mYt = list;
        dFu();
    }

    public c q(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.mYs];
        int a = a(this.mYs, inputStream, bArr);
        c o = this.mYu.o(bArr, a);
        if (o == null || o == c.mYp) {
            if (this.mYt != null) {
                for (c.a aVar : this.mYt) {
                    c o2 = aVar.o(bArr, a);
                    if (o2 != null && o2 != c.mYp) {
                        return o2;
                    }
                }
            }
            return c.mYp;
        }
        return o;
    }

    private void dFu() {
        this.mYs = this.mYu.getHeaderSize();
        if (this.mYt != null) {
            for (c.a aVar : this.mYt) {
                this.mYs = Math.max(this.mYs, aVar.getHeaderSize());
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

    public static synchronized d dFv() {
        d dVar;
        synchronized (d.class) {
            if (mYr == null) {
                mYr = new d();
            }
            dVar = mYr;
        }
        return dVar;
    }

    public static c r(InputStream inputStream) throws IOException {
        return dFv().q(inputStream);
    }

    public static c s(InputStream inputStream) {
        try {
            return r(inputStream);
        } catch (IOException e) {
            throw l.x(e);
        }
    }
}

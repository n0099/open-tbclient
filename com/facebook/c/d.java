package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private static d lOT;
    private int lOU;
    @Nullable
    private List<c.a> lOV;
    private final c.a lOW = new a();

    private d() {
        dmo();
    }

    public void eY(@Nullable List<c.a> list) {
        this.lOV = list;
        dmo();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lOU];
        int a = a(this.lOU, inputStream, bArr);
        c p = this.lOW.p(bArr, a);
        if (p == null || p == c.lOR) {
            if (this.lOV != null) {
                for (c.a aVar : this.lOV) {
                    c p2 = aVar.p(bArr, a);
                    if (p2 != null && p2 != c.lOR) {
                        return p2;
                    }
                }
            }
            return c.lOR;
        }
        return p;
    }

    private void dmo() {
        this.lOU = this.lOW.getHeaderSize();
        if (this.lOV != null) {
            for (c.a aVar : this.lOV) {
                this.lOU = Math.max(this.lOU, aVar.getHeaderSize());
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

    public static synchronized d dmp() {
        d dVar;
        synchronized (d.class) {
            if (lOT == null) {
                lOT = new d();
            }
            dVar = lOT;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return dmp().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.u(e);
        }
    }
}

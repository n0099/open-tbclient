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
    private static d lRt;
    private int lRu;
    @Nullable
    private List<c.a> lRv;
    private final c.a lRw = new a();

    private d() {
        dob();
    }

    public void eT(@Nullable List<c.a> list) {
        this.lRv = list;
        dob();
    }

    public c t(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.lRu];
        int a = a(this.lRu, inputStream, bArr);
        c r = this.lRw.r(bArr, a);
        if (r == null || r == c.lRr) {
            if (this.lRv != null) {
                for (c.a aVar : this.lRv) {
                    c r2 = aVar.r(bArr, a);
                    if (r2 != null && r2 != c.lRr) {
                        return r2;
                    }
                }
            }
            return c.lRr;
        }
        return r;
    }

    private void dob() {
        this.lRu = this.lRw.getHeaderSize();
        if (this.lRv != null) {
            for (c.a aVar : this.lRv) {
                this.lRu = Math.max(this.lRu, aVar.getHeaderSize());
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

    public static synchronized d doc() {
        d dVar;
        synchronized (d.class) {
            if (lRt == null) {
                lRt = new d();
            }
            dVar = lRt;
        }
        return dVar;
    }

    public static c u(InputStream inputStream) throws IOException {
        return doc().t(inputStream);
    }

    public static c v(InputStream inputStream) {
        try {
            return u(inputStream);
        } catch (IOException e) {
            throw l.t(e);
        }
    }
}

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
    private static d kfu;
    private int kfv;
    @Nullable
    private List<c.a> kfw;
    private final c.a kfx = new a();

    private d() {
        cFj();
    }

    public void eS(@Nullable List<c.a> list) {
        this.kfw = list;
        cFj();
    }

    public c p(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.kfv];
        int a = a(this.kfv, inputStream, bArr);
        if (this.kfw != null) {
            for (c.a aVar : this.kfw) {
                c l = aVar.l(bArr, a);
                if (l != null && l != c.kfs) {
                    return l;
                }
            }
        }
        c l2 = this.kfx.l(bArr, a);
        if (l2 == null) {
            return c.kfs;
        }
        return l2;
    }

    private void cFj() {
        this.kfv = this.kfx.getHeaderSize();
        if (this.kfw != null) {
            for (c.a aVar : this.kfw) {
                this.kfv = Math.max(this.kfv, aVar.getHeaderSize());
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

    public static synchronized d cFk() {
        d dVar;
        synchronized (d.class) {
            if (kfu == null) {
                kfu = new d();
            }
            dVar = kfu;
        }
        return dVar;
    }

    public static c q(InputStream inputStream) throws IOException {
        return cFk().p(inputStream);
    }

    public static c r(InputStream inputStream) {
        try {
            return q(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

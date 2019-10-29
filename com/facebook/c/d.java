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
    private static d kgl;
    private int kgm;
    @Nullable
    private List<c.a> kgn;
    private final c.a kgo = new a();

    private d() {
        cFl();
    }

    public void eS(@Nullable List<c.a> list) {
        this.kgn = list;
        cFl();
    }

    public c p(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.kgm];
        int a = a(this.kgm, inputStream, bArr);
        if (this.kgn != null) {
            for (c.a aVar : this.kgn) {
                c l = aVar.l(bArr, a);
                if (l != null && l != c.kgj) {
                    return l;
                }
            }
        }
        c l2 = this.kgo.l(bArr, a);
        if (l2 == null) {
            return c.kgj;
        }
        return l2;
    }

    private void cFl() {
        this.kgm = this.kgo.getHeaderSize();
        if (this.kgn != null) {
            for (c.a aVar : this.kgn) {
                this.kgm = Math.max(this.kgm, aVar.getHeaderSize());
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

    public static synchronized d cFm() {
        d dVar;
        synchronized (d.class) {
            if (kgl == null) {
                kgl = new d();
            }
            dVar = kgl;
        }
        return dVar;
    }

    public static c q(InputStream inputStream) throws IOException {
        return cFm().p(inputStream);
    }

    public static c r(InputStream inputStream) {
        try {
            return q(inputStream);
        } catch (IOException e) {
            throw k.q(e);
        }
    }
}

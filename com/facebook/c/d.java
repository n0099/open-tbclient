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
    private static d kfD;
    private int kfE;
    @Nullable
    private List<c.a> kfF;
    private final c.a kfG = new a();

    private d() {
        cHA();
    }

    public void eF(@Nullable List<c.a> list) {
        this.kfF = list;
        cHA();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.kfE];
        int a = a(this.kfE, inputStream, bArr);
        if (this.kfF != null) {
            for (c.a aVar : this.kfF) {
                c l = aVar.l(bArr, a);
                if (l != null && l != c.kfB) {
                    return l;
                }
            }
        }
        c l2 = this.kfG.l(bArr, a);
        if (l2 == null) {
            return c.kfB;
        }
        return l2;
    }

    private void cHA() {
        this.kfE = this.kfG.getHeaderSize();
        if (this.kfF != null) {
            for (c.a aVar : this.kfF) {
                this.kfE = Math.max(this.kfE, aVar.getHeaderSize());
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

    public static synchronized d cHB() {
        d dVar;
        synchronized (d.class) {
            if (kfD == null) {
                kfD = new d();
            }
            dVar = kfD;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cHB().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

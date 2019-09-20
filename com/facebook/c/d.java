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
    private static d kia;
    private int kib;
    @Nullable
    private List<c.a> kic;
    private final c.a kie = new a();

    private d() {
        cIo();
    }

    public void eF(@Nullable List<c.a> list) {
        this.kic = list;
        cIo();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.kib];
        int a = a(this.kib, inputStream, bArr);
        if (this.kic != null) {
            for (c.a aVar : this.kic) {
                c l = aVar.l(bArr, a);
                if (l != null && l != c.khY) {
                    return l;
                }
            }
        }
        c l2 = this.kie.l(bArr, a);
        if (l2 == null) {
            return c.khY;
        }
        return l2;
    }

    private void cIo() {
        this.kib = this.kie.getHeaderSize();
        if (this.kic != null) {
            for (c.a aVar : this.kic) {
                this.kib = Math.max(this.kib, aVar.getHeaderSize());
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

    public static synchronized d cIp() {
        d dVar;
        synchronized (d.class) {
            if (kia == null) {
                kia = new d();
            }
            dVar = kia;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cIp().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

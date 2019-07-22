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
    private static d kew;
    private final c.a keA = new a();
    private int kex;
    @Nullable
    private List<c.a> kez;

    private d() {
        cHf();
    }

    public void eG(@Nullable List<c.a> list) {
        this.kez = list;
        cHf();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.kex];
        int a = a(this.kex, inputStream, bArr);
        if (this.kez != null) {
            for (c.a aVar : this.kez) {
                c l = aVar.l(bArr, a);
                if (l != null && l != c.keu) {
                    return l;
                }
            }
        }
        c l2 = this.keA.l(bArr, a);
        if (l2 == null) {
            return c.keu;
        }
        return l2;
    }

    private void cHf() {
        this.kex = this.keA.getHeaderSize();
        if (this.kez != null) {
            for (c.a aVar : this.kez) {
                this.kex = Math.max(this.kex, aVar.getHeaderSize());
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

    public static synchronized d cHg() {
        d dVar;
        synchronized (d.class) {
            if (kew == null) {
                kew = new d();
            }
            dVar = kew;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cHg().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

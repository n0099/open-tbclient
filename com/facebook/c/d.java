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
    private static d oSC;
    private int oSD;
    @Nullable
    private List<c.a> oSE;
    private final c.a oSF = new a();

    private d() {
        emZ();
    }

    public void gz(@Nullable List<c.a> list) {
        this.oSE = list;
        emZ();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.oSD];
        int a2 = a(this.oSD, inputStream, bArr);
        c p = this.oSF.p(bArr, a2);
        if (p == null || p == c.oSA) {
            if (this.oSE != null) {
                for (c.a aVar : this.oSE) {
                    c p2 = aVar.p(bArr, a2);
                    if (p2 != null && p2 != c.oSA) {
                        return p2;
                    }
                }
            }
            return c.oSA;
        }
        return p;
    }

    private void emZ() {
        this.oSD = this.oSF.getHeaderSize();
        if (this.oSE != null) {
            for (c.a aVar : this.oSE) {
                this.oSD = Math.max(this.oSD, aVar.getHeaderSize());
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

    public static synchronized d ena() {
        d dVar;
        synchronized (d.class) {
            if (oSC == null) {
                oSC = new d();
            }
            dVar = oSC;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return ena().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw l.v(e);
        }
    }
}

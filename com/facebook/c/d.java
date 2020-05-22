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
    private static d msX;
    private int msY;
    @Nullable
    private List<c.a> msZ;
    private final c.a mta = new a();

    private d() {
        dxo();
    }

    public void fb(@Nullable List<c.a> list) {
        this.msZ = list;
        dxo();
    }

    public c r(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.msY];
        int a = a(this.msY, inputStream, bArr);
        c o = this.mta.o(bArr, a);
        if (o == null || o == c.msV) {
            if (this.msZ != null) {
                for (c.a aVar : this.msZ) {
                    c o2 = aVar.o(bArr, a);
                    if (o2 != null && o2 != c.msV) {
                        return o2;
                    }
                }
            }
            return c.msV;
        }
        return o;
    }

    private void dxo() {
        this.msY = this.mta.getHeaderSize();
        if (this.msZ != null) {
            for (c.a aVar : this.msZ) {
                this.msY = Math.max(this.msY, aVar.getHeaderSize());
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

    public static synchronized d dxp() {
        d dVar;
        synchronized (d.class) {
            if (msX == null) {
                msX = new d();
            }
            dVar = msX;
        }
        return dVar;
    }

    public static c s(InputStream inputStream) throws IOException {
        return dxp().r(inputStream);
    }

    public static c t(InputStream inputStream) {
        try {
            return s(inputStream);
        } catch (IOException e) {
            throw l.y(e);
        }
    }
}

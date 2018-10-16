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
    private static d ibX;
    private int ibY;
    @Nullable
    private List<c.a> ibZ;
    private final c.a ica = new a();

    private d() {
        bTZ();
    }

    public void eq(@Nullable List<c.a> list) {
        this.ibZ = list;
        bTZ();
    }

    public c p(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.ibY];
        int a = a(this.ibY, inputStream, bArr);
        if (this.ibZ != null) {
            for (c.a aVar : this.ibZ) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.ibV) {
                    return j;
                }
            }
        }
        c j2 = this.ica.j(bArr, a);
        if (j2 == null) {
            return c.ibV;
        }
        return j2;
    }

    private void bTZ() {
        this.ibY = this.ica.getHeaderSize();
        if (this.ibZ != null) {
            for (c.a aVar : this.ibZ) {
                this.ibY = Math.max(this.ibY, aVar.getHeaderSize());
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

    public static synchronized d bUa() {
        d dVar;
        synchronized (d.class) {
            if (ibX == null) {
                ibX = new d();
            }
            dVar = ibX;
        }
        return dVar;
    }

    public static c q(InputStream inputStream) throws IOException {
        return bUa().p(inputStream);
    }

    public static c r(InputStream inputStream) {
        try {
            return q(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

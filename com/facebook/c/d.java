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
    private static d ibY;
    private int ibZ;
    @Nullable
    private List<c.a> ica;
    private final c.a icb = new a();

    private d() {
        bTZ();
    }

    public void eq(@Nullable List<c.a> list) {
        this.ica = list;
        bTZ();
    }

    public c p(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.ibZ];
        int a = a(this.ibZ, inputStream, bArr);
        if (this.ica != null) {
            for (c.a aVar : this.ica) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.ibW) {
                    return j;
                }
            }
        }
        c j2 = this.icb.j(bArr, a);
        if (j2 == null) {
            return c.ibW;
        }
        return j2;
    }

    private void bTZ() {
        this.ibZ = this.icb.getHeaderSize();
        if (this.ica != null) {
            for (c.a aVar : this.ica) {
                this.ibZ = Math.max(this.ibZ, aVar.getHeaderSize());
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
            if (ibY == null) {
                ibY = new d();
            }
            dVar = ibY;
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

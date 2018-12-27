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
    private static d ioh;
    private int ioi;
    @Nullable
    private List<c.a> ioj;
    private final c.a iok = new a();

    private d() {
        bWq();
    }

    public void et(@Nullable List<c.a> list) {
        this.ioj = list;
        bWq();
    }

    public c q(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.ioi];
        int a = a(this.ioi, inputStream, bArr);
        if (this.ioj != null) {
            for (c.a aVar : this.ioj) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.iof) {
                    return j;
                }
            }
        }
        c j2 = this.iok.j(bArr, a);
        if (j2 == null) {
            return c.iof;
        }
        return j2;
    }

    private void bWq() {
        this.ioi = this.iok.getHeaderSize();
        if (this.ioj != null) {
            for (c.a aVar : this.ioj) {
                this.ioi = Math.max(this.ioi, aVar.getHeaderSize());
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

    public static synchronized d bWr() {
        d dVar;
        synchronized (d.class) {
            if (ioh == null) {
                ioh = new d();
            }
            dVar = ioh;
        }
        return dVar;
    }

    public static c r(InputStream inputStream) throws IOException {
        return bWr().q(inputStream);
    }

    public static c s(InputStream inputStream) {
        try {
            return r(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

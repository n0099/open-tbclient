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
    private static d idL;
    private int idM;
    @Nullable
    private List<c.a> idN;
    private final c.a idO = new a();

    private d() {
        bTu();
    }

    public void eo(@Nullable List<c.a> list) {
        this.idN = list;
        bTu();
    }

    public c p(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.idM];
        int a = a(this.idM, inputStream, bArr);
        if (this.idN != null) {
            for (c.a aVar : this.idN) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.idJ) {
                    return j;
                }
            }
        }
        c j2 = this.idO.j(bArr, a);
        if (j2 == null) {
            return c.idJ;
        }
        return j2;
    }

    private void bTu() {
        this.idM = this.idO.getHeaderSize();
        if (this.idN != null) {
            for (c.a aVar : this.idN) {
                this.idM = Math.max(this.idM, aVar.getHeaderSize());
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

    public static synchronized d bTv() {
        d dVar;
        synchronized (d.class) {
            if (idL == null) {
                idL = new d();
            }
            dVar = idL;
        }
        return dVar;
    }

    public static c q(InputStream inputStream) throws IOException {
        return bTv().p(inputStream);
    }

    public static c r(InputStream inputStream) {
        try {
            return q(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

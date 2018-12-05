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
    private static d ikV;
    private int ikW;
    @Nullable
    private List<c.a> ikX;
    private final c.a ikY = new a();

    private d() {
        bVA();
    }

    public void es(@Nullable List<c.a> list) {
        this.ikX = list;
        bVA();
    }

    public c q(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.ikW];
        int a = a(this.ikW, inputStream, bArr);
        if (this.ikX != null) {
            for (c.a aVar : this.ikX) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.ikT) {
                    return j;
                }
            }
        }
        c j2 = this.ikY.j(bArr, a);
        if (j2 == null) {
            return c.ikT;
        }
        return j2;
    }

    private void bVA() {
        this.ikW = this.ikY.getHeaderSize();
        if (this.ikX != null) {
            for (c.a aVar : this.ikX) {
                this.ikW = Math.max(this.ikW, aVar.getHeaderSize());
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

    public static synchronized d bVB() {
        d dVar;
        synchronized (d.class) {
            if (ikV == null) {
                ikV = new d();
            }
            dVar = ikV;
        }
        return dVar;
    }

    public static c r(InputStream inputStream) throws IOException {
        return bVB().q(inputStream);
    }

    public static c s(InputStream inputStream) {
        try {
            return r(inputStream);
        } catch (IOException e) {
            throw k.r(e);
        }
    }
}

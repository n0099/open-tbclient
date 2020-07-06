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
    private static d mQj;
    private int mQk;
    @Nullable
    private List<c.a> mQl;
    private final c.a mQm = new a();

    private d() {
        dCi();
    }

    public void fp(@Nullable List<c.a> list) {
        this.mQl = list;
        dCi();
    }

    public c r(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.mQk];
        int a = a(this.mQk, inputStream, bArr);
        c o = this.mQm.o(bArr, a);
        if (o == null || o == c.mQh) {
            if (this.mQl != null) {
                for (c.a aVar : this.mQl) {
                    c o2 = aVar.o(bArr, a);
                    if (o2 != null && o2 != c.mQh) {
                        return o2;
                    }
                }
            }
            return c.mQh;
        }
        return o;
    }

    private void dCi() {
        this.mQk = this.mQm.getHeaderSize();
        if (this.mQl != null) {
            for (c.a aVar : this.mQl) {
                this.mQk = Math.max(this.mQk, aVar.getHeaderSize());
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

    public static synchronized d dCj() {
        d dVar;
        synchronized (d.class) {
            if (mQj == null) {
                mQj = new d();
            }
            dVar = mQj;
        }
        return dVar;
    }

    public static c s(InputStream inputStream) throws IOException {
        return dCj().r(inputStream);
    }

    public static c t(InputStream inputStream) {
        try {
            return s(inputStream);
        } catch (IOException e) {
            throw l.y(e);
        }
    }
}

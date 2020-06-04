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
    private static d muh;
    private int mui;
    @Nullable
    private List<c.a> muj;
    private final c.a muk = new a();

    private d() {
        dxC();
    }

    public void fd(@Nullable List<c.a> list) {
        this.muj = list;
        dxC();
    }

    public c r(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.mui];
        int a = a(this.mui, inputStream, bArr);
        c o = this.muk.o(bArr, a);
        if (o == null || o == c.muf) {
            if (this.muj != null) {
                for (c.a aVar : this.muj) {
                    c o2 = aVar.o(bArr, a);
                    if (o2 != null && o2 != c.muf) {
                        return o2;
                    }
                }
            }
            return c.muf;
        }
        return o;
    }

    private void dxC() {
        this.mui = this.muk.getHeaderSize();
        if (this.muj != null) {
            for (c.a aVar : this.muj) {
                this.mui = Math.max(this.mui, aVar.getHeaderSize());
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

    public static synchronized d dxD() {
        d dVar;
        synchronized (d.class) {
            if (muh == null) {
                muh = new d();
            }
            dVar = muh;
        }
        return dVar;
    }

    public static c s(InputStream inputStream) throws IOException {
        return dxD().r(inputStream);
    }

    public static c t(InputStream inputStream) {
        try {
            return s(inputStream);
        } catch (IOException e) {
            throw l.y(e);
        }
    }
}

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
    private static d mQg;
    private int mQh;
    @Nullable
    private List<c.a> mQi;
    private final c.a mQj = new a();

    private d() {
        dCe();
    }

    public void fp(@Nullable List<c.a> list) {
        this.mQi = list;
        dCe();
    }

    public c r(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.mQh];
        int a = a(this.mQh, inputStream, bArr);
        c o = this.mQj.o(bArr, a);
        if (o == null || o == c.mQe) {
            if (this.mQi != null) {
                for (c.a aVar : this.mQi) {
                    c o2 = aVar.o(bArr, a);
                    if (o2 != null && o2 != c.mQe) {
                        return o2;
                    }
                }
            }
            return c.mQe;
        }
        return o;
    }

    private void dCe() {
        this.mQh = this.mQj.getHeaderSize();
        if (this.mQi != null) {
            for (c.a aVar : this.mQi) {
                this.mQh = Math.max(this.mQh, aVar.getHeaderSize());
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

    public static synchronized d dCf() {
        d dVar;
        synchronized (d.class) {
            if (mQg == null) {
                mQg = new d();
            }
            dVar = mQg;
        }
        return dVar;
    }

    public static c s(InputStream inputStream) throws IOException {
        return dCf().r(inputStream);
    }

    public static c t(InputStream inputStream) {
        try {
            return s(inputStream);
        } catch (IOException e) {
            throw l.y(e);
        }
    }
}

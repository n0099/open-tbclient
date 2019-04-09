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
    private static d jEB;
    private int jEC;
    @Nullable
    private List<c.a> jED;
    private final c.a jEE = new a();

    private d() {
        cwf();
    }

    public void ev(@Nullable List<c.a> list) {
        this.jED = list;
        cwf();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.jEC];
        int a = a(this.jEC, inputStream, bArr);
        if (this.jED != null) {
            for (c.a aVar : this.jED) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.jEz) {
                    return j;
                }
            }
        }
        c j2 = this.jEE.j(bArr, a);
        if (j2 == null) {
            return c.jEz;
        }
        return j2;
    }

    private void cwf() {
        this.jEC = this.jEE.getHeaderSize();
        if (this.jED != null) {
            for (c.a aVar : this.jED) {
                this.jEC = Math.max(this.jEC, aVar.getHeaderSize());
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

    public static synchronized d cwg() {
        d dVar;
        synchronized (d.class) {
            if (jEB == null) {
                jEB = new d();
            }
            dVar = jEB;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cwg().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.s(e);
        }
    }
}

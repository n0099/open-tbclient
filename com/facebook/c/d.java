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
    private static d jEA;
    private int jEB;
    @Nullable
    private List<c.a> jEC;
    private final c.a jED = new a();

    private d() {
        cwf();
    }

    public void ev(@Nullable List<c.a> list) {
        this.jEC = list;
        cwf();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.jEB];
        int a = a(this.jEB, inputStream, bArr);
        if (this.jEC != null) {
            for (c.a aVar : this.jEC) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.jEy) {
                    return j;
                }
            }
        }
        c j2 = this.jED.j(bArr, a);
        if (j2 == null) {
            return c.jEy;
        }
        return j2;
    }

    private void cwf() {
        this.jEB = this.jED.getHeaderSize();
        if (this.jEC != null) {
            for (c.a aVar : this.jEC) {
                this.jEB = Math.max(this.jEB, aVar.getHeaderSize());
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
            if (jEA == null) {
                jEA = new d();
            }
            dVar = jEA;
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

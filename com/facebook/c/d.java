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
    private static d jEV;
    private int jEW;
    @Nullable
    private List<c.a> jEX;
    private final c.a jEY = new a();

    private d() {
        cvZ();
    }

    public void ey(@Nullable List<c.a> list) {
        this.jEX = list;
        cvZ();
    }

    public c s(InputStream inputStream) throws IOException {
        g.checkNotNull(inputStream);
        byte[] bArr = new byte[this.jEW];
        int a = a(this.jEW, inputStream, bArr);
        if (this.jEX != null) {
            for (c.a aVar : this.jEX) {
                c j = aVar.j(bArr, a);
                if (j != null && j != c.jET) {
                    return j;
                }
            }
        }
        c j2 = this.jEY.j(bArr, a);
        if (j2 == null) {
            return c.jET;
        }
        return j2;
    }

    private void cvZ() {
        this.jEW = this.jEY.getHeaderSize();
        if (this.jEX != null) {
            for (c.a aVar : this.jEX) {
                this.jEW = Math.max(this.jEW, aVar.getHeaderSize());
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

    public static synchronized d cwa() {
        d dVar;
        synchronized (d.class) {
            if (jEV == null) {
                jEV = new d();
            }
            dVar = jEV;
        }
        return dVar;
    }

    public static c t(InputStream inputStream) throws IOException {
        return cwa().s(inputStream);
    }

    public static c u(InputStream inputStream) {
        try {
            return t(inputStream);
        } catch (IOException e) {
            throw k.s(e);
        }
    }
}

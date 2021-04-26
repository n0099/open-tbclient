package com.meizu.cloud.pushsdk.b.c;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class j {
    public static j a(final g gVar, final File file) {
        if (file != null) {
            return new j() { // from class: com.meizu.cloud.pushsdk.b.c.j.2
                @Override // com.meizu.cloud.pushsdk.b.c.j
                public g a() {
                    return g.this;
                }

                @Override // com.meizu.cloud.pushsdk.b.c.j
                public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
                    com.meizu.cloud.pushsdk.b.g.m mVar = null;
                    try {
                        mVar = com.meizu.cloud.pushsdk.b.g.g.a(file);
                        cVar.a(mVar);
                    } finally {
                        m.a(mVar);
                    }
                }

                @Override // com.meizu.cloud.pushsdk.b.c.j
                public long b() {
                    return file.length();
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static j a(g gVar, String str) {
        Charset charset = m.f35502c;
        if (gVar != null && (charset = gVar.b()) == null) {
            charset = m.f35502c;
            gVar = g.a(gVar + "; charset=utf-8");
        }
        return a(gVar, str.getBytes(charset));
    }

    public static j a(g gVar, byte[] bArr) {
        return a(gVar, bArr, 0, bArr.length);
    }

    public static j a(final g gVar, final byte[] bArr, final int i2, final int i3) {
        if (bArr != null) {
            m.a(bArr.length, i2, i3);
            return new j() { // from class: com.meizu.cloud.pushsdk.b.c.j.1
                @Override // com.meizu.cloud.pushsdk.b.c.j
                public g a() {
                    return g.this;
                }

                @Override // com.meizu.cloud.pushsdk.b.c.j
                public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
                    cVar.c(bArr, i2, i3);
                }

                @Override // com.meizu.cloud.pushsdk.b.c.j
                public long b() {
                    return i3;
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public abstract g a();

    public abstract void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException;

    public long b() throws IOException {
        return -1L;
    }
}

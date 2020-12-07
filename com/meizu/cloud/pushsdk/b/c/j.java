package com.meizu.cloud.pushsdk.b.c;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes16.dex */
public abstract class j {
    public static j a(final g gVar, final File file) {
        if (file == null) {
            throw new NullPointerException("content == null");
        }
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

    public static j a(g gVar, String str) {
        Charset charset = m.c;
        if (gVar != null && (charset = gVar.b()) == null) {
            charset = m.c;
            gVar = g.a(gVar + "; charset=utf-8");
        }
        return a(gVar, str.getBytes(charset));
    }

    public static j a(g gVar, byte[] bArr) {
        return a(gVar, bArr, 0, bArr.length);
    }

    public static j a(final g gVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        m.a(bArr.length, i, i2);
        return new j() { // from class: com.meizu.cloud.pushsdk.b.c.j.1
            @Override // com.meizu.cloud.pushsdk.b.c.j
            public g a() {
                return g.this;
            }

            @Override // com.meizu.cloud.pushsdk.b.c.j
            public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
                cVar.c(bArr, i, i2);
            }

            @Override // com.meizu.cloud.pushsdk.b.c.j
            public long b() {
                return i2;
            }
        };
    }

    public abstract g a();

    public abstract void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException;

    public long b() throws IOException {
        return -1L;
    }
}

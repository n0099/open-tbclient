package com.meizu.cloud.pushsdk.networking.b;

import com.meizu.cloud.pushsdk.networking.okio.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class h extends j {
    public static final g a = g.a("multipart/mixed");
    public static final g b = g.a("multipart/alternative");
    public static final g c = g.a("multipart/digest");
    public static final g d = g.a("multipart/parallel");
    public static final g e = g.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final ByteString i;
    private final g j;
    private final g k;
    private final List<b> l;
    private long m = -1;

    h(ByteString byteString, g gVar, List<b> list) {
        this.i = byteString;
        this.j = gVar;
        this.k = g.a(gVar + "; boundary=" + byteString.utf8());
        this.l = m.a(list);
    }

    @Override // com.meizu.cloud.pushsdk.networking.b.j
    public g a() {
        return this.k;
    }

    @Override // com.meizu.cloud.pushsdk.networking.b.j
    public long b() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((com.meizu.cloud.pushsdk.networking.okio.c) null, true);
        this.m = a2;
        return a2;
    }

    @Override // com.meizu.cloud.pushsdk.networking.b.j
    public void a(com.meizu.cloud.pushsdk.networking.okio.c cVar) throws IOException {
        a(cVar, false);
    }

    private long a(com.meizu.cloud.pushsdk.networking.okio.c cVar, boolean z) throws IOException {
        com.meizu.cloud.pushsdk.networking.okio.b bVar;
        long j = 0;
        if (!z) {
            bVar = null;
        } else {
            com.meizu.cloud.pushsdk.networking.okio.b bVar2 = new com.meizu.cloud.pushsdk.networking.okio.b();
            bVar = bVar2;
            cVar = bVar2;
        }
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            b bVar3 = this.l.get(i);
            c cVar2 = bVar3.a;
            j jVar = bVar3.b;
            cVar.c(h);
            cVar.b(this.i);
            cVar.c(g);
            if (cVar2 != null) {
                int a2 = cVar2.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    cVar.b(cVar2.a(i2)).c(f).b(cVar2.b(i2)).c(g);
                }
            }
            g a3 = jVar.a();
            if (a3 != null) {
                cVar.b("Content-Type: ").b(a3.toString()).c(g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                cVar.b("Content-Length: ").e(b2).c(g);
            } else if (z) {
                bVar.j();
                return -1L;
            }
            cVar.c(g);
            if (z) {
                j += b2;
            } else {
                jVar.a(cVar);
            }
            cVar.c(g);
        }
        cVar.c(h);
        cVar.b(this.i);
        cVar.c(h);
        cVar.c(g);
        if (z) {
            long a4 = j + bVar.a();
            bVar.j();
            return a4;
        }
        return j;
    }

    /* loaded from: classes3.dex */
    public static final class b {
        private final c a;
        private final j b;

        public static b a(c cVar, j jVar) {
            if (jVar == null) {
                throw new NullPointerException("body == null");
            }
            if (cVar != null && cVar.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (cVar != null && cVar.a(HTTP.CONTENT_LEN) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new b(cVar, jVar);
        }

        private b(c cVar, j jVar) {
            this.a = cVar;
            this.b = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private final ByteString a;
        private g b;
        private final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.b = h.a;
            this.c = new ArrayList();
            this.a = ByteString.encodeUtf8(str);
        }

        public a a(g gVar) {
            if (gVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!gVar.a().equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + gVar);
            }
            this.b = gVar;
            return this;
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.c.add(bVar);
            return this;
        }

        public h a() {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new h(this.a, this.b, this.c);
        }
    }
}

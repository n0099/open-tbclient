package com.meizu.cloud.pushsdk.b.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class h extends j {
    public static final g a = g.a("multipart/mixed");
    public static final g b = g.a("multipart/alternative");
    public static final g c = g.a("multipart/digest");
    public static final g d = g.a("multipart/parallel");
    public static final g e = g.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final com.meizu.cloud.pushsdk.b.g.d i;
    private final g j;
    private final g k;
    private final List<b> l;
    private long m = -1;

    /* loaded from: classes8.dex */
    public static final class a {
        private final com.meizu.cloud.pushsdk.b.g.d a;
        private g b;
        private final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.b = h.a;
            this.c = new ArrayList();
            this.a = com.meizu.cloud.pushsdk.b.g.d.a(str);
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(g gVar) {
            if (gVar == null) {
                throw new NullPointerException("type == null");
            }
            if (gVar.a().equals("multipart")) {
                this.b = gVar;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + gVar);
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

    /* loaded from: classes8.dex */
    public static final class b {
        private final c a;
        private final j b;

        private b(c cVar, j jVar) {
            this.a = cVar;
            this.b = jVar;
        }

        public static b a(c cVar, j jVar) {
            if (jVar == null) {
                throw new NullPointerException("body == null");
            }
            if (cVar == null || cVar.a("Content-Type") == null) {
                if (cVar == null || cVar.a("Content-Length") == null) {
                    return new b(cVar, jVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
    }

    h(com.meizu.cloud.pushsdk.b.g.d dVar, g gVar, List<b> list) {
        this.i = dVar;
        this.j = gVar;
        this.k = g.a(gVar + "; boundary=" + dVar.a());
        this.l = m.a(list);
    }

    private long a(com.meizu.cloud.pushsdk.b.g.b bVar, boolean z) throws IOException {
        com.meizu.cloud.pushsdk.b.g.a aVar;
        long j = 0;
        if (z) {
            com.meizu.cloud.pushsdk.b.g.a aVar2 = new com.meizu.cloud.pushsdk.b.g.a();
            aVar = aVar2;
            bVar = aVar2;
        } else {
            aVar = null;
        }
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            b bVar2 = this.l.get(i);
            c cVar = bVar2.a;
            j jVar = bVar2.b;
            bVar.c(h);
            bVar.b(this.i);
            bVar.c(g);
            if (cVar != null) {
                int a2 = cVar.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    bVar.b(cVar.a(i2)).c(f).b(cVar.b(i2)).c(g);
                }
            }
            g a3 = jVar.a();
            if (a3 != null) {
                bVar.b("Content-Type: ").b(a3.toString()).c(g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                bVar.b("Content-Length: ").e(b2).c(g);
            } else if (z) {
                aVar.j();
                return -1L;
            }
            bVar.c(g);
            if (z) {
                j += b2;
            } else {
                jVar.a(bVar);
            }
            bVar.c(g);
        }
        bVar.c(h);
        bVar.b(this.i);
        bVar.c(h);
        bVar.c(g);
        if (z) {
            long a4 = j + aVar.a();
            aVar.j();
            return a4;
        }
        return j;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.k;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.b bVar) throws IOException {
        a(bVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((com.meizu.cloud.pushsdk.b.g.b) null, true);
        this.m = a2;
        return a2;
    }
}

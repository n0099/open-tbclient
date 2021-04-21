package com.meizu.cloud.pushsdk.b.c;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class h extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final g f37904a = g.a("multipart/mixed");

    /* renamed from: b  reason: collision with root package name */
    public static final g f37905b = g.a("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final g f37906c = g.a("multipart/digest");

    /* renamed from: d  reason: collision with root package name */
    public static final g f37907d = g.a("multipart/parallel");

    /* renamed from: e  reason: collision with root package name */
    public static final g f37908e = g.a(IMAudioTransRequest.CONTENT_TYPE);

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f37909f = {58, 32};

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f37910g = {13, 10};

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f37911h = {UtilsBlink.VER_TYPE_SEPARATOR, UtilsBlink.VER_TYPE_SEPARATOR};
    public final com.meizu.cloud.pushsdk.b.g.e i;
    public final g j;
    public final g k;
    public final List<b> l;
    public long m = -1;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.b.g.e f37912a;

        /* renamed from: b  reason: collision with root package name */
        public g f37913b;

        /* renamed from: c  reason: collision with root package name */
        public final List<b> f37914c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.f37913b = h.f37904a;
            this.f37914c = new ArrayList();
            this.f37912a = com.meizu.cloud.pushsdk.b.g.e.a(str);
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(g gVar) {
            if (gVar != null) {
                if (gVar.a().equals("multipart")) {
                    this.f37913b = gVar;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + gVar);
            }
            throw new NullPointerException("type == null");
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.f37914c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public h a() {
            if (this.f37914c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new h(this.f37912a, this.f37913b, this.f37914c);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f37915a;

        /* renamed from: b  reason: collision with root package name */
        public final j f37916b;

        public b(c cVar, j jVar) {
            this.f37915a = cVar;
            this.f37916b = jVar;
        }

        public static b a(c cVar, j jVar) {
            if (jVar != null) {
                if (cVar == null || cVar.a("Content-Type") == null) {
                    if (cVar == null || cVar.a("Content-Length") == null) {
                        return new b(cVar, jVar);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            throw new NullPointerException("body == null");
        }
    }

    public h(com.meizu.cloud.pushsdk.b.g.e eVar, g gVar, List<b> list) {
        this.i = eVar;
        this.j = gVar;
        this.k = g.a(gVar + "; boundary=" + eVar.a());
        this.l = m.a(list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.meizu.cloud.pushsdk.b.g.b */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.meizu.cloud.pushsdk.b.g.b */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.meizu.cloud.pushsdk.b.g.b */
    /* JADX WARN: Multi-variable type inference failed */
    private long a(com.meizu.cloud.pushsdk.b.g.c cVar, boolean z) throws IOException {
        com.meizu.cloud.pushsdk.b.g.b bVar;
        if (z) {
            cVar = new com.meizu.cloud.pushsdk.b.g.b();
            bVar = cVar;
        } else {
            bVar = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar2 = this.l.get(i);
            c cVar2 = bVar2.f37915a;
            j jVar = bVar2.f37916b;
            cVar.c(f37911h);
            cVar.b(this.i);
            cVar.c(f37910g);
            if (cVar2 != null) {
                int a2 = cVar2.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    cVar.b(cVar2.a(i2)).c(f37909f).b(cVar2.b(i2)).c(f37910g);
                }
            }
            g a3 = jVar.a();
            if (a3 != null) {
                cVar.b(Part.CONTENT_TYPE).b(a3.toString()).c(f37910g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                cVar.b("Content-Length: ").e(b2).c(f37910g);
            } else if (z) {
                bVar.j();
                return -1L;
            }
            cVar.c(f37910g);
            if (z) {
                j += b2;
            } else {
                jVar.a(cVar);
            }
            cVar.c(f37910g);
        }
        cVar.c(f37911h);
        cVar.b(this.i);
        cVar.c(f37911h);
        cVar.c(f37910g);
        if (z) {
            long a4 = j + bVar.a();
            bVar.j();
            return a4;
        }
        return j;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.k;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((com.meizu.cloud.pushsdk.b.g.c) null, true);
        this.m = a2;
        return a2;
    }
}

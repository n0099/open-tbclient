package com.meizu.cloud.pushsdk.b.c;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes10.dex */
public final class h extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final g f74412a = g.a("multipart/mixed");

    /* renamed from: b  reason: collision with root package name */
    public static final g f74413b = g.a("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final g f74414c = g.a("multipart/digest");

    /* renamed from: d  reason: collision with root package name */
    public static final g f74415d = g.a("multipart/parallel");

    /* renamed from: e  reason: collision with root package name */
    public static final g f74416e = g.a(IMAudioTransRequest.CONTENT_TYPE);

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f74417f = {58, 32};

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f74418g = {13, 10};

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f74419h = {UtilsBlink.VER_TYPE_SEPARATOR, UtilsBlink.VER_TYPE_SEPARATOR};

    /* renamed from: i  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.g.e f74420i;

    /* renamed from: j  reason: collision with root package name */
    public final g f74421j;
    public final g k;
    public final List<b> l;
    public long m = -1;

    /* loaded from: classes10.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.meizu.cloud.pushsdk.b.g.e f74422a;

        /* renamed from: b  reason: collision with root package name */
        public g f74423b;

        /* renamed from: c  reason: collision with root package name */
        public final List<b> f74424c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.f74423b = h.f74412a;
            this.f74424c = new ArrayList();
            this.f74422a = com.meizu.cloud.pushsdk.b.g.e.a(str);
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(g gVar) {
            if (gVar != null) {
                if (gVar.a().equals("multipart")) {
                    this.f74423b = gVar;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + gVar);
            }
            throw new NullPointerException("type == null");
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.f74424c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public h a() {
            if (this.f74424c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new h(this.f74422a, this.f74423b, this.f74424c);
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f74425a;

        /* renamed from: b  reason: collision with root package name */
        public final j f74426b;

        public b(c cVar, j jVar) {
            this.f74425a = cVar;
            this.f74426b = jVar;
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
        this.f74420i = eVar;
        this.f74421j = gVar;
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
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar2 = this.l.get(i2);
            c cVar2 = bVar2.f74425a;
            j jVar = bVar2.f74426b;
            cVar.c(f74419h);
            cVar.b(this.f74420i);
            cVar.c(f74418g);
            if (cVar2 != null) {
                int a2 = cVar2.a();
                for (int i3 = 0; i3 < a2; i3++) {
                    cVar.b(cVar2.a(i3)).c(f74417f).b(cVar2.b(i3)).c(f74418g);
                }
            }
            g a3 = jVar.a();
            if (a3 != null) {
                cVar.b(Part.CONTENT_TYPE).b(a3.toString()).c(f74418g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                cVar.b("Content-Length: ").e(b2).c(f74418g);
            } else if (z) {
                bVar.j();
                return -1L;
            }
            cVar.c(f74418g);
            if (z) {
                j2 += b2;
            } else {
                jVar.a(cVar);
            }
            cVar.c(f74418g);
        }
        cVar.c(f74419h);
        cVar.b(this.f74420i);
        cVar.c(f74419h);
        cVar.c(f74418g);
        if (z) {
            long a4 = j2 + bVar.a();
            bVar.j();
            return a4;
        }
        return j2;
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
        long j2 = this.m;
        if (j2 != -1) {
            return j2;
        }
        long a2 = a((com.meizu.cloud.pushsdk.b.g.c) null, true);
        this.m = a2;
        return a2;
    }
}

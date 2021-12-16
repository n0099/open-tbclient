package com.meizu.cloud.pushsdk.b.c;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class h extends j {
    public static final g a = g.a("multipart/mixed");

    /* renamed from: b  reason: collision with root package name */
    public static final g f60859b = g.a("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final g f60860c = g.a("multipart/digest");

    /* renamed from: d  reason: collision with root package name */
    public static final g f60861d = g.a("multipart/parallel");

    /* renamed from: e  reason: collision with root package name */
    public static final g f60862e = g.a(IMAudioTransRequest.CONTENT_TYPE);

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f60863f = {58, 32};

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f60864g = {13, 10};

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f60865h = {UtilsBlink.VER_TYPE_SEPARATOR, UtilsBlink.VER_TYPE_SEPARATOR};

    /* renamed from: i  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.g.e f60866i;

    /* renamed from: j  reason: collision with root package name */
    public final g f60867j;

    /* renamed from: k  reason: collision with root package name */
    public final g f60868k;
    public final List<b> l;
    public long m = -1;

    /* loaded from: classes3.dex */
    public static final class a {
        public final com.meizu.cloud.pushsdk.b.g.e a;

        /* renamed from: b  reason: collision with root package name */
        public g f60869b;

        /* renamed from: c  reason: collision with root package name */
        public final List<b> f60870c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.f60869b = h.a;
            this.f60870c = new ArrayList();
            this.a = com.meizu.cloud.pushsdk.b.g.e.a(str);
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(g gVar) {
            if (gVar != null) {
                if (gVar.a().equals("multipart")) {
                    this.f60869b = gVar;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + gVar);
            }
            throw new NullPointerException("type == null");
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.f60870c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public h a() {
            if (this.f60870c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new h(this.a, this.f60869b, this.f60870c);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public final c a;

        /* renamed from: b  reason: collision with root package name */
        public final j f60871b;

        public b(c cVar, j jVar) {
            this.a = cVar;
            this.f60871b = jVar;
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
        this.f60866i = eVar;
        this.f60867j = gVar;
        this.f60868k = g.a(gVar + "; boundary=" + eVar.a());
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
            c cVar2 = bVar2.a;
            j jVar = bVar2.f60871b;
            cVar.c(f60865h);
            cVar.b(this.f60866i);
            cVar.c(f60864g);
            if (cVar2 != null) {
                int a2 = cVar2.a();
                for (int i3 = 0; i3 < a2; i3++) {
                    cVar.b(cVar2.a(i3)).c(f60863f).b(cVar2.b(i3)).c(f60864g);
                }
            }
            g a3 = jVar.a();
            if (a3 != null) {
                cVar.b(Part.CONTENT_TYPE).b(a3.toString()).c(f60864g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                cVar.b("Content-Length: ").e(b2).c(f60864g);
            } else if (z) {
                bVar.j();
                return -1L;
            }
            cVar.c(f60864g);
            if (z) {
                j2 += b2;
            } else {
                jVar.a(cVar);
            }
            cVar.c(f60864g);
        }
        cVar.c(f60865h);
        cVar.b(this.f60866i);
        cVar.c(f60865h);
        cVar.c(f60864g);
        if (z) {
            long a4 = j2 + bVar.a();
            bVar.j();
            return a4;
        }
        return j2;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f60868k;
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

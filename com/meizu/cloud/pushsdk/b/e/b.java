package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes10.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f74964a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f74965b;

    /* renamed from: c  reason: collision with root package name */
    public d f74966c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f74964a = jVar;
        if (aVar != null) {
            this.f74966c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f74967a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f74968b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j2) throws IOException {
                super.a(bVar, j2);
                if (this.f74968b == 0) {
                    this.f74968b = b.this.b();
                }
                this.f74967a += j2;
                if (b.this.f74966c != null) {
                    b.this.f74966c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f74967a, this.f74968b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f74964a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f74965b == null) {
            this.f74965b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f74964a.a(this.f74965b);
        this.f74965b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f74964a.b();
    }
}

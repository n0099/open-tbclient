package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes10.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f74265a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f74266b;

    /* renamed from: c  reason: collision with root package name */
    public d f74267c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f74265a = jVar;
        if (aVar != null) {
            this.f74267c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f74268a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f74269b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j2) throws IOException {
                super.a(bVar, j2);
                if (this.f74269b == 0) {
                    this.f74269b = b.this.b();
                }
                this.f74268a += j2;
                if (b.this.f74267c != null) {
                    b.this.f74267c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f74268a, this.f74269b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f74265a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f74266b == null) {
            this.f74266b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f74265a.a(this.f74266b);
        this.f74266b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f74265a.b();
    }
}

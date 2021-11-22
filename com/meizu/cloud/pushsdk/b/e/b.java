package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes2.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f68275a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f68276b;

    /* renamed from: c  reason: collision with root package name */
    public d f68277c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f68275a = jVar;
        if (aVar != null) {
            this.f68277c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f68278a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f68279b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f68279b == 0) {
                    this.f68279b = b.this.b();
                }
                this.f68278a += j;
                if (b.this.f68277c != null) {
                    b.this.f68277c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f68278a, this.f68279b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f68275a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f68276b == null) {
            this.f68276b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f68275a.a(this.f68276b);
        this.f68276b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f68275a.b();
    }
}

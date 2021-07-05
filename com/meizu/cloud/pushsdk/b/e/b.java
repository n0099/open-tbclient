package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes7.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f40220a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f40221b;

    /* renamed from: c  reason: collision with root package name */
    public d f40222c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f40220a = jVar;
        if (aVar != null) {
            this.f40222c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f40223a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f40224b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f40224b == 0) {
                    this.f40224b = b.this.b();
                }
                this.f40223a += j;
                if (b.this.f40222c != null) {
                    b.this.f40222c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f40223a, this.f40224b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f40220a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f40221b == null) {
            this.f40221b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f40220a.a(this.f40221b);
        this.f40221b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f40220a.b();
    }
}

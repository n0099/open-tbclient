package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes2.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f67362a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f67363b;

    /* renamed from: c  reason: collision with root package name */
    public d f67364c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f67362a = jVar;
        if (aVar != null) {
            this.f67364c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f67365a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f67366b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f67366b == 0) {
                    this.f67366b = b.this.b();
                }
                this.f67365a += j;
                if (b.this.f67364c != null) {
                    b.this.f67364c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f67365a, this.f67366b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f67362a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f67363b == null) {
            this.f67363b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f67362a.a(this.f67363b);
        this.f67363b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f67362a.b();
    }
}

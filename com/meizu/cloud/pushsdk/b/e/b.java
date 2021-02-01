package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes4.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    private final j f11185a;

    /* renamed from: b  reason: collision with root package name */
    private com.meizu.cloud.pushsdk.b.g.c f11186b;
    private d c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f11185a = jVar;
        if (aVar != null) {
            this.c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            long f11187a = 0;

            /* renamed from: b  reason: collision with root package name */
            long f11188b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f11188b == 0) {
                    this.f11188b = b.this.b();
                }
                this.f11187a += j;
                if (b.this.c != null) {
                    b.this.c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f11187a, this.f11188b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f11185a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f11186b == null) {
            this.f11186b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f11185a.a(this.f11186b);
        this.f11186b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f11185a.b();
    }
}

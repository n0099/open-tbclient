package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes10.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f74465a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f74466b;

    /* renamed from: c  reason: collision with root package name */
    public d f74467c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f74465a = jVar;
        if (aVar != null) {
            this.f74467c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f74468a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f74469b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j2) throws IOException {
                super.a(bVar, j2);
                if (this.f74469b == 0) {
                    this.f74469b = b.this.b();
                }
                this.f74468a += j2;
                if (b.this.f74467c != null) {
                    b.this.f74467c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f74468a, this.f74469b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f74465a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f74466b == null) {
            this.f74466b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f74465a.a(this.f74466b);
        this.f74466b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f74465a.b();
    }
}

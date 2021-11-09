package com.meizu.cloud.pushsdk.b.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final g f67270a = g.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f67271b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f67272c;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f67273a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f67274b = new ArrayList();

        public a a(String str, String str2) {
            this.f67273a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f67274b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public b a() {
            return new b(this.f67273a, this.f67274b);
        }

        public a b(String str, String str2) {
            this.f67273a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f67274b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    public b(List<String> list, List<String> list2) {
        this.f67271b = m.a(list);
        this.f67272c = m.a(list2);
    }

    private long a(com.meizu.cloud.pushsdk.b.g.c cVar, boolean z) {
        com.meizu.cloud.pushsdk.b.g.b bVar = z ? new com.meizu.cloud.pushsdk.b.g.b() : cVar.b();
        int size = this.f67271b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                bVar.b(38);
            }
            bVar.b(this.f67271b.get(i2));
            bVar.b(61);
            bVar.b(this.f67272c.get(i2));
        }
        if (z) {
            long a2 = bVar.a();
            bVar.j();
            return a2;
        }
        return 0L;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return f67270a;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() {
        return a((com.meizu.cloud.pushsdk.b.g.c) null, true);
    }
}

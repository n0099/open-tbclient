package com.meizu.cloud.pushsdk.b.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends j {
    public static final g a = g.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f60248b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f60249c;

    /* loaded from: classes2.dex */
    public static final class a {
        public final List<String> a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f60250b = new ArrayList();

        public a a(String str, String str2) {
            this.a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f60250b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public b a() {
            return new b(this.a, this.f60250b);
        }

        public a b(String str, String str2) {
            this.a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f60250b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    public b(List<String> list, List<String> list2) {
        this.f60248b = m.a(list);
        this.f60249c = m.a(list2);
    }

    private long a(com.meizu.cloud.pushsdk.b.g.c cVar, boolean z) {
        com.meizu.cloud.pushsdk.b.g.b bVar = z ? new com.meizu.cloud.pushsdk.b.g.b() : cVar.b();
        int size = this.f60248b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                bVar.b(38);
            }
            bVar.b(this.f60248b.get(i2));
            bVar.b(61);
            bVar.b(this.f60249c.get(i2));
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
        return a;
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

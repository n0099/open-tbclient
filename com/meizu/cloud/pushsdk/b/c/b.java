package com.meizu.cloud.pushsdk.b.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final g f74905a = g.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f74906b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f74907c;

    /* loaded from: classes10.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f74908a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f74909b = new ArrayList();

        public a a(String str, String str2) {
            this.f74908a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f74909b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public b a() {
            return new b(this.f74908a, this.f74909b);
        }

        public a b(String str, String str2) {
            this.f74908a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f74909b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    public b(List<String> list, List<String> list2) {
        this.f74906b = m.a(list);
        this.f74907c = m.a(list2);
    }

    private long a(com.meizu.cloud.pushsdk.b.g.c cVar, boolean z) {
        com.meizu.cloud.pushsdk.b.g.b bVar = z ? new com.meizu.cloud.pushsdk.b.g.b() : cVar.b();
        int size = this.f74906b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                bVar.b(38);
            }
            bVar.b(this.f74906b.get(i2));
            bVar.b(61);
            bVar.b(this.f74907c.get(i2));
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
        return f74905a;
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

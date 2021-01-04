package com.meizu.cloud.pushsdk.b.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    private static final g f11443a = g.a("application/x-www-form-urlencoded");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f11444b;
    private final List<String> c;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f11445a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f11446b = new ArrayList();

        public a a(String str, String str2) {
            this.f11445a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f11446b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public b a() {
            return new b(this.f11445a, this.f11446b);
        }

        public a b(String str, String str2) {
            this.f11445a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f11446b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    private b(List<String> list, List<String> list2) {
        this.f11444b = m.a(list);
        this.c = m.a(list2);
    }

    private long a(com.meizu.cloud.pushsdk.b.g.c cVar, boolean z) {
        long j = 0;
        com.meizu.cloud.pushsdk.b.g.b bVar = z ? new com.meizu.cloud.pushsdk.b.g.b() : cVar.b();
        int size = this.f11444b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bVar.b(38);
            }
            bVar.b(this.f11444b.get(i));
            bVar.b(61);
            bVar.b(this.c.get(i));
        }
        if (z) {
            j = bVar.a();
            bVar.j();
        }
        return j;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return f11443a;
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

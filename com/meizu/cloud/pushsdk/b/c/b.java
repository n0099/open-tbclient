package com.meizu.cloud.pushsdk.b.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends j {
    private static final g a = g.a("application/x-www-form-urlencoded");
    private final List<String> b;
    private final List<String> c;

    /* loaded from: classes6.dex */
    public static final class a {
        private final List<String> a = new ArrayList();
        private final List<String> b = new ArrayList();

        public a a(String str, String str2) {
            this.a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public b a() {
            return new b(this.a, this.b);
        }

        public a b(String str, String str2) {
            this.a.add(f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.b.add(f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    private b(List<String> list, List<String> list2) {
        this.b = m.a(list);
        this.c = m.a(list2);
    }

    private long a(com.meizu.cloud.pushsdk.b.g.b bVar, boolean z) {
        long j = 0;
        com.meizu.cloud.pushsdk.b.g.a aVar = z ? new com.meizu.cloud.pushsdk.b.g.a() : bVar.b();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                aVar.b(38);
            }
            aVar.b(this.b.get(i));
            aVar.b(61);
            aVar.b(this.c.get(i));
        }
        if (z) {
            j = aVar.a();
            aVar.j();
        }
        return j;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return a;
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.b bVar) throws IOException {
        a(bVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() {
        return a((com.meizu.cloud.pushsdk.b.g.b) null, true);
    }
}

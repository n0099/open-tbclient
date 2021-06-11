package d.a.l0.a.t1.c.c;

import java.util.TreeMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.o0.d.b f48440a;

    public b(String str, String str2, String str3) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("functionPagePath", str);
        treeMap.put("paymentArgs", str2);
        treeMap.put("slaveId", str3);
        this.f48440a = new d.a.l0.a.o0.d.b("beforeRequestPayment", treeMap);
    }

    public d.a.l0.a.o0.d.b a() {
        return this.f48440a;
    }
}

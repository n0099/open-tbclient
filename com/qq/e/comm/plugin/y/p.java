package com.qq.e.comm.plugin.y;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f12715a = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(int i, String str) {
        return new o(i, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(g gVar) {
        return (o) gdtadv.getobjresult(141, 1, gVar);
    }

    static JSONObject a(List<o> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                com.qq.e.comm.plugin.util.u a2 = j.a();
                a2.a("perfs", jSONArray);
                return a2.a();
            }
            jSONArray.put(new com.qq.e.comm.plugin.util.u(list.get(i2).b()).a());
            i = i2 + 1;
        }
    }
}

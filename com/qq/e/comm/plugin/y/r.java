package com.qq.e.comm.plugin.y;

import com.alibaba.fastjson.asm.Opcodes;
import java.util.concurrent.Future;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
class r {
    private static com.qq.e.comm.plugin.t.b.e a(String str, String str2) {
        return (com.qq.e.comm.plugin.t.b.e) gdtadv.getobjresult(Opcodes.FCMPL, 1, str, str2);
    }

    private static Future<com.qq.e.comm.plugin.t.b.f> a(String str, JSONObject jSONObject) {
        return (Future) gdtadv.getobjresult(150, 1, str, jSONObject);
    }

    static Future<com.qq.e.comm.plugin.t.b.f> a(JSONObject jSONObject) {
        return (Future) gdtadv.getobjresult(Opcodes.DCMPL, 1, jSONObject);
    }

    static Future<com.qq.e.comm.plugin.t.b.f> b(JSONObject jSONObject) {
        return (Future) gdtadv.getobjresult(152, 1, jSONObject);
    }
}

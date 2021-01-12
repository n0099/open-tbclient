package com.qq.e.comm.plugin.w;

import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.qq.e.comm.plugin.k.b bVar);

        void a(JSONObject jSONObject);
    }

    public static JSONObject a(JSONObject jSONObject, final long j) {
        if (j <= 0) {
            throw new Error("TimeOut shouldNot <=0 for loadAPPDetailInfoSyn method");
        }
        j d = com.qq.e.comm.plugin.util.d.d(jSONObject);
        if (!StringUtil.isEmpty(d.i()) && !StringUtil.isEmpty(d.j())) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("name", d.i());
                jSONObject2.put("iconurl", d.j());
                return jSONObject2;
            } catch (JSONException e) {
                GDTLogger.e("ExceptionWhileLoadAPPDetail", e);
            }
        }
        String optString = jSONObject.optString("productid");
        int optInt = jSONObject.optInt("producttype");
        final Exchanger exchanger = new Exchanger();
        a(optString, optInt, new a() { // from class: com.qq.e.comm.plugin.w.c.2
            @Override // com.qq.e.comm.plugin.w.c.a
            public void a(com.qq.e.comm.plugin.k.b bVar) {
                try {
                    exchanger.exchange(null, j, TimeUnit.MICROSECONDS);
                } catch (Exception e2) {
                    GDTLogger.e("ExceptionWhileLoadAPPDetail", e2);
                }
            }

            @Override // com.qq.e.comm.plugin.w.c.a
            public void a(JSONObject jSONObject3) {
                try {
                    if (jSONObject3 != null) {
                        exchanger.exchange(jSONObject3.optJSONObject("data"), j, TimeUnit.MICROSECONDS);
                    } else {
                        exchanger.exchange(null, j, TimeUnit.MICROSECONDS);
                    }
                } catch (Exception e2) {
                    GDTLogger.e("ExceptionWhileLoadAPPDetail", e2);
                }
            }
        });
        try {
            return (JSONObject) exchanger.exchange(null, j, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            GDTLogger.w("LoadAPPDetailInfoTimeOut");
            return null;
        }
    }

    public static void a(String str, int i, final a aVar) {
        if (aVar == null) {
            GDTLogger.e("Callback == null while loadAPKDetail");
            return;
        }
        String a2 = com.qq.e.comm.plugin.util.d.a(str, i);
        if (StringUtil.isEmpty(a2)) {
            aVar.a(new com.qq.e.comm.plugin.k.b(String.format("Detail URL is null for product(%d,%d)", str, Integer.valueOf(i)), 503));
            return;
        }
        com.qq.e.comm.plugin.t.b bVar = new com.qq.e.comm.plugin.t.b() { // from class: com.qq.e.comm.plugin.w.c.1
            @Override // com.qq.e.comm.plugin.t.b
            public void a(com.qq.e.comm.plugin.t.b.e eVar, com.qq.e.comm.plugin.t.b.f fVar) {
                try {
                    a.this.a(new JSONObject(fVar.d()));
                } catch (Throwable th) {
                    a.this.a(new com.qq.e.comm.plugin.k.b(th, (int) ErrorCode.OtherError.UNKNOWN_ERROR));
                }
            }

            @Override // com.qq.e.comm.plugin.t.b
            public void a(Exception exc) {
                a.this.a(new com.qq.e.comm.plugin.k.b(exc, 400));
            }
        };
        com.qq.e.comm.plugin.t.b.c cVar = new com.qq.e.comm.plugin.t.b.c(a2, e.a.GET, (byte[]) null);
        ai.a("gdt_tag_net", ai.a(cVar));
        com.qq.e.comm.plugin.t.d.a().a(cVar, c.a.High, bVar);
    }
}

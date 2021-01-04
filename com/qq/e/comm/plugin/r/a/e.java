package com.qq.e.comm.plugin.r.a;

import android.text.TextUtils;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private String f12672a;

    /* renamed from: b  reason: collision with root package name */
    private String f12673b;
    private String c;

    public e(String str, String str2, String str3) {
        this.f12672a = str;
        this.f12673b = str2;
        this.c = str3;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GDTLogger.d("report mediation: " + str);
        com.qq.e.comm.plugin.t.b.c cVar = new com.qq.e.comm.plugin.t.b.c(this.f12672a, e.a.POST, str.getBytes(com.qq.e.comm.plugin.f.a.f12289a));
        ai.a("gdt_tag_net", ai.a(cVar));
        com.qq.e.comm.plugin.t.d.a().a(cVar, c.a.High);
    }

    public void a(com.qq.e.comm.plugin.r.b.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_view_id", this.f12673b);
            jSONObject.put("pos_view_id", this.c);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("view_id", cVar.f());
            jSONObject.put("click", jSONObject2);
            a(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(List<com.qq.e.comm.plugin.r.b.c> list, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_view_id", this.f12673b);
            jSONObject.put("pos_view_id", this.c);
            JSONArray jSONArray = new JSONArray();
            for (com.qq.e.comm.plugin.r.b.c cVar : list) {
                if (cVar.q()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("view_id", cVar.f());
                    jSONObject2.put("fill", cVar.o() ? 1 : 0);
                    jSONObject2.put("duration", cVar.p() != 0 ? cVar.p() : cVar.h());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("req", jSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("view_id", str);
            jSONObject.put("victor", jSONObject3);
            a(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void b(com.qq.e.comm.plugin.r.b.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_view_id", this.f12673b);
            jSONObject.put("pos_view_id", this.c);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("view_id", cVar.f());
            jSONObject.put("imp", jSONObject2);
            a(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

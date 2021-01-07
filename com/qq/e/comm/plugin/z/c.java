package com.qq.e.comm.plugin.z;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ab.j;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.t.d;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.plugin.z.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f13037a;
    private String d = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/tempMob.c57c184b4f1591947314638.html";
    private String e = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/videoPlay.0246d5ae241596700948124.html";
    private a c = new a(ah.c(new File(ah.k(), "map")));

    /* renamed from: b  reason: collision with root package name */
    private b f13038b = new b(ah.c(new File(ah.k(), "template")));

    private c() {
    }

    public static c a() {
        if (f13037a == null) {
            synchronized (c.class) {
                try {
                    if (f13037a == null) {
                        f13037a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13037a;
    }

    private void a(String str, az.a aVar) {
        b(str);
        j.e().a(str, aVar, null);
    }

    private void a(final String str, final String str2) {
        ai.a("TemplateManager", "save template: dir = " + str + ", content = " + str2);
        s.f12889a.execute(new Runnable() { // from class: com.qq.e.comm.plugin.z.c.2
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(ah.k(), str);
                if (file.exists()) {
                    file.delete();
                }
                ah.a(file, str2);
            }
        });
    }

    private void b(String str) {
        File a2 = j.e().a(str);
        if (a2 == null || !a2.delete()) {
            return;
        }
        ai.a("TemplateManager", "本地缓存的旧文件已删除：" + str);
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.optInt("orientation", 1) == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("html");
            String optString2 = jSONObject.optString("js");
            ai.a("html=" + optString + " , js=" + optString2, (ai.a) null);
            if (!TextUtils.isEmpty(optString)) {
                c(optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                return optString;
            }
            d(optString2);
            return optString;
        }
        return null;
    }

    private void c(String str) {
        a(str, az.a.HTML);
    }

    private void d(String str) {
        a(str, az.a.JS);
    }

    private String e(String str) {
        b.a a2;
        if (TextUtils.isEmpty(str) || (a2 = this.f13038b.a(str)) == null) {
            return null;
        }
        return a2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ai.a("TemplateManager", "downloadByDefaultUrl");
        String string = GDTADManager.getInstance().getSM().getString("root_html_url");
        if (!TextUtils.isEmpty(string)) {
            this.d = string;
        }
        c(this.d);
        String string2 = GDTADManager.getInstance().getSM().getString("root_js_url");
        if (TextUtils.isEmpty(string2)) {
            string2 = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/tempMob.dca5a5e918.js";
        }
        d(string2);
        String string3 = GDTADManager.getInstance().getSM().getString("video_root_html_url");
        if (!TextUtils.isEmpty(string3)) {
            this.e = string3;
        }
        c(this.e);
        String string4 = GDTADManager.getInstance().getSM().getString("video_root_js_url");
        if (TextUtils.isEmpty(string4)) {
            string4 = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/videoPlay.2af75b9ebf.js";
        }
        d(string4);
    }

    private int f() {
        return GDTADManager.getInstance().getSM().getInteger("tpl_id_count", 10);
    }

    private List<String> f(String str) {
        return this.c.a(str);
    }

    public JSONArray a(String str) {
        List<String> f = f(str);
        int min = Math.min(f.size(), f());
        ArrayList arrayList = new ArrayList(min);
        for (int size = f.size() - 1; size >= 0 && arrayList.size() < min; size--) {
            b.a a2 = this.f13038b.a(f.get(size));
            if (a2 != null) {
                arrayList.add(a2.b());
            }
        }
        return new JSONArray((Collection) arrayList);
    }

    public JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null || !TextUtils.isEmpty(jSONObject.optString("data"))) {
            return jSONObject;
        }
        String e = e(jSONObject.optString("id"));
        if (TextUtils.isEmpty(e)) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject, new String[]{"id", "ver", "root_id", "url", "orientation"});
            jSONObject2.putOpt("data", e);
            return jSONObject2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public void a(String str, List<JSONObject> list, com.qq.e.comm.plugin.y.c cVar) {
        boolean z;
        boolean z2 = false;
        Iterator<JSONObject> it = list.iterator();
        boolean z3 = false;
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            JSONObject next = it.next();
            if (next != null) {
                boolean a2 = this.c.a(str, next.optString("id"));
                if (!z3 && a2) {
                    z3 = true;
                }
                boolean a3 = this.f13038b.a(next, cVar);
                if (!z && a3) {
                    z2 = true;
                }
            }
            z2 = z;
        }
        if (z3) {
            a("map", this.c.toString());
        }
        if (z) {
            a("template", this.f13038b.toString());
        }
    }

    public void b() {
        String string = GDTADManager.getInstance().getSM().getString("root_json_url");
        if (TextUtils.isEmpty(string)) {
            ai.a("TemplateManager", "init jsonUrl from control server isEmpty!!!");
            string = "https://qzs.qq.com/union/res/union_temp_v2/page/ANTempMob/tempMob.package.json";
        }
        d.a().a(new com.qq.e.comm.plugin.t.b.c(string, e.a.POST, (byte[]) null), c.a.High, new com.qq.e.comm.plugin.t.b() { // from class: com.qq.e.comm.plugin.z.c.1
            @Override // com.qq.e.comm.plugin.t.b
            public void a(e eVar, f fVar) {
                int e = fVar.e();
                if (e != 200) {
                    ai.b("TemplateManager", "request json fail statusCode = " + e);
                    c.this.e();
                    return;
                }
                try {
                    String d = fVar.d();
                    ai.a("TemplateManager", "onResponse: " + d);
                    JSONObject jSONObject = new JSONObject(d);
                    JSONObject optJSONObject = jSONObject.optJSONObject("tempMob");
                    c.this.d = c.this.c(optJSONObject);
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("videoPlay");
                    c.this.e = c.this.c(optJSONObject2);
                } catch (IOException | JSONException e2) {
                    e2.printStackTrace();
                    ai.b("TemplateManager", "parse data error: " + e2.getMessage());
                    c.this.e();
                }
            }

            @Override // com.qq.e.comm.plugin.t.b
            public void a(Exception exc) {
                ai.b("TemplateManager", "request json fail， errormsg = " + exc.getMessage());
                c.this.e();
            }
        });
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }
}

package d.b.c.b.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f69559d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Context f69560a;

    /* renamed from: b  reason: collision with root package name */
    public d f69561b = new d();

    /* renamed from: c  reason: collision with root package name */
    public boolean f69562c;

    public e(Context context, boolean z) {
        this.f69562c = true;
        this.f69560a = context;
        this.f69562c = z;
    }

    public void a() {
        if (this.f69562c) {
            String string = this.f69560a.getSharedPreferences("ttnet_tnc_config", 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.adnet.d.d.c("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                d c2 = c(new JSONObject(string));
                if (c2 != null) {
                    this.f69561b = c2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(c2 == null ? StringUtil.NULL_STRING : c2.toString());
                com.bytedance.sdk.adnet.d.d.c("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.adnet.d.d.c("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public void b(JSONObject jSONObject) {
        if (!this.f69562c) {
            com.bytedance.sdk.adnet.d.d.c("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        f.a().k();
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (d.b.c.b.a.i() && z && optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject3 = ((JSONObject) optJSONArray.get(i2)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    jSONObject2 = new JSONObject();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObject4 = (JSONObject) it.next();
                        Iterator<String> keys = jSONObject4.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, jSONObject4.getString(next));
                        }
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tnc_config");
            if (optJSONObject == null && jSONObject2 == null) {
                com.bytedance.sdk.adnet.d.d.b("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                optJSONObject.put("host_replace_map", jSONObject2);
            }
            d c2 = c(optJSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("handleConfigChanged, newConfig: ");
            sb.append(c2 == null ? StringUtil.NULL_STRING : c2.toString());
            com.bytedance.sdk.adnet.d.d.c("TNCConfigHandler", sb.toString());
            if (c2 == null) {
                synchronized (f69559d) {
                    this.f69560a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    d.b.c.b.e.d.b(this.f69560a, 1, "");
                }
                return;
            }
            this.f69561b = c2;
            String jSONObject5 = optJSONObject.toString();
            synchronized (f69559d) {
                this.f69560a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", jSONObject5).apply();
                d.b.c.b.e.d.b(this.f69560a, 1, jSONObject5);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.f69561b = new d();
                synchronized (f69559d) {
                    this.f69560a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    d.b.c.b.e.d.b(this.f69560a, 1, "");
                }
            } catch (Throwable th2) {
                synchronized (f69559d) {
                    this.f69560a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    d.b.c.b.e.d.b(this.f69560a, 1, "");
                    throw th2;
                }
            }
        }
    }

    public final d c(JSONObject jSONObject) {
        try {
            d dVar = new d();
            if (jSONObject.has("local_enable")) {
                dVar.f69550a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                dVar.f69551b = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                dVar.f69552c = hashMap;
            } else {
                dVar.f69552c = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            hashMap2.put(next, string2);
                        }
                    }
                }
                dVar.f69553d = hashMap2;
            } else {
                dVar.f69553d = null;
            }
            dVar.f69554e = jSONObject.optInt("req_to_cnt", dVar.f69554e);
            dVar.f69555f = jSONObject.optInt("req_to_api_cnt", dVar.f69555f);
            dVar.f69556g = jSONObject.optInt("req_to_ip_cnt", dVar.f69556g);
            dVar.f69557h = jSONObject.optInt("req_err_cnt", dVar.f69557h);
            dVar.f69558i = jSONObject.optInt("req_err_api_cnt", dVar.f69558i);
            dVar.j = jSONObject.optInt("req_err_ip_cnt", dVar.j);
            dVar.k = jSONObject.optInt("update_interval", dVar.k);
            dVar.l = jSONObject.optInt("update_random_range", dVar.l);
            dVar.m = jSONObject.optString("http_code_black", dVar.m);
            return dVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void d() {
        try {
            String a2 = d.b.c.b.e.d.a(this.f69560a, 1);
            if (TextUtils.isEmpty(a2)) {
                com.bytedance.sdk.adnet.d.d.c("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            d c2 = c(new JSONObject(a2));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            sb.append(c2 == null ? StringUtil.NULL_STRING : c2.toString());
            com.bytedance.sdk.adnet.d.d.c("TNCConfigHandler", sb.toString());
            if (c2 != null) {
                this.f69561b = c2;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.adnet.d.d.c("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public d e() {
        return this.f69561b;
    }
}

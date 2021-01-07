package com.qq.e.comm.plugin.r.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.b.g;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.plugin.util.v;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.vivo.push.PushClientConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f12668b;

    /* renamed from: a  reason: collision with root package name */
    private Context f12669a;
    private volatile com.qq.e.comm.plugin.r.b.b c;
    private long d;
    private boolean e;

    private d(Context context) {
        this.f12669a = context.getApplicationContext();
        c(c.a(context));
        if (c()) {
            a(false, true);
        }
    }

    public static d a(Context context) {
        if (f12668b == null) {
            synchronized (d.class) {
                try {
                    if (f12668b == null) {
                        f12668b = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12668b;
    }

    private String a(boolean z) {
        if (com.qq.e.comm.plugin.e.a.f12287b != null) {
            String a2 = com.qq.e.comm.plugin.e.a.f12287b.a();
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        return z ? "https://mi.ssp.qq.com/config?version=2" : "https://mi.ssp.qq.com/config";
    }

    private String b(boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", GDTADManager.getInstance().getAppStatus().getAPPID());
            jSONObject.put("sdk_ver", SDKStatus.getSDKVersion());
            jSONObject.put("sdk_st", aj.a());
            jSONObject.put("plugin_ver", String.valueOf(GDTADManager.getInstance().getPM().getPluginVersion()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("lat", v.a(this.f12669a).a());
            jSONObject2.put("lon", v.a(this.f12669a).b());
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_GEO, jSONObject2);
            jSONObject.put("app_ver_name", GDTADManager.getInstance().getAppStatus().getAPPVersion());
            jSONObject.put("device_id", o.l());
            jSONObject.put("encrypt", z2 ? 1 : 0);
            jSONObject.put("config_version", z ? "" : this.c.a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.c = new com.qq.e.comm.plugin.r.b.b(str);
    }

    private boolean c() {
        return GDTADManager.getInstance().getSM().getInteger("enableMediation", 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        s.f12889a.execute(new Runnable() { // from class: com.qq.e.comm.plugin.r.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                c.a(d.this.f12669a, str);
                d.this.e();
            }
        });
    }

    private boolean d() {
        if (SDKStatus.getSDKVersionCode() < 110) {
            return false;
        }
        return GlobalSetting.isEnableMediationTool();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!d() || this.c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("updateTime", System.currentTimeMillis());
            jSONObject.put("enableMediation", c());
            List<com.qq.e.comm.plugin.r.b.a> e = this.c.e();
            JSONArray jSONArray = new JSONArray();
            if (e != null && e.size() > 0) {
                for (com.qq.e.comm.plugin.r.b.a aVar : e) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("phyPosId", aVar.a());
                    List<com.qq.e.comm.plugin.r.b.c> f = aVar.f();
                    JSONArray jSONArray2 = new JSONArray();
                    if (f != null && f.size() > 0) {
                        for (com.qq.e.comm.plugin.r.b.c cVar : f) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", cVar.a());
                            jSONObject3.put("posId", cVar.b());
                            jSONObject3.put("ext", cVar.g());
                            jSONObject3.put(PushClientConstants.TAG_CLASS_NAME, cVar.e());
                            jSONArray2.put(jSONObject3);
                        }
                    }
                    jSONObject2.put("network", jSONArray2);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("layerConfigs", jSONArray);
            c.b(this.f12669a, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public com.qq.e.comm.plugin.r.b.a a(String str) {
        List<com.qq.e.comm.plugin.r.b.a> e;
        if (!TextUtils.isEmpty(str) && (e = this.c.e()) != null && e.size() > 0) {
            for (com.qq.e.comm.plugin.r.b.a aVar : e) {
                if (TextUtils.equals(str, aVar.a())) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public String a() {
        String c;
        return (this.c == null || (c = this.c.c()) == null) ? "" : c;
    }

    public void a(boolean z, boolean z2) {
        synchronized (this) {
            if (this.e) {
                return;
            }
            if (SystemClock.elapsedRealtime() - this.d > this.c.b() * 1000 || z) {
                this.e = true;
                com.qq.e.comm.plugin.t.b bVar = new com.qq.e.comm.plugin.t.b() { // from class: com.qq.e.comm.plugin.r.a.d.1
                    @Override // com.qq.e.comm.plugin.t.b
                    public void a(com.qq.e.comm.plugin.t.b.e eVar, f fVar) {
                        try {
                            int e = fVar.e();
                            if (e == 200) {
                                String d = fVar.d();
                                if (!TextUtils.isEmpty(d)) {
                                    try {
                                        int i = new JSONObject(d).getInt("ret_code");
                                        GDTLogger.d("Mediation config fetch config: " + d);
                                        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
                                        dVar.a("ret_code", Integer.valueOf(i));
                                        u.a(70012, 0, null, dVar);
                                        if (i == 10000) {
                                            d.this.c(d);
                                            d.this.d(d);
                                        }
                                        d.this.d = SystemClock.elapsedRealtime();
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                    d.this.e = false;
                                    return;
                                }
                            }
                            if (e != 200) {
                                u.a(70022, 0, null);
                            } else {
                                u.a(70032, 0, null);
                            }
                            d.this.e = false;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            d.this.e = false;
                        }
                    }

                    @Override // com.qq.e.comm.plugin.t.b
                    public void a(Exception exc) {
                        d.this.e = false;
                        exc.printStackTrace();
                    }
                };
                com.qq.e.comm.plugin.t.b.e cVar = !z2 ? new com.qq.e.comm.plugin.t.b.c(a(false), e.a.POST, b(z, false).getBytes(com.qq.e.comm.plugin.f.a.f12290a)) : new g(a(true), b(z, true).getBytes(com.qq.e.comm.plugin.f.a.f12290a));
                ai.a("gdt_tag_net", ai.a(cVar));
                com.qq.e.comm.plugin.t.d.a().a(cVar, c.a.High, bVar);
            }
        }
    }

    public String b() {
        String d;
        return (this.c == null || (d = this.c.d()) == null) ? "" : d;
    }

    public boolean b(String str) {
        return SDKStatus.getSDKVersionCode() >= 40 && c() && this.c != null && a(str) != null;
    }
}

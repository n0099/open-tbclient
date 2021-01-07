package com.qq.e.comm.plugin.splash;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f12814a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12815b;
    private final m c;
    private final String d;
    private final a e;
    private final com.qq.e.comm.plugin.s.f f;
    private final com.qq.e.comm.plugin.ad.l g;
    private final com.qq.e.comm.plugin.y.c h;
    private LoadAdParams j;
    private volatile List<com.qq.e.comm.plugin.s.f> i = null;
    private volatile boolean k = false;
    private boolean l = false;
    private boolean m = false;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i);

        void a(com.qq.e.comm.plugin.s.f fVar, com.qq.e.comm.plugin.s.f fVar2);
    }

    public h(String str, String str2, m mVar, String str3, com.qq.e.comm.plugin.ad.l lVar, a aVar, com.qq.e.comm.plugin.y.c cVar) {
        this.f12814a = str;
        this.f12815b = str2;
        this.c = mVar;
        this.d = str3;
        this.g = lVar;
        this.e = aVar;
        this.f = new com.qq.e.comm.plugin.s.f(str, str2, str3, com.qq.e.comm.plugin.ad.e.SPLASH);
        this.h = cVar;
    }

    private void a(int i, int i2) {
        if (this.m) {
            return;
        }
        this.e.a(i);
        k.a(i2, this.h, (com.qq.e.comm.plugin.k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        com.qq.e.comm.plugin.s.f fVar;
        this.l = true;
        int optInt = jSONObject.optInt(Constants.KEYS.RET);
        if (optInt != 0) {
            a(optInt, optInt);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            a(501, 5004);
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.f12815b);
        if (optJSONObject2 == null) {
            a(501, 5004);
            return;
        }
        int optInt2 = optJSONObject2.optInt(Constants.KEYS.RET);
        if (optInt2 != 0) {
            a(optInt2, optInt2);
            return;
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cfg");
        if (optJSONObject3 != null) {
            optJSONObject3.optJSONObject("playcfg");
        }
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            a(501, 5025);
            return;
        }
        List<JSONObject> a2 = com.qq.e.comm.plugin.util.b.a(optJSONArray, this.c, this.d);
        if (a2.size() > 0) {
            jSONObject2 = a2.get(0);
            this.f.g(jSONObject2);
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 == null) {
            a(501, 5014);
            return;
        }
        this.h.b(this.f.m()).c(this.f.H());
        if (this.f.e()) {
            l.a(this.f12815b);
        }
        if (this.f.d() && this.f.e()) {
            this.e.a(501);
            u.a(1010025, 0, this.h);
            af.a(this.f.q());
            return;
        }
        if (!TextUtils.isEmpty(this.f.f()) && this.i != null && this.i.size() > 0) {
            Iterator<com.qq.e.comm.plugin.s.f> it = this.i.iterator();
            while (it.hasNext()) {
                fVar = it.next();
                if (this.f.f().equals(fVar.f())) {
                    break;
                }
            }
        }
        fVar = null;
        if (this.m) {
            return;
        }
        this.e.a(this.f, fVar);
        k.a(0, this.h, (com.qq.e.comm.plugin.k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        if (this.i != null && this.i.size() > 0) {
            for (com.qq.e.comm.plugin.s.f fVar : this.i) {
                if (com.qq.e.comm.plugin.splash.a.b.a(fVar)) {
                    GDTLogger.d("本地成功获取第一刷订单号码信息");
                    this.k = true;
                    this.e.a(fVar, fVar);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qq.e.comm.plugin.ad.b f() {
        com.qq.e.comm.plugin.ad.b bVar = new com.qq.e.comm.plugin.ad.b();
        bVar.a(this.f12815b);
        bVar.c(1);
        int integer = GDTADManager.getInstance().getSM().getInteger("splashReqAdCount", 1);
        GDTLogger.d("splashReqAdCount is " + integer);
        bVar.d(integer);
        bVar.e(2);
        bVar.h(com.qq.e.comm.plugin.ad.e.SPLASH.b());
        bVar.a(this.g);
        com.qq.e.comm.plugin.ad.d a2 = com.qq.e.comm.plugin.ad.c.a(com.qq.e.comm.plugin.ad.e.SPLASH, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
        bVar.f(a2.a());
        bVar.g(a2.b());
        bVar.b(true);
        bVar.n(l.b(this.f12815b));
        if (this.j != null) {
            bVar.f(this.j.getUin());
            bVar.e(this.j.getLoginOpenid());
            bVar.g(this.j.getLoginAppId());
        }
        if (this.i != null && this.i.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (com.qq.e.comm.plugin.s.f fVar : this.i) {
                List<com.qq.e.comm.plugin.s.h> j = fVar.j();
                if (j != null && j.size() > 0) {
                    for (com.qq.e.comm.plugin.s.h hVar : j) {
                        List<Integer> b2 = hVar.b();
                        if (b2 != null && b2.size() > 0) {
                            for (Integer num : b2) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put(LegoListActivityConfig.AD_ID, fVar.m());
                                    jSONObject2.put(IXAdRequestInfo.CELL_ID, fVar.a());
                                    jSONObject2.put("uoid", fVar.f());
                                    jSONObject2.put("is_empty", fVar.e() ? 1 : 0);
                                    jSONObject2.put("is_contract", fVar.c() ? 1 : 0);
                                    jSONObject.put(num.toString(), jSONObject2);
                                } catch (JSONException e) {
                                }
                            }
                        }
                    }
                }
            }
            bVar.b(jSONObject);
        }
        return bVar;
    }

    public void a() {
        this.l = false;
        s.f12889a.submit(new Runnable() { // from class: com.qq.e.comm.plugin.splash.h.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h.this.i = com.qq.e.comm.plugin.u.b.a().b(h.this.f12814a, h.this.f12815b, h.this.d, com.qq.e.comm.plugin.ad.e.SPLASH);
                    if (com.qq.e.comm.plugin.splash.a.b.c() || !h.this.e()) {
                        h.this.k = false;
                        com.qq.e.comm.plugin.w.b bVar = new com.qq.e.comm.plugin.w.b(h.this.d, com.qq.e.comm.plugin.ad.e.SPLASH, h.this.f12815b);
                        final long currentTimeMillis = System.currentTimeMillis();
                        com.qq.e.comm.plugin.w.e.a(h.this.f(), bVar, new e.a() { // from class: com.qq.e.comm.plugin.splash.h.1.1
                            @Override // com.qq.e.comm.plugin.w.e.a
                            public void a(com.qq.e.comm.plugin.k.a aVar) {
                                if (h.this.m) {
                                    GDTLogger.d("LoadGDTSplashADFail but timeout");
                                    return;
                                }
                                ai.a("LoadGDTSplashADFail", aVar);
                                int a2 = aVar.a();
                                if (a2 == 5001) {
                                    k.a(a2, h.this.h, aVar);
                                } else {
                                    k.a(a2, h.this.h, (Exception) aVar);
                                }
                                h.this.e.a(a2);
                            }

                            @Override // com.qq.e.comm.plugin.w.e.a
                            public void a(JSONObject jSONObject) {
                                com.qq.e.comm.plugin.y.g b2 = new com.qq.e.comm.plugin.y.g(CmdConfigCustom.CMD_DEBUGLOG_SPECIFIED).b(System.currentTimeMillis() - currentTimeMillis);
                                b2.a(h.this.h);
                                u.a(b2);
                                if (h.this.m) {
                                    GDTLogger.d("SplashOnADLoadSuccess but timeout");
                                    return;
                                }
                                GDTLogger.d("SplashOnADLoadSuccess");
                                ai.a("gdt_tag_net", "LoadGDTSplashADResponse: ", jSONObject);
                                k.a(0, h.this.h, (Exception) null);
                                h.this.a(jSONObject);
                            }
                        });
                    }
                } catch (Exception e) {
                    GDTLogger.d("Error: Exception occurred when fetching ad");
                    h.this.e.a(6000);
                    k.a(6000, h.this.h, e);
                }
            }
        });
    }

    public void a(LoadAdParams loadAdParams) {
        this.j = loadAdParams;
    }

    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.l;
    }

    public void d() {
        this.m = true;
    }
}
